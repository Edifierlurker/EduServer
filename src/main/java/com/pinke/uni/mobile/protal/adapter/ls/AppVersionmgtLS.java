package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.pinke.uni.mobile.protal.adapter.service.IAppVersionmgtDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class AppVersionmgtLS implements IAppVersionmgtLS
{

    private Logger log = LoggerFactory.getLogger("AppVersionmgt", AppVersionmgtLS.class);

    private IAppVersionmgtDS appVersionmgtDS;

    public void setAppVersionmgtDS(IAppVersionmgtDS appVersionmgtDS)
    {
        this.appVersionmgtDS = appVersionmgtDS;
    }

    public String insertAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        // check param
        if (null == appVersionmgt)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        appVersionmgtDS.insertAppVersionmgt(appVersionmgt);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert appVersionmgt success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(appVersionmgtList);
        if (null == appVersionmgtList || appVersionmgtList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        appVersionmgtDS.insertAppVersionmgtList(appVersionmgtList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert appVersionmgtList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        // check param
        if (appVersionmgt == null || appVersionmgt.getVersionindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        appVersionmgtDS.updateAppVersionmgt(appVersionmgt);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update appVersionmgt success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(appVersionmgtList);
        if (null == appVersionmgtList || appVersionmgtList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        appVersionmgtDS.updateAppVersionmgtList(appVersionmgtList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update appVersionmgtList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        // check param
        if (appVersionmgt == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        appVersionmgtDS.removeAppVersionmgt(appVersionmgt);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove appVersionmgt success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeAppVersionmgtList(List<AppVersionmgt> appVersionmgtList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(appVersionmgtList);
        if (appVersionmgtList == null || appVersionmgtList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        appVersionmgtDS.removeAppVersionmgtList(appVersionmgtList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove appVersionmgtList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public AppVersionmgt getAppVersionmgt(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        // check param
        if (appVersionmgt == null || appVersionmgt.getVersionindex() == null)
        {
            return null;
        }
        return appVersionmgtDS.getAppVersionmgt(appVersionmgt);
    }

    public AppVersionmgt getAppVersionmgtByIndex(Long versionindex) throws DomainServiceException
    {
        // check param
        if (versionindex == null)
        {
            return null;
        }
        return appVersionmgtDS.getAppVersionmgtByIndex(versionindex);
    }

    public List<AppVersionmgt> getAppVersionmgtByCond(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        return appVersionmgtDS.getAppVersionmgtByCond(appVersionmgt);
    }

    public List<AppVersionmgt> getAppVersionmgtByCondExact(AppVersionmgt appVersionmgt) throws DomainServiceException
    {
        return appVersionmgtDS.getAppVersionmgtByCondExact(appVersionmgt);
    }

    public TableDataInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return appVersionmgtDS.pageInfoQuery(appVersionmgt, start, pageSize, puEntity);
    }

}
