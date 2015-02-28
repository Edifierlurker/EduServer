package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TClassinfoDAO extends DynamicObjectMispDAO implements ITClassinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTClassinfo(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("insert tclassinfo starting...");
        super.insert("insertTClassinfo", tclassinfo);
        log.debug("insert tclassinfo end");
    }

    public void insertTClassinfoList(List<TClassinfo> tclassinfoList) throws DAOException
    {
        log.debug("insert tclassinfoList starting...");
        if (null != tclassinfoList)
        {
            super.insertBatch("insertTClassinfo", tclassinfoList);
        }
        log.debug("insert tclassinfoList end");
    }

    public void updateTClassinfo(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("update tclassinfo by pk starting...");
        super.update("updateTClassinfo", tclassinfo);
        log.debug("update tclassinfo by pk end");
    }

    public void updateTClassinfoList(List<TClassinfo> tclassinfoList) throws DAOException
    {
        log.debug("update tclassinfoList by pk starting...");
        super.updateBatch("updateTClassinfo", tclassinfoList);
        log.debug("update tclassinfoList by pk end");
    }

    public void updateTClassinfoByCond(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("update tclassinfo by conditions starting...");
        super.update("updateTClassinfoByCond", tclassinfo);
        log.debug("update tclassinfo by conditions end");
    }

    public void deleteTClassinfo(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("delete tclassinfo by pk starting...");
        super.delete("deleteTClassinfo", tclassinfo);
        log.debug("delete tclassinfo by pk end");
    }

    public void deleteTClassinfoList(List<TClassinfo> tclassinfoList) throws DAOException
    {
        log.debug("delete tclassinfoList by pk starting...");
        super.deleteBatch("deleteTClassinfo", tclassinfoList);
        log.debug("delete tclassinfoList by pk end");
    }

    public void deleteTClassinfoByCond(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("delete tclassinfo by conditions starting...");
        super.delete("deleteTClassinfoByCond", tclassinfo);
        log.debug("delete tclassinfo by conditions end");
    }

    public TClassinfo getTClassinfo(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("query tclassinfo starting...");
        TClassinfo resultObj = (TClassinfo) super.queryForObject("getTClassinfo", tclassinfo);
        log.debug("query tclassinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TClassinfo> getTClassinfoByCond(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("query tclassinfo by condition starting...");
        List<TClassinfo> rList = (List<TClassinfo>) super.queryForList("queryTClassinfoListByCond", tclassinfo);
        log.debug("query tclassinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TClassinfo> getTClassinfoByCondExact(TClassinfo tclassinfo) throws DAOException
    {
        log.debug("query tclassinfo by exact condition starting...");
        List<TClassinfo> rList = (List<TClassinfo>) super.queryForList("queryTClassinfoListByCondExact", tclassinfo);
        log.debug("query tclassinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TClassinfo> getTClassinfoByCond(TClassinfo tclassinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tclassinfo by condition starting...");
        List<TClassinfo> rList = (List<TClassinfo>) super.queryForList("queryTClassinfoListByCond", tclassinfo,
                puEntity);
        log.debug("query tclassinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tclassinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTClassinfoListCntByCond", tclassinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TClassinfo> rsList = (List<TClassinfo>) super.pageQuery("queryTClassinfoListByCond", tclassinfo,
                    start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tclassinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTClassinfoListByCond", "queryTClassinfoListCntByCond", tclassinfo, start,
                pageSize, puEntity);
    }

}