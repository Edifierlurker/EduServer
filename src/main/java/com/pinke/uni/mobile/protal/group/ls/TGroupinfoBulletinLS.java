package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.group.service.ITGroupinfoBulletinDS;
import com.pinke.uni.mobile.protal.group.service.ITGroupinfoBulletinPicDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoBulletinLS implements ITGroupinfoBulletinLS
{

    private Logger log = LoggerFactory.getLogger("TGroupinfoBulletin", TGroupinfoBulletinLS.class);

    private ITGroupinfoBulletinDS tgroupinfoBulletinDS;
    private ITGroupinfoBulletinPicDS tgroupinfoBulletinPicDS;

    public void setTgroupinfoBulletinDS(ITGroupinfoBulletinDS tgroupinfoBulletinDS)
    {
        this.tgroupinfoBulletinDS = tgroupinfoBulletinDS;
    }

    public String insertTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        // check param
        if (null == tgroupinfoBulletin)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tgroupinfoBulletinDS.insertTGroupinfoBulletin(tgroupinfoBulletin);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoBulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinList);
        if (null == tgroupinfoBulletinList || tgroupinfoBulletinList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinDS.insertTGroupinfoBulletinList(tgroupinfoBulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tgroupinfoBulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getBulletinidnex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinDS.updateTGroupinfoBulletin(tgroupinfoBulletin);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoBulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinList);
        if (null == tgroupinfoBulletinList || tgroupinfoBulletinList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinDS.updateTGroupinfoBulletinList(tgroupinfoBulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tgroupinfoBulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin) throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getBulletinidnex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinDS.removeTGroupinfoBulletin(tgroupinfoBulletin);
        TGroupinfoBulletinPic tgroupinfoBulletinPic = new TGroupinfoBulletinPic();
        tgroupinfoBulletinPic.setBulletinidnex(tgroupinfoBulletin.getBulletinidnex());
        tgroupinfoBulletinPic.setStatus(1);
        List<TGroupinfoBulletinPic> list = tgroupinfoBulletinPicDS
                .getTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);
        if (list != null && list.size() > 0)
        {
//            for (int i = 0; i < list.size(); i++)
//            {
//                String dstPath = list.get(i).getIconurl();
//                File file = new File(dstPath);
//                if (file.exists())
//                {
//                    file.delete();
//                }
//            }
            tgroupinfoBulletinPicDS.removeTGroupinfoBulletinPicList(list);
        }

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoBulletin success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTGroupinfoBulletinList(List<TGroupinfoBulletin> tgroupinfoBulletinList)
            throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tgroupinfoBulletinList);
        if (tgroupinfoBulletinList == null || tgroupinfoBulletinList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tgroupinfoBulletinDS.removeTGroupinfoBulletinList(tgroupinfoBulletinList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tgroupinfoBulletinList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TGroupinfoBulletin getTGroupinfoBulletin(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        // check param
        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getBulletinidnex() == null)
        {
            return null;
        }
        return tgroupinfoBulletinDS.getTGroupinfoBulletin(tgroupinfoBulletin);
    }

    public TGroupinfoBulletin getTGroupinfoBulletinByIndex(Long bulletinidnex) throws DomainServiceException
    {
        // check param
        if (bulletinidnex == null)
        {
            return null;
        }
        return tgroupinfoBulletinDS.getTGroupinfoBulletinByIndex(bulletinidnex);
    }

    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        return tgroupinfoBulletinDS.getTGroupinfoBulletinByCond(tgroupinfoBulletin);
    }

    public List<TGroupinfoBulletin> getTGroupinfoBulletinByCondExact(TGroupinfoBulletin tgroupinfoBulletin)
            throws DomainServiceException
    {
        return tgroupinfoBulletinDS.getTGroupinfoBulletinByCondExact(tgroupinfoBulletin);
    }

    public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException
    {
        return tgroupinfoBulletinDS.pageInfoQuery(tgroupinfoBulletin, start, pageSize, puEntity);
    }

    public ITGroupinfoBulletinPicDS getTgroupinfoBulletinPicDS()
    {
        return tgroupinfoBulletinPicDS;
    }

    public void setTgroupinfoBulletinPicDS(ITGroupinfoBulletinPicDS tgroupinfoBulletinPicDS)
    {
        this.tgroupinfoBulletinPicDS = tgroupinfoBulletinPicDS;
    }

}
