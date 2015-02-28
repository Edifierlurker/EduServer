package com.pinke.uni.mobile.protal.adapter.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

/**
 * @author 母乐乐
 * 
 */
public interface ILoginFS
{
    /**
     * 用户注册接口
     * 
     * @param userinfo
     * @return
     */
    public String signUp(String userCode, String password);

    /**
     * 用户登录
     * 
     * @param userCode
     * @param password
     * @return
     */
    public String login(String userCode, String password);

    /**
     * 根据用户名查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserCode(String userCode);

    /**
     * 根据用户index,修改用户个人信息
     * 
     * @param userInfo
     * @return
     */
    public boolean updateUserInfo(TStudentinfo userInfo);

    /**
     * 根据用户index查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserIndex(String userIndex);

    /**
     * 查询学校信息列表
     * 
     * @param tschoolinfo
     * @return
     */
    public TableDataInfo getSchoolInfoList(TSchoolinfo tschoolinfo, int page, int count);

    /**
     * 查询院系列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getCollegeInfoList(TCollegeinfo tcollegeinfo, int page, int count);

    /**
     * 查询专业列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getMajorInfoList(TMajorinfo tmajorinfo, int page, int count);

    /**
     * 查询班级列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getClassInfoList(TClassinfo tclassinfo, int page, int count);

    public List getSchoolfoExtendsList(TSchoolinfoHis tschoolinfoHis);

    /**
     * 查询学校基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TSchoolinfo getSchoolInfo(Long schoolIndex);

    /**
     * 查询院系基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TCollegeinfo getCollegeInfo(Long collegeIndex);

    /**
     * 查询专业基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TMajorinfo getMajorInfo(Long majorIndex);

    /**
     * 查询班级基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TClassinfo getClassInfo(Long classIndex);

    public TableDataInfo searchUserList(String keyword, int page, int count);

    /**
     * 根据用户名查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByExtends(TStudentinfo tstudentinfo);

    /**
     * 根据包名查询客户端最新的版本
     * 
     * @param userCode
     * @return
     */
    public AppVersionmgt getAppVersion(String packagename);
    /**
     * 根据用户UserID查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserID(String userID);
}
