package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.pinke.uni.mobile.protal.group.service.ITGroupCategoryMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupCategoryMapLS implements ITGroupCategoryMapLS
{

    private Logger log = LoggerFactory.getLogger("TGroupCategoryMap", TGroupCategoryMapLS.class);

    private ITGroupCategoryMapDS tgroupCategoryMapDS;

    public void setTgroupCategoryMapDS(ITGroupCategoryMapDS tgroupCategoryMapDS)
    {
        this.tgroupCategoryMapDS = tgroupCategoryMapDS;
    }

    public String insertTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DomainServiceException
    {
        // check param
        if (null == tgroupCategoryMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupCategoryMapDS.insertTGroupCategoryMap(tgroupCategoryMap);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupCategoryMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryMapList);
        if (null == tgroupCategoryMapList || tgroupCategoryMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryMapDS.insertTGroupCategoryMapList(tgroupCategoryMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupCategoryMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DomainServiceException
    {
        // check param
        if (tgroupCategoryMap == null || tgroupCategoryMap.getMapindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryMapDS.updateTGroupCategoryMap(tgroupCategoryMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupCategoryMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryMapList);
        if (null == tgroupCategoryMapList || tgroupCategoryMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryMapDS.updateTGroupCategoryMapList(tgroupCategoryMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupCategoryMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DomainServiceException
    {
        // check param
        if (tgroupCategoryMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryMapDS.removeTGroupCategoryMap(tgroupCategoryMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupCategoryMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupCategoryMapList(List<TGroupCategoryMap> tgroupCategoryMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryMapList);
        if (tgroupCategoryMapList == null || tgroupCategoryMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryMapDS.removeTGroupCategoryMapList(tgroupCategoryMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupCategoryMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupCategoryMap getTGroupCategoryMap(TGroupCategoryMap tgroupCategoryMap) throws DomainServiceException
    {
        // check param
        if (tgroupCategoryMap == null || tgroupCategoryMap.getMapindex() == null)
        {
            return null;
        }
        return tgroupCategoryMapDS.getTGroupCategoryMap(tgroupCategoryMap);
    }

    public TGroupCategoryMap getTGroupCategoryMapByIndex(Long mapindex) throws DomainServiceException
    {
        // check param
        if (mapindex == null)
        {
            return null;
        }
        return tgroupCategoryMapDS.getTGroupCategoryMapByIndex(mapindex);
    }

    public List<TGroupCategoryMap> getTGroupCategoryMapByCond(TGroupCategoryMap tgroupCategoryMap)
            throws DomainServiceException
    {
        return tgroupCategoryMapDS.getTGroupCategoryMapByCond(tgroupCategoryMap);
    }

    public List<TGroupCategoryMap> getTGroupCategoryMapByCondExact(TGroupCategoryMap tgroupCategoryMap)
            throws DomainServiceException
    {
        return tgroupCategoryMapDS.getTGroupCategoryMapByCondExact(tgroupCategoryMap);
    }

    public TableDataInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tgroupCategoryMapDS.pageInfoQuery(tgroupCategoryMap, start, pageSize, puEntity);
    }

}
