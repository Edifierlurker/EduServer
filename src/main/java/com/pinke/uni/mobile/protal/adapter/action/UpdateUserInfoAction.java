package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.adapter.fs.ILoginFS;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 修改用户信息
 * 
 * @author lucuiping
 */
public class UpdateUserInfoAction extends Business
{

    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    /** 用户唯一标识 */
    private String userIndex;
    /**
     * 修改类型
     */
    private String type;
    /** 姓名 */
    private String name;
    /** 性别 1: 男 2: 女 3: 保密 */
    private int gender;
    /** 昵称 */
    private String nick;
    /** 出生日期 */
    private String age;
    /** 身份证 */
    private String idDard;
    /** 联系方式 */
    private String contactinfo;
    /** 身份类别，0-学生，1-老师 **/
    private String userType;
    /** 学号 **/
    private String studentNO;
    /** 学校index */
    private String schoolIndex;
    /** 院系index */
    private String collegeIndex;
    /** 专业index */
    private String majorIndex;
    /** 班级index */
    private String classIndex;
    /** 入校时间 */
    private String enterTime;
    /** 籍贯 */
    private String origin;
    /** 个性签名 */
    private String signature;
    /** 用户手机号码 */
    private String userCode;
    /** 用户头像名称 */
    private String headPic;
    private String weeks;
    private String weekBegin;
    private String starseat;
    private String hobby;
    private String recordURL;

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
            boolean updateFlag = true;
            TStudentinfo userInfo = new TStudentinfo();

            userInfo = loginFS.getUserInfoByUserIndex(userIndex);
            if (userInfo == null)
            {
                jsonObj.put("result", "1");
                jsonObj.put("desc", "用户不存在，无法更新信息");
            }
            /**
             * 修改用户基本信息
             */
            if ("1".equals(type))
            {
                if (Tools.isNotNull(name))
                {
                    userInfo.setStudentname(name);
                }
                if (Tools.isNotNull(age))
                {
                    userInfo.setBirthmonth(age);
                }
                if (Tools.isNotNull(idDard))
                {
                    userInfo.setIdcard(idDard);
                }
                if (Tools.isNotNull(gender + ""))
                {
                    userInfo.setGender(gender);
                }
                if (Tools.isNotNull(contactinfo))
                {
                    userInfo.setContactinfo(contactinfo);
                }
                if (Tools.isNotNull(userType))
                {
                    userInfo.setUsertype(Integer.parseInt(userType));
                }
                if (Tools.isNotNull(studentNO))
                {
                    userInfo.setStudentno(studentNO);
                }
                if (Tools.isNotNull(schoolIndex))
                {
                    userInfo.setSchoolindex(Long.parseLong(schoolIndex));
                    userInfo.setCollegeindex(0l);
                    userInfo.setMajorindex(0l);
                    userInfo.setClassindex(0l);
                }
                if (Tools.isNotNull(enterTime))
                {
                    userInfo.setEntertime(enterTime);
                }
                if (Tools.isNotNull(origin))
                {
                    userInfo.setOrigin(origin);
                }
                if (Tools.isNotNull(signature))
                {
                    userInfo.setSignature(signature);
                }
                if (Tools.isNotNull(collegeIndex))
                {
                    userInfo.setCollegeindex(Long.parseLong(collegeIndex));
                    userInfo.setMajorindex(0l);
                    userInfo.setClassindex(0l);
                }
                if (Tools.isNotNull(majorIndex))
                {
                    userInfo.setMajorindex(Long.parseLong(majorIndex));
                    userInfo.setClassindex(0l);
                }
                if (Tools.isNotNull(classIndex))
                {
                    userInfo.setClassindex(Long.parseLong(classIndex));
                }

                if (Tools.isNotNull(starseat))
                {
                    userInfo.setStarseat(starseat);
                }
                if (Tools.isNotNull(hobby))
                {
                    userInfo.setHobby(hobby);
                }

            }
            /**
             * 重新绑定用户手机号
             */
            else if ("2".equals(type))
            {
                TStudentinfo temp = loginFS.getUserInfoByUserCode(userCode);
                if (temp == null)
                {
                    userInfo.setUserphone(userCode);
                }
                else
                {
                    jsonObj.put("result", "1");
                    jsonObj.put("desc", "手机号已经绑定");
                    updateFlag = false;
                }

            }
            /**
             * 修改用户头像
             */
            else if ("3".equals(type))
            {
                userInfo.setHeadpic("/userUpload/" + headPic);

            }
            /**
             * 修改周数
             */
            else if ("4".equals(type))
            {
                if (Tools.isNotNull(weeks))
                {
                    userInfo.setWeeks(Long.parseLong(weeks));
                }
                if (Tools.isNotNull(weekBegin))
                {
                    userInfo.setWeekbegin(weekBegin);
                }

            }
            else if ("5".equals(type))
            {
                userInfo.setuserrecordurl("/userRecord/" + recordURL);
            }
            if (updateFlag = true)
            {
                boolean errorcode = loginFS.updateUserInfo(userInfo);
                if (errorcode = true)
                {
                    jsonObj.put("result", "0");
                    jsonObj.put("desc", "");
                    if ("3".equals(type))
                    {
                        jsonObj.put("newHeadPic", Tools.serverURL + "/userUpload/" + headPic);
                    }
                }
                else
                {
                    jsonObj.put("result", "1");
                    jsonObj.put("desc", "用户信息更新失败");
                }

            }

        }
        catch (Exception e)
        {
            log.info("修改用户信息接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "用户信息更新失败");

        }
        finally
        {
            log.info("修改用户信息接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }

    }

    private boolean confirm()
    {
        try
        {
            String content = getRequestContent();

            log.info("请求的Json类型的结果字符串：" + content);
            if (null == content)
            {
                return false;
            }

            JSONObject obj = JSONObject.fromObject(content);
            if (null == obj)
            {
                return false;
            }
            userIndex = obj.get("userIndex") + "";
            if (Tools.isNull(userIndex))
            {
                return false;
            }
            type = obj.get("type") + "";
            if (Tools.isNull(type))
            {
                return false;
            }
            if ("2".equals(type))
            {
                userCode = obj.get("userCode") + "";
                if (Tools.isNull(userCode))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else if ("3".equals(type))
            {
                headPic = obj.get("headPic") + "";
                if (Tools.isNull(headPic))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else if ("4".equals(type))
            {
                weeks = obj.get("weeks") + "";
                weekBegin = obj.get("weekBegin") + "";
                if (Tools.isNull(weekBegin) && Tools.isNull(weeks))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else if ("5".equals(type))
            {
                recordURL = obj.get("recordURL") + "";
                if (Tools.isNull(recordURL))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                name = obj.get("name") + "";
                String genderStr = obj.get("gender") + "";
                if (Tools.isNotNull(genderStr))
                {
                    gender = Integer.parseInt(genderStr);
                }
                else
                {
                    gender = 3;
                }

                age = obj.get("age") + "";
                idDard = obj.get("idDard") + "";
                contactinfo = obj.get("contactinfo") + "";
                userType = obj.get("userType") + "";
                studentNO = obj.get("studentNO") + "";
                schoolIndex = obj.get("schoolIndex") + "";
                enterTime = obj.get("enterTime") + "";
                origin = obj.get("origin") + "";
                signature = obj.get("signature") + "";
                collegeIndex = obj.get("collegeIndex") + "";
                majorIndex = obj.get("majorIndex") + "";
                classIndex = obj.get("classIndex") + "";
                starseat = obj.get("starseat") + "";
                hobby = obj.get("hobby") + "";

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
