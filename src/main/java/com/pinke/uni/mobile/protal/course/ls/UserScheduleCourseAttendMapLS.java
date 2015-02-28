package com.pinke.uni.mobile.protal.course.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.pinke.uni.mobile.protal.course.service.IUserScheduleCourseAttendMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleCourseAttendMapLS implements IUserScheduleCourseAttendMapLS
{

    private Logger log = LoggerFactory.getLogger("UserScheduleCourseAttendMap", UserScheduleCourseAttendMapLS.class);

    private IUserScheduleCourseAttendMapDS userScheduleCourseAttendMapDS;

    public void setUserScheduleCourseAttendMapDS(IUserScheduleCourseAttendMapDS userScheduleCourseAttendMapDS)
    {
        this.userScheduleCourseAttendMapDS = userScheduleCourseAttendMapDS;
    }

    public String insertUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        // check param
        if (null == userScheduleCourseAttendMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userScheduleCourseAttendMapDS.insertUserScheduleCourseAttendMap(userScheduleCourseAttendMap);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleCourseAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserScheduleCourseAttendMapList(
            List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseAttendMapList);
        if (null == userScheduleCourseAttendMapList || userScheduleCourseAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.insertUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS
                + ":insert userScheduleCourseAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userScheduleCourseAttendMap == null || userScheduleCourseAttendMap.getCourseattendindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.updateUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleCourseAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }
    public String updateUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userScheduleCourseAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.updateUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleCourseAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleCourseAttendMapList(
            List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseAttendMapList);
        if (null == userScheduleCourseAttendMapList || userScheduleCourseAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.updateUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS
                + ":update userScheduleCourseAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userScheduleCourseAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.removeUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleCourseAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleCourseAttendMapList(
            List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseAttendMapList);
        if (userScheduleCourseAttendMapList == null || userScheduleCourseAttendMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseAttendMapDS.removeUserScheduleCourseAttendMapList(userScheduleCourseAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS
                + ":remove userScheduleCourseAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMap(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        // check param
        if (userScheduleCourseAttendMap == null || userScheduleCourseAttendMap.getCourseattendindex() == null)
        {
            return null;
        }
        return userScheduleCourseAttendMapDS.getUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
    }

    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMapByIndex(Long courseattendindex)
            throws DomainServiceException
    {
        // check param
        if (courseattendindex == null)
        {
            return null;
        }
        return userScheduleCourseAttendMapDS.getUserScheduleCourseAttendMapByIndex(courseattendindex);
    }

    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        return userScheduleCourseAttendMapDS.getUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
    }

    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCondExact(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DomainServiceException
    {
        return userScheduleCourseAttendMapDS.getUserScheduleCourseAttendMapByCondExact(userScheduleCourseAttendMap);
    }

    public TableDataInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleCourseAttendMapDS.pageInfoQuery(userScheduleCourseAttendMap, start, pageSize, puEntity);
    }

}
