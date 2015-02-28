package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TArticleinfoLikeDAO extends DynamicObjectMispDAO implements ITArticleinfoLikeDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("insert tarticleinfoLike starting...");
        super.insert("insertTArticleinfoLike", tarticleinfoLike);
        log.debug("insert tarticleinfoLike end");
    }

    public void insertTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DAOException
    {
        log.debug("insert tarticleinfoLikeList starting...");
        if (null != tarticleinfoLikeList)
        {
            super.insertBatch("insertTArticleinfoLike", tarticleinfoLikeList);
        }
        log.debug("insert tarticleinfoLikeList end");
    }

    public void updateTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("update tarticleinfoLike by pk starting...");
        super.update("updateTArticleinfoLike", tarticleinfoLike);
        log.debug("update tarticleinfoLike by pk end");
    }

    public void updateTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DAOException
    {
        log.debug("update tarticleinfoLikeList by pk starting...");
        super.updateBatch("updateTArticleinfoLike", tarticleinfoLikeList);
        log.debug("update tarticleinfoLikeList by pk end");
    }

    public void updateTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("update tarticleinfoLike by conditions starting...");
        super.update("updateTArticleinfoLikeByCond", tarticleinfoLike);
        log.debug("update tarticleinfoLike by conditions end");
    }

    public void deleteTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("delete tarticleinfoLike by pk starting...");
        super.delete("deleteTArticleinfoLike", tarticleinfoLike);
        log.debug("delete tarticleinfoLike by pk end");
    }

    public void deleteTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DAOException
    {
        log.debug("delete tarticleinfoLikeList by pk starting...");
        super.deleteBatch("deleteTArticleinfoLike", tarticleinfoLikeList);
        log.debug("delete tarticleinfoLikeList by pk end");
    }

    public void deleteTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("delete tarticleinfoLike by conditions starting...");
        super.delete("deleteTArticleinfoLikeByCond", tarticleinfoLike);
        log.debug("delete tarticleinfoLike by conditions end");
    }

    public TArticleinfoLike getTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("query tarticleinfoLike starting...");
        TArticleinfoLike resultObj = (TArticleinfoLike) super.queryForObject("getTArticleinfoLike", tarticleinfoLike);
        log.debug("query tarticleinfoLike end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoLike> getTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("query tarticleinfoLike by condition starting...");
        List<TArticleinfoLike> rList = (List<TArticleinfoLike>) super.queryForList("queryTArticleinfoLikeListByCond",
                tarticleinfoLike);
        log.debug("query tarticleinfoLike by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoLike> getTArticleinfoLikeByCondExact(TArticleinfoLike tarticleinfoLike) throws DAOException
    {
        log.debug("query tarticleinfoLike by exact condition starting...");
        List<TArticleinfoLike> rList = (List<TArticleinfoLike>) super.queryForList(
                "queryTArticleinfoLikeListByCondExact", tarticleinfoLike);
        log.debug("query tarticleinfoLike by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TArticleinfoLike> getTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tarticleinfoLike by condition starting...");
        List<TArticleinfoLike> rList = (List<TArticleinfoLike>) super.queryForList("queryTArticleinfoLikeListByCond",
                tarticleinfoLike, puEntity);
        log.debug("query tarticleinfoLike by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize) throws DAOException
    {
        log.debug("page query tarticleinfoLike by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTArticleinfoLikeListCntByCond", tarticleinfoLike))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TArticleinfoLike> rsList = (List<TArticleinfoLike>) super.pageQuery("queryTArticleinfoLikeListByCond",
                    tarticleinfoLike, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tarticleinfoLike by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTArticleinfoLikeListByCond", "queryTArticleinfoLikeListCntByCond",
                tarticleinfoLike, start, pageSize, puEntity);
    }

}