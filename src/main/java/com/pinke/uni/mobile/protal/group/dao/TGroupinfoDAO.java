package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupinfoDAO extends DynamicObjectMispDAO implements ITGroupinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupinfo(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("insert tgroupinfo starting...");
        super.insert("insertTGroupinfo", tgroupinfo);
        log.debug("insert tgroupinfo end");
    }

    public void insertTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException
    {
        log.debug("insert tgroupinfoList starting...");
        if (null != tgroupinfoList)
        {
            super.insertBatch("insertTGroupinfo", tgroupinfoList);
        }
        log.debug("insert tgroupinfoList end");
    }

    public void updateTGroupinfo(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("update tgroupinfo by pk starting...");
        super.update("updateTGroupinfo", tgroupinfo);
        log.debug("update tgroupinfo by pk end");
    }

    public void updateTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException
    {
        log.debug("update tgroupinfoList by pk starting...");
        super.updateBatch("updateTGroupinfo", tgroupinfoList);
        log.debug("update tgroupinfoList by pk end");
    }

    public void updateTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("update tgroupinfo by conditions starting...");
        super.update("updateTGroupinfoByCond", tgroupinfo);
        log.debug("update tgroupinfo by conditions end");
    }

    public void deleteTGroupinfo(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("delete tgroupinfo by pk starting...");
        super.delete("deleteTGroupinfo", tgroupinfo);
        log.debug("delete tgroupinfo by pk end");
    }

    public void deleteTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException
    {
        log.debug("delete tgroupinfoList by pk starting...");
        super.deleteBatch("deleteTGroupinfo", tgroupinfoList);
        log.debug("delete tgroupinfoList by pk end");
    }

    public void deleteTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("delete tgroupinfo by conditions starting...");
        super.delete("deleteTGroupinfoByCond", tgroupinfo);
        log.debug("delete tgroupinfo by conditions end");
    }

    public TGroupinfo getTGroupinfo(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("query tgroupinfo starting...");
        TGroupinfo resultObj = (TGroupinfo) super.queryForObject("getTGroupinfo", tgroupinfo);
        log.debug("query tgroupinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("query tgroupinfo by condition starting...");
        List<TGroupinfo> rList = (List<TGroupinfo>) super.queryForList("queryTGroupinfoListByCond", tgroupinfo);
        log.debug("query tgroupinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfo> getTGroupinfoByCondExact(TGroupinfo tgroupinfo) throws DAOException
    {
        log.debug("query tgroupinfo by exact condition starting...");
        List<TGroupinfo> rList = (List<TGroupinfo>) super.queryForList("queryTGroupinfoListByCondExact", tgroupinfo);
        log.debug("query tgroupinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tgroupinfo by condition starting...");
        List<TGroupinfo> rList = (List<TGroupinfo>) super.queryForList("queryTGroupinfoListByCond", tgroupinfo,
                puEntity);
        log.debug("query tgroupinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tgroupinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTGroupinfoListCntByCond", tgroupinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupinfo> rsList = (List<TGroupinfo>) super.pageQuery("queryTGroupinfoListByCond", tgroupinfo,
                    start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTGroupinfoListByCond", "queryTGroupinfoListCntByCond", tgroupinfo, start,
                pageSize, puEntity);
    }
    
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTGroupinfoListByCondExtends", "queryTGroupinfoListCntByCondExtends", tgroupinfo, start,
                pageSize, puEntity);
    }

}