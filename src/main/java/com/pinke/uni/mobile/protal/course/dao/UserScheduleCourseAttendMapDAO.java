package com.pinke.uni.mobile.protal.course.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserScheduleCourseAttendMapDAO extends DynamicObjectMispDAO implements IUserScheduleCourseAttendMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("insert userScheduleCourseAttendMap starting...");
        super.insert("insertUserScheduleCourseAttendMap", userScheduleCourseAttendMap);
        log.debug("insert userScheduleCourseAttendMap end");
    }

    public void insertUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException
    {
        log.debug("insert userScheduleCourseAttendMapList starting...");
        if (null != userScheduleCourseAttendMapList)
        {
            super.insertBatch("insertUserScheduleCourseAttendMap", userScheduleCourseAttendMapList);
        }
        log.debug("insert userScheduleCourseAttendMapList end");
    }

    public void updateUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("update userScheduleCourseAttendMap by pk starting...");
        super.update("updateUserScheduleCourseAttendMap", userScheduleCourseAttendMap);
        log.debug("update userScheduleCourseAttendMap by pk end");
    }

    public void updateUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException
    {
        log.debug("update userScheduleCourseAttendMapList by pk starting...");
        super.updateBatch("updateUserScheduleCourseAttendMap", userScheduleCourseAttendMapList);
        log.debug("update userScheduleCourseAttendMapList by pk end");
    }

    public void updateUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("update userScheduleCourseAttendMap by conditions starting...");
        super.update("updateUserScheduleCourseAttendMapByCond", userScheduleCourseAttendMap);
        log.debug("update userScheduleCourseAttendMap by conditions end");
    }

    public void deleteUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("delete userScheduleCourseAttendMap by pk starting...");
        super.delete("deleteUserScheduleCourseAttendMap", userScheduleCourseAttendMap);
        log.debug("delete userScheduleCourseAttendMap by pk end");
    }

    public void deleteUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException
    {
        log.debug("delete userScheduleCourseAttendMapList by pk starting...");
        super.deleteBatch("deleteUserScheduleCourseAttendMap", userScheduleCourseAttendMapList);
        log.debug("delete userScheduleCourseAttendMapList by pk end");
    }

    public void deleteUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("delete userScheduleCourseAttendMap by conditions starting...");
        super.delete("deleteUserScheduleCourseAttendMapByCond", userScheduleCourseAttendMap);
        log.debug("delete userScheduleCourseAttendMap by conditions end");
    }

    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMap(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException
    {
        log.debug("query userScheduleCourseAttendMap starting...");
        UserScheduleCourseAttendMap resultObj = (UserScheduleCourseAttendMap) super.queryForObject(
                "getUserScheduleCourseAttendMap", userScheduleCourseAttendMap);
        log.debug("query userScheduleCourseAttendMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException
    {
        log.debug("query userScheduleCourseAttendMap by condition starting...");
        List<UserScheduleCourseAttendMap> rList = (List<UserScheduleCourseAttendMap>) super.queryForList(
                "queryUserScheduleCourseAttendMapListByCond", userScheduleCourseAttendMap);
        log.debug("query userScheduleCourseAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCondExact(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException
    {
        log.debug("query userScheduleCourseAttendMap by exact condition starting...");
        List<UserScheduleCourseAttendMap> rList = (List<UserScheduleCourseAttendMap>) super.queryForList(
                "queryUserScheduleCourseAttendMapListByCondExact", userScheduleCourseAttendMap);
        log.debug("query userScheduleCourseAttendMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userScheduleCourseAttendMap by condition starting...");
        List<UserScheduleCourseAttendMap> rList = (List<UserScheduleCourseAttendMap>) super.queryForList(
                "queryUserScheduleCourseAttendMapListByCond", userScheduleCourseAttendMap, puEntity);
        log.debug("query userScheduleCourseAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userScheduleCourseAttendMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleCourseAttendMapListCntByCond",
                userScheduleCourseAttendMap)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserScheduleCourseAttendMap> rsList = (List<UserScheduleCourseAttendMap>) super.pageQuery(
                    "queryUserScheduleCourseAttendMapListByCond", userScheduleCourseAttendMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userScheduleCourseAttendMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super
                .indexPageQuery("queryUserScheduleCourseAttendMapListByCond",
                        "queryUserScheduleCourseAttendMapListCntByCond", userScheduleCourseAttendMap, start, pageSize,
                        puEntity);
    }
    
    @SuppressWarnings("unchecked")
    public int pageInfoQueryCount(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException
    {
        log.debug("page query userScheduleCourseAttendMap by condition starting...");
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleCourseAttendMapListCntByCond",
                userScheduleCourseAttendMap)).intValue();

        log.debug("page query userScheduleCourseAttendMap by condition end");
        return totalCnt;
    }

}