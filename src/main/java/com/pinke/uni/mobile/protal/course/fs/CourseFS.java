package com.pinke.uni.mobile.protal.course.fs;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.course.ls.IUserScheduleCourseAttendMapLS;
import com.pinke.uni.mobile.protal.course.ls.IUserScheduleCourseLS;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class CourseFS implements ICourseFS
{

    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private Log log = SSBBus.getLog(this.getClass());
    private IUserScheduleCourseLS userScheduleCourseLS;
    private IUserScheduleCourseAttendMapLS userScheduleCourseAttendMapLS;

    /**
     * 查询课程详情
     * 
     * @param userScheduleCourse
     * @return
     */
    public UserScheduleCourse getUserScheduleCourse(UserScheduleCourse userScheduleCourse)
    {
        if (userScheduleCourse == null || userScheduleCourse.getCourseindex() == null)
        {
            return null;
        }
        try
        {
            userScheduleCourse = userScheduleCourseLS.getUserScheduleCourse(userScheduleCourse);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userScheduleCourse;

    }

    /**
     * 查询课程列表(分页)
     * 
     * @return
     */
    public TableDataInfo getUserScheduleCourseList(UserScheduleCourse userScheduleCourse, int pageNum, int count)
    {
        if (userScheduleCourse == null)
        {
            return null;
        }
        TableDataInfo list = null;
        try
        {
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(pageNum);
            pageparam.setPageSize(count);
            userScheduleCourse.setStatus(1);
            list = userScheduleCourseLS.pageInfoQuery(userScheduleCourse, pageparam.getFirstIndex(), pageparam
                    .getPageSize(), new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 查询课程列表（不分页）
     * 
     * @return
     */
    public List getUserScheduleCourseList(UserScheduleCourse userScheduleCourse)
    {
        if (userScheduleCourse == null)
        {
            return null;
        }
        List list = null;
        try
        {

            userScheduleCourse.setStatus(1);
            list = userScheduleCourseLS.getUserScheduleCourseByCond(userScheduleCourse);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 查询课程列表(用户已经参加的)
     * 
     * @return
     */
    public TableDataInfo getUserScheduleAttendCourseList(UserScheduleCourse userScheduleCourse, int pageNum, int count)
    {
        if (userScheduleCourse == null)
        {
            return null;
        }
        TableDataInfo list = null;
        try
        {
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(pageNum);
            pageparam.setPageSize(count);
            userScheduleCourse.setStatus(1);
            list = userScheduleCourseLS.pageInfoQuery(userScheduleCourse, pageparam.getFirstIndex(), pageparam
                    .getPageSize(), new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /**
     * 新增课程
     * 
     * @return
     */
    public String insertUserScheduleCourseInfo(UserScheduleCourse userScheduleCourse)
    {
        String resultJobj = new JSONObject().toString();
        if (userScheduleCourse == null)
        {
            return resultJobj.toString();
        }

        try
        {
            resultJobj = userScheduleCourseLS.insertUserScheduleCourse(userScheduleCourse);

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultJobj.toString();

    }

    /**
     * 更新课程
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserScheduleCourseInfo(UserScheduleCourse userScheduleCourse)
    {
        boolean result = false;
        if (userScheduleCourse == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userScheduleCourseLS.updateUserScheduleCourse(userScheduleCourse);
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
     * 更新课程参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean updateUserCourseAttend(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
    {
        boolean result = false;
        if (userScheduleCourseAttendMap == null || userScheduleCourseAttendMap.getAttendindex() == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userScheduleCourseAttendMapLS
                    .updateUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
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
     * 新增课程参与者
     * 
     * @param userScheduleExaminfo
     * @return
     */
    public boolean insertIntoCourse(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
    {
        boolean result = false;
        if (userScheduleCourseAttendMap == null || userScheduleCourseAttendMap.getCourseindex() == null
                || userScheduleCourseAttendMap.getAttendindex() == null)
        {
            return false;
        }
        String errorCode;
        try
        {
            errorCode = userScheduleCourseAttendMapLS.insertUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
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
     * 查询课程参与的人数
     * 
     * @return
     */
    public int getAttendUserCount(Long courseIndex)
    {
        if (courseIndex == null)
        {
            return 0;
        }
        List<UserScheduleCourseAttendMap> list = new ArrayList();
        try
        {
            UserScheduleCourseAttendMap userScheduleCourseAttendMap = new UserScheduleCourseAttendMap();
            userScheduleCourseAttendMap.setCourseindex(courseIndex);
            userScheduleCourseAttendMap.setStatus(1);
            list = userScheduleCourseAttendMapLS.getUserScheduleCourseAttendMapByCond(userScheduleCourseAttendMap);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list == null ? 0 : list.size();

    }

    public IUserScheduleCourseLS getUserScheduleCourseLS()
    {
        return userScheduleCourseLS;
    }

    public void setUserScheduleCourseLS(IUserScheduleCourseLS userScheduleCourseLS)
    {
        this.userScheduleCourseLS = userScheduleCourseLS;
    }

    public IUserScheduleCourseAttendMapLS getUserScheduleCourseAttendMapLS()
    {
        return userScheduleCourseAttendMapLS;
    }

    public void setUserScheduleCourseAttendMapLS(IUserScheduleCourseAttendMapLS userScheduleCourseAttendMapLS)
    {
        this.userScheduleCourseAttendMapLS = userScheduleCourseAttendMapLS;
    }

}
