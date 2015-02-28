package com.pinke.uni.mobile.protal.course.service;

import java.util.List;

import com.pinke.uni.mobile.protal.course.dao.IUserScheduleCourseDAO;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleCourseDS extends DynamicObjectBaseDS implements IUserScheduleCourseDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserScheduleCourseDAO dao = null;

    public void setDao(IUserScheduleCourseDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        log.debug("insert userScheduleCourse starting...");
        try
        {
//            if (null == userScheduleCourse.getCourseindex())
//            {
//                userScheduleCourse.setCourseindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
//                        "user_schedule_course"));
//            }
            dao.insertUserScheduleCourse(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleCourse end");
    }

    public void insertUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        log.debug("insert userScheduleCourseList by pk starting...");
        if (null == userScheduleCourseList || userScheduleCourseList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseList");
            return;
        }
        try
        {
            int listSize = userScheduleCourseList.size();
            Long index = (Long) Sequence.getSequence("user_schedule_course", listSize);
            for (int i = 0; i < userScheduleCourseList.size(); i++)
            {
                if (userScheduleCourseList.get(i) != null)
                {
                    if (null == userScheduleCourseList.get(i).getCourseindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userScheduleCourseList.get(i).setCourseindex(primaryindex);
                    }
                }
            }
            dao.insertUserScheduleCourseList(userScheduleCourseList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userScheduleCourseList by pk end");
    }

    public void updateUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        log.debug("update userScheduleCourse by pk starting...");
        try
        {
            dao.updateUserScheduleCourse(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourse by pk end");
    }

    public void updateUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        log.debug("update userScheduleCourseList by pk starting...");
        if (null == userScheduleCourseList || userScheduleCourseList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseList");
            return;
        }
        try
        {
            dao.updateUserScheduleCourseList(userScheduleCourseList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourseList by pk end");
    }

    public void updateUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        log.debug("update userScheduleCourse by condition starting...");
        try
        {
            dao.updateUserScheduleCourseByCond(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userScheduleCourse by condition end");
    }

    public void removeUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        log.debug("remove userScheduleCourse by pk starting...");
        try
        {
            dao.deleteUserScheduleCourse(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourse by pk end");
    }

    public void removeUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        log.debug("remove userScheduleCourseList by pk starting...");
        if (null == userScheduleCourseList || userScheduleCourseList.size() == 0)
        {
            log.debug("there is no datas in userScheduleCourseList");
            return;
        }
        try
        {
            dao.deleteUserScheduleCourseList(userScheduleCourseList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourseList by pk end");
    }

    public void removeUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        log.debug("remove userScheduleCourse by condition starting...");
        try
        {
            dao.deleteUserScheduleCourseByCond(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userScheduleCourse by condition end");
    }

    public UserScheduleCourse getUserScheduleCourse(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourse by pk starting...");
        UserScheduleCourse rsObj = null;
        try
        {
            rsObj = dao.getUserScheduleCourse(userScheduleCourse);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleCourseList by pk end");
        return rsObj;
    }

    public UserScheduleCourse getUserScheduleCourseByIndex(Long courseindex) throws DomainServiceException
    {
        log.debug("get userScheduleCourse by courseindex starting...");
        UserScheduleCourse rsObj = new UserScheduleCourse();
        rsObj.setCourseindex(courseindex);
        try
        {
            rsObj = dao.getUserScheduleCourse(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userScheduleCourse by courseindex end");
        return rsObj;
    }

    public List<UserScheduleCourse> getUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourse by condition starting...");
        List<UserScheduleCourse> rsList = null;
        try
        {
            rsList = dao.getUserScheduleCourseByCond(userScheduleCourse);
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
        log.debug("get userScheduleCourse by condition end");
        return rsList;
    }

    public List<UserScheduleCourse> getUserScheduleCourseByCondExact(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourse by exact condition starting...");
        List<UserScheduleCourse> rsList = null;
        try
        {
            rsList = dao.getUserScheduleCourseByCondExact(userScheduleCourse);
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
        log.debug("get userScheduleCourse by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userScheduleCourse page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleCourse, start, pageSize);
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
        tableInfo.setData((List<UserScheduleCourse>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleCourse page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userScheduleCourse page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userScheduleCourse, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserScheduleCourse>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userScheduleCourse page info by condition end");
        return tableInfo;
    }

}
