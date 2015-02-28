package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupinfoDAO
{
    /**
     * 新增TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void insertTGroupinfo(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 批量新增TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException;

    /**
     * 根据主键更新TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfo(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据主键批量更新TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException;

    /**
     * 根据条件更新TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据主键删除TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfo(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据主键批量删除TGroupinfo对象
     * 
     * @param tgroupinfoList
     *            TGroupinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfoList(List<TGroupinfo> tgroupinfoList) throws DAOException;

    /**
     * 根据条件删除TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据主键查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象
     * @throws DAOException
     *             dao异常
     */
    public TGroupinfo getTGroupinfo(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据条件查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据条件精确查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfo> getTGroupinfoByCondExact(TGroupinfo tgroupinfo) throws DAOException;

    /**
     * 根据条件查询TGroupinfo对象
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @return 满足条件的TGroupinfo对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfo> getTGroupinfoByCond(TGroupinfo tgroupinfo, PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询TGroupinfo对象，作为查询条件的参数
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize) throws DAOException;

    /**
     * 根据条件分页查询TGroupinfo对象，作为查询条件的参数
     * 
     * @param tgroupinfo
     *            TGroupinfo对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException;

    public PageInfo pageInfoQueryExtends(TGroupinfo tgroupinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException;

}