package com.pinke.uni.lottery.sender;

import com.alibaba.fastjson.JSONArray;
import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.lottery.model.RewardsInfo;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 彩种奖金查询
 */
public class RewardsQuerySender extends BaseServiceHandle {

    private static final String[] PARAMS = {"lottery"};
    private static final String[] RESULT = {"code", "datas"};
    private static final String[] DATA = {"game", "money", "add", "code"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS, request, SnsConstants.POST_KEY_VALUE);
        String game = request.getParameter("lottery");
        if(game != null) {
            JSONObject jb = JSONObject.fromObject(rs);
            List<RewardsInfo> list = JSONArray.parseArray(jb.get("datas").toString(), RewardsInfo.class);
            for (RewardsInfo obj : list) {
                if (obj.getGame().equals(game)) {
                    result.set(JSONObject.fromObject(obj).toString());break;
                }
            }
            result.set("{\"game\":\"-1\"}");
        }else {
            result.set("{\"game\":\"-2\"}");
        }
        return this;
    }
}
