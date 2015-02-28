package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TFriendinfoApplyDAO extends DynamicObjectMispDAO implements ITFriendinfoApplyDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("insert tfriendinfoApply starting...");
        super.insert("insertTFriendinfoApply", tfriendinfoApply);
        log.debug("insert tfriendinfoApply end");
    }

    public void insertTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DAOException
    {
        log.debug("insert tfriendinfoApplyList starting...");
        if (null != tfriendinfoApplyList)
        {
            super.insertBatch("insertTFriendinfoApply", tfriendinfoApplyList);
        }
        log.debug("insert tfriendinfoApplyList end");
    }

    public void updateTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("update tfriendinfoApply by pk starting...");
        super.update("updateTFriendinfoApply", tfriendinfoApply);
        log.debug("update tfriendinfoApply by pk end");
    }

    public void updateTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DAOException
    {
        log.debug("update tfriendinfoApplyList by pk starting...");
        super.updateBatch("updateTFriendinfoApply", tfriendinfoApplyList);
        log.debug("update tfriendinfoApplyList by pk end");
    }

    public void updateTFriendinfoApplyByCond(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("update tfriendinfoApply by conditions starting...");
        super.update("updateTFriendinfoApplyByCond", tfriendinfoApply);
        log.debug("update tfriendinfoApply by conditions end");
    }

    public void deleteTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("delete tfriendinfoApply by pk starting...");
        super.delete("deleteTFriendinfoApply", tfriendinfoApply);
        log.debug("delete tfriendinfoApply by pk end");
    }

    public void deleteTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DAOException
    {
        log.debug("delete tfriendinfoApplyList by pk starting...");
        super.deleteBatch("deleteTFriendinfoApply", tfriendinfoApplyList);
        log.debug("delete tfriendinfoApplyList by pk end");
    }

    public void deleteTFriendinfoApplyByCond(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("delete tfriendinfoApply by conditions starting...");
        super.delete("deleteTFriendinfoApplyByCond", tfriendinfoApply);
        log.debug("delete tfriendinfoApply by conditions end");
    }

    public TFriendinfoApply getTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("query tfriendinfoApply starting...");
        TFriendinfoApply resultObj = (TFriendinfoApply) super.queryForObject("getTFriendinfoApply", tfriendinfoApply);
        log.debug("query tfriendinfoApply end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfoApply> getTFriendinfoApplyByCond(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("query tfriendinfoApply by condition starting...");
        List<TFriendinfoApply> rList = (List<TFriendinfoApply>) super.queryForList("queryTFriendinfoApplyListByCond",
                tfriendinfoApply);
        log.debug("query tfriendinfoApply by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfoApply> getTFriendinfoApplyByCondExact(TFriendinfoApply tfriendinfoApply) throws DAOException
    {
        log.debug("query tfriendinfoApply by exact condition starting...");
        List<TFriendinfoApply> rList = (List<TFriendinfoApply>) super.queryForList(
                "queryTFriendinfoApplyListByCondExact", tfriendinfoApply);
        log.debug("query tfriendinfoApply by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TFriendinfoApply> getTFriendinfoApplyByCond(TFriendinfoApply tfriendinfoApply, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query tfriendinfoApply by condition starting...");
        List<TFriendinfoApply> rList = (List<TFriendinfoApply>) super.queryForList("queryTFriendinfoApplyListByCond",
                tfriendinfoApply, puEntity);
        log.debug("query tfriendinfoApply by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize) throws DAOException
    {
        log.debug("page query tfriendinfoApply by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryTFriendinfoApplyListCntByCond", tfriendinfoApply))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TFriendinfoApply> rsList = (List<TFriendinfoApply>) super.pageQuery("queryTFriendinfoApplyListByCond",
                    tfriendinfoApply, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tfriendinfoApply by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryTFriendinfoApplyListByCondExtends", "queryTFriendinfoApplyListCntByCond",
                tfriendinfoApply, start, pageSize, puEntity);
    }

}