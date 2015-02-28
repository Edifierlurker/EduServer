package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITArticleinfoLikeDAO;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoLikeDS extends DynamicObjectBaseDS implements ITArticleinfoLikeDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITArticleinfoLikeDAO dao = null;

    public void setDao(ITArticleinfoLikeDAO dao)
    {
        this.dao = dao;
    }

    public void insertTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("insert tarticleinfoLike starting...");
        try
        {
//            if (null == tarticleinfoLike.getLikeindex())
//            {
//                tarticleinfoLike.setLikeindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_articleinfo_like"));
//            }
            dao.insertTArticleinfoLike(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tarticleinfoLike end");
    }

    public void insertTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        log.debug("insert tarticleinfoLikeList by pk starting...");
        if (null == tarticleinfoLikeList || tarticleinfoLikeList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoLikeList");
            return;
        }
        try
        {
            int listSize = tarticleinfoLikeList.size();
            Long index = (Long) Sequence.getSequence("t_articleinfo_like", listSize);
            for (int i = 0; i < tarticleinfoLikeList.size(); i++)
            {
                if (tarticleinfoLikeList.get(i) != null)
                {
                    if (null == tarticleinfoLikeList.get(i).getLikeindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tarticleinfoLikeList.get(i).setLikeindex(primaryindex);
                    }
                }
            }
            dao.insertTArticleinfoLikeList(tarticleinfoLikeList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tarticleinfoLikeList by pk end");
    }

    public void updateTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("update tarticleinfoLike by pk starting...");
        try
        {
            dao.updateTArticleinfoLike(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoLike by pk end");
    }

    public void updateTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        log.debug("update tarticleinfoLikeList by pk starting...");
        if (null == tarticleinfoLikeList || tarticleinfoLikeList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoLikeList");
            return;
        }
        try
        {
            dao.updateTArticleinfoLikeList(tarticleinfoLikeList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoLikeList by pk end");
    }

    public void updateTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("update tarticleinfoLike by condition starting...");
        try
        {
            dao.updateTArticleinfoLikeByCond(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoLike by condition end");
    }

    public void removeTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("remove tarticleinfoLike by pk starting...");
        try
        {
            dao.deleteTArticleinfoLike(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoLike by pk end");
    }

    public void removeTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        log.debug("remove tarticleinfoLikeList by pk starting...");
        if (null == tarticleinfoLikeList || tarticleinfoLikeList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoLikeList");
            return;
        }
        try
        {
            dao.deleteTArticleinfoLikeList(tarticleinfoLikeList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoLikeList by pk end");
    }

    public void removeTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("remove tarticleinfoLike by condition starting...");
        try
        {
            dao.deleteTArticleinfoLikeByCond(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoLike by condition end");
    }

    public TArticleinfoLike getTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        log.debug("get tarticleinfoLike by pk starting...");
        TArticleinfoLike rsObj = null;
        try
        {
            rsObj = dao.getTArticleinfoLike(tarticleinfoLike);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tarticleinfoLikeList by pk end");
        return rsObj;
    }

    public TArticleinfoLike getTArticleinfoLikeByIndex(Long likeindex) throws DomainServiceException
    {
        log.debug("get tarticleinfoLike by likeindex starting...");
        TArticleinfoLike rsObj = new TArticleinfoLike();
        rsObj.setLikeindex(likeindex);
        try
        {
            rsObj = dao.getTArticleinfoLike(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tarticleinfoLike by likeindex end");
        return rsObj;
    }

    public List<TArticleinfoLike> getTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoLike by condition starting...");
        List<TArticleinfoLike> rsList = null;
        try
        {
            rsList = dao.getTArticleinfoLikeByCond(tarticleinfoLike);
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
        log.debug("get tarticleinfoLike by condition end");
        return rsList;
    }

    public List<TArticleinfoLike> getTArticleinfoLikeByCondExact(TArticleinfoLike tarticleinfoLike)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoLike by exact condition starting...");
        List<TArticleinfoLike> rsList = null;
        try
        {
            rsList = dao.getTArticleinfoLikeByCondExact(tarticleinfoLike);
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
        log.debug("get tarticleinfoLike by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoLike page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tarticleinfoLike, start, pageSize);
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
        tableInfo.setData((List<TArticleinfoLike>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tarticleinfoLike page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get tarticleinfoLike page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tarticleinfoLike, start, pageSize, puEntity);
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
        tableInfo.setData((List<TArticleinfoLike>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tarticleinfoLike page info by condition end");
        return tableInfo;
    }

}
