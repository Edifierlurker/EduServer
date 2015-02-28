package com.pinke.uni.mobile.protal.common.config;

import java.io.File;
import java.util.HashMap;

import com.pinke.uni.mobile.protal.util.ProjectContext;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 配置文件载入类
 * 
 * @author Administrator
 * 
 */
public class ConfigContent {
	private static Log log=SSBBus.getLog(ConfigContent.class);
	/**
	 * 配置文件类
	 */
	private static XmlConfiguration xmlconfig = new XmlConfiguration();
	
	/**
	 * 修改时间，用来判断是否重新加载
	 */
	private static long FIRST_MODIFY_TIME = new File(ConfigParser.XML_FILE)
			.lastModified();

	/**
	 * 初始化参数
	 */
	public static void init() {
		ConfigParser configParse = new ConfigParser();
		
//		xmlconfig.setDevUser(configParse.getNodeAtrr("DEV",
//				"dbname"));
		xmlconfig.setWapUrlRoot(configParse.getNodeAtrr(
				"PATH", "rootpath"));
		xmlconfig.setWapVoLog(configParse.getNodeAtrr(
				"PRINTLOG", "isopen"));
		xmlconfig.setBalckUser(configParse.getNodeAtrr(
				"BLACKUSER", "isopen"));
		xmlconfig.setWapAppdetail(configParse.getNodeAtrr(
				"PATH", "appdetail"));
		xmlconfig.setWebUrlRoot(configParse.getNodeAtrr(
				"WEBPATH", "rootpath"));
		xmlconfig.setWebAppdetail(configParse.getNodeAtrr(
				"WEBPATH", "appdetail"));
		xmlconfig.setAppstateUrlRoot(configParse
				.getNodeAtrr("NOTICEURL", "rootpath"));
		xmlconfig.setNoticePath(configParse.getNodeAtrr(
				"NOTICEURL", "page"));
		xmlconfig.setImageRootUrl(ProjectContext.getInstance()
				.getRootPath()+ "upload/");
		xmlconfig.setImageDefaultUrl(ProjectContext.getInstance()
				.getConfigPath()+ "images/");
		xmlconfig.setHttpHeaderUa(configParse.getNodeAtrr(
				"HTTPHEADER", "ua"));
		xmlconfig.setHttpHeaderHandua(configParse
				.getNodeAtrr("HTTPHEADER", "handua"));
		xmlconfig.setHttpHeaderPhone(configParse
				.getNodeAtrr("HTTPHEADER", "phone"));
		xmlconfig.setHttpHeaderHandphone(configParse
				.getNodeAtrr("HTTPHEADER", "handphone"));
		xmlconfig.setHttpHeaderSettertype(configParse
				.getNodeAtrr("HTTPHEADER", "settertype"));
		xmlconfig.setHttpHeaderVersion(configParse
				.getNodeAtrr("HTTPHEADER", "version"));
//		xmlconfig.setCacheTime(Integer.parseInt(configParse
//				.getNodeAtrr("CACHE", "time")));
//		xmlconfig.setCacheIsopen(Integer.parseInt(configParse.getNodeAtrr("CACHE", "isopen")));
		xmlconfig.setCommlen(Integer.parseInt(configParse
				.getNodeAtrr("COMMENT", "length")));
//		xmlconfig.setCommlen(Integer.parseInt(configParse
//				.getNodeAtrr("KEYWORDS", "number")));
		xmlconfig.setPayKey(configParse.getNodeAtrr("KEY",
				"VALUE"));
		xmlconfig.setPayType(configParse.getNodeAtrr(
				"accountType", "VALUE"));
		xmlconfig.setPayAddress(configParse.getNodeAtrr(
				"Port_address", "VALUE"));
		xmlconfig.setRequestWap(configParse.getNodeAtrr(
				"requestWap", "VALUE"));
		xmlconfig.setAddMoney(configParse.getNodeAtrr(
				"addMoney", "VALUE"));
		xmlconfig.setTaskFreshmemoryStime(configParse
				.getNodeAtrr("AUTOFRESHMEMORY", "starttime"));
		xmlconfig.setTaskFreshmemoryEtime(configParse
				.getNodeAtrr("AUTOFRESHMEMORY", "endtime"));
		xmlconfig.setTaskFreshmemoryInterval(configParse
				.getNodeAtrr("AUTOFRESHMEMORY", "interval"));
		xmlconfig.setTaskFreshConfigStime(configParse
				.getNodeAtrr("AUTOFRESHCONFIG", "starttime"));
		xmlconfig.setTaskFreshConfigEtime(configParse
				.getNodeAtrr("AUTOFRESHCONFIG", "endtime"));
		xmlconfig.setTashFreshConfigInterval(configParse
				.getNodeAtrr("AUTOFRESHCONFIG", "interval"));
		xmlconfig.setShortMessageSenttype(configParse
				.getNodeAtrr("SENTTYPE", "type"));
		xmlconfig.setShortMessageOrdertype(configParse
				.getNodeAtrr("ORDERTYPE", "otype"));
		xmlconfig.setDefaultua(initUadefault(configParse));
//		xmlconfig.setCafircount(configParse
//				.getNodeAtrr("CATEGORY", "cafircount"));
		xmlconfig.setBillingremoteurl(configParse
				.getNodeAtrr("REMOTEURL", "VALUE"));
		xmlconfig.setBillackey(configParse
				.getNodeAtrr("BILLPARAM", "ackey"));
		xmlconfig.setBillcusid(configParse
				.getNodeAtrr("BILLPARAM", "cusid"));
		xmlconfig.setBillptype(configParse
				.getNodeAtrr("BILLPARAM", "ptype"));
		xmlconfig.setWebremoteurl(configParse
				.getNodeAtrr("WEBREMOTEURL", "VALUE"));
		xmlconfig.setIsloginuser(configParse
				.getNodeAtrr("ISLOGINUSER", "isopen"));
//		xmlconfig.setNewcount(configParse
//				.getNodeAtrr("APPCOUNT", "new"));
//		xmlconfig.setRecommendcount(configParse
//				.getNodeAtrr("APPCOUNT", "recommend"));
//		xmlconfig.setToplistcount(configParse
//				.getNodeAtrr("APPCOUNT", "toplist"));
		xmlconfig.setSource(configParse
				.getNodeAtrr("SOURCE", "VALUE"));
		xmlconfig.setAuthlogin(configParse
				.getNodeAtrr("WAPSET", "authlogin"));
		xmlconfig.setAddyn(configParse
				.getNodeAtrr("advert", "dyna"));
		xmlconfig.setCompanykey(configParse
				.getNodeAtrr("company", "key"));
		log.info("初始化配置文件参数：\n");
		log.info(xmlconfig.toString());
		
		configParse = null;
	}

