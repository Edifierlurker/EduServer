package com.pinke.uni.mobile.protal.util;

import com.zte.sapi.db.ConnectionPool;
import com.zte.zxywpub.ConnectionPoolImpl;

/**
 * 操作145库
 * 
 * @author Administrator
 * 
 */
public class ConnectionUtil {

	public static boolean insert(String sql) {
		try {
			ConnectionPool dbPool = ConnectionPoolImpl.getInstance();
			if(dbPool.doUpdate("134", sql)>0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("实时同步："+sql);
			e.printStackTrace();
		}
		return false;
	}
	
//	public static boolean insert2(String sql) {
////		需回收连接
//		ConnectionPool dbPool = null;
//		Hashtable ht = null;
//		try {
//		 dbPool = ConnectionPoolImpl.getInstance();
//		 ht = dbPool.getConnection("133", -1);
//		 Connection conn = (Connection) ht.get("conn");
////		 ...处理自己的事情
//		 } catch (Exception ex) {
//		 } finally {
//		      try {
//		      dbPool.freeConnection("133", ht);//回收连接
//		     } catch (DBException e) {
//		     }
//		 }
//
//		return false;
//	}
	
//	public static Hashtable select(){
//		Hashtable ht = null;
//		try {
//			ConnectionPool dbPool = ConnectionPoolImpl.getInstance();
//			String sql0 = "";// SQL语句
//			Vector v0 = dbPool.doQuery("134", sql0);
//			ht = (Hashtable) v0.get(0);
//		} catch (Exception e) {
//		}
//		return ht;
//		
//	}

}
