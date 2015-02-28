package com.pinke.uni.mobile.protal.common.page.handle;

import com.pinke.uni.mobile.protal.activity.ls.IUserScheduleActivityLS;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 14-12-10.
 */
public class ActivityInfoHandle extends BaseServiceHandle {

    private Log log = SSBBus.getLog(this.getClass());
    private static IUserScheduleActivityLS userScheduleActivityLS = (IUserScheduleActivityLS) SSBBus.findDomainService("userScheduleActivityLS");

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("aid");
        if (StringUtils.isEmpty(idStr) || !NumberUtils.isNumber(idStr)) {
            return null;
        }
        Long id = Long.valueOf(idStr);
        try {
            UserScheduleActivity userScheduleActivity = new UserScheduleActivity();
            userScheduleActivity.setActivityindex(id);
            UserScheduleActivity detail = userScheduleActivityLS.getUserScheduleActivity(userScheduleActivity);
            request.setAttribute("info", detail);
            return this;
        } catch (Exception e) {
            log.error("activityindex is " + idStr + " ,but page error!");
        }
        return null;
    }
}
