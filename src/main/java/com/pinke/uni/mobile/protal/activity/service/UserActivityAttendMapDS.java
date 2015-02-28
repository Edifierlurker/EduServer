package com.pinke.uni.mobile.protal.activity.service;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.dao.IUserActivityAttendMapDAO;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserActivityAttendMapDS extends DynamicObjectBaseDS implements IUserActivityAttendMapDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserActivityAttendMapDAO dao = null;

    public void setDao(IUserActivityAttendMapDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DomainServiceException
    {
        log.debug("insert userActivityAttendMap starting...");
        try
        {
//            if (null == userActivityAttendMap.getAttendindex())
//            {
//                userActivityAttendMap.setAttendindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "user_activity_attend_map"));
//            }
            dao.insertUserActivityAttendMap(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userActivityAttendMap end");
    }

    public void insertUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        log.debug("insert userActivityAttendMapList by pk starting...");
        if (null == userActivityAttendMapList || userActivityAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityAttendMapList");
            return;
        }
        try
        {
            int listSize = userActivityAttendMapList.size();
            Long index = (Long) Sequence.getSequence("user_activity_attend_map", listSize);
            for (int i = 0; i < userActivityAttendMapList.size(); i++)
            {
                if (userActivityAttendMapList.get(i) != null)
                {
                    if (null == userActivityAttendMapList.get(i).getAttendindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userActivityAttendMapList.get(i).setAttendindex(primaryindex);
                    }
                }
            }
            dao.insertUserActivityAttendMapList(userActivityAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userActivityAttendMapList by pk end");
    }

    public void updateUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DomainServiceException
    {
        log.debug("update userActivityAttendMap by pk starting...");
        try
        {
            dao.updateUserActivityAttendMap(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityAttendMap by pk end");
    }

    public void updateUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        log.debug("update userActivityAttendMapList by pk starting...");
        if (null == userActivityAttendMapList || userActivityAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityAttendMapList");
            return;
        }
        try
        {
            dao.updateUserActivityAttendMapList(userActivityAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityAttendMapList by pk end");
    }

    public void updateUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        log.debug("update userActivityAttendMap by condition starting...");
        try
        {
            dao.updateUserActivityAttendMapByCond(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userActivityAttendMap by condition end");
    }

    public void removeUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap) throws DomainServiceException
    {
        log.debug("remove userActivityAttendMap by pk starting...");
        try
        {
            dao.deleteUserActivityAttendMap(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityAttendMap by pk end");
    }

    public void removeUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        log.debug("remove userActivityAttendMapList by pk starting...");
        if (null == userActivityAttendMapList || userActivityAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userActivityAttendMapList");
            return;
        }
        try
        {
            dao.deleteUserActivityAttendMapList(userActivityAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityAttendMapList by pk end");
    }

    public void removeUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        log.debug("remove userActivityAttendMap by condition starting...");
        try
        {
            dao.deleteUserActivityAttendMapByCond(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userActivityAttendMap by condition end");
    }

    public UserActivityAttendMap getUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        log.debug("get userActivityAttendMap by pk starting...");
        UserActivityAttendMap rsObj = null;
        try
        {
            rsObj = dao.getUserActivityAttendMap(userActivityAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userActivityAttendMapList by pk end");
        return rsObj;
    }

    public UserActivityAttendMap getUserActivityAttendMapByIndex(Long attendindex) throws DomainServiceException
    {
        log.debug("get userActivityAttendMap by attendindex starting...");
        UserActivityAttendMap rsObj = new UserActivityAttendMap();
        rsObj.setAttendindex(attendindex);
        try
        {
            rsObj = dao.getUserActivityAttendMap(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userActivityAttendMap by attendindex end");
        return rsObj;
    }

    public List<UserActivityAttendMapExtends> getUserActivityAttendMapByCond(UserActivityAttendMapExtends userActivityAttendMap)
            throws DomainServiceException
    {
        log.debug("get userActivityAttendMap by condition starting...");
        List<UserActivityAttendMapExtends> rsList = null;
        try
        {
            rsList = dao.getUserActivityAttendMapByCond(userActivityAttendMap);
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
        log.debug("get userActivityAttendMap by condition end");
        return rsList;
    }

    public List<UserActivityAttendMap> getUserActivityAttendMapByCondExact(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        log.debug("get userActivityAttendMap by exact condition starting...");
        List<UserActivityAttendMap> rsList = null;
        try
        {
            rsList = dao.getUserActivityAttendMapByCondExact(userActivityAttendMap);
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
        log.debug("get userActivityAttendMap by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userActivityAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userActivityAttendMap, start, pageSize);
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
        tableInfo.setData((List<UserActivityAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userActivityAttendMap page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userActivityAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userActivityAttendMap, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserActivityAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userActivityAttendMap page info by condition end");
        return tableInfo;
    }

}
