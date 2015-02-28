package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.IAppVersionmgtDAO;
import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class AppVersionmgtDS extends DynamicObjectBaseDS implements IAppVersionmgtDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IAppVersionmgtDAO dao = null;

    public void setDao(IAppVersionmgtDAO dao)
    {
        this.dao = dao;
    }

    public void insertAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("insert appVersionmgt starting...");
        try
        {
//            if (null == appVersionmgt.getVersionindex())
//            {
//                appVersionmgt.setVersionindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("app_versionmgt"));
//            }
            dao.insertAppVersionmgt(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert appVersionmgt end");
    }

    public void insertAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        log.debug("insert appVersionmgtList by pk starting...");
        if (null == appVersionmgtList || appVersionmgtList.size() == 0)
        {
            log.debug("there is no datas in appVersionmgtList");
            return;
        }
        try
        {
            int listSize = appVersionmgtList.size();
            Long index = (Long) Sequence.getSequence("app_versionmgt", listSize);
            for (int i = 0; i < appVersionmgtList.size(); i++)
            {
                if (appVersionmgtList.get(i) != null)
                {
                    if (null == appVersionmgtList.get(i).getVersionindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        appVersionmgtList.get(i).setVersionindex(primaryindex);
                    }
                }
            }
            dao.insertAppVersionmgtList(appVersionmgtList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert appVersionmgtList by pk end");
    }

    public void updateAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("update appVersionmgt by pk starting...");
        try
        {
            dao.updateAppVersionmgt(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update appVersionmgt by pk end");
    }

    public void updateAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        log.debug("update appVersionmgtList by pk starting...");
        if (null == appVersionmgtList || appVersionmgtList.size() == 0)
        {
            log.debug("there is no datas in appVersionmgtList");
            return;
        }
        try
        {
            dao.updateAppVersionmgtList(appVersionmgtList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update appVersionmgtList by pk end");
    }

    public void updateAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("update appVersionmgt by condition starting...");
        try
        {
            dao.updateAppVersionmgtByCond(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update appVersionmgt by condition end");
    }

    public void removeAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("remove appVersionmgt by pk starting...");
        try
        {
            dao.deleteAppVersionmgt(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove appVersionmgt by pk end");
    }

    public void removeAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        log.debug("remove appVersionmgtList by pk starting...");
        if (null == appVersionmgtList || appVersionmgtList.size() == 0)
        {
            log.debug("there is no datas in appVersionmgtList");
            return;
        }
        try
        {
            dao.deleteAppVersionmgtList(appVersionmgtList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove appVersionmgtList by pk end");
    }

    public void removeAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("remove appVersionmgt by condition starting...");
        try
        {
            dao.deleteAppVersionmgtByCond(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove appVersionmgt by condition end");
    }

    public AppVersionmgt getAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("get appVersionmgt by pk starting...");
        AppVersionmgt rsObj = null;
        try
        {
            rsObj = dao.getAppVersionmgt(appVersionmgt);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get appVersionmgtList by pk end");
        return rsObj;
    }

    public AppVersionmgt getAppVersionmgtByIndex(Long versionindex) throws DomainServiceException
    {
        log.debug("get appVersionmgt by versionindex starting...");
        AppVersionmgt rsObj = new AppVersionmgt();
        rsObj.setVersionindex(versionindex);
        try
        {
            rsObj = dao.getAppVersionmgt(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get appVersionmgt by versionindex end");
        return rsObj;
    }

    public List<AppVersionmgt> getAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("get appVersionmgt by condition starting...");
        List<AppVersionmgt> rsList = null;
        try
        {
            rsList = dao.getAppVersionmgtByCond(appVersionmgt);
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
        log.debug("get appVersionmgt by condition end");
        return rsList;
    }

    public List<AppVersionmgt> getAppVersionmgtByCondExact(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        log.debug("get appVersionmgt by exact condition starting...");
        List<AppVersionmgt> rsList = null;
        try
        {
            rsList = dao.getAppVersionmgtByCondExact(appVersionmgt);
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
        log.debug("get appVersionmgt by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get appVersionmgt page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(appVersionmgt, start, pageSize);
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
        tableInfo.setData((List<AppVersionmgt>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get appVersionmgt page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get appVersionmgt page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(appVersionmgt, start, pageSize, puEntity);
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
        tableInfo.setData((List<AppVersionmgt>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get appVersionmgt page info by condition end");
        return tableInfo;
    }

}
