package com.pinke.uni.lottery.dao;

import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

import java.util.List;

public class LotteryPrintRecordDAO extends DynamicObjectMispDAO implements ILotteryPrintRecordDAO {
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("insert lotteryPrintRecord starting...");
        super.insert("insertLotteryPrintRecord", lotteryPrintRecord);
        log.debug("insert lotteryPrintRecord end");
    }

    public void insertLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException {
        log.debug("insert lotteryPrintRecordList starting...");
        if (null != lotteryPrintRecordList) {
            super.insertBatch("insertLotteryPrintRecord", lotteryPrintRecordList);
        }
        log.debug("insert lotteryPrintRecordList end");
    }

    public void updateLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("update lotteryPrintRecord by pk starting...");
        super.update("updateLotteryPrintRecord", lotteryPrintRecord);
        log.debug("update lotteryPrintRecord by pk end");
    }

    public void updateLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException {
        log.debug("update lotteryPrintRecordList by pk starting...");
        super.updateBatch("updateLotteryPrintRecord", lotteryPrintRecordList);
        log.debug("update lotteryPrintRecordList by pk end");
    }

    public void updateLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("update lotteryPrintRecord by conditions starting...");
        super.update("updateLotteryPrintRecordByCond", lotteryPrintRecord);
        log.debug("update lotteryPrintRecord by conditions end");
    }

    public void deleteLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("delete lotteryPrintRecord by pk starting...");
        super.delete("deleteLotteryPrintRecord", lotteryPrintRecord);
        log.debug("delete lotteryPrintRecord by pk end");
    }

    public void deleteLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException {
        log.debug("delete lotteryPrintRecordList by pk starting...");
        super.deleteBatch("deleteLotteryPrintRecord", lotteryPrintRecordList);
        log.debug("delete lotteryPrintRecordList by pk end");
    }

    public LotteryPrintRecord getLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("query lotteryPrintRecord starting...");
        LotteryPrintRecord resultObj = (LotteryPrintRecord) super.queryForObject("getLotteryPrintRecord", lotteryPrintRecord);
        log.debug("query lotteryPrintRecord end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DAOException {
        log.debug("query lotteryPrintRecord by condition starting...");
        List<LotteryPrintRecord> rList = (List<LotteryPrintRecord>) super.queryForList("queryLotteryPrintRecordListByCond", lotteryPrintRecord);
        log.debug("query lotteryPrintRecord by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord, PageUtilEntity puEntity) throws DAOException {
        log.debug("query lotteryPrintRecord by condition starting...");
        List<LotteryPrintRecord> rList = (List<LotteryPrintRecord>) super.queryForList("queryLotteryPrintRecordListByCond", lotteryPrintRecord, puEntity);
        log.debug("query lotteryPrintRecord by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize) throws DAOException {
        log.debug("page query lotteryPrintRecord by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryLotteryPrintRecordListCntByCond", lotteryPrintRecord)).intValue();
        if (totalCnt > 0) {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<LotteryPrintRecord> rsList = (List<LotteryPrintRecord>) super.pageQuery("queryLotteryPrintRecordListByCond", lotteryPrintRecord, start,
                    fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        } else {
            pageInfo = new PageInfo();
        }
        log.debug("page query lotteryPrintRecord by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException {
        return super.indexPageQuery("queryLotteryPrintRecordListByCond", "queryLotteryPrintRecordListCntByCond", lotteryPrintRecord, start,
                pageSize, puEntity);
    }

}