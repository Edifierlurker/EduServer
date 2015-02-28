package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.pinke.uni.mobile.protal.bbs.service.ITBulletinDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBulletinLS implements ITBulletinLS
{

    private Logger log = LoggerFactory.getLogger("TBulletin", TBulletinLS.class);

    private ITBulletinDS tbulletinDS;

    public void setTbulletinDS(ITBulletinDS tbulletinDS)
    {
        this.tbulletinDS = tbulletinDS;
    }

    public String insertTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        // check param
        if (null == tbulletin)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tbulletinDS.insertTBulletin(tbulletin);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbulletinList);
        if (null == tbulletinList || tbulletinList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbulletinDS.insertTBulletinList(tbulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        // check param
        if (tbulletin == null || tbulletin.getBulindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbulletinDS.updateTBulletin(tbulletin);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbulletinList);
        if (null == tbulletinList || tbulletinList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbulletinDS.updateTBulletinList(tbulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        // check param
        if (tbulletin == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbulletinDS.removeTBulletin(tbulletin);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBulletinList(List<TBulletin> tbulletinList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbulletinList);
        if (tbulletinList == null || tbulletinList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbulletinDS.removeTBulletinList(tbulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TBulletin getTBulletin(TBulletin tbulletin) throws DomainServiceException
    {
        // check param
        if (tbulletin == null || tbulletin.getBulindex() == null)
        {
            return null;
        }
        return tbulletinDS.getTBulletin(tbulletin);
    }

    public TBulletin getTBulletinByIndex(Long bulindex) throws DomainServiceException
    {
        // check param
        if (bulindex == null)
        {
            return null;
        }
        return tbulletinDS.getTBulletinByIndex(bulindex);
    }

    public List<TBulletin> getTBulletinByCond(TBulletin tbulletin) throws DomainServiceException
    {
        return tbulletinDS.getTBulletinByCond(tbulletin);
    }

    public List<TBulletin> getTBulletinByCondExact(TBulletin tbulletin) throws DomainServiceException
    {
        return tbulletinDS.getTBulletinByCondExact(tbulletin);
    }

    public TableDataInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tbulletinDS.pageInfoQuery(tbulletin, start, pageSize, puEntity);
    }

}
