package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TMajorinfoDAO extends DynamicObjectMispDAO implements ITMajorinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTMajorinfo(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("insert tmajorinfo starting...");
        super.insert("insertTMajorinfo", tmajorinfo);
        log.debug("insert tmajorinfo end");
    }

    public void insertTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DAOException
    {
        log.debug("insert tmajorinfoList starting...");
        if (null != tmajorinfoList)
        {
            super.insertBatch("insertTMajorinfo", tmajorinfoList);
        }
        log.debug("insert tmajorinfoList end");
    }

    public void updateTMajorinfo(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("update tmajorinfo by pk starting...");
        super.update("updateTMajorinfo", tmajorinfo);
        log.debug("update tmajorinfo by pk end");
    }

    public void updateTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DAOException
    {
        log.debug("update tmajorinfoList by pk starting...");
        super.updateBatch("updateTMajorinfo", tmajorinfoList);
        log.debug("update tmajorinfoList by pk end");
    }

    public void updateTMajorinfoByCond(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("update tmajorinfo by conditions starting...");
        super.update("updateTMajorinfoByCond", tmajorinfo);
        log.debug("update tmajorinfo by conditions end");
    }

    public void deleteTMajorinfo(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("delete tmajorinfo by pk starting...");
        super.delete("deleteTMajorinfo", tmajorinfo);
        log.debug("delete tmajorinfo by pk end");
    }

    public void deleteTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DAOException
    {
        log.debug("delete tmajorinfoList by pk starting...");
        super.deleteBatch("deleteTMajorinfo", tmajorinfoList);
        log.debug("delete tmajorinfoList by pk end");
    }

    public void deleteTMajorinfoByCond(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("delete tmajorinfo by conditions starting...");
        super.delete("deleteTMajorinfoByCond", tmajorinfo);
        log.debug("delete tmajorinfo by conditions end");
    }

    public TMajorinfo getTMajorinfo(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("query tmajorinfo starting...");
        TMajorinfo resultObj = (TMajorinfo) super.queryForObject("getTMajorinfo", tmajorinfo);
        log.debug("query tmajorinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TMajorinfo> getTMajorinfoByCond(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("query tmajorinfo by condition starting...");
        List<TMajorinfo> rList = (List<TMajorinfo>) super.queryForList("queryTMajorinfoListByCond", tmajorinfo);
        log.debug("query tmajorinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TMajorinfo> getTMajorinfoByCondExact(TMajorinfo tmajorinfo) throws DAOException
    {
        log.debug("query tmajorinfo by exact condition starting...");
        List<TMajorinfo> rList = (List<TMajorinfo>) super.queryForList("queryTMajorinfoListByCondExact", tmajorinfo);
        log.debug("query tmajorinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TMajorinfo> getTMajorinfoByCond(TMajorinfo tmajorinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tmajorinfo by condition starting...");
        List<TMajorinfo> rList = (List<TMajorinfo>) super.queryForList("queryTMajorinfoListByCond", tmajorinfo,
                puEntity);
        log.debug("query tmajorinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tmajorinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTMajorinfoListCntByCond", tmajorinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TMajorinfo> rsList = (List<TMajorinfo>) super.pageQuery("queryTMajorinfoListByCond", tmajorinfo,
                    start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tmajorinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTMajorinfoListByCond", "queryTMajorinfoListCntByCond", tmajorinfo, start,
                pageSize, puEntity);
    }

}