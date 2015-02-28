package com.pinke.uni.mobile.protal.exam.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.pinke.uni.mobile.protal.exam.service.IUserExaminfoAttendMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserExaminfoAttendMapLS implements IUserExaminfoAttendMapLS
{

    private Logger log = LoggerFactory.getLogger("UserExaminfoAttendMap", UserExaminfoAttendMapLS.class);

    private IUserExaminfoAttendMapDS userExaminfoAttendMapDS;

    public void setUserExaminfoAttendMapDS(IUserExaminfoAttendMapDS userExaminfoAttendMapDS)
    {
        this.userExaminfoAttendMapDS = userExaminfoAttendMapDS;
    }

    public String insertUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (null == userExaminfoAttendMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userExaminfoAttendMapDS.insertUserExaminfoAttendMap(userExaminfoAttendMap);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userExaminfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userExaminfoAttendMapList);
        if (null == userExaminfoAttendMapList || userExaminfoAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.insertUserExaminfoAttendMapList(userExaminfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userExaminfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userExaminfoAttendMap == null || userExaminfoAttendMap.getAttendindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.updateUserExaminfoAttendMap(userExaminfoAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userExaminfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }
    public String updateUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userExaminfoAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.updateUserExaminfoAttendMapByCond(userExaminfoAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userExaminfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userExaminfoAttendMapList);
        if (null == userExaminfoAttendMapList || userExaminfoAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.updateUserExaminfoAttendMapList(userExaminfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userExaminfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userExaminfoAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.removeUserExaminfoAttendMap(userExaminfoAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userExaminfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userExaminfoAttendMapList);
        if (userExaminfoAttendMapList == null || userExaminfoAttendMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userExaminfoAttendMapDS.removeUserExaminfoAttendMapList(userExaminfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userExaminfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserExaminfoAttendMap getUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userExaminfoAttendMap == null || userExaminfoAttendMap.getAttendindex() == null)
        {
            return null;
        }
        return userExaminfoAttendMapDS.getUserExaminfoAttendMap(userExaminfoAttendMap);
    }

    public UserExaminfoAttendMap getUserExaminfoAttendMapByIndex(Long attendindex) throws DomainServiceException
    {
        // check param
        if (attendindex == null)
        {
            return null;
        }
        return userExaminfoAttendMapDS.getUserExaminfoAttendMapByIndex(attendindex);
    }

    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        return userExaminfoAttendMapDS.getUserExaminfoAttendMapByCond(userExaminfoAttendMap);
    }

    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCondExact(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException
    {
        return userExaminfoAttendMapDS.getUserExaminfoAttendMapByCondExact(userExaminfoAttendMap);
    }

    public TableDataInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userExaminfoAttendMapDS.pageInfoQuery(userExaminfoAttendMap, start, pageSize, puEntity);
    }

}
