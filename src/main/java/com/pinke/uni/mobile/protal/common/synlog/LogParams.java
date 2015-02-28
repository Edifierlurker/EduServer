package com.pinke.uni.mobile.protal.common.synlog;

import com.pinke.uni.mobile.protal.util.Tools;

public class LogParams {
	
	private String channelid;
	private String usercode;
	private String userid;
	private String userImsi;
	private String userImei;
	private String userType;
	private String remoteIp;
	private String phoneAccessType;
	private String terminalIndex;
	private String userUa;
	private String userState;
	private String errorCode;
    /**
     * 运营商网络
     */
    private String networkOperator;

    /**
     * 安卓平台版本
     */
    private String Androidversion;

    /**
     * 手机网络类型
     */
    private String networkType;

    /**
     * 信号强度
     */
    private String signal;

    /**
     * 手机mac地址
     */
    private String mac;
	
	private String productIndex;
	
	/**
	 * 客户端的版本号
	 */
	private String clientVersion;
	
	/**
	 * 频道id
	 * @return
	 */
	private String downchannel;
	
	public String getChannelid() {
		return Tools.isNull(channelid)?"":channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getUsercode() {
		return Tools.isNull(usercode)?"":usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUserid() {
		return Tools.isNull(userid)?"":userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserImsi() {
		return Tools.isNull(userImsi)?"":userImsi;
	}
	public void setUserImsi(String userImsi) {
		this.userImsi = userImsi;
	}
	public String getUserImei() {
		return Tools.isNull(userImei)?"":userImei;
	}
	public void setUserImei(String userImei) {
		this.userImei = userImei;
	}
	public String getUserType() {
		return Tools.isNull(userType)?"":userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getRemoteIp() {
		return Tools.isNull(remoteIp)?"":remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public String getPhoneAccessType() {
		return Tools.isNull(phoneAccessType)?"":phoneAccessType;
	}
	public void setPhoneAccessType(String phoneAccessType) {
		this.phoneAccessType = phoneAccessType;
	}
	public String getProductIndex() {
		return Tools.isNull(productIndex)?"":productIndex;
	}
	public void setProductIndex(String productIndex) {
		this.productIndex = productIndex;
	}
	public String getTerminalIndex() {
		
		return Tools.isNull(terminalIndex)?"":terminalIndex;
	}
	public void setTerminalIndex(String terminalIndex) {
		this.terminalIndex = terminalIndex;
	}
	public String getUserUa() {		
		return Tools.isNull(userUa)?"":userUa;
	}
	public void setUserUa(String userUa) {
		this.userUa = userUa;
	}
	public String getUserState() {		
		return Tools.isNull(userState)?"0":userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
    public String getErrorCode()
    {
        return Tools.isNull(errorCode)?"":errorCode;
    }
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getNetworkOperator()
    {
        return Tools.isNull(networkOperator)?"":networkOperator;
    }
    public void setNetworkOperator(String networkOperator)
    {
        this.networkOperator = networkOperator;
    }
    public String getAndroidversion()
    {
        return Tools.isNull(Androidversion)?"":Androidversion;
    }
    public void setAndroidversion(String androidversion)
    {
        Androidversion = androidversion;
    }
    public String getNetworkType()
    {
        return Tools.isNull(networkType)?"":networkType;
    }
    public void setNetworkType(String networkType)
    {
        this.networkType = networkType;
    }
    public String getSignal()
    {
        return Tools.isNull(signal)?"":signal;
    }
    public void setSignal(String signal)
    {
        this.signal = signal;
    }
    public String getMac()
    {
        return Tools.isNull(mac)?"":mac;
    }
    public void setMac(String mac)
    {
        this.mac = mac;
    }
    public String getDownchannel()
    {
        return Tools.isNull(downchannel)?"":downchannel;
    }
    public void setDownchannel(String downchannel)
    {
        this.downchannel = downchannel;
    }
    public String getClientVersion()
    {
        return Tools.isNull(clientVersion)?"":clientVersion;
    }
    public void setClientVersion(String clientVersion)
    {
        this.clientVersion = clientVersion;
    }

}
