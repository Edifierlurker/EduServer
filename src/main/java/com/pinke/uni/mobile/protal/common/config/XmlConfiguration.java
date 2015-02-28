package com.pinke.uni.mobile.protal.common.config;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 系统配置项，所有信息放在xml文件中
 * 
 * @author Administrator
 * 
 */
public class XmlConfiguration {
	/**
	 * 开发者社区数据库用户名
	 */
	// private String devUser;
	/**
	 * wap网站主页地址
	 */
	private String wapUrlRoot;
	/**
	 * 日志的输出控制
	 */
	private String wapVoLog;
	/**
	 * 黑名单及时拦截开关
	 */
	private String balckUser;
	/**
	 * wap网站商品详情地址
	 */
	private String wapAppdetail;
	/**
	 * WEB网站主页地址
	 */
	private String webUrlRoot;
	/**
	 * WEB网站商品详情地址
	 */
	private String webAppdetail;
	/**
	 * 代理地址
	 */
	private String appstateUrlRoot;
	/**
	 * 公告页面
	 */
	private String noticePath;
	/**
	 * 图片服务器路径
	 */
	private String imageRootUrl;
	/**
	 * 读取不到文件时默认图片路径
	 */
	private String imageDefaultUrl;
	/**
	 * HTTP头信息手机User_Agent key
	 */
	private String httpHeaderUa;
	/**
	 * HTTP头信息手机User_Agent key 手动输入
	 */
	private String httpHeaderHandua;
	/**
	 * HTTP头信息手机号key
	 */
	private String httpHeaderPhone;
	/**
	 * HTTP头信息手机号key，手动输入
	 */
	private String httpHeaderHandphone;
	/**
	 * HTTP头信息设置类型key
	 */
	private String httpHeaderSettertype;
	/**
	 * HTTP头信息客户端版本key
	 */
	private String httpHeaderVersion;
	/**
	 * 缓存时间
	 */
	// private int cacheTime;
	/**
	 * 是否开启缓存0 关闭，1开启
	 */
	// private int cacheIsopen;
	/**
	 * 评论长度限制
	 */
	private int commlen;
	/**
	 * 中间账户key
	 */
	private String payKey;
	/**
	 * 中间账户类型
	 */
	private String payType;
	/**
	 * 中间账户地址
	 */
	private String payAddress;
	/**
	 * 中间注册绑定返回地址
	 */
	private String requestWap;
	/**
	 * 中间充值地址
	 */
	private String addMoney;
	/**
	 * 刷新内存定时器开始时间(时)
	 */
	private String taskFreshmemoryStime;
	/**
	 * 刷新内存定时器结束时间(时)
	 */
	private String taskFreshmemoryEtime;
	/**
	 * 刷新内存定时器间隔时间(分)
	 */
	private String taskFreshmemoryInterval;
	/**
	 * 刷新配置文件开始时间(时)
	 */
	private String taskFreshConfigStime;
	/**
	 * 刷新配置文件结束时间(时)
	 */
	private String taskFreshConfigEtime;
	/**
	 * 刷新配置文件间隔时间(分)
	 */
	private String tashFreshConfigInterval;
	/**
	 * 短信发送方式1 短消息 2 push
	 */
	private String shortMessageSenttype;
	/**
	 * 短消息的命令类型
	 */
	private String shortMessageOrdertype;
	/**
	 * 当从网关和用户信息中都获取不到ua信息时，发送此ua信息给用户
	 */
	private HashMap<String, String[]> defaultua = null;
	/**
	 * 一级分类显示个数
	 */
	// private String cafircount;
	/**
	 * 计费远程调用url
	 */
	private String billingremoteurl;
	/**
	 * 计费商户号
	 */
	private String billcusid;
	/**
	 * 计费接入密钥
	 */
	private String billackey;
	/**
	 * 门户类型 0-管理平台 1——WAP门户 2——WEB门户 3——手机客户端 4——PC客户端
	 */
	private String billptype;
	/**
	 * web门户调用url
	 */
	private String webremoteurl;
	/**
	 * 
	 * 是否判断用户登陆
	 */
	private String isloginuser;
	/**
	 * 新品推荐总数
	 */
	// private String newcount;
	/**
	 * 精品推荐
	 */
	// private String recommendcount;
	/**
	 * 排行榜
	 */
	// private String toplistcount;
	/**
	 * souce文件名
	 */
	private String source;

	/**
	 * 广告是否动态读取 1 动态读取
	 */
	private String addyn = "0";

	/**
	 * 通过wap网关是否自动登录
	 */
	private String authlogin;

	private String keywords;

	private String companykey;

