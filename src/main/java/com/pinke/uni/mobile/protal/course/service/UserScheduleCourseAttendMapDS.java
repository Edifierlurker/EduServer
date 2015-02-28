package com.pinke.uni.mobile.protal.course.service;

import java.util.List;

import com.pinke.uni.mobile.protal.course.dao.IUserScheduleCourseAttendMapDAO;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleCourseAttendMapDS extends DynamicObjectBaseDS implements IUserScheduleCourseAttendMapDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserScheduleCourseAttendMapDAO dao = null;

    public void setDao(IUserScheduleCourseAttendMapDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        log.debug("insert userScheduleCourseAttendMap starting...");
        try
        {
//            if (null == userScheduleCourseAttendMap.getCourseattendindex())
//            {
//                userScheduleCourseAttendMap.setCourseattendindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "user_schedule_course_attend_map"));
//            }
            dao.insertUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleCourseAttendMap end");
    }

    public void insertUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DomainServiceException
    {
        log.debug("insert userScheduleCourseAttendMapList by pk starting...");
        if (null == userScheduleCourseAttendMapList || userScheduleCourseAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseAttendMapList");
            return;
        }
        try
        {
            int listSize = userScheduleCourseAttendMapList.size();
            Long index = (Long) Sequence.getSequence("user_schedule_course_attend_map", listSize);
            for (int i = 0; i < userScheduleCourseAttendMapList.size(); i++)
            {
                if (userScheduleCourseAttendMapList.get(i) != null)
                {
                    if (null == userScheduleCourseAttendMapList.get(i).getCourseattendindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userScheduleCourseAttendMapList.get(i).setCourseattendindex(primaryindex);
                    }
                }
            }
            dao.insertUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleCourseAttendMapList by pk end");
    }

    public void updateUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        log.debug("update userScheduleCourseAttendMap by pk starting...");
        try
        {
            dao.updateUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourseAttendMap by pk end");
    }

    public void updateUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DomainServiceException
    {
        log.debug("update userScheduleCourseAttendMapList by pk starting...");
        if (null == userScheduleCourseAttendMapList || userScheduleCourseAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseAttendMapList");
            return;
        }
        try
        {
            dao.updateUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourseAttendMapList by pk end");
    }

    public void updateUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        log.debug("update userScheduleCourseAttendMap by condition starting...");
        try
        {
            dao.updateUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourseAttendMap by condition end");
    }

    public void removeUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        log.debug("remove userScheduleCourseAttendMap by pk starting...");
        try
        {
            dao.deleteUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourseAttendMap by pk end");
    }

    public void removeUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DomainServiceException
    {
        log.debug("remove userScheduleCourseAttendMapList by pk starting...");
        if (null == userScheduleCourseAttendMapList || userScheduleCourseAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseAttendMapList");
            return;
        }
        try
        {
            dao.deleteUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourseAttendMapList by pk end");
    }

    public void removeUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        log.debug("remove userScheduleCourseAttendMap by condition starting...");
        try
        {
            dao.deleteUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourseAttendMap by condition end");
    }

    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMap(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap by pk starting...");
        UserScheduleCourseAttendMap rsObj = null;
        try
        {
            rsObj = dao.getUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleCourseAttendMapList by pk end");
        return rsObj;
    }

    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMapByIndex(Long courseattendindex)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap by courseattendindex starting...");
        UserScheduleCourseAttendMap rsObj = new UserScheduleCourseAttendMap();
        rsObj.setCourseattendindex(courseattendindex);
        try
        {
            rsObj = dao.getUserScheduleCourseAttendMap(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleCourseAttendMap by courseattendindex end");
        return rsObj;
    }

    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap by condition starting...");
        List<UserScheduleCourseAttendMap> rsList = null;
        try
        {
            rsList = dao.getUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
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
        log.debug("get userScheduleCourseAttendMap by condition end");
        return rsList;
    }

    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCondExact(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap by exact condition starting...");
        List<UserScheduleCourseAttendMap> rsList = null;
        try
        {
            rsList = dao.getUserScheduleCourseAttendMapByCondExact(userScheduleCourseAttendMap);
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
        log.debug("get userScheduleCourseAttendMap by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleCourseAttendMap, start, pageSize);
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
        tableInfo.setData((List<UserScheduleCourseAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleCourseAttendMap page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleCourseAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleCourseAttendMap, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleCourseAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleCourseAttendMap page info by condition end");
        return tableInfo;
    }

}
