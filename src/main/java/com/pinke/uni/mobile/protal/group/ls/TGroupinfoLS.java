package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.service.ITGroupinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoLS implements ITGroupinfoLS
{

    private Logger log = LoggerFactory.getLogger("TGroupinfo", TGroupinfoLS.class);

    private ITGroupinfoDS tgroupinfoDS;

    public void setTgroupinfoDS(ITGroupinfoDS tgroupinfoDS)
    {
        this.tgroupinfoDS = tgroupinfoDS;
    }

    public String insertTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        // check param
        if (null == tgroupinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupinfoDS.insertTGroupinfo(tgroupinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoList);
        if (null == tgroupinfoList || tgroupinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoDS.insertTGroupinfoList(tgroupinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        // check param
        if (tgroupinfo == null || tgroupinfo.getGroupindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoDS.updateTGroupinfo(tgroupinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoList);
        if (null == tgroupinfoList || tgroupinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoDS.updateTGroupinfoList(tgroupinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        // check param
        if (tgroupinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoDS.removeTGroupinfoByCond(tgroupinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoList);
        if (tgroupinfoList == null || tgroupinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoDS.removeTGroupinfoList(tgroupinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupinfo getTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        // check param
        if (tgroupinfo == null || tgroupinfo.getGroupindex() == null)
        {
            return null;
        }
        return tgroupinfoDS.getTGroupinfo(tgroupinfo);
    }

    public TGroupinfo getTGroupinfoByIndex(Long groupindex) throws DomainServiceException
    {
        // check param
        if (groupindex == null)
        {
            return null;
        }
        return tgroupinfoDS.getTGroupinfoByIndex(groupindex);
    }

    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        return tgroupinfoDS.getTGroupinfoByCond(tgroupinfo);
    }

    public List<TGroupinfo> getTGroupinfoByCondExact(TGroupinfo tgroupinfo) throws DomainServiceException
    {
        return tgroupinfoDS.getTGroupinfoByCondExact(tgroupinfo);
    }

    public TableDataInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tgroupinfoDS.pageInfoQuery(tgroupinfo, start, pageSize, puEntity);
    }

    public TableDataInfo pageInfoQueryExtends(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tgroupinfoDS.pageInfoQueryExtends(tgroupinfo, start, pageSize, puEntity);
    }

}
