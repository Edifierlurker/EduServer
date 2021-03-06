package com.pinke.uni.lottery.sender;

import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-4.
 */
public class OrderInfoQuerySender extends BaseServiceHandle {

    private static final String[] PARAMS = {"orderId"};
    private static final String[] RESULT = {"code","orderId","status","money","win","items"};
    private static final String[] ITEM = {"game","code","mutiple","success","win"};
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS, request, SnsConstants.POST_KEY_VALUE);
        result.set(rs);
        return this;
    }
}
