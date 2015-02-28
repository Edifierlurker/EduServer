package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITSchoolinfoHisDAO;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TSchoolinfoHisDS extends DynamicObjectBaseDS implements ITSchoolinfoHisDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITSchoolinfoHisDAO dao = null;

    public void setDao(ITSchoolinfoHisDAO dao)
    {
        this.dao = dao;
    }

    public void insertTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("insert tschoolinfoHis starting...");
        try
        {
            if (null == tschoolinfoHis.getMapindex())
            {
                tschoolinfoHis.setMapindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_schoolinfo_his"));
            }
            dao.insertTSchoolinfoHis(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tschoolinfoHis end");
    }

    public void insertTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        log.debug("insert tschoolinfoHisList by pk starting...");
        if (null == tschoolinfoHisList || tschoolinfoHisList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoHisList");
            return;
        }
        try
        {
            int listSize = tschoolinfoHisList.size();
            Long index = (Long) Sequence.getSequence("t_schoolinfo_his", listSize);
            for (int i = 0; i < tschoolinfoHisList.size(); i++)
            {
                if (tschoolinfoHisList.get(i) != null)
                {
                    if (null == tschoolinfoHisList.get(i).getMapindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tschoolinfoHisList.get(i).setMapindex(primaryindex);
                    }
                }
            }
            dao.insertTSchoolinfoHisList(tschoolinfoHisList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tschoolinfoHisList by pk end");
    }

    public void updateTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("update tschoolinfoHis by pk starting...");
        try
        {
            dao.updateTSchoolinfoHis(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfoHis by pk end");
    }

    public void updateTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        log.debug("update tschoolinfoHisList by pk starting...");
        if (null == tschoolinfoHisList || tschoolinfoHisList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoHisList");
            return;
        }
        try
        {
            dao.updateTSchoolinfoHisList(tschoolinfoHisList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfoHisList by pk end");
    }

    public void updateTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("update tschoolinfoHis by condition starting...");
        try
        {
            dao.updateTSchoolinfoHisByCond(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfoHis by condition end");
    }

    public void removeTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("remove tschoolinfoHis by pk starting...");
        try
        {
            dao.deleteTSchoolinfoHis(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tschoolinfoHis by pk end");
    }

    public void removeTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        log.debug("remove tschoolinfoHisList by pk starting...");
        if (null == tschoolinfoHisList || tschoolinfoHisList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoHisList");
            return;
        }
        try
        {
            dao.deleteTSchoolinfoHisList(tschoolinfoHisList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tschoolinfoHisList by pk end");
    }

    public void removeTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("remove tschoolinfoHis by condition starting...");
        try
        {
            dao.deleteTSchoolinfoHisByCond(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tschoolinfoHis by condition end");
    }

    public TSchoolinfoHis getTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("get tschoolinfoHis by pk starting...");
        TSchoolinfoHis rsObj = null;
        try
        {
            rsObj = dao.getTSchoolinfoHis(tschoolinfoHis);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tschoolinfoHisList by pk end");
        return rsObj;
    }

    public TSchoolinfoHis getTSchoolinfoHisByIndex(Long mapindex) throws DomainServiceException
    {
        log.debug("get tschoolinfoHis by mapindex starting...");
        TSchoolinfoHis rsObj = new TSchoolinfoHis();
        rsObj.setMapindex(mapindex);
        try
        {
            rsObj = dao.getTSchoolinfoHis(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tschoolinfoHis by mapindex end");
        return rsObj;
    }

    public List<TSchoolinfoHis> getTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        log.debug("get tschoolinfoHis by condition starting...");
        List<TSchoolinfoHis> rsList = null;
        try
        {
            rsList = dao.getTSchoolinfoHisByCond(tschoolinfoHis);
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
        log.debug("get tschoolinfoHis by condition end");
        return rsList;
    }

    public List<TSchoolinfoHis> getTSchoolinfoHisByCondExact(TSchoolinfoHis tschoolinfoHis)
            throws DomainServiceException
    {
        log.debug("get tschoolinfoHis by exact condition starting...");
        List<TSchoolinfoHis> rsList = null;
        try
        {
            rsList = dao.getTSchoolinfoHisByCondExact(tschoolinfoHis);
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
        log.debug("get tschoolinfoHis by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tschoolinfoHis page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tschoolinfoHis, start, pageSize);
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
        tableInfo.setData((List<TSchoolinfoHis>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tschoolinfoHis page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tschoolinfoHis page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tschoolinfoHis, start, pageSize, puEntity);
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
        tableInfo.setData((List<TSchoolinfoHis>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tschoolinfoHis page info by condition end");
        return tableInfo;
    }

}
