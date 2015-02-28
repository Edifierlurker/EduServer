package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TSchoolinfoDAO extends DynamicObjectMispDAO implements ITSchoolinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTSchoolinfo(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("insert tschoolinfo starting...");
        super.insert("insertTSchoolinfo", tschoolinfo);
        log.debug("insert tschoolinfo end");
    }

    public void insertTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DAOException
    {
        log.debug("insert tschoolinfoList starting...");
        if (null != tschoolinfoList)
        {
            super.insertBatch("insertTSchoolinfo", tschoolinfoList);
        }
        log.debug("insert tschoolinfoList end");
    }

    public void updateTSchoolinfo(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("update tschoolinfo by pk starting...");
        super.update("updateTSchoolinfo", tschoolinfo);
        log.debug("update tschoolinfo by pk end");
    }

    public void updateTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DAOException
    {
        log.debug("update tschoolinfoList by pk starting...");
        super.updateBatch("updateTSchoolinfo", tschoolinfoList);
        log.debug("update tschoolinfoList by pk end");
    }

    public void updateTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("update tschoolinfo by conditions starting...");
        super.update("updateTSchoolinfoByCond", tschoolinfo);
        log.debug("update tschoolinfo by conditions end");
    }

    public void deleteTSchoolinfo(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("delete tschoolinfo by pk starting...");
        super.delete("deleteTSchoolinfo", tschoolinfo);
        log.debug("delete tschoolinfo by pk end");
    }

    public void deleteTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DAOException
    {
        log.debug("delete tschoolinfoList by pk starting...");
        super.deleteBatch("deleteTSchoolinfo", tschoolinfoList);
        log.debug("delete tschoolinfoList by pk end");
    }

    public void deleteTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("delete tschoolinfo by conditions starting...");
        super.delete("deleteTSchoolinfoByCond", tschoolinfo);
        log.debug("delete tschoolinfo by conditions end");
    }

    public TSchoolinfo getTSchoolinfo(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("query tschoolinfo starting...");
        TSchoolinfo resultObj = (TSchoolinfo) super.queryForObject("getTSchoolinfo", tschoolinfo);
        log.debug("query tschoolinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfo> getTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("query tschoolinfo by condition starting...");
        List<TSchoolinfo> rList = (List<TSchoolinfo>) super.queryForList("queryTSchoolinfoListByCond", tschoolinfo);
        log.debug("query tschoolinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfo> getTSchoolinfoByCondExact(TSchoolinfo tschoolinfo) throws DAOException
    {
        log.debug("query tschoolinfo by exact condition starting...");
        List<TSchoolinfo> rList = (List<TSchoolinfo>) super
                .queryForList("queryTSchoolinfoListByCondExact", tschoolinfo);
        log.debug("query tschoolinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TSchoolinfo> getTSchoolinfoByCond(TSchoolinfo tschoolinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tschoolinfo by condition starting...");
        List<TSchoolinfo> rList = (List<TSchoolinfo>) super.queryForList("queryTSchoolinfoListByCond", tschoolinfo,
                puEntity);
        log.debug("query tschoolinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tschoolinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTSchoolinfoListCntByCond", tschoolinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TSchoolinfo> rsList = (List<TSchoolinfo>) super.pageQuery("queryTSchoolinfoListByCond", tschoolinfo,
                    start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tschoolinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTSchoolinfoListByCond", "queryTSchoolinfoListCntByCond", tschoolinfo, start,
                pageSize, puEntity);
    }

}