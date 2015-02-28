package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITArticleinfoDAO
{
    /**
     * 新增TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void insertTArticleinfo(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 批量新增TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException;

    /**
     * 根据主键更新TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfo(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据主键批量更新TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException;

    /**
     * 根据条件更新TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据主键删除TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfo(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据主键批量删除TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DAOException;

    /**
     * 根据条件删除TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据主键查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象
     * @throws DAOException
     *             dao异常
     */
    public TArticleinfo getTArticleinfo(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据条件查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据条件精确查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfo> getTArticleinfoByCondExact(TArticleinfo tarticleinfo) throws DAOException;

    /**
     * 根据条件查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo, PageUtilEntity puEntity)
            throws DAOException;

    /**
     * 根据条件分页查询TArticleinfo对象，作为查询条件的参数
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize) throws DAOException;

    /**
     * 根据条件分页查询TArticleinfo对象，作为查询条件的参数
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
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
    public PageInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException;

    public PageInfo pageInfoQueryExtends(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException;

}