package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITMajorinfoDAO;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TMajorinfoDS extends DynamicObjectBaseDS implements ITMajorinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITMajorinfoDAO dao = null;

    public void setDao(ITMajorinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("insert tmajorinfo starting...");
        try
        {
            if (null == tmajorinfo.getMajorindex())
            {
                tmajorinfo.setMajorindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_majorinfo"));
            }
            dao.insertTMajorinfo(tmajorinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tmajorinfo end");
    }

    public void insertTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        log.debug("insert tmajorinfoList by pk starting...");
        if (null == tmajorinfoList || tmajorinfoList.size() == 0)
        {
            log.debug("there is no datas in tmajorinfoList");
            return;
        }
        try
        {
            int listSize = tmajorinfoList.size();
            Long index = (Long) Sequence.getSequence("t_majorinfo", listSize);
            for (int i = 0; i < tmajorinfoList.size(); i++)
            {
                if (tmajorinfoList.get(i) != null)
                {
                    if (null == tmajorinfoList.get(i).getMajorindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tmajorinfoList.get(i).setMajorindex(primaryindex);
                    }
                }
            }
            dao.insertTMajorinfoList(tmajorinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tmajorinfoList by pk end");
    }

    public void updateTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("update tmajorinfo by pk starting...");
        try
        {
            dao.updateTMajorinfo(tmajorinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tmajorinfo by pk end");
    }

    public void updateTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        log.debug("update tmajorinfoList by pk starting...");
        if (null == tmajorinfoList || tmajorinfoList.size() == 0)
        {
            log.debug("there is no datas in tmajorinfoList");
            return;
        }
        try
        {
            dao.updateTMajorinfoList(tmajorinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tmajorinfoList by pk end");
    }

    public void removeTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("remove tmajorinfo by pk starting...");
        try
        {
            dao.deleteTMajorinfo(tmajorinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tmajorinfo by pk end");
    }

    public void removeTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        log.debug("remove tmajorinfoList by pk starting...");
        if (null == tmajorinfoList || tmajorinfoList.size() == 0)
        {
            log.debug("there is no datas in tmajorinfoList");
            return;
        }
        try
        {
            dao.deleteTMajorinfoList(tmajorinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tmajorinfoList by pk end");
    }

    public TMajorinfo getTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("get tmajorinfo by pk starting...");
        TMajorinfo rsObj = null;
        try
        {
            rsObj = dao.getTMajorinfo(tmajorinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tmajorinfoList by pk end");
        return rsObj;
    }

    public TMajorinfo getTMajorinfoByIndex(Long majorindex) throws DomainServiceException
    {
        log.debug("get tmajorinfo by majorindex starting...");
        TMajorinfo rsObj = new TMajorinfo();
        rsObj.setMajorindex(majorindex);
        try
        {
            rsObj = dao.getTMajorinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tmajorinfo by majorindex end");
        return rsObj;
    }

    public List<TMajorinfo> getTMajorinfoByCond(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("get tmajorinfo by condition starting...");
        List<TMajorinfo> rsList = null;
        try
        {
            rsList = dao.getTMajorinfoByCond(tmajorinfo);
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
        log.debug("get tmajorinfo by condition end");
        return rsList;
    }

    public List<TMajorinfo> getTMajorinfoByCondExact(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        log.debug("get tmajorinfo by exact condition starting...");
        List<TMajorinfo> rsList = null;
        try
        {
            rsList = dao.getTMajorinfoByCondExact(tmajorinfo);
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
        log.debug("get tmajorinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tmajorinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tmajorinfo, start, pageSize);
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
        tableInfo.setData((List<TMajorinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tmajorinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tmajorinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tmajorinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TMajorinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tmajorinfo page info by condition end");
        return tableInfo;
    }

}
