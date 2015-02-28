package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取附近的人列表
 * 
 * @author Administrator
 * 
 */
public class GetUserNearPositionListAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 是 用户名index
     * @site String UTF 是 用户位置
     * @userLatitude String UTF 用户纬度
     * @userLongitude String UTF 用户经度
     * @pageNum String UTF 是 请求第几页数据
     * @count String UTF 是 单页请求数量，默认取值20
     * @gender 性别类型 0- 不区分 1- 只看男生 2- 只看女生
     */
    String userIndex;
    int pageNum;
    int count;
    String gender;
    String site;
    String longitude;
    String latitude;

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
        log.info("获取附近的人列表接口接收到的参数：userindex=" + userIndex + ",pageNum=" + pageNum + ",count=" + count + ",site="
                + site + ",longitude=" + longitude + ",latitude=" + latitude);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("resultPost", "1");
            resultJobj.put("desc", "获取附近的人列表失败");
            // 上报自己的位置
            try
            {
                TNearStudent tnearStudent = new TNearStudent();
                tnearStudent.setLatitude(latitude);
                tnearStudent.setLongitude(longitude);
                tnearStudent.setStudentindex(Long.parseLong(userIndex));
                tnearStudent.setSite(site);
                tnearStudent.setCreatetime(Tools.formatDate7(new Date()));
                tnearStudent.setStatus(1);
                boolean postResult = groupFS.insertUserSiteInfo(tnearStudent);
                if (postResult == true)
                    resultJobj.put("resultPost", "0");
            }
            catch (Exception e)
            {
                log.error("上报用户位置失败" + e);
            }

            // 所有的附近的人列表
            TNearStudent tnearStudent = new TNearStudent();
            tnearStudent.setLongitude(longitude);
            tnearStudent.setLatitude(latitude);
            tnearStudent.setStatus(1);
            tnearStudent.setStudentindex(Long.parseLong(userIndex));
            if (Tools.isNotNull(gender))
            {
                tnearStudent.setGender(Integer.parseInt(gender));
            }
            tnearStudent.setOrderCond("DISTANCE DESC");
            TableDataInfo tabledata = groupFS.getNearStudentListByDistance(tnearStudent, pageNum, count);

            if (tabledata != null)
            {
                resultJobj.put("result", "0");
                resultJobj.put("desc", "");
                List<TNearStudent> list = tabledata.getData();
                int totalCount = tabledata.getTotalCount();
                resultJobj.put("totalCount", totalCount);
                if (list != null && list.size() > 0)
                {
                    for (TNearStudent temp : list)
                    {
                        /**
                         * @nearIndex String UTF 是 附近的人的index
                         * @nearHeadPic String UTF 是 附近的人的头像
                         * @nearNickName String UTF 是 附近的人的昵称
                         * @nearSign String UTF 是 附近的人的个性签名
                         * @site String UTF 是 附近的人地点
                         * @distance String UTF 是 附近的人的距离
                         */
                        JSONObject tempJobj = new JSONObject();
                        tempJobj.put("nearIndex", temp.getStudentindex() + "");
                        tempJobj.put("nearHeadPic", Tools.serverURL + temp.getHeadpic() + "");
                        tempJobj.put("nearNickName", temp.getStudentname() + "");
                        tempJobj.put("nearSign", temp.getSignature() + "");
                        tempJobj.put("site", temp.getSite() + "");
                        tempJobj.put("distance", temp.getDISTANCE() + "");
                        tempArray.add(tempJobj);

                    }
                }
                resultJobj.put("data", tempArray);
            }

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取附近的人列表接口异常", e);

        }
        finally
        {
            log.info("获取附近的人列表接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            site = this.getRequest().getParameter("site");
            gender = this.getRequest().getParameter("gender");
            longitude = this.getRequest().getParameter("userLongitude");
            latitude = this.getRequest().getParameter("userLatitude");
            if (Tools.isNull(userIndex) || Tools.isNull(pageNumStr) || Tools.isNull(countStr) || Tools.isNull(site)
                    || Tools.isNull(longitude) || Tools.isNull(latitude))
            {
                return false;
            }

            pageNum = Integer.parseInt(pageNumStr);
            count = Integer.parseInt(countStr);

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
