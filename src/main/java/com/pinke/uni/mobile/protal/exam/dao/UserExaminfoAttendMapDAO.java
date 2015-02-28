package com.pinke.uni.mobile.protal.exam.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserExaminfoAttendMapDAO extends DynamicObjectMispDAO implements IUserExaminfoAttendMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DAOException
    {
        log.debug("insert userExaminfoAttendMap starting...");
        super.insert("insertUserExaminfoAttendMap", userExaminfoAttendMap);
        log.debug("insert userExaminfoAttendMap end");
    }

    public void insertUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DAOException
    {
        log.debug("insert userExaminfoAttendMapList starting...");
        if (null != userExaminfoAttendMapList)
        {
            super.insertBatch("insertUserExaminfoAttendMap", userExaminfoAttendMapList);
        }
        log.debug("insert userExaminfoAttendMapList end");
    }

    public void updateUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DAOException
    {
        log.debug("update userExaminfoAttendMap by pk starting...");
        super.update("updateUserExaminfoAttendMap", userExaminfoAttendMap);
        log.debug("update userExaminfoAttendMap by pk end");
    }

    public void updateUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DAOException
    {
        log.debug("update userExaminfoAttendMapList by pk starting...");
        super.updateBatch("updateUserExaminfoAttendMap", userExaminfoAttendMapList);
        log.debug("update userExaminfoAttendMapList by pk end");
    }

    public void updateUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap) throws DAOException
    {
        log.debug("update userExaminfoAttendMap by conditions starting...");
        super.update("updateUserExaminfoAttendMapByCond", userExaminfoAttendMap);
        log.debug("update userExaminfoAttendMap by conditions end");
    }

    public void deleteUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DAOException
    {
        log.debug("delete userExaminfoAttendMap by pk starting...");
        super.delete("deleteUserExaminfoAttendMap", userExaminfoAttendMap);
        log.debug("delete userExaminfoAttendMap by pk end");
    }

    public void deleteUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DAOException
    {
        log.debug("delete userExaminfoAttendMapList by pk starting...");
        super.deleteBatch("deleteUserExaminfoAttendMap", userExaminfoAttendMapList);
        log.debug("delete userExaminfoAttendMapList by pk end");
    }

    public void deleteUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap) throws DAOException
    {
        log.debug("delete userExaminfoAttendMap by conditions starting...");
        super.delete("deleteUserExaminfoAttendMapByCond", userExaminfoAttendMap);
        log.debug("delete userExaminfoAttendMap by conditions end");
    }

    public UserExaminfoAttendMap getUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DAOException
    {
        log.debug("query userExaminfoAttendMap starting...");
        UserExaminfoAttendMap resultObj = (UserExaminfoAttendMap) super.queryForObject("getUserExaminfoAttendMap",
                userExaminfoAttendMap);
        log.debug("query userExaminfoAttendMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DAOException
    {
        log.debug("query userExaminfoAttendMap by condition starting...");
        List<UserExaminfoAttendMap> rList = (List<UserExaminfoAttendMap>) super.queryForList(
                "queryUserExaminfoAttendMapListByCond", userExaminfoAttendMap);
        log.debug("query userExaminfoAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCondExact(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DAOException
    {
        log.debug("query userExaminfoAttendMap by exact condition starting...");
        List<UserExaminfoAttendMap> rList = (List<UserExaminfoAttendMap>) super.queryForList(
                "queryUserExaminfoAttendMapListByCondExact", userExaminfoAttendMap);
        log.debug("query userExaminfoAttendMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userExaminfoAttendMap by condition starting...");
        List<UserExaminfoAttendMap> rList = (List<UserExaminfoAttendMap>) super.queryForList(
                "queryUserExaminfoAttendMapListByCond", userExaminfoAttendMap, puEntity);
        log.debug("query userExaminfoAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userExaminfoAttendMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super
                .queryForObject("queryUserExaminfoAttendMapListCntByCond", userExaminfoAttendMap)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserExaminfoAttendMap> rsList = (List<UserExaminfoAttendMap>) super.pageQuery(
                    "queryUserExaminfoAttendMapListByCond", userExaminfoAttendMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userExaminfoAttendMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserExaminfoAttendMapListByCond", "queryUserExaminfoAttendMapListCntByCond",
                userExaminfoAttendMap, start, pageSize, puEntity);
    }

}