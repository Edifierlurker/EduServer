package com.pinke.uni.lottery.sender;

import com.pinke.uni.lottery.common.GameConstants;
import com.pinke.uni.lottery.http.SnsConstants;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 奖期查询 ，根据彩种编号查询
 */
public class IssueQuerySender extends BaseServiceHandle {
    private static Log log = SSBBus.getLog(IssueQuerySender.class);

    private static final String[] PARAMS = {"lottery"};
    private static final String[] RESULT = {"code", "lottery", "issue", "number", "nextIssue", "endTime", "closeTime", "saleStatus"};

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String game = request.getParameter("lottery");
        if (game != null) {
            String key = "lottery_" + game + "_issureinfo";
            Object obj = getMemCachedValue(key);
            String rs = null;
            if (obj == null) {
                rs = proccessHttpSender(PARAMS, request, SnsConstants.POST_KEY_VALUE);
                if(rs!= null )setMemCachedValue(key, rs, 3600);
            } else {
                rs = obj.toString();
            }
            if (StringUtils.isEmpty(rs)) {
                result.set("{\"code\":-2}");
            } else {
                JSONObject jb = JSONObject.fromObject(rs);
                rs = rs.substring(0, rs.length() - 1) + ",\"lotteryname\":" + "\"" + GameConstants.LOTTERY.get(jb.get("lottery")) + "\"}";

                result.set(rs);
            }
            log.info("issue query result : " + rs);
        } else {
            result.set("{\"code\":-1}");
        }
        return this;
    }
}
