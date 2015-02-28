package com.pinke.uni.mobile.protal.common.dcache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.zte.misp.common.IDCacheCallBack;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.zxcpp.dcache.dcjapi.DcAPI;
import com.zte.zxcpp.dcache.dcjapi.util.DcIncrease;
import com.zte.zxcpp.dcache.dcjapi.util.DcKey;
import com.zte.zxcpp.dcache.dcjapi.util.DcKeyAttr;
import com.zte.zxcpp.dcache.dcjapi.util.DcValue;

public class AppDCacheAdapter
{
    private Log log = SSBBus.getLog(this.getClass());

    // 记得学习一下，封装一个dcacheFactory ，存放hashmap，key为“session”、“DB
    // dcache”等，value为DCacheAdapter
    private DcAPI api;
    // key属性
    DcKeyAttr keyattr;
    private static boolean flag = AppDCacheAdapter.getfalg();

    // private static String appkey = "AppStore_store";

    public static boolean getfalg()
    {
        ApplicationGlobalResource agr = ApplicationGlobalResource.getInstance();
        String dcacheflag = agr.getValueByKey("store.dcacheflag");
        if (null == dcacheflag || "".equals(dcacheflag))
            dcacheflag = "false";
        return Boolean.parseBoolean(dcacheflag);
    }

    public AppDCacheAdapter(char space)
    {
        if (flag)
        {
            api = new DcAPI(space);
            // 由应用生成的一个Value的版本号，递增
            // 0为不启用应用版本号机制。请使用长度为8的short
            // 数组表示: short[8]
            // AppEdition应用版本号是可选项，应用可以生成一个序号，作为服务器侧的数据版本判断依据。因为如果两个客户端并发地对一个Key写入时，其先后顺序是不一定的，如果应用需要保证这种顺序，可以采用两个办法：或者收到第一个写操作响应后再写第二个值，或者使用应用版本号，服务器节点根据这个版本号来区分先后顺序。如果服务器节点收到一个Set操作，发现App
            // Edition小于或等于之前已写入的App Edition，则不必再次写入，直接返回成功。
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            // 1001用于数据版本检查，由应用填写。写操作时记录该标签号。读操作时会校验该标签号，仅当与读到的标签号相等则读取成功，这个由服务端进行处理。如果填0表示不做校验。
            // 0表示永久有效
            keyattr = new DcKeyAttr(edition, 1001, 0);
        }

    }

