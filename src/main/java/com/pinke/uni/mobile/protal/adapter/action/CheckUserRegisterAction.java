package com.pinke.uni.mobile.protal.adapter.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
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
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

/**
 * 查询用户是否已注册（List,多个用户）
 * 
 * @author Administrator
 * 
 */
public class CheckUserRegisterAction extends Business
{
    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private String userIndex;
    private JSONArray userList;

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
        JSONArray schoolArray = new JSONArray();
        jsonObj.put("totalCount", "0");
        jsonObj.put("result", "1");
        jsonObj.put("desc", "查询用户是否已注册失败");
        try
        {

            jsonObj.put("result", "0");
            jsonObj.put("desc", "");

            JSONArray tempArray = new JSONArray();
            for (int i = 0; i < userList.size(); i++)
            {
                JSONObject tempUser = userList.getJSONObject(i);
                if (tempUser != null)
                {
                    String tempCode = tempUser.get("userCode") + "";
                    if (Tools.isNotNull(tempCode))
                    {

                        TStudentinfo tempStudent = loginFS.getUserInfoByUserCode(tempCode);
                        if (tempStudent != null && Tools.isNotNull(tempStudent.getSchoolindex() + ""))
                        {
                            JSONObject tempObj = new JSONObject();
                            tempObj.put("studentIndex", tempStudent.getStudentindex() + "");
                            tempObj.put("studentName", tempStudent.getStudentname() + "");
                            tempObj.put("studentID", tempStudent.getStudentid() + "");
                            tempObj.put("headPic", Tools.serverURL + "/upload/" + tempStudent.getHeadpic() + "");
                            tempArray.add(tempObj);

                        }
                    }

                }

            }

            jsonObj.put("data", tempArray);

        }
        catch (Exception e)
        {
            log.info("查询用户是否注册接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询用户是否注册失败");

        }
        finally
        {
            log.info("查询用户是否注册接口响应的Json类型的结果字符串：" + jsonObj.toString());
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
            String userListStr = obj.get("userList") + "";
            if (Tools.isNull(userListStr))
            {
                return false;
            }
            userList = JSONArray.fromObject(userListStr);

        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
