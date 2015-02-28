package com.pinke.uni.mobile.protal.personal.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;

public interface IPersonalFS
{
    /**
     * 查询用户的个人列表
     * 
     * @param userIndex
     * @return
     */
    public List getUserPersonalList(Long userIndex);
    /**
     * 根据个人详情index查询个人详情
     * @param userIndex
     * @return
     */
    public List getUserPersonalDetailByIndex(Long detailIndex,Long userIndex);
    /**
     * 修改个人（包括假删除）
     * @param userSchedulePrivate
     * @return
     */
    public boolean updatePersonalDetail(UserSchedulePrivate userSchedulePrivate);
    /**
     * 新增个人
     * @param userSchedulePrivate
     * @return
     */
    public boolean insertPersonalDetail(UserSchedulePrivate userSchedulePrivate);

}
