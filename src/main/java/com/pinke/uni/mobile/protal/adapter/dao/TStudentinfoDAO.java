package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TStudentinfoDAO extends DynamicObjectMispDAO implements ITStudentinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTStudentinfo(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("insert tstudentinfo starting...");
        super.insert("insertTStudentinfo", tstudentinfo);
        log.debug("insert tstudentinfo end");
    }

    public void insertTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DAOException
    {
        log.debug("insert tstudentinfoList starting...");
        if (null != tstudentinfoList)
        {
            super.insertBatch("insertTStudentinfo", tstudentinfoList);
        }
        log.debug("insert tstudentinfoList end");
    }

    public void updateTStudentinfo(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("update tstudentinfo by pk starting...");
        super.update("updateTStudentinfo", tstudentinfo);
        log.debug("update tstudentinfo by pk end");
    }

    public void updateTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DAOException
    {
        log.debug("update tstudentinfoList by pk starting...");
        super.updateBatch("updateTStudentinfo", tstudentinfoList);
        log.debug("update tstudentinfoList by pk end");
    }

    public void updateTStudentinfoByCond(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("update tstudentinfo by conditions starting...");
        super.update("updateTStudentinfoByCond", tstudentinfo);
        log.debug("update tstudentinfo by conditions end");
    }

    public void deleteTStudentinfo(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("delete tstudentinfo by pk starting...");
        super.delete("deleteTStudentinfo", tstudentinfo);
        log.debug("delete tstudentinfo by pk end");
    }

    public void deleteTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DAOException
    {
        log.debug("delete tstudentinfoList by pk starting...");
        super.deleteBatch("deleteTStudentinfo", tstudentinfoList);
        log.debug("delete tstudentinfoList by pk end");
    }

    public void deleteTStudentinfoByCond(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("delete tstudentinfo by conditions starting...");
        super.delete("deleteTStudentinfoByCond", tstudentinfo);
        log.debug("delete tstudentinfo by conditions end");
    }

    public TStudentinfo getTStudentinfo(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("query tstudentinfo starting...");
        TStudentinfo resultObj = (TStudentinfo) super.queryForObject("getTStudentinfo", tstudentinfo);
        log.debug("query tstudentinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TStudentinfo> getTStudentinfoByCond(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("query tstudentinfo by condition starting...");
        List<TStudentinfo> rList = (List<TStudentinfo>) super.queryForList("queryTStudentinfoListByCondTempExtends", tstudentinfo);
        log.debug("query tstudentinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TStudentinfo> getTStudentinfoByCondExact(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("query tstudentinfo by exact condition starting...");
        List<TStudentinfo> rList = (List<TStudentinfo>) super.queryForList("queryTStudentinfoListByCondExact",
                tstudentinfo);
        log.debug("query tstudentinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TStudentinfo> getTStudentinfoByCond(TStudentinfo tstudentinfo, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tstudentinfo by condition starting...");
        List<TStudentinfo> rList = (List<TStudentinfo>) super.queryForList("queryTStudentinfoListByCond", tstudentinfo,
                puEntity);
        log.debug("query tstudentinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tstudentinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTStudentinfoListCntByCond", tstudentinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TStudentinfo> rsList = (List<TStudentinfo>) super.pageQuery("queryTStudentinfoListByCond",
                    tstudentinfo, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tstudentinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTStudentinfoListByCondExtends", "queryTStudentinfoListCntByCondExtends", tstudentinfo,
                start, pageSize, puEntity);
    }
    
    public TStudentinfo getTStudentinfoByUserCode(TStudentinfo tstudentinfo) throws DAOException
    {
        log.debug("query tstudentinfo starting...");
        TStudentinfo resultObj = (TStudentinfo) super.queryForObject("getTStudentinfoByUsercode", tstudentinfo);
        log.debug("query tstudentinfo end");
        return resultObj;
    }

}