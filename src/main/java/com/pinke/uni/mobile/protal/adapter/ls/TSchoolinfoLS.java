package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.service.ITSchoolinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TSchoolinfoLS implements ITSchoolinfoLS
{

    private Logger log = LoggerFactory.getLogger("TSchoolinfo", TSchoolinfoLS.class);

    private ITSchoolinfoDS tschoolinfoDS;

    public void setTschoolinfoDS(ITSchoolinfoDS tschoolinfoDS)
    {
        this.tschoolinfoDS = tschoolinfoDS;
    }

    public String insertTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        // check param
        if (null == tschoolinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tschoolinfoDS.insertTSchoolinfo(tschoolinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tschoolinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoList);
        if (null == tschoolinfoList || tschoolinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoDS.insertTSchoolinfoList(tschoolinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tschoolinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        // check param
        if (tschoolinfo == null || tschoolinfo.getSchoolindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoDS.updateTSchoolinfo(tschoolinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tschoolinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoList);
        if (null == tschoolinfoList || tschoolinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoDS.updateTSchoolinfoList(tschoolinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tschoolinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        // check param
        if (tschoolinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoDS.removeTSchoolinfo(tschoolinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tschoolinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTSchoolinfoList(List<TSchoolinfo> tschoolinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoList);
        if (tschoolinfoList == null || tschoolinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoDS.removeTSchoolinfoList(tschoolinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tschoolinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TSchoolinfo getTSchoolinfo(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        // check param
        if (tschoolinfo == null || tschoolinfo.getSchoolindex() == null)
        {
            return null;
        }
        return tschoolinfoDS.getTSchoolinfo(tschoolinfo);
    }

    public TSchoolinfo getTSchoolinfoByIndex(Long schoolindex) throws DomainServiceException
    {
        // check param
        if (schoolindex == null)
        {
            return null;
        }
        return tschoolinfoDS.getTSchoolinfoByIndex(schoolindex);
    }

    public List<TSchoolinfo> getTSchoolinfoByCond(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        return tschoolinfoDS.getTSchoolinfoByCond(tschoolinfo);
    }

    public List<TSchoolinfo> getTSchoolinfoByCondExact(TSchoolinfo tschoolinfo) throws DomainServiceException
    {
        return tschoolinfoDS.getTSchoolinfoByCondExact(tschoolinfo);
    }

    public TableDataInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tschoolinfoDS.pageInfoQuery(tschoolinfo, start, pageSize, puEntity);
    }

}
