package com.pinke.uni.lottery.sender;

import com.alibaba.fastjson.JSON;
import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.lottery.model.LotteryInfo;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * 彩种查询
 */
public class LotteriesQuerySender extends BaseServiceHandle {

    private static final String[] RESULT = {"code","datas"};
    private static final String[] DATA = {"lottery","status","note","award","startTime","endTime","periods","interval","open"};
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(new String[0], request, SnsConstants.POST_KEY_VALUE);
//        JSONObject jsonObject = JSONObject.fromObject(rs);
//        String code = String.valueOf(jsonObject.getString("code"));
//        JSONArray dataArray = jsonObject.getJSONArray("datas");
//        LotteryInfo[] arr = (LotteryInfo[])JSONArray.toArray(dataArray,LotteryInfo.class);
        result.set(rs);
        return this;
    }
}
