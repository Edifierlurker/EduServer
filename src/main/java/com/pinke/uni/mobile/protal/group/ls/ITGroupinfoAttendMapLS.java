package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoAttendMapLS
{
    /**
     * 新增TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量新增TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

    /**
     * 更新TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量更新TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

    /**
     * 删除TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMap
     *            TGroupinfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfoAttendMap(TGroupinfoAttendMap tgroupinfoAttendMap) throws DomainServiceException;

    /**
     * 批量删除TGroupinfoAttendMap对象
     * 
     * @param tgroupinfoAttendMapList
     *            TGroupinfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfoAttendMapList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
            throws DomainServiceException;

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
    public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public List<TGroupinfoAttendMap> getTGroupinfoAttendChat(TGroupinfoAttendMap tgroupinfoAttendMap)
            throws DomainServiceException;
}