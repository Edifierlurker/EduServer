package com.pinke.uni.mobile.protal.common.dcache;

import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class MemConstant {
	/**
	 * session
	 */
	public static final String PHONESESSIONID = "phonesessionid";
	/**
	 * 验证码
	 */
	public static final String PHONEVERIFYCODE = "phoneverifycode";
	/**
	 * 用户机型
	 */
	public static final String PHONEOWNUA = "phoneownua";
	/**
	 * 图片
	 */
	public static final String PHONEICONDATA = "phoneicondata";
	/**
	 * 图片路径
	 */
	public static final String PHONEICONS = "phoneicons";

	/**
	 * 
	 */
	public static final String OPENFEINTCLIENTSTAT = "openfeintclientstat";

	public static final char MISP_DCACHE_SPACE = '\001';
	/**
	 * dcache缓存清除时间常量
	 * 
	 */
	public static final boolean DCACHE_ISOPEN = MemConstant
			.getIsopen("store.dcacheflag");
	public static final Long TIME_LEVEL1 = MemConstant.getfalg(1);// 1800
	public static final Long TIME_LEVEL2 = MemConstant.getfalg(2);// 排行时间7200
	public static final Long TIME_LEVEL3 = MemConstant.getfalg(3);// 一级分类分页时间43200
	public static final Long TIME_LEVEL4 = MemConstant.getfalg(4);// 货架时间86400
	public static final Long TIME_LEVEL5 = MemConstant.getfalg(5);// 货架时间0

	public static Long getfalg(int level) {
		ApplicationGlobalResource agr = ApplicationGlobalResource.getInstance();
		String time = agr.getValueByKey("store.dcache_time_level" + level);
		if (null == time || "".equals(time)) {
			time = "0";
		}
		return Long.parseLong(time);
	}

	public static boolean getIsopen(String level) {
		ApplicationGlobalResource agr = ApplicationGlobalResource.getInstance();
		String isopen = agr.getValueByKey(level);
		if (Tools.isNotNull(isopen)) {
			return "true".equals(isopen) ? true : false;
		}
		return false;
	}

	// public static void main(String[] args) {
	// System.out.println(DCACHE_ISOPEN);
	// System.out.println(TIME_LEVEL1);
	// System.out.println(TIME_LEVEL2);
	// System.out.println(TIME_LEVEL3);
	// System.out.println(TIME_LEVEL4);
	// System.out.println(TIME_LEVEL5);
	// }
}
