package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupinfoDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoDS extends DynamicObjectBaseDS implements ITGroupinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITGroupinfoDAO dao = null;

    public void setDao(ITGroupinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("insert tgroupinfo starting...");
        try
        {
//            if (null == tgroupinfo.getGroupid())
//            {
//                tgroupinfo.setGroupid((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_groupinfo_groupid"));
//            }
            dao.insertTGroupinfo(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfo end");
    }

    public void insertTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        log.debug("insert tgroupinfoList by pk starting...");
        if (null == tgroupinfoList || tgroupinfoList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoList");
            return;
        }
        try
        {
            int listSize = tgroupinfoList.size();
            Long index = (Long) Sequence.getSequence("t_groupinfo", listSize);
            for (int i = 0; i < tgroupinfoList.size(); i++)
            {
                if (tgroupinfoList.get(i) != null)
                {
                    if (null == tgroupinfoList.get(i).getGroupindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tgroupinfoList.get(i).setGroupindex(primaryindex);
                    }
                }
            }
            dao.insertTGroupinfoList(tgroupinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfoList by pk end");
    }

    public void updateTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("update tgroupinfo by pk starting...");
        try
        {
            dao.updateTGroupinfo(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfo by pk end");
    }

    public void updateTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        log.debug("update tgroupinfoList by pk starting...");
        if (null == tgroupinfoList || tgroupinfoList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoList");
            return;
        }
        try
        {
            dao.updateTGroupinfoList(tgroupinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoList by pk end");
    }

    public void updateTGroupinfoByCond(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("update tgroupinfo by condition starting...");
        try
        {
            dao.updateTGroupinfoByCond(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfo by condition end");
    }

    public void removeTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("remove tgroupinfo by pk starting...");
        try
        {
            dao.deleteTGroupinfo(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfo by pk end");
    }

    public void removeTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        log.debug("remove tgroupinfoList by pk starting...");
        if (null == tgroupinfoList || tgroupinfoList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoList");
            return;
        }
        try
        {
            dao.deleteTGroupinfoList(tgroupinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoList by pk end");
    }

    public void removeTGroupinfoByCond(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("remove tgroupinfo by condition starting...");
        try
        {
            dao.deleteTGroupinfoByCond(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfo by condition end");
    }

    public TGroupinfo getTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("get tgroupinfo by pk starting...");
        TGroupinfo rsObj = null;
        try
        {
            rsObj = dao.getTGroupinfo(tgroupinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfoList by pk end");
        return rsObj;
    }

    public TGroupinfo getTGroupinfoByIndex(Long groupindex) throws DomainServiceException
    {
        log.debug("get tgroupinfo by groupindex starting...");
        TGroupinfo rsObj = new TGroupinfo();
        rsObj.setGroupindex(groupindex);
        try
        {
            rsObj = dao.getTGroupinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfo by groupindex end");
        return rsObj;
    }

    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("get tgroupinfo by condition starting...");
        List<TGroupinfo> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoByCond(tgroupinfo);
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
        log.debug("get tgroupinfo by condition end");
        return rsList;
    }

    public List<TGroupinfo> getTGroupinfoByCondExact(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        log.debug("get tgroupinfo by exact condition starting...");
        List<TGroupinfo> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoByCondExact(tgroupinfo);
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
        log.debug("get tgroupinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get tgroupinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfo, start, pageSize);
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
        tableInfo.setData((List<TGroupinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tgroupinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TGroupinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQueryExtends(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tgroupinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtends(tgroupinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TGroupinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfo page info by condition end");
        return tableInfo;
    }

}
