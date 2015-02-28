package com.pinke.uni.mobile.protal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 计算文件的MD5
 */
public class MD5Two {
	/**
	 * 16进制数字
	 */
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	protected static MessageDigest messageDigest = null;
	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println(MD5Two.class.getName()
					+ "初始化失败，MessageDigest不支持MD5Util.");
			e.printStackTrace();
		}
	}

	/**
	 * MD加密信息
	 * 
	 * @param bsrc
	 * @return md5加密后的信息
	 */
	public final static String MD5Str(byte[] bsrc) {
		try {
			byte[] strTemp = bsrc;
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// System.out.println((int)b);
				// 将没个数(int)b进行双字节加密
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 计算文件的MD5
	 * 
	 * @param fileName
	 *            文件的绝对路径
	 * @return
	 * @throws IOException
	 */
	public static String getFileMD5String(String fileName) {
		File f = new File(fileName);
		try {
			return getFileMD5String(f);
		} catch (IOException e) {
			return "";
		}
	}

	/**
	 * 计算文件的MD5，重载方法
	 * 
	 * @param file
	 *            文件对象
	 * @return
	 * @throws IOException
	 */
	public static String getFileMD5String(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
				file.length());
		messageDigest.update(byteBuffer);
		return bufferToHex(messageDigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

}