	public static final XmlConfiguration getXmlconfig() {
		return xmlconfig;
	}

	public static void reLoad() {
		synchronized (xmlconfig) {
			long now_time = new File(ConfigParser.XML_FILE).lastModified();
			if (FIRST_MODIFY_TIME != now_time) {
				log.info("开始重新载入配置文件");
				init();
				FIRST_MODIFY_TIME = now_time;
				log.info("重新载入配置文件结束");
			}
		}
	}
	
	/**
	 * 当从网关和用户信息中都获取不到ua信息时，发送此ua信息给用户
	 */
	private static HashMap<String,String[]>  initUadefault(ConfigParser configParse){
		HashMap<String,String[]> uadefalut = new HashMap<String,String[]>();
		String[] uainfo = null;
		String name = "";
		String ua = "";
		name = configParse.getNodeAtrr("wm", "name");
		ua = configParse.getNodeAtrr("wm", "ua");
		uainfo = new String[]{name,ua};
		uadefalut.put("wm", uainfo);
		name = configParse.getNodeAtrr("java", "name");
		ua = configParse.getNodeAtrr("java", "ua");
		uainfo = new String[]{name,ua};
		uadefalut.put("java", uainfo);
		name = configParse.getNodeAtrr("Symbian", "name");
		ua = configParse.getNodeAtrr("Symbian", "ua");
		uainfo = new String[]{name,ua};
		uadefalut.put("Symbian", uainfo);
		name = configParse.getNodeAtrr("android", "name");
		ua = configParse.getNodeAtrr("android", "ua");
		uainfo = new String[]{name,ua};
		uadefalut.put("android", uainfo);
		return uadefalut;
	}
}
