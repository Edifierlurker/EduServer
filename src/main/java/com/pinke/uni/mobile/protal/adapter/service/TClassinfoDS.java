package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITClassinfoDAO;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TClassinfoDS extends DynamicObjectBaseDS implements ITClassinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITClassinfoDAO dao = null;

    public void setDao(ITClassinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("insert tclassinfo starting...");
        try
        {
            if (null == tclassinfo.getClassindex())
            {
                tclassinfo.setClassindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_classinfo"));
            }
            dao.insertTClassinfo(tclassinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tclassinfo end");
    }

    public void insertTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        log.debug("insert tclassinfoList by pk starting...");
        if (null == tclassinfoList || tclassinfoList.size() == 0)
        {
            log.debug("there is no datas in tclassinfoList");
            return;
        }
        try
        {
            int listSize = tclassinfoList.size();
            Long index = (Long) Sequence.getSequence("t_classinfo", listSize);
            for (int i = 0; i < tclassinfoList.size(); i++)
            {
                if (tclassinfoList.get(i) != null)
                {
                    if (null == tclassinfoList.get(i).getClassindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tclassinfoList.get(i).setClassindex(primaryindex);
                    }
                }
            }
            dao.insertTClassinfoList(tclassinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tclassinfoList by pk end");
    }

    public void updateTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("update tclassinfo by pk starting...");
        try
        {
            dao.updateTClassinfo(tclassinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tclassinfo by pk end");
    }

    public void updateTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        log.debug("update tclassinfoList by pk starting...");
        if (null == tclassinfoList || tclassinfoList.size() == 0)
        {
            log.debug("there is no datas in tclassinfoList");
            return;
        }
        try
        {
            dao.updateTClassinfoList(tclassinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tclassinfoList by pk end");
    }

    public void removeTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("remove tclassinfo by pk starting...");
        try
        {
            dao.deleteTClassinfo(tclassinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tclassinfo by pk end");
    }

    public void removeTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        log.debug("remove tclassinfoList by pk starting...");
        if (null == tclassinfoList || tclassinfoList.size() == 0)
        {
            log.debug("there is no datas in tclassinfoList");
            return;
        }
        try
        {
            dao.deleteTClassinfoList(tclassinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tclassinfoList by pk end");
    }

    public TClassinfo getTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("get tclassinfo by pk starting...");
        TClassinfo rsObj = null;
        try
        {
            rsObj = dao.getTClassinfo(tclassinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tclassinfoList by pk end");
        return rsObj;
    }

    public TClassinfo getTClassinfoByIndex(Long classindex) throws DomainServiceException
    {
        log.debug("get tclassinfo by classindex starting...");
        TClassinfo rsObj = new TClassinfo();
        rsObj.setClassindex(classindex);
        try
        {
            rsObj = dao.getTClassinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tclassinfo by classindex end");
        return rsObj;
    }

    public List<TClassinfo> getTClassinfoByCond(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("get tclassinfo by condition starting...");
        List<TClassinfo> rsList = null;
        try
        {
            rsList = dao.getTClassinfoByCond(tclassinfo);
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
        log.debug("get tclassinfo by condition end");
        return rsList;
    }

    public List<TClassinfo> getTClassinfoByCondExact(TClassinfo tclassinfo) throws DomainServiceException
    {
        log.debug("get tclassinfo by exact condition starting...");
        List<TClassinfo> rsList = null;
        try
        {
            rsList = dao.getTClassinfoByCondExact(tclassinfo);
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
        log.debug("get tclassinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tclassinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tclassinfo, start, pageSize);
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
        tableInfo.setData((List<TClassinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tclassinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tclassinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tclassinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TClassinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tclassinfo page info by condition end");
        return tableInfo;
    }

}
