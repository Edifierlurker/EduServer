package com.pinke.uni.mobile.protal.group.service;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoAttendMapDS
{
    /**
     * 新增TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public void insertTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量新增TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public void insertTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

    /**
     * 更新TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public void updateTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量更新TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public void updateTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

    /**
     * 根据条件更新TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap更新条件
     * @throws DomainServiceException
     *             ds异常
     */
    public void updateTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 删除TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public void removeTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量删除TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public void removeTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

    /**
     * 根据条件删除TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap删除条件
     * @throws DomainServiceException
     *             ds异常
     */
    public void removeTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 查询TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @return TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfoAttendMap getTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据主键查询TGroupinfoAttendMap对象
     * 
     * @param mapindex
     *            TGroupinfoAttendMap对象主键
     * @return TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfoAttendMap getTGroupinfoAttendMapByIndex(Long mapindex) throws DomainServiceException;

    /**
     * 根据条件查询TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @return 满足条件的TGroupinfoAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据条件精确查询TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @return 满足条件的TGroupinfoAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCondExact(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据条件分页查询TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象，作为查询条件的参数
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws DomainServiceException
     *             ds异常
     */
    public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize)
            throws DomainServiceException;

    /**
     * 根据条件分页查询TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象，作为查询条件的参数
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws DomainServiceException
     *             ds异常
     */
    public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public List<TGroupinfoAttendMap> getTGroupinfoAttendChat(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException;

}