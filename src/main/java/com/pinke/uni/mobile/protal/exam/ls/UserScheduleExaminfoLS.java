package com.pinke.uni.mobile.protal.exam.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.pinke.uni.mobile.protal.exam.service.IUserScheduleExaminfoDS;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.pinke.uni.mobile.protal.schedule.service.IUserScheduleDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleExaminfoLS implements IUserScheduleExaminfoLS
{

    private Logger log = LoggerFactory.getLogger("UserScheduleExaminfo", UserScheduleExaminfoLS.class);

    private IUserScheduleExaminfoDS userScheduleExaminfoDS;
    private IUserScheduleDS userScheduleDS;

    public void setUserScheduleExaminfoDS(IUserScheduleExaminfoDS userScheduleExaminfoDS)
    {
        this.userScheduleExaminfoDS = userScheduleExaminfoDS;
    }

    public IUserScheduleDS getUserScheduleDS()
    {
        return userScheduleDS;
    }

    public void setUserScheduleDS(IUserScheduleDS userScheduleDS)
    {
        this.userScheduleDS = userScheduleDS;
    }

    public String insertUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        // check param
        if (null == userScheduleExaminfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userScheduleExaminfoDS.insertUserScheduleExaminfo(userScheduleExaminfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleExaminfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleExaminfoList);
        if (null == userScheduleExaminfoList || userScheduleExaminfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleExaminfoDS.insertUserScheduleExaminfoList(userScheduleExaminfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleExaminfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        // check param
        if (userScheduleExaminfo == null || userScheduleExaminfo.getExamindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleExaminfoDS.updateUserScheduleExaminfo(userScheduleExaminfo);
        if (userScheduleExaminfo.getExamindex() != null && userScheduleExaminfo.getStudentindex() != null)
        {
            if (Tools.isNotNull(userScheduleExaminfo.getExamname())
                    || Tools.isNotNull(userScheduleExaminfo.getExamdate())
                    || Tools.isNotNull(userScheduleExaminfo.getExamstarttime())
                    || Tools.isNotNull(userScheduleExaminfo.getExamendtime()))
            {

            }
            UserSchedule userSchedule = new UserSchedule();
            userSchedule.setDetailindex(userScheduleExaminfo.getExamindex());
            userSchedule.setStudentindex(userScheduleExaminfo.getStudentindex());
            userSchedule.setScheduletype(2);
            List<UserSchedule> list = userScheduleDS.getUserScheduleByCond(userSchedule);
            if (list != null && list.size() > 0)
            {
                UserSchedule temp = list.get(0);
                if (Tools.isNotNull(userScheduleExaminfo.getExamname()))
                {
                    temp.setSchedulename(userScheduleExaminfo.getExamname());
                    temp.setScheduletitle(userScheduleExaminfo.getExamname());
                }
                if (Tools.isNotNull(userScheduleExaminfo.getExamdate()))
                {
                    temp.setScheduledate(userScheduleExaminfo.getExamdate());
                }
                if (Tools.isNotNull(userScheduleExaminfo.getExamstarttime()))
                {
                    temp.setStarttime(userScheduleExaminfo.getExamstarttime());
                }

                if (Tools.isNotNull(userScheduleExaminfo.getExamendtime()))
                {
                    temp.setEndtime(userScheduleExaminfo.getExamendtime());
                }

                userScheduleDS.updateUserSchedule(temp);
            }

        }
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleExaminfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleExaminfoList);
        if (null == userScheduleExaminfoList || userScheduleExaminfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleExaminfoDS.updateUserScheduleExaminfoList(userScheduleExaminfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleExaminfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException
    {
        // check param
        if (userScheduleExaminfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleExaminfoDS.removeUserScheduleExaminfo(userScheduleExaminfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleExaminfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleExaminfoList);
        if (userScheduleExaminfoList == null || userScheduleExaminfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleExaminfoDS.removeUserScheduleExaminfoList(userScheduleExaminfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleExaminfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserScheduleExaminfo getUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        // check param
        if (userScheduleExaminfo == null || userScheduleExaminfo.getExamindex() == null)
        {
            return null;
        }
        return userScheduleExaminfoDS.getUserScheduleExaminfo(userScheduleExaminfo);
    }

    public UserScheduleExaminfo getUserScheduleExaminfoByIndex(Long examindex) throws DomainServiceException
    {
        // check param
        if (examindex == null)
        {
            return null;
        }
        return userScheduleExaminfoDS.getUserScheduleExaminfoByIndex(examindex);
    }

    public UserScheduleExaminfoExtends getUserScheduleExaminfoByIndexExtends(Long examindex)
            throws DomainServiceException
    {
        // check param
        if (examindex == null)
        {
            return null;
        }
        return userScheduleExaminfoDS.getUserScheduleExaminfoByIndexExtends(examindex);
    }

    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        return userScheduleExaminfoDS.getUserScheduleExaminfoByCond(userScheduleExaminfo);
    }

    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCondExact(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException
    {
        return userScheduleExaminfoDS.getUserScheduleExaminfoByCondExact(userScheduleExaminfo);
    }

    public TableDataInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleExaminfoDS.pageInfoQuery(userScheduleExaminfo, start, pageSize, puEntity);
    }

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtends(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException
    {
        return userScheduleExaminfoDS.getUserScheduleExaminfoByCondExtends(userScheduleExaminfo);
    }

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtendsMore(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException
    {
        return userScheduleExaminfoDS.getUserScheduleExaminfoByCondExtendsMore(userScheduleExaminfo);
    }

    public TableDataInfo pageInfoQueryExtends(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleExaminfoDS.pageInfoQueryExtends(userScheduleExaminfo, start, pageSize, puEntity);
    }

    public TableDataInfo pageInfoQueryExtendsMore(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleExaminfoDS.pageInfoQueryExtendsMore(userScheduleExaminfo, start, pageSize, puEntity);
    }

}
