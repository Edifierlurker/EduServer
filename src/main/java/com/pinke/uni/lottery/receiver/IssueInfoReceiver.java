package com.pinke.uni.lottery.receiver;

import com.pinke.uni.lottery.ParamsUtil;
import com.pinke.uni.lottery.common.GameErrors;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 奖期通知
 */
public class IssueInfoReceiver extends BaseServiceHandle {
    private static final String[] PARAMS = {"lottery","issue","code","nextIssue","endTime","closeTime","saleStatus"};
    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> map = request.getParameterMap();
        String sign = map.get("sign");
        if(map.get("t") == null || sign == null || map.get("partner") == null ) {

            result.set(GameErrors.INFO_ERROR + "");
        }else {
            if (ParamsUtil.verifySign(sign, map)) {
                //todo 奖期通知入库？
                result.set("0");
            }
        };
        return this;
    }
}
