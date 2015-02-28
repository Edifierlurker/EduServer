package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.bbs.service.ITBbsinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBbsinfoLS implements ITBbsinfoLS
{

    private Logger log = LoggerFactory.getLogger("TBbsinfo", TBbsinfoLS.class);

    private ITBbsinfoDS tbbsinfoDS;

    public void setTbbsinfoDS(ITBbsinfoDS tbbsinfoDS)
    {
        this.tbbsinfoDS = tbbsinfoDS;
    }

    public String insertTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        // check param
        if (null == tbbsinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tbbsinfoDS.insertTBbsinfo(tbbsinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbbsinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoList);
        if (null == tbbsinfoList || tbbsinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoDS.insertTBbsinfoList(tbbsinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbbsinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        // check param
        if (tbbsinfo == null || tbbsinfo.getBbsindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoDS.updateTBbsinfo(tbbsinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbbsinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoList);
        if (null == tbbsinfoList || tbbsinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoDS.updateTBbsinfoList(tbbsinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbbsinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        // check param
        if (tbbsinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoDS.removeTBbsinfo(tbbsinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbbsinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBbsinfoList(List<TBbsinfo> tbbsinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoList);
        if (tbbsinfoList == null || tbbsinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoDS.removeTBbsinfoList(tbbsinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbbsinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TBbsinfo getTBbsinfo(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        // check param
        if (tbbsinfo == null || tbbsinfo.getBbsindex() == null)
        {
            return null;
        }
        return tbbsinfoDS.getTBbsinfo(tbbsinfo);
    }

    public TBbsinfo getTBbsinfoByIndex(Long bbsindex) throws DomainServiceException
    {
        // check param
        if (bbsindex == null)
        {
            return null;
        }
        return tbbsinfoDS.getTBbsinfoByIndex(bbsindex);
    }

    public List<TBbsinfo> getTBbsinfoByCond(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        return tbbsinfoDS.getTBbsinfoByCond(tbbsinfo);
    }

    public List<TBbsinfo> getTBbsinfoByCondExact(TBbsinfo tbbsinfo) throws DomainServiceException
    {
        return tbbsinfoDS.getTBbsinfoByCondExact(tbbsinfo);
    }

    public TableDataInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tbbsinfoDS.pageInfoQuery(tbbsinfo, start, pageSize, puEntity);
    }

}
