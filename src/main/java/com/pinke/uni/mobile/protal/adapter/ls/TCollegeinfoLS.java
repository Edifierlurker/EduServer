package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.pinke.uni.mobile.protal.adapter.service.ITCollegeinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TCollegeinfoLS implements ITCollegeinfoLS
{

    private Logger log = LoggerFactory.getLogger("TCollegeinfo", TCollegeinfoLS.class);

    private ITCollegeinfoDS tcollegeinfoDS;

    public void setTcollegeinfoDS(ITCollegeinfoDS tcollegeinfoDS)
    {
        this.tcollegeinfoDS = tcollegeinfoDS;
    }

    public String insertTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        // check param
        if (null == tcollegeinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tcollegeinfoDS.insertTCollegeinfo(tcollegeinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tcollegeinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tcollegeinfoList);
        if (null == tcollegeinfoList || tcollegeinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tcollegeinfoDS.insertTCollegeinfoList(tcollegeinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tcollegeinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        // check param
        if (tcollegeinfo == null || tcollegeinfo.getCollegeindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tcollegeinfoDS.updateTCollegeinfo(tcollegeinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tcollegeinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tcollegeinfoList);
        if (null == tcollegeinfoList || tcollegeinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tcollegeinfoDS.updateTCollegeinfoList(tcollegeinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tcollegeinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        // check param
        if (tcollegeinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tcollegeinfoDS.removeTCollegeinfo(tcollegeinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tcollegeinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTCollegeinfoList(List<TCollegeinfo> tcollegeinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tcollegeinfoList);
        if (tcollegeinfoList == null || tcollegeinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tcollegeinfoDS.removeTCollegeinfoList(tcollegeinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tcollegeinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TCollegeinfo getTCollegeinfo(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        // check param
        if (tcollegeinfo == null || tcollegeinfo.getCollegeindex() == null)
        {
            return null;
        }
        return tcollegeinfoDS.getTCollegeinfo(tcollegeinfo);
    }

    public TCollegeinfo getTCollegeinfoByIndex(Long collegeindex) throws DomainServiceException
    {
        // check param
        if (collegeindex == null)
        {
            return null;
        }
        return tcollegeinfoDS.getTCollegeinfoByIndex(collegeindex);
    }

    public List<TCollegeinfo> getTCollegeinfoByCond(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        return tcollegeinfoDS.getTCollegeinfoByCond(tcollegeinfo);
    }

    public List<TCollegeinfo> getTCollegeinfoByCondExact(TCollegeinfo tcollegeinfo) throws DomainServiceException
    {
        return tcollegeinfoDS.getTCollegeinfoByCondExact(tcollegeinfo);
    }

    public TableDataInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tcollegeinfoDS.pageInfoQuery(tcollegeinfo, start, pageSize, puEntity);
    }

}
