package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.pinke.uni.mobile.protal.bbs.service.ITArticleinfoLikeDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoLikeLS implements ITArticleinfoLikeLS
{

    private Logger log = LoggerFactory.getLogger("TArticleinfoLike", TArticleinfoLikeLS.class);

    private ITArticleinfoLikeDS tarticleinfoLikeDS;

    public void setTarticleinfoLikeDS(ITArticleinfoLikeDS tarticleinfoLikeDS)
    {
        this.tarticleinfoLikeDS = tarticleinfoLikeDS;
    }

    public String insertTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        // check param
        if (null == tarticleinfoLike)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tarticleinfoLikeDS.insertTArticleinfoLike(tarticleinfoLike);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoLike success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoLikeList);
        if (null == tarticleinfoLikeList || tarticleinfoLikeList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoLikeDS.insertTArticleinfoLikeList(tarticleinfoLikeList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoLikeList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        // check param
        if (tarticleinfoLike == null || tarticleinfoLike.getLikeindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoLikeDS.updateTArticleinfoLike(tarticleinfoLike);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoLike success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoLikeList);
        if (null == tarticleinfoLikeList || tarticleinfoLikeList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoLikeDS.updateTArticleinfoLikeList(tarticleinfoLikeList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoLikeList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        // check param
        if (tarticleinfoLike == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoLikeDS.removeTArticleinfoLike(tarticleinfoLike);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoLike success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoLikeList(List<TArticleinfoLike> tarticleinfoLikeList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoLikeList);
        if (tarticleinfoLikeList == null || tarticleinfoLikeList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoLikeDS.removeTArticleinfoLikeList(tarticleinfoLikeList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoLikeList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TArticleinfoLike getTArticleinfoLike(TArticleinfoLike tarticleinfoLike) throws DomainServiceException
    {
        // check param
        if (tarticleinfoLike == null || tarticleinfoLike.getLikeindex() == null)
        {
            return null;
        }
        return tarticleinfoLikeDS.getTArticleinfoLike(tarticleinfoLike);
    }

    public TArticleinfoLike getTArticleinfoLikeByIndex(Long likeindex) throws DomainServiceException
    {
        // check param
        if (likeindex == null)
        {
            return null;
        }
        return tarticleinfoLikeDS.getTArticleinfoLikeByIndex(likeindex);
    }

    public List<TArticleinfoLike> getTArticleinfoLikeByCond(TArticleinfoLike tarticleinfoLike)
            throws DomainServiceException
    {
        return tarticleinfoLikeDS.getTArticleinfoLikeByCond(tarticleinfoLike);
    }

    public List<TArticleinfoLike> getTArticleinfoLikeByCondExact(TArticleinfoLike tarticleinfoLike)
            throws DomainServiceException
    {
        return tarticleinfoLikeDS.getTArticleinfoLikeByCondExact(tarticleinfoLike);
    }

    public TableDataInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tarticleinfoLikeDS.pageInfoQuery(tarticleinfoLike, start, pageSize, puEntity);
    }

}
