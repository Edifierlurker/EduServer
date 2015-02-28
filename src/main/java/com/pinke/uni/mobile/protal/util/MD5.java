package com.pinke.uni.mobile.protal.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Decoder;

public class MD5 {
	public MD5() {
		sourceStr = new byte[2048];
		destStr = new byte[16];
	}

	public MD5(byte str[]) {
		sourceStr = new byte[2048];
		destStr = new byte[16];
		sourceStr = str;
	}

	/**
	 * 
	 * @return byte[]
	 */
	public byte[] getSourceStr() {
		return sourceStr;
	}

	/**
	 * 
	 * @param sourceStr
	 *            byte[]
	 */
	public void setSourceStr(byte sourceStr[]) {
		this.sourceStr = sourceStr;
	}

	/**
	 * 
	 * @return byte[]
	 */
	public byte[] getDestStr() {
		return destStr;
	}

	/**
	 * 
	 * @param destStr
	 *            byte[]
	 */
	public void setDestStr(byte destStr[]) {
		this.destStr = destStr;
	}

	/**
	 * MD5
	 * 
	 * @throws NoSuchAlgorithmException
	 * @return boolean
	 */
	public boolean md5Start() throws NoSuchAlgorithmException {
		boolean over = true;
		try {
			MessageDigest alg = MessageDigest.getInstance("MD5");
			alg.update(sourceStr);
			destStr = alg.digest();
		} catch (NoSuchAlgorithmException nsae) {
			over = false;
		}
		return over;
	}

	/**
	 * @param str
	 *            String
	 * @return byte[]
	 */
	public byte[] getDigest(String str) {
		sourceStr = str.getBytes();
		try {
			md5Start();
		} catch (Exception e) {
		}
		return destStr;
	}

	/**
	 * 
	 * @param str
	 *            byte[]
	 * @return byte[]
	 */
	public byte[] getDigest(byte str[]) {
		sourceStr = str;
		try {
			md5Start();
		} catch (Exception e) {
		}
		return destStr;
	}

	private byte sourceStr[];
	private byte destStr[];

	/**
	 * @param b
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			result.append(byteToHexString(b[i]));
		return result.toString();
	}

	/**
	 * @param b
	 * @return
	 */
	public static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F" };

	public static String getBASE64(byte[] s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s);
	}

	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// String mdrStr="123456";
		// System.out.println("mdrStr:"+mdrStr);
		// MD5 d= new MD5();
		// byte[] re = null;
		// try {
		// re = d.getDigest(mdrStr.getBytes("utf-8"));
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// String signTmpStr=MD5.byteArrayToHexString(re).toLowerCase();
		// System.out.println(signTmpStr);
	}
}
