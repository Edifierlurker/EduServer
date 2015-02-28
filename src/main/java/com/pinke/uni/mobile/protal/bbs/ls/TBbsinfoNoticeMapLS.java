package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.pinke.uni.mobile.protal.bbs.service.ITBbsinfoDS;
import com.pinke.uni.mobile.protal.bbs.service.ITBbsinfoNoticeMapDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TBbsinfoNoticeMapLS implements ITBbsinfoNoticeMapLS
{

    private Logger log = LoggerFactory.getLogger("TBbsinfoNoticeMap", TBbsinfoNoticeMapLS.class);

    private ITBbsinfoNoticeMapDS tbbsinfoNoticeMapDS;
    private ITBbsinfoDS tbbsinfoDS;

    public void setTbbsinfoNoticeMapDS(ITBbsinfoNoticeMapDS tbbsinfoNoticeMapDS)
    {
        this.tbbsinfoNoticeMapDS = tbbsinfoNoticeMapDS;
    }

    public ITBbsinfoDS getTbbsinfoDS()
    {
        return tbbsinfoDS;
    }

    public void setTbbsinfoDS(ITBbsinfoDS tbbsinfoDS)
    {
        this.tbbsinfoDS = tbbsinfoDS;
    }

    public String insertTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        // check param
        if (null == tbbsinfoNoticeMap)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.insertTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        if (Tools.isNotNull(tbbsinfoNoticeMap.getBbsindex() + ""))
        {
            TBbsinfo tbbsinfo = new TBbsinfo();
            tbbsinfo.setBbsindex(tbbsinfoNoticeMap.getBbsindex());
            tbbsinfoDS.updateTBbsinfo(tbbsinfo);
        }

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbbsinfoNoticeMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoNoticeMapList);
        if (null == tbbsinfoNoticeMapList || tbbsinfoNoticeMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.insertTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tbbsinfoNoticeMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        // check param
        if (tbbsinfoNoticeMap == null || tbbsinfoNoticeMap.getMapindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.updateTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbbsinfoNoticeMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoNoticeMapList);
        if (null == tbbsinfoNoticeMapList || tbbsinfoNoticeMapList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.updateTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tbbsinfoNoticeMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        // check param
        if (tbbsinfoNoticeMap == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.removeTBbsinfoNoticeMap(tbbsinfoNoticeMap);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbbsinfoNoticeMap success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTBbsinfoNoticeMapList(List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tbbsinfoNoticeMapList);
        if (tbbsinfoNoticeMapList == null || tbbsinfoNoticeMapList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tbbsinfoNoticeMapDS.removeTBbsinfoNoticeMapList(tbbsinfoNoticeMapList);
        for(int i=0;i<tbbsinfoNoticeMapList.size();i++){
            TBbsinfoNoticeMap temp = tbbsinfoNoticeMapList.get(0);
            if (Tools.isNotNull(temp.getBbsindex() + ""))
            {
                TBbsinfo tbbsinfo = new TBbsinfo();
                tbbsinfo.setBbsindex(temp.getBbsindex());
                tbbsinfo.setCaclecount((long) tbbsinfoNoticeMapList.size());
                tbbsinfoDS.updateTBbsinfo(tbbsinfo);
            }
        }
        
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tbbsinfoNoticeMapList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TBbsinfoNoticeMap getTBbsinfoNoticeMap(TBbsinfoNoticeMap tbbsinfoNoticeMap) throws DomainServiceException
    {
        // check param
        if (tbbsinfoNoticeMap == null || tbbsinfoNoticeMap.getMapindex() == null)
        {
            return null;
        }
        return tbbsinfoNoticeMapDS.getTBbsinfoNoticeMap(tbbsinfoNoticeMap);
    }

    public TBbsinfoNoticeMap getTBbsinfoNoticeMapByIndex(Long mapindex) throws DomainServiceException
    {
        // check param
        if (mapindex == null)
        {
            return null;
        }
        return tbbsinfoNoticeMapDS.getTBbsinfoNoticeMapByIndex(mapindex);
    }

    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond(TBbsinfoNoticeMap tbbsinfoNoticeMap)
            throws DomainServiceException
    {
        return tbbsinfoNoticeMapDS.getTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
    }

    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCondExact(TBbsinfoNoticeMap tbbsinfoNoticeMap)
            throws DomainServiceException
    {
        return tbbsinfoNoticeMapDS.getTBbsinfoNoticeMapByCondExact(tbbsinfoNoticeMap);
    }

    public TableDataInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tbbsinfoNoticeMapDS.pageInfoQuery(tbbsinfoNoticeMap, start, pageSize, puEntity);
    }

}
