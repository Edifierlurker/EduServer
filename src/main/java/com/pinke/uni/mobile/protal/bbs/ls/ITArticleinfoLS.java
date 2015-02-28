package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITArticleinfoLS
{
    /**
     * 新增TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 批量新增TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException;

    /**
     * 更新TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 批量更新TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException;

    /**
     * 删除TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 批量删除TArticleinfo对象
     * 
     * @param tarticleinfoList
     *            TArticleinfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeTArticleinfoList(List<TArticleinfo> tarticleinfoList) throws DomainServiceException;

    /**
     * 查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return TArticleinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TArticleinfo getTArticleinfo(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 根据主键查询TArticleinfo对象
     * 
     * @param articleindex
     *            TArticleinfo对象主键
     * @return TArticleinfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public TArticleinfo getTArticleinfoByIndex(Long articleindex) throws DomainServiceException;

    /**
     * 根据条件查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TArticleinfo> getTArticleinfoByCond(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 根据条件精确查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象
     * @return 满足条件的TArticleinfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<TArticleinfo> getTArticleinfoByCondExact(TArticleinfo tarticleinfo) throws DomainServiceException;

    /**
     * 根据条件分页查询TArticleinfo对象
     * 
     * @param tarticleinfo
     *            TArticleinfo对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException;

    public TableDataInfo pageInfoQueryExtends(TArticleinfo tarticleinfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;
}