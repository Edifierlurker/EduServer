package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TArticleinfoDAO extends DynamicObjectMispDAO implements ITArticleinfoDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTArticleinfo(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("insert tarticleinfo starting...");
        super.insert("insertTArticleinfo", tarticleinfo);
        log.debug("insert tarticleinfo end");
    }

    public void insertTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException
    {
        log.debug("insert tarticleinfoList starting...");
        if (null != tarticleinfoList)
        {
            super.insertBatch("insertTArticleinfo", tarticleinfoList);
        }
        log.debug("insert tarticleinfoList end");
    }

    public void updateTArticleinfo(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("update tarticleinfo by pk starting...");
        super.update("updateTArticleinfo", tarticleinfo);
        log.debug("update tarticleinfo by pk end");
    }

    public void updateTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException
    {
        log.debug("update tarticleinfoList by pk starting...");
        super.updateBatch("updateTArticleinfo", tarticleinfoList);
        log.debug("update tarticleinfoList by pk end");
    }

    public void updateTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("update tarticleinfo by conditions starting...");
        super.update("updateTArticleinfoByCond", tarticleinfo);
        log.debug("update tarticleinfo by conditions end");
    }

    public void deleteTArticleinfo(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("delete tarticleinfo by pk starting...");
        super.delete("deleteTArticleinfo", tarticleinfo);
        log.debug("delete tarticleinfo by pk end");
    }

    public void deleteTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException
    {
        log.debug("delete tarticleinfoList by pk starting...");
        super.deleteBatch("deleteTArticleinfo", tarticleinfoList);
        log.debug("delete tarticleinfoList by pk end");
    }

    public void deleteTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("delete tarticleinfo by conditions starting...");
        super.delete("deleteTArticleinfoByCond", tarticleinfo);
        log.debug("delete tarticleinfo by conditions end");
    }

    public TArticleinfo getTArticleinfo(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("query tarticleinfo starting...");
        TArticleinfo resultObj = (TArticleinfo) super.queryForObject("getTArticleinfo", tarticleinfo);
        log.debug("query tarticleinfo end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("query tarticleinfo by condition starting...");
        List<TArticleinfo> rList = (List<TArticleinfo>) super.queryForList("queryTArticleinfoListByCond", tarticleinfo);
        log.debug("query tarticleinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfo> getTArticleinfoByCondExact(TArticleinfo tarticleinfo) throws DAOException
    {
        log.debug("query tarticleinfo by exact condition starting...");
        List<TArticleinfo> rList = (List<TArticleinfo>) super.queryForList("queryTArticleinfoListByCondExact",
                tarticleinfo);
        log.debug("query tarticleinfo by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tarticleinfo by condition starting...");
        List<TArticleinfo> rList = (List<TArticleinfo>) super.queryForList("queryTArticleinfoListByCond", tarticleinfo,
                puEntity);
        log.debug("query tarticleinfo by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize) throws DAOException
    {
        log.debug("page query tarticleinfo by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTArticleinfoListCntByCond", tarticleinfo)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TArticleinfo> rsList = (List<TArticleinfo>) super.pageQuery("queryTArticleinfoListByCond",
                    tarticleinfo, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tarticleinfo by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTArticleinfoListByCond", "queryTArticleinfoListCntByCond", tarticleinfo,
                start, pageSize, puEntity);
    }
    
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTArticleinfoListByCondExtends", "queryTArticleinfoListCntByCondExtends", tarticleinfo,
                start, pageSize, puEntity);
    }

}