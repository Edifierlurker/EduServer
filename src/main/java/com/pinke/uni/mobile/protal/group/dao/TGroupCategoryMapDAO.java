package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupCategoryMapDAO extends DynamicObjectMispDAO implements ITGroupCategoryMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("insert tgroupCategoryMap starting...");
        super.insert("insertTGroupCategoryMap", tgroupCategoryMap);
        log.debug("insert tgroupCategoryMap end");
    }

    public void insertTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList) throws DAOException
    {
        log.debug("insert tgroupCategoryMapList starting...");
        if (null != tgroupCategoryMapList)
        {
            super.insertBatch("insertTGroupCategoryMap", tgroupCategoryMapList);
        }
        log.debug("insert tgroupCategoryMapList end");
    }

    public void updateTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("update tgroupCategoryMap by pk starting...");
        super.update("updateTGroupCategoryMap", tgroupCategoryMap);
        log.debug("update tgroupCategoryMap by pk end");
    }

    public void updateTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList) throws DAOException
    {
        log.debug("update tgroupCategoryMapList by pk starting...");
        super.updateBatch("updateTGroupCategoryMap", tgroupCategoryMapList);
        log.debug("update tgroupCategoryMapList by pk end");
    }

    public void updateTGroupCategoryMapByCond(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("update tgroupCategoryMap by conditions starting...");
        super.update("updateTGroupCategoryMapByCond", tgroupCategoryMap);
        log.debug("update tgroupCategoryMap by conditions end");
    }

    public void deleteTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("delete tgroupCategoryMap by pk starting...");
        super.delete("deleteTGroupCategoryMap", tgroupCategoryMap);
        log.debug("delete tgroupCategoryMap by pk end");
    }

    public void deleteTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList) throws DAOException
    {
        log.debug("delete tgroupCategoryMapList by pk starting...");
        super.deleteBatch("deleteTGroupCategoryMap", tgroupCategoryMapList);
        log.debug("delete tgroupCategoryMapList by pk end");
    }

    public void deleteTGroupCategoryMapByCond(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("delete tgroupCategoryMap by conditions starting...");
        super.delete("deleteTGroupCategoryMapByCond", tgroupCategoryMap);
        log.debug("delete tgroupCategoryMap by conditions end");
    }

    public TGroupCategoryMap getTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("query tgroupCategoryMap starting...");
        TGroupCategoryMap resultObj = (TGroupCategoryMap) super.queryForObject("getTGroupCategoryMap",
                tgroupCategoryMap);
        log.debug("query tgroupCategoryMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategoryMap> getTGroupCategoryMapByCond(TGroupCategoryMap tgroupCategoryMap) throws DAOException
    {
        log.debug("query tgroupCategoryMap by condition starting...");
        List<TGroupCategoryMap> rList = (List<TGroupCategoryMap>) super.queryForList(
                "queryTGroupCategoryMapListByCond", tgroupCategoryMap);
        log.debug("query tgroupCategoryMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategoryMap> getTGroupCategoryMapByCondExact(TGroupCategoryMap tgroupCategoryMap)
            throws DAOException
    {
        log.debug("query tgroupCategoryMap by exact condition starting...");
        List<TGroupCategoryMap> rList = (List<TGroupCategoryMap>) super.queryForList(
                "queryTGroupCategoryMapListByCondExact", tgroupCategoryMap);
        log.debug("query tgroupCategoryMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategoryMap> getTGroupCategoryMapByCond(TGroupCategoryMap tgroupCategoryMap,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tgroupCategoryMap by condition starting...");
        List<TGroupCategoryMap> rList = (List<TGroupCategoryMap>) super.queryForList(
                "queryTGroupCategoryMapListByCond", tgroupCategoryMap, puEntity);
        log.debug("query tgroupCategoryMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize) throws DAOException
    {
        log.debug("page query tgroupCategoryMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTGroupCategoryMapListCntByCond", tgroupCategoryMap))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupCategoryMap> rsList = (List<TGroupCategoryMap>) super.pageQuery(
                    "queryTGroupCategoryMapListByCond", tgroupCategoryMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupCategoryMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTGroupCategoryMapListByCond", "queryTGroupCategoryMapListCntByCond",
                tgroupCategoryMap, start, pageSize, puEntity);
    }

}