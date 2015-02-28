package com.pinke.uni.mobile.protal.common.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;

public class ByteInterpreter {
	 public static final int CHARSIZE = 2;

	  public static final byte[] charToByteArray(char cChar)
	  {
	    return new byte[] { 
	      (byte)(cChar >> '\b' & 0xFF), 
	      (byte)(cChar >> '\000' & 0xFF) };
	  }

	  public static final byte[] booleanToByteArray(boolean bBoolean)
	  {
	    return new byte[] { (byte)(bBoolean ? 1 : 0) };
	  }

	  public static final byte[] intToByteArray(int int32)
	  {
	    return new byte[] { 
	      (byte)(int32 >> 24 & 0xFF), 
	      (byte)(int32 >> 16 & 0xFF), 
	      (byte)(int32 >> 8 & 0xFF), 
	      (byte)(int32 >> 0 & 0xFF) };
	  }

	  public static final byte[] floatToByteArray(float fInt32)
	  {
	    return intToByteArray(Float.floatToRawIntBits(fInt32));
	  }

	  public static final byte[] longToByteArray(long int64)
	  {
	    return new byte[] { 
	      (byte)(int)(int64 >> 56 & 0xFF), 
	      (byte)(int)(int64 >> 48 & 0xFF), 
	      (byte)(int)(int64 >> 40 & 0xFF), 
	      (byte)(int)(int64 >> 32 & 0xFF), 
	      (byte)(int)(int64 >> 24 & 0xFF), 
	      (byte)(int)(int64 >> 16 & 0xFF), 
	      (byte)(int)(int64 >> 8 & 0xFF), 
	      (byte)(int)(int64 >> 0 & 0xFF) };
	  }

	  public static final byte[] doubleToByteArray(double fInt64)
	  {
	    return longToByteArray(Double.doubleToRawLongBits(fInt64));
	  }

	  public static final byte[] stringToByteArray(String sString)
	  {
	    return sString == null ? null : sString.getBytes();
	  }

	  public static final char byteArrayToChar(byte[] byteArray)
	  {
	    return (char)((0xFF & byteArray[0]) << 8 | (0xFF & byteArray[1]) << 0);
	  }

	  public static final char[] byteArrayToCharArray(byte[] byteArray)
	  {
	    int size = byteArray.length / 2;
	    char[] charArray = new char[size];

	    for (int s = 0; s < size; s++)
	    {
	      byte[] tmpArray = getSubByteArray(byteArray, s * 2, (s + 1) * 2);
	      charArray[s] = byteArrayToChar(tmpArray);
	    }
	    return charArray;
	  }

	  public static final byte[] charArrayToByteArray(char[] charArray)
	  {
	    byte[] byteArray = new byte[charArray.length * 2];

	    for (int s = 0; s < charArray.length; s++)
	    {
	      byte[] tmpArray = charToByteArray(charArray[s]);
	      byteArray = appendToByteArray(byteArray, tmpArray, s * 2);
	    }
	    return byteArray;
	  }

	  public static final short byteArrayToShort(byte[] byteArray, int offset) {
	    return 
	      (short)((0xFF & byteArray[offset]) << 8 | 
	      (0xFF & byteArray[(offset + 1)]) << 0);
	  }

	  public static final int byteArrayToInt(byte[] byteArray, int offset)
	  {
	    return (0xFF & byteArray[offset]) << 24 | (0xFF & byteArray[(offset + 1)]) << 16 | (0xFF & byteArray[(offset + 2)]) << 8 | (0xFF & byteArray[(offset + 3)]) << 0;
	  }

	  public static final float byteArrayToFloat(byte[] byteArray, int offset)
	  {
	    return Float.intBitsToFloat(byteArrayToInt(byteArray, offset));
	  }

	  public static final long byteArrayToLong(byte[] byteArray, int offset)
	  {
	    return 
	      (0xFF & byteArray[offset]) << 56 | 
	      (0xFF & byteArray[(offset + 1)]) << 48 | 
	      (0xFF & byteArray[(offset + 2)]) << 40 | 
	      (0xFF & byteArray[(offset + 3)]) << 32 | 
	      (0xFF & byteArray[(offset + 4)]) << 24 | 
	      (0xFF & byteArray[(offset + 5)]) << 16 | 
	      (0xFF & byteArray[(offset + 6)]) << 8 | 
	      (0xFF & byteArray[(offset + 7)]) << 0;
	  }

