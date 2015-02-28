package com.pinke.uni.lottery.service;

import com.pinke.uni.lottery.dao.ILotteryOrderRecordDAO;
import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class LotteryOrderRecordDS extends DynamicObjectBaseDS implements ILotteryOrderRecordDS {
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ILotteryOrderRecordDAO dao = null;

    public void setDao(ILotteryOrderRecordDAO dao) {
        this.dao = dao;
    }

    public void insertLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("insert lotteryOrderRecord starting...");
        try {
            if (null == lotteryOrderRecord.getOrderindex())
            {
                lotteryOrderRecord.setOrderindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("lottery_order_record"));
            }
            dao.insertLotteryOrderRecord(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert lotteryOrderRecord end");
    }

    public void insertLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        log.debug("insert lotteryOrderRecordList by pk starting...");
        if (null == lotteryOrderRecordList || lotteryOrderRecordList.size() == 0) {
            log.debug("there is no datas in lotteryOrderRecordList");
            return;
        }
        try {
            int listSize = lotteryOrderRecordList.size();
            Long index = (Long) Sequence.getSequence("lottery_order_record", listSize);
            for (int i = 0; i < lotteryOrderRecordList.size(); i++) {
                if (lotteryOrderRecordList.get(i) != null) {
                    if (null == lotteryOrderRecordList.get(i).getOrderindex()) {
                        Long primaryindex = Long.valueOf(index + i);
                        lotteryOrderRecordList.get(i).setOrderindex(primaryindex);
                    }
                }
            }
            dao.insertLotteryOrderRecordList(lotteryOrderRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert lotteryOrderRecordList by pk end");
    }

    public void updateLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("update lotteryOrderRecord by pk starting...");
        try {
            dao.updateLotteryOrderRecord(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryOrderRecord by pk end");
    }

    public void updateLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        log.debug("update lotteryOrderRecordList by pk starting...");
        if (null == lotteryOrderRecordList || lotteryOrderRecordList.size() == 0) {
            log.debug("there is no datas in lotteryOrderRecordList");
            return;
        }
        try {
            dao.updateLotteryOrderRecordList(lotteryOrderRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryOrderRecordList by pk end");
    }

    public void updateLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("update lotteryOrderRecord by condition starting...");
        try {
            dao.updateLotteryOrderRecordByCond(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryOrderRecord by condition end");
    }

    public void removeLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("remove lotteryOrderRecord by pk starting...");
        try {
            dao.deleteLotteryOrderRecord(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove lotteryOrderRecord by pk end");
    }

    public void removeLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        log.debug("remove lotteryOrderRecordList by pk starting...");
        if (null == lotteryOrderRecordList || lotteryOrderRecordList.size() == 0) {
            log.debug("there is no datas in lotteryOrderRecordList");
            return;
        }
        try {
            dao.deleteLotteryOrderRecordList(lotteryOrderRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove lotteryOrderRecordList by pk end");
    }

    public LotteryOrderRecord getLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("get lotteryOrderRecord by pk starting...");
        LotteryOrderRecord rsObj = null;
        try {
            rsObj = dao.getLotteryOrderRecord(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get lotteryOrderRecordList by pk end");
        return rsObj;
    }

    public LotteryOrderRecord getLotteryOrderRecordByOrderid(String orderid) throws DomainServiceException {
        log.debug("get lotteryOrderRecord by orderid starting...");
        LotteryOrderRecord rsObj = new LotteryOrderRecord();
        rsObj.setOrderid(orderid);
        try {
            List<LotteryOrderRecord> list = dao.getLotteryOrderRecordByCond(rsObj);
            if(CollectionUtils.isNotEmpty(list) && list.size() == 1){
                rsObj = list.get(0);
            }else{
                rsObj = null;
            }
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get lotteryOrderRecord by bulindex end");
        return rsObj;
    }

    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        log.debug("get lotteryOrderRecord by condition starting...");
        List<LotteryOrderRecord> rsList = null;
        try {
            rsList = dao.getLotteryOrderRecordByCond(lotteryOrderRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get lotteryOrderRecord by condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize) throws DomainServiceException {
        log.debug("get lotteryOrderRecord page info by condition starting...");
        PageInfo pageInfo = null;
        try {
            pageInfo = dao.pageInfoQuery(lotteryOrderRecord, start, pageSize);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<LotteryOrderRecord>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get lotteryOrderRecord page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException {
        log.debug("get lotteryOrderRecord page info by condition starting...");
        PageInfo pageInfo = null;
        try {
            pageInfo = dao.pageInfoQuery(lotteryOrderRecord, start, pageSize, puEntity);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<LotteryOrderRecord>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get lotteryOrderRecord page info by condition end");
        return tableInfo;
    }

}
