package com.pinke.uni.mobile.protal.common.message;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.pinke.uni.mobile.protal.util.SystemTools;


public class TableInfo {

	private String tableName;
	
	private int rows;
	
	private List<ValueObj> list;

	public TableInfo(int rows, String tableName) {
		super();
		this.rows = rows;
		this.tableName = tableName;
		list = new ArrayList<ValueObj>(rows);
	}
	
	public void addElement(ValueObj obj){
		list.add(obj);
	}

	public List<ValueObj> getList() {
		return list;
	}
	
	public byte[] getByte(){
		byte[] res = null;
		
		try {
			byte[] tablenamevalue_byte = tableName.getBytes("utf-8");
			byte[] tablenamevaluesize_byte = SystemTools.intToByte(tablenamevalue_byte.length);
			byte[] rows_byte = SystemTools.intToByte(rows);
			
			res = SystemTools.ByteAdd(tablenamevaluesize_byte, tablenamevalue_byte);
			res = SystemTools.ByteAdd(res, rows_byte);
			for(int i=0;i<list.size();i++){
				ValueObj vo = list.get(i);
				byte[] vo_byte = vo.getByte();
				res = SystemTools.ByteAdd(res, vo_byte);
			}
			
			return res;
		} catch (UnsupportedEncodingException e) {
		}
		
		return null;
	}
}