	public String defaultuaString() {
		String uas = "";
		if (defaultua != null) {
			uas = "(";
			Iterator<String> iterator = defaultua.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				String[] value = defaultua.get(key);
				uas += (key + "=[" + value[0] + "," + value[1] + "]");
			}
			uas += ")";
		}
		return uas;
	}

	@Override
	public String toString() {
		return "XmlConfiguration [appstateUrlRoot=" + appstateUrlRoot
				+ ";\n defaultua=" + defaultuaString()
				+ ";\n httpHeaderHandphone=" + httpHeaderHandphone
				+ ";\n httpHeaderHandua=" + httpHeaderHandua
				+ ";\n httpHeaderPhone=" + httpHeaderPhone
				+ ";\n httpHeaderSettertype=" + httpHeaderSettertype
				+ ";\n httpHeaderUa=" + httpHeaderUa + ";\n httpHeaderVersion="
				+ httpHeaderVersion + ";\n imageDefaultUrl=" + imageDefaultUrl
				+ ";\n imageRootUrl=" + imageRootUrl + ";\n noticePath="
				+ noticePath + ";\n payAddress=" + payAddress
				+ ";\n requestWap=" + requestWap + ";\n addMoney=" + addMoney
				+ ";\n payKey=" + payKey + ";\n payType=" + payType
				+ ";\n shortMessageOrdertype=" + shortMessageOrdertype
				+ ";\n shortMessageSenttype=" + shortMessageSenttype
				+ ";\n tashFreshConfigInterval=" + tashFreshConfigInterval
				+ ";\n taskFreshConfigEtime=" + taskFreshConfigEtime
				+ ";\n taskFreshConfigStime=" + taskFreshConfigStime
				+ ";\n taskFreshmemoryEtime=" + taskFreshmemoryEtime
				+ ";\n taskFreshmemoryInterval=" + taskFreshmemoryInterval
				+ ";\n taskFreshmemoryStime=" + taskFreshmemoryStime
				+ ";\n wapAppdetail=" + wapAppdetail + ";\n wapUrlRoot="
				+ wapUrlRoot + ";\n wapVoLog=" + wapVoLog + ";\n blackUser="
				+ balckUser + ";\n webAppdetail=" + webAppdetail
				+ ";\n webUrlRoot=" + webUrlRoot + ";\n billingremoteurl="
				+ billingremoteurl + ";\n billcusid=" + billcusid
				+ ";\n billackey=" + billackey + ";\n billptype=" + billptype
				+ ";\n webremoteurl=" + webremoteurl + ";\n isloginuser="
				+ isloginuser + ";\n source=" + source + ";\n authlogin="
				+ authlogin + ";\n keywords=" + keywords + ";\n advertdyna="
				+ addyn + ";\n companykey=" + companykey + "]";
	}

	public String getAuthlogin() {
		return authlogin;
	}

	public void setAuthlogin(String authlogin) {
		this.authlogin = authlogin;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsloginuser() {
		return isloginuser;
	}

	public void setIsloginuser(String isloginuser) {
		this.isloginuser = isloginuser;
	}

	// public String getCafircount() {
	// return cafircount;
	// }
	// public void setCafircount(String cafircount) {
	// this.cafircount = cafircount;
	// }
	public String getTaskFreshConfigStime() {
		return taskFreshConfigStime;
	}

	public void setTaskFreshConfigStime(String taskFreshConfigStime) {
		this.taskFreshConfigStime = taskFreshConfigStime;
	}

	public String getTaskFreshConfigEtime() {
		return taskFreshConfigEtime;
	}

	public void setTaskFreshConfigEtime(String taskFreshConfigEtime) {
		this.taskFreshConfigEtime = taskFreshConfigEtime;
	}

	public String getTashFreshConfigInterval() {
		return tashFreshConfigInterval;
	}

	public void setTashFreshConfigInterval(String tashFreshConfigInterval) {
		this.tashFreshConfigInterval = tashFreshConfigInterval;
	}

	public String getWapUrlRoot() {
		return wapUrlRoot;
	}

	public void setWapUrlRoot(String wapUrlRoot) {
		this.wapUrlRoot = wapUrlRoot;
	}

	public String getWapVoLog() {
		return wapVoLog;
	}

	public void setWapVoLog(String wapVoLog) {
		this.wapVoLog = wapVoLog;
	}

	public String getWapAppdetail() {
		return wapAppdetail;
	}

	public void setWapAppdetail(String wapAppdetail) {
		this.wapAppdetail = wapAppdetail;
	}

	public String getWebUrlRoot() {
		return webUrlRoot;
	}

	public void setWebUrlRoot(String webUrlRoot) {
		this.webUrlRoot = webUrlRoot;
	}

	public String getWebAppdetail() {
		return webAppdetail;
	}

	public void setWebAppdetail(String webAppdetail) {
		this.webAppdetail = webAppdetail;
	}

	public String getAppstateUrlRoot() {
		return appstateUrlRoot;
	}

	public void setAppstateUrlRoot(String appstateUrlRoot) {
		this.appstateUrlRoot = appstateUrlRoot;
	}

	public String getNoticePath() {
		return noticePath;
	}

	public void setNoticePath(String noticePath) {
		this.noticePath = noticePath;
	}

	public String getImageRootUrl() {
		return imageRootUrl;
	}

	public void setImageRootUrl(String imageRootUrl) {
		this.imageRootUrl = imageRootUrl;
	}

	public String getImageDefaultUrl() {
		return imageDefaultUrl;
	}

	public void setImageDefaultUrl(String imageDefaultUrl) {
		this.imageDefaultUrl = imageDefaultUrl;
	}

	public String getHttpHeaderUa() {
		return httpHeaderUa;
	}

	public void setHttpHeaderUa(String httpHeaderUa) {
		this.httpHeaderUa = httpHeaderUa;
	}

	public String getHttpHeaderHandua() {
		return httpHeaderHandua;
	}

	public void setHttpHeaderHandua(String httpHeaderHandua) {
		this.httpHeaderHandua = httpHeaderHandua;
	}

	public String getHttpHeaderPhone() {
		return httpHeaderPhone;
	}

	public void setHttpHeaderPhone(String httpHeaderPhone) {
		this.httpHeaderPhone = httpHeaderPhone;
	}

	public String getHttpHeaderHandphone() {
		return httpHeaderHandphone;
	}

	public void setHttpHeaderHandphone(String httpHeaderHandphone) {
		this.httpHeaderHandphone = httpHeaderHandphone;
	}

	public String getHttpHeaderSettertype() {
		return httpHeaderSettertype;
	}

	public void setHttpHeaderSettertype(String httpHeaderSettertype) {
		this.httpHeaderSettertype = httpHeaderSettertype;
	}

	public String getHttpHeaderVersion() {
		return httpHeaderVersion;
	}

	public void setHttpHeaderVersion(String httpHeaderVersion) {
		this.httpHeaderVersion = httpHeaderVersion;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayAddress() {
		return payAddress;
	}

	public void setPayAddress(String payAddress) {
		this.payAddress = payAddress;
	}

	public String getTaskFreshmemoryStime() {
		return taskFreshmemoryStime;
	}

	public void setTaskFreshmemoryStime(String taskFreshmemoryStime) {
		this.taskFreshmemoryStime = taskFreshmemoryStime;
	}

	public String getTaskFreshmemoryEtime() {
		return taskFreshmemoryEtime;
	}

	public void setTaskFreshmemoryEtime(String taskFreshmemoryEtime) {
		this.taskFreshmemoryEtime = taskFreshmemoryEtime;
	}

	public String getTaskFreshmemoryInterval() {
		return taskFreshmemoryInterval;
	}

	public void setTaskFreshmemoryInterval(String taskFreshmemoryInterval) {
		this.taskFreshmemoryInterval = taskFreshmemoryInterval;
	}

	public String getShortMessageSenttype() {
		return shortMessageSenttype;
	}

	public void setShortMessageSenttype(String shortMessageSenttype) {
		this.shortMessageSenttype = shortMessageSenttype;
	}

	public String getShortMessageOrdertype() {
		return shortMessageOrdertype;
	}

	public void setShortMessageOrdertype(String shortMessageOrdertype) {
		this.shortMessageOrdertype = shortMessageOrdertype;
	}

	public HashMap<String, String[]> getDefaultua() {
		return defaultua;
	}

	public void setDefaultua(HashMap<String, String[]> defaultua) {
		this.defaultua = defaultua;
	}

	public String getBalckUser() {
		return balckUser;
	}

	public void setBalckUser(String balckUser) {
		this.balckUser = balckUser;
	}

	public String getAddMoney() {
		return addMoney;
	}

	public void setAddMoney(String addMoney) {
		this.addMoney = addMoney;
	}

	public String getRequestWap() {
		return requestWap;
	}

	public void setRequestWap(String requestWap) {
		this.requestWap = requestWap;
	}

	public String getBillingremoteurl() {
		return billingremoteurl;
	}

	public void setBillingremoteurl(String billingremoteurl) {
		this.billingremoteurl = billingremoteurl;
	}

	public String getBillcusid() {
		return billcusid;
	}

	public void setBillcusid(String billcusid) {
		this.billcusid = billcusid;
	}

	public String getBillackey() {
		return billackey;
	}

	public void setBillackey(String billackey) {
		this.billackey = billackey;
	}

	public String getBillptype() {
		return billptype;
	}

	public void setBillptype(String billptype) {
		this.billptype = billptype;
	}

	public String getWebremoteurl() {
		return webremoteurl;
	}

	public void setWebremoteurl(String webremoteurl) {
		this.webremoteurl = webremoteurl;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getAddyn() {
		return addyn;
	}

	public void setAddyn(String addyn) {
		this.addyn = addyn;
	}

	public int getCommlen() {
		return commlen;
	}

	public void setCommlen(int commlen) {
		this.commlen = commlen;
	}

	public String getCompanykey() {
		return companykey;
	}

	public void setCompanykey(String companykey) {
		this.companykey = companykey;
	}
}
