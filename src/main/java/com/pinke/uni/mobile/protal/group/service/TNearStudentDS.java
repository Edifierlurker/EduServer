package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITNearStudentDAO;
import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TNearStudentDS extends DynamicObjectBaseDS implements ITNearStudentDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ITNearStudentDAO dao = null;

    public void setDao(ITNearStudentDAO dao)
    {
        this.dao = dao;
    }

    public void insertTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("insert tnearStudent starting...");
        try
        {
            if (null == tnearStudent.getStudentindex())
            {
                tnearStudent.setStudentindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_near_student"));
            }
            dao.insertTNearStudent(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tnearStudent end");
    }

    public void insertTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        log.debug("insert tnearStudentList by pk starting...");
        if (null == tnearStudentList || tnearStudentList.size() == 0)
        {
            log.debug("there is no datas in tnearStudentList");
            return;
        }
        try
        {
            int listSize = tnearStudentList.size();
            Long index = (Long) Sequence.getSequence("t_near_student", listSize);
            for (int i = 0; i < tnearStudentList.size(); i++)
            {
                if (tnearStudentList.get(i) != null)
                {
                    if (null == tnearStudentList.get(i).getStudentindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        tnearStudentList.get(i).setStudentindex(primaryindex);
                    }
                }
            }
            dao.insertTNearStudentList(tnearStudentList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert tnearStudentList by pk end");
    }

    public void updateTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("update tnearStudent by pk starting...");
        try
        {
            dao.updateTNearStudent(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tnearStudent by pk end");
    }

    public void updateTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        log.debug("update tnearStudentList by pk starting...");
        if (null == tnearStudentList || tnearStudentList.size() == 0)
        {
            log.debug("there is no datas in tnearStudentList");
            return;
        }
        try
        {
            dao.updateTNearStudentList(tnearStudentList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tnearStudentList by pk end");
    }

    public void updateTNearStudentByCond(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("update tnearStudent by condition starting...");
        try
        {
            dao.updateTNearStudentByCond(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update tnearStudent by condition end");
    }

    public void removeTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("remove tnearStudent by pk starting...");
        try
        {
            dao.deleteTNearStudent(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tnearStudent by pk end");
    }

    public void removeTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        log.debug("remove tnearStudentList by pk starting...");
        if (null == tnearStudentList || tnearStudentList.size() == 0)
        {
            log.debug("there is no datas in tnearStudentList");
            return;
        }
        try
        {
            dao.deleteTNearStudentList(tnearStudentList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tnearStudentList by pk end");
    }

    public void removeTNearStudentByCond(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("remove tnearStudent by condition starting...");
        try
        {
            dao.deleteTNearStudentByCond(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove tnearStudent by condition end");
    }

    public TNearStudent getTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("get tnearStudent by pk starting...");
        TNearStudent rsObj = null;
        try
        {
            rsObj = dao.getTNearStudent(tnearStudent);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tnearStudentList by pk end");
        return rsObj;
    }

    public TNearStudent getTNearStudentByIndex(Long studentindex) throws DomainServiceException
    {
        log.debug("get tnearStudent by studentindex starting...");
        TNearStudent rsObj = new TNearStudent();
        rsObj.setStudentindex(studentindex);
        try
        {
            rsObj = dao.getTNearStudent(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get tnearStudent by studentindex end");
        return rsObj;
    }

    public List<TNearStudent> getTNearStudentByCond(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("get tnearStudent by condition starting...");
        List<TNearStudent> rsList = null;
        try
        {
            rsList = dao.getTNearStudentByCond(tnearStudent);
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
        log.debug("get tnearStudent by condition end");
        return rsList;
    }

    public List<TNearStudent> getTNearStudentByCondExact(TNearStudent tnearStudent) throws DomainServiceException
    {
        log.debug("get tnearStudent by exact condition starting...");
        List<TNearStudent> rsList = null;
        try
        {
            rsList = dao.getTNearStudentByCondExact(tnearStudent);
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
        log.debug("get tnearStudent by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get tnearStudent page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tnearStudent, start, pageSize);
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
        tableInfo.setData((List<TNearStudent>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tnearStudent page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get tnearStudent page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(tnearStudent, start, pageSize, puEntity);
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
        tableInfo.setData((List<TNearStudent>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get tnearStudent page info by condition end");
        return tableInfo;
    }

}