	  public static long byteTolong(byte[] bytes) {
	    long i = 0L;
	    int len = bytes.length;
	    for (int m = 0; m < len - 1; m++) {
	      i += (bytes[m] & 0xFF);
	      i <<= 8;
	    }

	    i += (bytes[(len - 1)] & 0xFF);
	    return i;
	  }

	  public static final double byteArrayToDouble(byte[] byteArray, int offset)
	  {
	    return Double.longBitsToDouble(byteArrayToLong(byteArray, offset));
	  }

	  public static final String byteArrayToString(byte[] byteArray)
	    throws UnsupportedEncodingException
	  {
	    return new String(byteArray, "utf-8");
	  }

	  public static final byte[] appendToByteArray(byte[] dArray, byte[] sArray, int offset)
	  {
	    for (int i = 0; i < sArray.length; i++)
	      dArray[(offset + i)] = sArray[i];
	    return dArray;
	  }

	  public static final byte[] appendToByteArray(byte[] dArray, byte[] sArray)
	  {
	    int endOfArray = dArray.length;
	    if (endOfArray < endOfArray + sArray.length)
	      dArray = expandByteArray(dArray, sArray.length);
	    for (int i = 0; i < sArray.length; i++)
	      dArray[(endOfArray + i)] = sArray[i];
	    return dArray;
	  }

	  public static final byte[] getSubByteArray(byte[] byteArray, int offset_START, int offset_END)
	  {
	    byte[] byteBuffer = new byte[offset_END - offset_START];
	    for (int i = offset_START; i < offset_END; i++)
	      byteBuffer[(i - offset_START)] = byteArray[i];
	    return byteBuffer;
	  }

	  public static final byte[] expandByteArray(byte[] byteArray, int appendLength)
	  {
	    byte[] cArray = (byte[])byteArray.clone();
	    byteArray = new byte[cArray.length + appendLength];
	    for (int i = 0; i < cArray.length; i++)
	      byteArray[i] = cArray[i];
	    return byteArray;
	  }

	  public static final boolean compareByteArray(byte[] array1, byte[] array2)
	  {
	    return array1.equals(array2);
	  }

	  public static final char[] stringToCharArray(String sVal)
	  {
	    return sVal.toCharArray();
	  }

	  public static final String charArrayToString(char[] charArray)
	  {
	    return new String(charArray);
	  }

	  public static final String appendIntegerToString(int val)
	  {
	    byte[] comCode = intToByteArray(val);
	    char[] chrCode = byteArrayToCharArray(comCode);
	    return charArrayToString(chrCode);
	  }

	  public static final String appendFloatToString(float val)
	  {
	    byte[] comCode = floatToByteArray(val);
	    char[] chrCode = byteArrayToCharArray(comCode);
	    return charArrayToString(chrCode);
	  }

	  public static final int getIntFromString(String val, int offset)
	  {
	    char[] chrCode = new char[2];

	    val.getChars(offset, offset + 2, chrCode, 0);
	    byte[] comCode = charArrayToByteArray(chrCode);
	    return byteArrayToInt(comCode, 0);
	  }

	  public static final float getFloatFromString(String val, int offset)
	  {
	    char[] chrCode = new char[2];

	    val.getChars(offset, offset + 2, chrCode, 0);
	    byte[] comCode = charArrayToByteArray(chrCode);
	    return byteArrayToFloat(comCode, 0);
	  }

	  public static final byte[] ObjectToByteArray(Object obj)
	  {
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    try
	    {
	      ObjectOutputStream oos = new ObjectOutputStream(bos);
	      oos.writeObject(obj);
	      oos.flush();
	      oos.close();
	      bos.close();
	      byte[] data = bos.toByteArray();
	      return data;
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }

	  public static final Object byteArrayToObject(byte[] bytes)
	  {
	    try
	    {
	      Object object = new ObjectInputStream(
	        new ByteArrayInputStream(bytes)).readObject();
	      return object;
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }return null;
	  }
}
