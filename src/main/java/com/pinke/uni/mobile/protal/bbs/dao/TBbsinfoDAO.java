package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TBbsinfoDAO extends DynamicObjectMispDAO implements ITBbsinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTBbsinfo(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("insert tbbsinfo starting...");
        super.insert("insertTBbsinfo", tbbsinfo);
        log.debug("insert tbbsinfo end");
    }

    public void insertTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DAOException
    {
        log.debug("insert tbbsinfoList starting...");
        if (null != tbbsinfoList)
        {
            super.insertBatch("insertTBbsinfo", tbbsinfoList);
        }
        log.debug("insert tbbsinfoList end");
    }

    public void updateTBbsinfo(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("update tbbsinfo by pk starting...");
        super.update("updateTBbsinfo", tbbsinfo);
        log.debug("update tbbsinfo by pk end");
    }

    public void updateTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DAOException
    {
        log.debug("update tbbsinfoList by pk starting...");
        super.updateBatch("updateTBbsinfo", tbbsinfoList);
        log.debug("update tbbsinfoList by pk end");
    }

    public void updateTBbsinfoByCond(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("update tbbsinfo by conditions starting...");
        super.update("updateTBbsinfoByCond", tbbsinfo);
        log.debug("update tbbsinfo by conditions end");
    }

    public void deleteTBbsinfo(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("delete tbbsinfo by pk starting...");
        super.delete("deleteTBbsinfo", tbbsinfo);
        log.debug("delete tbbsinfo by pk end");
    }

    public void deleteTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DAOException
    {
        log.debug("delete tbbsinfoList by pk starting...");
        super.deleteBatch("deleteTBbsinfo", tbbsinfoList);
        log.debug("delete tbbsinfoList by pk end");
    }

    public void deleteTBbsinfoByCond(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("delete tbbsinfo by conditions starting...");
        super.delete("deleteTBbsinfoByCond", tbbsinfo);
        log.debug("delete tbbsinfo by conditions end");
    }

    public TBbsinfo getTBbsinfo(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("query tbbsinfo starting...");
        TBbsinfo resultObj = (TBbsinfo) super.queryForObject("getTBbsinfo", tbbsinfo);
        log.debug("query tbbsinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TBbsinfo> getTBbsinfoByCond(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("query tbbsinfo by condition starting...");
        List<TBbsinfo> rList = (List<TBbsinfo>) super.queryForList("queryTBbsinfoListByCond", tbbsinfo);
        log.debug("query tbbsinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TBbsinfo> getTBbsinfoByCondExact(TBbsinfo tbbsinfo) throws DAOException
    {
        log.debug("query tbbsinfo by exact condition starting...");
        List<TBbsinfo> rList = (List<TBbsinfo>) super.queryForList("queryTBbsinfoListByCondExact", tbbsinfo);
        log.debug("query tbbsinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TBbsinfo> getTBbsinfoByCond(TBbsinfo tbbsinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tbbsinfo by condition starting...");
        List<TBbsinfo> rList = (List<TBbsinfo>) super.queryForList("queryTBbsinfoListByCond", tbbsinfo, puEntity);
        log.debug("query tbbsinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tbbsinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTBbsinfoListCntByCond", tbbsinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TBbsinfo> rsList = (List<TBbsinfo>) super.pageQuery("queryTBbsinfoListByCond", tbbsinfo, start,
                    fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tbbsinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTBbsinfoListByCond", "queryTBbsinfoListCntByCond", tbbsinfo, start, pageSize,
                puEntity);
    }

}