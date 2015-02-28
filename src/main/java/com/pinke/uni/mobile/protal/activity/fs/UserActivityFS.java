package com.pinke.uni.mobile.protal.activity.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.activity.ls.IUserActivityAttendMapLS;
import com.pinke.uni.mobile.protal.activity.ls.IUserActivityInviteMapLS;
import com.pinke.uni.mobile.protal.activity.ls.IUserScheduleActivityLS;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class UserActivityFS implements IUserActivityFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private IUserScheduleActivityLS userScheduleActivityLS;
    private IUserActivityAttendMapLS userActivityAttendMapLS;
    private IUserActivityInviteMapLS userActivityInviteMapLS;

    /**
     * 根据活动index查询活动详情
     * 
     * @param detailIndex
     * @return
     */
    public UserScheduleActivity getUserActivityDetailByIndex(Long detailIndex)
    {
        if (detailIndex == null)
            return null;
        SeriObjDCache dcValue = null;
        String strKey = "getUserActivityDetailByIndex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + detailIndex));

        }
        UserScheduleActivity userScheduleActivity = new UserScheduleActivity();
        if (dcValue == null || mcc == null)
        {

            try
            {
                userScheduleActivity = userScheduleActivityLS.getUserScheduleActivityByIndex(detailIndex);
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null && userScheduleActivity != null)
            {
                dcValue = new SeriObjDCache();

                dcValue.setMemObj(userScheduleActivity);

                boolean success = mcc.set(new String(strKey + "_" + detailIndex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                userScheduleActivity = (UserScheduleActivity) dcValue.getMemObj();
            }
        }
        return userScheduleActivity;

    }

    /**
     * 根据全属性查询活动详情
     * 
     * @param detailIndex
     * @return
     */
    public UserScheduleActivity getUserActivityDetail(UserScheduleActivity userScheduleActivity)
    {
        if (userScheduleActivity == null)
            return null;
        SeriObjDCache dcValue = null;
        String strKey = "getUserActivityDetail";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userScheduleActivity.getCreatetime() + "_"
                    + userScheduleActivity.getOriginatorindex()));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                List<UserScheduleActivity> list = userScheduleActivityLS
                        .getUserScheduleActivityByCondExact(userScheduleActivity);
                if (list != null && list.size() > 0)
                    userScheduleActivity = list.get(0);
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (userScheduleActivity != null)
                {
                    dcValue.setMemObj(userScheduleActivity);
                }
                else
                {
                    dcValue.setMemObj(new UserScheduleActivity());
                }

                boolean success = mcc.set(new String(strKey + "_" + userScheduleActivity.getCreatetime() + "_"
                        + userScheduleActivity.getOriginatorindex()), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                userScheduleActivity = (UserScheduleActivity) dcValue.getMemObj();
            }
        }
        return userScheduleActivity;

    }

    /**
     * 根据活动index和用户index查询用户是否被邀请参与活动
     * 
     * @param detailIndex
     * @return
     */
    public UserActivityInviteMap getInviteByIndex(Long detailIndex, Long userIndex)
    {
        if (detailIndex == null || userIndex == null)
            return null;

        UserActivityInviteMap temp = new UserActivityInviteMap();

        temp.setActivityindex(detailIndex);
        temp.setStudentindex(userIndex);
        temp.setStatus(1);

        try
        {
            temp = userActivityInviteMapLS.getUserActivityInviteMap(temp);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return temp;

    }

    /**
     * 查询用户被邀请参与活动列表
     * 
     * @param detailIndex
     * @return
     */
    public TableDataInfo getInviteList(Long userIndex, int page, int count)
    {
        if (userIndex == null)
            return null;

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getInviteList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {
            try
            {
                UserActivityInviteMap temp = new UserActivityInviteMap();

                temp.setStudentindex(userIndex);
                temp.setStatus(1);
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = userActivityInviteMapLS.pageInfoQuery(temp, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());
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
                    boolean success = mcc.set(new String(strKey + "_" + userIndex + "_" + page + "_" + count), dcValue,
                            new Date(DCACHETIME_LEVERL1 * 1000));
                }

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
     * 根据活动index获取参与者列表(包含头像等其他信息)
     * 
     * @param detailIndex
     * @return
     */
    public List getAttendListByIndex(Long detailIndex)
    {
        if (detailIndex == null)
            return null;
        SeriObjDCache dcValue = null;
        String strKey = "getAttendListByIndex";
        List<UserActivityAttendMapExtends> list = new ArrayList();
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + detailIndex));

        }
        UserActivityAttendMapExtends userActivityAttendMap = new UserActivityAttendMapExtends();
        if (dcValue == null || mcc == null)
        {

            userActivityAttendMap.setActivityindex(detailIndex);
            userActivityAttendMap.setStatus(1);

            try
            {
                list = userActivityAttendMapLS.getUserActivityAttendMapByCond(userActivityAttendMap);
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
                boolean success = mcc.set(new String(strKey + "_" + detailIndex), dcValue, new Date(
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
     * 新增活动
     * 
     * @param userScheduleActivity
     * @return
     */
    public boolean insertUserActivity(UserScheduleActivity userScheduleActivity)
    {
        // if (userScheduleActivity != null && userScheduleActivity.getOriginatorindex() != null)
        // {
        // return false;
        // }
        boolean result = false;
        try
        {
            userScheduleActivity.setStatus(1);
            String errorcode = userScheduleActivityLS.insertUserScheduleActivity(userScheduleActivity);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
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
     * 插入参与者信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean insertUserActivityAttend(UserActivityAttendMap userActivityAttendMap)
    {
        if (userActivityAttendMap == null || userActivityAttendMap.getActivityindex() == null
                || userActivityAttendMap.getStudentindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userActivityAttendMapLS.insertUserActivityAttendMap(userActivityAttendMap);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 插入邀请者信息（多条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean insertUserActivityInviteList(List<UserActivityInviteMap> userActivityInviteMapList)
    {
        if (userActivityInviteMapList == null || userActivityInviteMapList.size() <= 0)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userActivityInviteMapLS.insertUserActivityInviteMapList(userActivityInviteMapList);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 更新参与者信息
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityAttend(UserActivityAttendMap userActivityAttendMap)
    {

        if (userActivityAttendMap == null || userActivityAttendMap.getActivityindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userActivityAttendMapLS.updateUserActivityAttendMapByCond(userActivityAttendMap);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;

    }

    /**
     * 更新邀请者信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityInvite(UserActivityInviteMap userActivityInviteMap)
    {
        if (userActivityInviteMap == null || userActivityInviteMap.getActivityindex() == null
                || userActivityInviteMap.getStatus() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userActivityInviteMapLS.updateUserActivityInviteMapByCond(userActivityInviteMap);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 更新活动信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityDetail(UserScheduleActivity userScheduleActivity)
    {
        if (userScheduleActivity == null || userScheduleActivity.getActivityindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userScheduleActivityLS.updateUserScheduleActivity(userScheduleActivity);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 查询活动列表(分页查询)
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserActivityList(UserScheduleActivity userScheduleActivity, int page, int count)
    {

        if (userScheduleActivity == null)
        {
            return null;
        }
        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserActivityList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc
                    .get(new String(strKey + "_" + userScheduleActivity + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {
            try
            {
                userScheduleActivity.setStatus(1);
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = userScheduleActivityLS.pageInfoQuery(userScheduleActivity, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());
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
                    boolean success = mcc.set(
                            new String(strKey + "_" + userScheduleActivity + "_" + page + "_" + count), dcValue,
                            new Date(DCACHETIME_LEVERL1 * 1000));
                }

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
     * 查询某用户参与的活动列表index
     * 
     * @param userScheduleActivity
     * @return
     */
    public List getUserAttendActivityList(UserActivityAttendMapExtends userActivityAttendMap)
    {
        if (userActivityAttendMap == null || userActivityAttendMap.getStudentindex() == null)
        {
            return null;
        }
        List<UserActivityAttendMapExtends> list = new ArrayList();
        try
        {
            // userActivityAttendMap.setStatus(1);
            userActivityAttendMap.setOrderCond("activityindex desc");
            list = userActivityAttendMapLS.getUserActivityAttendMapByCond(userActivityAttendMap);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询某用户参与的活动列表及列表详情
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserAttendActivityListDetail(UserScheduleActivityExtends userScheduleActivity, int page,
            int count)
    {
        if (userScheduleActivity == null || userScheduleActivity.getAttendUserindex() == null)
        {
            return null;
        }
        TableDataInfo list = null;
        try
        {
            userScheduleActivity.setStatus(1);
            userScheduleActivity.setOrderCond("activityindex desc");
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = userScheduleActivityLS.pageInfoQueryExtends(userScheduleActivity, pageparam.getFirstIndex(),
                    pageparam.getPageSize(), new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询附近的活动列表(分页查询)
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserNearActivityList(UserScheduleActivity userScheduleActivity, int page, int count)
    {
        TableDataInfo list = null;
        if (userScheduleActivity == null)
        {
            return null;
        }
        try
        {
            userScheduleActivity.setStatus(1);
            userScheduleActivity.setOrderCond("distance asc");

            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = userScheduleActivityLS.pageInfoQuery(userScheduleActivity, pageparam.getFirstIndex(), pageparam
                    .getPageSize(), new PageUtilEntity());
            // list = userScheduleActivityLS.getUserScheduleActivityByCond(userScheduleActivity);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 搜索活动列表(分页查询)
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo searchUserActivityList(String keyword, int page, int count)
    {

        if (Tools.isNull(keyword))
        {
            return null;
        }
        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserActivityList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + keyword + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {
            try
            {
                UserScheduleActivity userScheduleActivity = new UserScheduleActivity();
                userScheduleActivity.setStatus(1);
                userScheduleActivity.setActivitytitle(keyword);
                userScheduleActivity.setOrderCond("starttime asc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = userScheduleActivityLS.pageInfoQuery(userScheduleActivity, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());
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
                    boolean success = mcc.set(new String(strKey + "_" + keyword + "_" + page + "_" + count), dcValue,
                            new Date(DCACHETIME_LEVERL1 * 1000));
                }

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
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

    public IUserScheduleActivityLS getUserScheduleActivityLS()
    {
        return userScheduleActivityLS;
    }

    public void setUserScheduleActivityLS(IUserScheduleActivityLS userScheduleActivityLS)
    {
        this.userScheduleActivityLS = userScheduleActivityLS;
    }

    public IUserActivityAttendMapLS getUserActivityAttendMapLS()
    {
        return userActivityAttendMapLS;
    }

    public void setUserActivityAttendMapLS(IUserActivityAttendMapLS userActivityAttendMapLS)
    {
        this.userActivityAttendMapLS = userActivityAttendMapLS;
    }

    public IUserActivityInviteMapLS getUserActivityInviteMapLS()
    {
        return userActivityInviteMapLS;
    }

    public void setUserActivityInviteMapLS(IUserActivityInviteMapLS userActivityInviteMapLS)
    {
        this.userActivityInviteMapLS = userActivityInviteMapLS;
    }

}
