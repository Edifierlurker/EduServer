package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITSchoolinfoDAO;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TSchoolinfoDS extends DynamicObjectBaseDS implements ITSchoolinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITSchoolinfoDAO dao = null;

    public void setDao(ITSchoolinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("insert tschoolinfo starting...");
        try
        {
            if (null == tschoolinfo.getSchoolindex())
            {
                tschoolinfo.setSchoolindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_schoolinfo"));
            }
            dao.insertTSchoolinfo(tschoolinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tschoolinfo end");
    }

    public void insertTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        log.debug("insert tschoolinfoList by pk starting...");
        if (null == tschoolinfoList || tschoolinfoList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoList");
            return;
        }
        try
        {
            int listSize = tschoolinfoList.size();
            Long index = (Long) Sequence.getSequence("t_schoolinfo", listSize);
            for (int i = 0; i < tschoolinfoList.size(); i++)
            {
                if (tschoolinfoList.get(i) != null)
                {
                    if (null == tschoolinfoList.get(i).getSchoolindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tschoolinfoList.get(i).setSchoolindex(primaryindex);
                    }
                }
            }
            dao.insertTSchoolinfoList(tschoolinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tschoolinfoList by pk end");
    }

    public void updateTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("update tschoolinfo by pk starting...");
        try
        {
            dao.updateTSchoolinfo(tschoolinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfo by pk end");
    }

    public void updateTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        log.debug("update tschoolinfoList by pk starting...");
        if (null == tschoolinfoList || tschoolinfoList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoList");
            return;
        }
        try
        {
            dao.updateTSchoolinfoList(tschoolinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfoList by pk end");
    }

    public void updateTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("update tschoolinfo by condition starting...");
        try
        {
            dao.updateTSchoolinfoByCond(tschoolinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tschoolinfo by condition end");
    }

    public void removeTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("remove tschoolinfo by pk starting...");
        try
        {
            dao.deleteTSchoolinfo(tschoolinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tschoolinfo by pk end");
    }

    public void removeTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        log.debug("remove tschoolinfoList by pk starting...");
        if (null == tschoolinfoList || tschoolinfoList.size() == 0)
        {
            log.debug("there is no datas in tschoolinfoList");
            return;
        }
        try
        {
            dao.deleteTSchoolinfoList(tschoolinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tschoolinfoList by pk end");
    }

    public TSchoolinfo getTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("get tschoolinfo by pk starting...");
        TSchoolinfo rsObj = null;
        try
        {
            rsObj = dao.getTSchoolinfo(tschoolinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tschoolinfoList by pk end");
        return rsObj;
    }

    public TSchoolinfo getTSchoolinfoByIndex(Long schoolindex) throws DomainServiceException
    {
        log.debug("get tschoolinfo by schoolindex starting...");
        TSchoolinfo rsObj = new TSchoolinfo();
        rsObj.setSchoolindex(schoolindex);
        try
        {
            rsObj = dao.getTSchoolinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tschoolinfo by schoolindex end");
        return rsObj;
    }

    public List<TSchoolinfo> getTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("get tschoolinfo by condition starting...");
        List<TSchoolinfo> rsList = null;
        try
        {
            rsList = dao.getTSchoolinfoByCond(tschoolinfo);
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
        log.debug("get tschoolinfo by condition end");
        return rsList;
    }

    public List<TSchoolinfo> getTSchoolinfoByCondExact(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        log.debug("get tschoolinfo by exact condition starting...");
        List<TSchoolinfo> rsList = null;
        try
        {
            rsList = dao.getTSchoolinfoByCondExact(tschoolinfo);
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
        log.debug("get tschoolinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tschoolinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tschoolinfo, start, pageSize);
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
        tableInfo.setData((List<TSchoolinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tschoolinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tschoolinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tschoolinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TSchoolinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tschoolinfo page info by condition end");
        return tableInfo;
    }

}
