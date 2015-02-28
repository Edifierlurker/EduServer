package com.pinke.uni.mobile.protal.activity.ls;

import java.util.ArrayList;
import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
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

public class UserScheduleActivityLS implements IUserScheduleActivityLS
{

    private Logger log = LoggerFactory.getLogger("UserScheduleActivity", UserScheduleActivityLS.class);

    private IUserScheduleActivityDS userScheduleActivityDS;
    private IUserScheduleDS userScheduleDS;

    public void setUserScheduleActivityDS(IUserScheduleActivityDS userScheduleActivityDS)
    {
        this.userScheduleActivityDS = userScheduleActivityDS;
    }

    public IUserScheduleDS getUserScheduleDS()
    {
        return userScheduleDS;
    }

    public void setUserScheduleDS(IUserScheduleDS userScheduleDS)
    {
        this.userScheduleDS = userScheduleDS;
    }

    public String insertUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        // check param
        if (null == userScheduleActivity)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userScheduleActivityDS.insertUserScheduleActivity(userScheduleActivity);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleActivity success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleActivityList);
        if (null == userScheduleActivityList || userScheduleActivityList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleActivityDS.insertUserScheduleActivityList(userScheduleActivityList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleActivityList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        // check param
        if (userScheduleActivity == null || userScheduleActivity.getActivityindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleActivityDS.updateUserScheduleActivity(userScheduleActivity);
        /**
         * 更新所有参与此活动的用户的日程
         */
        if (userScheduleActivity.getActivityindex() != null )

        {
            if (Tools.isNotNull(userScheduleActivity.getActivitytitle())
                    || Tools.isNotNull(userScheduleActivity.getStarttime())
                    || Tools.isNotNull(userScheduleActivity.getEndtime()))
            {
                UserSchedule userSchedule = new UserSchedule();
                userSchedule.setDetailindex(userScheduleActivity.getActivityindex());
                // userSchedule.setStudentindex(userScheduleActivity.getOriginatorindex());
                userSchedule.setScheduletype(1);
                List<UserSchedule> list = userScheduleDS.getUserScheduleByCond(userSchedule);
                List<UserSchedule> updateList = new ArrayList();
                if (list != null && list.size() > 0)
                {
                    for (int i = 0; i < list.size(); i++)
                    {
                        UserSchedule temp = list.get(i);
                        if (Tools.isNotNull(userScheduleActivity.getActivitytitle()))
                        {
                            temp.setSchedulename(userScheduleActivity.getActivitytitle());
                            temp.setScheduletitle(userScheduleActivity.getActivitytitle());
                        }
                        if (Tools.isNotNull(userScheduleActivity.getStarttime()))
                        {
                            temp.setScheduledate(Tools.formatDate10(userScheduleActivity.getStarttime()));
                            temp.setStarttime(userScheduleActivity.getStarttime());
                        }
                        if (Tools.isNotNull(userScheduleActivity.getEndtime()))
                        {
                            temp.setEndtime(userScheduleActivity.getEndtime());
                        }
                        updateList.add(temp);
                    }

                    userScheduleDS.updateUserScheduleList(updateList);
                }
            }

        }

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleActivity success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleActivityList);
        if (null == userScheduleActivityList || userScheduleActivityList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleActivityDS.updateUserScheduleActivityList(userScheduleActivityList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleActivityList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException
    {
        // check param
        if (userScheduleActivity == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleActivityDS.removeUserScheduleActivity(userScheduleActivity);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleActivity success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleActivityList);
        if (userScheduleActivityList == null || userScheduleActivityList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleActivityDS.removeUserScheduleActivityList(userScheduleActivityList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleActivityList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserScheduleActivity getUserScheduleActivity(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        // check param
        if (userScheduleActivity == null || userScheduleActivity.getActivityindex() == null)
        {
            return null;
        }
        return userScheduleActivityDS.getUserScheduleActivity(userScheduleActivity);
    }

    public UserScheduleActivityExtends getUserScheduleActivityExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DomainServiceException
    {
        // check param
        if (userScheduleActivity == null || userScheduleActivity.getActivityindex() == null)
        {
            return null;
        }
        return userScheduleActivityDS.getUserScheduleActivityExtends(userScheduleActivity);
    }

    public UserScheduleActivity getUserScheduleActivityByIndex(Long activityindex) throws DomainServiceException
    {
        // check param
        if (activityindex == null)
        {
            return null;
        }
        return userScheduleActivityDS.getUserScheduleActivityByIndex(activityindex);
    }

    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        return userScheduleActivityDS.getUserScheduleActivityByCond(userScheduleActivity);
    }

    public List<UserScheduleActivity> getUserScheduleActivityByCondExact(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException
    {
        return userScheduleActivityDS.getUserScheduleActivityByCondExact(userScheduleActivity);
    }

    public TableDataInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleActivityDS.pageInfoQuery(userScheduleActivity, start, pageSize, puEntity);
    }

    public List<UserScheduleActivity> getUserScheduleActivityByCondExtends(
            UserScheduleActivityExtends userScheduleActivity) throws DomainServiceException
    {
        return userScheduleActivityDS.getUserScheduleActivityByCondExtends(userScheduleActivity);
    }

    public TableDataInfo pageInfoQueryExtends(UserScheduleActivityExtends userScheduleActivity, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleActivityDS.pageInfoQueryExtends(userScheduleActivity, start, pageSize, puEntity);
    }

}
