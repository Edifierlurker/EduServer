package com.pinke.uni.mobile.protal.activity.service;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.dao.IUserActivityInviteMapDAO;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserActivityInviteMapDS extends DynamicObjectBaseDS implements IUserActivityInviteMapDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserActivityInviteMapDAO dao = null;

    public void setDao(IUserActivityInviteMapDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DomainServiceException
    {
        log.debug("insert userActivityInviteMap starting...");
        try
        {
            if (null == userActivityInviteMap.getInviteindex())
            {
                userActivityInviteMap.setInviteindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
                        "user_activity_invite_map"));
            }
            dao.insertUserActivityInviteMap(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userActivityInviteMap end");
    }

    public void insertUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        log.debug("insert userActivityInviteMapList by pk starting...");
        if (null == userActivityInviteMapList || userActivityInviteMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityInviteMapList");
            return;
        }
        try
        {
//            int listSize = userActivityInviteMapList.size();
//            Long index = (Long) Sequence.getSequence("user_activity_invite_map", listSize);
//            for (int i = 0; i < userActivityInviteMapList.size(); i++)
//            {
//                if (userActivityInviteMapList.get(i) != null)
//                {
//                    if (null == userActivityInviteMapList.get(i).getInviteindex())
//                    {
//                        Long primaryindex = Long.valueOf(index + i);
//                        userActivityInviteMapList.get(i).setInviteindex(primaryindex);
//                    }
//                }
//            }
            dao.insertUserActivityInviteMapList(userActivityInviteMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userActivityInviteMapList by pk end");
    }

    public void updateUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DomainServiceException
    {
        log.debug("update userActivityInviteMap by pk starting...");
        try
        {
            dao.updateUserActivityInviteMap(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityInviteMap by pk end");
    }

    public void updateUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        log.debug("update userActivityInviteMapList by pk starting...");
        if (null == userActivityInviteMapList || userActivityInviteMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityInviteMapList");
            return;
        }
        try
        {
            dao.updateUserActivityInviteMapList(userActivityInviteMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityInviteMapList by pk end");
    }

    public void updateUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        log.debug("update userActivityInviteMap by condition starting...");
        try
        {
            dao.updateUserActivityInviteMapByCond(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityInviteMap by condition end");
    }

    public void removeUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap) throws DomainServiceException
    {
        log.debug("remove userActivityInviteMap by pk starting...");
        try
        {
            dao.deleteUserActivityInviteMap(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityInviteMap by pk end");
    }

    public void removeUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        log.debug("remove userActivityInviteMapList by pk starting...");
        if (null == userActivityInviteMapList || userActivityInviteMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityInviteMapList");
            return;
        }
        try
        {
            dao.deleteUserActivityInviteMapList(userActivityInviteMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityInviteMapList by pk end");
    }

    public void removeUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        log.debug("remove userActivityInviteMap by condition starting...");
        try
        {
            dao.deleteUserActivityInviteMapByCond(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityInviteMap by condition end");
    }

    public UserActivityInviteMap getUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        log.debug("get userActivityInviteMap by pk starting...");
        UserActivityInviteMap rsObj = null;
        try
        {
            rsObj = dao.getUserActivityInviteMap(userActivityInviteMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userActivityInviteMapList by pk end");
        return rsObj;
    }

    public UserActivityInviteMap getUserActivityInviteMapByIndex(Long inviteindex) throws DomainServiceException
    {
        log.debug("get userActivityInviteMap by inviteindex starting...");
        UserActivityInviteMap rsObj = new UserActivityInviteMap();
        rsObj.setInviteindex(inviteindex);
        try
        {
            rsObj = dao.getUserActivityInviteMap(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userActivityInviteMap by inviteindex end");
        return rsObj;
    }

    public List<UserActivityInviteMap> getUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        log.debug("get userActivityInviteMap by condition starting...");
        List<UserActivityInviteMap> rsList = null;
        try
        {
            rsList = dao.getUserActivityInviteMapByCond(userActivityInviteMap);
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
        log.debug("get userActivityInviteMap by condition end");
        return rsList;
    }

    public List<UserActivityInviteMap> getUserActivityInviteMapByCondExact(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        log.debug("get userActivityInviteMap by exact condition starting...");
        List<UserActivityInviteMap> rsList = null;
        try
        {
            rsList = dao.getUserActivityInviteMapByCondExact(userActivityInviteMap);
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
        log.debug("get userActivityInviteMap by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userActivityInviteMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userActivityInviteMap, start, pageSize);
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
        tableInfo.setData((List<UserActivityInviteMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userActivityInviteMap page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userActivityInviteMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userActivityInviteMap, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserActivityInviteMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userActivityInviteMap page info by condition end");
        return tableInfo;
    }

}
