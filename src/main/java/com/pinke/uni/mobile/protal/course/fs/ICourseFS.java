package com.pinke.uni.mobile.protal.course.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface ICourseFS
{
    /**
     * 查询课程详情
     * 
     * @param userScheduleCourse
     * @return
     */
    public UserScheduleCourse getUserScheduleCourse(UserScheduleCourse userScheduleCourse);

    /**
     * 查询课程列表
     * 
     * @return
     */
    public TableDataInfo getUserScheduleCourseList(UserScheduleCourse userScheduleCourse, int pageNum, int count);
    public TableDataInfo getUserScheduleAttendCourseList(UserScheduleCourse userScheduleCourse, int pageNum,
            int count);

    /**
     * 新增课程
     * 
     * @return
     */
    public String insertUserScheduleCourseInfo(UserScheduleCourse userScheduleCourse);

    /**
     * 更新课程
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserScheduleCourseInfo(UserScheduleCourse userScheduleCourse);

    /**
     * 新增课程参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean insertIntoCourse(UserScheduleCourseAttendMap userScheduleCourseAttendMap);

    /**
     * 查询课程参与的人数
     * 
     * @return
     */
    public int getAttendUserCount(Long courseIndex);

    /**
     * 更新课程参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserCourseAttend(UserScheduleCourseAttendMap userScheduleCourseAttendMap);
    
    /**
     * 查询课程列表（不分页）
     * 
     * @return
     */
    public List getUserScheduleCourseList(UserScheduleCourse userScheduleCourse);

}
