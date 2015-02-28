package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITBulletinDAO;
import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBulletinDS extends DynamicObjectBaseDS implements ITBulletinDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITBulletinDAO dao = null;

    public void setDao(ITBulletinDAO dao)
    {
        this.dao = dao;
    }

    public void insertTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("insert tbulletin starting...");
        try
        {
//            if (null == tbulletin.getBulindex())
//            {
//                tbulletin.setBulindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_bulletin"));
//            }
            dao.insertTBulletin(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbulletin end");
    }

    public void insertTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        log.debug("insert tbulletinList by pk starting...");
        if (null == tbulletinList || tbulletinList.size() == 0)
        {
            log.debug("there is no datas in tbulletinList");
            return;
        }
        try
        {
            int listSize = tbulletinList.size();
            Long index = (Long) Sequence.getSequence("t_bulletin", listSize);
            for (int i = 0; i < tbulletinList.size(); i++)
            {
                if (tbulletinList.get(i) != null)
                {
                    if (null == tbulletinList.get(i).getBulindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tbulletinList.get(i).setBulindex(primaryindex);
                    }
                }
            }
            dao.insertTBulletinList(tbulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbulletinList by pk end");
    }

    public void updateTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("update tbulletin by pk starting...");
        try
        {
            dao.updateTBulletin(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbulletin by pk end");
    }

    public void updateTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        log.debug("update tbulletinList by pk starting...");
        if (null == tbulletinList || tbulletinList.size() == 0)
        {
            log.debug("there is no datas in tbulletinList");
            return;
        }
        try
        {
            dao.updateTBulletinList(tbulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbulletinList by pk end");
    }

    public void updateTBulletinByCond(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("update tbulletin by condition starting...");
        try
        {
            dao.updateTBulletinByCond(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbulletin by condition end");
    }

    public void removeTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("remove tbulletin by pk starting...");
        try
        {
            dao.deleteTBulletin(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbulletin by pk end");
    }

    public void removeTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        log.debug("remove tbulletinList by pk starting...");
        if (null == tbulletinList || tbulletinList.size() == 0)
        {
            log.debug("there is no datas in tbulletinList");
            return;
        }
        try
        {
            dao.deleteTBulletinList(tbulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbulletinList by pk end");
    }

    public void removeTBulletinByCond(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("remove tbulletin by condition starting...");
        try
        {
            dao.deleteTBulletinByCond(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbulletin by condition end");
    }

    public TBulletin getTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("get tbulletin by pk starting...");
        TBulletin rsObj = null;
        try
        {
            rsObj = dao.getTBulletin(tbulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbulletinList by pk end");
        return rsObj;
    }

    public TBulletin getTBulletinByIndex(Long bulindex) throws DomainServiceException
    {
        log.debug("get tbulletin by bulindex starting...");
        TBulletin rsObj = new TBulletin();
        rsObj.setBulindex(bulindex);
        try
        {
            rsObj = dao.getTBulletin(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbulletin by bulindex end");
        return rsObj;
    }

    public List<TBulletin> getTBulletinByCond(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("get tbulletin by condition starting...");
        List<TBulletin> rsList = null;
        try
        {
            rsList = dao.getTBulletinByCond(tbulletin);
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
        log.debug("get tbulletin by condition end");
        return rsList;
    }

    public List<TBulletin> getTBulletinByCondExact(TBulletin tbulletin) throws DomainServiceException
    {
        log.debug("get tbulletin by exact condition starting...");
        List<TBulletin> rsList = null;
        try
        {
            rsList = dao.getTBulletinByCondExact(tbulletin);
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
        log.debug("get tbulletin by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tbulletin page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbulletin, start, pageSize);
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
        tableInfo.setData((List<TBulletin>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbulletin page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tbulletin page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbulletin, start, pageSize, puEntity);
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
        tableInfo.setData((List<TBulletin>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbulletin page info by condition end");
        return tableInfo;
    }

}
