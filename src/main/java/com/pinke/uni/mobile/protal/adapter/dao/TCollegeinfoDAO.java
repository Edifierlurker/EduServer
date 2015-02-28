package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TCollegeinfoDAO extends DynamicObjectMispDAO implements ITCollegeinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTCollegeinfo(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("insert tcollegeinfo starting...");
        super.insert("insertTCollegeinfo", tcollegeinfo);
        log.debug("insert tcollegeinfo end");
    }

    public void insertTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DAOException
    {
        log.debug("insert tcollegeinfoList starting...");
        if (null != tcollegeinfoList)
        {
            super.insertBatch("insertTCollegeinfo", tcollegeinfoList);
        }
        log.debug("insert tcollegeinfoList end");
    }

    public void updateTCollegeinfo(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("update tcollegeinfo by pk starting...");
        super.update("updateTCollegeinfo", tcollegeinfo);
        log.debug("update tcollegeinfo by pk end");
    }

    public void updateTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DAOException
    {
        log.debug("update tcollegeinfoList by pk starting...");
        super.updateBatch("updateTCollegeinfo", tcollegeinfoList);
        log.debug("update tcollegeinfoList by pk end");
    }

    public void updateTCollegeinfoByCond(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("update tcollegeinfo by conditions starting...");
        super.update("updateTCollegeinfoByCond", tcollegeinfo);
        log.debug("update tcollegeinfo by conditions end");
    }

    public void deleteTCollegeinfo(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("delete tcollegeinfo by pk starting...");
        super.delete("deleteTCollegeinfo", tcollegeinfo);
        log.debug("delete tcollegeinfo by pk end");
    }

    public void deleteTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DAOException
    {
        log.debug("delete tcollegeinfoList by pk starting...");
        super.deleteBatch("deleteTCollegeinfo", tcollegeinfoList);
        log.debug("delete tcollegeinfoList by pk end");
    }

    public void deleteTCollegeinfoByCond(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("delete tcollegeinfo by conditions starting...");
        super.delete("deleteTCollegeinfoByCond", tcollegeinfo);
        log.debug("delete tcollegeinfo by conditions end");
    }

    public TCollegeinfo getTCollegeinfo(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("query tcollegeinfo starting...");
        TCollegeinfo resultObj = (TCollegeinfo) super.queryForObject("getTCollegeinfo", tcollegeinfo);
        log.debug("query tcollegeinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TCollegeinfo> getTCollegeinfoByCond(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("query tcollegeinfo by condition starting...");
        List<TCollegeinfo> rList = (List<TCollegeinfo>) super.queryForList("queryTCollegeinfoListByCond", tcollegeinfo);
        log.debug("query tcollegeinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TCollegeinfo> getTCollegeinfoByCondExact(TCollegeinfo tcollegeinfo) throws DAOException
    {
        log.debug("query tcollegeinfo by exact condition starting...");
        List<TCollegeinfo> rList = (List<TCollegeinfo>) super.queryForList("queryTCollegeinfoListByCondExact",
                tcollegeinfo);
        log.debug("query tcollegeinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TCollegeinfo> getTCollegeinfoByCond(TCollegeinfo tcollegeinfo, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tcollegeinfo by condition starting...");
        List<TCollegeinfo> rList = (List<TCollegeinfo>) super.queryForList("queryTCollegeinfoListByCond", tcollegeinfo,
                puEntity);
        log.debug("query tcollegeinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tcollegeinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTCollegeinfoListCntByCond", tcollegeinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TCollegeinfo> rsList = (List<TCollegeinfo>) super.pageQuery("queryTCollegeinfoListByCond",
                    tcollegeinfo, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tcollegeinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTCollegeinfoListByCond", "queryTCollegeinfoListCntByCond", tcollegeinfo,
                start, pageSize, puEntity);
    }

}