package com.pinke.uni.mobile.protal.personal.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.pinke.uni.mobile.protal.personal.service.IUserSchedulePrivateDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserSchedulePrivateLS implements IUserSchedulePrivateLS
{

    private Logger log = LoggerFactory.getLogger("UserSchedulePrivate", UserSchedulePrivateLS.class);

    private IUserSchedulePrivateDS userSchedulePrivateDS;

    public void setUserSchedulePrivateDS(IUserSchedulePrivateDS userSchedulePrivateDS)
    {
        this.userSchedulePrivateDS = userSchedulePrivateDS;
    }

    public String insertUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        // check param
        if (null == userSchedulePrivate)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userSchedulePrivateDS.insertUserSchedulePrivate(userSchedulePrivate);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userSchedulePrivate success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userSchedulePrivateList);
        if (null == userSchedulePrivateList || userSchedulePrivateList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userSchedulePrivateDS.insertUserSchedulePrivateList(userSchedulePrivateList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userSchedulePrivateList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        // check param
        if (userSchedulePrivate == null || userSchedulePrivate.getPrivateindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userSchedulePrivateDS.updateUserSchedulePrivate(userSchedulePrivate);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userSchedulePrivate success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userSchedulePrivateList);
        if (null == userSchedulePrivateList || userSchedulePrivateList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userSchedulePrivateDS.updateUserSchedulePrivateList(userSchedulePrivateList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userSchedulePrivateList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate) throws DomainServiceException
    {
        // check param
        if (userSchedulePrivate == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userSchedulePrivateDS.removeUserSchedulePrivate(userSchedulePrivate);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userSchedulePrivate success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserSchedulePrivateList(List<UserSchedulePrivate> userSchedulePrivateList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userSchedulePrivateList);
        if (userSchedulePrivateList == null || userSchedulePrivateList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userSchedulePrivateDS.removeUserSchedulePrivateList(userSchedulePrivateList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userSchedulePrivateList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserSchedulePrivate getUserSchedulePrivate(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        // check param
        if (userSchedulePrivate == null || userSchedulePrivate.getPrivateindex() == null)
        {
            return null;
        }
        return userSchedulePrivateDS.getUserSchedulePrivate(userSchedulePrivate);
    }

    public UserSchedulePrivate getUserSchedulePrivateByIndex(Long privateindex) throws DomainServiceException
    {
        // check param
        if (privateindex == null)
        {
            return null;
        }
        return userSchedulePrivateDS.getUserSchedulePrivateByIndex(privateindex);
    }

    public List<UserSchedulePrivate> getUserSchedulePrivateByCond(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        return userSchedulePrivateDS.getUserSchedulePrivateByCond(userSchedulePrivate);
    }

    public List<UserSchedulePrivate> getUserSchedulePrivateByCondExact(UserSchedulePrivate userSchedulePrivate)
            throws DomainServiceException
    {
        return userSchedulePrivateDS.getUserSchedulePrivateByCondExact(userSchedulePrivate);
    }

    public TableDataInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userSchedulePrivateDS.pageInfoQuery(userSchedulePrivate, start, pageSize, puEntity);
    }

}
