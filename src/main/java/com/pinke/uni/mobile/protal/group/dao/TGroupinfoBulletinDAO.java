package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupinfoBulletinDAO extends DynamicObjectMispDAO implements ITGroupinfoBulletinDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("insert tgroupinfoBulletin starting...");
        super.insert("insertTGroupinfoBulletin", tgroupinfoBulletin);
        log.debug("insert tgroupinfoBulletin end");
    }

    public void insertTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList) throws DAOException
    {
        log.debug("insert tgroupinfoBulletinList starting...");
        if (null != tgroupinfoBulletinList)
        {
            super.insertBatch("insertTGroupinfoBulletin", tgroupinfoBulletinList);
        }
        log.debug("insert tgroupinfoBulletinList end");
    }

    public void updateTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("update tgroupinfoBulletin by pk starting...");
        super.update("updateTGroupinfoBulletin", tgroupinfoBulletin);
        log.debug("update tgroupinfoBulletin by pk end");
    }

    public void updateTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList) throws DAOException
    {
        log.debug("update tgroupinfoBulletinList by pk starting...");
        super.updateBatch("updateTGroupinfoBulletin", tgroupinfoBulletinList);
        log.debug("update tgroupinfoBulletinList by pk end");
    }

    public void updateTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("update tgroupinfoBulletin by conditions starting...");
        super.update("updateTGroupinfoBulletinByCond", tgroupinfoBulletin);
        log.debug("update tgroupinfoBulletin by conditions end");
    }

    public void deleteTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("delete tgroupinfoBulletin by pk starting...");
        super.delete("deleteTGroupinfoBulletin", tgroupinfoBulletin);
        log.debug("delete tgroupinfoBulletin by pk end");
    }

    public void deleteTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList) throws DAOException
    {
        log.debug("delete tgroupinfoBulletinList by pk starting...");
        super.deleteBatch("deleteTGroupinfoBulletin", tgroupinfoBulletinList);
        log.debug("delete tgroupinfoBulletinList by pk end");
    }

    public void deleteTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("delete tgroupinfoBulletin by conditions starting...");
        super.delete("deleteTGroupinfoBulletinByCond", tgroupinfoBulletin);
        log.debug("delete tgroupinfoBulletin by conditions end");
    }

    public TGroupinfoBulletin getTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DAOException
    {
        log.debug("query tgroupinfoBulletin starting...");
        TGroupinfoBulletin resultObj = (TGroupinfoBulletin) super.queryForObject("getTGroupinfoBulletin",
                tgroupinfoBulletin);
        log.debug("query tgroupinfoBulletin end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin)
            throws DAOException
    {
        log.debug("query tgroupinfoBulletin by condition starting...");
        List<TGroupinfoBulletin> rList = (List<TGroupinfoBulletin>) super.queryForList(
                "queryTGroupinfoBulletinListByCond", tgroupinfoBulletin);
        log.debug("query tgroupinfoBulletin by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCondExact(TGroupinfoBulletin tgroupinfoBulletin)
            throws DAOException
    {
        log.debug("query tgroupinfoBulletin by exact condition starting...");
        List<TGroupinfoBulletin> rList = (List<TGroupinfoBulletin>) super.queryForList(
                "queryTGroupinfoBulletinListByCondExact", tgroupinfoBulletin);
        log.debug("query tgroupinfoBulletin by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tgroupinfoBulletin by condition starting...");
        List<TGroupinfoBulletin> rList = (List<TGroupinfoBulletin>) super.queryForList(
                "queryTGroupinfoBulletinListByCond", tgroupinfoBulletin, puEntity);
        log.debug("query tgroupinfoBulletin by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize) throws DAOException
    {
        log.debug("page query tgroupinfoBulletin by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTGroupinfoBulletinListCntByCond", tgroupinfoBulletin))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupinfoBulletin> rsList = (List<TGroupinfoBulletin>) super.pageQuery(
                    "queryTGroupinfoBulletinListByCond", tgroupinfoBulletin, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupinfoBulletin by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryTGroupinfoBulletinListByCond", "queryTGroupinfoBulletinListCntByCond",
                tgroupinfoBulletin, start, pageSize, puEntity);
    }

}