package com.pinke.uni.mobile.protal.common.service;


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;


/**
 * 数据适配器
 * @ClassName: DataAdapter 
 * @Description: 数据适配器
 */
public class DataAdapter
{

    /** 时间戳 */
    private long timeStamp = 0;

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    /**
     * addTable
     * @Description: 添加一个表 
     * @param data
     */
    public void addTable(WoTableData data)
    {
        tables.addElement(data);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        int tablecount = 0;
        WoTableData da = null;
        tablecount = tables.size();
        result.append("start==========================================\n");
        result.append("\n" + "tablecount = " + tablecount + "\n");
        for (int index = 0; index < tablecount; ++index)
        {
        	result.append("tableindex = " + index + "\n");
            da = (WoTableData) tables.elementAt(index);
            result.append(da.toString());
        }
        result.append("end=============================================\n");
        return result.toString();
    }

    /**
     * encode
     * @Description: 编码(字节数组转换成数据输出流)
     * @param dos
     */
    public void encode(DataOutputStream dos)
    {
        int tablecount = tables.size();
        try
        {
            byte[] array = ByteProcess.intToByteArray(tablecount);
            dos.write(array);
            for (int index = 0; index < tablecount; ++index)
            {
                WoTableData table = (WoTableData) tables.elementAt(index);
                table.encode(dos);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /** 表数据列表容器 */
    Vector<WoTableData> tables = new Vector<WoTableData>();

    /**
     * _finalize
     * @Description: 结束操作
     */
    public void _finalize()
    {
        if (tables != null)
        {
            tables = null;
        }
    }
}
