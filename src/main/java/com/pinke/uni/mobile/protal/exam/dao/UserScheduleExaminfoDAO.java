package com.pinke.uni.mobile.protal.exam.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserScheduleExaminfoDAO extends DynamicObjectMispDAO implements IUserScheduleExaminfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("insert userScheduleExaminfo starting...");
        super.insert("insertUserScheduleExaminfo", userScheduleExaminfo);
        log.debug("insert userScheduleExaminfo end");
    }

    public void insertUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException
    {
        log.debug("insert userScheduleExaminfoList starting...");
        if (null != userScheduleExaminfoList)
        {
            super.insertBatch("insertUserScheduleExaminfo", userScheduleExaminfoList);
        }
        log.debug("insert userScheduleExaminfoList end");
    }

    public void updateUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("update userScheduleExaminfo by pk starting...");
        super.update("updateUserScheduleExaminfo", userScheduleExaminfo);
        log.debug("update userScheduleExaminfo by pk end");
    }

    public void updateUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException
    {
        log.debug("update userScheduleExaminfoList by pk starting...");
        super.updateBatch("updateUserScheduleExaminfo", userScheduleExaminfoList);
        log.debug("update userScheduleExaminfoList by pk end");
    }

    public void updateUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("update userScheduleExaminfo by conditions starting...");
        super.update("updateUserScheduleExaminfoByCond", userScheduleExaminfo);
        log.debug("update userScheduleExaminfo by conditions end");
    }

    public void deleteUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("delete userScheduleExaminfo by pk starting...");
        super.delete("deleteUserScheduleExaminfo", userScheduleExaminfo);
        log.debug("delete userScheduleExaminfo by pk end");
    }

    public void deleteUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException
    {
        log.debug("delete userScheduleExaminfoList by pk starting...");
        super.deleteBatch("deleteUserScheduleExaminfo", userScheduleExaminfoList);
        log.debug("delete userScheduleExaminfoList by pk end");
    }

    public void deleteUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("delete userScheduleExaminfo by conditions starting...");
        super.delete("deleteUserScheduleExaminfoByCond", userScheduleExaminfo);
        log.debug("delete userScheduleExaminfo by conditions end");
    }

    public UserScheduleExaminfo getUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException
    {
        log.debug("query userScheduleExaminfo starting...");
        UserScheduleExaminfo resultObj = (UserScheduleExaminfo) super.queryForObject("getUserScheduleExaminfo",
                userScheduleExaminfo);
        log.debug("query userScheduleExaminfo end");
        return resultObj;
    }

    public UserScheduleExaminfoExtends getUserScheduleExaminfoExtends(UserScheduleExaminfoExtends userScheduleExaminfo)
            throws DAOException
    {
        log.debug("query userScheduleExaminfo starting...");
        UserScheduleExaminfoExtends resultObj = (UserScheduleExaminfoExtends) super.queryForObject(
                "getUserScheduleExaminfoExtends", userScheduleExaminfo);
        log.debug("query userScheduleExaminfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DAOException
    {
        log.debug("query userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfo> rList = (List<UserScheduleExaminfo>) super.queryForList(
                "queryUserScheduleExaminfoListByCond", userScheduleExaminfo);
        log.debug("query userScheduleExaminfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCondExact(UserScheduleExaminfo userScheduleExaminfo)
            throws DAOException
    {
        log.debug("query userScheduleExaminfo by exact condition starting...");
        List<UserScheduleExaminfo> rList = (List<UserScheduleExaminfo>) super.queryForList(
                "queryUserScheduleExaminfoListByCondExact", userScheduleExaminfo);
        log.debug("query userScheduleExaminfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfo> rList = (List<UserScheduleExaminfo>) super.queryForList(
                "queryUserScheduleExaminfoListByCond", userScheduleExaminfo, puEntity);
        log.debug("query userScheduleExaminfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query userScheduleExaminfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleExaminfoListCntByCond", userScheduleExaminfo))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserScheduleExaminfo> rsList = (List<UserScheduleExaminfo>) super.pageQuery(
                    "queryUserScheduleExaminfoListByCond", userScheduleExaminfo, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userScheduleExaminfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleExaminfoListByCond", "queryUserScheduleExaminfoListCntByCond",
                userScheduleExaminfo, start, pageSize, puEntity);
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(UserScheduleExaminfoExtends userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleExaminfoListByCondExtends",
                "queryUserScheduleExaminfoListCntByCondExtends", userScheduleExaminfo, start, pageSize, puEntity);
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtendsMore(UserScheduleExaminfoExtends userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleExaminfoListByCondExtendsMore",
                "queryUserScheduleExaminfoListCntByCondExtendsMore", userScheduleExaminfo, start, pageSize, puEntity);
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtends(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DAOException
    {
        log.debug("query userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfoExtends> rList = (List<UserScheduleExaminfoExtends>) super.queryForList(
                "queryUserScheduleExaminfoListByCondExtends", userScheduleExaminfo);
        log.debug("query userScheduleExaminfo by condition end");
        return rList;
    }

    /**
     * 查询用户已经参加的考试列表
     * 
     * @param userScheduleExaminfo
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtendsMore(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DAOException
    {
        log.debug("query userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfoExtends> rList = (List<UserScheduleExaminfoExtends>) super.queryForList(
                "queryUserScheduleExaminfoListByCondExtendsMore", userScheduleExaminfo);
        log.debug("query userScheduleExaminfo by condition end");
        return rList;
    }

}