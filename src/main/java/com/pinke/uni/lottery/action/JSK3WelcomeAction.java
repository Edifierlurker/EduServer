package com.pinke.uni.lottery.action;

import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-4.
 */
public class JSK3WelcomeAction extends BaseServiceHandle {

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("uid");
        if(userid == null){}

        return this;
    }
}
