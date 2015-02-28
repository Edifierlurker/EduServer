package com.pinke.uni.mobile.protal.common.service;


/**
 * 字节数据处理器类
 * @ClassName: ByteProcess 
 * @Description: 字节数据处理器
 */
public class ByteProcess
{

    /**
     * 从一个16位的字符创建一个16位的字节数组
     * Creates a 16bit byte array from a 16bit character
     * 
     * @param cChar
     *            Character to convert
     */
    public static final byte[] charToByteArray(char cChar)
    {
        return new byte[]{(byte) ((cChar >> 8) & 0xff), (byte) ((cChar >> 0) & 0xff),};
    }

    /**
     * 从布尔型创建一个8位的字节数组
     * Creates an 8bit byte array from a boolean
     * 
     * @param bBoolean
     *            Boolean to convert
     */
    public static final byte[] booleanToByteArray(boolean bBoolean)
    {
        return new byte[]{(byte) (bBoolean ? 0x01 : 0x00)};
    }

    /**
     * 从整型创建一个32位的字节数组
     * Creates a 32bit byte array from an integer
     * 
     * @param int32
     *            Integer to convert
     */
    public static final byte[] intToByteArray(int int32)
    {
        return new byte[]{(byte) ((int32 >> 24) & 0xff), (byte) ((int32 >> 16) & 0xff), (byte) ((int32 >> 8) & 0xff),
            (byte) ((int32 >> 0) & 0xff),};
    }

    /**
     * 从长整型创建一个64位的字节数组
     * Creates a 64bit byte array from a long
     * 
     * @param int64
     *            Long to convert
     */
    public static final byte[] longToByteArray(long int64)
    {
        return new byte[]{(byte) ((int64 >> 56) & 0xff), (byte) ((int64 >> 48) & 0xff), (byte) ((int64 >> 40) & 0xff),
            (byte) ((int64 >> 32) & 0xff), (byte) ((int64 >> 24) & 0xff), (byte) ((int64 >> 16) & 0xff),
            (byte) ((int64 >> 8) & 0xff), (byte) ((int64 >> 0) & 0xff)};
    }

    /**
     * 从字符串创建一个字节数组
     * Creates a byte array from a String
     * 
     * @param sString
     *            String to convert
     */
    public static final byte[] stringToByteArray(String sString)
    {
        return (sString == null) ? null : sString.getBytes();
    }

    /**
     * 将字节数组转换为字符
     * Creates a Char from a byte array
     * 
     * @param byteArray
     *            Array of bytes to convert
     */
    public static final char byteArrayToChar(byte[] byteArray)
    {
        return (char) ((0xff & byteArray[0]) << 8 | (0xff & byteArray[1]) << 0);
    }

    /**
     * 将字节数组转换为字符数组
     * Creates a Char array from a byte array
     * 
     * @param byteArray
     *            Array of bytes to convert
     */
    public static final char[] byteArrayToCharArray(byte[] byteArray)
    {
        final int size = byteArray.length / 2;
        final char[] charArray = new char[size];
        byte[] tmpArray;
        for (int s = 0; s < size; s++)
        {
            tmpArray = ByteProcess.getSubByteArray(byteArray, s * 2, (s + 1) * 2);
            charArray[s] = byteArrayToChar(tmpArray);
        }
        return charArray;
    }

    /**
     * 将字符数组转换为字节数组
     * Creates a byte array from a Char array
     * 
     * @param charArray
     *            Array of characters to convert
     */
    public static final byte[] charArrayToByteArray(char[] charArray)
    {
        byte[] byteArray = new byte[charArray.length * 2];
        byte[] tmpArray;
        for (int s = 0; s < charArray.length; s++)
        {
            tmpArray = ByteProcess.charToByteArray(charArray[s]);
            byteArray = ByteProcess.appendToByteArray(byteArray, tmpArray, s * 2);
        }
        return byteArray;
    }

    /**
     * byteArrayToShort
     * @Description: 将字节数组转换为短整型
     * @param byteArray
     * @param offset
     * @return
     */
    public static final short byteArrayToShort(byte[] byteArray, int offset)
    {
        return (short) ((0xff & byteArray[offset]) << 8 | (0xff & byteArray[offset + 1]) << 0);
    }

