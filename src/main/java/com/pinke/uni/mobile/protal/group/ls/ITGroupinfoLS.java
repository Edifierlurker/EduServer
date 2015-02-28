package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoLS
{
    /**
     * 新增TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 批量新增TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException;

    /**
     * 更新TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 批量更新TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException;

    /**
     * 删除TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 批量删除TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DomainServiceException;

    /**
     * 查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return TGroupinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfo getTGroupinfo(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 根据主键查询TGroupinfo对象
     * 
     * @param groupindex
     *            TGroupinfo对象主键
     * @return TGroupinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfo getTGroupinfoByIndex(Long groupindex) throws DomainServiceException;

    /**
     * 根据条件查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 根据条件精确查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfo> getTGroupinfoByCondExact(TGroupinfo tgroupinfo) throws DomainServiceException;

    /**
     * 根据条件分页查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException;

    public TableDataInfo pageInfoQueryExtends(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException;
}