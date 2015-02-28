package com.pinke.uni.mobile.protal.common.page.handle;

import com.pinke.uni.mobile.protal.bbs.ls.ITBulletinLS;
import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 14-12-10.
 */
public class BulletinHandle extends BaseServiceHandle {
    private static ITBulletinLS bulletinLS = (ITBulletinLS) SSBBus.findDomainService("tbulletinLS");

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        String bid = request.getParameter("bid");
        if (StringUtils.isEmpty(bid) || !StringUtils.isNumeric(bid))
            return null;
        TBulletin queryObj = new TBulletin();
        queryObj.setBulindex(Long.valueOf(bid));
        TBulletin resultObj = null;
        try {
            resultObj = bulletinLS.getTBulletin(queryObj);
            request.setAttribute("info", resultObj);
            return this;
        } catch (DomainServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
