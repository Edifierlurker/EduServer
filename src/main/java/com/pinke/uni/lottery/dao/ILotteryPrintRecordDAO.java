package com.pinke.uni.lottery.dao;

import com.pinke.uni.lottery.model.LotteryPrintRecord;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

import java.util.List;

public interface ILotteryPrintRecordDAO {
    /**
     * 新增LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void insertLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException;

    /**
     * 批量新增LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void insertLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException;

    /**
     * 根据主键更新LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException;

    /**
     * 根据主键批量更新LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException;

    /**
     * 根据条件更新LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord更新条件
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void updateLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DAOException;

    /**
     * 根据主键删除LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void deleteLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException;

    /**
     * 根据主键批量删除LotteryPrintRecord对象
     *
     * @param lotteryPrintRecordList LotteryPrintRecord对象列表
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public void deleteLotteryPrintRecordList(List<LotteryPrintRecord> lotteryPrintRecordList) throws DAOException;


    /**
     * 根据主键查询LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @return 满足条件的LotteryPrintRecord对象
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public LotteryPrintRecord getLotteryPrintRecord(LotteryPrintRecord lotteryPrintRecord) throws DAOException;

    /**
     * 根据条件查询LotteryPrintRecord对象
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @return 满足条件的LotteryPrintRecord对象集
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public List<LotteryPrintRecord> getLotteryPrintRecordByCond(LotteryPrintRecord lotteryPrintRecord) throws DAOException;


    /**
     * 根据条件分页查询LotteryPrintRecord对象，作为查询条件的参数
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @param start              起始行
     * @param pageSize           页面大小
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public PageInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize) throws DAOException;

    /**
     * 根据条件分页查询LotteryPrintRecord对象，作为查询条件的参数
     *
     * @param lotteryPrintRecord LotteryPrintRecord对象
     * @param start              起始行
     * @param pageSize           页面大小
     * @param puEntity           排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws com.zte.ssb.framework.exception.exceptions.DAOException dao异常
     */
    public PageInfo pageInfoQuery(LotteryPrintRecord lotteryPrintRecord, int start, int pageSize, PageUtilEntity puEntity) throws DAOException;

}