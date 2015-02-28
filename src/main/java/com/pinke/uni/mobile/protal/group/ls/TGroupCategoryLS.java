package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.pinke.uni.mobile.protal.group.service.ITGroupCategoryDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupCategoryLS implements ITGroupCategoryLS
{

    private Logger log = LoggerFactory.getLogger("TGroupCategory", TGroupCategoryLS.class);

    private ITGroupCategoryDS tgroupCategoryDS;

    public void setTgroupCategoryDS(ITGroupCategoryDS tgroupCategoryDS)
    {
        this.tgroupCategoryDS = tgroupCategoryDS;
    }

    public String insertTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        // check param
        if (null == tgroupCategory)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupCategoryDS.insertTGroupCategory(tgroupCategory);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupCategory success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryList);
        if (null == tgroupCategoryList || tgroupCategoryList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryDS.insertTGroupCategoryList(tgroupCategoryList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupCategoryList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        // check param
        if (tgroupCategory == null || tgroupCategory.getCategoryindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryDS.updateTGroupCategory(tgroupCategory);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupCategory success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryList);
        if (null == tgroupCategoryList || tgroupCategoryList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryDS.updateTGroupCategoryList(tgroupCategoryList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupCategoryList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        // check param
        if (tgroupCategory == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryDS.removeTGroupCategory(tgroupCategory);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupCategory success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupCategoryList(List<TGroupCategory> tgroupCategoryList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupCategoryList);
        if (tgroupCategoryList == null || tgroupCategoryList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupCategoryDS.removeTGroupCategoryList(tgroupCategoryList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupCategoryList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupCategory getTGroupCategory(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        // check param
        if (tgroupCategory == null || tgroupCategory.getCategoryindex() == null)
        {
            return null;
        }
        return tgroupCategoryDS.getTGroupCategory(tgroupCategory);
    }

    public TGroupCategory getTGroupCategoryByIndex(Long categoryindex) throws DomainServiceException
    {
        // check param
        if (categoryindex == null)
        {
            return null;
        }
        return tgroupCategoryDS.getTGroupCategoryByIndex(categoryindex);
    }

    public List<TGroupCategory> getTGroupCategoryByCond(TGroupCategory tgroupCategory) throws DomainServiceException
    {
        return tgroupCategoryDS.getTGroupCategoryByCond(tgroupCategory);
    }

    public List<TGroupCategory> getTGroupCategoryByCondExact(TGroupCategory tgroupCategory)
            throws DomainServiceException
    {
        return tgroupCategoryDS.getTGroupCategoryByCondExact(tgroupCategory);
    }

    public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tgroupCategoryDS.pageInfoQuery(tgroupCategory, start, pageSize, puEntity);
    }

}
