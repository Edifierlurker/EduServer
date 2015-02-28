package com.pinke.uni.mobile.protal.activity.ls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.service.IUserActivityAttendMapDS;
import com.pinke.uni.mobile.protal.activity.service.IUserActivityInviteMapDS;
import com.pinke.uni.mobile.protal.activity.service.IUserScheduleActivityDS;
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

public class UserActivityAttendMapLS implements IUserActivityAttendMapLS
{

    private Logger log = LoggerFactory.getLogger("UserActivityAttendMap", UserActivityAttendMapLS.class);

    private IUserActivityAttendMapDS userActivityAttendMapDS;
    private IUserScheduleActivityDS userScheduleActivityDS;
    private IUserScheduleDS userScheduleDS;
    private IUserActivityInviteMapDS userActivityInviteMapDS;

    public IUserScheduleDS getUserScheduleDS()
    {
        return userScheduleDS;
    }

    public void setUserScheduleDS(IUserScheduleDS userScheduleDS)
    {
        this.userScheduleDS = userScheduleDS;
    }

    public IUserActivityInviteMapDS getUserActivityInviteMapDS()
    {
        return userActivityInviteMapDS;
    }

    public void setUserActivityInviteMapDS(IUserActivityInviteMapDS userActivityInviteMapDS)
    {
        this.userActivityInviteMapDS = userActivityInviteMapDS;
    }

    public void setUserActivityAttendMapDS(IUserActivityAttendMapDS userActivityAttendMapDS)
    {
        this.userActivityAttendMapDS = userActivityAttendMapDS;
    }

    public IUserScheduleActivityDS getUserScheduleActivityDS()
    {
        return userScheduleActivityDS;
    }

    public void setUserScheduleActivityDS(IUserScheduleActivityDS userScheduleActivityDS)
    {
        this.userScheduleActivityDS = userScheduleActivityDS;
    }

    public String insertUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        // check param
        if (null == userActivityAttendMap || userActivityAttendMap.getActivityindex() == null
                || userActivityAttendMap.getStudentindex() == null)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        List<UserActivityAttendMap> list = this.getUserActivityAttendMapByCondExact(userActivityAttendMap);
        if (list != null && list.size() > 0)
        {
            UserActivityAttendMap temp = list.get(0);
            temp.setStatus(1);
            this.updateUserActivityAttendMap(temp);
        }
        else
        {
            userActivityAttendMapDS.insertUserActivityAttendMap(userActivityAttendMap);
        }

        if (userActivityAttendMap.getActivityindex() != null)
        {
            UserScheduleActivity userScheduleActivity = new UserScheduleActivity();

            userScheduleActivity = userScheduleActivityDS.getUserScheduleActivityByIndex(userActivityAttendMap
                    .getActivityindex());
            if (userScheduleActivity != null)
            {
                userScheduleActivityDS.updateUserScheduleActivity(userScheduleActivity);
                /**
                 * 新增日程
                 */

                try
                {
                    UserSchedule userSchedule = new UserSchedule();
                    userSchedule.setDetailindex(userScheduleActivity.getActivityindex());
                    userSchedule.setStudentindex(userActivityAttendMap.getStudentindex());
                    String starttime = userScheduleActivity.getStarttime();
                    String endtime = userScheduleActivity.getEndtime();
                    if (Tools.isNotNull(starttime))
                    {
                        userSchedule.setScheduledate(Tools.formatDate10(starttime));
                        userSchedule.setStarttime(starttime);
                    }
                    if (Tools.isNotNull(endtime))
                    {
                        userSchedule.setEndtime(endtime);
                    }

                    userSchedule.setScheduletype(1);
                    userSchedule.setCreatetime(Tools.formatDate7(new Date()));
                    userSchedule.setStatus(1);
                    userSchedule.setSchedulename(userScheduleActivity.getActivitytitle() + "");
                    userSchedule.setScheduletitle(userScheduleActivity.getActivitytitle() + "");
                    userScheduleDS.insertUserSchedule(userSchedule);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }

            /**
             * 如果是被邀请的，则修改邀请表
             */
            UserActivityInviteMap userActivityInviteMap = new UserActivityInviteMap();
            userActivityInviteMap.setActivityindex(userScheduleActivity.getActivityindex());
            userActivityInviteMap.setInviteindex(userActivityAttendMap.getAttendindex());
            userActivityInviteMap.setIsaccpet(0);
            List<UserActivityInviteMap> invitetempList = userActivityInviteMapDS
                    .getUserActivityInviteMapByCond(userActivityInviteMap);
            List<UserActivityInviteMap> inviteUpdateList = new ArrayList();
            if (invitetempList != null && invitetempList.size() > 0)
            {
                for (int j = 0; j < invitetempList.size(); j++)
                {
                    UserActivityInviteMap temp = new UserActivityInviteMap();
                    temp = invitetempList.get(j);
                    temp.setIsaccpet(1);
                    inviteUpdateList.add(temp);
                }
                userActivityInviteMapDS.updateUserActivityInviteMapList(inviteUpdateList);

            }

        }

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userActivityAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityAttendMapList);
        if (null == userActivityAttendMapList || userActivityAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.insertUserActivityAttendMapList(userActivityAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userActivityAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityAttendMap == null || userActivityAttendMap.getAttendindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.updateUserActivityAttendMap(userActivityAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.updateUserActivityAttendMapByCond(userActivityAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityAttendMapList);
        if (null == userActivityAttendMapList || userActivityAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.updateUserActivityAttendMapList(userActivityAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userActivityAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.removeUserActivityAttendMap(userActivityAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userActivityAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userActivityAttendMapList);
        if (userActivityAttendMapList == null || userActivityAttendMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userActivityAttendMapDS.removeUserActivityAttendMapList(userActivityAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userActivityAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserActivityAttendMap getUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        // check param
        if (userActivityAttendMap == null || userActivityAttendMap.getAttendindex() == null)
        {
            return null;
        }
        return userActivityAttendMapDS.getUserActivityAttendMap(userActivityAttendMap);
    }

    public UserActivityAttendMap getUserActivityAttendMapByIndex(Long attendindex) throws DomainServiceException
    {
        // check param
        if (attendindex == null)
        {
            return null;
        }
        return userActivityAttendMapDS.getUserActivityAttendMapByIndex(attendindex);
    }

    public List<UserActivityAttendMapExtends> getUserActivityAttendMapByCond(
            UserActivityAttendMapExtends userActivityAttendMap) throws DomainServiceException
    {
        return userActivityAttendMapDS.getUserActivityAttendMapByCond(userActivityAttendMap);
    }

    public List<UserActivityAttendMap> getUserActivityAttendMapByCondExact(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException
    {
        return userActivityAttendMapDS.getUserActivityAttendMapByCondExact(userActivityAttendMap);
    }

    public TableDataInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userActivityAttendMapDS.pageInfoQuery(userActivityAttendMap, start, pageSize, puEntity);
    }

}
