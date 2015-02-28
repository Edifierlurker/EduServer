package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TArticleinfoShareDAO extends DynamicObjectMispDAO implements ITArticleinfoShareDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("insert tarticleinfoShare starting...");
        super.insert("insertTArticleinfoShare", tarticleinfoShare);
        log.debug("insert tarticleinfoShare end");
    }

    public void insertTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList) throws DAOException
    {
        log.debug("insert tarticleinfoShareList starting...");
        if (null != tarticleinfoShareList)
        {
            super.insertBatch("insertTArticleinfoShare", tarticleinfoShareList);
        }
        log.debug("insert tarticleinfoShareList end");
    }

    public void updateTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("update tarticleinfoShare by pk starting...");
        super.update("updateTArticleinfoShare", tarticleinfoShare);
        log.debug("update tarticleinfoShare by pk end");
    }

    public void updateTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList) throws DAOException
    {
        log.debug("update tarticleinfoShareList by pk starting...");
        super.updateBatch("updateTArticleinfoShare", tarticleinfoShareList);
        log.debug("update tarticleinfoShareList by pk end");
    }

    public void updateTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("update tarticleinfoShare by conditions starting...");
        super.update("updateTArticleinfoShareByCond", tarticleinfoShare);
        log.debug("update tarticleinfoShare by conditions end");
    }

    public void deleteTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("delete tarticleinfoShare by pk starting...");
        super.delete("deleteTArticleinfoShare", tarticleinfoShare);
        log.debug("delete tarticleinfoShare by pk end");
    }

    public void deleteTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList) throws DAOException
    {
        log.debug("delete tarticleinfoShareList by pk starting...");
        super.deleteBatch("deleteTArticleinfoShare", tarticleinfoShareList);
        log.debug("delete tarticleinfoShareList by pk end");
    }

    public void deleteTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("delete tarticleinfoShare by conditions starting...");
        super.delete("deleteTArticleinfoShareByCond", tarticleinfoShare);
        log.debug("delete tarticleinfoShare by conditions end");
    }

    public TArticleinfoShare getTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("query tarticleinfoShare starting...");
        TArticleinfoShare resultObj = (TArticleinfoShare) super.queryForObject("getTArticleinfoShare",
                tarticleinfoShare);
        log.debug("query tarticleinfoShare end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoShare> getTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare) throws DAOException
    {
        log.debug("query tarticleinfoShare by condition starting...");
        List<TArticleinfoShare> rList = (List<TArticleinfoShare>) super.queryForList(
                "queryTArticleinfoShareListByCond", tarticleinfoShare);
        log.debug("query tarticleinfoShare by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoShare> getTArticleinfoShareByCondExact(TArticleinfoShare tarticleinfoShare)
            throws DAOException
    {
        log.debug("query tarticleinfoShare by exact condition starting...");
        List<TArticleinfoShare> rList = (List<TArticleinfoShare>) super.queryForList(
                "queryTArticleinfoShareListByCondExact", tarticleinfoShare);
        log.debug("query tarticleinfoShare by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoShare> getTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tarticleinfoShare by condition starting...");
        List<TArticleinfoShare> rList = (List<TArticleinfoShare>) super.queryForList(
                "queryTArticleinfoShareListByCond", tarticleinfoShare, puEntity);
        log.debug("query tarticleinfoShare by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize) throws DAOException
    {
        log.debug("page query tarticleinfoShare by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTArticleinfoShareListCntByCond", tarticleinfoShare))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TArticleinfoShare> rsList = (List<TArticleinfoShare>) super.pageQuery(
                    "queryTArticleinfoShareListByCond", tarticleinfoShare, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tarticleinfoShare by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTArticleinfoShareListByCond", "queryTArticleinfoShareListCntByCond",
                tarticleinfoShare, start, pageSize, puEntity);
    }

}