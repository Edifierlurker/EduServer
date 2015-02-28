package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITArticleinfoShareDAO;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoShareDS extends DynamicObjectBaseDS implements ITArticleinfoShareDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITArticleinfoShareDAO dao = null;

    public void setDao(ITArticleinfoShareDAO dao)
    {
        this.dao = dao;
    }

    public void insertTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("insert tarticleinfoShare starting...");
        try
        {
//            if (null == tarticleinfoShare.getShareindex())
//            {
//                tarticleinfoShare.setShareindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "t_articleinfo_share"));
//            }
            dao.insertTArticleinfoShare(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tarticleinfoShare end");
    }

    public void insertTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        log.debug("insert tarticleinfoShareList by pk starting...");
        if (null == tarticleinfoShareList || tarticleinfoShareList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoShareList");
            return;
        }
        try
        {
            int listSize = tarticleinfoShareList.size();
            Long index = (Long) Sequence.getSequence("t_articleinfo_share", listSize);
            for (int i = 0; i < tarticleinfoShareList.size(); i++)
            {
                if (tarticleinfoShareList.get(i) != null)
                {
                    if (null == tarticleinfoShareList.get(i).getShareindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tarticleinfoShareList.get(i).setShareindex(primaryindex);
                    }
                }
            }
            dao.insertTArticleinfoShareList(tarticleinfoShareList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tarticleinfoShareList by pk end");
    }

    public void updateTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("update tarticleinfoShare by pk starting...");
        try
        {
            dao.updateTArticleinfoShare(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoShare by pk end");
    }

    public void updateTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        log.debug("update tarticleinfoShareList by pk starting...");
        if (null == tarticleinfoShareList || tarticleinfoShareList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoShareList");
            return;
        }
        try
        {
            dao.updateTArticleinfoShareList(tarticleinfoShareList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoShareList by pk end");
    }

    public void updateTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("update tarticleinfoShare by condition starting...");
        try
        {
            dao.updateTArticleinfoShareByCond(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tarticleinfoShare by condition end");
    }

    public void removeTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("remove tarticleinfoShare by pk starting...");
        try
        {
            dao.deleteTArticleinfoShare(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoShare by pk end");
    }

    public void removeTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        log.debug("remove tarticleinfoShareList by pk starting...");
        if (null == tarticleinfoShareList || tarticleinfoShareList.size() == 0)
        {
            log.debug("there is no datas in tarticleinfoShareList");
            return;
        }
        try
        {
            dao.deleteTArticleinfoShareList(tarticleinfoShareList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoShareList by pk end");
    }

    public void removeTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("remove tarticleinfoShare by condition starting...");
        try
        {
            dao.deleteTArticleinfoShareByCond(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tarticleinfoShare by condition end");
    }

    public TArticleinfoShare getTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        log.debug("get tarticleinfoShare by pk starting...");
        TArticleinfoShare rsObj = null;
        try
        {
            rsObj = dao.getTArticleinfoShare(tarticleinfoShare);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tarticleinfoShareList by pk end");
        return rsObj;
    }

    public TArticleinfoShare getTArticleinfoShareByIndex(Long shareindex) throws DomainServiceException
    {
        log.debug("get tarticleinfoShare by shareindex starting...");
        TArticleinfoShare rsObj = new TArticleinfoShare();
        rsObj.setShareindex(shareindex);
        try
        {
            rsObj = dao.getTArticleinfoShare(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tarticleinfoShare by shareindex end");
        return rsObj;
    }

    public List<TArticleinfoShare> getTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoShare by condition starting...");
        List<TArticleinfoShare> rsList = null;
        try
        {
            rsList = dao.getTArticleinfoShareByCond(tarticleinfoShare);
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
        log.debug("get tarticleinfoShare by condition end");
        return rsList;
    }

    public List<TArticleinfoShare> getTArticleinfoShareByCondExact(TArticleinfoShare tarticleinfoShare)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoShare by exact condition starting...");
        List<TArticleinfoShare> rsList = null;
        try
        {
            rsList = dao.getTArticleinfoShareByCondExact(tarticleinfoShare);
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
        log.debug("get tarticleinfoShare by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tarticleinfoShare page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tarticleinfoShare, start, pageSize);
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
        tableInfo.setData((List<TArticleinfoShare>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tarticleinfoShare page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get tarticleinfoShare page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tarticleinfoShare, start, pageSize, puEntity);
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
        tableInfo.setData((List<TArticleinfoShare>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tarticleinfoShare page info by condition end");
        return tableInfo;
    }

}
