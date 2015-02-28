package com.pinke.uni.mobile.protal.common.message;

import com.pinke.uni.mobile.protal.util.SystemTools;
/**
 * 组装字节数组工具类
 * @author zte
 *
 */
public class MsgUtil {
	
	public static byte[] bytesForInt(String elementName,int elementValue)throws Exception{
		byte[] enamesize = SystemTools.intToByte(elementName.length());
		byte[] ename = elementName.getBytes("utf-8");
		byte[] evalue = SystemTools.intToByte(elementValue);
		byte[] evaluesize_value = SystemTools.intToByte(evalue.length);
		
		byte[] res = SystemTools.ByteAdd(enamesize,ename);
		res = SystemTools.ByteAdd(res,evaluesize_value);
		res = SystemTools.ByteAdd(res,evalue);
		return res;
	}
	
	public static byte[] bytesForString(String elementName,String elementValue)throws Exception{
		byte[] enamesize = SystemTools.intToByte(elementName.length());
		byte[] ename = elementName.getBytes("utf-8");
		byte[] evalue = elementValue.getBytes("utf-8");
		byte[] evaluesize_value = SystemTools.intToByte(evalue.length);
		
		byte[] res = SystemTools.ByteAdd(enamesize,ename);
		res = SystemTools.ByteAdd(res,evaluesize_value);
		res = SystemTools.ByteAdd(res,evalue);
		return res;
	}
	
	public static byte[] bytesForLong(String elementName,long elementValue)throws Exception{
		byte[] enamesize = SystemTools.intToByte(elementName.length());
		byte[] ename = elementName.getBytes("utf-8");
		byte[] evalue = SystemTools.longToByteArray(elementValue);
		byte[] evaluesize_value = SystemTools.intToByte(evalue.length);
		
		byte[] res = SystemTools.ByteAdd(enamesize,ename);
		res = SystemTools.ByteAdd(res,evaluesize_value);
		res = SystemTools.ByteAdd(res,evalue);
		return res;
	}
	
	public static byte[] bytesForByte(String elementName,byte elementValue)throws Exception{
		byte[] enamesize = SystemTools.intToByte(elementName.length());
		byte[] ename = elementName.getBytes("utf-8");
		byte[] evalue = new byte[] { elementValue };
		byte[] evaluesize_value = SystemTools.intToByte(evalue.length);
		
		byte[] res = SystemTools.ByteAdd(enamesize,ename);
		res = SystemTools.ByteAdd(res,evaluesize_value);
		res = SystemTools.ByteAdd(res,evalue);
		
		return res;
	}
	
	public static byte[] resdata(int elementValue)throws Exception{
		byte[] evalue = SystemTools.intToByte(elementValue);
		byte[] evaluesize_value = SystemTools.intToByte(evalue.length);
		
		byte[] res = SystemTools.ByteAdd(evaluesize_value,evalue);
		return res;
	}
}
