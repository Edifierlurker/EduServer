package com.pinke.uni.lottery.action;

import com.pinke.uni.lottery.BallUtil;
import com.pinke.uni.lottery.OrderUtil;
import com.pinke.uni.lottery.ParamsUtil;
import com.pinke.uni.lottery.common.GameConstants;
import com.pinke.uni.lottery.common.GameErrors;
import com.pinke.uni.lottery.common.OrderidGenerator;
import com.pinke.uni.lottery.http.HttpClient;
import com.pinke.uni.lottery.http.PostParameter;
import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.lottery.ls.ILotteryOrderRecordLS;
import com.pinke.uni.lottery.ls.ILotteryPrintRecordLS;
import com.pinke.uni.lottery.model.BallTicket;
import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.pinke.uni.mobile.protal.common.CommonConstants;
import com.pinke.uni.mobile.protal.common.model.LoginUserInfo;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-1-4.
 */
public class PayAction extends BaseServiceHandle {
    private static Log log = SSBBus.getLog(PayAction.class);
    private ILotteryOrderRecordLS lotteryOrderRecordLS = (ILotteryOrderRecordLS) SSBBus.findFacadeService("lotteryOrderRecordLS");
    private ILotteryPrintRecordLS lotteryPrintRecordLS = (ILotteryPrintRecordLS) SSBBus.findFacadeService("lotteryPrintRecordLS");


    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String lottery = request.getParameter("lottery");
        String issue = request.getParameter("issue");
        if (checkData(request)) {
            List<BallTicket> list = (List<BallTicket>) session.getAttribute("BALL_LIST");
            LoginUserInfo userInfo = (LoginUserInfo) session.getAttribute(CommonConstants.PAGE_LOGIN_USER);
            LotteryOrderRecord lotteryOrderRecord = getLotteryOrderRecord(lottery, issue, list, userInfo);

            String prePayJsonResult = prePay(lotteryOrderRecord);
            JSONObject obj = JSONObject.fromObject(prePayJsonResult);
            Integer status = obj.getInt("status");
            String payseqid = obj.getString("orderid");

            lotteryOrderRecord.setPayfee(status == 0 ? lotteryOrderRecord.getPrice() : 0);
            lotteryOrderRecord.setStatus(status == 0 ? GameConstants.ORDER_STATUS.TICKETS_SUCCESS : GameConstants.ORDER_STATUS.TICKETS_FAIL);
            lotteryOrderRecord.setPayseqid(payseqid);

            try {
                String returncode = lotteryOrderRecordLS.insertLotteryOrderRecord(lotteryOrderRecord);
                if (CommonErrorcode.COMMON_SUCCESS.equals(returncode)) {
                    LotteryOrderRecord realOrder = lotteryOrderRecordLS.getLotteryOrderRecordByOrderid(lotteryOrderRecord.getOrderid());
                    String results = printBallsReq(realOrder, list);
                    OrderUtil.getOrderPrintStatus(results);
                    result.set("{\"result\":0,\"message\":" + results + "}");
                } else {
                    log.error("generate pay order fail : " + lotteryOrderRecord.toString());
                    result.set("{\"result\":-1}");
                }
            } catch (DomainServiceException e) {
                e.printStackTrace();
                result.set("{\"result\":-2}");
            }
        } else {
            result.set("{\"result\":-3}");
        }
        clearRequestSessionData(request);
        return this;
    }

    private LotteryOrderRecord getLotteryOrderRecord(String lottery, String issue, List<BallTicket> list, LoginUserInfo userInfo) {
        LotteryOrderRecord lotteryOrderRecord = OrderUtil.initOrder();
        String orderid = OrderidGenerator.generateLotteryOrderid(GameConstants.LOTTERY_CODE.get(lottery));
        int count = BallUtil.getSumCount(list);
        String paytime = lotteryOrderRecord.getOrdertime();

        lotteryOrderRecord.setLcode(BallUtil.formatBallListToPrintBallString(list));
        lotteryOrderRecord.setLcount(count);
        lotteryOrderRecord.setLissue(issue);
        lotteryOrderRecord.setLtype(lottery);
        lotteryOrderRecord.setPrice(200l * count);
        lotteryOrderRecord.setUserindex(userInfo.getUserindex());
        lotteryOrderRecord.setUseraccount("Kate");//todo
        lotteryOrderRecord.setUsername(userInfo.getUsername());

        lotteryOrderRecord.setOrderid(orderid);
        lotteryOrderRecord.setOrdertime(paytime);
        lotteryOrderRecord.setStatus(GameConstants.ORDER_STATUS.TICKETS_WAIT);
        return lotteryOrderRecord;
    }

    private boolean checkData(HttpServletRequest request) {
        String lottery = request.getParameter("lottery");
        String enballlist = request.getParameter("balllist");
        String issue = request.getParameter("issue");
        String checkCode = request.getParameter("checkCode");
        String securepara = request.getParameter("securepara");
        HttpSession session = request.getSession();
        Object money = session.getAttribute("PAY_MONEY");
        String balllist = "";
        if (StringUtils.isEmpty(lottery) || StringUtils.isEmpty(enballlist) || money == null || StringUtils.isEmpty(issue) || StringUtils.isEmpty(checkCode) || StringUtils.isEmpty(securepara)) {
            clearRequestSessionData(request);
            request.setAttribute("result", GameErrors.LOTTERY_ERROR);
        } else {
            try {
                balllist = URLDecoder.decode(enballlist, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String secure = ParamsUtil.MD5(checkCode + "-" + lottery + "-" + balllist + "-" + money + "-" + ParamsUtil.getPartnerKey());
            log.info("generate pay secure param is : " + secure + " and transfer secure param is : " + securepara + ".");
            if (secure.equals(securepara)) {
                return true;
            }
        }
        return false;
    }

    private void clearRequestSessionData(HttpServletRequest request) {
        request.getSession().removeAttribute("PAY_MONEY");
        request.getSession().removeAttribute("BALL_LIST");
    }

    private String prePay(LotteryOrderRecord lotteryOrderRecord) {
        String[] hmaccontent = {"useraccount", "cporderid", "appid", "apppackagename", "channelid", "time", "payfee", "rtnurl"};

        Map<String, String> map = new HashMap<String, String>();
        map.put("useraccount", lotteryOrderRecord.getUseraccount());
        map.put("cporderid", lotteryOrderRecord.getOrderid());
        map.put("appid", OrderUtil.getCpAppid());
        map.put("apppackagename", "");
        map.put("channelid", OrderUtil.getCpChannelid());
        map.put("time", lotteryOrderRecord.getPaytime());
        map.put("payfee", lotteryOrderRecord.getPrice() + "");
        map.put("rtnurl", OrderUtil.getCpNotifyURL());
        String hmac = OrderUtil.paramToHMACString(hmaccontent, map);

        return OrderUtil.prePay(GameConstants.LOTTERY.get(lotteryOrderRecord.getLtype()), hmac);
    }

    private String printBallsReq(LotteryOrderRecord lotteryOrderRecord, List<BallTicket> list) {
        if (lotteryOrderRecord == null) return "-1";
        List<LotteryPrintRecord> lotteryPrintRecordList = new ArrayList<LotteryPrintRecord>();
        String ltype = lotteryOrderRecord.getLtype();
        if (GameConstants.LOTTERY_TYPE.SSQ.equals(ltype)) {
            String[] strings = GameConstants.LOTTERY_GAME.get(ltype);
            for (String str : strings) {
                String ballcode = BallUtil.formatSingleIssueBallListToPrintBallString(list, str);
                if (StringUtils.isEmpty(ballcode)) continue;
                LotteryPrintRecord printRecord = OrderUtil.initPrint(lotteryOrderRecord);
                printRecord.setLcode(ballcode);
                printRecord.setGtype(str);
                printRecord.setLcount(BallUtil.getSumCount(BallUtil.getBallTicketListWithGameType(list, str)));
                lotteryPrintRecordList.add(printRecord);
            }
        }
        String[] results = sendPrintRequests(lotteryPrintRecordList);
        return results == null ? "" : JSONArray.fromObject(results).toString();
    }

    private String[] sendPrintRequests(List<LotteryPrintRecord> lotteryPrintRecordList) {
        HttpClient client = new HttpClient(150, 5000, 5000, 1024 * 1024);
        String[] rs = new String[lotteryPrintRecordList.size()];
        int i = 0;
        for (LotteryPrintRecord printRecord : lotteryPrintRecordList) {
            Map<String,String> map = new HashMap<String,String>();
            map.put("game", printRecord.getGtype());
            map.put("orderId", printRecord.getPrintid());
            map.put("money", 2 * printRecord.getLcount()+"");
            map.put("issue", printRecord.getLissue());
            map.put("content", printRecord.getLcode());
            PostParameter[] postParameters = ParamsUtil.mapToPostParameter(map);
            try {
                String printResult = null;
                try {
                    printResult = client.post(this.getPageService().getPage(), postParameters, SnsConstants.POST_KEY_VALUE);
                } catch (Exception e) {
                    System.out.print("--------------------------------");
                }
                String resultcode = null;
                if (StringUtils.isNotEmpty(printResult)) {
                    JSONObject object = JSONObject.fromObject(printResult);
                    resultcode = object.get("code").toString();
                } else {
                    resultcode = GameErrors.LOTTERY_ERROR + "";
                }
                if (Integer.valueOf(resultcode).equals(GameErrors.SUCCESS)) {
                    printRecord.setPrintstatus(GameConstants.PRINT_STATUS.WAIT);
                    printRecord.setStatus(1);
                    printRecord.setReqtime(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss"));
                } else {
                    printRecord.setPrintstatus(GameConstants.PRINT_STATUS.WAIT);
                    printRecord.setStatus(0);
                    printRecord.setReqtime(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss"));
                }
                String rslt = lotteryPrintRecordLS.insertLotteryPrintRecord(printRecord);
                rs[i] = rslt.equals(CommonErrorcode.COMMON_SUCCESS) ? "1" : "0";
            } catch (Exception e) {
                e.printStackTrace();
                rs[i] = "-1";
            }
            i++;
        }
        return rs;
    }
}
