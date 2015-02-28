package com.pinke.uni.lottery.action;

import com.pinke.uni.mobile.protal.common.CommonConstants;
import com.pinke.uni.mobile.protal.common.model.LoginUserInfo;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 15-1-8.
 */
public class LotteryLoginAction extends BaseServiceHandle {

    private static final String[] PARAMS = {"userCode","password"};
    private static final String[] RESULT = {"result","desc","userIndex","schoolIndex","weeks","weekBegin"};
//    private String url = "/unistore/servicedata.do?serviceid=login";
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String usercode = request.getParameter("userCode");
        String rs = null;
        if(NumberUtils.isNumber(usercode)) {
            rs = proccessHttpGet(PARAMS, request);
            if (rs != null) {
                JSONObject obj = JSONObject.fromObject(rs);
                String status = obj.get("result").toString();
                if (status.equals("0")) {
                    HttpSession session = request.getSession();
                    LoginUserInfo userInfo = new LoginUserInfo();
                    userInfo.setUserid(usercode);
                    userInfo.setUserindex(Long.valueOf(obj.get("userIndex").toString()));
                    userInfo.setSchoolIndex(Long.valueOf(obj.get("schoolIndex").toString()));
                    session.setAttribute(CommonConstants.PAGE_LOGIN_USER, userInfo);
                }
            } else {
                response.setStatus(500);
            }
        }else{
            response.setStatus(500);
        }
        result.set(rs);
        return this;
    }
}
