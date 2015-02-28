package com.pinke.uni.mobile.protal.activity.service;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.dao.IUserScheduleActivityDAO;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleActivityDS extends DynamicObjectBaseDS implements IUserScheduleActivityDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserScheduleActivityDAO dao = null;

    public void setDao(IUserScheduleActivityDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        log.debug("insert userScheduleActivity starting...");
        try
        {
//            if (null == userScheduleActivity.getActivityindex())
//            {
//                userScheduleActivity.setActivityindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "user_schedule_activity"));
//            }
            dao.insertUserScheduleActivity(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleActivity end");
    }

    public void insertUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        log.debug("insert userScheduleActivityList by pk starting...");
        if (null == userScheduleActivityList || userScheduleActivityList.size() == 0)
        {
            log.debug("there is no datas in userScheduleActivityList");
            return;
        }
        try
        {
            int listSize = userScheduleActivityList.size();
            Long index = (Long) Sequence.getSequence("user_schedule_activity", listSize);
            for (int i = 0; i < userScheduleActivityList.size(); i++)
            {
                if (userScheduleActivityList.get(i) != null)
                {
                    if (null == userScheduleActivityList.get(i).getActivityindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userScheduleActivityList.get(i).setActivityindex(primaryindex);
                    }
                }
            }
            dao.insertUserScheduleActivityList(userScheduleActivityList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleActivityList by pk end");
    }

    public void updateUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        log.debug("update userScheduleActivity by pk starting...");
        try
        {
            dao.updateUserScheduleActivity(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleActivity by pk end");
    }

    public void updateUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        log.debug("update userScheduleActivityList by pk starting...");
        if (null == userScheduleActivityList || userScheduleActivityList.size() == 0)
        {
            log.debug("there is no datas in userScheduleActivityList");
            return;
        }
        try
        {
            dao.updateUserScheduleActivityList(userScheduleActivityList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleActivityList by pk end");
    }

    public void updateUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("update userScheduleActivity by condition starting...");
        try
        {
            dao.updateUserScheduleActivityByCond(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleActivity by condition end");
    }

    public void removeUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        log.debug("remove userScheduleActivity by pk starting...");
        try
        {
            dao.deleteUserScheduleActivity(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleActivity by pk end");
    }

    public void removeUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        log.debug("remove userScheduleActivityList by pk starting...");
        if (null == userScheduleActivityList || userScheduleActivityList.size() == 0)
        {
            log.debug("there is no datas in userScheduleActivityList");
            return;
        }
        try
        {
            dao.deleteUserScheduleActivityList(userScheduleActivityList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleActivityList by pk end");
    }

    public UserScheduleActivity getUserScheduleActivity(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity by pk starting...");
        UserScheduleActivity rsObj = null;
        try
        {
            rsObj = dao.getUserScheduleActivity(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleActivityList by pk end");
        return rsObj;
    }
    
    public UserScheduleActivityExtends getUserScheduleActivityExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity by pk starting...");
        UserScheduleActivityExtends rsObj = null;
        try
        {
            rsObj = dao.getUserScheduleActivityExtends(userScheduleActivity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleActivityList by pk end");
        return rsObj;
    }

    public UserScheduleActivity getUserScheduleActivityByIndex(Long activityindex) throws DomainServiceException
    {
        log.debug("get userScheduleActivity by activityindex starting...");
        UserScheduleActivity rsObj = new UserScheduleActivity();
        rsObj.setActivityindex(activityindex);
        try
        {
            rsObj = dao.getUserScheduleActivity(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleActivity by activityindex end");
        return rsObj;
    }

    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity by condition starting...");
        List<UserScheduleActivity> rsList = null;
        try
        {
            rsList = dao.getUserScheduleActivityByCond(userScheduleActivity);
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
        log.debug("get userScheduleActivity by condition end");
        return rsList;
    }

    public List<UserScheduleActivity> getUserScheduleActivityByCondExact(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity by exact condition starting...");
        List<UserScheduleActivity> rsList = null;
        try
        {
            rsList = dao.getUserScheduleActivityByCondExact(userScheduleActivity);
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
        log.debug("get userScheduleActivity by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleActivity, start, pageSize);
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
        tableInfo.setData((List<UserScheduleActivity>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleActivity page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleActivity page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleActivity, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleActivity>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleActivity page info by condition end");
        return tableInfo;
    }
    
    public List<UserScheduleActivity> getUserScheduleActivityByCondExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DomainServiceException
    {
        log.debug("get userScheduleActivity by condition starting...");
        List<UserScheduleActivity> rsList = null;
        try
        {
            rsList = dao.getUserScheduleActivityByCondExtends(userScheduleActivity);
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
        log.debug("get userScheduleActivity by condition end");
        return rsList;
    }
    
    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQueryExtends(UserScheduleActivityExtends userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleActivity page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtends(userScheduleActivity, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleActivityExtends>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleActivity page info by condition end");
        return tableInfo;
    }

}
