package com.pinke.uni.lottery.action;

import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-4.
 */
public class PaySuccessAction extends BaseServiceHandle {

    private static final String[] PARAMS = {"lottery"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String lottery = request.getParameter("lottery");
        result.set(StringUtils.isEmpty(lottery)?"":lottery);
        return this;
    }
}
