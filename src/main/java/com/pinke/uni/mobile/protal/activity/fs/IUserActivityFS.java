package com.pinke.uni.mobile.protal.activity.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface IUserActivityFS
{
    /**
     * 根据活动index和用户index查询用户是否参与活动
     * 
     * @param detailIndex
     * @return
     */
    public UserActivityInviteMap getInviteByIndex(Long detailIndex, Long userIndex);

    /**
     * 根据活动index查询活动详情
     * 
     * @param detailIndex
     * @return
     */
    public UserScheduleActivity getUserActivityDetailByIndex(Long detailIndex);

    /**
     * 根据活动index获取参与者列表(包含头像等其他信息)
     * 
     * @param detailIndex
     * @return
     */
    public List getAttendListByIndex(Long detailIndex);

    /**
     * 新增活动
     * 
     * @param userScheduleActivity
     * @return
     */
    public boolean insertUserActivity(UserScheduleActivity userScheduleActivity);

    /**
     * 插入参与者信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean insertUserActivityAttend(UserActivityAttendMap userActivityAttendMap);

    /**
     * 插入邀请者信息（多条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean insertUserActivityInviteList(List<UserActivityInviteMap> userActivityInviteMapList);

    /**
     * 更新参与者信息
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityAttend(UserActivityAttendMap userActivityAttendMap);

    /**
     * 更新邀请者信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityInvite(UserActivityInviteMap userActivityInviteMap);

    /**
     * 根据全属性查询活动详情
     * 
     * @param detailIndex
     * @return
     */
    public UserScheduleActivity getUserActivityDetail(UserScheduleActivity userScheduleActivity);

    /**
     * 更新活动信息（单条）
     * 
     * @param userActivityAttendMap
     * @return
     */
    public boolean updateUserActivityDetail(UserScheduleActivity userScheduleActivity);

    /**
     * 查询活动列表
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserActivityList(UserScheduleActivity userScheduleActivity, int page, int count);

    /**
     * 查询某用户参与的活动列表
     * 
     * @param userScheduleActivity
     * @return
     */
    public List getUserAttendActivityList(UserActivityAttendMapExtends userActivityAttendMap);

    /**
     * 查询某用户参与的活动列表及列表详情
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserAttendActivityListDetail(UserScheduleActivityExtends userScheduleActivity, int page,
            int count);

    /**
     * 查询附近的活动列表(分页查询)
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo getUserNearActivityList(UserScheduleActivity userScheduleActivity, int page, int count);
    /**
     * 查询用户被邀请参与活动列表
     * 
     * @param detailIndex
     * @return
     */
    public TableDataInfo getInviteList(Long userIndex,int page,int count);
    
    /**
     * 搜索活动列表(分页查询)
     * 
     * @param userScheduleActivity
     * @return
     */
    public TableDataInfo searchUserActivityList(String keyword, int page, int count);
}
