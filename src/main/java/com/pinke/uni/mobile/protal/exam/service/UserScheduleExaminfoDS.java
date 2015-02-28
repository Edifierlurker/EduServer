package com.pinke.uni.mobile.protal.exam.service;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.dao.IUserScheduleExaminfoDAO;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleExaminfoDS extends DynamicObjectBaseDS implements IUserScheduleExaminfoDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserScheduleExaminfoDAO dao = null;

    public void setDao(IUserScheduleExaminfoDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        log.debug("insert userScheduleExaminfo starting...");
        try
        {
            // if (null == userScheduleExaminfo.getExamindex())
            // {
            // userScheduleExaminfo.setExamindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
            // "user_schedule_examinfo"));
            // }
            dao.insertUserScheduleExaminfo(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleExaminfo end");
    }

    public void insertUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        log.debug("insert userScheduleExaminfoList by pk starting...");
        if (null == userScheduleExaminfoList || userScheduleExaminfoList.size() == 0)
        {
            log.debug("there is no datas in userScheduleExaminfoList");
            return;
        }
        try
        {
            int listSize = userScheduleExaminfoList.size();
            Long index = (Long) Sequence.getSequence("user_schedule_examinfo", listSize);
            for (int i = 0; i < userScheduleExaminfoList.size(); i++)
            {
                if (userScheduleExaminfoList.get(i) != null)
                {
                    if (null == userScheduleExaminfoList.get(i).getExamindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userScheduleExaminfoList.get(i).setExamindex(primaryindex);
                    }
                }
            }
            dao.insertUserScheduleExaminfoList(userScheduleExaminfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleExaminfoList by pk end");
    }

    public void updateUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        log.debug("update userScheduleExaminfo by pk starting...");
        try
        {
            dao.updateUserScheduleExaminfo(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleExaminfo by pk end");
    }

    public void updateUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        log.debug("update userScheduleExaminfoList by pk starting...");
        if (null == userScheduleExaminfoList || userScheduleExaminfoList.size() == 0)
        {
            log.debug("there is no datas in userScheduleExaminfoList");
            return;
        }
        try
        {
            dao.updateUserScheduleExaminfoList(userScheduleExaminfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleExaminfoList by pk end");
    }

    public void updateUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        log.debug("update userScheduleExaminfo by condition starting...");
        try
        {
            dao.updateUserScheduleExaminfoByCond(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleExaminfo by condition end");
    }

    public void removeUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        log.debug("remove userScheduleExaminfo by pk starting...");
        try
        {
            dao.deleteUserScheduleExaminfo(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleExaminfo by pk end");
    }

    public void removeUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        log.debug("remove userScheduleExaminfoList by pk starting...");
        if (null == userScheduleExaminfoList || userScheduleExaminfoList.size() == 0)
        {
            log.debug("there is no datas in userScheduleExaminfoList");
            return;
        }
        try
        {
            dao.deleteUserScheduleExaminfoList(userScheduleExaminfoList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleExaminfoList by pk end");
    }

    public void removeUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        log.debug("remove userScheduleExaminfo by condition starting...");
        try
        {
            dao.deleteUserScheduleExaminfoByCond(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleExaminfo by condition end");
    }

    public UserScheduleExaminfo getUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by pk starting...");
        UserScheduleExaminfo rsObj = null;
        try
        {
            rsObj = dao.getUserScheduleExaminfo(userScheduleExaminfo);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleExaminfoList by pk end");
        return rsObj;
    }

    public UserScheduleExaminfo getUserScheduleExaminfoByIndex(Long examindex) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by examindex starting...");
        UserScheduleExaminfo rsObj = new UserScheduleExaminfo();
        rsObj.setExamindex(examindex);
        try
        {
            rsObj = dao.getUserScheduleExaminfo(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleExaminfo by examindex end");
        return rsObj;
    }

    public UserScheduleExaminfoExtends getUserScheduleExaminfoByIndexExtends(Long examindex)
            throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by examindex starting...");
        UserScheduleExaminfoExtends rsObj = new UserScheduleExaminfoExtends();
        rsObj.setExamindex(examindex);
        try
        {
            rsObj = dao.getUserScheduleExaminfoExtends(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleExaminfo by examindex end");
        return rsObj;
    }

    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfo> rsList = null;
        try
        {
            rsList = dao.getUserScheduleExaminfoByCond(userScheduleExaminfo);
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
        log.debug("get userScheduleExaminfo by condition end");
        return rsList;
    }

    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCondExact(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by exact condition starting...");
        List<UserScheduleExaminfo> rsList = null;
        try
        {
            rsList = dao.getUserScheduleExaminfoByCondExact(userScheduleExaminfo);
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
        log.debug("get userScheduleExaminfo by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleExaminfo, start, pageSize);
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
        tableInfo.setData((List<UserScheduleExaminfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleExaminfo page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleExaminfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleExaminfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleExaminfo page info by condition end");
        return tableInfo;
    }

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtends(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfoExtends> rsList = null;
        try
        {
            rsList = dao.getUserScheduleExaminfoByCondExtends(userScheduleExaminfo);
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
        log.debug("get userScheduleExaminfo by condition end");
        return rsList;
    }

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtendsMore(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo by condition starting...");
        List<UserScheduleExaminfoExtends> rsList = null;
        try
        {
            rsList = dao.getUserScheduleExaminfoByCondExtendsMore(userScheduleExaminfo);
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
        log.debug("get userScheduleExaminfo by condition end");
        return rsList;
    }

    public TableDataInfo pageInfoQueryExtends(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtends(userScheduleExaminfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleExaminfoExtends>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleExaminfo page info by condition end");
        return tableInfo;
    }

    public TableDataInfo pageInfoQueryExtendsMore(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleExaminfo page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtendsMore(userScheduleExaminfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleExaminfoExtends>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleExaminfo page info by condition end");
        return tableInfo;
    }
}
