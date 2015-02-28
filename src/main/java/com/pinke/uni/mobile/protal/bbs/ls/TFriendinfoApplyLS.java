package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.pinke.uni.mobile.protal.bbs.service.ITFriendinfoApplyDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TFriendinfoApplyLS implements ITFriendinfoApplyLS
{

    private Logger log = LoggerFactory.getLogger("TFriendinfoApply", TFriendinfoApplyLS.class);

    private ITFriendinfoApplyDS tfriendinfoApplyDS;

    public void setTfriendinfoApplyDS(ITFriendinfoApplyDS tfriendinfoApplyDS)
    {
        this.tfriendinfoApplyDS = tfriendinfoApplyDS;
    }

    public String insertTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DomainServiceException
    {
        // check param
        if (null == tfriendinfoApply)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tfriendinfoApplyDS.insertTFriendinfoApply(tfriendinfoApply);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tfriendinfoApply success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoApplyList);
        if (null == tfriendinfoApplyList || tfriendinfoApplyList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoApplyDS.insertTFriendinfoApplyList(tfriendinfoApplyList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tfriendinfoApplyList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DomainServiceException
    {
        // check param
        if (tfriendinfoApply == null || tfriendinfoApply.getApplyindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoApplyDS.updateTFriendinfoApply(tfriendinfoApply);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tfriendinfoApply success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoApplyList);
        if (null == tfriendinfoApplyList || tfriendinfoApplyList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoApplyDS.updateTFriendinfoApplyList(tfriendinfoApplyList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tfriendinfoApplyList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DomainServiceException
    {
        // check param
        if (tfriendinfoApply == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoApplyDS.removeTFriendinfoApply(tfriendinfoApply);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tfriendinfoApply success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTFriendinfoApplyList(List<TFriendinfoApply> tfriendinfoApplyList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoApplyList);
        if (tfriendinfoApplyList == null || tfriendinfoApplyList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoApplyDS.removeTFriendinfoApplyList(tfriendinfoApplyList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tfriendinfoApplyList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TFriendinfoApply getTFriendinfoApply(TFriendinfoApply tfriendinfoApply) throws DomainServiceException
    {
        // check param
        if (tfriendinfoApply == null || tfriendinfoApply.getApplyindex() == null)
        {
            return null;
        }
        return tfriendinfoApplyDS.getTFriendinfoApply(tfriendinfoApply);
    }

    public TFriendinfoApply getTFriendinfoApplyByIndex(Long applyindex) throws DomainServiceException
    {
        // check param
        if (applyindex == null)
        {
            return null;
        }
        return tfriendinfoApplyDS.getTFriendinfoApplyByIndex(applyindex);
    }

    public List<TFriendinfoApply> getTFriendinfoApplyByCond(TFriendinfoApply tfriendinfoApply)
            throws DomainServiceException
    {
        return tfriendinfoApplyDS.getTFriendinfoApplyByCond(tfriendinfoApply);
    }

    public List<TFriendinfoApply> getTFriendinfoApplyByCondExact(TFriendinfoApply tfriendinfoApply)
            throws DomainServiceException
    {
        return tfriendinfoApplyDS.getTFriendinfoApplyByCondExact(tfriendinfoApply);
    }

    public TableDataInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tfriendinfoApplyDS.pageInfoQuery(tfriendinfoApply, start, pageSize, puEntity);
    }

}
