package com.pinke.uni.mobile.protal.common.service;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;


/**
 * 表数据
 * @ClassName: WoTableData 
 * @Description: 表数据
 */
public class WoTableData
{

    /**
     * parser
     * @Description: 解析
     * @param bis
     * @return
     */
    static public WoTableData parser(DataInputStream bis)
    {
        WoTableData table = new WoTableData();
        try
        {
            table.tablenamesize = bis.readInt();
            table.tablename = new byte[table.tablenamesize];
            bis.read(table.tablename);
            int rowcount = bis.readInt();
            if (rowcount > DataParser.DEFAULT_TIME)
            {
                return null;
            }
            for (int index = 0; index < rowcount; ++index)
            {
                WoRowData row = WoRowData.parser(bis);
                if (row != null)
                    table.addRow(row);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            table = null;
        }
        return table;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        String tablenameStr = "";
        try
        {
            tablenameStr = new String(tablename, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        result.append("tablenamesize = ").append(tablenamesize).append("\n");
        result.append("tablename = ").append(tablenameStr).append("\n");
        result.append("rowcount = ").append(rows.size()).append("\n");
        for (int index = 0; index < rows.size(); ++index)
        {
        	result.append("rowindex = ").append(index);
            WoRowData row = (WoRowData) rows.elementAt(index);
            result.append(row.toString());
        }
        return result.toString();
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
            dos.write(ByteProcess.intToByteArray(tablenamesize));
            dos.write(tablename);
            int rowcount = rows.size();
            byte[] array = ByteProcess.intToByteArray(rowcount);
            dos.write(array);
            //GC.__delete(array);
            for (int index = 0; index < rowcount; ++index)
            {
                WoRowData row = (WoRowData) rows.elementAt(index);
                row.encode(dos);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * addRow
     * @Description: 增加一个行数据 
     * @param arow
     */
    public void addRow(WoRowData arow)
    {
        rows.addElement(arow);
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
            tablename = aName.getBytes("UTF-8");
            tablenamesize = tablename.length;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /** 表名大小 */
    int tablenamesize = 0;
    /** 表名数据 */
    byte[] tablename;
    /** 行数据列表容器 */
    public Vector<WoRowData> rows = new Vector<WoRowData>();

    public void _finalize()
    {
        tablename = null;
        if (rows != null)
        {
            rows = null;
        }
    }
}
