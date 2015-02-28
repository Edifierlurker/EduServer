package com.pinke.uni.mobile.protal.exam.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface IExamInfoFS
{
    /**
     * 查询考试列表
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public TableDataInfo getExamList(UserScheduleExaminfo userScheduleExaminfo, int page, int count);

    /**
     * 查询考试列表(不分页)
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public List getExamList(UserScheduleExaminfo userScheduleExaminfo);

    /**
     * 查询用户已参加的考试列表
     */
    public TableDataInfo getUserAttendExamListByUserindex(UserScheduleExaminfoExtends userScheduleExaminfo, int page,
            int count);

    /**
     * 根据index查询详情
     * 
     * @param examindex
     * @return
     */

    public UserScheduleExaminfoExtends getUserScheduleExaminfoExtendsByIndex(Long examindex);

    /**
     * 新增考试
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean insertUserScheduleExamInfo(UserScheduleExaminfo userScheduleExaminfo);

    /**
     * 更新考试
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserScheduleExamInfo(UserScheduleExaminfo userScheduleExaminfo);

    /**
     * 新增考试参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean insertIntoExam(UserExaminfoAttendMap userExaminfoAttendMap);

    /**
     * 更新考试参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateIntoExam(UserExaminfoAttendMap userExaminfoAttendMap);

    /**
     * 根据index查询详情
     * 
     * @param examindex
     * @return
     */

    public UserScheduleExaminfo getUserScheduleExaminfoByIndex(Long examindex);

}
