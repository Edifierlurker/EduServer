package com.pinke.uni.mobile.protal.common.dcache;

import com.pinke.uni.mobile.protal.util.Constant;
import com.pinke.uni.mobile.protal.util.StoreUtil;

/**
 * session缓存类,采用memcache中间件进行缓存,sessionid和客户端ip作为key将sessionid缓存，
 * 保证一个sessionid对应一个客户端 sessionid验证保证请求在不登陆的情况下都是非法，保证安全性
 * 
 * @author Administrator
 * 
 */
public class SessionCache {

	private static SessionCache cache = null;

	private static AppDCacheAdapter c = AppDCacheFactory.getInstance()
			.getAdapter(MemConstant.MISP_DCACHE_SPACE);
	// 验证码缓存时间5分钟
	private static int VERIFYCODE_TIME = 300;
	
	// vac验证码缓存时间3分钟
	private static int VACVERIFYCODE_TIME = 180;

	private SessionCache() {
	}

	public static SessionCache getInstance() {
		if (cache == null) {
			cache = new SessionCache();
		}
		return cache;

	}

	/**
	 * 插入sessionid 到缓存中
	 * 
	 * @param sessionid
	 *            sessionid
	 * @param ip
	 *            客户端ip地址
	 */
	public void putSessionid(String sessionid, String ip) {
		// 缓存key值
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONESESSIONID, sessionid, ip });
		SeriObjDCache dcSessionid = new SeriObjDCache();
		dcSessionid.setMemObj(sessionid);
		// 从缓存获取
		if (c != null) {
			// c.delKey(this.getClass().getName(), strKey);
			// c.delAsyncKey(this.getClass().getName(), strKey);
			// c.setValue(this.getClass().getName(), strKey, dcSessionid,
			// Constant.CACHE_SESSION_TIME);
			c.setAsyncValue(this.getClass().getName(), strKey, dcSessionid,
					Constant.CACHE_SESSION_TIME);
		}
	}

	/**
	 * 从缓存中获取sessionid
	 * 
	 * @param sessionid
	 *            key中sessionid
	 * @param ip
	 *            key中ip，客户端ip
	 * @return 存在 返回sessionid，不存在返回""
	 */
	public String getSessionid(String sessionid, String ip) {
		// 缓存key值
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONESESSIONID, sessionid, ip });

		// 从缓存获取
		SeriObjDCache dcSessionid = null;
		String _sessionid = "";
		if (c != null) {
			dcSessionid = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
			if (dcSessionid != null && dcSessionid.getMemObj() != null) {
				_sessionid = dcSessionid.getMemObj().toString();
			}
		}
		return _sessionid;
	}

	/**
	 * 插入验证码 到缓存中
	 * 
	 */
	public void putVerifycode(String phonenumber, String verifycode) {
		// 缓存key值
		if (c != null) {
			String strKey = StoreUtil.getStrKey(new String[] {
					MemConstant.PHONEVERIFYCODE, phonenumber });
			SeriObjDCache dcValue = new SeriObjDCache();
			dcValue.setMemObj(verifycode);
			// c.setValue(this.getClass().getName(), strKey, dcValue,
			// VERIFYCODE_TIME);
			c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
					VERIFYCODE_TIME);
		}
	}
	
	   /**
     * 插入vac验证码 到缓存中,过期时间3分钟
     * 
     */
    public void putVacVerifycode(String phonenumber, String verifycode) {
        // 缓存key值
        if (c != null) {
            String strKey = StoreUtil.getStrKey(new String[] {
                    MemConstant.PHONEVERIFYCODE, phonenumber });
            SeriObjDCache dcValue = new SeriObjDCache();
            dcValue.setMemObj(verifycode);
            // c.setValue(this.getClass().getName(), strKey, dcValue,
            // VERIFYCODE_TIME);
            c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
                    VACVERIFYCODE_TIME);
        }
    }

	/**
	 * 获取验证码
	 * 
	 * @param phonenumber
	 *            用户号码
	 * @return
	 */
	public String getVerifycode(String phonenumber) {
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONEVERIFYCODE, phonenumber });
		SeriObjDCache memobj = null;
		String verifycode = null;
		if (c != null) {
			memobj = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
			if (memobj != null && memobj.getMemObj() != null) {
				verifycode = memobj.getMemObj().toString();
			}
		}
		return verifycode;
	}

	/**
	 * 插入用户本机机型ua id到缓存中
	 * 
	 * @param sessionid
	 *            sessionid
	 */
	public void putSessionOwnua(String sessionid, String ua) {
		if (c != null) {
			// 缓存key值
			String strKey = StoreUtil.getStrKey(new String[] {
					MemConstant.PHONEOWNUA, sessionid });
			SeriObjDCache dcValue = new SeriObjDCache();
			dcValue.setMemObj(ua);
			// c.setValue(this.getClass().getName(), strKey, dcValue,
			// Constant.CACHE_SESSION_TIME);
			c.setAsyncValue(this.getClass().getName(), strKey, dcValue,
					Constant.CACHE_SESSION_TIME);
		}
	}

	/**
	 * 获取用户本机机型id
	 * 
	 * @param sessionid
	 * @return
	 */
	public String getUserOwnua(String sessionid) {
		String strKey = StoreUtil.getStrKey(new String[] {
				MemConstant.PHONEOWNUA, sessionid });
		SeriObjDCache memobj = null;
		String ownua = "";
		if (c != null) {
			memobj = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
			if (memobj != null && memobj.getMemObj() != null) {
				ownua = memobj.getMemObj().toString();
			}
		}
		return ownua;
	}

	/**
	 * 获取cache中的对象值
	 * 
	 * @param sessionid
	 * @return
	 */
	public String getCacheObj(String sessionid, String objkey) {
		String strKey = StoreUtil.getStrKey(new String[] { objkey, sessionid });
		SeriObjDCache memobj = null;
		String objvalue = "";
		if (c != null) {
			memobj = (SeriObjDCache) c.getValue(this.getClass().getName(),
					strKey);
			if (memobj != null && memobj.getMemObj() != null) {
				objvalue = memobj.getMemObj().toString();
			}
		}
		return objvalue;
	}

	/**
	 * 将对象值插入cache中
	 * 
	 * @param sessionid
	 * @return
	 */
	public void putCacheObj(String sessionid, String objkey, Object objvalue,
			int expires) {
		String strKey = StoreUtil.getStrKey(new String[] { objkey, sessionid });
		SeriObjDCache dcValue = new SeriObjDCache();
		dcValue.setMemObj(objvalue);
		// c.setValue(this.getClass().getName(), strKey, dcValue, expires);
		c.setAsyncValue(this.getClass().getName(), strKey, dcValue, expires);
	}

	/**
	 * 删除cache中的对象
	 * 
	 * @param sessionid
	 * @return
	 */
	public void removeCacheObj(String sessionid, String objkey) {
		String strKey = StoreUtil.getStrKey(new String[] { objkey, sessionid });
		// c.delKey(this.getClass().getName(), strKey);
		c.delAsyncKey(this.getClass().getName(), strKey);
	}
}
