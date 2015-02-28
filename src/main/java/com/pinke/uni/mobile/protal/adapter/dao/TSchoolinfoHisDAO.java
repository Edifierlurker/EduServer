package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TSchoolinfoHisDAO extends DynamicObjectMispDAO implements ITSchoolinfoHisDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("insert tschoolinfoHis starting...");
        super.insert("insertTSchoolinfoHis", tschoolinfoHis);
        log.debug("insert tschoolinfoHis end");
    }

    public void insertTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DAOException
    {
        log.debug("insert tschoolinfoHisList starting...");
        if (null != tschoolinfoHisList)
        {
            super.insertBatch("insertTSchoolinfoHis", tschoolinfoHisList);
        }
        log.debug("insert tschoolinfoHisList end");
    }

    public void updateTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("update tschoolinfoHis by pk starting...");
        super.update("updateTSchoolinfoHis", tschoolinfoHis);
        log.debug("update tschoolinfoHis by pk end");
    }

    public void updateTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DAOException
    {
        log.debug("update tschoolinfoHisList by pk starting...");
        super.updateBatch("updateTSchoolinfoHis", tschoolinfoHisList);
        log.debug("update tschoolinfoHisList by pk end");
    }

    public void updateTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("update tschoolinfoHis by conditions starting...");
        super.update("updateTSchoolinfoHisByCond", tschoolinfoHis);
        log.debug("update tschoolinfoHis by conditions end");
    }

    public void deleteTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("delete tschoolinfoHis by pk starting...");
        super.delete("deleteTSchoolinfoHis", tschoolinfoHis);
        log.debug("delete tschoolinfoHis by pk end");
    }

    public void deleteTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DAOException
    {
        log.debug("delete tschoolinfoHisList by pk starting...");
        super.deleteBatch("deleteTSchoolinfoHis", tschoolinfoHisList);
        log.debug("delete tschoolinfoHisList by pk end");
    }

    public void deleteTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("delete tschoolinfoHis by conditions starting...");
        super.delete("deleteTSchoolinfoHisByCond", tschoolinfoHis);
        log.debug("delete tschoolinfoHis by conditions end");
    }

    public TSchoolinfoHis getTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("query tschoolinfoHis starting...");
        TSchoolinfoHis resultObj = (TSchoolinfoHis) super.queryForObject("getTSchoolinfoHis", tschoolinfoHis);
        log.debug("query tschoolinfoHis end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfoHis> getTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("query tschoolinfoHis by condition starting...");
        List<TSchoolinfoHis> rList = (List<TSchoolinfoHis>) super.queryForList("queryTSchoolinfoHisListByCond",
                tschoolinfoHis);
        log.debug("query tschoolinfoHis by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfoHis> getTSchoolinfoHisByCondExact(TSchoolinfoHis tschoolinfoHis) throws DAOException
    {
        log.debug("query tschoolinfoHis by exact condition starting...");
        List<TSchoolinfoHis> rList = (List<TSchoolinfoHis>) super.queryForList("queryTSchoolinfoHisListByCondExact",
                tschoolinfoHis);
        log.debug("query tschoolinfoHis by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfoHis> getTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tschoolinfoHis by condition starting...");
        List<TSchoolinfoHis> rList = (List<TSchoolinfoHis>) super.queryForList("queryTSchoolinfoHisListByCond",
                tschoolinfoHis, puEntity);
        log.debug("query tschoolinfoHis by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize) throws DAOException
    {
        log.debug("page query tschoolinfoHis by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTSchoolinfoHisListCntByCond", tschoolinfoHis)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TSchoolinfoHis> rsList = (List<TSchoolinfoHis>) super.pageQuery("queryTSchoolinfoHisListByCond",
                    tschoolinfoHis, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tschoolinfoHis by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTSchoolinfoHisListByCond", "queryTSchoolinfoHisListCntByCond",
                tschoolinfoHis, start, pageSize, puEntity);
    }

}