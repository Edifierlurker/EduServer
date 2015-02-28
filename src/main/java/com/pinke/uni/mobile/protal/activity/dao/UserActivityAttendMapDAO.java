package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserActivityAttendMapDAO extends DynamicObjectMispDAO implements IUserActivityAttendMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DAOException
    {
        log.debug("insert userActivityAttendMap starting...");
        super.insert("insertUserActivityAttendMap", userActivityAttendMap);
        log.debug("insert userActivityAttendMap end");
    }

    public void insertUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DAOException
    {
        log.debug("insert userActivityAttendMapList starting...");
        if (null != userActivityAttendMapList)
        {
            super.insertBatch("insertUserActivityAttendMap", userActivityAttendMapList);
        }
        log.debug("insert userActivityAttendMapList end");
    }

    public void updateUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DAOException
    {
        log.debug("update userActivityAttendMap by pk starting...");
        super.update("updateUserActivityAttendMap", userActivityAttendMap);
        log.debug("update userActivityAttendMap by pk end");
    }

    public void updateUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DAOException
    {
        log.debug("update userActivityAttendMapList by pk starting...");
        super.updateBatch("updateUserActivityAttendMap", userActivityAttendMapList);
        log.debug("update userActivityAttendMapList by pk end");
    }

    public void updateUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap) throws DAOException
    {
        log.debug("update userActivityAttendMap by conditions starting...");
        super.update("updateUserActivityAttendMapByCond", userActivityAttendMap);
        log.debug("update userActivityAttendMap by conditions end");
    }

    public void deleteUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DAOException
    {
        log.debug("delete userActivityAttendMap by pk starting...");
        super.delete("deleteUserActivityAttendMap", userActivityAttendMap);
        log.debug("delete userActivityAttendMap by pk end");
    }

    public void deleteUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DAOException
    {
        log.debug("delete userActivityAttendMapList by pk starting...");
        super.deleteBatch("deleteUserActivityAttendMap", userActivityAttendMapList);
        log.debug("delete userActivityAttendMapList by pk end");
    }

    public void deleteUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap) throws DAOException
    {
        log.debug("delete userActivityAttendMap by conditions starting...");
        super.delete("deleteUserActivityAttendMapByCond", userActivityAttendMap);
        log.debug("delete userActivityAttendMap by conditions end");
    }

    public UserActivityAttendMap getUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DAOException
    {
        log.debug("query userActivityAttendMap starting...");
        UserActivityAttendMap resultObj = (UserActivityAttendMap) super.queryForObject("getUserActivityAttendMap",
                userActivityAttendMap);
        log.debug("query userActivityAttendMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityAttendMapExtends> getUserActivityAttendMapByCond(UserActivityAttendMapExtends userActivityAttendMap)
            throws DAOException
    {
        log.debug("query userActivityAttendMap by condition starting...");
        List<UserActivityAttendMapExtends> rList = (List<UserActivityAttendMapExtends>) super.queryForList(
                "queryUserActivityAttendMapListByCondExtends", userActivityAttendMap);
        log.debug("query userActivityAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityAttendMap> getUserActivityAttendMapByCondExact(UserActivityAttendMap userActivityAttendMap)
            throws DAOException
    {
        log.debug("query userActivityAttendMap by exact condition starting...");
        List<UserActivityAttendMap> rList = (List<UserActivityAttendMap>) super.queryForList(
                "queryUserActivityAttendMapListByCond", userActivityAttendMap);
        log.debug("query userActivityAttendMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserActivityAttendMap> getUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userActivityAttendMap by condition starting...");
        List<UserActivityAttendMap> rList = (List<UserActivityAttendMap>) super.queryForList(
                "queryUserActivityAttendMapListByCond", userActivityAttendMap, puEntity);
        log.debug("query userActivityAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userActivityAttendMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super
                .queryForObject("queryUserActivityAttendMapListCntByCond", userActivityAttendMap)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserActivityAttendMap> rsList = (List<UserActivityAttendMap>) super.pageQuery(
                    "queryUserActivityAttendMapListByCond", userActivityAttendMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userActivityAttendMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserActivityAttendMapListByCond", "queryUserActivityAttendMapListCntByCond",
                userActivityAttendMap, start, pageSize, puEntity);
    }
    
    

}