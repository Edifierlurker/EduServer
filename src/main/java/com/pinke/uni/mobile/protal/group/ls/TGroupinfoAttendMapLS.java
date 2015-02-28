package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.group.service.ITGroupinfoAttendMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoAttendMapLS implements ITGroupinfoAttendMapLS
{

    private Logger log = LoggerFactory.getLogger("TGroupinfoAttendMap", TGroupinfoAttendMapLS.class);

    private ITGroupinfoAttendMapDS tgroupinfoAttendMapDS;

    public void setTgroupinfoAttendMapDS(ITGroupinfoAttendMapDS tgroupinfoAttendMapDS)
    {
        this.tgroupinfoAttendMapDS = tgroupinfoAttendMapDS;
    }

    public String insertTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException
    {
        // check param
        if (null == tgroupinfoAttendMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupinfoAttendMapDS.insertTGroupinfoAttendMap(tgroupinfoAttendMap);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoAttendMapList);
        if (null == tgroupinfoAttendMapList || tgroupinfoAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoAttendMapDS.insertTGroupinfoAttendMapList(tgroupinfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException
    {
        // check param
        if (tgroupinfoAttendMap == null || tgroupinfoAttendMap.getMapindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoAttendMapDS.updateTGroupinfoAttendMap(tgroupinfoAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoAttendMapList);
        if (null == tgroupinfoAttendMapList || tgroupinfoAttendMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoAttendMapDS.updateTGroupinfoAttendMapList(tgroupinfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException
    {
        // check param
        if (tgroupinfoAttendMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoAttendMapDS.removeTGroupinfoAttendMap(tgroupinfoAttendMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoAttendMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoAttendMapList);
        if (tgroupinfoAttendMapList == null || tgroupinfoAttendMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoAttendMapDS.removeTGroupinfoAttendMapList(tgroupinfoAttendMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoAttendMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupinfoAttendMap getTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException
    {
        // check param
        if (tgroupinfoAttendMap == null )
        {
            return null;
        }
        return tgroupinfoAttendMapDS.getTGroupinfoAttendMap(tgroupinfoAttendMap);
    }

    public TGroupinfoAttendMap getTGroupinfoAttendMapByIndex(Long mapindex) throws DomainServiceException
    {
        // check param
        if (mapindex == null)
        {
            return null;
        }
        return tgroupinfoAttendMapDS.getTGroupinfoAttendMapByIndex(mapindex);
    }

    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException
    {
        return tgroupinfoAttendMapDS.getTGroupinfoAttendMapByCond(tgroupinfoAttendMap);
    }
    
    public List<TGroupinfoAttendMap> getTGroupinfoAttendChat(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException
    {
        return tgroupinfoAttendMapDS.getTGroupinfoAttendChat(tgroupinfoAttendMap);
    }

    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCondExact(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException
    {
        return tgroupinfoAttendMapDS.getTGroupinfoAttendMapByCondExact(tgroupinfoAttendMap);
    }

    public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tgroupinfoAttendMapDS.pageInfoQuery(tgroupinfoAttendMap, start, pageSize, puEntity);
    }

}
