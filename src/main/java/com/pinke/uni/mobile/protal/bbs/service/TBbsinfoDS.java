package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITBbsinfoDAO;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBbsinfoDS extends DynamicObjectBaseDS implements ITBbsinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITBbsinfoDAO dao = null;

    public void setDao(ITBbsinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("insert tbbsinfo starting...");
        try
        {
//            if (null == tbbsinfo.getBbsindex())
//            {
//                tbbsinfo.setBbsindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_bbsinfo"));
//            }
            dao.insertTBbsinfo(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbbsinfo end");
    }

    public void insertTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        log.debug("insert tbbsinfoList by pk starting...");
        if (null == tbbsinfoList || tbbsinfoList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoList");
            return;
        }
        try
        {
            int listSize = tbbsinfoList.size();
            Long index = (Long) Sequence.getSequence("t_bbsinfo", listSize);
            for (int i = 0; i < tbbsinfoList.size(); i++)
            {
                if (tbbsinfoList.get(i) != null)
                {
                    if (null == tbbsinfoList.get(i).getBbsindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tbbsinfoList.get(i).setBbsindex(primaryindex);
                    }
                }
            }
            dao.insertTBbsinfoList(tbbsinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tbbsinfoList by pk end");
    }

    public void updateTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("update tbbsinfo by pk starting...");
        try
        {
            dao.updateTBbsinfo(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfo by pk end");
    }

    public void updateTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        log.debug("update tbbsinfoList by pk starting...");
        if (null == tbbsinfoList || tbbsinfoList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoList");
            return;
        }
        try
        {
            dao.updateTBbsinfoList(tbbsinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfoList by pk end");
    }

    public void updateTBbsinfoByCond(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("update tbbsinfo by condition starting...");
        try
        {
            dao.updateTBbsinfoByCond(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tbbsinfo by condition end");
    }

    public void removeTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("remove tbbsinfo by pk starting...");
        try
        {
            dao.deleteTBbsinfo(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfo by pk end");
    }

    public void removeTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        log.debug("remove tbbsinfoList by pk starting...");
        if (null == tbbsinfoList || tbbsinfoList.size() == 0)
        {
            log.debug("there is no datas in tbbsinfoList");
            return;
        }
        try
        {
            dao.deleteTBbsinfoList(tbbsinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfoList by pk end");
    }

    public void removeTBbsinfoByCond(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("remove tbbsinfo by condition starting...");
        try
        {
            dao.deleteTBbsinfoByCond(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tbbsinfo by condition end");
    }

    public TBbsinfo getTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("get tbbsinfo by pk starting...");
        TBbsinfo rsObj = null;
        try
        {
            rsObj = dao.getTBbsinfo(tbbsinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbbsinfoList by pk end");
        return rsObj;
    }

    public TBbsinfo getTBbsinfoByIndex(Long bbsindex) throws DomainServiceException
    {
        log.debug("get tbbsinfo by bbsindex starting...");
        TBbsinfo rsObj = new TBbsinfo();
        rsObj.setBbsindex(bbsindex);
        try
        {
            rsObj = dao.getTBbsinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tbbsinfo by bbsindex end");
        return rsObj;
    }

    public List<TBbsinfo> getTBbsinfoByCond(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("get tbbsinfo by condition starting...");
        List<TBbsinfo> rsList = null;
        try
        {
            rsList = dao.getTBbsinfoByCond(tbbsinfo);
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
        log.debug("get tbbsinfo by condition end");
        return rsList;
    }

    public List<TBbsinfo> getTBbsinfoByCondExact(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        log.debug("get tbbsinfo by exact condition starting...");
        List<TBbsinfo> rsList = null;
        try
        {
            rsList = dao.getTBbsinfoByCondExact(tbbsinfo);
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
        log.debug("get tbbsinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tbbsinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbbsinfo, start, pageSize);
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
        tableInfo.setData((List<TBbsinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbbsinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tbbsinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tbbsinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TBbsinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tbbsinfo page info by condition end");
        return tableInfo;
    }

}
