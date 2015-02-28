package com.pinke.uni.mobile.protal.personal.service;

import java.util.List;

import com.pinke.uni.mobile.protal.personal.dao.IUserSchedulePrivateDAO;
import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserSchedulePrivateDS extends DynamicObjectBaseDS implements IUserSchedulePrivateDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserSchedulePrivateDAO dao = null;

    public void setDao(IUserSchedulePrivateDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        log.debug("insert userSchedulePrivate starting...");
        try
        {
            if (null == userSchedulePrivate.getPrivateindex())
            {
                userSchedulePrivate.setPrivateindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
                        "user_schedule_private"));
            }
            dao.insertUserSchedulePrivate(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userSchedulePrivate end");
    }

    public void insertUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        log.debug("insert userSchedulePrivateList by pk starting...");
        if (null == userSchedulePrivateList || userSchedulePrivateList.size() == 0)
        {
            log.debug("there is no datas in userSchedulePrivateList");
            return;
        }
        try
        {
            int listSize = userSchedulePrivateList.size();
            Long index = (Long) Sequence.getSequence("user_schedule_private", listSize);
            for (int i = 0; i < userSchedulePrivateList.size(); i++)
            {
                if (userSchedulePrivateList.get(i) != null)
                {
                    if (null == userSchedulePrivateList.get(i).getPrivateindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userSchedulePrivateList.get(i).setPrivateindex(primaryindex);
                    }
                }
            }
            dao.insertUserSchedulePrivateList(userSchedulePrivateList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userSchedulePrivateList by pk end");
    }

    public void updateUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        log.debug("update userSchedulePrivate by pk starting...");
        try
        {
            dao.updateUserSchedulePrivate(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userSchedulePrivate by pk end");
    }

    public void updateUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        log.debug("update userSchedulePrivateList by pk starting...");
        if (null == userSchedulePrivateList || userSchedulePrivateList.size() == 0)
        {
            log.debug("there is no datas in userSchedulePrivateList");
            return;
        }
        try
        {
            dao.updateUserSchedulePrivateList(userSchedulePrivateList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userSchedulePrivateList by pk end");
    }

    public void updateUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        log.debug("update userSchedulePrivate by condition starting...");
        try
        {
            dao.updateUserSchedulePrivateByCond(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userSchedulePrivate by condition end");
    }

    public void removeUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        log.debug("remove userSchedulePrivate by pk starting...");
        try
        {
            dao.deleteUserSchedulePrivate(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userSchedulePrivate by pk end");
    }

    public void removeUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        log.debug("remove userSchedulePrivateList by pk starting...");
        if (null == userSchedulePrivateList || userSchedulePrivateList.size() == 0)
        {
            log.debug("there is no datas in userSchedulePrivateList");
            return;
        }
        try
        {
            dao.deleteUserSchedulePrivateList(userSchedulePrivateList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userSchedulePrivateList by pk end");
    }

    public void removeUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        log.debug("remove userSchedulePrivate by condition starting...");
        try
        {
            dao.deleteUserSchedulePrivateByCond(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userSchedulePrivate by condition end");
    }

    public UserSchedulePrivate getUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        log.debug("get userSchedulePrivate by pk starting...");
        UserSchedulePrivate rsObj = null;
        try
        {
            rsObj = dao.getUserSchedulePrivate(userSchedulePrivate);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userSchedulePrivateList by pk end");
        return rsObj;
    }

    public UserSchedulePrivate getUserSchedulePrivateByIndex(Long privateindex) throws DomainServiceException
    {
        log.debug("get userSchedulePrivate by privateindex starting...");
        UserSchedulePrivate rsObj = new UserSchedulePrivate();
        rsObj.setPrivateindex(privateindex);
        try
        {
            rsObj = dao.getUserSchedulePrivate(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userSchedulePrivate by privateindex end");
        return rsObj;
    }

    public List<UserSchedulePrivate> getUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        log.debug("get userSchedulePrivate by condition starting...");
        List<UserSchedulePrivate> rsList = null;
        try
        {
            rsList = dao.getUserSchedulePrivateByCond(userSchedulePrivate);
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
        log.debug("get userSchedulePrivate by condition end");
        return rsList;
    }

    public List<UserSchedulePrivate> getUserSchedulePrivateByCondExact(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        log.debug("get userSchedulePrivate by exact condition starting...");
        List<UserSchedulePrivate> rsList = null;
        try
        {
            rsList = dao.getUserSchedulePrivateByCondExact(userSchedulePrivate);
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
        log.debug("get userSchedulePrivate by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userSchedulePrivate page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userSchedulePrivate, start, pageSize);
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
        tableInfo.setData((List<UserSchedulePrivate>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userSchedulePrivate page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userSchedulePrivate page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userSchedulePrivate, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserSchedulePrivate>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userSchedulePrivate page info by condition end");
        return tableInfo;
    }

}
