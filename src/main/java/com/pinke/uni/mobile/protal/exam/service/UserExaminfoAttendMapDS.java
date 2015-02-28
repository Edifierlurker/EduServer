package com.pinke.uni.mobile.protal.exam.service;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.dao.IUserExaminfoAttendMapDAO;
import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserExaminfoAttendMapDS extends DynamicObjectBaseDS implements IUserExaminfoAttendMapDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserExaminfoAttendMapDAO dao = null;

    public void setDao(IUserExaminfoAttendMapDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DomainServiceException
    {
        log.debug("insert userExaminfoAttendMap starting...");
        try
        {
            if (null == userExaminfoAttendMap.getAttendindex())
            {
                userExaminfoAttendMap.setAttendindex((Long) this.getPrimaryKeyGenerator().getPrimarykey(
                        "user_examinfo_attend_map"));
            }
            dao.insertUserExaminfoAttendMap(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userExaminfoAttendMap end");
    }

    public void insertUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        log.debug("insert userExaminfoAttendMapList by pk starting...");
        if (null == userExaminfoAttendMapList || userExaminfoAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userExaminfoAttendMapList");
            return;
        }
        try
        {
            int listSize = userExaminfoAttendMapList.size();
            Long index = (Long) Sequence.getSequence("user_examinfo_attend_map", listSize);
            for (int i = 0; i < userExaminfoAttendMapList.size(); i++)
            {
                if (userExaminfoAttendMapList.get(i) != null)
                {
                    if (null == userExaminfoAttendMapList.get(i).getAttendindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userExaminfoAttendMapList.get(i).setAttendindex(primaryindex);
                    }
                }
            }
            dao.insertUserExaminfoAttendMapList(userExaminfoAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userExaminfoAttendMapList by pk end");
    }

    public void updateUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DomainServiceException
    {
        log.debug("update userExaminfoAttendMap by pk starting...");
        try
        {
            dao.updateUserExaminfoAttendMap(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userExaminfoAttendMap by pk end");
    }

    public void updateUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        log.debug("update userExaminfoAttendMapList by pk starting...");
        if (null == userExaminfoAttendMapList || userExaminfoAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userExaminfoAttendMapList");
            return;
        }
        try
        {
            dao.updateUserExaminfoAttendMapList(userExaminfoAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userExaminfoAttendMapList by pk end");
    }

    public void updateUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        log.debug("update userExaminfoAttendMap by condition starting...");
        try
        {
            dao.updateUserExaminfoAttendMapByCond(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userExaminfoAttendMap by condition end");
    }

    public void removeUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap) throws DomainServiceException
    {
        log.debug("remove userExaminfoAttendMap by pk starting...");
        try
        {
            dao.deleteUserExaminfoAttendMap(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userExaminfoAttendMap by pk end");
    }

    public void removeUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        log.debug("remove userExaminfoAttendMapList by pk starting...");
        if (null == userExaminfoAttendMapList || userExaminfoAttendMapList.size() == 0)
        {
            log.debug("there is no datas in userExaminfoAttendMapList");
            return;
        }
        try
        {
            dao.deleteUserExaminfoAttendMapList(userExaminfoAttendMapList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userExaminfoAttendMapList by pk end");
    }

    public void removeUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        log.debug("remove userExaminfoAttendMap by condition starting...");
        try
        {
            dao.deleteUserExaminfoAttendMapByCond(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userExaminfoAttendMap by condition end");
    }

    public UserExaminfoAttendMap getUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap by pk starting...");
        UserExaminfoAttendMap rsObj = null;
        try
        {
            rsObj = dao.getUserExaminfoAttendMap(userExaminfoAttendMap);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userExaminfoAttendMapList by pk end");
        return rsObj;
    }

    public UserExaminfoAttendMap getUserExaminfoAttendMapByIndex(Long attendindex) throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap by attendindex starting...");
        UserExaminfoAttendMap rsObj = new UserExaminfoAttendMap();
        rsObj.setAttendindex(attendindex);
        try
        {
            rsObj = dao.getUserExaminfoAttendMap(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userExaminfoAttendMap by attendindex end");
        return rsObj;
    }

    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap by condition starting...");
        List<UserExaminfoAttendMap> rsList = null;
        try
        {
            rsList = dao.getUserExaminfoAttendMapByCond(userExaminfoAttendMap);
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
        log.debug("get userExaminfoAttendMap by condition end");
        return rsList;
    }

    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCondExact(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap by exact condition starting...");
        List<UserExaminfoAttendMap> rsList = null;
        try
        {
            rsList = dao.getUserExaminfoAttendMapByCondExact(userExaminfoAttendMap);
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
        log.debug("get userExaminfoAttendMap by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize)
            throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userExaminfoAttendMap, start, pageSize);
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
        tableInfo.setData((List<UserExaminfoAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userExaminfoAttendMap page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        log.debug("get userExaminfoAttendMap page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userExaminfoAttendMap, start, pageSize, puEntity);
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
        tableInfo.setData((List<UserExaminfoAttendMap>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userExaminfoAttendMap page info by condition end");
        return tableInfo;
    }

}
