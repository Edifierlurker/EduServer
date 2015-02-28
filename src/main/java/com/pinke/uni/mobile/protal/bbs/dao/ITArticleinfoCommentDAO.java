package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITArticleinfoCommentDAO
{
    /**
     * 新增TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DAOException
     *             dao异常
     */
    public void insertTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 批量新增TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList) throws DAOException;

    /**
     * 根据主键更新TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 根据主键批量更新TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList) throws DAOException;

    /**
     * 根据条件更新TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 根据主键删除TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 根据主键批量删除TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList) throws DAOException;

    /**
     * 根据条件删除TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 根据主键查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象
     * @throws DAOException
     *             dao异常
     */
    public TArticleinfoComment getTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DAOException;

    /**
     * 根据条件查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfoComment> getTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment)
            throws DAOException;

    /**
     * 根据条件精确查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象集
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfoComment> getTArticleinfoCommentByCondExact(TArticleinfoComment tarticleinfoComment)
            throws DAOException;

    /**
     * 根据条件查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<TArticleinfoComment> getTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment,
            PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询TArticleinfoComment对象，作为查询条件的参数
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize) throws DAOException;

    /**
     * 根据条件分页查询TArticleinfoComment对象，作为查询条件的参数
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
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
    public PageInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

    public PageInfo pageInfoQueryExtends(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

}