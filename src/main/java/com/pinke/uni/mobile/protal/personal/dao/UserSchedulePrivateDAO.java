package com.pinke.uni.mobile.protal.personal.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserSchedulePrivateDAO extends DynamicObjectMispDAO implements IUserSchedulePrivateDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("insert userSchedulePrivate starting...");
        super.insert("insertUserSchedulePrivate", userSchedulePrivate);
        log.debug("insert userSchedulePrivate end");
    }

    public void insertUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList) throws DAOException
    {
        log.debug("insert userSchedulePrivateList starting...");
        if (null != userSchedulePrivateList)
        {
            super.insertBatch("insertUserSchedulePrivate", userSchedulePrivateList);
        }
        log.debug("insert userSchedulePrivateList end");
    }

    public void updateUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("update userSchedulePrivate by pk starting...");
        super.update("updateUserSchedulePrivate", userSchedulePrivate);
        log.debug("update userSchedulePrivate by pk end");
    }

    public void updateUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList) throws DAOException
    {
        log.debug("update userSchedulePrivateList by pk starting...");
        super.updateBatch("updateUserSchedulePrivate", userSchedulePrivateList);
        log.debug("update userSchedulePrivateList by pk end");
    }

    public void updateUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("update userSchedulePrivate by conditions starting...");
        super.update("updateUserSchedulePrivateByCond", userSchedulePrivate);
        log.debug("update userSchedulePrivate by conditions end");
    }

    public void deleteUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("delete userSchedulePrivate by pk starting...");
        super.delete("deleteUserSchedulePrivate", userSchedulePrivate);
        log.debug("delete userSchedulePrivate by pk end");
    }

    public void deleteUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList) throws DAOException
    {
        log.debug("delete userSchedulePrivateList by pk starting...");
        super.deleteBatch("deleteUserSchedulePrivate", userSchedulePrivateList);
        log.debug("delete userSchedulePrivateList by pk end");
    }

    public void deleteUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("delete userSchedulePrivate by conditions starting...");
        super.delete("deleteUserSchedulePrivateByCond", userSchedulePrivate);
        log.debug("delete userSchedulePrivate by conditions end");
    }

    public UserSchedulePrivate getUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DAOException
    {
        log.debug("query userSchedulePrivate starting...");
        UserSchedulePrivate resultObj = (UserSchedulePrivate) super.queryForObject("getUserSchedulePrivate",
                userSchedulePrivate);
        log.debug("query userSchedulePrivate end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedulePrivate> getUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate)
            throws DAOException
    {
        log.debug("query userSchedulePrivate by condition starting...");
        List<UserSchedulePrivate> rList = (List<UserSchedulePrivate>) super.queryForList(
                "queryUserSchedulePrivateListByCond", userSchedulePrivate);
        log.debug("query userSchedulePrivate by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedulePrivate> getUserSchedulePrivateByCondExact(UserSchedulePrivate userSchedulePrivate)
            throws DAOException
    {
        log.debug("query userSchedulePrivate by exact condition starting...");
        List<UserSchedulePrivate> rList = (List<UserSchedulePrivate>) super.queryForList(
                "queryUserSchedulePrivateListByCondExact", userSchedulePrivate);
        log.debug("query userSchedulePrivate by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserSchedulePrivate> getUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate,
            PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userSchedulePrivate by condition starting...");
        List<UserSchedulePrivate> rList = (List<UserSchedulePrivate>) super.queryForList(
                "queryUserSchedulePrivateListByCond", userSchedulePrivate, puEntity);
        log.debug("query userSchedulePrivate by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize) throws DAOException
    {
        log.debug("page query userSchedulePrivate by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserSchedulePrivateListCntByCond", userSchedulePrivate))
                .intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserSchedulePrivate> rsList = (List<UserSchedulePrivate>) super.pageQuery(
                    "queryUserSchedulePrivateListByCond", userSchedulePrivate, start, fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userSchedulePrivate by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException
    {
        return super.indexPageQuery("queryUserSchedulePrivateListByCond", "queryUserSchedulePrivateListCntByCond",
                userSchedulePrivate, start, pageSize, puEntity);
    }

}