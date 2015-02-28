package com.pinke.uni.mobile.protal.course.ls;

import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.ls.ITSchoolinfoHisLS;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.pinke.uni.mobile.protal.course.service.IUserScheduleCourseDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserScheduleCourseLS implements IUserScheduleCourseLS
{

    private Logger log = LoggerFactory.getLogger("UserScheduleCourse", UserScheduleCourseLS.class);

    private IUserScheduleCourseDS userScheduleCourseDS;
    private ITSchoolinfoHisLS tschoolinfoHisLS;

    private IUserScheduleCourseAttendMapLS userScheduleCourseAttendMapLS;

    public void setUserScheduleCourseDS(IUserScheduleCourseDS userScheduleCourseDS)
    {
        this.userScheduleCourseDS = userScheduleCourseDS;
    }

    public ITSchoolinfoHisLS getTschoolinfoHisLS()
    {
        return tschoolinfoHisLS;
    }

    public void setTschoolinfoHisLS(ITSchoolinfoHisLS tschoolinfoHisLS)
    {
        this.tschoolinfoHisLS = tschoolinfoHisLS;
    }

    public IUserScheduleCourseAttendMapLS getUserScheduleCourseAttendMapLS()
    {
        return userScheduleCourseAttendMapLS;
    }

    public void setUserScheduleCourseAttendMapLS(IUserScheduleCourseAttendMapLS userScheduleCourseAttendMapLS)
    {
        this.userScheduleCourseAttendMapLS = userScheduleCourseAttendMapLS;
    }

    public String insertUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        JSONObject resultJobj = new JSONObject();
        resultJobj.put("result", CommonErrorcode.COMMON_INPUT_OBJECT_NULL);
        // check param
        if (null == userScheduleCourse)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return resultJobj.toString();
        }

        userScheduleCourseDS.insertUserScheduleCourse(userScheduleCourse);

        userScheduleCourse.setStatus(1);
        List<UserScheduleCourse> tempList = this.getUserScheduleCourseByCond(userScheduleCourse);
        UserScheduleCourse temp = null;
        if (tempList != null && tempList.size() > 0)
            temp = tempList.get(0);
        if (temp != null)
        {
            resultJobj.put("result", CommonErrorcode.COMMON_SUCCESS);
            resultJobj.put("courseindex", temp.getCourseindex() + "");
            UserScheduleCourseAttendMap userScheduleCourseAttendMap = new UserScheduleCourseAttendMap();
            userScheduleCourseAttendMap.setCourseindex(temp.getCourseindex());
            userScheduleCourseAttendMap.setAttendindex(temp.getStudentindex());
            String courseStartTime = "";
            String courseEndTime = "";
            String sections = temp.getSections();
            String schoolIndex = temp.getSchoolindex() + "";
            if (Tools.isNotNull(sections))
            {
                String[] sectionArray = sections.split("-");
                int length = sectionArray.length;
                if (sectionArray != null && sectionArray.length > 0)
                {
                    if (Tools.isNull(schoolIndex))
                        schoolIndex = "1";
                    if (Tools.isNotNull(schoolIndex))
                    {
                        TSchoolinfoHis tschoolinfoHis = new TSchoolinfoHis();
                        List<TSchoolinfoHis> tempSchoolHisList = tschoolinfoHisLS
                                .getTSchoolinfoHisByCond(tschoolinfoHis);
                        if (tempSchoolHisList != null && tempSchoolHisList.size() > 0)
                        {

                            for (TSchoolinfoHis tempSchool : tempSchoolHisList)
                            {
                                if (Tools.isNotNull(sectionArray[0])
                                        && sectionArray[0].equals(tempSchool.getSections() + ""))
                                {
                                    courseStartTime = tempSchool.getSectionstarttime();
                                }
                                if (Tools.isNotNull(sectionArray[length - 1])
                                        && sectionArray[length - 1].equals(tempSchool.getSections() + ""))
                                {
                                    courseEndTime = tempSchool.getSectionendtime();
                                }
                            }

                        }
                    }
                }

            }

            userScheduleCourseAttendMap.setCourseendtime(courseEndTime);
            userScheduleCourseAttendMap.setCoursestarttime(courseStartTime);
            userScheduleCourseAttendMap.setStatus(1);

            userScheduleCourseAttendMapLS.insertUserScheduleCourseAttendMap(userScheduleCourseAttendMap);
        }
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleCourse success");

        return resultJobj.toString();

    }

    public String insertUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseList);
        if (null == userScheduleCourseList || userScheduleCourseList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseDS.insertUserScheduleCourseList(userScheduleCourseList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userScheduleCourseList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        // check param
        if (userScheduleCourse == null || userScheduleCourse.getCourseindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseDS.updateUserScheduleCourse(userScheduleCourse);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleCourse success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseList);
        if (null == userScheduleCourseList || userScheduleCourseList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseDS.updateUserScheduleCourseList(userScheduleCourseList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userScheduleCourseList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleCourse(UserScheduleCourse userScheduleCourse) throws DomainServiceException
    {
        // check param
        if (userScheduleCourse == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseDS.removeUserScheduleCourse(userScheduleCourse);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleCourse success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserScheduleCourseList(List<UserScheduleCourse> userScheduleCourseList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userScheduleCourseList);
        if (userScheduleCourseList == null || userScheduleCourseList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userScheduleCourseDS.removeUserScheduleCourseList(userScheduleCourseList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userScheduleCourseList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserScheduleCourse getUserScheduleCourse(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        // check param
        if (userScheduleCourse == null || userScheduleCourse.getCourseindex() == null)
        {
            return null;
        }
        return userScheduleCourseDS.getUserScheduleCourse(userScheduleCourse);
    }

    public UserScheduleCourse getUserScheduleCourseByIndex(Long courseindex) throws DomainServiceException
    {
        // check param
        if (courseindex == null)
        {
            return null;
        }
        return userScheduleCourseDS.getUserScheduleCourseByIndex(courseindex);
    }

    public List<UserScheduleCourse> getUserScheduleCourseByCond(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        return userScheduleCourseDS.getUserScheduleCourseByCond(userScheduleCourse);
    }

    public List<UserScheduleCourse> getUserScheduleCourseByCondExact(UserScheduleCourse userScheduleCourse)
            throws DomainServiceException
    {
        return userScheduleCourseDS.getUserScheduleCourseByCondExact(userScheduleCourse);
    }

    public TableDataInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return userScheduleCourseDS.pageInfoQuery(userScheduleCourse, start, pageSize, puEntity);
    }

}
