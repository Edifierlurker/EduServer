package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.adapter.service.ITStudentinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TStudentinfoLS implements ITStudentinfoLS
{

    private Logger log = LoggerFactory.getLogger("TStudentinfo", TStudentinfoLS.class);

    private ITStudentinfoDS tstudentinfoDS;

    public void setTstudentinfoDS(ITStudentinfoDS tstudentinfoDS)
    {
        this.tstudentinfoDS = tstudentinfoDS;
    }

    public String insertTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        // check param
        if (null == tstudentinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tstudentinfoDS.insertTStudentinfo(tstudentinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tstudentinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tstudentinfoList);
        if (null == tstudentinfoList || tstudentinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tstudentinfoDS.insertTStudentinfoList(tstudentinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tstudentinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        // check param
        if (tstudentinfo == null || tstudentinfo.getStudentindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tstudentinfoDS.updateTStudentinfo(tstudentinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tstudentinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tstudentinfoList);
        if (null == tstudentinfoList || tstudentinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tstudentinfoDS.updateTStudentinfoList(tstudentinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tstudentinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        // check param
        if (tstudentinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tstudentinfoDS.removeTStudentinfo(tstudentinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tstudentinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTStudentinfoList(List<TStudentinfo> tstudentinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tstudentinfoList);
        if (tstudentinfoList == null || tstudentinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tstudentinfoDS.removeTStudentinfoList(tstudentinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tstudentinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TStudentinfo getTStudentinfo(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        // check param
        if (tstudentinfo == null || tstudentinfo.getStudentindex() == null)
        {
            return null;
        }
        return tstudentinfoDS.getTStudentinfo(tstudentinfo);
    }

    public TStudentinfo getTStudentinfoByIndex(Long studentindex) throws DomainServiceException
    {
        // check param
        if (studentindex == null)
        {
            return null;
        }
        return tstudentinfoDS.getTStudentinfoByIndex(studentindex);
    }

    public List<TStudentinfo> getTStudentinfoByCond(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        return tstudentinfoDS.getTStudentinfoByCond(tstudentinfo);
    }

    public List<TStudentinfo> getTStudentinfoByCondExact(TStudentinfo tstudentinfo) throws DomainServiceException
    {
        return tstudentinfoDS.getTStudentinfoByCondExact(tstudentinfo);
    }

    public TableDataInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tstudentinfoDS.pageInfoQuery(tstudentinfo, start, pageSize, puEntity);
    }
    public TStudentinfo getTStudentinfoByUserCode(String userCode) throws DomainServiceException
    {
        // check param
        if (userCode == null)
        {
            return null;
        }
        return tstudentinfoDS.getTStudentinfoByUserCode(userCode);
    }

}
