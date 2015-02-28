package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TFriendinfoDAO extends DynamicObjectMispDAO implements ITFriendinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTFriendinfo(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("insert tfriendinfo starting...");
        super.insert("insertTFriendinfo", tfriendinfo);
        log.debug("insert tfriendinfo end");
    }

    public void insertTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DAOException
    {
        log.debug("insert tfriendinfoList starting...");
        if (null != tfriendinfoList)
        {
            super.insertBatch("insertTFriendinfo", tfriendinfoList);
        }
        log.debug("insert tfriendinfoList end");
    }

    public void updateTFriendinfo(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("update tfriendinfo by pk starting...");
        super.update("updateTFriendinfo", tfriendinfo);
        log.debug("update tfriendinfo by pk end");
    }

    public void updateTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DAOException
    {
        log.debug("update tfriendinfoList by pk starting...");
        super.updateBatch("updateTFriendinfo", tfriendinfoList);
        log.debug("update tfriendinfoList by pk end");
    }

    public void updateTFriendinfoByCond(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("update tfriendinfo by conditions starting...");
        super.update("updateTFriendinfoByCond", tfriendinfo);
        log.debug("update tfriendinfo by conditions end");
    }

    public void deleteTFriendinfo(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("delete tfriendinfo by pk starting...");
        super.delete("deleteTFriendinfo", tfriendinfo);
        log.debug("delete tfriendinfo by pk end");
    }

    public void deleteTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DAOException
    {
        log.debug("delete tfriendinfoList by pk starting...");
        super.deleteBatch("deleteTFriendinfo", tfriendinfoList);
        log.debug("delete tfriendinfoList by pk end");
    }

    public void deleteTFriendinfoByCond(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("delete tfriendinfo by conditions starting...");
        super.delete("deleteTFriendinfoByCond", tfriendinfo);
        log.debug("delete tfriendinfo by conditions end");
    }

    public TFriendinfo getTFriendinfo(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("query tfriendinfo starting...");
        TFriendinfo resultObj = (TFriendinfo) super.queryForObject("getTFriendinfo", tfriendinfo);
        log.debug("query tfriendinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfo> getTFriendinfoByCond(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("query tfriendinfo by condition starting...");
        List<TFriendinfo> rList = (List<TFriendinfo>) super.queryForList("queryTFriendinfoListByCond", tfriendinfo);
        log.debug("query tfriendinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfo> getTFriendinfoByCondExact(TFriendinfo tfriendinfo) throws DAOException
    {
        log.debug("query tfriendinfo by exact condition starting...");
        List<TFriendinfo> rList = (List<TFriendinfo>) super
                .queryForList("queryTFriendinfoListByCondExact", tfriendinfo);
        log.debug("query tfriendinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfo> getTFriendinfoByCond(TFriendinfo tfriendinfo, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tfriendinfo by condition starting...");
        List<TFriendinfo> rList = (List<TFriendinfo>) super.queryForList("queryTFriendinfoListByCond", tfriendinfo,
                puEntity);
        log.debug("query tfriendinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tfriendinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTFriendinfoListCntByCond", tfriendinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TFriendinfo> rsList = (List<TFriendinfo>) super.pageQuery("queryTFriendinfoListByCond", tfriendinfo,
                    start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tfriendinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTFriendinfoListByCond", "queryTFriendinfoListCntByCond", tfriendinfo, start,
                pageSize, puEntity);
    }

}