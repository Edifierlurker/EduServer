package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoBulletinPicLS
{
    /**
     * 新增TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 批量新增TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException;

    /**
     * 更新TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 批量更新TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException;

    /**
     * 删除TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 批量删除TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DomainServiceException;

    /**
     * 查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return TGroupinfoBulletinPic对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfoBulletinPic getTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 根据主键查询TGroupinfoBulletinPic对象
     * 
     * @param picindex
     *            TGroupinfoBulletinPic对象主键
     * @return TGroupinfoBulletinPic对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TGroupinfoBulletinPic getTGroupinfoBulletinPicByIndex(Long picindex) throws DomainServiceException;

    /**
     * 根据条件查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 根据条件精确查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCondExact(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DomainServiceException;

    /**
     * 根据条件分页查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;
}