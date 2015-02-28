package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.pinke.uni.mobile.protal.bbs.service.ITArticleinfoShareDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoShareLS implements ITArticleinfoShareLS
{

    private Logger log = LoggerFactory.getLogger("TArticleinfoShare", TArticleinfoShareLS.class);

    private ITArticleinfoShareDS tarticleinfoShareDS;

    public void setTarticleinfoShareDS(ITArticleinfoShareDS tarticleinfoShareDS)
    {
        this.tarticleinfoShareDS = tarticleinfoShareDS;
    }

    public String insertTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        // check param
        if (null == tarticleinfoShare)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tarticleinfoShareDS.insertTArticleinfoShare(tarticleinfoShare);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoShare success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoShareList);
        if (null == tarticleinfoShareList || tarticleinfoShareList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoShareDS.insertTArticleinfoShareList(tarticleinfoShareList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoShareList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        // check param
        if (tarticleinfoShare == null || tarticleinfoShare.getShareindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoShareDS.updateTArticleinfoShare(tarticleinfoShare);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoShare success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoShareList);
        if (null == tarticleinfoShareList || tarticleinfoShareList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoShareDS.updateTArticleinfoShareList(tarticleinfoShareList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoShareList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        // check param
        if (tarticleinfoShare == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoShareDS.removeTArticleinfoShare(tarticleinfoShare);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoShare success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoShareList(List<TArticleinfoShare> tarticleinfoShareList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoShareList);
        if (tarticleinfoShareList == null || tarticleinfoShareList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoShareDS.removeTArticleinfoShareList(tarticleinfoShareList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoShareList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TArticleinfoShare getTArticleinfoShare(TArticleinfoShare tarticleinfoShare) throws DomainServiceException
    {
        // check param
        if (tarticleinfoShare == null || tarticleinfoShare.getShareindex() == null)
        {
            return null;
        }
        return tarticleinfoShareDS.getTArticleinfoShare(tarticleinfoShare);
    }

    public TArticleinfoShare getTArticleinfoShareByIndex(Long shareindex) throws DomainServiceException
    {
        // check param
        if (shareindex == null)
        {
            return null;
        }
        return tarticleinfoShareDS.getTArticleinfoShareByIndex(shareindex);
    }

    public List<TArticleinfoShare> getTArticleinfoShareByCond(TArticleinfoShare tarticleinfoShare)
            throws DomainServiceException
    {
        return tarticleinfoShareDS.getTArticleinfoShareByCond(tarticleinfoShare);
    }

    public List<TArticleinfoShare> getTArticleinfoShareByCondExact(TArticleinfoShare tarticleinfoShare)
            throws DomainServiceException
    {
        return tarticleinfoShareDS.getTArticleinfoShareByCondExact(tarticleinfoShare);
    }

    public TableDataInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tarticleinfoShareDS.pageInfoQuery(tarticleinfoShare, start, pageSize, puEntity);
    }

}
