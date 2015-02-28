package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupCategoryDAO extends DynamicObjectMispDAO implements ITGroupCategoryDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupCategory(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("insert tgroupCategory starting...");
        super.insert("insertTGroupCategory", tgroupCategory);
        log.debug("insert tgroupCategory end");
    }

    public void insertTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DAOException
    {
        log.debug("insert tgroupCategoryList starting...");
        if (null != tgroupCategoryList)
        {
            super.insertBatch("insertTGroupCategory", tgroupCategoryList);
        }
        log.debug("insert tgroupCategoryList end");
    }

    public void updateTGroupCategory(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("update tgroupCategory by pk starting...");
        super.update("updateTGroupCategory", tgroupCategory);
        log.debug("update tgroupCategory by pk end");
    }

    public void updateTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DAOException
    {
        log.debug("update tgroupCategoryList by pk starting...");
        super.updateBatch("updateTGroupCategory", tgroupCategoryList);
        log.debug("update tgroupCategoryList by pk end");
    }

    public void updateTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("update tgroupCategory by conditions starting...");
        super.update("updateTGroupCategoryByCond", tgroupCategory);
        log.debug("update tgroupCategory by conditions end");
    }

    public void deleteTGroupCategory(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("delete tgroupCategory by pk starting...");
        super.delete("deleteTGroupCategory", tgroupCategory);
        log.debug("delete tgroupCategory by pk end");
    }

    public void deleteTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DAOException
    {
        log.debug("delete tgroupCategoryList by pk starting...");
        super.deleteBatch("deleteTGroupCategory", tgroupCategoryList);
        log.debug("delete tgroupCategoryList by pk end");
    }

    public void deleteTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("delete tgroupCategory by conditions starting...");
        super.delete("deleteTGroupCategoryByCond", tgroupCategory);
        log.debug("delete tgroupCategory by conditions end");
    }

    public TGroupCategory getTGroupCategory(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("query tgroupCategory starting...");
        TGroupCategory resultObj = (TGroupCategory) super.queryForObject("getTGroupCategory", tgroupCategory);
        log.debug("query tgroupCategory end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategory> getTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("query tgroupCategory by condition starting...");
        List<TGroupCategory> rList = (List<TGroupCategory>) super.queryForList("queryTGroupCategoryListByCond",
                tgroupCategory);
        log.debug("query tgroupCategory by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategory> getTGroupCategoryByCondExact(TGroupCategory tgroupCategory) throws DAOException
    {
        log.debug("query tgroupCategory by exact condition starting...");
        List<TGroupCategory> rList = (List<TGroupCategory>) super.queryForList("queryTGroupCategoryListByCondExact",
                tgroupCategory);
        log.debug("query tgroupCategory by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupCategory> getTGroupCategoryByCond(TGroupCategory tgroupCategory, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tgroupCategory by condition starting...");
        List<TGroupCategory> rList = (List<TGroupCategory>) super.queryForList("queryTGroupCategoryListByCond",
                tgroupCategory, puEntity);
        log.debug("query tgroupCategory by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize) throws DAOException
    {
        log.debug("page query tgroupCategory by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTGroupCategoryListCntByCond", tgroupCategory)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupCategory> rsList = (List<TGroupCategory>) super.pageQuery("queryTGroupCategoryListByCond",
                    tgroupCategory, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupCategory by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTGroupCategoryListByCond", "queryTGroupCategoryListCntByCond",
                tgroupCategory, start, pageSize, puEntity);
    }

}