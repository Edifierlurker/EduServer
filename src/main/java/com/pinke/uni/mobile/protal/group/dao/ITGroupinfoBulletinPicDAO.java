package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupinfoBulletinPicDAO
{
    /**
     * 新增TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DAOException
     *             dao异常
     */
    public void insertTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException;

    /**
     * 批量新增TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException;

    /**
     * 根据主键更新TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException;

    /**
     * 根据主键批量更新TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException;

    /**
     * 根据条件更新TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException;

    /**
     * 根据主键删除TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException;

    /**
     * 根据主键批量删除TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPicList
     *            TGroupinfoBulletinPic对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfoBulletinPicList(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
            throws DAOException;

    /**
     * 根据条件删除TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic) throws DAOException;

    /**
     * 根据主键查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象
     * @throws DAOException
     *             dao异常
     */
    public TGroupinfoBulletinPic getTGroupinfoBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException;

    /**
     * 根据条件查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException;

    /**
     * 根据条件精确查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCondExact(TGroupinfoBulletinPic tgroupinfoBulletinPic)
            throws DAOException;

    /**
     * 根据条件查询TGroupinfoBulletinPic对象
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @return 满足条件的TGroupinfoBulletinPic对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<TGroupinfoBulletinPic> getTGroupinfoBulletinPicByCond(TGroupinfoBulletinPic tgroupinfoBulletinPic,
            PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询TGroupinfoBulletinPic对象，作为查询条件的参数
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize)
            throws DAOException;

    /**
     * 根据条件分页查询TGroupinfoBulletinPic对象，作为查询条件的参数
     * 
     * @param tgroupinfoBulletinPic
     *            TGroupinfoBulletinPic对象
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
    public PageInfo pageInfoQuery(TGroupinfoBulletinPic tgroupinfoBulletinPic, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

}