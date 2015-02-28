package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TGroupinfoBulletinPicDAO extends DynamicObjectMispDAO implements ITGroupinfoBulletinPicDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException
    {
        log.debug("insert tgroupinfoBulletinPic starting...");
        super.insert("insertTGroupinfoBulletinPic", tgroupinfoBulletinPic);
        log.debug("insert tgroupinfoBulletinPic end");
    }

    public void insertTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException
    {
        log.debug("insert tgroupinfoBulletinPicList starting...");
        if (null != tgroupinfoBulletinPicList)
        {
            super.insertBatch("insertTGroupinfoBulletinPic", tgroupinfoBulletinPicList);
        }
        log.debug("insert tgroupinfoBulletinPicList end");
    }

    public void updateTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException
    {
        log.debug("update tgroupinfoBulletinPic by pk starting...");
        super.update("updateTGroupinfoBulletinPic", tgroupinfoBulletinPic);
        log.debug("update tgroupinfoBulletinPic by pk end");
    }

    public void updateTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException
    {
        log.debug("update tgroupinfoBulletinPicList by pk starting...");
        super.updateBatch("updateTGroupinfoBulletinPic", tgroupinfoBulletinPicList);
        log.debug("update tgroupinfoBulletinPicList by pk end");
    }

    public void updateTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException
    {
        log.debug("update tgroupinfoBulletinPic by conditions starting...");
        super.update("updateTGroupinfoBulletinPicByCond", tgroupinfoBulletinPic);
        log.debug("update tgroupinfoBulletinPic by conditions end");
    }

    public void deleteTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException
    {
        log.debug("delete tgroupinfoBulletinPic by pk starting...");
        super.delete("deleteTGroupinfoBulletinPic", tgroupinfoBulletinPic);
        log.debug("delete tgroupinfoBulletinPic by pk end");
    }

    public void deleteTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException
    {
        log.debug("delete tgroupinfoBulletinPicList by pk starting...");
        super.deleteBatch("deleteTGroupinfoBulletinPic", tgroupinfoBulletinPicList);
        log.debug("delete tgroupinfoBulletinPicList by pk end");
    }

    public void deleteTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException
    {
        log.debug("delete tgroupinfoBulletinPic by conditions starting...");
        super.delete("deleteTGroupinfoBulletinPicByCond", tgroupinfoBulletinPic);
        log.debug("delete tgroupinfoBulletinPic by conditions end");
    }

    public TGroupinfoBulletinPic getTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException
    {
        log.debug("query tgroupinfoBulletinPic starting...");
        TGroupinfoBulletinPic resultObj = (TGroupinfoBulletinPic) super.queryForObject("getTGroupinfoBulletinPic",
                tgroupinfoBulletinPic);
        log.debug("query tgroupinfoBulletinPic end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException
    {
        log.debug("query tgroupinfoBulletinPic by condition starting...");
        List<TGroupinfoBulletinPic> rList = (List<TGroupinfoBulletinPic>) super.queryForList(
                "queryTGroupinfoBulletinPicListByCond", tgroupinfoBulletinPic);
        log.debug("query tgroupinfoBulletinPic by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCondExact(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException
    {
        log.debug("query tgroupinfoBulletinPic by exact condition starting...");
        List<TGroupinfoBulletinPic> rList = (List<TGroupinfoBulletinPic>) super.queryForList(
                "queryTGroupinfoBulletinPicListByCondExact", tgroupinfoBulletinPic);
        log.debug("query tgroupinfoBulletinPic by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query tgroupinfoBulletinPic by condition starting...");
        List<TGroupinfoBulletinPic> rList = (List<TGroupinfoBulletinPic>) super.queryForList(
                "queryTGroupinfoBulletinPicListByCond", tgroupinfoBulletinPic, puEntity);
        log.debug("query tgroupinfoBulletinPic by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize)
            throws DAOException
    {
        log.debug("page query tgroupinfoBulletinPic by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super
                .queryForObject("queryTGroupinfoBulletinPicListCntByCond", tgroupinfoBulletinPic)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<TGroupinfoBulletinPic> rsList = (List<TGroupinfoBulletinPic>) super.pageQuery(
                    "queryTGroupinfoBulletinPicListByCond", tgroupinfoBulletinPic, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query tgroupinfoBulletinPic by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryTGroupinfoBulletinPicListByCond", "queryTGroupinfoBulletinPicListCntByCond",
                tgroupinfoBulletinPic, start, pageSize, puEntity);
    }

}