package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupinfoBulletinPicDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoBulletinPicDS extends DynamicObjectBaseDS implements ITGroupinfoBulletinPicDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITGroupinfoBulletinPicDAO dao = null;

    public void setDao(ITGroupinfoBulletinPicDAO dao)
    {
        this.dao = dao;
    }

    public void insertTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DomainServiceException
    {
        log.debug("insert tgroupinfoBulletinPic starting...");
        try
        {
//            if (null == tgroupinfoBulletinPic.getPicindex())
//            {
//                tgroupinfoBulletinPic.setPicindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "t_groupinfo_bulletin_pic"));
//            }
            dao.insertTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfoBulletinPic end");
    }

    public void insertTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        log.debug("insert tgroupinfoBulletinPicList by pk starting...");
        if (null == tgroupinfoBulletinPicList || tgroupinfoBulletinPicList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinPicList");
            return;
        }
        try
        {
//            int listSize = tgroupinfoBulletinPicList.size();
//            Long index = (Long) Sequence.getSequence("t_groupinfo_bulletin_pic", listSize);
//            for (int i = 0; i < tgroupinfoBulletinPicList.size(); i++)
//            {
//                if (tgroupinfoBulletinPicList.get(i) != null)
//                {
//                    if (null == tgroupinfoBulletinPicList.get(i).getPicindex())
//                    {
//                        Long primaryindex = Long.valueOf(index + i);
//                        tgroupinfoBulletinPicList.get(i).setPicindex(primaryindex);
//                    }
//                }
//            }
            dao.insertTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tgroupinfoBulletinPicList by pk end");
    }

    public void updateTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletinPic by pk starting...");
        try
        {
            dao.updateTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletinPic by pk end");
    }

    public void updateTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletinPicList by pk starting...");
        if (null == tgroupinfoBulletinPicList || tgroupinfoBulletinPicList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinPicList");
            return;
        }
        try
        {
            dao.updateTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletinPicList by pk end");
    }

    public void updateTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        log.debug("update tgroupinfoBulletinPic by condition starting...");
        try
        {
            dao.updateTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tgroupinfoBulletinPic by condition end");
    }

    public void removeTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletinPic by pk starting...");
        try
        {
            dao.deleteTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletinPic by pk end");
    }

    public void removeTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletinPicList by pk starting...");
        if (null == tgroupinfoBulletinPicList || tgroupinfoBulletinPicList.size() == 0)
        {
            log.debug("there is no datas in tgroupinfoBulletinPicList");
            return;
        }
        try
        {
            dao.deleteTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletinPicList by pk end");
    }

    public void removeTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        log.debug("remove tgroupinfoBulletinPic by condition starting...");
        try
        {
            dao.deleteTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tgroupinfoBulletinPic by condition end");
    }

    public TGroupinfoBulletinPic getTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic by pk starting...");
        TGroupinfoBulletinPic rsObj = null;
        try
        {
            rsObj = dao.getTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfoBulletinPicList by pk end");
        return rsObj;
    }

    public TGroupinfoBulletinPic getTGroupinfoBulletinPicByIndex(Long picindex) throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic by picindex starting...");
        TGroupinfoBulletinPic rsObj = new TGroupinfoBulletinPic();
        rsObj.setPicindex(picindex);
        try
        {
            rsObj = dao.getTGroupinfoBulletinPic(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tgroupinfoBulletinPic by picindex end");
        return rsObj;
    }

    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic by condition starting...");
        List<TGroupinfoBulletinPic> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);
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
        log.debug("get tgroupinfoBulletinPic by condition end");
        return rsList;
    }

    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCondExact(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic by exact condition starting...");
        List<TGroupinfoBulletinPic> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoBulletinPicByCondExact(tgroupinfoBulletinPic);
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
        log.debug("get tgroupinfoBulletinPic by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfoBulletinPic, start, pageSize);
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
        tableInfo.setData((List<TGroupinfoBulletinPic>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfoBulletinPic page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get tgroupinfoBulletinPic page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tgroupinfoBulletinPic, start, pageSize, puEntity);
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
        tableInfo.setData((List<TGroupinfoBulletinPic>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tgroupinfoBulletinPic page info by condition end");
        return tableInfo;
    }

}
