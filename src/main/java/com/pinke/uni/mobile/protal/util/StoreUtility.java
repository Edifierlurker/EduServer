package com.pinke.uni.mobile.protal.util;



import java.io.File;

/**
 * <p>文件名称: StoreUtility.java</p>
 * <p>文件描述: AppStore通用类</p>
 * <p>版权所有: 版权所有(C)2001-2010</p>
 * <p>公   司: 中兴通讯股份有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>完成日期: 2011年3月23号</p>
 * @version 1.0
 * @author  孟勇
 */
public class StoreUtility
{
    private static String myPath = null;//当前类在Web应用的类路径
    private static String webPath = null;//Web应用的WEB-INF路径
    private static String appPath = null;//Web应用的路径
    private static String rootApp = null;
    
    /**
     * 获取当前类在Web应用的类路径<br>以目录分隔符结尾
     */
    private static void getMyPath()
    {
        if(myPath == null)
        {
            myPath = StoreUtility.class.getResource("/").getPath();
        }
    }
    
    /**
     * 获取Web应用的WEB-INF路径<br>以目录分隔符结尾
     * @return
     */
    public static String getWebPath()
    {
        if(webPath == null)
        {
            getMyPath();
            webPath = (new File(myPath)).getParent().concat(File.separator);
        }
        
        return webPath;
    }
    
    /**
     * 获取Web应用的路径<br>以目录分隔符结尾
     * @return
     */
    public static String getAppPath()
    {
        if(appPath == null)
        {
            appPath = (new File(getWebPath())).getParent().concat(File.separator);
        }
        
        return appPath;
    }
    
    /**
     * 获取Web应用中的指定目录<br>以目录分隔符结尾
     * @param path Web应用中的目录
     * @return
     */
    public static String getPath(String path)
    {
        return getAppPath().concat(path).concat(File.separator);
    }
    
    /**
     * 获取Web应用上传路径，指向filepath<br>以目录分隔符结尾
     * @return
     */
    public static String getRootPath()
    {
        if(rootApp == null)
        {
            rootApp = getAppPath().concat("filepath").concat(File.separator);
        }
        
        return rootApp;
    }
    
    /**
     * 判断上传文件格式否是合法
     * @param fileName 文件名
     * @return
     */
    public static boolean isValidUploadFormat(String fileName)
    {
        String name = fileName.trim().toLowerCase();
        return !(name.endsWith(".jsp") || name.endsWith(".php"));
    }

}
