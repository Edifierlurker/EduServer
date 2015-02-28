package com.pinke.uni.lottery.action;

import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-4.
 */
public class PayFailureAction extends BaseServiceHandle {

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String msg = request.getParameter("msg");
        result.set(StringUtils.isEmpty(msg)?"-999":msg);
        return this;
    }
}
