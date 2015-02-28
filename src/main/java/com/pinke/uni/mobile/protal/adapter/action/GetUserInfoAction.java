package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 查看用户信息
 * 
 * @author lucuiping
 */
public class GetUserInfoAction extends Business
{

    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private String userIndex;
    private String type;

    @Override
    public void execute()
    {
        if (!confirm())
        {
            try
            {
                this.getResponse().sendError(CodeConstant.SC_HTTP_400, CodeConstant.HTTP_400);
            }
            catch (IOException e)
            {
                log.error("response流异常", e);
            }
            return;
        }

        SendUtil sendUtil = new SendUtil();
        JSONObject jsonObj = new JSONObject();
        try
        {

            TStudentinfo tstudentinfo = new TStudentinfo();
            tstudentinfo.setStudentindex(Long.parseLong(userIndex));
            tstudentinfo.setStatus(1);
            TStudentinfo userInfo = loginFS.getUserInfoByExtends(tstudentinfo);
            if (userInfo == null)
            {
                jsonObj.put("result", "1");
                jsonObj.put("desc", "用户不存在，无法查看信息");
            }
            else
            {

                jsonObj.put("result", "0");
                jsonObj.put("desc", "");

                /**
                 * name string UTF 是 姓名 gender int 4 是 性别 1: 男 0: 女 age String UTF 是 出生日期 idDard string UTF 是 身份证
                 * contactinfo string UTF 是 联系方式 studentNO string UTF 是 学号 userType int UTF 是 身份类别，0-学生，1-老师 schoolIndex
                 * string UTF 是 学校index collegeIndex string UTF 是 院系index majorIndex string UTF 是 专业index classIndex
                 * string UTF 是 班级index enterTime string UTF 是 入校时间 origin string UTF 是 籍贯 school string UTF 是 学校名称
                 * college string UTF 是 院系 major string UTF 是 专业 class string UTF 是 班级 signature string UTF 是 个性签名
                 * headPic string UTF 是 用户头像地址
                 */
                jsonObj.put("name", userInfo.getStudentname());
                jsonObj.put("userCode", userInfo.getUserphone() + "");
                jsonObj.put("gender", userInfo.getGender());
                jsonObj.put("age", userInfo.getBirthmonth() + "");
                jsonObj.put("idDard", userInfo.getIdcard() + "");
                jsonObj.put("contactinfo", userInfo.getContactinfo() + "");
                jsonObj.put("studentNO", userInfo.getStudentno() + "");
                jsonObj.put("userType", userInfo.getUsertype());
                jsonObj.put("schoolIndex", userInfo.getSchoolindex() + "");
                jsonObj.put("collegeIndex", userInfo.getCollegeindex() + "");
                jsonObj.put("majorIndex", userInfo.getMajorindex() + "");
                jsonObj.put("classIndex", userInfo.getClassindex() + "");
                jsonObj.put("enterTime", userInfo.getEntertime() + "");
                jsonObj.put("origin", userInfo.getOrigin() + "");
                jsonObj.put("weeks", userInfo.getWeeks() + "");
                jsonObj.put("weekBegin", userInfo.getWeekbegin() + "");
                jsonObj.put("userID", userInfo.getStudentid() + "");
                TSchoolinfo tempSchool = loginFS.getSchoolInfo(userInfo.getSchoolindex());
                if (tempSchool != null)
                    jsonObj.put("school", tempSchool.getSchoolname() + "");
                TCollegeinfo tempCollege = loginFS.getCollegeInfo(userInfo.getCollegeindex());
                if (tempCollege != null)
                    jsonObj.put("college", tempCollege.getCollegename() + "");
                TMajorinfo tempMajor = loginFS.getMajorInfo(userInfo.getMajorindex());
                if (tempMajor != null)
                    jsonObj.put("major", tempMajor.getMajorname() + "");

                TClassinfo tempClass = loginFS.getClassInfo(userInfo.getClassindex());

                if (tempClass != null)
                    jsonObj.put("className", tempClass.getClassname() + "");

                jsonObj.put("signature", userInfo.getSignature() + "");
                jsonObj.put("headPic", Tools.serverURL + userInfo.getHeadpic() + "");

                jsonObj.put("starseat", Tools.isNull(userInfo.getStarseat()) ? "保密" : userInfo.getStarseat() + "");
                jsonObj.put("hobby", userInfo.getHobby() + "");
                jsonObj.put("recordURL", Tools.serverURL + userInfo.getuserrecordurl() + "");

            }

        }
        catch (Exception e)
        {
            log.info("查询用户信息接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询用户信息失败");

        }
        finally
        {
            log.info("查询用户信息接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            type = this.getRequest().getParameter("type");
            if (Tools.isNull(userIndex) || Tools.isNull(type))
            {
                return false;
            }
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
