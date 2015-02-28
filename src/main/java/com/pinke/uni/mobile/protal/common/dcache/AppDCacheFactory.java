package com.pinke.uni.mobile.protal.common.dcache;

import java.util.HashMap;

public class AppDCacheFactory {

	private HashMap<String, AppDCacheAdapter> caches = new HashMap<String, AppDCacheAdapter>();

	public static AppDCacheFactory instance = null;

	public static AppDCacheFactory getInstance() {
		if (instance == null) {
			instance = new AppDCacheFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @param space
	 *            取值范围1~255
	 * @return
	 */
	public AppDCacheAdapter getAdapter(char space) {
		AppDCacheAdapter adapter = null;
		if (MemConstant.DCACHE_ISOPEN) {
			adapter = caches.get(String.valueOf(space));
			if (adapter == null) {
				adapter = new AppDCacheAdapter(space);
				caches.put(String.valueOf(space), adapter);
			}
		}
		return adapter;
	}

	public void removeAdapter(char space) {
		caches.remove(String.valueOf(space));
	}

}
