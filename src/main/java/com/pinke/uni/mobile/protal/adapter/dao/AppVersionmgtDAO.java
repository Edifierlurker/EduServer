package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class AppVersionmgtDAO extends DynamicObjectMispDAO implements IAppVersionmgtDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertAppVersionmgt(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("insert appVersionmgt starting...");
        super.insert("insertAppVersionmgt", appVersionmgt);
        log.debug("insert appVersionmgt end");
    }

    public void insertAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DAOException
    {
        log.debug("insert appVersionmgtList starting...");
        if (null != appVersionmgtList)
        {
            super.insertBatch("insertAppVersionmgt", appVersionmgtList);
        }
        log.debug("insert appVersionmgtList end");
    }

    public void updateAppVersionmgt(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("update appVersionmgt by pk starting...");
        super.update("updateAppVersionmgt", appVersionmgt);
        log.debug("update appVersionmgt by pk end");
    }

    public void updateAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DAOException
    {
        log.debug("update appVersionmgtList by pk starting...");
        super.updateBatch("updateAppVersionmgt", appVersionmgtList);
        log.debug("update appVersionmgtList by pk end");
    }

    public void updateAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("update appVersionmgt by conditions starting...");
        super.update("updateAppVersionmgtByCond", appVersionmgt);
        log.debug("update appVersionmgt by conditions end");
    }

    public void deleteAppVersionmgt(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("delete appVersionmgt by pk starting...");
        super.delete("deleteAppVersionmgt", appVersionmgt);
        log.debug("delete appVersionmgt by pk end");
    }

    public void deleteAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DAOException
    {
        log.debug("delete appVersionmgtList by pk starting...");
        super.deleteBatch("deleteAppVersionmgt", appVersionmgtList);
        log.debug("delete appVersionmgtList by pk end");
    }

    public void deleteAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("delete appVersionmgt by conditions starting...");
        super.delete("deleteAppVersionmgtByCond", appVersionmgt);
        log.debug("delete appVersionmgt by conditions end");
    }

    public AppVersionmgt getAppVersionmgt(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("query appVersionmgt starting...");
        AppVersionmgt resultObj = (AppVersionmgt) super.queryForObject("getAppVersionmgt", appVersionmgt);
        log.debug("query appVersionmgt end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<AppVersionmgt> getAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("query appVersionmgt by condition starting...");
        List<AppVersionmgt> rList = (List<AppVersionmgt>) super.queryForList("queryAppVersionmgtListByCond",
                appVersionmgt);
        log.debug("query appVersionmgt by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<AppVersionmgt> getAppVersionmgtByCondExact(AppVersionmgt appVersionmgt) throws DAOException
    {
        log.debug("query appVersionmgt by exact condition starting...");
        List<AppVersionmgt> rList = (List<AppVersionmgt>) super.queryForList("queryAppVersionmgtListByCondExact",
                appVersionmgt);
        log.debug("query appVersionmgt by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<AppVersionmgt> getAppVersionmgtByCond(AppVersionmgt appVersionmgt, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query appVersionmgt by condition starting...");
        List<AppVersionmgt> rList = (List<AppVersionmgt>) super.queryForList("queryAppVersionmgtListByCond",
                appVersionmgt, puEntity);
        log.debug("query appVersionmgt by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize) throws DAOException
    {
        log.debug("page query appVersionmgt by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryAppVersionmgtListCntByCond", appVersionmgt)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<AppVersionmgt> rsList = (List<AppVersionmgt>) super.pageQuery("queryAppVersionmgtListByCond",
                    appVersionmgt, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query appVersionmgt by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryAppVersionmgtListByCond", "queryAppVersionmgtListCntByCond", appVersionmgt,
                start, pageSize, puEntity);
    }

}