package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.pinke.uni.mobile.protal.bbs.service.ITFriendinfoDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TFriendinfoLS implements ITFriendinfoLS
{

    private Logger log = LoggerFactory.getLogger("TFriendinfo", TFriendinfoLS.class);

    private ITFriendinfoDS tfriendinfoDS;

    public void setTfriendinfoDS(ITFriendinfoDS tfriendinfoDS)
    {
        this.tfriendinfoDS = tfriendinfoDS;
    }

    public String insertTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        // check param
        if (null == tfriendinfo)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tfriendinfoDS.insertTFriendinfo(tfriendinfo);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tfriendinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoList);
        if (null == tfriendinfoList || tfriendinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.insertTFriendinfoList(tfriendinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tfriendinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        // check param
        if (tfriendinfo == null || tfriendinfo.getMapindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.updateTFriendinfo(tfriendinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tfriendinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTFriendinfoExtends(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        // check param
        if (tfriendinfo == null || tfriendinfo.getFriendindex() == null || tfriendinfo.getUserindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.updateTFriendinfoByCond(tfriendinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tfriendinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoList);
        if (null == tfriendinfoList || tfriendinfoList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.updateTFriendinfoList(tfriendinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tfriendinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        // check param
        if (tfriendinfo == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.removeTFriendinfo(tfriendinfo);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tfriendinfo success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tfriendinfoList);
        if (tfriendinfoList == null || tfriendinfoList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tfriendinfoDS.removeTFriendinfoList(tfriendinfoList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tfriendinfoList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TFriendinfo getTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        // check param
        if (tfriendinfo == null)
        {
            return null;
        }
        return tfriendinfoDS.getTFriendinfo(tfriendinfo);
    }

    public TFriendinfo getTFriendinfoByIndex(Long mapindex) throws DomainServiceException
    {
        // check param
        if (mapindex == null)
        {
            return null;
        }
        return tfriendinfoDS.getTFriendinfoByIndex(mapindex);
    }

    public List<TFriendinfo> getTFriendinfoByCond(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        return tfriendinfoDS.getTFriendinfoByCond(tfriendinfo);
    }

    public List<TFriendinfo> getTFriendinfoByCondExact(TFriendinfo tfriendinfo) throws DomainServiceException
    {
        return tfriendinfoDS.getTFriendinfoByCondExact(tfriendinfo);
    }

    public TableDataInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tfriendinfoDS.pageInfoQuery(tfriendinfo, start, pageSize, puEntity);
    }

}
