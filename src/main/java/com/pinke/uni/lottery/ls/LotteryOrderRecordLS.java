package com.pinke.uni.lottery.ls;

import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.pinke.uni.lottery.service.ILotteryOrderRecordDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

import java.util.List;

public class LotteryOrderRecordLS implements ILotteryOrderRecordLS {

    private Logger log = LoggerFactory.getLogger("LotteryOrderRecord", LotteryOrderRecordLS.class);

    private ILotteryOrderRecordDS lotteryOrderRecordDS;

    public void setLotteryOrderRecordDS(ILotteryOrderRecordDS lotteryOrderRecordDS) {
        this.lotteryOrderRecordDS = lotteryOrderRecordDS;
    }

    public String insertLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        // check param
        if (null == lotteryOrderRecord) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        lotteryOrderRecordDS.insertLotteryOrderRecord(lotteryOrderRecord);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert lotteryOrderRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryOrderRecordList);
        if (null == lotteryOrderRecordList || lotteryOrderRecordList.size() == 0) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryOrderRecordDS.insertLotteryOrderRecordList(lotteryOrderRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert lotteryOrderRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        // check param
        if (lotteryOrderRecord == null || lotteryOrderRecord.getOrderindex() == null) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryOrderRecordDS.updateLotteryOrderRecord(lotteryOrderRecord);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update lotteryOrderRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryOrderRecordList);
        if (null == lotteryOrderRecordList || lotteryOrderRecordList.size() == 0) {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryOrderRecordDS.updateLotteryOrderRecordList(lotteryOrderRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update lotteryOrderRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        // check param
        if (lotteryOrderRecord == null) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryOrderRecordDS.removeLotteryOrderRecord(lotteryOrderRecord);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove lotteryOrderRecord success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(lotteryOrderRecordList);
        if (lotteryOrderRecordList == null || lotteryOrderRecordList.size() == 0) {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        lotteryOrderRecordDS.removeLotteryOrderRecordList(lotteryOrderRecordList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove lotteryOrderRecordList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public LotteryOrderRecord getLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        // check param
        if (lotteryOrderRecord == null || lotteryOrderRecord.getOrderindex() == null) {
            return null;
        }
        return lotteryOrderRecordDS.getLotteryOrderRecord(lotteryOrderRecord);
    }

    public LotteryOrderRecord getLotteryOrderRecordByOrderid(String orderid) throws DomainServiceException {
        // check param
        if (orderid == null) {
            return null;
        }
        return lotteryOrderRecordDS.getLotteryOrderRecordByOrderid(orderid);
    }

    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException {
        return lotteryOrderRecordDS.getLotteryOrderRecordByCond(lotteryOrderRecord);
    }


    public TableDataInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException {
        return lotteryOrderRecordDS.pageInfoQuery(lotteryOrderRecord, start, pageSize, puEntity);
    }

}
