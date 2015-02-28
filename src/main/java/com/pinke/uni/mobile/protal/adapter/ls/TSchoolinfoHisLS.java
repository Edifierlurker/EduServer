package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.adapter.service.ITSchoolinfoHisDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TSchoolinfoHisLS implements ITSchoolinfoHisLS
{

    private Logger log = LoggerFactory.getLogger("TSchoolinfoHis", TSchoolinfoHisLS.class);

    private ITSchoolinfoHisDS tschoolinfoHisDS;

    public void setTschoolinfoHisDS(ITSchoolinfoHisDS tschoolinfoHisDS)
    {
        this.tschoolinfoHisDS = tschoolinfoHisDS;
    }

    public String insertTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        // check param
        if (null == tschoolinfoHis)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tschoolinfoHisDS.insertTSchoolinfoHis(tschoolinfoHis);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tschoolinfoHis success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoHisList);
        if (null == tschoolinfoHisList || tschoolinfoHisList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoHisDS.insertTSchoolinfoHisList(tschoolinfoHisList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tschoolinfoHisList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        // check param
        if (tschoolinfoHis == null || tschoolinfoHis.getMapindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoHisDS.updateTSchoolinfoHis(tschoolinfoHis);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tschoolinfoHis success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoHisList);
        if (null == tschoolinfoHisList || tschoolinfoHisList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoHisDS.updateTSchoolinfoHisList(tschoolinfoHisList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tschoolinfoHisList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        // check param
        if (tschoolinfoHis == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoHisDS.removeTSchoolinfoHis(tschoolinfoHis);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tschoolinfoHis success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTSchoolinfoHisList(List<TSchoolinfoHis> tschoolinfoHisList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tschoolinfoHisList);
        if (tschoolinfoHisList == null || tschoolinfoHisList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tschoolinfoHisDS.removeTSchoolinfoHisList(tschoolinfoHisList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tschoolinfoHisList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TSchoolinfoHis getTSchoolinfoHis(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        // check param
        if (tschoolinfoHis == null || tschoolinfoHis.getMapindex() == null)
        {
            return null;
        }
        return tschoolinfoHisDS.getTSchoolinfoHis(tschoolinfoHis);
    }

    public TSchoolinfoHis getTSchoolinfoHisByIndex(Long mapindex) throws DomainServiceException
    {
        // check param
        if (mapindex == null)
        {
            return null;
        }
        return tschoolinfoHisDS.getTSchoolinfoHisByIndex(mapindex);
    }

    public List<TSchoolinfoHis> getTSchoolinfoHisByCond(TSchoolinfoHis tschoolinfoHis) throws DomainServiceException
    {
        return tschoolinfoHisDS.getTSchoolinfoHisByCond(tschoolinfoHis);
    }

    public List<TSchoolinfoHis> getTSchoolinfoHisByCondExact(TSchoolinfoHis tschoolinfoHis)
            throws DomainServiceException
    {
        return tschoolinfoHisDS.getTSchoolinfoHisByCondExact(tschoolinfoHis);
    }

    public TableDataInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tschoolinfoHisDS.pageInfoQuery(tschoolinfoHis, start, pageSize, puEntity);
    }

}
