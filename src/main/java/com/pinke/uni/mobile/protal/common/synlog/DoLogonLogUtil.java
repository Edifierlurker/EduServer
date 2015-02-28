package com.pinke.uni.mobile.protal.common.synlog;

import com.pinke.uni.mobile.protal.util.StoreTools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class DoLogonLogUtil
{

    private static final String LOGCLASSFOROPENCLIENT = "com.pinke.uni.mobile.DoOpenClientUtil";
    private static final String LOGCLASSFORRTB = "com.pinke.uni.mobile.DoRTBUtil";
    private static final String LogCLASSFORRTBPOS = "com.pinke.uni.mobile.DoRTBPOSUtil";
    private static final String LOGCLASSFORBSSTC ="com.pinke.uni.mobile.DoBSSTCUtil";
    public static Log loggerOpenClient = SSBBus.getLog(LOGCLASSFOROPENCLIENT);
    public static Log loggerRTB = SSBBus.getLog(LOGCLASSFORRTB);
    public static Log loggerRTBPOS = SSBBus.getLog(LogCLASSFORRTBPOS);
    public static Log loggerBssTC = SSBBus.getLog(LOGCLASSFORBSSTC);

    private DoLogonLogUtil()
    {
    }

    private static StringBuffer logContent(LogParams params)
    {
        StringBuffer mess = new StringBuffer();
        mess.append(params.getClientVersion()).append(LogUtilConstants.SEPARATOR)
            .append(params.getChannelid()).append(LogUtilConstants.SEPARATOR)
            .append(params.getPhoneAccessType()).append(LogUtilConstants.SEPARATOR)
            .append(params.getNetworkOperator()).append(LogUtilConstants.SEPARATOR)
            .append(params.getUserType()) .append(LogUtilConstants.SEPARATOR)
            .append("").append(LogUtilConstants.SEPARATOR)
            .append(StoreTools.filterPfcStr(params.getUsercode().length() > 32 ? params.getUsercode().substring(0,
                                32) : params.getUsercode())).append(LogUtilConstants.SEPARATOR)
            .append(params.getUserImsi()).append(LogUtilConstants.SEPARATOR)
            .append(params.getUserImei()).append(LogUtilConstants.SEPARATOR)
            .append(params.getUserUa()).append(LogUtilConstants.SEPARATOR)
            .append(params.getTerminalIndex()).append(LogUtilConstants.SEPARATOR)
            .append(params.getDownchannel()).append(LogUtilConstants.SEPARATOR)
            .append(params.getRemoteIp().trim()).append(LogUtilConstants.SEPARATOR)
            .append(params.getUserState()).append(LogUtilConstants.SEPARATOR);
        return mess;
    }

    /**
     * 记录用户打开客户端日志的log4j日志(手机客户端调用此方法)
     */
    public static void logOpenClient(LogParams params)
    {
        try
        {
            StringBuilder mess = new StringBuilder();
            mess.append(StoreTools.getNow3()).append(LogUtilConstants.SEPARATOR).append("openClient").append(
                    LogUtilConstants.SEPARATOR).append(logContent(params));
            // 记录log4j日志
            loggerOpenClient.warn(mess.toString());
        }
        catch (Exception e)
        {
            loggerOpenClient.error("记录打开客户端日志失败", e);
        }
    }

    /**
     * RTB对接打点
     * time|channel|productIndex|position|userCode|IMSI|flag|pressemble|referer
     */
    public static void logRTB(LogParams params)
    {
        try
        {         
            StringBuilder mess = new StringBuilder();
            mess.append(StoreTools.getNow3()).append(LogUtilConstants.SEPARATOR)
                .append(params.getDownchannel()) .append(LogUtilConstants.SEPARATOR)
                .append(params.getProductIndex()).append(LogUtilConstants.SEPARATOR)
                .append(params.getErrorCode()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUsercode()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserImsi()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserUa()).append(LogUtilConstants.SEPARATOR)
                .append(params.getChannelid()).append(LogUtilConstants.SEPARATOR)
                .append(params.getRemoteIp()).append(LogUtilConstants.SEPARATOR);
            // 记录log4j日志
            loggerRTB.warn(mess.toString());
        }
        catch (Exception e)
        {
            loggerRTB.error("记录RTB日志失败", e);
        }
    }

    
    /**
     * RTB推荐位置记录
     * time|channel|productIndex|position|userCode|IMSI|flag|version|pressemble|referer
     */
    public static void logRTBPOS(LogParams params)
    {
        try
        {
            StringBuilder mess = new StringBuilder();
            mess.append(StoreTools.getNow3()).append(LogUtilConstants.SEPARATOR)
                .append(params.getDownchannel()).append(LogUtilConstants.SEPARATOR)
                .append(params.getProductIndex()).append(LogUtilConstants.SEPARATOR)
                .append(params.getErrorCode()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUsercode()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserImsi()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserState()).append(LogUtilConstants.SEPARATOR)
                .append(params.getClientVersion()).append(LogUtilConstants.SEPARATOR)
                .append(params.getChannelid()).append(LogUtilConstants.SEPARATOR)
                .append(params.getRemoteIp()).append(LogUtilConstants.SEPARATOR);
            // 记录log4j日志
            loggerRTBPOS.warn(mess.toString());
        }
        catch (Exception e)
        {
            loggerRTBPOS.error("记录RTB推荐位置日志失败", e);
        }
    }
    
    
    /**
     * 查询流量套餐
     * time|userCode|IMSI|IMEI|version|UA|pressemble|IP|已使用语音流量|未使用语音流量|已使用上网流量|未使用上网流量|
     */
    public static void logBSSTC(LogParams params)
    {
        try
        {
            StringBuilder mess = new StringBuilder();
            mess.append(StoreTools.getNow3()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUsercode()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserImsi()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserImei()).append(LogUtilConstants.SEPARATOR)                
                .append(params.getClientVersion()).append(LogUtilConstants.SEPARATOR)
                .append(params.getUserUa()).append(LogUtilConstants.SEPARATOR)
                .append(params.getChannelid()).append(LogUtilConstants.SEPARATOR)
                .append(params.getRemoteIp()).append(LogUtilConstants.SEPARATOR)
                .append(params.getMac()).append(LogUtilConstants.SEPARATOR);
            // 记录log4j日志
            loggerBssTC.warn(mess.toString());
        }
        catch (Exception e)
        {
            loggerBssTC.error("记录查询流量套餐日志失败", e);
        }
    }
}