    public Object getValue(String modulekey, String keystr)
    {
        if (flag)
        {
            DcKey key = new DcKey(modulekey + "_" + keystr, keyattr);
            // 2表示返回的状态值，操作返回的响应码
            int[] status = new int[2];
//            System.out.println("***************dcache的key值***********：" + key.getPKey());
            DcValue valueGet = api.dcGet(key, status);
            byte value[] = valueGet.getPValue();
            if (value != null)
            {
                ByteArrayInputStream in = new ByteArrayInputStream(value);
                try
                {
                    ObjectInputStream oIn = new ObjectInputStream(in);
                    return oIn.readObject();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
                catch (ClassNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public void getValue(String modulekey, String keystr, IDCacheCallBack callback)
    {
        if (flag)
        {
            DcKey key = new DcKey(modulekey + "_" + keystr, keyattr);

            api.dcAGet(callback, key);
        }

    }

    public int setValue(String modulekey, String keystr, Object value, long expires)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, expires);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oout;
            try
            {
                oout = new ObjectOutputStream(baos);
                oout.writeObject(value);
                oout.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            DcValue dv = new DcValue(baos.toByteArray(), (short) 0, (short) 0);
            return api.dcSet(key, dv);
        }
        return -1;
    }

    public int setAsyncValue(String modulekey, String keystr, Serializable value, long expires)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, expires);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);
//System.out.println("*********"+key.getPKey());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oout;
            try
            {
                oout = new ObjectOutputStream(baos);
                oout.writeObject(value);
                oout.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Logger.getLogger("DCache").log(Priority.ERROR, "File I/O Error");
            }

            DcValue dv = new DcValue(baos.toByteArray(), (short) 0, (short) 0);
            // 2011.08.15参数修改，将null修改为new DcacheCallBack(),在包中新增DcacheCallBack()类
            return api.dcASet(new DcacheCallBack(), key, dv, key.getPKey());
        }
        return -1;
    }

    public Object getValue1(String modulekey, String keystr)
    {
        if (flag)
        {
            DcKey key = new DcKey(modulekey + "_" + keystr, keyattr);
            // 2表示返回的状态值，操作返回的响应码
            int[] status = new int[2];

            DcValue valueGet = api.dcGet(key, status);
            byte value[] = valueGet.getPValue();
            if (value != null)
            {
                try
                {
                    String value_imp;
                    value_imp = new String(value, "utf-8");
                    return value_imp;
                }
                catch (UnsupportedEncodingException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }

            }
        }
        return null;

    }

    public Object getValue2(String keystr)
    {
        if (flag)
        {
            DcKey key = new DcKey(keystr, keyattr);
            // 2表示返回的状态值，操作返回的响应码
            int[] status = new int[2];

            DcValue valueGet = api.dcGet(key, status);
            byte value[] = valueGet.getPValue();
            if (value != null)
            {
                try
                {
                    String value_imp;
                    value_imp = new String(value, "utf-8");
                    return value_imp;
                }
                catch (UnsupportedEncodingException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }

            }
        }
        return null;

    }

    public int setAsyncValue1(String modulekey, String keystr, Serializable value, long expires, String value1)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, expires);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);

            DcValue dv = new DcValue(value1.getBytes(), (short) 0, (short) 0);
            // 2011.08.15参数修改，将null修改为new DcacheCallBack(),在包中新增DcacheCallBack()类
            return api.dcASet(new DcacheCallBack(), key, dv, key.getPKey());
        }
        return -1;
    }

    // 异步删除
    public int delAsyncKey(String modulekey, String keystr)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, 0);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);
            // return api.dcADel(null, key);
            return api.dcADel(new DcacheCallBack(), key, key.getPKey());
        }
        return -1;
    }

    // 同步删除
    public int delKey(String modulekey, String keystr)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, 0);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);
            return api.dcDel(key);
        }
        return -1;
    }

    // 同步计数
    public long getIncrease(String modulekey, String keystr, long begin, long addnum)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, 0);
            DcKey key = new DcKey(modulekey + "_" + keystr, attr);
            DcIncrease inc = new DcIncrease(addnum, begin);
            // 2表示返回的状态值，操作返回的响应码
            int[] recStatus = new int[2];
            DcValue value = api.dcIncrease(key, inc, recStatus);
            // DcValue v=api.dci
            return value.getPValueAsLong();
        }
        return -1;
    }


    public int setAsyncValueForCLanguage(String keystr, String value, long expires)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr attr = new DcKeyAttr(edition, 1001, expires);
            DcKey key = new DcKey(keystr, attr);

            DcValue dv;
            try
            {
                dv = new DcValue(value.getBytes("UTF-8"), (short) 0, (short) 0);
                return api.dcSet(key, dv);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public Object getValueForCLanguage(String keystr)
    {
        if (flag)
        {
            short[] edition = { 10, 10, 10, 02, 41, 15, 35, 64 };
            DcKeyAttr keyattr = new DcKeyAttr(edition, 1001, 0);
            DcKey key = new DcKey(keystr, keyattr);
            // 2表示返回的状态值，操作返回的响应码
            int[] status = new int[2];
//System.out.println("************"+keystr);
            DcValue valueGet = api.dcGet(key, status);
            byte value[] = valueGet.getPValue();
            if (value != null)
            {
                try
                {
                    String value_imp;
                    value_imp = new String(value, "UTF-8");
                    return value_imp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }

            }
        }
        return null;
    }

}
