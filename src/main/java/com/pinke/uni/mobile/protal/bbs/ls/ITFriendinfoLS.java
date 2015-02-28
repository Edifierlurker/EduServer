package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITFriendinfoLS
{
    /**
     * 新增TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 批量新增TFriendinfo对象
     * 
     * @param tfriendinfoList
     *            TFriendinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException;

    /**
     * 更新TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 批量更新TFriendinfo对象
     * 
     * @param tfriendinfoList
     *            TFriendinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException;

    /**
     * 删除TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 批量删除TFriendinfo对象
     * 
     * @param tfriendinfoList
     *            TFriendinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTFriendinfoList(List<TFriendinfo> tfriendinfoList) throws DomainServiceException;

    /**
     * 查询TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @return TFriendinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TFriendinfo getTFriendinfo(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 根据主键查询TFriendinfo对象
     * 
     * @param mapindex
     *            TFriendinfo对象主键
     * @return TFriendinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TFriendinfo getTFriendinfoByIndex(Long mapindex) throws DomainServiceException;

    /**
     * 根据条件查询TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @return 满足条件的TFriendinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TFriendinfo> getTFriendinfoByCond(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 根据条件精确查询TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象
     * @return 满足条件的TFriendinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TFriendinfo> getTFriendinfoByCondExact(TFriendinfo tfriendinfo) throws DomainServiceException;

    /**
     * 根据条件分页查询TFriendinfo对象
     * 
     * @param tfriendinfo
     *            TFriendinfo对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException;

    public String updateTFriendinfoExtends(TFriendinfo tfriendinfo) throws DomainServiceException;
}