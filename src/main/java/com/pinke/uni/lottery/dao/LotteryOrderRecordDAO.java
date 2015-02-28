package com.pinke.uni.lottery.dao;

import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

import java.util.List;

public class LotteryOrderRecordDAO extends DynamicObjectMispDAO implements ILotteryOrderRecordDAO {
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("insert lotteryOrderRecord starting...");
        super.insert("insertLotteryOrderRecord", lotteryOrderRecord);
        log.debug("insert lotteryOrderRecord end");
    }

    public void insertLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException {
        log.debug("insert lotteryOrderRecordList starting...");
        if (null != lotteryOrderRecordList) {
            super.insertBatch("insertLotteryOrderRecord", lotteryOrderRecordList);
        }
        log.debug("insert lotteryOrderRecordList end");
    }

    public void updateLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("update lotteryOrderRecord by pk starting...");
        super.update("updateLotteryOrderRecord", lotteryOrderRecord);
        log.debug("update lotteryOrderRecord by pk end");
    }

    public void updateLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException {
        log.debug("update lotteryOrderRecordList by pk starting...");
        super.updateBatch("updateLotteryOrderRecord", lotteryOrderRecordList);
        log.debug("update lotteryOrderRecordList by pk end");
    }

    public void updateLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("update lotteryOrderRecord by conditions starting...");
        super.update("updateLotteryOrderRecordByCond", lotteryOrderRecord);
        log.debug("update lotteryOrderRecord by conditions end");
    }

    public void deleteLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("delete lotteryOrderRecord by pk starting...");
        super.delete("deleteLotteryOrderRecord", lotteryOrderRecord);
        log.debug("delete lotteryOrderRecord by pk end");
    }

    public void deleteLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException {
        log.debug("delete lotteryOrderRecordList by pk starting...");
        super.deleteBatch("deleteLotteryOrderRecord", lotteryOrderRecordList);
        log.debug("delete lotteryOrderRecordList by pk end");
    }

    public LotteryOrderRecord getLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("query lotteryOrderRecord starting...");
        LotteryOrderRecord resultObj = (LotteryOrderRecord) super.queryForObject("getLotteryOrderRecord", lotteryOrderRecord);
        log.debug("query lotteryOrderRecord end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DAOException {
        log.debug("query lotteryOrderRecord by condition starting...");
        List<LotteryOrderRecord> rList = (List<LotteryOrderRecord>) super.queryForList("queryLotteryOrderRecordListByCond", lotteryOrderRecord);
        log.debug("query lotteryOrderRecord by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord, PageUtilEntity puEntity) throws DAOException {
        log.debug("query lotteryOrderRecord by condition starting...");
        List<LotteryOrderRecord> rList = (List<LotteryOrderRecord>) super.queryForList("queryLotteryOrderRecordListByCond", lotteryOrderRecord, puEntity);
        log.debug("query lotteryOrderRecord by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize) throws DAOException {
        log.debug("page query lotteryOrderRecord by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryLotteryOrderRecordListCntByCond", lotteryOrderRecord)).intValue();
        if (totalCnt > 0) {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<LotteryOrderRecord> rsList = (List<LotteryOrderRecord>) super.pageQuery("queryLotteryOrderRecordListByCond", lotteryOrderRecord, start,
                    fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        } else {
            pageInfo = new PageInfo();
        }
        log.debug("page query lotteryOrderRecord by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException {
        return super.indexPageQuery("queryLotteryOrderRecordListByCond", "queryLotteryOrderRecordListCntByCond", lotteryOrderRecord, start,
                pageSize, puEntity);
    }

}