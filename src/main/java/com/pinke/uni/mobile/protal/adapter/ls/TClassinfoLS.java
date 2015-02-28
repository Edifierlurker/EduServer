package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.pinke.uni.mobile.protal.adapter.service.ITClassinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TClassinfoLS implements ITClassinfoLS
{

    private Logger log = LoggerFactory.getLogger("TClassinfo", TClassinfoLS.class);

    private ITClassinfoDS tclassinfoDS;

    public void setTclassinfoDS(ITClassinfoDS tclassinfoDS)
    {
        this.tclassinfoDS = tclassinfoDS;
    }

    public String insertTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        // check param
        if (null == tclassinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tclassinfoDS.insertTClassinfo(tclassinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tclassinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tclassinfoList);
        if (null == tclassinfoList || tclassinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tclassinfoDS.insertTClassinfoList(tclassinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tclassinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        // check param
        if (tclassinfo == null || tclassinfo.getClassindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tclassinfoDS.updateTClassinfo(tclassinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tclassinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tclassinfoList);
        if (null == tclassinfoList || tclassinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tclassinfoDS.updateTClassinfoList(tclassinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tclassinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        // check param
        if (tclassinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tclassinfoDS.removeTClassinfo(tclassinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tclassinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTClassinfoList(List<TClassinfo> tclassinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tclassinfoList);
        if (tclassinfoList == null || tclassinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tclassinfoDS.removeTClassinfoList(tclassinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tclassinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TClassinfo getTClassinfo(TClassinfo tclassinfo) throws DomainServiceException
    {
        // check param
        if (tclassinfo == null || tclassinfo.getClassindex() == null)
        {
            return null;
        }
        return tclassinfoDS.getTClassinfo(tclassinfo);
    }

    public TClassinfo getTClassinfoByIndex(Long classindex) throws DomainServiceException
    {
        // check param
        if (classindex == null)
        {
            return null;
        }
        return tclassinfoDS.getTClassinfoByIndex(classindex);
    }

    public List<TClassinfo> getTClassinfoByCond(TClassinfo tclassinfo) throws DomainServiceException
    {
        return tclassinfoDS.getTClassinfoByCond(tclassinfo);
    }

    public List<TClassinfo> getTClassinfoByCondExact(TClassinfo tclassinfo) throws DomainServiceException
    {
        return tclassinfoDS.getTClassinfoByCondExact(tclassinfo);
    }

    public TableDataInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tclassinfoDS.pageInfoQuery(tclassinfo, start, pageSize, puEntity);
    }

}
