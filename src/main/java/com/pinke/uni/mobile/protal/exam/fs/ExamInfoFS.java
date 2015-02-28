package com.pinke.uni.mobile.protal.exam.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.exam.ls.IUserExaminfoAttendMapLS;
import com.pinke.uni.mobile.protal.exam.ls.IUserScheduleExaminfoLS;
import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class ExamInfoFS implements IExamInfoFS
{
    private IUserScheduleExaminfoLS userScheduleExaminfoLS;
    private IUserExaminfoAttendMapLS userExaminfoAttendMapLS;

    /**
     * 查询考试列表
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public TableDataInfo getExamList(UserScheduleExaminfo userScheduleExaminfo, int page, int count)
    {
        if (userScheduleExaminfo == null)
        {
            return null;
        }
        TableDataInfo list = null;

        try
        {
            userScheduleExaminfo.setStatus(1);
            userScheduleExaminfo.setOrderCond("examdate asc,examindex desc");

            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = userScheduleExaminfoLS.pageInfoQuery(userScheduleExaminfo, pageparam.getFirstIndex(),
                    pageparam.getPageSize(), new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询考试列表(不分页)
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public List getExamList(UserScheduleExaminfo userScheduleExaminfo)
    {
        if (userScheduleExaminfo == null)
        {
            return null;
        }
        List list = null;

        try
        {
            userScheduleExaminfo.setStatus(1);
            userScheduleExaminfo.setOrderCond("examdate asc,examindex desc");

            list = userScheduleExaminfoLS.getUserScheduleExaminfoByCond(userScheduleExaminfo);

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询用户已参加的考试列表
     */
    public TableDataInfo getUserAttendExamListByUserindex(UserScheduleExaminfoExtends userScheduleExaminfo, int page,
            int count)
    {
        if (userScheduleExaminfo == null || userScheduleExaminfo.getUserindex() == null)
        {
            return null;
        }
        TableDataInfo list = null;

        try
        {
            userScheduleExaminfo.setStatus(1);
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            userScheduleExaminfo.setOrderCond("examstarttime asc,examindex desc");
            list = userScheduleExaminfoLS.pageInfoQueryExtendsMore(userScheduleExaminfo, pageparam.getFirstIndex(),
                    pageparam.getPageSize(), new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据index查询详情
     * 
     * @param examindex
     * @return
     */

    public UserScheduleExaminfoExtends getUserScheduleExaminfoExtendsByIndex(Long examindex)
    {
        if (examindex == null)
        {
            return null;
        }
        UserScheduleExaminfoExtends userScheduleExaminfo = new UserScheduleExaminfoExtends();
        try
        {
            userScheduleExaminfo = userScheduleExaminfoLS.getUserScheduleExaminfoByIndexExtends(examindex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userScheduleExaminfo;

    }

    /**
     * 根据index查询详情
     * 
     * @param examindex
     * @return
     */

    public UserScheduleExaminfo getUserScheduleExaminfoByIndex(Long examindex)
    {
        if (examindex == null)
        {
            return null;
        }
        UserScheduleExaminfo userScheduleExaminfo = new UserScheduleExaminfo();
        try
        {
            userScheduleExaminfo = userScheduleExaminfoLS.getUserScheduleExaminfoByIndex(examindex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userScheduleExaminfo;

    }

    /**
     * 新增考试
     */

    public boolean insertUserScheduleExamInfo(UserScheduleExaminfo userScheduleExaminfo)
    {
        boolean result = false;
        if (userScheduleExaminfo == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userScheduleExaminfoLS.insertUserScheduleExaminfo(userScheduleExaminfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 更新考试
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserScheduleExamInfo(UserScheduleExaminfo userScheduleExaminfo)
    {
        boolean result = false;
        if (userScheduleExaminfo == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userScheduleExaminfoLS.updateUserScheduleExaminfo(userScheduleExaminfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 新增考试参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean insertIntoExam(UserExaminfoAttendMap userExaminfoAttendMap)
    {
        boolean result = false;
        if (userExaminfoAttendMap == null || userExaminfoAttendMap.getExamindex() == null
                || userExaminfoAttendMap.getUserindex() == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userExaminfoAttendMapLS.insertUserExaminfoAttendMap(userExaminfoAttendMap);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 更新考试参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateIntoExam(UserExaminfoAttendMap userExaminfoAttendMap)
    {
        boolean result = false;
        if (userExaminfoAttendMap == null || userExaminfoAttendMap.getExamindex() == null
                || userExaminfoAttendMap.getUserindex() == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userExaminfoAttendMapLS.updateUserExaminfoAttendMapByCond(userExaminfoAttendMap);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

    public IUserScheduleExaminfoLS getUserScheduleExaminfoLS()
    {
        return userScheduleExaminfoLS;
    }

    public void setUserScheduleExaminfoLS(IUserScheduleExaminfoLS userScheduleExaminfoLS)
    {
        this.userScheduleExaminfoLS = userScheduleExaminfoLS;
    }

    public IUserExaminfoAttendMapLS getUserExaminfoAttendMapLS()
    {
        return userExaminfoAttendMapLS;
    }

    public void setUserExaminfoAttendMapLS(IUserExaminfoAttendMapLS userExaminfoAttendMapLS)
    {
        this.userExaminfoAttendMapLS = userExaminfoAttendMapLS;
    }

}
