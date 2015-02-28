

package com.pinke.uni.lottery.ls;

import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

import java.util.List;

public interface ILotteryOrderRecordLS {
    /**
     * 新增LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String insertLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException;

    /**
     * 批量新增LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String insertLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException;

    /**
     * 更新LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String updateLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException;

    /**
     * 批量更新LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String updateLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException;


    /**
     * 删除LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String removeLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException;

    /**
     * 批量删除LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public String removeLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DomainServiceException;

    /**
     * 查询LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @return LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public LotteryOrderRecord getLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException;

    /**
     * 根据主键查询LotteryOrderRecord对象
     *
     * @param orderid LotteryOrderRecord对象主键
     * @return LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public LotteryOrderRecord getLotteryOrderRecordByOrderid(String orderid) throws DomainServiceException;

    /**
     * 根据条件查询LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @return 满足条件的LotteryOrderRecord对象集
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DomainServiceException;

    /**
     * 根据条件分页查询LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象，作为查询条件的参数
     * @param start              起始行
     * @param pageSize           页面大小
     * @param puEntity           排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DomainServiceException ds异常
     */
    public TableDataInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize, PageUtilEntity puEntity) throws DomainServiceException;
}