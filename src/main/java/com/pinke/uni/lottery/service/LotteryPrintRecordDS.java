package com.pinke.uni.lottery.service;

import com.pinke.uni.lottery.dao.ILotteryPrintRecordDAO;
import com.pinke.uni.lottery.model.LotteryPrintRecord;
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

public class LotteryPrintRecordDS extends DynamicObjectBaseDS implements ILotteryPrintRecordDS {
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private ILotteryPrintRecordDAO dao = null;

    public void setDao(ILotteryPrintRecordDAO dao) {
        this.dao = dao;
    }

    public void insertLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("insert lotteryPrintRecord starting...");
        try {
            if (null == lotteryPrintRecord.getOrderindex())
            {
                lotteryPrintRecord.setOrderindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("lottery_order_record"));
            }
            dao.insertLotteryPrintRecord(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert lotteryPrintRecord end");
    }

    public void insertLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        log.debug("insert lotteryPrintRecordList by pk starting...");
        if (null == lotteryPrintRecordList || lotteryPrintRecordList.size() == 0) {
            log.debug("there is no datas in lotteryPrintRecordList");
            return;
        }
        try {
            int listSize = lotteryPrintRecordList.size();
            Long index = (Long) Sequence.getSequence("lottery_order_record", listSize);
            for (int i = 0; i < lotteryPrintRecordList.size(); i++) {
                if (lotteryPrintRecordList.get(i) != null) {
                    if (null == lotteryPrintRecordList.get(i).getOrderindex()) {
                        Long primaryindex = Long.valueOf(index + i);
                        lotteryPrintRecordList.get(i).setOrderindex(primaryindex);
                    }
                }
            }
            dao.insertLotteryPrintRecordList(lotteryPrintRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert lotteryPrintRecordList by pk end");
    }

    public void updateLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("update lotteryPrintRecord by pk starting...");
        try {
            dao.updateLotteryPrintRecord(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryPrintRecord by pk end");
    }

    public void updateLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        log.debug("update lotteryPrintRecordList by pk starting...");
        if (null == lotteryPrintRecordList || lotteryPrintRecordList.size() == 0) {
            log.debug("there is no datas in lotteryPrintRecordList");
            return;
        }
        try {
            dao.updateLotteryPrintRecordList(lotteryPrintRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryPrintRecordList by pk end");
    }

    public void updateLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("update lotteryPrintRecord by condition starting...");
        try {
            dao.updateLotteryPrintRecordByCond(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update lotteryPrintRecord by condition end");
    }

    public void removeLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("remove lotteryPrintRecord by pk starting...");
        try {
            dao.deleteLotteryPrintRecord(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove lotteryPrintRecord by pk end");
    }

    public void removeLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        log.debug("remove lotteryPrintRecordList by pk starting...");
        if (null == lotteryPrintRecordList || lotteryPrintRecordList.size() == 0) {
            log.debug("there is no datas in lotteryPrintRecordList");
            return;
        }
        try {
            dao.deleteLotteryPrintRecordList(lotteryPrintRecordList);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove lotteryPrintRecordList by pk end");
    }

    public LotteryPrintRecord getLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("get lotteryPrintRecord by pk starting...");
        LotteryPrintRecord rsObj = null;
        try {
            rsObj = dao.getLotteryPrintRecord(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get lotteryPrintRecordList by pk end");
        return rsObj;
    }

    public LotteryPrintRecord getLotteryPrintRecordByPrintid(String printid) throws DomainServiceException {
        log.debug("get lotteryPrintRecord by bulindex starting...");
        LotteryPrintRecord rsObj = new LotteryPrintRecord();
        rsObj.setPrintid(printid);
        try {
            List<LotteryPrintRecord> list = dao.getLotteryPrintRecordByCond(rsObj);
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
        log.debug("get lotteryPrintRecord by bulindex end");
        return rsObj;
    }

    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        log.debug("get lotteryPrintRecord by condition starting...");
        List<LotteryPrintRecord> rsList = null;
        try {
            rsList = dao.getLotteryPrintRecordByCond(lotteryPrintRecord);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get lotteryPrintRecord by condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize) throws DomainServiceException {
        log.debug("get lotteryPrintRecord page info by condition starting...");
        PageInfo pageInfo = null;
        try {
            pageInfo = dao.pageInfoQuery(lotteryPrintRecord, start, pageSize);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<LotteryPrintRecord>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get lotteryPrintRecord page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException {
        log.debug("get lotteryPrintRecord page info by condition starting...");
        PageInfo pageInfo = null;
        try {
            pageInfo = dao.pageInfoQuery(lotteryPrintRecord, start, pageSize, puEntity);
        } catch (DAOException daoEx) {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        } catch (Exception e) {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<LotteryPrintRecord>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get lotteryPrintRecord page info by condition end");
        return tableInfo;
    }

}
