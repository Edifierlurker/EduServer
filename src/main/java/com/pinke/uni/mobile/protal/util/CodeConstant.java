package com.pinke.uni.mobile.protal.util;

/**
 * http状态常量定义
 * 
 * @author shenyijie
 * 
 */
public class CodeConstant {

	/**
	 * 处理成功
	 */
	public static final int SC_HTTP_200 = 200;
	public static final String HTTP_200 = "处理成功";

	/**
	 * 400（错误请求）客户端请求无效
	 */
	public static final int SC_HTTP_400 = 400;
	public static final String HTTP_400 = "客户端请求无效，传入参数有误";

	/**
	 * 401 客户端身份验证错误
	 */
	public static final int SC_HTTP_401 = 401;
	public static final String HTTP_401 = "客户端身份验证错误";

	/**
	 * 403服务器拒绝处理请求
	 */
	public static final int SC_HTTP_403 = 403;
	public static final String HTTP_403 = "服务器拒绝处理请求";

	/**
	 * 413（请求实体过大） 服务器无法处理请求
	 */
	public static final int SC_HTTP_413 = 413;
	public static final String HTTP_413 = "请求实体过大";

	/**
	 * 420用户未注册，无法登录
	 */
	public static final int SC_HTTP_420 = 420;
	public static final String HTTP_420 = "获取不到手机号码，需要重新登录";

	/**
	 * 421 用户是黑名单用户，无法登录
	 */
	public static final int SC_HTTP_421 = 421;
	public static final String HTTP_421 = "用户是黑名单用户，无法登录";
	/**
	 * 422 用户密码错误，无法登录
	 */
	public static final int SC_HTTP_422 = 422;
	public static final String HTTP_422 = "用户密码错误，无法登录";
	/**
	 * 用户sessionid验证错误，非法访问
	 */
	public static final int SC_HTTP_423 = 423;
	public static final String HTTP_423 = "用户sessionid验证错误，非法访问";
	/**
	 * 500 服务器内部错误，无法完成请求
	 */
	public static final int SC_HTTP_500 = 500;
	public static final String HTTP_500 = "服务器内部错误，无法完成请求";

	/**
	 * 503 服务器暂时无法可用
	 */
	public static final int SC_HTTP_503 = 503;
	public static final String HTTP_503 = "服务器暂时无法可用";

	/**
	 * 520 非本省用户或者号段信息不正确
	 */
	public static final int SC_HTTP_520 = 520;
	public static final String HTTP_520 = "非本省用户或者号段信息不正确";
	/**
	 * 521 开通专用APN失败
	 */
	public static final int SC_HTTP_521 = 521;
	public static final String HTTP_521 = "开通专用APN失败";

	/**
	 * 成功返回码
	 */
	public static final int RECODE_RS_SUC = 0;
	/**
	 * 失败返回码
	 */
	public static final int RECODE_RS_FAIL = 1;

}
