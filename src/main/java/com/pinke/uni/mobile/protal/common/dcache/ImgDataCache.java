package com.pinke.uni.mobile.protal.common.dcache;

import com.pinke.uni.mobile.protal.util.StoreUtil;
import com.pinke.uni.mobile.protal.util.SystemTools;
import com.pinke.uni.mobile.protal.util.Tools;

/**
 * 缓存商品信息类
 * 
 * @author Administrator
 * 
 */
public class ImgDataCache {
	// 客户端版本号
	private String clientversion;

	public String getClientversion() {
		return clientversion;
	}

	public void setClientversion(String clientversion) {
		this.clientversion = clientversion;
	}

	private AppDCacheAdapter c = null;

	public ImgDataCache() {
		super();
		initClient();
	}

	private void initClient() {
		if (MemConstant.DCACHE_ISOPEN) {
			c = AppDCacheFactory.getInstance().getAdapter(
					MemConstant.MISP_DCACHE_SPACE);
		}
	}

	/**
	 * 从缓存中获取图片
	 * 
	 * @param search
	 * @return
	 */
	public byte[] getIcondata(String iconurl) throws Exception {
		byte[] rs;

		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONEICONDATA, iconurl });
		SeriObjDCache dcValue = null;
		if (c != null) {
			dcValue = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
		}
		if (dcValue == null || c == null) {
			rs = SystemTools.readFileToByte(iconurl);
			if (rs != null && c != null) {
				dcValue = new SeriObjDCache();
				dcValue.setMemObj("");
				dcValue.setMemByte(rs);
				// c.setValue(this.getClass().getName(), strKey, dcValue,
				// MemConstant.TIME_LEVEL3);
				c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
						MemConstant.TIME_LEVEL3);
			}
		} else {
			rs = dcValue.getMemByte();
		}
		return rs;
	}

	/**
	 * 获取的适配客户端的图片
	 * 
	 * @param ratiotype
	 *            分辨率类型 1 240x320 ;2 320x480
	 * @param icontype
	 *            图片类型 1 列表图片;2 详情图片;3 截图
	 * @return [图片名]
	 * @throws Exception
	 *             SQLEXCEPION
	 */
	public String[] getPhoneiconCache(String picname, String ratiotype)
			throws Exception {
		String[] rs = null;
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONEICONS, "Phoneicon", picname, ratiotype });
		SeriObjDCache dcValue = null;
		if (c != null) {
			dcValue = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
		}
		if (dcValue == null || c == null || dcValue.getMemObjList() == null) {
			rs = StoreUtil.parseIconurl(picname, getPhoneiconCache2(ratiotype));
			if (rs != null && rs[0] != null && rs[1] != null && c != null) {
				dcValue = new SeriObjDCache();
				dcValue.setMemObj("");
				dcValue.setMemObjList(rs);
				// c.setValue(this.getClass().getName(), strKey, dcValue,
				// MemConstant.TIME_LEVEL3);
				c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
						MemConstant.TIME_LEVEL3);
			}
		} else {
			rs = (String[]) dcValue.getMemObjList();
		}
		return rs;
	}

	/**
	 * 获取的适配客户端的图片
	 * 
	 * @param ratiotype
	 *            分辨率类型 1 240x320 ;2 320x480
	 * @param icontype
	 *            图片类型 1 列表图片;2 详情图片;3 截图
	 * @return [图片名]
	 * @throws Exception
	 *             SQLEXCEPION
	 */
	public String getPhoneiconCache2(String ratio) throws Exception {
		String rs = "middle";
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONEICONS, "PhoneiconName", ratio });
		SeriObjDCache dcValue = null;
		if (c != null) {
			dcValue = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
		}
		if (dcValue == null || c == null) {
			if (Tools.isNull(ratio) || !Tools.isNumeric(ratio)) {
				ratio = "320";
			}
			// String[] rations=ratio.split("x");
			int tempRation = Integer.parseInt(ratio);
			if (tempRation >= 480) {
				rs = "large";
			} else if (tempRation > 240) {
				rs = "middle";
			} else if (tempRation <= 240) {
				rs = "small";
			}
			if (c != null) {
				dcValue = new SeriObjDCache();
				dcValue.setMemObj(rs);
				// c.setValue(this.getClass().getName(), strKey, dcValue,
				// MemConstant.TIME_LEVEL3);
				c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
						MemConstant.TIME_LEVEL3);
			}
		} else {
			rs = (String) dcValue.getMemObj();
		}
		return rs;
	}

	/**
	 * 获取的适配客户端的图片
	 * 
	 * @param ratiotype
	 *            分辨率类型 1 240x320 ;2 320x480
	 * @param icontype
	 *            图片类型 1 列表图片;2 详情图片;3 截图
	 * @return [图片名]
	 * @throws Exception
	 *             SQLEXCEPION
	 */
	public String getPhoneiconCache3(String iconurl, String ratiotype)
			throws Exception {
		String rs = "default.jpg";
		String imgName = getPhoneiconCache2(ratiotype);
		if ("large".equals(imgName)) {
			ratiotype = "88%5E88";
		} else if ("middle".equals(imgName)) {
			ratiotype = "64%5E64";
		} else {
			ratiotype = "40%5E40";
		}
		String[] urlparams = SystemTools.getURLParams(iconurl);
		String[] iconparam = urlparams[0].split("\\.");
		if (iconparam.length == 2) {// 非截图时，采用图片名加数据库中所存图片后缀拼接组成
			rs = urlparams[1] + iconparam[0] + "." + ratiotype + "."
					+ iconparam[1];
		}
		return rs;
	}
}
