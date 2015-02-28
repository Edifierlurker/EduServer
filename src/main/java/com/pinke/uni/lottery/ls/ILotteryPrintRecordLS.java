

package com.pinke.uni.lottery.ls;

import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

import java.util.List;

public interface ILotteryPrintRecordLS {
    /**
     * 新增LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String insertLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException;

    /**
     * 批量新增LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String insertLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException;

    /**
     * 更新LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String updateLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException;

    /**
     * 批量更新LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String updateLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException;


    /**
     * 删除LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String removeLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException;

    /**
     * 批量删除LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String removeLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DomainServiceException;

    /**
     * 查询LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @return LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public LotteryPrintRecord getLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException;

    /**
     * 根据主键查询LotteryPrintRecord对象
     *
     * @param printid LotteryPrintRecord对象主键
     * @return LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public LotteryPrintRecord getLotteryPrintRecordByPrintid(String printid) throws DomainServiceException;

    /**
     * 根据条件查询LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @return 满足条件的LotteryPrintRecord对象集
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DomainServiceException;

    /**
     * 根据条件分页查询LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象，作为查询条件的参数
     * @param start              起始行
     * @param pageSize           页面大小
     * @param puEntity           排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public TableDataInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize, PageUtilEntity puEntity) throws DomainServiceException;
}