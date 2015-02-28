package com.pinke.uni.mobile.protal.schedule.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface IScheduleFS
{
    /**
     * 根据userindex查询用户某天的日程
     * 
     * @param userIndex
     * @param date
     * @return
     */
    public TableDataInfo getUserScheduleListByUserIndex(String userIndex, String date, int pageNum, int count);

    /**
     * 添加用户日程
     * 
     * @param userSchedule
     * @return
     */
    public boolean insertUserSchedule(UserSchedule userSchedule);

    /**
     * 删除用户日程
     * 
     * @param userSchedule
     * @return
     */
    public boolean delUserSchedule(UserSchedule userSchedule);

    /**
     * 根据userindex查询用户日程
     * 
     * @param userIndex
     * @param date
     * @return
     */
    public List getUserScheduleList(String userIndex, String date, String type);

}
