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
import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class GetSchoolInfoAction extends Business
{
    private Log log = SSBBus.getLog(getClass());
    private ILoginFS loginFS = (ILoginFS) SSBBus.findFacadeService("mloginFS");
    private String schoolIndex;
    private String collegeIndex;
    private String majorIndex;
    private String type;
    int pageNum;
    int count;

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
        jsonObj.put("desc", "查询列表失败");
        try
        {

            if ("0".equals(type))
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
                TSchoolinfo tschoolinfo = new TSchoolinfo();
                tschoolinfo.setSchoolstatus(1);
                TableDataInfo tableDataInfo = loginFS.getSchoolInfoList(tschoolinfo, pageNum, count);
                if (tableDataInfo != null)
                {
                    List<TSchoolinfo> schoolList = tableDataInfo.getData();

                    if (schoolList != null)
                    {
                        jsonObj.put("totalCount", schoolList.size() + "");
                        for (int i = 0; i < schoolList.size(); i++)
                        {
                            TSchoolinfo tempSchool = schoolList.get(i);
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("detailIndex", tempSchool.getSchoolindex() + "");
                            tempJobj.put("detailName", tempSchool.getSchoolname() + "");
                            schoolArray.add(tempJobj);

                        }

                    }
                }

            }
            else if ("1".equals(type))
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
                TCollegeinfo tcollegeinfo = new TCollegeinfo();
                tcollegeinfo.setUperindex(Long.parseLong(schoolIndex));
                tcollegeinfo.setStatus(1);
                TableDataInfo tableDataInfo = loginFS.getCollegeInfoList(tcollegeinfo, pageNum, count);
                if (tableDataInfo != null)
                {
                    List<TCollegeinfo> collegeList = tableDataInfo.getData();

                    if (collegeList != null)
                    {
                        jsonObj.put("totalCount", collegeList.size() + "");
                        for (int i = 0; i < collegeList.size(); i++)
                        {
                            TCollegeinfo tempCollege = collegeList.get(i);
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("detailIndex", tempCollege.getCollegeindex() + "");
                            tempJobj.put("detailName", tempCollege.getCollegename() + "");
                            tempJobj.put("detailType", tempCollege.getLevel() + "");
                            schoolArray.add(tempJobj);

                        }

                    }
                }
            }
            else if ("2".equals(type))
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
                TMajorinfo tmajorinfo = new TMajorinfo();
                tmajorinfo.setCollegeindex(Long.parseLong(collegeIndex));
                TableDataInfo tableDataInfo = loginFS.getMajorInfoList(tmajorinfo, pageNum, count);
                if (tableDataInfo != null)
                {
                    List<TMajorinfo> majorList = tableDataInfo.getData();
                    jsonObj.put("totalCount", majorList.size() + "");
                    if (majorList != null)
                    {
                        jsonObj.put("totalCount", majorList.size() + "");
                        for (int i = 0; i < majorList.size(); i++)
                        {
                            TMajorinfo tempMajor = majorList.get(i);
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("detailIndex", tempMajor.getMajorindex() + "");
                            tempJobj.put("detailName", tempMajor.getMajorname() + "");

                            schoolArray.add(tempJobj);

                        }

                    }

                }
            }

            else if ("3".equals(type))
            {
                jsonObj.put("result", "0");
                jsonObj.put("desc", "");
                TClassinfo tclassinfo = new TClassinfo();
                tclassinfo.setCollegeindex(Long.parseLong(collegeIndex));
                TableDataInfo tableDataInfo = loginFS.getClassInfoList(tclassinfo, pageNum, count);
                if (tableDataInfo != null)
                {
                    List<TClassinfo> classList = tableDataInfo.getData();
                    jsonObj.put("totalCount", classList.size() + "");
                    if (classList != null)
                    {
                        for (int i = 0; i < classList.size(); i++)
                        {
                            TClassinfo tempClass = classList.get(i);
                            JSONObject tempJobj = new JSONObject();
                            tempJobj.put("detailIndex", tempClass.getClassindex() + "");
                            tempJobj.put("detailName", tempClass.getClassname() + "");
                            schoolArray.add(tempJobj);
                        }

                    }
                }
            }
            jsonObj.put("Data", schoolArray);

        }
        catch (Exception e)
        {
            log.info("查询学校信息接口异常", e);
            jsonObj.put("result", "1");
            jsonObj.put("desc", "查询学校信息失败");

        }
        finally
        {
            log.info("查询学校信息接口响应的Json类型的结果字符串：" + jsonObj.toString());
            sendUtil.sendMessage(getResponse(), jsonObj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            schoolIndex = this.getRequest().getParameter("schoolIndex");
            collegeIndex = this.getRequest().getParameter("collegeIndex");
            majorIndex = this.getRequest().getParameter("majorIndex");
            type = this.getRequest().getParameter("type");
            String pageNumStr = this.getRequest().getParameter("pageNum");
            String countStr = this.getRequest().getParameter("count");
            if (Tools.isNull(type) || Tools.isNull(pageNumStr) || Tools.isNull(countStr))
            {
                return false;
            }
            if ("1".equals(type))
            {
                if (Tools.isNull(schoolIndex))
                {
                    return false;
                }
            }
            if ("2".equals(type) || "3".equals(type))
            {
                if (Tools.isNull(collegeIndex))
                {
                    return false;
                }
            }
            pageNum = Integer.parseInt(pageNumStr);
            count = Integer.parseInt(countStr);
        }
        catch (Exception e)
        {
            log.error("验证请求参数失败", e);
            return false;
        }

        return true;
    }

}
