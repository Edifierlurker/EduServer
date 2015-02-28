package com.pinke.uni.pay;

import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-6.
 */
public class AccountPrePayConfirm extends BaseServiceHandle {
    private static final String[] PARAMS = {"cpid","hmac"};
    private static final String[] HMAC = {"orderid","status","payfee"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS,request, SnsConstants.POST_JSON);
        result.set(rs);
        return this;
    }
}
