package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITCollegeinfoDAO;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TCollegeinfoDS extends DynamicObjectBaseDS implements ITCollegeinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITCollegeinfoDAO dao = null;

    public void setDao(ITCollegeinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("insert tcollegeinfo starting...");
        try
        {
            if (null == tcollegeinfo.getCollegeindex())
            {
                tcollegeinfo.setCollegeindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_collegeinfo"));
            }
            dao.insertTCollegeinfo(tcollegeinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tcollegeinfo end");
    }

    public void insertTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        log.debug("insert tcollegeinfoList by pk starting...");
        if (null == tcollegeinfoList || tcollegeinfoList.size() == 0)
        {
            log.debug("there is no datas in tcollegeinfoList");
            return;
        }
        try
        {
            int listSize = tcollegeinfoList.size();
            Long index = (Long) Sequence.getSequence("t_collegeinfo", listSize);
            for (int i = 0; i < tcollegeinfoList.size(); i++)
            {
                if (tcollegeinfoList.get(i) != null)
                {
                    if (null == tcollegeinfoList.get(i).getCollegeindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tcollegeinfoList.get(i).setCollegeindex(primaryindex);
                    }
                }
            }
            dao.insertTCollegeinfoList(tcollegeinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tcollegeinfoList by pk end");
    }

    public void updateTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("update tcollegeinfo by pk starting...");
        try
        {
            dao.updateTCollegeinfo(tcollegeinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tcollegeinfo by pk end");
    }

    public void updateTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        log.debug("update tcollegeinfoList by pk starting...");
        if (null == tcollegeinfoList || tcollegeinfoList.size() == 0)
        {
            log.debug("there is no datas in tcollegeinfoList");
            return;
        }
        try
        {
            dao.updateTCollegeinfoList(tcollegeinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tcollegeinfoList by pk end");
    }

    public void removeTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("remove tcollegeinfo by pk starting...");
        try
        {
            dao.deleteTCollegeinfo(tcollegeinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tcollegeinfo by pk end");
    }

    public void removeTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        log.debug("remove tcollegeinfoList by pk starting...");
        if (null == tcollegeinfoList || tcollegeinfoList.size() == 0)
        {
            log.debug("there is no datas in tcollegeinfoList");
            return;
        }
        try
        {
            dao.deleteTCollegeinfoList(tcollegeinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tcollegeinfoList by pk end");
    }

    public TCollegeinfo getTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("get tcollegeinfo by pk starting...");
        TCollegeinfo rsObj = null;
        try
        {
            rsObj = dao.getTCollegeinfo(tcollegeinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tcollegeinfoList by pk end");
        return rsObj;
    }

    public TCollegeinfo getTCollegeinfoByIndex(Long collegeindex) throws DomainServiceException
    {
        log.debug("get tcollegeinfo by collegeindex starting...");
        TCollegeinfo rsObj = new TCollegeinfo();
        rsObj.setCollegeindex(collegeindex);
        try
        {
            rsObj = dao.getTCollegeinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tcollegeinfo by collegeindex end");
        return rsObj;
    }

    public List<TCollegeinfo> getTCollegeinfoByCond(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("get tcollegeinfo by condition starting...");
        List<TCollegeinfo> rsList = null;
        try
        {
            rsList = dao.getTCollegeinfoByCond(tcollegeinfo);
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
        log.debug("get tcollegeinfo by condition end");
        return rsList;
    }

    public List<TCollegeinfo> getTCollegeinfoByCondExact(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        log.debug("get tcollegeinfo by exact condition starting...");
        List<TCollegeinfo> rsList = null;
        try
        {
            rsList = dao.getTCollegeinfoByCondExact(tcollegeinfo);
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
        log.debug("get tcollegeinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tcollegeinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tcollegeinfo, start, pageSize);
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
        tableInfo.setData((List<TCollegeinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tcollegeinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tcollegeinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tcollegeinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TCollegeinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tcollegeinfo page info by condition end");
        return tableInfo;
    }

}
