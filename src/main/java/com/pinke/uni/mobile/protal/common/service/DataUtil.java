package com.pinke.uni.mobile.protal.common.service;


import java.util.Vector;


/**
 * 数据操作工具类
 * @ClassName: DataUtil 
 * @Description: 数据操作工具
 */
public class DataUtil
{

    private static final String TAG = "DataUtil";
    
    /**
     * getTableData
     * @Description: 获取表数据
     * @param de 数据适配类型数据
     * @param tableName 表名
     * @return
     * @throws Exception
     */
    public static WoTableData getTableData(DataAdapter de, String tableName) throws Exception
    {
        if (de != null)
        {
            Vector<WoTableData> tables = de.tables;
            if (tables != null)
            {
                for (int i = 0; i < tables.size(); i++)
                {
                    WoTableData woTableData = (WoTableData) tables.elementAt(i);
                    String tablenameStr = new String(woTableData.tablename, "UTF-8");
                    if (tablenameStr != null && tablenameStr.equals(tableName))
                    {
//                        NewLog.debug(TAG, "getTableData return table: tableName=" + tableName + "; rowssize=" + woTableData.rows.size());
                        return woTableData;
                    }
                }
            }
        }
//        NewLog.debug(TAG, "getTableData return null");
        return null;
    }

    /**
     * getByte
     * @Description: 根据key获取字节
     * @param woRowData
     * @param key
     * @return
     * @throws Exception
     */
    public static byte getByte(WoRowData woRowData, String key) throws Exception
    {
        Vector<WoColumnData> columns = woRowData.columnsdatas;
        for (int i = 0; i < columns.size(); i++)
        {
            WoColumnData woColumnData = (WoColumnData) columns.elementAt(i);
            String nameStr = new String(woColumnData.name, "UTF-8");
            if (nameStr != null && nameStr.equals(key))
            {
                return woColumnData.value[0];
            }
        }
        return 0;
    }

    /**
     * getInt
     * @Description: 根据key获取整型数据 
     * @param woRowData
     * @param key
     * @return
     * @throws Exception
     */
    public static int getInt(WoRowData woRowData, String key) throws Exception
    {
        Vector<WoColumnData> columns = woRowData.columnsdatas;
        for (int i = 0; i < columns.size(); i++)
        {
            WoColumnData woColumnData = (WoColumnData) columns.elementAt(i);
            String nameStr = new String(woColumnData.name, "UTF-8");
            if (nameStr != null && nameStr.equals(key))
            {
                return ByteProcess.byteArrayToInt(woColumnData.value, 0);
            }
        }
        return 0;
    }

    /**
     * getLong
     * @Description: 根据key获取长整型数据
     * @param woRowData
     * @param key
     * @return
     * @throws Exception
     */
    public static long getLong(WoRowData woRowData, String key) throws Exception
    {
        Vector<WoColumnData> columns = woRowData.columnsdatas;
        for (int i = 0; i < columns.size(); i++)
        {
            WoColumnData woColumnData = (WoColumnData) columns.elementAt(i);
            String nameStr = new String(woColumnData.name,"UTF-8");
            if (nameStr != null && nameStr.equals(key))
            {
                return ByteProcess.byteArrayToLong(woColumnData.value, 0);
            }
        }
        return 0;
    }

    /**
     * getString
     * @Description: 根据key获取字符串
     * @param woRowData
     * @param key
     * @return
     * @throws Exception
     */
    public static String getString(WoRowData woRowData, String key) throws Exception
    {
        Vector<WoColumnData> columns = woRowData.columnsdatas;
        for (int i = 0; i < columns.size(); i++)
        {
            WoColumnData woColumnData = (WoColumnData) columns.elementAt(i);
            String nameStr = new String(woColumnData.name, "UTF-8");
            if (nameStr != null && nameStr.equals(key))
            {
                return new String(woColumnData.value,"UTF-8");
            }
        }
        return null;
    }

    /**
     * getByteArray
     * @Description: 根据key获取字节数组
     * @param woRowData
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] getByteArray(WoRowData woRowData, String key) throws Exception
    {
        Vector<WoColumnData> columns = woRowData.columnsdatas;
        for (int i = 0; i < columns.size(); i++)
        {
            WoColumnData woColumnData = (WoColumnData) columns.elementAt(i);
            String nameStr = new String(woColumnData.name, "UTF-8");
            if (nameStr != null && nameStr.equals(key))
            {
                return woColumnData.resdata;
            }
        }
        return null;
    }



    
}
