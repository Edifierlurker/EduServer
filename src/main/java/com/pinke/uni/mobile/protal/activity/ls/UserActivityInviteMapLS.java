package com.pinke.uni.mobile.protal.activity.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.service.IUserActivityInviteMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserActivityInviteMapLS implements IUserActivityInviteMapLS
{

    private Logger log = LoggerFactory.getLogger("UserActivityInviteMap", UserActivityInviteMapLS.class);

    private IUserActivityInviteMapDS userActivityInviteMapDS;

    public void setUserActivityInviteMapDS(IUserActivityInviteMapDS userActivityInviteMapDS)
    {
        this.userActivityInviteMapDS = userActivityInviteMapDS;
    }

    public String insertUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        // check param
        if (null == userActivityInviteMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userActivityInviteMapDS.insertUserActivityInviteMap(userActivityInviteMap);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userActivityInviteMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityInviteMapList);
        if (null == userActivityInviteMapList || userActivityInviteMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.insertUserActivityInviteMapList(userActivityInviteMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userActivityInviteMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityInviteMap == null || userActivityInviteMap.getInviteindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.updateUserActivityInviteMap(userActivityInviteMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityInviteMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }
    
    public String updateUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityInviteMap == null )
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.updateUserActivityInviteMapByCond(userActivityInviteMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityInviteMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityInviteMapList);
        if (null == userActivityInviteMapList || userActivityInviteMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.updateUserActivityInviteMapList(userActivityInviteMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityInviteMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityInviteMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.removeUserActivityInviteMap(userActivityInviteMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userActivityInviteMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityInviteMapList);
        if (userActivityInviteMapList == null || userActivityInviteMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityInviteMapDS.removeUserActivityInviteMapList(userActivityInviteMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userActivityInviteMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserActivityInviteMap getUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityInviteMap == null || userActivityInviteMap.getInviteindex() == null)
        {
            return null;
        }
        return userActivityInviteMapDS.getUserActivityInviteMap(userActivityInviteMap);
    }

    public UserActivityInviteMap getUserActivityInviteMapByIndex(Long inviteindex) throws DomainServiceException
    {
        // check param
        if (inviteindex == null)
        {
            return null;
        }
        return userActivityInviteMapDS.getUserActivityInviteMapByIndex(inviteindex);
    }

    public List<UserActivityInviteMap> getUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        return userActivityInviteMapDS.getUserActivityInviteMapByCond(userActivityInviteMap);
    }

    public List<UserActivityInviteMap> getUserActivityInviteMapByCondExact(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException
    {
        return userActivityInviteMapDS.getUserActivityInviteMapByCondExact(userActivityInviteMap);
    }

    public TableDataInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userActivityInviteMapDS.pageInfoQuery(userActivityInviteMap, start, pageSize, puEntity);
    }

}
