package com.pinke.uni.lottery.sender;

import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 出票请求
 */
public class PrintTicketsSender extends BaseServiceHandle {
    private static Log log = SSBBus.getLog(PrintTicketsSender.class);

    private static final String []  PARAMS = {"game","orderId","money","issue","content"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS,request, SnsConstants.POST_KEY_VALUE);
        log.info("print result : " + rs);
        result.set(rs);
        return this;
    }
}
