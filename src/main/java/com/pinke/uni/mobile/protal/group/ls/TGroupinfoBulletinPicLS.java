package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.group.service.ITGroupinfoBulletinPicDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoBulletinPicLS implements ITGroupinfoBulletinPicLS
{

    private Logger log = LoggerFactory.getLogger("TGroupinfoBulletinPic", TGroupinfoBulletinPicLS.class);

    private ITGroupinfoBulletinPicDS tgroupinfoBulletinPicDS;

    public void setTgroupinfoBulletinPicDS(ITGroupinfoBulletinPicDS tgroupinfoBulletinPicDS)
    {
        this.tgroupinfoBulletinPicDS = tgroupinfoBulletinPicDS;
    }

    public String insertTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        // check param
        if (null == tgroupinfoBulletinPic)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupinfoBulletinPicDS.insertTGroupinfoBulletinPic(tgroupinfoBulletinPic);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoBulletinPic success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinPicList);
        if (null == tgroupinfoBulletinPicList || tgroupinfoBulletinPicList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinPicDS.insertTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoBulletinPicList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletinPic == null || tgroupinfoBulletinPic.getPicindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinPicDS.updateTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoBulletinPic success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinPicList);
        if (null == tgroupinfoBulletinPicList || tgroupinfoBulletinPicList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinPicDS.updateTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoBulletinPicList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletinPic == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinPicDS.removeTGroupinfoBulletinPic(tgroupinfoBulletinPic);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoBulletinPic success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinPicList);
        if (tgroupinfoBulletinPicList == null || tgroupinfoBulletinPicList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinPicDS.removeTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoBulletinPicList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupinfoBulletinPic getTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletinPic == null || tgroupinfoBulletinPic.getPicindex() == null)
        {
            return null;
        }
        return tgroupinfoBulletinPicDS.getTGroupinfoBulletinPic(tgroupinfoBulletinPic);
    }

    public TGroupinfoBulletinPic getTGroupinfoBulletinPicByIndex(Long picindex) throws DomainServiceException
    {
        // check param
        if (picindex == null)
        {
            return null;
        }
        return tgroupinfoBulletinPicDS.getTGroupinfoBulletinPicByIndex(picindex);
    }

    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        return tgroupinfoBulletinPicDS.getTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);
    }

    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCondExact(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException
    {
        return tgroupinfoBulletinPicDS.getTGroupinfoBulletinPicByCondExact(tgroupinfoBulletinPic);
    }

    public TableDataInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tgroupinfoBulletinPicDS.pageInfoQuery(tgroupinfoBulletinPic, start, pageSize, puEntity);
    }

}
