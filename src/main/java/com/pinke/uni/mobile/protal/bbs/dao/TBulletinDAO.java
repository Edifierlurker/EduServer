package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TBulletinDAO extends DynamicObjectMispDAO implements ITBulletinDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTBulletin(TBulletin tbulletin) throws DAOException
    {
        log.debug("insert tbulletin starting...");
        super.insert("insertTBulletin", tbulletin);
        log.debug("insert tbulletin end");
    }

    public void insertTBulletinList(List<TBulletin> tbulletinList) throws DAOException
    {
        log.debug("insert tbulletinList starting...");
        if (null != tbulletinList)
        {
            super.insertBatch("insertTBulletin", tbulletinList);
        }
        log.debug("insert tbulletinList end");
    }

    public void updateTBulletin(TBulletin tbulletin) throws DAOException
    {
        log.debug("update tbulletin by pk starting...");
        super.update("updateTBulletin", tbulletin);
        log.debug("update tbulletin by pk end");
    }

    public void updateTBulletinList(List<TBulletin> tbulletinList) throws DAOException
    {
        log.debug("update tbulletinList by pk starting...");
        super.updateBatch("updateTBulletin", tbulletinList);
        log.debug("update tbulletinList by pk end");
    }

    public void updateTBulletinByCond(TBulletin tbulletin) throws DAOException
    {
        log.debug("update tbulletin by conditions starting...");
        super.update("updateTBulletinByCond", tbulletin);
        log.debug("update tbulletin by conditions end");
    }

    public void deleteTBulletin(TBulletin tbulletin) throws DAOException
    {
        log.debug("delete tbulletin by pk starting...");
        super.delete("deleteTBulletin", tbulletin);
        log.debug("delete tbulletin by pk end");
    }

    public void deleteTBulletinList(List<TBulletin> tbulletinList) throws DAOException
    {
        log.debug("delete tbulletinList by pk starting...");
        super.deleteBatch("deleteTBulletin", tbulletinList);
        log.debug("delete tbulletinList by pk end");
    }

    public void deleteTBulletinByCond(TBulletin tbulletin) throws DAOException
    {
        log.debug("delete tbulletin by conditions starting...");
        super.delete("deleteTBulletinByCond", tbulletin);
        log.debug("delete tbulletin by conditions end");
    }

    public TBulletin getTBulletin(TBulletin tbulletin) throws DAOException
    {
        log.debug("query tbulletin starting...");
        TBulletin resultObj = (TBulletin) super.queryForObject("getTBulletin", tbulletin);
        log.debug("query tbulletin end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TBulletin> getTBulletinByCond(TBulletin tbulletin) throws DAOException
    {
        log.debug("query tbulletin by condition starting...");
        List<TBulletin> rList = (List<TBulletin>) super.queryForList("queryTBulletinListByCond", tbulletin);
        log.debug("query tbulletin by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TBulletin> getTBulletinByCondExact(TBulletin tbulletin) throws DAOException
    {
        log.debug("query tbulletin by exact condition starting...");
        List<TBulletin> rList = (List<TBulletin>) super.queryForList("queryTBulletinListByCondExact", tbulletin);
        log.debug("query tbulletin by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TBulletin> getTBulletinByCond(TBulletin tbulletin, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tbulletin by condition starting...");
        List<TBulletin> rList = (List<TBulletin>) super.queryForList("queryTBulletinListByCond", tbulletin, puEntity);
        log.debug("query tbulletin by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize) throws DAOException
    {
        log.debug("page query tbulletin by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTBulletinListCntByCond", tbulletin)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TBulletin> rsList = (List<TBulletin>) super.pageQuery("queryTBulletinListByCond", tbulletin, start,
                    fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tbulletin by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTBulletinListByCond", "queryTBulletinListCntByCond", tbulletin, start,
                pageSize, puEntity);
    }

}