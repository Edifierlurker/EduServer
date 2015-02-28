package com.pinke.uni.lottery.ls;

import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.pinke.uni.lottery.service.ILotteryPrintRecordDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

import java.util.List;

public class LotteryPrintRecordLS implements ILotteryPrintRecordLS {

    private Logger log = LoggerFactory.getLogger("LotteryPrintRecord", LotteryPrintRecordLS.class);

    private ILotteryPrintRecordDS lotteryPrintRecordDS;

    public void setLotteryPrintRecordDS(ILotteryPrintRecordDS lotteryPrintRecordDS) {
        this.lotteryPrintRecordDS = lotteryPrintRecordDS;
    }

    public String insertLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        // check param
        if (null == lotteryPrintRecord) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        lotteryPrintRecordDS.insertLotteryPrintRecord(lotteryPrintRecord);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert lotteryPrintRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryPrintRecordList);
        if (null == lotteryPrintRecordList || lotteryPrintRecordList.size() == 0) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryPrintRecordDS.insertLotteryPrintRecordList(lotteryPrintRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert lotteryPrintRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        // check param
        if (lotteryPrintRecord == null || lotteryPrintRecord.getPrintindex() == null) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryPrintRecordDS.updateLotteryPrintRecord(lotteryPrintRecord);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update lotteryPrintRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryPrintRecordList);
        if (null == lotteryPrintRecordList || lotteryPrintRecordList.size() == 0) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryPrintRecordDS.updateLotteryPrintRecordList(lotteryPrintRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update lotteryPrintRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        // check param
        if (lotteryPrintRecord == null) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryPrintRecordDS.removeLotteryPrintRecord(lotteryPrintRecord);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove lotteryPrintRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryPrintRecordList);
        if (lotteryPrintRecordList == null || lotteryPrintRecordList.size() == 0) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryPrintRecordDS.removeLotteryPrintRecordList(lotteryPrintRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove lotteryPrintRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public LotteryPrintRecord getLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        // check param
        if (lotteryPrintRecord == null || lotteryPrintRecord.getPrintindex() == null) {
            return null;
        }
        return lotteryPrintRecordDS.getLotteryPrintRecord(lotteryPrintRecord);
    }

    public LotteryPrintRecord getLotteryPrintRecordByPrintid(String printid) throws DomainServiceException {
        // check param
        if (printid == null) {
            return null;
        }
        return lotteryPrintRecordDS.getLotteryPrintRecordByPrintid(printid);
    }

    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException {
        return lotteryPrintRecordDS.getLotteryPrintRecordByCond(lotteryPrintRecord);
    }


    public TableDataInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException {
        return lotteryPrintRecordDS.pageInfoQuery(lotteryPrintRecord, start, pageSize, puEntity);
    }

}
