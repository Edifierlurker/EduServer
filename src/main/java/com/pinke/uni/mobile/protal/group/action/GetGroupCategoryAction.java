package com.pinke.uni.mobile.protal.group.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pinke.uni.mobile.protal.common.Business;
import com.pinke.uni.mobile.protal.group.fs.IGroupFS;
import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.pinke.uni.mobile.protal.util.CodeConstant;
import com.pinke.uni.mobile.protal.util.SendUtil;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

/**
 * 获取群组分类
 * 
 * @author Administrator
 * 
 */
public class GetGroupCategoryAction extends Business
{
    private Log log = SSBBus.getLog(this.getClass());
    private IGroupFS groupFS = (IGroupFS) SSBBus.findFacadeService("mGroupFS");

    /**
     * @userIndex String UTF 否 用户名index
     * @pageNum String 4 是 请求第几页数据
     * @count String 4 是 单页请求数量，默认取值20
     */
    String userIndex;

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
        log.info("获取群组分类接口接收到的参数：userindex=" + userIndex);
        SendUtil sendUtil = new SendUtil();
        JSONObject resultJobj = new JSONObject();
        JSONArray tempArray = new JSONArray();
        try
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "获取群组分类失败");

            // 一级群组分类
            List<TGroupCategory> catList = groupFS.getGroupCategoryList();

            if (catList != null && catList.size() > 0)
            {
                for (TGroupCategory temp : catList)
                {

                    JSONObject tempJobj = new JSONObject();
                    tempJobj.put("catIndex", temp.getCategoryindex() + "");
                    tempJobj.put("catTitle", temp.getCategoryname() + "");
                    tempJobj.put("catPic", temp.getCategorypic() + "");
                    JSONArray tempTwoArray = new JSONArray();
                    // 二级群组分类
                    List<TGroupCategory> catTwoList = groupFS.getGroupCategoryListByUpindex(temp.getCategoryindex());
                    if (catTwoList != null && catTwoList.size() > 0)
                    {
                        JSONObject tempTwoJobj = new JSONObject();
                        tempTwoJobj.put("catIndex", temp.getCategoryindex() + "");
                        tempTwoJobj.put("catTitle", temp.getCategoryname() + "");
                        tempTwoJobj.put("catPic", temp.getCategorypic() + "");
                        tempTwoArray.add(tempTwoJobj);
                    }
                    tempJobj.put("category", tempTwoArray);
                    tempArray.add(tempJobj);

                }
            }
            resultJobj.put("data", tempArray);

        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.info("获取群组分类接口异常", e);

        }
        finally
        {
            log.info("获取群组分类接口响应的Json类型的结果字符串：" + resultJobj.toString());
            sendUtil.sendMessage(this.getResponse(), resultJobj.toString());
        }

    }

    private boolean confirm()
    {

        try
        {
            userIndex = this.getRequest().getParameter("userIndex");

        }
        catch (Exception e)
        {
            log.error("获取json数据异常", e);
            return false;
        }

        return true;

    }

}
