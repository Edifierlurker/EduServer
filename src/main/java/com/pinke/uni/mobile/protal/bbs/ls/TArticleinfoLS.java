package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.bbs.service.ITArticleinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoLS implements ITArticleinfoLS
{

    private Logger log = LoggerFactory.getLogger("TArticleinfo", TArticleinfoLS.class);

    private ITArticleinfoDS tarticleinfoDS;

    public void setTarticleinfoDS(ITArticleinfoDS tarticleinfoDS)
    {
        this.tarticleinfoDS = tarticleinfoDS;
    }

    public String insertTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        // check param
        if (null == tarticleinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tarticleinfoDS.insertTArticleinfo(tarticleinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoList);
        if (null == tarticleinfoList || tarticleinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoDS.insertTArticleinfoList(tarticleinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        // check param
        if (tarticleinfo == null || tarticleinfo.getArticleindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoDS.updateTArticleinfo(tarticleinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoList);
        if (null == tarticleinfoList || tarticleinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoDS.updateTArticleinfoList(tarticleinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        // check param
        if (tarticleinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoDS.removeTArticleinfo(tarticleinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoList);
        if (tarticleinfoList == null || tarticleinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoDS.removeTArticleinfoList(tarticleinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TArticleinfo getTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        // check param
        if (tarticleinfo == null || tarticleinfo.getArticleindex() == null)
        {
            return null;
        }
        return tarticleinfoDS.getTArticleinfo(tarticleinfo);
    }

    public TArticleinfo getTArticleinfoByIndex(Long articleindex) throws DomainServiceException
    {
        // check param
        if (articleindex == null)
        {
            return null;
        }
        return tarticleinfoDS.getTArticleinfoByIndex(articleindex);
    }

    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        return tarticleinfoDS.getTArticleinfoByCond(tarticleinfo);
    }

    public List<TArticleinfo> getTArticleinfoByCondExact(TArticleinfo tarticleinfo) throws DomainServiceException
    {
        return tarticleinfoDS.getTArticleinfoByCondExact(tarticleinfo);
    }

    public TableDataInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tarticleinfoDS.pageInfoQuery(tarticleinfo, start, pageSize, puEntity);
    }
    public TableDataInfo pageInfoQueryExtends(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tarticleinfoDS.pageInfoQueryExtends(tarticleinfo, start, pageSize, puEntity);
    }

}
