package com.pinke.uni.mobile.protal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.pinke.uni.mobile.protal.common.config.ConfigContent;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class SystemTools {
	private static Log log = SSBBus.getLog(SystemTools.class);

	/**
	 * ��ʼ����
	 * 
	 */
	public SystemTools() {
	}

	/**
	 * 增加���BYTE����
	 * 
	 * @param src
	 *            byte[] Դ源数组
	 * @param dest
	 *            byte[]目标数组
	 * @return 得到的数组
	 */
	public static byte[] ByteAdd(byte src[], byte dest[]) {
		int srcLen = src.length;
		int destLen = dest.length;
		byte bytes[] = new byte[srcLen + destLen];
		int i = 0;
		for (i = 0; i < srcLen; i++) {
			bytes[i] = src[i];

		}
		for (int n = i; n < srcLen + destLen; n++) {
			bytes[n] = dest[n - i];

		}
		return bytes;
	}

	public static String byteToString(byte src[], int beg, int end) {
		StringBuffer hs = new StringBuffer();
		char ch = '\0';
		for (int n = beg; n <= end; n++) {
			ch = (char) src[n];
			hs.append(ch);
		}

		return hs.toString();
	}

	public static Date getDate(String s) {
		Date date = null;
		if (s.length() == 14) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

			try {
				date = formatter.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (s.length() == 8) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			try {
				date = formatter.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (s.length() == 19) {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				date = formatter.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			log.error("传入错误的时间格式:" + s);
		}
		return date;
	}

	public static String byteToStringCh(byte src[], int beg, int end) {
		// String hs = "";
		// String tmp = "";
		byte[] btTmp = new byte[end - beg + 1];
		System.arraycopy(src, beg, btTmp, 0, end - beg + 1);
		/*
		 * char ch = '\0'; for (int n = beg; n <= end; n++) { ch = (char)
		 * src[n]; hs = hs + ch; }
		 */

		return new String(btTmp);
		// return hs;
	}

	public static byte[] byteToByte(byte src[], int beg, int end) {
		byte bytes[] = new byte[end - beg + 1];
		for (int i = beg; i <= end; i++) {
			bytes[i - beg] = src[i];
		}
		return bytes;
	}

	public static String getNow3() {
		Date d = new Date();
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		str = formatter.format(d);
		return str;
	}

	public static String getNowLog() {
		Date d = new Date();
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = formatter.format(d);
		return str;
	}

	public static String decode(String output) {
		try {
			return new String(output.getBytes("ISO-8859-1"), "GBK");
		} catch (Exception ex) {
			return "";
		}
	}

	public static String encode(String input) {
		try {
			return new String(input.getBytes("GBK"), "ISO-8859-1");
		} catch (Exception ex) {
			return "";
		}
	}

	private static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return " 0x" + hexDigits[d1] + hexDigits[d2] + " ";
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			result.append(byteToHexString(b[i]));
		return result.toString();
	}

	public static byte[] intToByte(int i) {
		byte bytes[] = new byte[4];
		bytes[3] = (byte) i;
		bytes[2] = (byte) (i >> 8);
		bytes[1] = (byte) (i >> 16);
		bytes[0] = (byte) (i >> 24);
		return bytes;
	}

	public static int byteToInt(byte bytes[]) {
		int i = 0;
		int len = bytes.length;
		for (int m = 0; m < len - 1; m++) {
			i += bytes[m] & 0xff;
			i <<= 8;
		}

		i += bytes[len - 1] & 0xff;
		return i;
	}

	public static int getStreamNo() {

		if (streamNo > 999999999) {
			streamNo = 0;
			return streamNo;
		}
		streamNo++;
		return streamNo;

	}

	/**
	 * 记录日志（16进制）
	 * 
	 * @param data
	 *            16进制字符数组
	 * @return String 转换后的字符串
	 */
	public static String hexlog(byte[] data) {
		/**
		 * 记录日志
		 */
		StringBuffer logmes = new StringBuffer();

		for (int i = 0; i < data.length; i++) {

			String temp = Integer.toHexString(data[i] & 0xff);

			if (temp.length() == 1) {
				logmes.append("0");
			}
			logmes.append(temp).append(" ");
		}

		return logmes.toString();
	}

	/**
	 * 获得32位唯一序列号
	 * 
	 * @return String
	 */
	public static String getUUID_32() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 获得当前时间
	 * 
	 * @return String 获得当前时间的字符串变量，如"20030114101211"
	 */
	public static String getNow() {
		Date d = new Date();
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		str = formatter.format(d);
		return str;
	}

	/**
	 * 连接两字符串数组
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public static String[] stringAddString(String[] src, String[] dest) {
		int srcLen = src.length;
		int destLen = dest.length;
		String[] res = new String[srcLen + destLen];
		int i = 0;
		for (i = 0; i < srcLen; i++) {
			res[i] = src[i];
		}
		for (int n = i; n < srcLen + destLen; n++) {
			res[n] = dest[n - i];
		}
		return res;
	}

	/**
	 * 静态方法,获得某一日期的前n天的日期
	 * 
	 * @param date
	 *            既定日期,以此日期为基准进行查询.格式为"yyyyMMddhhmmss"
	 * @param n
	 *            在给定日期上加或减的天数.当n为正值时,将获得将来第n天的日期, 当n为负值时,将获得过去n天前的日期
	 * @return String字符串,格式为"yyyyMMdd"
	 */
	public static String getPreviousDate(String date, int n) {
		String str = "";

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
			formatter.parse(date);
			Calendar tempCal = formatter.getCalendar();
			tempCal.add(Calendar.DATE, n);
			str = formatter.format(tempCal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * Creates a 16bit byte array from a 16bit character
	 * 
	 * @param cChar
	 *            Character to convert
	 */
	public static final byte[] charToByteArray(char cChar) {
		return new byte[] { (byte) ((cChar >> 8) & 0xff),
				(byte) ((cChar >> 0) & 0xff), };
	}

	/**
	 * Creates an 8bit byte array from a boolean
	 * 
	 * @param bBoolean
	 *            Boolean to convert
	 */
	public static final byte[] booleanToByteArray(boolean bBoolean) {
		return new byte[] { (byte) (bBoolean ? 0x01 : 0x00) };
	}

	/**
	 * Creates a 32bit byte array from an integer
	 * 
	 * @param int32
	 *            Integer to convert
	 */
	public static final byte[] intToByteArray(int int32) {
		return new byte[] { (byte) ((int32 >> 24) & 0xff),
				(byte) ((int32 >> 16) & 0xff), (byte) ((int32 >> 8) & 0xff),
				(byte) ((int32 >> 0) & 0xff), };
	}

	/**
	 * Creates a 32bit byte array from a float
	 * 
	 * @param fInt32
	 *            Float to convert
	 */
	public static final byte[] floatToByteArray(float fInt32) {
		return intToByteArray(Float.floatToRawIntBits(fInt32));
	}

	/**
	 * Creates a 64bit byte array from a long
	 * 
	 * @param int64
	 *            Long to convert
	 */
	public static final byte[] longToByteArray(long int64) {
		return new byte[] { (byte) ((int64 >> 56) & 0xff),
				(byte) ((int64 >> 48) & 0xff), (byte) ((int64 >> 40) & 0xff),
				(byte) ((int64 >> 32) & 0xff), (byte) ((int64 >> 24) & 0xff),
				(byte) ((int64 >> 16) & 0xff), (byte) ((int64 >> 8) & 0xff),
				(byte) ((int64 >> 0) & 0xff) };
	}

	/**
	 * Creates a 64bit byte array from a double
	 * 
	 * @param fInt64
	 *            Double to convert
	 */
	public static final byte[] doubleToByteArray(double fInt64) {
		return longToByteArray(Double.doubleToRawLongBits(fInt64));
	}

	/**
	 * Creates a byte array from a String
	 * 
	 * @param sString
	 *            String to convert
	 */
	public static final byte[] stringToByteArray(String sString) {
		return (sString == null) ? null : sString.getBytes();
	}

	/**
	 * Creates a Char from a byte array
	 * 
	 * @param byteArray
	 *            Array of bytes to convert
	 */
	public static final char byteArrayToChar(byte[] byteArray) {
		return (char) ((0xff & byteArray[0]) << 8 | (0xff & byteArray[1]) << 0);
	}

	/**
	 * Creates a Char array from a byte array
	 * 
	 * @param byteArray
	 *            Array of bytes to convert
	 */
	public static final char[] byteArrayToCharArray(byte[] byteArray) {
		final int size = byteArray.length / 2;
		final char[] charArray = new char[size];
		byte[] tmpArray;
		for (int s = 0; s < size; s++) {
			tmpArray = SystemTools.getSubByteArray(byteArray, s * 2,
					(s + 1) * 2);
			charArray[s] = byteArrayToChar(tmpArray);
		}
		return charArray;
	}

	/**
	 * Creates a byte array from a Char array
	 * 
	 * @param charArray
	 *            Array of characters to convert
	 */
	public static final byte[] charArrayToByteArray(char[] charArray) {
		byte[] byteArray = new byte[charArray.length * 2];
		byte[] tmpArray;
		for (int s = 0; s < charArray.length; s++) {
			tmpArray = SystemTools.charToByteArray(charArray[s]);
			byteArray = SystemTools.appendToByteArray(byteArray, tmpArray,
					s * 2);
		}
		return byteArray;
	}

	public static final short byteArrayToShort(byte[] byteArray, int offset) {
		return (short) ((0xff & byteArray[offset]) << 8 | (0xff & byteArray[offset + 1]) << 0);
	}

	/**
	 * Creates an Integer from a byte array
	 * 
	 * @param byteArray
	 *            Byte array to convert
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final int byteArrayToInt(byte[] byteArray, int offset) {
		return (0xff & byteArray[offset]) << 24
				| (0xff & byteArray[offset + 1]) << 16
				| (0xff & byteArray[offset + 2]) << 8
				| (0xff & byteArray[offset + 3]) << 0;
	}

	/**
	 * Creates a float from a byte array
	 * 
	 * @param byteArray
	 *            Byte array to convert
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final float byteArrayToFloat(byte[] byteArray, int offset) {
		return Float.intBitsToFloat(byteArrayToInt(byteArray, offset));
	}

	/**
	 * Creates a long from a byte array(有问题)
	 * 
	 * @param byteArray
	 *            Byte array to convert
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final long byteArrayToLong(byte[] byteArray, int offset) {
		return (0xff & byteArray[offset]) << 56
				| (0xff & byteArray[offset + 1]) << 48
				| (0xff & byteArray[offset + 2]) << 40
				| (0xff & byteArray[offset + 3]) << 32
				| (0xff & byteArray[offset + 4]) << 24
				| (0xff & byteArray[offset + 5]) << 16
				| (0xff & byteArray[offset + 6]) << 8
				| (0xff & byteArray[offset + 7]) << 0;
	}

	// 改进版
	public static long byteTolong(byte bytes[]) {
		long i = 0;
		int len = bytes.length;
		for (int m = 0; m < len - 1; m++) {
			i += bytes[m] & 0xff;
			i <<= 8;
		}

		i += bytes[len - 1] & 0xff;
		return i;
	}

	/**
	 * Creates a double from a byte array
	 * 
	 * @param byteArray
	 *            Byte array to convert
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final double byteArrayToDouble(byte[] byteArray, int offset) {
		return Double.longBitsToDouble(byteArrayToLong(byteArray, offset));
	}

	/**
	 * Creates a String from a byte array
	 * 
	 * @param byteArray
	 *            Byte array to convert
	 */
	public static final String byteArrayToString(byte[] byteArray) {
		return new String(byteArray);
	}

	/**
	 * Adds a byte array to another byte array
	 * 
	 * @param dArray
	 *            Array to append to
	 * @param sArray
	 *            Array to append
	 * @param offset
	 *            Offset to start appending
	 */
	public static final byte[] appendToByteArray(byte[] dArray, byte[] sArray,
			int offset) {
		for (int i = 0; i < sArray.length; i++)
			dArray[offset + i] = sArray[i];
		return dArray;
	}

	/**
	 * Adds a byte array to the end of a byte array
	 * 
	 * @param dArray
	 *            Byte array to append to
	 * @param sArray
	 *            Byte array to append
	 */
	public static final byte[] appendToByteArray(byte[] dArray, byte[] sArray) {
		final int endOfArray = dArray.length;
		if (endOfArray < endOfArray + sArray.length)
			dArray = expandByteArray(dArray, sArray.length);
		for (int i = 0; i < sArray.length; i++)
			dArray[endOfArray + i] = sArray[i];
		return dArray;
	}

	/**
	 * Returns a byte array from another byte array
	 * 
	 * @param byteArray
	 *            Byte array to parse
	 * @param offset_START
	 *            Starting location
	 * @param offset_END
	 *            Ending location
	 */
	public static final byte[] getSubByteArray(byte[] byteArray,
			int offset_START, int offset_END) {
		final byte[] byteBuffer = new byte[offset_END - offset_START];
		for (int i = offset_START; i < offset_END; i++)
			byteBuffer[i - offset_START] = byteArray[i];
		return byteBuffer;
	}

	/**
	 * Extends the maximum size of a byte array
	 * 
	 * @param byteArray
	 *            Byte array to expand
	 * @param appendLength
	 *            Size to extend array
	 * @return
	 */
	public static final byte[] expandByteArray(byte[] byteArray,
			int appendLength) {
		final byte[] cArray = byteArray.clone();
		byteArray = new byte[cArray.length + appendLength];
		for (int i = 0; i < cArray.length; i++)
			byteArray[i] = cArray[i];
		return byteArray;
	}

	/**
	 * Converts a String to an array of Char
	 * 
	 * @param sVal
	 *            String to convert
	 */
	public static final char[] stringToCharArray(String sVal) {
		return sVal.toCharArray();
	}

	/**
	 * Converts an array of Char to a String
	 * 
	 * @param charArray
	 *            Array of Chars to convert
	 */
	public static final String charArrayToString(char[] charArray) {
		return new String(charArray);
	}

	/**
	 * Converts an Integer to a 4byte String
	 * 
	 * @param val
	 *            Integer to convert
	 */
	public static final String appendIntegerToString(int val) {
		final byte[] comCode = SystemTools.intToByteArray(val);
		final char[] chrCode = SystemTools.byteArrayToCharArray(comCode);
		return SystemTools.charArrayToString(chrCode);
	}

	/**
	 * Converts a float to a 4byte String
	 * 
	 * @param val
	 *            float to convert
	 */
	public static final String appendFloatToString(float val) {
		final byte[] comCode = SystemTools.floatToByteArray(val);
		final char[] chrCode = SystemTools.byteArrayToCharArray(comCode);
		return SystemTools.charArrayToString(chrCode);
	}

	/**
	 * Returns an Integer from a String
	 * 
	 * @param val
	 *            String to parse
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final int getIntFromString(String val, int offset) {
		final char[] chrCode = new char[CHARSIZE];
		final byte[] comCode;

		val.getChars(offset, offset + CHARSIZE, chrCode, 0);
		comCode = SystemTools.charArrayToByteArray(chrCode);
		return SystemTools.byteArrayToInt(comCode, 0);
	}

	/**
	 * Returns a float from a String
	 * 
	 * @param val
	 *            String to parse
	 * @param offset
	 *            Offset to start parsing
	 */
	public static final float getFloatFromString(String val, int offset) {
		final char[] chrCode = new char[CHARSIZE];
		final byte[] comCode;

		val.getChars(offset, offset + CHARSIZE, chrCode, 0);
		comCode = SystemTools.charArrayToByteArray(chrCode);
		return SystemTools.byteArrayToFloat(comCode, 0);
	}

	public static final byte[] objectToByteArray(Object obj) {
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			bos.close();
			final byte[] data = bos.toByteArray();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final Object byteArrayToObject(byte[] bytes) {
		final Object object;
		try {
			object = new ObjectInputStream(new ByteArrayInputStream(bytes))
					.readObject();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 读取文件成字节流
	 * 
	 * @param url
	 *            文件路径
	 * @return
	 */
	public static byte[] readFileToByte(String url) {

		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		byte[] data = null;
		File file = new File(url);
		if (!file.isFile()) {
			String iconname = "";
			// 找不到图片时采取默认图片，此时默认图片根据需要获取的图片来匹配
			String[] params = getURLParams(url);
			if (params != null && params.length == 2) {
				String[] names = params[0].split("\\.");
				if (params[0].contains("figure")) {// 为截图时取不到图片则传空数组
					return new byte[] {};
				}
				if (names.length == 2) {
					iconname = names[0] + ".png";
				} else {
					iconname = "default.png";
				}
			} else {
				iconname = "default.png";
			}
			url = ConfigContent.getXmlconfig().getImageDefaultUrl() + iconname;
			file = new File(url);
			if (!file.exists()) {
				if (params.length == 2) {
					if (params[0].contains("small")) {
						iconname = "small.png";
					} else if (params[0].contains("middle")) {
						iconname = "middle.png";
					}
					if (params[0].contains("large")) {
						iconname = "large.png";
					} else {
						iconname = "middle.png";
					}
				}
				url = ConfigContent.getXmlconfig().getImageDefaultUrl()
						+ iconname;
				file = new File(url);
				if (!file.exists()) {
					url = ConfigContent.getXmlconfig().getImageDefaultUrl()
							+ "default.png";
				}
			}
		}

		if (url != null && url.trim().length() != 0) {
			try {
				fis = new FileInputStream(new File(url));
				baos = new ByteArrayOutputStream();
				byte[] buff = new byte[1024];
				int rc = 0;
				while ((rc = fis.read(buff, 0, 1024)) > 0) {
					baos.write(buff, 0, rc);
				}
				data = new byte[baos.size()];
				System.arraycopy(baos.toByteArray(), 0, data, 0, baos.size());
				return data;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (baos != null) {
						baos.reset();
						baos.close();
					}
					if (fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return new byte[0];
	}

	/**
	 * 解析图片路径
	 * 
	 * @param url
	 * @return[名字，目录]
	 */
	public static String[] getURLParams(String url) {
		String[] params = new String[] { "default.jpg", "" };
		if (url != null) {
			int i = url.lastIndexOf("/");
			if (i > 0) {
				params[1] = url.substring(0, i + 1);
				params[0] = url.substring(i + 1);
			}
		}
		return params;
	}

	public static final int CHARSIZE = 2;

	private static int streamNo = 0;

	// public static void main(String[] args) {
	// // System.out.println(readFileToByte("/opt/commsoft/s.gif"));
	// //System.out.println("name:"+getURLParams("opt/commsoft/s.gif")[0]+",目录："+getURLParams("opt/commsoft/s.gif")[1]);
	//
	// byte[] data = readFileToByte("D:/myself/asdf6511asdf97/");
	// try {
	// FileOutputStream fos = new FileOutputStream(new
	// File("d:/Dangerous1.jpg"));
	// fos.write(data);
	// fos.flush();
	// fos.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
}
