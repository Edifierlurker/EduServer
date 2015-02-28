package com.pinke.uni.mobile.protal.util;

/**
 * 常量
 * 
 * @author Administrator
 * 
 */
public class Constant {
	/**
	 * 用户未设置时的默认姓名
	 */
	public static final String DEFAULT_USERNAME = "路人甲";

	/**
	 * sessionid缓存时间，2小时
	 */
	public static final int CACHE_SESSION_TIME = 1800;
	/**
	 * 机型缓存
	 */
	public static final int CACHE_HANDSET_MODELNAME = 7200;
	/**
	 * 热门品牌个数
	 */
	public static final int HOT_BRAND = 6;
	/**
	 * 注册时密码加密解密key
	 */
	public static final String PASS_KEY = "WOSTORE_PHONE_*&^%$";

	/** =============================================================== **/
	/**
	 * 提供短信、彩信、WAPPUSH等业务能力功能的业务类型
	 */
	public static final String SERVICETYPE_MESSAGE = "10";
	/**
	 * 提供下载引擎的接口的业务类型
	 */
	public static final String SERVICETYPE_ENGINE = "20";
	/**
	 * 提供精分系统接口的业务类型
	 */
	public static final String SERVICETYPE_ANALYSE = "30";
	/**
	 * 短消息的命令类型
	 */
	// public static final String ORDERTYPE_SHORTMESS =
	// ConfigParser.getConfigParser().getNodeAtrr("ORDERTYPE", "otype");
	/**
	 * 彩信的命令类型
	 */
	public static final String ORDERTYPE_COLORMESS = "002";
	/**
	 * WAPPUSH的命令类型
	 */
	public static final String ORDERTYPE_WAPPUSH = "310";
	/**
	 * 获取客户端下载URL的命令类型
	 */
	public static final String ORDERTYPE_GETURL = "001";
	/**
	 * 群组分众的命令类型
	 */
	public static final String ORDERTYPE_GROUP = "001";
	/**
	 * 个体分众的命令类型
	 */
	public static final String ORDERTYPE_UNIT = "002";
	/**
	 * 个体基本属性的命令类型
	 */
	public static final String ORDERTYPE_UNITATTRIBUTE = "003";
	/**
	 * 群组列表的命令类型
	 */
	public static final String ORDERTYPE_GROUPLIST = "004";
	/**
	 * 商品智能分析的命令类型
	 */
	public static final String ORDERTYPE_APPCONSTRUE = "005";
}
