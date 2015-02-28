package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupCategoryDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupCategoryDS extends DynamicObjectBaseDS implements ITGroupCategoryDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITGroupCategoryDAO dao = null;

    public void setDao(ITGroupCategoryDAO dao)
    {
        this.dao = dao;
    }

    public void insertTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("insert tgroupCategory starting...");
        try
        {
//            if (null == tgroupCategory.getCategoryindex())
//            {
//                tgroupCategory.setCategoryindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_group_category"));
//            }
            dao.insertTGroupCategory(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupCategory end");
    }

    public void insertTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        log.debug("insert tgroupCategoryList by pk starting...");
        if (null == tgroupCategoryList || tgroupCategoryList.size() == 0)
        {
            log.debug("there is no datas in tgroupCategoryList");
            return;
        }
        try
        {
            int listSize = tgroupCategoryList.size();
            Long index = (Long) Sequence.getSequence("t_group_category", listSize);
            for (int i = 0; i < tgroupCategoryList.size(); i++)
            {
                if (tgroupCategoryList.get(i) != null)
                {
                    if (null == tgroupCategoryList.get(i).getCategoryindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tgroupCategoryList.get(i).setCategoryindex(primaryindex);
                    }
                }
            }
            dao.insertTGroupCategoryList(tgroupCategoryList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupCategoryList by pk end");
    }

    public void updateTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("update tgroupCategory by pk starting...");
        try
        {
            dao.updateTGroupCategory(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupCategory by pk end");
    }

    public void updateTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        log.debug("update tgroupCategoryList by pk starting...");
        if (null == tgroupCategoryList || tgroupCategoryList.size() == 0)
        {
            log.debug("there is no datas in tgroupCategoryList");
            return;
        }
        try
        {
            dao.updateTGroupCategoryList(tgroupCategoryList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupCategoryList by pk end");
    }

    public void updateTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("update tgroupCategory by condition starting...");
        try
        {
            dao.updateTGroupCategoryByCond(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupCategory by condition end");
    }

    public void removeTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("remove tgroupCategory by pk starting...");
        try
        {
            dao.deleteTGroupCategory(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupCategory by pk end");
    }

    public void removeTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        log.debug("remove tgroupCategoryList by pk starting...");
        if (null == tgroupCategoryList || tgroupCategoryList.size() == 0)
        {
            log.debug("there is no datas in tgroupCategoryList");
            return;
        }
        try
        {
            dao.deleteTGroupCategoryList(tgroupCategoryList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupCategoryList by pk end");
    }

    public void removeTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("remove tgroupCategory by condition starting...");
        try
        {
            dao.deleteTGroupCategoryByCond(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupCategory by condition end");
    }

    public TGroupCategory getTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("get tgroupCategory by pk starting...");
        TGroupCategory rsObj = null;
        try
        {
            rsObj = dao.getTGroupCategory(tgroupCategory);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupCategoryList by pk end");
        return rsObj;
    }

    public TGroupCategory getTGroupCategoryByIndex(Long categoryindex) throws DomainServiceException
    {
        log.debug("get tgroupCategory by categoryindex starting...");
        TGroupCategory rsObj = new TGroupCategory();
        rsObj.setCategoryindex(categoryindex);
        try
        {
            rsObj = dao.getTGroupCategory(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupCategory by categoryindex end");
        return rsObj;
    }

    public List<TGroupCategory> getTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        log.debug("get tgroupCategory by condition starting...");
        List<TGroupCategory> rsList = null;
        try
        {
            rsList = dao.getTGroupCategoryByCond(tgroupCategory);
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
        log.debug("get tgroupCategory by condition end");
        return rsList;
    }

    public List<TGroupCategory> getTGroupCategoryByCondExact(TGroupCategory tgroupCategory)
            throws DomainServiceException
    {
        log.debug("get tgroupCategory by exact condition starting...");
        List<TGroupCategory> rsList = null;
        try
        {
            rsList = dao.getTGroupCategoryByCondExact(tgroupCategory);
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
        log.debug("get tgroupCategory by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tgroupCategory page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupCategory, start, pageSize);
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
        tableInfo.setData((List<TGroupCategory>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupCategory page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tgroupCategory page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupCategory, start, pageSize, puEntity);
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
        tableInfo.setData((List<TGroupCategory>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupCategory page info by condition end");
        return tableInfo;
    }

}
