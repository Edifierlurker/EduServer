package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITArticleinfoCommentLS
{
    /**
     * 新增TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException;

    /**
     * 批量新增TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException;

    /**
     * 更新TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException;

    /**
     * 批量更新TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException;

    /**
     * 删除TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTArticleinfoComment(TArticleinfoComment tarticleinfoComment) throws DomainServiceException;

    /**
     * 批量删除TArticleinfoComment对象
     * 
     * @param tarticleinfoCommentList
     *            TArticleinfoComment对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTArticleinfoCommentList(List<TArticleinfoComment> tarticleinfoCommentList)
            throws DomainServiceException;

    /**
     * 查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return TArticleinfoComment对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TArticleinfoComment getTArticleinfoComment(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException;

    /**
     * 根据主键查询TArticleinfoComment对象
     * 
     * @param commentindex
     *            TArticleinfoComment对象主键
     * @return TArticleinfoComment对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TArticleinfoComment getTArticleinfoCommentByIndex(Long commentindex) throws DomainServiceException;

    /**
     * 根据条件查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TArticleinfoComment> getTArticleinfoCommentByCond(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException;

    /**
     * 根据条件精确查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象
     * @return 满足条件的TArticleinfoComment对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TArticleinfoComment> getTArticleinfoCommentByCondExact(TArticleinfoComment tarticleinfoComment)
            throws DomainServiceException;

    /**
     * 根据条件分页查询TArticleinfoComment对象
     * 
     * @param tarticleinfoComment
     *            TArticleinfoComment对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public TableDataInfo pageInfoQueryExtends(TArticleinfoComment tarticleinfoComment, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;
}