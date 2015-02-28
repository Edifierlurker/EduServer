package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TNearStudentDAO extends DynamicObjectMispDAO implements ITNearStudentDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTNearStudent(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("insert tnearStudent starting...");
        super.insert("insertTNearStudent", tnearStudent);
        log.debug("insert tnearStudent end");
    }

    public void insertTNearStudentList(List<TNearStudent> tnearStudentList) throws DAOException
    {
        log.debug("insert tnearStudentList starting...");
        if (null != tnearStudentList)
        {
            super.insertBatch("insertTNearStudent", tnearStudentList);
        }
        log.debug("insert tnearStudentList end");
    }

    public void updateTNearStudent(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("update tnearStudent by pk starting...");
        super.update("updateTNearStudent", tnearStudent);
        log.debug("update tnearStudent by pk end");
    }

    public void updateTNearStudentList(List<TNearStudent> tnearStudentList) throws DAOException
    {
        log.debug("update tnearStudentList by pk starting...");
        super.updateBatch("updateTNearStudent", tnearStudentList);
        log.debug("update tnearStudentList by pk end");
    }

    public void updateTNearStudentByCond(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("update tnearStudent by conditions starting...");
        super.update("updateTNearStudentByCond", tnearStudent);
        log.debug("update tnearStudent by conditions end");
    }

    public void deleteTNearStudent(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("delete tnearStudent by pk starting...");
        super.delete("deleteTNearStudent", tnearStudent);
        log.debug("delete tnearStudent by pk end");
    }

    public void deleteTNearStudentList(List<TNearStudent> tnearStudentList) throws DAOException
    {
        log.debug("delete tnearStudentList by pk starting...");
        super.deleteBatch("deleteTNearStudent", tnearStudentList);
        log.debug("delete tnearStudentList by pk end");
    }

    public void deleteTNearStudentByCond(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("delete tnearStudent by conditions starting...");
        super.delete("deleteTNearStudentByCond", tnearStudent);
        log.debug("delete tnearStudent by conditions end");
    }

    public TNearStudent getTNearStudent(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("query tnearStudent starting...");
        TNearStudent resultObj = (TNearStudent) super.queryForObject("getTNearStudent", tnearStudent);
        log.debug("query tnearStudent end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TNearStudent> getTNearStudentByCond(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("query tnearStudent by condition starting...");
        List<TNearStudent> rList = (List<TNearStudent>) super.queryForList("queryTNearStudentListByCond", tnearStudent);
        log.debug("query tnearStudent by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TNearStudent> getTNearStudentByCondExact(TNearStudent tnearStudent) throws DAOException
    {
        log.debug("query tnearStudent by exact condition starting...");
        List<TNearStudent> rList = (List<TNearStudent>) super.queryForList("queryTNearStudentListByCondExact",
                tnearStudent);
        log.debug("query tnearStudent by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TNearStudent> getTNearStudentByCond(TNearStudent tnearStudent, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tnearStudent by condition starting...");
        List<TNearStudent> rList = (List<TNearStudent>) super.queryForList("queryTNearStudentListByCond", tnearStudent,
                puEntity);
        log.debug("query tnearStudent by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize) throws DAOException
    {
        log.debug("page query tnearStudent by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTNearStudentListCntByCond", tnearStudent)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TNearStudent> rsList = (List<TNearStudent>) super.pageQuery("queryTNearStudentListByCond",
                    tnearStudent, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tnearStudent by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTNearStudentListByCond", "queryTNearStudentListCntByCond", tnearStudent,
                start, pageSize, puEntity);
    }

}