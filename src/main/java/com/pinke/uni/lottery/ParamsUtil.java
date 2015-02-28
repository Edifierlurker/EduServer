package com.pinke.uni.lottery;

import com.pinke.uni.lottery.http.PostParameter;
import com.pinke.uni.mobile.protal.util.CryptUtil;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.util.*;

/**
 * Created by Administrator on 14-12-31.
 */
public class ParamsUtil {

    public static String mapToParamStr(Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String key : paramMap.keySet()) {
            if ("t".equals(key) || "partner".equals(key) || "sign".equals(key))
                continue;
            String value = paramMap.get(key);
            if (isFirst) {
                sb.append(key + "=" + value);
                isFirst = false;
            } else {
                if (value != null) {
                    sb.append("&" + key + "=" + value);
                } else {
                    sb.append("&" + key + "=");
                }
            }
        }
        return sb.toString();
    }

    public static String generateRequestParamStr(Map map) {
        String param = mapToParamStr(map);
        String temp = (StringUtils.isEmpty(param) ? "" : (param + "&"));
        String rt = temp + "partner=" + getPartner() + "&t=" + map.get("t") + "&sign=" + signParams(map);
        System.out.println("******************post content : " + rt);
        return rt;
    }

    public static Map addSignInfo(Map<String,String> map){
           map.put("partner",getPartner());
           map.put("sign", signParams(map));
        return map;
    }

    public static String signParams(Map map) {
        String param = mapToParamStr(map);
        String temp = (StringUtils.isEmpty(param) ? "" : (param + "&")) + "partner=" + getPartner();
        String firstSign = MD5(temp);
        String origTwo = firstSign + map.get("t") + getPartnerKey();
        return MD5(origTwo);
    }

    public static Map paramStringToMap(String params){
        if(params == null) return null;
        Map map = new HashMap();
        StringTokenizer st = new StringTokenizer(params,"&");
        while(st.hasMoreElements()){
            String param = String.valueOf(st.nextElement());
            int deli = param.indexOf("=");
            map.put(param.substring(0,deli),param.substring(deli+1));
        }
        return map;
    }

    public static PostParameter[] mapToPostParameter(Map<String,String> map){
        if(map == null ) return new PostParameter[0];
        List<PostParameter> list = new ArrayList<PostParameter>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            list.add(new PostParameter(entry.getKey(),entry.getValue()));
        }
        return list.toArray(new PostParameter[list.size()]);
    }

    public static boolean verifySign(String sign, Map params) {
        return sign.equals(signParams(params));
    }

    public static String getPartnerKey() {
        return ApplicationGlobalResource.getInstance().getValueByKey("caipiao.pkey");
    }

    public static String getPartner() {
        return ApplicationGlobalResource.getInstance().getValueByKey("caipiao.partnerid");
    }

    public static void main(String[] arg) {
        Map map = new TreeMap();
//        map.put("lottery","001");
        map.put("orderId","P15012017294900004");
        map.put("status","1");
        map.put("success","");
        map.put("message","");
        map.put("t", "1421748144108");
        System.out.println(generateRequestParamStr(map));
        String[] a = {"{\"result\":-1}","{\"result\":-1}","{\"result\":-1}"};
        System.out.println(JSONArray.fromObject(a));

    }

    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String paramMapToJSONString(String[] params ,Map<String,String> paramMap){
        StringBuffer sb = new StringBuffer("{");
        for(String param : params){
            sb.append("\""+ param+"\"").append(":").append("\""+ paramMap.get(param)+"\"") ;
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("}");
        return sb.toString();
    }


}
