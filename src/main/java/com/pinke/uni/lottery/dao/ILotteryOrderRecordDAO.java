package com.pinke.uni.lottery.dao;

import com.pinke.uni.lottery.model.LotteryOrderRecord;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

import java.util.List;

public interface ILotteryOrderRecordDAO {
    /**
     * 新增LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void insertLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException;

    /**
     * 批量新增LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void insertLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException;

    /**
     * 根据主键更新LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException;

    /**
     * 根据主键批量更新LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException;

    /**
     * 根据条件更新LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord更新条件
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DAOException;

    /**
     * 根据主键删除LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void deleteLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException;

    /**
     * 根据主键批量删除LotteryOrderRecord对象
     *
     * @param lotteryOrderRecordList LotteryOrderRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void deleteLotteryOrderRecordList(List<LotteryOrderRecord> lotteryOrderRecordList) throws DAOException;


    /**
     * 根据主键查询LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @return 满足条件的LotteryOrderRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public LotteryOrderRecord getLotteryOrderRecord(LotteryOrderRecord lotteryOrderRecord) throws DAOException;

    /**
     * 根据条件查询LotteryOrderRecord对象
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @return 满足条件的LotteryOrderRecord对象集
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public List<LotteryOrderRecord> getLotteryOrderRecordByCond(LotteryOrderRecord lotteryOrderRecord) throws DAOException;


    /**
     * 根据条件分页查询LotteryOrderRecord对象，作为查询条件的参数
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @param start              起始行
     * @param pageSize           页面大小
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public PageInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize) throws DAOException;

    /**
     * 根据条件分页查询LotteryOrderRecord对象，作为查询条件的参数
     *
     * @param lotteryOrderRecord LotteryOrderRecord对象
     * @param start              起始行
     * @param pageSize           页面大小
     * @param puEntity           排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public PageInfo pageInfoQuery(LotteryOrderRecord lotteryOrderRecord, int start, int pageSize, PageUtilEntity puEntity) throws DAOException;

}