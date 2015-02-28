package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITBbsinfoNoticeMapDAO;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBbsinfoNoticeMapDS extends DynamicObjectBaseDS implements ITBbsinfoNoticeMapDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITBbsinfoNoticeMapDAO dao = null;

    public void setDao(ITBbsinfoNoticeMapDAO dao)
    {
        this.dao = dao;
    }

    public void insertTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("insert tbbsinfoNoticeMap starting...");
        try
        {
            // if (null == tbbsinfoNoticeMap.getMapindex())
            // {
            // tbbsinfoNoticeMap.setMapindex((Long)
            // this.getPrimaryKeyGenerator().getPrimarykey("t_bbsinfo_notice_map"));
            // }
            dao.insertTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbbsinfoNoticeMap end");
    }

    public void insertTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        log.debug("insert tbbsinfoNoticeMapList by pk starting...");
        if (null == tbbsinfoNoticeMapList || tbbsinfoNoticeMapList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoNoticeMapList");
            return;
        }
        try
        {
            int listSize = tbbsinfoNoticeMapList.size();
            Long index = (Long) Sequence.getSequence("t_bbsinfo_notice_map", listSize);
            for (int i = 0; i < tbbsinfoNoticeMapList.size(); i++)
            {
                if (tbbsinfoNoticeMapList.get(i) != null)
                {
                    if (null == tbbsinfoNoticeMapList.get(i).getMapindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tbbsinfoNoticeMapList.get(i).setMapindex(primaryindex);
                    }
                }
            }
            dao.insertTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbbsinfoNoticeMapList by pk end");
    }

    public void updateTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("update tbbsinfoNoticeMap by pk starting...");
        try
        {
            dao.updateTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfoNoticeMap by pk end");
    }

    public void updateTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        log.debug("update tbbsinfoNoticeMapList by pk starting...");
        if (null == tbbsinfoNoticeMapList || tbbsinfoNoticeMapList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoNoticeMapList");
            return;
        }
        try
        {
            dao.updateTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfoNoticeMapList by pk end");
    }

    public void updateTBbsinfoNoticeMapByCond(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("update tbbsinfoNoticeMap by condition starting...");
        try
        {
            dao.updateTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfoNoticeMap by condition end");
    }

    public void removeTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("remove tbbsinfoNoticeMap by pk starting...");
        try
        {
            dao.deleteTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfoNoticeMap by pk end");
    }

    public void removeTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        log.debug("remove tbbsinfoNoticeMapList by pk starting...");
        if (null == tbbsinfoNoticeMapList || tbbsinfoNoticeMapList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoNoticeMapList");
            return;
        }
        try
        {
            dao.deleteTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfoNoticeMapList by pk end");
    }

    public void removeTBbsinfoNoticeMapByCond(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("remove tbbsinfoNoticeMap by condition starting...");
        try
        {
            dao.deleteTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfoNoticeMap by condition end");
    }

    public TBbsinfoNoticeMap getTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap by pk starting...");
        TBbsinfoNoticeMap rsObj = null;
        try
        {
            rsObj = dao.getTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbbsinfoNoticeMapList by pk end");
        return rsObj;
    }

    public TBbsinfoNoticeMap getTBbsinfoNoticeMapByIndex(Long mapindex) throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap by mapindex starting...");
        TBbsinfoNoticeMap rsObj = new TBbsinfoNoticeMap();
        rsObj.setMapindex(mapindex);
        try
        {
            rsObj = dao.getTBbsinfoNoticeMap(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbbsinfoNoticeMap by mapindex end");
        return rsObj;
    }

    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond(TBbsinfoNoticeMap tbbsinfoNoticeMap)
            throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap by condition starting...");
        List<TBbsinfoNoticeMap> rsList = null;
        try
        {
            rsList = dao.getTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get tbbsinfoNoticeMap by condition end");
        return rsList;
    }

    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCondExact(TBbsinfoNoticeMap tbbsinfoNoticeMap)
            throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap by exact condition starting...");
        List<TBbsinfoNoticeMap> rsList = null;
        try
        {
            rsList = dao.getTBbsinfoNoticeMapByCondExact(tbbsinfoNoticeMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get tbbsinfoNoticeMap by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbbsinfoNoticeMap, start, pageSize);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<TBbsinfoNoticeMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbbsinfoNoticeMap page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get tbbsinfoNoticeMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbbsinfoNoticeMap, start, pageSize, puEntity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<TBbsinfoNoticeMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbbsinfoNoticeMap page info by condition end");
        return tableInfo;
    }

}
