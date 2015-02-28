package com.pinke.uni.lottery.action;

import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-8.
 */
public class LotteryToLoginAction extends BaseServiceHandle {

    private static final String[] PARAMS = {"userCode","password"};
    private static final String[] RESULT = {"result","desc","userIndex","schoolIndex","weeks","weekBegin"};
//    private String url = "/unistore/servicedata.do?serviceid=login";
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("rl");
        if(a == null){
            response.setStatus(500);
        }else {
            result.set(a);
        }
        return this;
    }
}
