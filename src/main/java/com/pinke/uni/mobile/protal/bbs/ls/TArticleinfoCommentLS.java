package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.pinke.uni.mobile.protal.bbs.service.ITArticleinfoCommentDS;
import com.pinke.uni.mobile.protal.bbs.service.ITArticleinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoCommentLS implements ITArticleinfoCommentLS
{

    private Logger log = LoggerFactory.getLogger("TArticleinfoComment", TArticleinfoCommentLS.class);

    private ITArticleinfoCommentDS tarticleinfoCommentDS;
    private ITArticleinfoDS tarticleinfoDS;

    public void setTarticleinfoCommentDS(ITArticleinfoCommentDS tarticleinfoCommentDS)
    {
        this.tarticleinfoCommentDS = tarticleinfoCommentDS;
    }

    public ITArticleinfoDS getTarticleinfoDS()
    {
        return tarticleinfoDS;
    }

    public void setTarticleinfoDS(ITArticleinfoDS tarticleinfoDS)
    {
        this.tarticleinfoDS = tarticleinfoDS;
    }

    public String insertTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException
    {
        // check param
        if (null == tarticleinfoComment || tarticleinfoComment.getArticleindex() == null)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tarticleinfoCommentDS.insertTArticleinfoComment(tarticleinfoComment);
        if (Tools.isNotNull(tarticleinfoComment.getArticleindex() + ""))
        {
            TArticleinfo tarticleinfo = new TArticleinfo();
            tarticleinfo.setArticleindex(tarticleinfoComment.getArticleindex());
            tarticleinfo.setLastposttime(tarticleinfoComment.getCreatetime());
            tarticleinfoDS.updateTArticleinfo(tarticleinfo);

        }

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoComment success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoCommentList);
        if (null == tarticleinfoCommentList || tarticleinfoCommentList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoCommentDS.insertTArticleinfoCommentList(tarticleinfoCommentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tarticleinfoCommentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException
    {
        // check param
        if (tarticleinfoComment == null || tarticleinfoComment.getCommentindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoCommentDS.updateTArticleinfoComment(tarticleinfoComment);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoComment success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoCommentList);
        if (null == tarticleinfoCommentList || tarticleinfoCommentList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoCommentDS.updateTArticleinfoCommentList(tarticleinfoCommentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tarticleinfoCommentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException
    {
        // check param
        if (tarticleinfoComment == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoCommentDS.removeTArticleinfoComment(tarticleinfoComment);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoComment success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tarticleinfoCommentList);
        if (tarticleinfoCommentList == null || tarticleinfoCommentList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tarticleinfoCommentDS.removeTArticleinfoCommentList(tarticleinfoCommentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tarticleinfoCommentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TArticleinfoComment getTArticleinfoComment(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException
    {
        // check param
        if (tarticleinfoComment == null || tarticleinfoComment.getCommentindex() == null)
        {
            return null;
        }
        return tarticleinfoCommentDS.getTArticleinfoComment(tarticleinfoComment);
    }

    public TArticleinfoComment getTArticleinfoCommentByIndex(Long commentindex) throws DomainServiceException
    {
        // check param
        if (commentindex == null)
        {
            return null;
        }
        return tarticleinfoCommentDS.getTArticleinfoCommentByIndex(commentindex);
    }

    public List<TArticleinfoComment> getTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException
    {
        return tarticleinfoCommentDS.getTArticleinfoCommentByCond(tarticleinfoComment);
    }

    public List<TArticleinfoComment> getTArticleinfoCommentByCondExact(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException
    {
        return tarticleinfoCommentDS.getTArticleinfoCommentByCondExact(tarticleinfoComment);
    }

    public TableDataInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tarticleinfoCommentDS.pageInfoQuery(tarticleinfoComment, start, pageSize, puEntity);
    }

    public TableDataInfo pageInfoQueryExtends(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tarticleinfoCommentDS.pageInfoQueryExtends(tarticleinfoComment, start, pageSize, puEntity);
    }

}
