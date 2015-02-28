package com.pinke.uni.lottery.sender;

import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 单彩种信息查询
 */
public class LotteryInfoQuerySender extends BaseServiceHandle {

    private static final String[] PARAMS = {"lottery"};
    private static final String[] RESULT = {"code","lottery","series","note","award","startTime","endTime","periods","interval","open"};
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS,request, SnsConstants.POST_KEY_VALUE);
        result.set(rs);
        return this;
    }
}
