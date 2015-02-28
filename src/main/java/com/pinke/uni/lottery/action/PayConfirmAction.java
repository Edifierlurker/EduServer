package com.pinke.uni.lottery.action;

import com.ericsson.cqtmsfw.StringUtils;
import com.pinke.uni.lottery.BallUtil;
import com.pinke.uni.lottery.ParamsUtil;
import com.pinke.uni.lottery.common.GameErrors;
import com.pinke.uni.lottery.model.BallTicket;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 15-1-4.
 */
public class PayConfirmAction extends BaseServiceHandle {

    private static final String[] PARAMS = {"balllist","lottery"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        Cookie[]  cookies = request.getCookies();
        String balllist = "";
        String enballlist = "";
        for(Cookie c : cookies){
            if(c.getName().equals("balls")){
                try {
                    enballlist = c.getValue();
                    balllist = URLDecoder.decode(enballlist, "utf-8");
                    c.setPath("/");
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        String lottery = request.getParameter("lottery");
        if(StringUtils.isEmpty(lottery) || StringUtils.isEmpty(balllist)){
            request.setAttribute("result", GameErrors.LOTTERY_ERROR);
        }else{
            List<BallTicket> list = BallUtil.getBallListFromBallString(balllist,"#",lottery);
            String checkcode = ParamsUtil.MD5( lottery + "-" + System.currentTimeMillis());
            Long money = BallUtil.getMoneySum(list);
            request.setAttribute("money",money);
            request.setAttribute("balllist", enballlist);
            request.setAttribute("checkCode",checkcode);
            request.setAttribute("securepara", ParamsUtil.MD5(checkcode + "-" + lottery + "-" + balllist + "-" + money + "-" + ParamsUtil.getPartnerKey()));

            request.getSession().setAttribute("BALL_LIST", list);
            request.getSession().setAttribute("PAY_MONEY", money);

            request.setAttribute("result", GameErrors.SUCCESS);
        }
        return this;
    }
}
