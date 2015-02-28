package com.pinke.uni.mobile.protal.common.dcache;

import com.zte.zxcpp.dcache.dcjapi.javatcp.AppMsg;
import com.zte.zxcpp.dcache.dcjapi.javatcp.DcacheMessageListener;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * dcache异步写入的回调类，这里直接借用misp的回调类。并配置log4j.xml
 * 
 * @author Administrator
 * 
 */
public class DcacheCallBack implements DcacheMessageListener {

	private Log log = SSBBus.getLog(getClass());

	public void messageReceived(AppMsg msg) {
		throw new IllegalStateException("Not supported.");
	}

	public void messageReceived(AppMsg msg, String key) {
		if (msg == null) {
			this.log.error(key + " :timeout");
		} else if (msg.getStatus() != 0) {
			String opration = null;
			switch (msg.getCommand()) {
			case 1004:
				opration = "ASet";
				break;
			case 1006:
				opration = "ADel";
				break;
			case 1002:
				opration = "AGet";
				break;
			case 1008:
				opration = "AInc";
				break;
			case 1003:
			case 1005:
			case 1007:
			default:
				throw new IllegalArgumentException("Not supported operation.");
			}
			this.log.error(key + " " + opration + " failed, status is: "
					+ msg.getStatus());
		}
	}

}
