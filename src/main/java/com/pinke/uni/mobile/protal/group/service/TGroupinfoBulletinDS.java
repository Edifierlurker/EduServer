package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupinfoBulletinDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoBulletinDS extends DynamicObjectBaseDS implements ITGroupinfoBulletinDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITGroupinfoBulletinDAO dao = null;

    public void setDao(ITGroupinfoBulletinDAO dao)
    {
        this.dao = dao;
    }

    public void insertTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        log.debug("insert tgroupinfoBulletin starting...");
        try
        {
//            if (null == tgroupinfoBulletin.getBulletinidnex())
//            {
//                tgroupinfoBulletin.setBulletinidnex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "t_groupinfo_bulletin"));
//            }
            dao.insertTGroupinfoBulletin(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfoBulletin end");
    }

    public void insertTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        log.debug("insert tgroupinfoBulletinList by pk starting...");
        if (null == tgroupinfoBulletinList || tgroupinfoBulletinList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinList");
            return;
        }
        try
        {
            int listSize = tgroupinfoBulletinList.size();
            Long index = (Long) Sequence.getSequence("t_groupinfo_bulletin", listSize);
            for (int i = 0; i < tgroupinfoBulletinList.size(); i++)
            {
                if (tgroupinfoBulletinList.get(i) != null)
                {
                    if (null == tgroupinfoBulletinList.get(i).getBulletinidnex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tgroupinfoBulletinList.get(i).setBulletinidnex(primaryindex);
                    }
                }
            }
            dao.insertTGroupinfoBulletinList(tgroupinfoBulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfoBulletinList by pk end");
    }

    public void updateTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletin by pk starting...");
        try
        {
            dao.updateTGroupinfoBulletin(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletin by pk end");
    }

    public void updateTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletinList by pk starting...");
        if (null == tgroupinfoBulletinList || tgroupinfoBulletinList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinList");
            return;
        }
        try
        {
            dao.updateTGroupinfoBulletinList(tgroupinfoBulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletinList by pk end");
    }

    public void updateTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletin by condition starting...");
        try
        {
            dao.updateTGroupinfoBulletinByCond(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletin by condition end");
    }

    public void removeTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletin by pk starting...");
        try
        {
            dao.deleteTGroupinfoBulletin(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletin by pk end");
    }

    public void removeTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletinList by pk starting...");
        if (null == tgroupinfoBulletinList || tgroupinfoBulletinList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinList");
            return;
        }
        try
        {
            dao.deleteTGroupinfoBulletinList(tgroupinfoBulletinList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletinList by pk end");
    }

    public void removeTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletin by condition starting...");
        try
        {
            dao.deleteTGroupinfoBulletinByCond(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletin by condition end");
    }

    public TGroupinfoBulletin getTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin by pk starting...");
        TGroupinfoBulletin rsObj = null;
        try
        {
            rsObj = dao.getTGroupinfoBulletin(tgroupinfoBulletin);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfoBulletinList by pk end");
        return rsObj;
    }

    public TGroupinfoBulletin getTGroupinfoBulletinByIndex(Long bulletinidnex) throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin by bulletinidnex starting...");
        TGroupinfoBulletin rsObj = new TGroupinfoBulletin();
        rsObj.setBulletinidnex(bulletinidnex);
        try
        {
            rsObj = dao.getTGroupinfoBulletin(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfoBulletin by bulletinidnex end");
        return rsObj;
    }

    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin by condition starting...");
        List<TGroupinfoBulletin> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoBulletinByCond(tgroupinfoBulletin);
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
        log.debug("get tgroupinfoBulletin by condition end");
        return rsList;
    }

    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCondExact(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin by exact condition starting...");
        List<TGroupinfoBulletin> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoBulletinByCondExact(tgroupinfoBulletin);
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
        log.debug("get tgroupinfoBulletin by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfoBulletin, start, pageSize);
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
        tableInfo.setData((List<TGroupinfoBulletin>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfoBulletin page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletin page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfoBulletin, start, pageSize, puEntity);
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
        tableInfo.setData((List<TGroupinfoBulletin>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfoBulletin page info by condition end");
        return tableInfo;
    }

}
