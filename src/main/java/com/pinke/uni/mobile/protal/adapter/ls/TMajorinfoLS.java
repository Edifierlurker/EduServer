package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.pinke.uni.mobile.protal.adapter.service.ITMajorinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TMajorinfoLS implements ITMajorinfoLS
{

    private Logger log = LoggerFactory.getLogger("TMajorinfo", TMajorinfoLS.class);

    private ITMajorinfoDS tmajorinfoDS;

    public void setTmajorinfoDS(ITMajorinfoDS tmajorinfoDS)
    {
        this.tmajorinfoDS = tmajorinfoDS;
    }

    public String insertTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        // check param
        if (null == tmajorinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tmajorinfoDS.insertTMajorinfo(tmajorinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tmajorinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tmajorinfoList);
        if (null == tmajorinfoList || tmajorinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tmajorinfoDS.insertTMajorinfoList(tmajorinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tmajorinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        // check param
        if (tmajorinfo == null || tmajorinfo.getMajorindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tmajorinfoDS.updateTMajorinfo(tmajorinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tmajorinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tmajorinfoList);
        if (null == tmajorinfoList || tmajorinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tmajorinfoDS.updateTMajorinfoList(tmajorinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tmajorinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        // check param
        if (tmajorinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tmajorinfoDS.removeTMajorinfo(tmajorinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tmajorinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTMajorinfoList(List<TMajorinfo> tmajorinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tmajorinfoList);
        if (tmajorinfoList == null || tmajorinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tmajorinfoDS.removeTMajorinfoList(tmajorinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tmajorinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TMajorinfo getTMajorinfo(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        // check param
        if (tmajorinfo == null || tmajorinfo.getMajorindex() == null)
        {
            return null;
        }
        return tmajorinfoDS.getTMajorinfo(tmajorinfo);
    }

    public TMajorinfo getTMajorinfoByIndex(Long majorindex) throws DomainServiceException
    {
        // check param
        if (majorindex == null)
        {
            return null;
        }
        return tmajorinfoDS.getTMajorinfoByIndex(majorindex);
    }

    public List<TMajorinfo> getTMajorinfoByCond(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        return tmajorinfoDS.getTMajorinfoByCond(tmajorinfo);
    }

    public List<TMajorinfo> getTMajorinfoByCondExact(TMajorinfo tmajorinfo) throws DomainServiceException
    {
        return tmajorinfoDS.getTMajorinfoByCondExact(tmajorinfo);
    }

    public TableDataInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tmajorinfoDS.pageInfoQuery(tmajorinfo, start, pageSize, puEntity);
    }

}
