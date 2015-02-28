package com.pinke.uni.lottery.action;

import com.pinke.uni.lottery.ls.ILotteryOrderRecordLS;
import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.pinke.uni.mobile.protal.common.CommonConstants;
import com.pinke.uni.mobile.protal.common.model.LoginUserInfo;
import com.pinke.uni.mobile.protal.common.page.handle.BaseServiceHandle;
import com.pinke.uni.mobile.protal.common.page.handle.IPageServiceHandle;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 15-1-4.
 */
public class LotteryOrderInfoAction extends BaseServiceHandle {
    private static Log log = SSBBus.getLog(LotteryOrderInfoAction.class);
    private ILotteryOrderRecordLS lotteryOrderRecordLS = (ILotteryOrderRecordLS) SSBBus.findFacadeService("lotteryOrderRecordLS");

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String orderindexStr = request.getParameter("oidx");
        if(NumberUtils.isNumber(orderindexStr)) {
            Long orderindex = Long.valueOf(orderindexStr);
            LoginUserInfo userInfo = (LoginUserInfo) session.getAttribute(CommonConstants.PAGE_LOGIN_USER);
            try {
                LotteryOrderRecord lotteryOrderRecord = new LotteryOrderRecord();
                lotteryOrderRecord.setUserindex(userInfo.getUserindex());
                lotteryOrderRecord.setOrderindex(orderindex);
                log.info("orderindex : "+orderindex +" ,userindex : " + userInfo.getUserindex());
                List<LotteryOrderRecord> list = lotteryOrderRecordLS.getLotteryOrderRecordByCond(lotteryOrderRecord);
                if(CollectionUtils.isNotEmpty(list) && list.size() == 1)
                    request.setAttribute("orderinfo", list.get(0));
            } catch (DomainServiceException e) {
                e.printStackTrace();
            }
            result.set("{\"result\":0}");
        }
        return this;
    }
}
