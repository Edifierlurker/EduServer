package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupinfoAttendMapDAO extends DynamicObjectMispDAO implements ITGroupinfoAttendMapDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("insert tgroupinfoAttendMap starting...");
        super.insert("insertTGroupinfoAttendMap", tgroupinfoAttendMap);
        log.debug("insert tgroupinfoAttendMap end");
    }

    public void insertTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList) throws DAOException
    {
        log.debug("insert tgroupinfoAttendMapList starting...");
        if (null != tgroupinfoAttendMapList)
        {
            super.insertBatch("insertTGroupinfoAttendMap", tgroupinfoAttendMapList);
        }
        log.debug("insert tgroupinfoAttendMapList end");
    }

    public void updateTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("update tgroupinfoAttendMap by pk starting...");
        super.update("updateTGroupinfoAttendMap", tgroupinfoAttendMap);
        log.debug("update tgroupinfoAttendMap by pk end");
    }

    public void updateTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList) throws DAOException
    {
        log.debug("update tgroupinfoAttendMapList by pk starting...");
        super.updateBatch("updateTGroupinfoAttendMap", tgroupinfoAttendMapList);
        log.debug("update tgroupinfoAttendMapList by pk end");
    }

    public void updateTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("update tgroupinfoAttendMap by conditions starting...");
        super.update("updateTGroupinfoAttendMapByCond", tgroupinfoAttendMap);
        log.debug("update tgroupinfoAttendMap by conditions end");
    }

    public void deleteTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("delete tgroupinfoAttendMap by pk starting...");
        super.delete("deleteTGroupinfoAttendMap", tgroupinfoAttendMap);
        log.debug("delete tgroupinfoAttendMap by pk end");
    }

    public void deleteTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList) throws DAOException
    {
        log.debug("delete tgroupinfoAttendMapList by pk starting...");
        super.deleteBatch("deleteTGroupinfoAttendMap", tgroupinfoAttendMapList);
        log.debug("delete tgroupinfoAttendMapList by pk end");
    }

    public void deleteTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("delete tgroupinfoAttendMap by conditions starting...");
        super.delete("deleteTGroupinfoAttendMapByCond", tgroupinfoAttendMap);
        log.debug("delete tgroupinfoAttendMap by conditions end");
    }

    public TGroupinfoAttendMap getTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DAOException
    {
        log.debug("query tgroupinfoAttendMap starting...");
        TGroupinfoAttendMap resultObj = (TGroupinfoAttendMap) super.queryForObject("getTGroupinfoAttendMap",
                tgroupinfoAttendMap);
        log.debug("query tgroupinfoAttendMap end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DAOException
    {
        log.debug("query tgroupinfoAttendMap by condition starting...");
        List<TGroupinfoAttendMap> rList = (List<TGroupinfoAttendMap>) super.queryForList(
                "queryTGroupinfoAttendMapListByCondExtends", tgroupinfoAttendMap);
        log.debug("query tgroupinfoAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCondExact(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DAOException
    {
        log.debug("query tgroupinfoAttendMap by exact condition starting...");
        List<TGroupinfoAttendMap> rList = (List<TGroupinfoAttendMap>) super.queryForList(
                "queryTGroupinfoAttendMapListByCondExact", tgroupinfoAttendMap);
        log.debug("query tgroupinfoAttendMap by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tgroupinfoAttendMap by condition starting...");
        List<TGroupinfoAttendMap> rList = (List<TGroupinfoAttendMap>) super.queryForList(
                "queryTGroupinfoAttendMapListByCond", tgroupinfoAttendMap, puEntity);
        log.debug("query tgroupinfoAttendMap by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize) throws DAOException
    {
        log.debug("page query tgroupinfoAttendMap by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTGroupinfoAttendMapListCntByCond", tgroupinfoAttendMap))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupinfoAttendMap> rsList = (List<TGroupinfoAttendMap>) super.pageQuery(
                    "queryTGroupinfoAttendMapListByCond", tgroupinfoAttendMap, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupinfoAttendMap by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryTGroupinfoAttendMapListByCond", "queryTGroupinfoAttendMapListCntByCond",
                tgroupinfoAttendMap, start, pageSize, puEntity);
    }
    
    @SuppressWarnings("unchecked")
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapChatList(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DAOException
    {
        log.debug("query tgroupinfoAttendMap by condition starting...");
        List<TGroupinfoAttendMap> rList = (List<TGroupinfoAttendMap>) super.queryForList(
                "queryTGroupinfoAttendMapListByCond", tgroupinfoAttendMap);
        log.debug("query tgroupinfoAttendMap by condition end");
        return rList;
    }
    
    @SuppressWarnings("unchecked")
    public List<TGroupinfoAttendMap> getTGroupinfoAttendChat(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DAOException
    {
        log.debug("query tgroupinfoAttendMap by condition starting...");
        List<TGroupinfoAttendMap> rList = (List<TGroupinfoAttendMap>) super.queryForList(
                "queryTGroupinfoAttendMapListByCond", tgroupinfoAttendMap);
        log.debug("query tgroupinfoAttendMap by condition end");
        return rList;
    }

}