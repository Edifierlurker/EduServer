package com.pinke.uni.mobile.protal.common.service;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * 列数据
 * @ClassName: WoColumnData 
 * @Description: 列数据
 */
public class WoColumnData
{

    /**
     * parser
     * @Description: 将数据输入流解析为WoColumnData
     * @param bis
     * @return
     * @throws IOException
     */
    static public WoColumnData parser(DataInputStream bis) throws IOException
    {
        WoColumnData column = new WoColumnData();

        column.namesize = bis.readInt();
        column.name = new byte[column.namesize];
        bis.read(column.name);
        column.valuesize = bis.readInt();
        column.value = new byte[column.valuesize];
        bis.read(column.value);
        column.ressize = bis.readInt();
        // 资源数据非必需字段,解析前进行判断是否有
        if (column.ressize > 0)
        {
            column.resdata = new byte[column.ressize];
            bis.read(column.resdata);
        }
        return column;
    }

    /**
     * encode
     * @Description: 编码(字节数组转换成数据输出流)
     * @param dos
     */
    public void encode(DataOutputStream dos)
    {
        try
        {
            byte[] namesizeArray = ByteProcess.intToByteArray(namesize);
            dos.write(namesizeArray);
            dos.write(name);
            byte[] valuesizeArray = ByteProcess.intToByteArray(valuesize);
            dos.write(valuesizeArray);
            dos.write(value);
            byte[] ressizeArray = ByteProcess.intToByteArray(ressize);
            dos.write(ressizeArray);
            if (ressize > 0)
            {
                dos.write(resdata);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * setname
     * @Description: 设置名字
     * @param aName
     */
    public void setname(String aName)
    {
        try
        {
            name = aName.getBytes("UTF-8");
            namesize = name.length;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * setvalue
     * @Description: 设置值
     * @param aValue
     */
    public void setvalue(String aValue)
    {
        try
        {
            value = aValue.getBytes("UTF-8");
            valuesize = value.length;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    public void setvalue(int aValue)
    {
        value = ByteProcess.intToByteArray(aValue);
        valuesize = value.length;
    }

    public void setvalue(byte aValue)
    {
        value = new byte[]{aValue};
        valuesize = 1;
    }

    /**
     * setres
     * @Description: 设置资源数据
     * @param aResData
     */
    public void setres(byte[] aResData)
    {
        if (this.resdata == aResData)
        {
            return;
        }
        if (aResData == null)
        {
            this.resdata = null;
        }
        else
        {
            if (aResData.length == 0)
            {
                this.resdata = new byte[0];
            }
            else
            {
                this.resdata = new byte[aResData.length];
                System.arraycopy(this.resdata, 0, aResData, 0, aResData.length);
            }
            ressize = aResData.length;
        }
    }

    /** 名字的长度 */
    int namesize = 0;
    /** 名字字节数组 */
    byte[] name;
    /** 值的长度 */
    int valuesize = 0;
    /** 值字节数组 */
    byte[] value;
    /** 资源长度 */
    int ressize = 0;
    /** 资源字节数组 */
    byte[] resdata;
}
