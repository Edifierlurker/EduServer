package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserActivityInviteMapDAO extends DynamicObjectMispDAO implements IUserActivityInviteMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DAOException
    {
        log.debug("insert userActivityInviteMap starting...");
        super.insert("insertUserActivityInviteMap", userActivityInviteMap);
        log.debug("insert userActivityInviteMap end");
    }

    public void insertUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DAOException
    {
        log.debug("insert userActivityInviteMapList starting...");
        if (null != userActivityInviteMapList)
        {
            super.insertBatch("insertUserActivityInviteMap", userActivityInviteMapList);
        }
        log.debug("insert userActivityInviteMapList end");
    }

    public void updateUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DAOException
    {
        log.debug("update userActivityInviteMap by pk starting...");
        super.update("updateUserActivityInviteMap", userActivityInviteMap);
        log.debug("update userActivityInviteMap by pk end");
    }

    public void updateUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DAOException
    {
        log.debug("update userActivityInviteMapList by pk starting...");
        super.updateBatch("updateUserActivityInviteMap", userActivityInviteMapList);
        log.debug("update userActivityInviteMapList by pk end");
    }

    public void updateUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap) throws DAOException
    {
        log.debug("update userActivityInviteMap by conditions starting...");
        super.update("updateUserActivityInviteMapByCond", userActivityInviteMap);
        log.debug("update userActivityInviteMap by conditions end");
    }

    public void deleteUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DAOException
    {
        log.debug("delete userActivityInviteMap by pk starting...");
        super.delete("deleteUserActivityInviteMap", userActivityInviteMap);
        log.debug("delete userActivityInviteMap by pk end");
    }

    public void deleteUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DAOException
    {
        log.debug("delete userActivityInviteMapList by pk starting...");
        super.deleteBatch("deleteUserActivityInviteMap", userActivityInviteMapList);
        log.debug("delete userActivityInviteMapList by pk end");
    }

    public void deleteUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap) throws DAOException
    {
        log.debug("delete userActivityInviteMap by conditions starting...");
        super.delete("deleteUserActivityInviteMapByCond", userActivityInviteMap);
        log.debug("delete userActivityInviteMap by conditions end");
    }

    public UserActivityInviteMap getUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DAOException
    {
        log.debug("query userActivityInviteMap starting...");
        UserActivityInviteMap resultObj = (UserActivityInviteMap) super.queryForObject("getUserActivityInviteMap",
                userActivityInviteMap);
        log.debug("query userActivityInviteMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityInviteMap> getUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DAOException
    {
        log.debug("query userActivityInviteMap by condition starting...");
        List<UserActivityInviteMap> rList = (List<UserActivityInviteMap>) super.queryForList(
                "queryUserActivityInviteMapListByCond", userActivityInviteMap);
        log.debug("query userActivityInviteMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityInviteMap> getUserActivityInviteMapByCondExact(UserActivityInviteMap userActivityInviteMap)
            throws DAOException
    {
        log.debug("query userActivityInviteMap by exact condition starting...");
        List<UserActivityInviteMap> rList = (List<UserActivityInviteMap>) super.queryForList(
                "queryUserActivityInviteMapListByCondExact", userActivityInviteMap);
        log.debug("query userActivityInviteMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityInviteMap> getUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userActivityInviteMap by condition starting...");
        List<UserActivityInviteMap> rList = (List<UserActivityInviteMap>) super.queryForList(
                "queryUserActivityInviteMapListByCond", userActivityInviteMap, puEntity);
        log.debug("query userActivityInviteMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userActivityInviteMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super
                .queryForObject("queryUserActivityInviteMapListCntByCond", userActivityInviteMap)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserActivityInviteMap> rsList = (List<UserActivityInviteMap>) super.pageQuery(
                    "queryUserActivityInviteMapListByCond", userActivityInviteMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userActivityInviteMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserActivityInviteMapListByCondExtends", "queryUserActivityInviteMapListCntByCondExtends",
                userActivityInviteMap, start, pageSize, puEntity);
    }

}