package com.pinke.uni.lottery.sender;

import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 15-1-4.
 */
public class OmitQuerySender extends BaseServiceHandle {

    private static final String[] PARAMS = {"lottery"};
    private static final String[] RESULT = {"code","lottery","datas"};
    private static final String[] DATA = {"game","infos"};
    private static final String[] INFO = {"code","nowOmit","maxOmit","todayOpen"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String rs = proccessHttpSender(PARAMS, request, SnsConstants.POST_KEY_VALUE);
        result.set("0");
        return this;
    }
}