    /**
     * 将字节数组转换为整型
     * Creates an Integer from a byte array
     * 
     * @param byteArray
     *            Byte array to convert
     * @param offset
     *            Offset to start parsing
     */
    public static final int byteArrayToInt(byte[] byteArray, int offset)
    {
        return (0xff & byteArray[offset]) << 24 | (0xff & byteArray[offset + 1]) << 16
            | (0xff & byteArray[offset + 2]) << 8 | (0xff & byteArray[offset + 3]) << 0;
    }

    /**
     * 将字节数组转换为长整型
     * Creates a long from a byte array
     * 
     * @param byteArray
     *            Byte array to convert
     * @param offset
     *            Offset to start parsing
     */
    public static final long byteArrayToLong(byte[] byteArray, int offset)
    {
        // return (0xff & byteArray[offset]) << 56 | (0xff & byteArray[offset +
        // 1]) << 48 | (0xff & byteArray[offset + 2]) << 40 | (0xff &
        // byteArray[offset + 3]) << 32
        // | (0xff & byteArray[offset + 4]) << 24 | (0xff & byteArray[offset +
        // 5]) << 16 | (0xff & byteArray[offset + 6]) << 8 | (0xff &
        // byteArray[offset + 7]) << 0;
        long i = 0;
        int len = byteArray.length;
        for (int m = 0; m < len - 1; m++)
        {
            i += byteArray[m] & 0xff;
            i <<= 8;
        }

        i += byteArray[len - 1] & 0xff;
        return i;

    }

    /**
     * 将字节数组转换为字符串
     * Creates a String from a byte array
     * 
     * @param byteArray
     *            Byte array to convert
     */
    public static final String byteArrayToString(byte[] byteArray)
    {
        return new String(byteArray);
    }

    /**
     * 将一个字节数组加到另一个字节数组中
     * Adds a byte array to another byte array
     * 
     * @param dArray
     *            Array to append to
     * @param sArray
     *            Array to append
     * @param offset
     *            Offset to start appending
     */
    public static final byte[] appendToByteArray(byte[] dArray, byte[] sArray, int offset)
    {
        for (int i = 0; i < sArray.length; i++)
            dArray[offset + i] = sArray[i];
        return dArray;
    }

    /**
     * 从一个字节数组中创建一个子字节数组
     * Returns a byte array from another byte array
     * 
     * @param byteArray
     *            Byte array to parse
     * @param offset_START
     *            Starting location
     * @param offset_END
     *            Ending location
     */
    public static final byte[] getSubByteArray(byte[] byteArray, int offset_START, int offset_END)
    {
        final byte[] byteBuffer = new byte[offset_END - offset_START];
        for (int i = offset_START; i < offset_END; i++)
            byteBuffer[i - offset_START] = byteArray[i];
        return byteBuffer;
    }

    /**
     * 比较两个字节数组
     * Compares to byte arrays
     * 
     * @param array1
     *            Array 1
     * @param array2
     *            Array 2
     */
    public static final boolean compareByteArray(byte[] array1, byte[] array2)
    {
        if (array1.equals(array2))
            return true;
        else
            return false;
    }

    /**
     * 将字符串转化为字符数组
     * Converts a String to an array of Char
     * 
     * @param sVal
     *            String to convert
     */
    public static final char[] stringToCharArray(String sVal)
    {
        return sVal.toCharArray();
    }

    /**
     * 将字符串转换为整型
     * Returns an Integer from a String
     * 
     * @param val
     *            String to parse
     * @param offset
     *            Offset to start parsing
     */
    public static final int getIntFromString(String val, int offset)
    {
        final char[] chrCode = new char[CHARSIZE];
        final byte[] comCode;

        val.getChars(offset, offset + CHARSIZE, chrCode, 0);
        comCode = ByteProcess.charArrayToByteArray(chrCode);
        return ByteProcess.byteArrayToInt(comCode, 0);
    }

    /** 字符长度 */
    public static final int CHARSIZE = 2;

    public void _finalize()
    {

    }
}
