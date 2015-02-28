package com.pinke.uni.mobile.protal.schedule.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.schedule.service.IUserScheduleDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleLS implements IUserScheduleLS
{

    private Logger log = LoggerFactory.getLogger("UserSchedule", UserScheduleLS.class);

    private IUserScheduleDS userScheduleDS;

    public void setUserScheduleDS(IUserScheduleDS userScheduleDS)
    {
        this.userScheduleDS = userScheduleDS;
    }

    public String insertUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        // check param
        if (null == userSchedule)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userScheduleDS.insertUserSchedule(userSchedule);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userSchedule success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleList);
        if (null == userScheduleList || userScheduleList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleDS.insertUserScheduleList(userScheduleList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        // check param
        if (userSchedule == null || userSchedule.getScheduleindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleDS.updateUserSchedule(userSchedule);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userSchedule success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleList);
        if (null == userScheduleList || userScheduleList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleDS.updateUserScheduleList(userScheduleList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        // check param
        if (userSchedule == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleDS.removeUserSchedule(userSchedule);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userSchedule success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleList(List<UserSchedule> userScheduleList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleList);
        if (userScheduleList == null || userScheduleList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleDS.removeUserScheduleList(userScheduleList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserSchedule getUserSchedule(UserSchedule userSchedule) throws DomainServiceException
    {
        // check param
        if (userSchedule == null || userSchedule.getScheduleindex() == null)
        {
            return null;
        }
        return userScheduleDS.getUserSchedule(userSchedule);
    }

    public UserSchedule getUserScheduleByIndex(Long scheduleindex) throws DomainServiceException
    {
        // check param
        if (scheduleindex == null)
        {
            return null;
        }
        return userScheduleDS.getUserScheduleByIndex(scheduleindex);
    }

    public List<UserSchedule> getUserScheduleByCond(UserSchedule userSchedule) throws DomainServiceException
    {
        return userScheduleDS.getUserScheduleByCond(userSchedule);
    }

    public List<UserSchedule> getUserScheduleByCondExact(UserSchedule userSchedule) throws DomainServiceException
    {
        return userScheduleDS.getUserScheduleByCondExact(userSchedule);
    }

    public TableDataInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return userScheduleDS.pageInfoQuery(userSchedule, start, pageSize, puEntity);
    }

}
