package com.pinke.uni.mobile.protal.schedule.service;

import java.util.List;

import com.pinke.uni.mobile.protal.schedule.dao.IUserScheduleDAO;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleDS extends DynamicObjectBaseDS implements IUserScheduleDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserScheduleDAO dao = null;

    public void setDao(IUserScheduleDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("insert userSchedule starting...");
        try
        {
//            if (null == userSchedule.getScheduleindex())
//            {
//                userSchedule.setScheduleindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("user_schedule"));
//            }
            dao.insertUserSchedule(userSchedule);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userSchedule end");
    }

    public void insertUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        log.debug("insert userScheduleList by pk starting...");
        if (null == userScheduleList || userScheduleList.size() == 0)
        {
            log.debug("there is no datas in userScheduleList");
            return;
        }
        try
        {
            int listSize = userScheduleList.size();
            Long index = (Long) Sequence.getSequence("user_schedule", listSize);
            for (int i = 0; i < userScheduleList.size(); i++)
            {
                if (userScheduleList.get(i) != null)
                {
                    if (null == userScheduleList.get(i).getScheduleindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userScheduleList.get(i).setScheduleindex(primaryindex);
                    }
                }
            }
            dao.insertUserScheduleList(userScheduleList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleList by pk end");
    }

    public void updateUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("update userSchedule by pk starting...");
        try
        {
            dao.updateUserSchedule(userSchedule);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userSchedule by pk end");
    }

    public void updateUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        log.debug("update userScheduleList by pk starting...");
        if (null == userScheduleList || userScheduleList.size() == 0)
        {
            log.debug("there is no datas in userScheduleList");
            return;
        }
        try
        {
            dao.updateUserScheduleList(userScheduleList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleList by pk end");
    }

    public void removeUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("remove userSchedule by pk starting...");
        try
        {
            dao.deleteUserScheduleByCond(userSchedule);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userSchedule by pk end");
    }

    public void removeUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        log.debug("remove userScheduleList by pk starting...");
        if (null == userScheduleList || userScheduleList.size() == 0)
        {
            log.debug("there is no datas in userScheduleList");
            return;
        }
        try
        {
            dao.deleteUserScheduleList(userScheduleList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleList by pk end");
    }

    public UserSchedule getUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("get userSchedule by pk starting...");
        UserSchedule rsObj = null;
        try
        {
            rsObj = dao.getUserSchedule(userSchedule);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleList by pk end");
        return rsObj;
    }

    public UserSchedule getUserScheduleByIndex(Long scheduleindex) throws DomainServiceException
    {
        log.debug("get userSchedule by scheduleindex starting...");
        UserSchedule rsObj = new UserSchedule();
        rsObj.setScheduleindex(scheduleindex);
        try
        {
            rsObj = dao.getUserSchedule(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userSchedule by scheduleindex end");
        return rsObj;
    }

    public List<UserSchedule> getUserScheduleByCond(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("get userSchedule by condition starting...");
        List<UserSchedule> rsList = null;
        try
        {
            rsList = dao.getUserScheduleByCond(userSchedule);
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
        log.debug("get userSchedule by condition end");
        return rsList;
    }

    public List<UserSchedule> getUserScheduleByCondExact(UserSchedule userSchedule) throws DomainServiceException
    {
        log.debug("get userSchedule by exact condition starting...");
        List<UserSchedule> rsList = null;
        try
        {
            rsList = dao.getUserScheduleByCondExact(userSchedule);
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
        log.debug("get userSchedule by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userSchedule page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userSchedule, start, pageSize);
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
        tableInfo.setData((List<UserSchedule>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userSchedule page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get userSchedule page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userSchedule, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserSchedule>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userSchedule page info by condition end");
        return tableInfo;
    }

}
