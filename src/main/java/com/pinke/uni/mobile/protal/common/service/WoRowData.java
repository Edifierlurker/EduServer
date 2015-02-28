package com.pinke.uni.mobile.protal.common.service;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;


/**
 * 行数据
 * @ClassName: WoRowData 
 * @Description: 行数据
 */
public class WoRowData
{

    /**
     * parser
     * @Description: 解析
     * @param bis
     * @return
     * @throws IOException
     */
    static public WoRowData parser(DataInputStream bis) throws IOException
    {
        WoRowData row = new WoRowData();
        int columnconut = bis.readInt();
        if (columnconut > DataParser.DEFAULT_TIME)
        {
            return null;
        }
        for (int index = 0; index < columnconut; ++index)
        {
            WoColumnData columns = WoColumnData.parser(bis);
            if (columns != null)
            {
                row.addColumn(columns);
            }
        }
        return row;
    }

    public String toString()
    {
        String result = "";
        result += "columscount = " + columnsdatas.size() + "\n";
        for (int index = 0; index < columnsdatas.size(); ++index)
        {
            result += "columsindex = " + index + "\n";
            WoColumnData colums = (WoColumnData) columnsdatas.elementAt(index);
            result += colums.toString();
        }
        return result;
    }

    /**
     * addColumn
     * @Description: 增加一列数据 
     * @param acolumn
     */
    public void addColumn(WoColumnData acolumn)
    {
        columnsdatas.addElement(acolumn);
    }

    /**
     * encode
     * @Description: 编码(字节数组转换成数据输出流)
     * @param dos
     */
    public void encode(DataOutputStream dos)
    {
        int columncount = columnsdatas.size();
        try
        {
            byte[] array = ByteProcess.intToByteArray(columncount);
            dos.write(array);
            //GC.__delete(array);
            for (int index = 0; index < columncount; ++index)
            {
                WoColumnData column = (WoColumnData) columnsdatas.elementAt(index);
                column.encode(dos);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /** 行数据列表容器 */
    Vector<WoColumnData> columnsdatas = new Vector<WoColumnData>();

    /**
     * _finalize
     * @Description: 结束操作
     */
    public void _finalize()
    {
        if (columnsdatas != null)
        {
            columnsdatas = null;
        }
    }
}
