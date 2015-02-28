package com.pinke.uni.mobile.protal.common.dcache;

import java.io.Serializable;
import java.util.List;

//缓存对象
public class SeriObjDCache implements Serializable {

	private static final long serialVersionUID = 14047390074221815L;

	/**
	 * mem队列
	 */
	private List memlist;
	/**
	 * mem对象
	 */
	private int totalCount;

	/**
	 * mem对象
	 */
	private Object memObj;
	/**
	 * mem对象队列
	 */
	private Object[] memObjList;
	/**
	 * 二进制数组
	 */
	private byte[] memByte;

	public List getMemlist() {
		return memlist;
	}

	/**
	 * 设置mem队列
	 * 
	 * @param memlist
	 *            mem队列
	 */
	public void setMemlist(List memlist) {
		this.memlist = memlist;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Object getMemObj() {
		return memObj;
	}

	public void setMemObj(Object memObj) {
		this.memObj = memObj;
	}

	public Object[] getMemObjList() {
		return memObjList;
	}

	public void setMemObjList(Object[] memObjList) {
		this.memObjList = memObjList;
	}

	public byte[] getMemByte() {
		return memByte;
	}

	public void setMemByte(byte[] memByte) {
		this.memByte = memByte;
	}

}
