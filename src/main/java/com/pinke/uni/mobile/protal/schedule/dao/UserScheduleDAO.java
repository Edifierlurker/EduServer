package com.pinke.uni.mobile.protal.schedule.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserScheduleDAO extends DynamicObjectMispDAO implements IUserScheduleDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserSchedule(UserSchedule userSchedule) throws DAOException
    {
        log.debug("insert userSchedule starting...");
        super.insert("insertUserSchedule", userSchedule);
        log.debug("insert userSchedule end");
    }

    public void insertUserScheduleList(List<UserSchedule> userScheduleList) throws DAOException
    {
        log.debug("insert userScheduleList starting...");
        if (null != userScheduleList)
        {
            super.insertBatch("insertUserSchedule", userScheduleList);
        }
        log.debug("insert userScheduleList end");
    }

    public void updateUserSchedule(UserSchedule userSchedule) throws DAOException
    {
        log.debug("update userSchedule by pk starting...");
        super.update("updateUserSchedule", userSchedule);
        log.debug("update userSchedule by pk end");
    }

    public void updateUserScheduleList(List<UserSchedule> userScheduleList) throws DAOException
    {
        log.debug("update userScheduleList by pk starting...");
        super.updateBatch("updateUserSchedule", userScheduleList);
        log.debug("update userScheduleList by pk end");
    }

    public void updateUserScheduleByCond(UserSchedule userSchedule) throws DAOException
    {
        log.debug("update userSchedule by conditions starting...");
        super.update("updateUserScheduleByCond", userSchedule);
        log.debug("update userSchedule by conditions end");
    }

    public void deleteUserSchedule(UserSchedule userSchedule) throws DAOException
    {
        log.debug("delete userSchedule by pk starting...");
        super.delete("deleteUserSchedule", userSchedule);
        log.debug("delete userSchedule by pk end");
    }

    public void deleteUserScheduleList(List<UserSchedule> userScheduleList) throws DAOException
    {
        log.debug("delete userScheduleList by pk starting...");
        super.deleteBatch("deleteUserSchedule", userScheduleList);
        log.debug("delete userScheduleList by pk end");
    }

    public void deleteUserScheduleByCond(UserSchedule userSchedule) throws DAOException
    {
        log.debug("delete userSchedule by conditions starting...");
        super.delete("deleteUserScheduleByCond", userSchedule);
        log.debug("delete userSchedule by conditions end");
    }

    public UserSchedule getUserSchedule(UserSchedule userSchedule) throws DAOException
    {
        log.debug("query userSchedule starting...");
        UserSchedule resultObj = (UserSchedule) super.queryForObject("getUserSchedule", userSchedule);
        log.debug("query userSchedule end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedule> getUserScheduleByCond(UserSchedule userSchedule) throws DAOException
    {
        log.debug("query userSchedule by condition starting...");
        List<UserSchedule> rList = (List<UserSchedule>) super.queryForList("queryUserScheduleListByCond", userSchedule);
        log.debug("query userSchedule by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedule> getUserScheduleByCondExact(UserSchedule userSchedule) throws DAOException
    {
        log.debug("query userSchedule by exact condition starting...");
        List<UserSchedule> rList = (List<UserSchedule>) super.queryForList("queryUserScheduleListByCondExact",
                userSchedule);
        log.debug("query userSchedule by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedule> getUserScheduleByCond(UserSchedule userSchedule, PageUtilEntity puEntity)
            throws DAOException
    {
        log.debug("query userSchedule by condition starting...");
        List<UserSchedule> rList = (List<UserSchedule>) super.queryForList("queryUserScheduleListByCond", userSchedule,
                puEntity);
        log.debug("query userSchedule by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize) throws DAOException
    {
        log.debug("page query userSchedule by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserScheduleListCntByCond", userSchedule)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserSchedule> rsList = (List<UserSchedule>) super.pageQuery("queryUserScheduleListByCond",
                    userSchedule, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userSchedule by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryUserScheduleListByCond", "queryUserScheduleListCntByCond", userSchedule,
                start, pageSize, puEntity);
    }

}