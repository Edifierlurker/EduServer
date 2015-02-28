package com.pinke.uni.mobile.protal.schedule.fs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.schedule.ls.IUserScheduleLS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class ScheduleFS implements IScheduleFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private Log log = SSBBus.getLog(this.getClass());
    private IUserScheduleLS userScheduleLS;

    /**
     * 根据userindex查询用户某天的日程
     * 
     * @param userIndex
     * @param date
     * @return
     */
    public TableDataInfo getUserScheduleListByUserIndex(String userIndex, String date, int pageNum, int count)
    {
        TableDataInfo list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getUserScheduleListByUserIndex";
        if (Tools.isNull(userIndex) || Tools.isNull(date))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex + "_" + date + "_" + pageNum + "_"
                    + count));

        }
        if (dcValue == null || mcc == null)
        {

            UserSchedule userSchedule = new UserSchedule();
            userSchedule.setStudentindex(Long.parseLong(userIndex));
            userSchedule.setStatus(1);
            userSchedule.setScheduledate(date);
            userSchedule.setOrderCond("starttime asc");
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(pageNum);
            pageparam.setPageSize(count);
            try
            {
                list = userScheduleLS.pageInfoQuery(userSchedule, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userIndex + "_" + date + "_" + pageNum + "_"
                        + count), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }

        return list;
    }

    /**
     * 根据userindex查询用户日程
     * 
     * @param userIndex
     * @param date
     * @return
     */
    public List getUserScheduleList(String userIndex, String date, String type)
    {
        List<UserSchedule> list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getUserScheduleList";
        if (Tools.isNull(userIndex) || Tools.isNull(date))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex + "_" + date));

        }
        if (dcValue == null || mcc == null)
        {

            UserSchedule userSchedule = new UserSchedule();
            userSchedule.setStudentindex(Long.parseLong(userIndex));
            userSchedule.setStatus(1);
            if ("2".equals(type))
            {
                userSchedule.setScheduleweekStart(date);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date scheduleweekStart;
                try
                {
                    scheduleweekStart = sdf.parse(date);
                    calendar.setTime(scheduleweekStart);
                    calendar.add(Calendar.DAY_OF_YEAR, 6);
                    Date scheduleweekEnd = calendar.getTime();

                    userSchedule.setScheduleweekEnd(Tools.formatDate9(scheduleweekEnd));
                }
                catch (ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            else
            {
                userSchedule.setScheduledate(date);
            }

            userSchedule.setOrderCond("scheduledate asc");
            PageParam pageparam = new PageParam();

            try
            {
                list = userScheduleLS.getUserScheduleByCond(userSchedule);
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list);

                }
                else
                {
                    dcValue.setMemlist(new ArrayList());

                }
                boolean success = mcc.set(new String(strKey + "_" + userIndex + "_" + date), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list = dcValue.getMemlist();

            }
        }

        return list;
    }

    /**
     * 添加用户日程
     * 
     * @param userSchedule
     * @return
     */
    public boolean insertUserSchedule(UserSchedule userSchedule)
    {
        boolean result = false;
        if (userSchedule == null || userSchedule.getStudentindex() == null
                || Tools.isNull(userSchedule.getScheduledate()))
        {
            return false;
        }
        try
        {
            String errorCode = userScheduleLS.insertUserSchedule(userSchedule);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除用户日程
     * 
     * @param userSchedule
     * @return
     */
    public boolean delUserSchedule(UserSchedule userSchedule)
    {
        boolean result = false;
        if (userSchedule == null )
        {
            return false;
        }
        try
        {
            String errorCode = userScheduleLS.removeUserSchedule(userSchedule);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public IUserScheduleLS getUserScheduleLS()
    {
        return userScheduleLS;
    }

    public void setUserScheduleLS(IUserScheduleLS userScheduleLS)
    {
        this.userScheduleLS = userScheduleLS;
    }

    public static void main(String[] args)
    {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date scheduleweekStart;
        try
        {
            scheduleweekStart = sdf.parse("20141231");
            calendar.setTime(scheduleweekStart);
            calendar.add(Calendar.DAY_OF_YEAR, 6);
            Date scheduleweekEnd = calendar.getTime();
            System.out.println(Tools.formatDate9(scheduleweekEnd));

        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
