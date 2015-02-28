package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserScheduleActivityDAO extends DynamicObjectMispDAO implements IUserScheduleActivityDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("insert userScheduleActivity starting...");
        super.insert("insertUserScheduleActivity", userScheduleActivity);
        log.debug("insert userScheduleActivity end");
    }

    public void insertUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException
    {
        log.debug("insert userScheduleActivityList starting...");
        if (null != userScheduleActivityList)
        {
            super.insertBatch("insertUserScheduleActivity", userScheduleActivityList);
        }
        log.debug("insert userScheduleActivityList end");
    }

    public void updateUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("update userScheduleActivity by pk starting...");
        super.update("updateUserScheduleActivity", userScheduleActivity);
        log.debug("update userScheduleActivity by pk end");
    }

    public void updateUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException
    {
        log.debug("update userScheduleActivityList by pk starting...");
        super.updateBatch("updateUserScheduleActivity", userScheduleActivityList);
        log.debug("update userScheduleActivityList by pk end");
    }

    public void updateUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("update userScheduleActivity by conditions starting...");
        super.update("updateUserScheduleActivityByCond", userScheduleActivity);
        log.debug("update userScheduleActivity by conditions end");
    }

    public void deleteUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("delete userScheduleActivity by pk starting...");
        super.delete("deleteUserScheduleActivity", userScheduleActivity);
        log.debug("delete userScheduleActivity by pk end");
    }

    public void deleteUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException
    {
        log.debug("delete userScheduleActivityList by pk starting...");
        super.deleteBatch("deleteUserScheduleActivity", userScheduleActivityList);
        log.debug("delete userScheduleActivityList by pk end");
    }

    public void deleteUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("delete userScheduleActivity by conditions starting...");
        super.delete("deleteUserScheduleActivityByCond", userScheduleActivity);
        log.debug("delete userScheduleActivity by conditions end");
    }

    public UserScheduleActivity getUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException
    {
        log.debug("query userScheduleActivity starting...");
        UserScheduleActivity resultObj = (UserScheduleActivity) super.queryForObject("getUserScheduleActivity",
                userScheduleActivity);
        log.debug("query userScheduleActivity end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DAOException
    {
        log.debug("query userScheduleActivity by condition starting...");
        List<UserScheduleActivity> rList = (List<UserScheduleActivity>) super.queryForList(
                "queryUserScheduleActivityListByCond", userScheduleActivity);
        log.debug("query userScheduleActivity by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleActivity> getUserScheduleActivityByCondExact(UserScheduleActivity userScheduleActivity)
            throws DAOException
    {
        log.debug("query userScheduleActivity by exact condition starting...");
        List<UserScheduleActivity> rList = (List<UserScheduleActivity>) super.queryForList(
                "queryUserScheduleActivityListByCondExact", userScheduleActivity);
        log.debug("query userScheduleActivity by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userScheduleActivity by condition starting...");
        List<UserScheduleActivity> rList = (List<UserScheduleActivity>) super.queryForList(
                "queryUserScheduleActivityListByCond", userScheduleActivity, puEntity);
        log.debug("query userScheduleActivity by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userScheduleActivity by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleActivityListCntByCond", userScheduleActivity))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserScheduleActivity> rsList = (List<UserScheduleActivity>) super.pageQuery(
                    "queryUserScheduleActivityListByCond", userScheduleActivity, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userScheduleActivity by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleActivityListByCond", "queryUserScheduleActivityListCntByCond",
                userScheduleActivity, start, pageSize, puEntity);
    }
    public UserScheduleActivityExtends getUserScheduleActivityExtends(UserScheduleActivityExtends userScheduleActivity) throws DAOException
    {
        log.debug("query userScheduleActivity starting...");
        UserScheduleActivityExtends resultObj = (UserScheduleActivityExtends) super.queryForObject("getUserScheduleActivityExtends",
                userScheduleActivity);
        log.debug("query userScheduleActivity end");
        return resultObj;
    }
    /**
     * 查询用户参与的活动列表
     * @param userScheduleActivity
     * @return
     * @throws DAOException
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCondExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DAOException
    {
        log.debug("query userScheduleActivity by condition starting...");
        List<UserScheduleActivity> rList = (List<UserScheduleActivity>) super.queryForList(
                "queryUserScheduleActivityListByCondExtends", userScheduleActivity);
        log.debug("query userScheduleActivity by condition end");
        return rList;
    }
    /**
     * 查询用户参与的活动列表(分页)
     * @param userScheduleActivity
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(UserScheduleActivityExtends userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleActivityListByCondExtends", "queryUserScheduleActivityListCntByCondExtends",
                userScheduleActivity, start, pageSize, puEntity);
    }


}