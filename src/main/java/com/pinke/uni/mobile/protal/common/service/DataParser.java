package com.pinke.uni.mobile.protal.common.service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;



/**
 * 数据解析器
 * @ClassName: DataParser 
 * @Description: 数据解析器
 */
public class DataParser
{

    /** 默认时间 */
    public static final int DEFAULT_TIME = 1000;

    /**
     * parser
     * @Description: 解析(字节数组转换成数据适配类型)
     * @param aData
     * @return
     */
    static public DataAdapter parser(byte[] aData)
    {
        DataAdapter p = new DataAdapter();
        ByteArrayInputStream bais = new ByteArrayInputStream(aData);
        DataInputStream bis = new DataInputStream(bais);
        try
        {
            int tablecount = bis.readInt();
            if (tablecount > DEFAULT_TIME)
            {
                return null;
            }
            for (int index = 0; index < tablecount; ++index)
            {
                WoTableData table = WoTableData.parser(bis);
                if (table != null)
                    p.addTable(table);
            }

            if (bais != null)
                bais.close();
            if (bis != null)
                bis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * encode
     * @Description: 编码(适配类型转换为字节数组)
     * @param aData
     * @return
     */
    static public byte[] encode(DataAdapter aData)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            aData.encode(dos);
            bos.close();
            dos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    public void _finalize()
    {
    }
}
