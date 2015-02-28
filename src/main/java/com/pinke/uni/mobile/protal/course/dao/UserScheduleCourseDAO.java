package com.pinke.uni.mobile.protal.course.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserScheduleCourseDAO extends DynamicObjectMispDAO implements IUserScheduleCourseDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("insert userScheduleCourse starting...");
        super.insert("insertUserScheduleCourse", userScheduleCourse);
        log.debug("insert userScheduleCourse end");
    }

    public void insertUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList) throws DAOException
    {
        log.debug("insert userScheduleCourseList starting...");
        if (null != userScheduleCourseList)
        {
            super.insertBatch("insertUserScheduleCourse", userScheduleCourseList);
        }
        log.debug("insert userScheduleCourseList end");
    }

    public void updateUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("update userScheduleCourse by pk starting...");
        super.update("updateUserScheduleCourse", userScheduleCourse);
        log.debug("update userScheduleCourse by pk end");
    }

    public void updateUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList) throws DAOException
    {
        log.debug("update userScheduleCourseList by pk starting...");
        super.updateBatch("updateUserScheduleCourse", userScheduleCourseList);
        log.debug("update userScheduleCourseList by pk end");
    }

    public void updateUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("update userScheduleCourse by conditions starting...");
        super.update("updateUserScheduleCourseByCond", userScheduleCourse);
        log.debug("update userScheduleCourse by conditions end");
    }

    public void deleteUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("delete userScheduleCourse by pk starting...");
        super.delete("deleteUserScheduleCourse", userScheduleCourse);
        log.debug("delete userScheduleCourse by pk end");
    }

    public void deleteUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList) throws DAOException
    {
        log.debug("delete userScheduleCourseList by pk starting...");
        super.deleteBatch("deleteUserScheduleCourse", userScheduleCourseList);
        log.debug("delete userScheduleCourseList by pk end");
    }

    public void deleteUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("delete userScheduleCourse by conditions starting...");
        super.delete("deleteUserScheduleCourseByCond", userScheduleCourse);
        log.debug("delete userScheduleCourse by conditions end");
    }

    public UserScheduleCourse getUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DAOException
    {
        log.debug("query userScheduleCourse starting...");
        UserScheduleCourse resultObj = (UserScheduleCourse) super.queryForObject("getUserScheduleCourse",
                userScheduleCourse);
        log.debug("query userScheduleCourse end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourse> getUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse)
            throws DAOException
    {
        log.debug("query userScheduleCourse by condition starting...");
        List<UserScheduleCourse> rList = (List<UserScheduleCourse>) super.queryForList(
                "queryUserScheduleCourseListByCond", userScheduleCourse);
        log.debug("query userScheduleCourse by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourse> getUserScheduleCourseByCondExact(UserScheduleCourse userScheduleCourse)
            throws DAOException
    {
        log.debug("query userScheduleCourse by exact condition starting...");
        List<UserScheduleCourse> rList = (List<UserScheduleCourse>) super.queryForList(
                "queryUserScheduleCourseListByCondExact", userScheduleCourse);
        log.debug("query userScheduleCourse by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserScheduleCourse> getUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userScheduleCourse by condition starting...");
        List<UserScheduleCourse> rList = (List<UserScheduleCourse>) super.queryForList(
                "queryUserScheduleCourseListByCond", userScheduleCourse, puEntity);
        log.debug("query userScheduleCourse by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize) throws DAOException
    {
        log.debug("page query userScheduleCourse by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleCourseListCntByCond", userScheduleCourse))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserScheduleCourse> rsList = (List<UserScheduleCourse>) super.pageQuery(
                    "queryUserScheduleCourseListByCond", userScheduleCourse, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userScheduleCourse by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleCourseListByCond", "queryUserScheduleCourseListCntByCond",
                userScheduleCourse, start, pageSize, puEntity);
    }

}