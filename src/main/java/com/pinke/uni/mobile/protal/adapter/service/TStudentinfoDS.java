package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.dao.ITStudentinfoDAO;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TStudentinfoDS extends DynamicObjectBaseDS implements ITStudentinfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITStudentinfoDAO dao = null;

    public void setDao(ITStudentinfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("insert tstudentinfo starting...");
        try
        {
//            if (null == tstudentinfo.getStudentindex())
//            {
//                tstudentinfo.setStudentindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_studentinfo"));
//            }
            dao.insertTStudentinfo(tstudentinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tstudentinfo end");
    }

    public void insertTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        log.debug("insert tstudentinfoList by pk starting...");
        if (null == tstudentinfoList || tstudentinfoList.size() == 0)
        {
            log.debug("there is no datas in tstudentinfoList");
            return;
        }
        try
        {
            int listSize = tstudentinfoList.size();
            Long index = (Long) Sequence.getSequence("t_studentinfo", listSize);
            for (int i = 0; i < tstudentinfoList.size(); i++)
            {
                if (tstudentinfoList.get(i) != null)
                {
                    if (null == tstudentinfoList.get(i).getStudentindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tstudentinfoList.get(i).setStudentindex(primaryindex);
                    }
                }
            }
            dao.insertTStudentinfoList(tstudentinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tstudentinfoList by pk end");
    }

    public void updateTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("update tstudentinfo by pk starting...");
        try
        {
            dao.updateTStudentinfo(tstudentinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tstudentinfo by pk end");
    }

    public void updateTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        log.debug("update tstudentinfoList by pk starting...");
        if (null == tstudentinfoList || tstudentinfoList.size() == 0)
        {
            log.debug("there is no datas in tstudentinfoList");
            return;
        }
        try
        {
            dao.updateTStudentinfoList(tstudentinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tstudentinfoList by pk end");
    }

    public void removeTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("remove tstudentinfo by pk starting...");
        try
        {
            dao.deleteTStudentinfo(tstudentinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tstudentinfo by pk end");
    }

    public void removeTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        log.debug("remove tstudentinfoList by pk starting...");
        if (null == tstudentinfoList || tstudentinfoList.size() == 0)
        {
            log.debug("there is no datas in tstudentinfoList");
            return;
        }
        try
        {
            dao.deleteTStudentinfoList(tstudentinfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tstudentinfoList by pk end");
    }

    public TStudentinfo getTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("get tstudentinfo by pk starting...");
        TStudentinfo rsObj = null;
        try
        {
            rsObj = dao.getTStudentinfo(tstudentinfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tstudentinfoList by pk end");
        return rsObj;
    }

    public TStudentinfo getTStudentinfoByIndex(Long studentindex) throws DomainServiceException
    {
        log.debug("get tstudentinfo by studentindex starting...");
        TStudentinfo rsObj = new TStudentinfo();
        rsObj.setStudentindex(studentindex);
        try
        {
            rsObj = dao.getTStudentinfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tstudentinfo by studentindex end");
        return rsObj;
    }

    public List<TStudentinfo> getTStudentinfoByCond(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("get tstudentinfo by condition starting...");
        List<TStudentinfo> rsList = null;
        try
        {
            rsList = dao.getTStudentinfoByCond(tstudentinfo);
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
        log.debug("get tstudentinfo by condition end");
        return rsList;
    }

    public List<TStudentinfo> getTStudentinfoByCondExact(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        log.debug("get tstudentinfo by exact condition starting...");
        List<TStudentinfo> rsList = null;
        try
        {
            rsList = dao.getTStudentinfoByCondExact(tstudentinfo);
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
        log.debug("get tstudentinfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tstudentinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tstudentinfo, start, pageSize);
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
        tableInfo.setData((List<TStudentinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tstudentinfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tstudentinfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tstudentinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TStudentinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tstudentinfo page info by condition end");
        return tableInfo;
    }
    /**
     * 根据用户名查询用户信息
     * @param userCode
     * @return
     * @throws DomainServiceException
     */
    public TStudentinfo getTStudentinfoByUserCode(String userCode) throws DomainServiceException{

        log.debug("get tstudentinfo by studentindex starting...");
        TStudentinfo rsObj = new TStudentinfo();
        rsObj.setUserphone(userCode);
        try
        {
            rsObj = dao.getTStudentinfoByUserCode(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tstudentinfo by studentindex end");
        return rsObj;
    
    }


}
