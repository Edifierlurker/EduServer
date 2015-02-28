package com.pinke.uni.lottery.receiver;

import com.pinke.uni.lottery.OrderUtil;
import com.pinke.uni.lottery.ParamsUtil;
import com.pinke.uni.lottery.common.GameConstants;
import com.pinke.uni.lottery.common.GameErrors;
import com.pinke.uni.lottery.ls.ILotteryOrderRecordLS;
import com.pinke.uni.lottery.ls.ILotteryPrintRecordLS;
import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 投注结果通知
 */
public class BetResultReceiver extends BaseServiceHandle {
    private static Log log = SSBBus.getLog(BetResultReceiver.class);
    private ILotteryOrderRecordLS lotteryOrderRecordLS = (ILotteryOrderRecordLS) SSBBus.findFacadeService("lotteryOrderRecordLS");
    private ILotteryPrintRecordLS lotteryPrintRecordLS = (ILotteryPrintRecordLS) SSBBus.findFacadeService("lotteryPrintRecordLS");

    private static final String[] PARAMS = {"orderId", "status", "success", "message", "t"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> requireMap = getRequireParamFromRequestMap(PARAMS, request);
        String sign = request.getParameter("sign");
        String timestamp = request.getParameter("t");
        String partner = request.getParameter("partner");
        if (timestamp == null || sign == null || partner == null) {
            log.error("betResult param error : t,sign,partner " + timestamp + "," + sign + "," + partner);
            result.set(GameErrors.INFO_ERROR + "");
        } else {
            if (ParamsUtil.verifySign(sign, requireMap)) {
                String status = requireMap.get("status");
                String orderId = requireMap.get("orderId");
                try {
                    LotteryPrintRecord lotteryPrintRecord = lotteryPrintRecordLS.getLotteryPrintRecordByPrintid(orderId);
                    if (lotteryPrintRecord != null) {
                        try {
                            Long orderindex = lotteryPrintRecord.getOrderindex();
                            LotteryOrderRecord orderRecord = new LotteryOrderRecord();
                            orderRecord.setOrderindex(orderindex);
                            orderRecord = lotteryOrderRecordLS.getLotteryOrderRecord(orderRecord);
                            if (orderRecord != null) {
                                LotteryPrintRecord updateRecord = new LotteryPrintRecord();
                                updateRecord.setPrintindex(lotteryPrintRecord.getPrintindex());
                                if ((GameConstants.PRINT_STATUS.SUCCESS + "").equals(status)) {
                                    updateRecord.setPrintstatus(GameConstants.PRINT_STATUS.SUCCESS);
                                    updateRecord.setPrintresult(lotteryPrintRecord.getLcode());
                                    updateRecord.setPrintfee(200l * lotteryPrintRecord.getLcount());
                                } else if ((GameConstants.PRINT_STATUS.PART_SUCCESS + "").equals(status)) {
                                    String successLots = requireMap.get("success");
                                    updateRecord.setPrintstatus(GameConstants.PRINT_STATUS.PART_SUCCESS);
                                    updateRecord.setPrintresult(successLots);
                                    updateRecord.setPrintfee(200l * successLots.split("#").length);
                                } else if ((GameConstants.PRINT_STATUS.FAIL + "").equals(status)) {
                                    String message = requireMap.get("message");
                                    updateRecord.setPrintstatus(GameConstants.PRINT_STATUS.FAIL);
                                    updateRecord.setPrintresult(message);
                                    updateRecord.setPrintfee(0l);
                                }
                                updateRecord.setPrinttime(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss"));
                                lotteryPrintRecordLS.updateLotteryPrintRecord(updateRecord);
                                String orderresultcode = checkAndDoUpdateOrderInfo(orderRecord);
                                if (!"-1".equals(orderresultcode)) {
                                    if ("1".equals(orderresultcode)) {
                                        String rslt = prePayConfirm(orderindex);
                                        JSONObject object = JSONObject.fromObject(rslt);
                                        Integer code = object.getInt("result");
                                        String cporderid = object.getString("cporderid");
                                        String orderid = object.getString("orderid");
                                        LotteryOrderRecord updateOrderRecord = new LotteryOrderRecord();
                                        updateOrderRecord.setOrderindex(orderindex);
                                        updateOrderRecord.setOuterorderid(orderid);
                                        if (code == 0) {
                                            updateOrderRecord.setStatus(GameConstants.ORDER_STATUS.TICKETS_CONFIRM_SUCCESS);
                                        } else {
                                            if (cporderid != null) {
                                                updateOrderRecord.setStatus(GameConstants.ORDER_STATUS.TICKETS_CONFIRM_FAIL);
                                            }
                                        }
                                        lotteryOrderRecordLS.updateLotteryOrderRecord(updateOrderRecord);
                                    }
                                    result.set("{\"code\":" + GameErrors.SUCCESS + "}");
                                    return this;
                                } else {
                                    log.error("printid : " + requireMap.get("orderId") + ",orderindex : " + orderindex + "update order record fail !");
                                }
                            } else {
                                log.error("printid : " + requireMap.get("orderId") + ",there are no order records !");
                            }
                        } catch (DomainServiceException e) {
                            log.error("printid : " + requireMap.get("orderId") + ",update  print record fail !");
                            e.printStackTrace();
                        }
                    } else {
                        log.error("printid : " + requireMap.get("orderId") + ",there are no print records !");
                    }
                } catch (DomainServiceException e) {
                    e.printStackTrace();
                }
                result.set("{\"code\":" + GameErrors.SYSTEM_ERROR + "}");
            } else {
                log.error("orderid : " + requireMap.get("orderId") + ",bet result sign error !");
                result.set("{\"code\":" + GameErrors.SIGN_ERROR + "}");
            }
        }
        return this;
    }

    private String checkAndDoUpdateOrderInfo(LotteryOrderRecord orderRecord) {
        Long orderindex = orderRecord.getOrderindex();
        List<LotteryPrintRecord> list = fetchSingleOrderPrintRecords(orderindex);
        Map checkedResult = checkOrderPrintOverOrNot(list);
        Integer code = (Integer) checkedResult.get("code");
        if (code == 1) {
            LotteryOrderRecord orderPrintOverRecord = new LotteryOrderRecord();
            orderPrintOverRecord.setOrderindex(orderindex);
            orderPrintOverRecord.setPrintstatus(assemblePrintStatus((Integer[]) checkedResult.get("status")));
            orderPrintOverRecord.setPrintresult(assemblePrintResults((String[]) checkedResult.get("results")));
            orderPrintOverRecord.setPrintfee(assemblePrintFees((Long[]) checkedResult.get("printfees")));
            try {
                String resultcode = lotteryOrderRecordLS.updateLotteryOrderRecord(orderPrintOverRecord);
                if (!CommonErrorcode.COMMON_SUCCESS.equals(resultcode)) {
                    return "-1";
                } else {
                    return "1";
                }
            } catch (DomainServiceException e) {
                e.printStackTrace();
                return "-1";
            }
        }
        return "0";
    }

    public Map checkOrderPrintOverOrNot(List<LotteryPrintRecord> list) {
        Map resultMap = new HashMap();
        int len = list.size();
        Integer[] printstatus = new Integer[len];
        String[] printresults = new String[len];
        Long[] printfees = new Long[len];
        int i = 0;
        for (LotteryPrintRecord printRecord : list) {
            if (GameConstants.PRINT_STATUS.WAIT == printRecord.getPrintstatus()) {
                resultMap.put("code", 0);
                return resultMap;
            }
            printstatus[i] = printRecord.getPrintstatus();
            printresults[i] = printRecord.getPrintresult();
            printfees[i] = printRecord.getPrintfee();
            i++;
        }
        resultMap.put("code", 1);
        resultMap.put("status", printstatus);
        resultMap.put("results", printresults);
        resultMap.put("printfees", printfees);
        return resultMap;
    }

    private Integer assemblePrintStatus(Integer[] integers) {
        Arrays.sort(integers);
        Integer status = GameConstants.PRINT_STATUS.FAIL;
        for (Integer st : integers) {
            if (st == GameConstants.PRINT_STATUS.SUCCESS || st == GameConstants.PRINT_STATUS.PART_SUCCESS) {
                status = st;
            } else if (status != GameConstants.PRINT_STATUS.FAIL) {
                status = GameConstants.PRINT_STATUS.PART_SUCCESS;
            }
        }
        return status;
    }

    private Long assemblePrintFees(Long[] longs) {
        Long l = 0l;
        for (Long st : longs) {
            l += st;
        }
        return l;
    }

    private String assemblePrintResults(String[] results) {
        StringBuilder rslt = new StringBuilder();
        int max = results.length - 1;
        for (int i = 0; i <= max; i++) {
            rslt.append(results[i]);
            if (i == max)
                return rslt.toString();
            rslt.append("#");
        }
        return rslt.toString();
    }

    private List<LotteryPrintRecord> fetchSingleOrderPrintRecords(Long orderindex) {
        LotteryPrintRecord condition = new LotteryPrintRecord();
        condition.setOrderindex(orderindex);
        try {
            return lotteryPrintRecordLS.getLotteryPrintRecordByCond(condition);
        } catch (DomainServiceException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String prePayConfirm(Long orderindex) {
        log.info("prePayConfirm begin!");
        String[] hmaccontent = {"orderid", "status", "payfee"};
        String hmac = null;
        try {
            LotteryOrderRecord lotteryOrderRecord = new LotteryOrderRecord();
            lotteryOrderRecord.setOrderindex(orderindex);
            lotteryOrderRecord = lotteryOrderRecordLS.getLotteryOrderRecord(lotteryOrderRecord);
            Map<String,String> map = new HashMap<String,String>();
            map.put("orderid", lotteryOrderRecord.getOuterorderid());
            map.put("status", lotteryOrderRecord.getPrintfee().equals(lotteryOrderRecord.getPayfee()) ? "0" : "1");
            map.put("payfee", lotteryOrderRecord.getPrintfee() + "");
            hmac = OrderUtil.paramToHMACString(hmaccontent, map);

        } catch (DomainServiceException e) {
            e.printStackTrace();
        }
        return OrderUtil.prePayConfirm(hmac);
    }
}
