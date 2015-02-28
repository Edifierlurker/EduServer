package com.pinke.uni.lottery;

import com.pinke.uni.lottery.common.OrderidGenerator;
import com.pinke.uni.lottery.http.HttpClient;
import com.pinke.uni.lottery.http.PostParameter;
import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.pinke.uni.mobile.protal.util.CryptUtil;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 15-1-13.
 */
public class OrderUtil {

    private OrderUtil() {

    }

    public static LotteryOrderRecord initOrder() {
        LotteryOrderRecord lotteryOrderRecord = new LotteryOrderRecord();
        lotteryOrderRecord.setStatus(0);
        lotteryOrderRecord.setOrdertime(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss"));
        lotteryOrderRecord.setPrintstatus(0);
        return lotteryOrderRecord;
    }

    public static LotteryPrintRecord initPrint(LotteryOrderRecord lotteryOrderRecord) {
        LotteryPrintRecord lotteryPrintRecord = new LotteryPrintRecord();
        lotteryPrintRecord.setPrintstatus(0);
        lotteryPrintRecord.setPrintid(OrderidGenerator.generateLotteryPrintid());
        lotteryPrintRecord.setOrderid(lotteryOrderRecord.getOrderid());
        lotteryPrintRecord.setOrderindex(lotteryOrderRecord.getOrderindex());
        lotteryPrintRecord.setLtype(lotteryOrderRecord.getLtype());
        lotteryPrintRecord.setLissue(lotteryOrderRecord.getLissue());
        return lotteryPrintRecord;
    }

    public static String[] getOrderPrintStatus(String results){
        if(StringUtils.isEmpty(results)) return new String[0];
        JSONArray arr = JSONArray.fromObject(results);
        Iterator<String> it = arr.iterator();
        while(it.hasNext()){
            String result = it.next();
            if(result != null){}
        }
        return null;
    }
    public static String paramToHMACString(String[] params ,Map<String,String> paramMap){
        return CryptUtil.encryptBy3DesAndBase64(ParamsUtil.paramMapToJSONString(params,paramMap), getCpPayKey());
    }

    public static String prePay(String subject,String hmac){
        HttpClient client = new HttpClient(150, 5000, 5000, 1024 * 1024);
        Map<String,String> map = new HashMap<String, String>();
        map.put("cpid", getCpid());
        map.put("version", getCpPayVersion());
        map.put("subject",subject);
        map.put("hmac",hmac);
        PostParameter[] postParameters = ParamsUtil.mapToPostParameter(map);
        String rs = null;
        try {
            rs = client.post(getPrePayURL(), postParameters, SnsConstants.POST_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }


    public static String prePayConfirm(String hmac){
        HttpClient client = new HttpClient(150, 5000, 5000, 1024 * 1024);
        Map<String,String> map = new HashMap<String, String>();
        map.put("cpid", getCpid());
        map.put("hmac",hmac);
        PostParameter[] postParameters = ParamsUtil.mapToPostParameter(map);
        String rs = null;
        try {
            rs = client.post(getPrePayConfirmURL(), postParameters, SnsConstants.POST_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String getPayURL() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.pay_url");
    }

    public static String getPrePayConfirmURL() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.prepayconfirm_url");
    }

    public static String getPrePayURL() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.prepay_url");
    }

    public static String getCpPayKey() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.pkey");
    }

    public static String getCpid() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.cpid");
    }

    public static String getCpPayVersion() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.version");
    }

    public static String getCpAppid() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.appid");
    }

    public static String getCpChannelid() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.channelid");
    }

    public static String getCpNotifyURL() {
        return ApplicationGlobalResource.getInstance().getValueByKey("pay.notify_url");
    }
}
