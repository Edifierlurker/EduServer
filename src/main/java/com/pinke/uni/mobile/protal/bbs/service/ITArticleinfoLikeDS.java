

package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITArticleinfoLikeDS
{
    /**
  * 新增TArticleinfoLike对象
  *
  * @param tarticleinfoLike TArticleinfoLike对象
  * @throws DomainServiceException ds异常
  */
	public void insertTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;
   /**
  * 批量新增TArticleinfoLike对象
  *
  * @param tarticleinfoLikeList  TArticleinfoLike对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DomainServiceException;	
	
    /**
  * 更新TArticleinfoLike对象
  *
  * @param tarticleinfoLike TArticleinfoLike对象
  * @throws DomainServiceException ds异常
  */
	public void updateTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;

    /**
  * 批量更新TArticleinfoLike对象
  *
  * @param tarticleinfoLikeList  TArticleinfoLike对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DomainServiceException;

	/**
  * 根据条件更新TArticleinfoLike对象  
  *
  * @param tarticleinfoLike TArticleinfoLike更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;

	/**
  * 删除TArticleinfoLike对象
  *
  * @param tarticleinfoLike TArticleinfoLike对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;

	/**
  * 批量删除TArticleinfoLike对象
  *
  * @param tarticleinfoLikeList  TArticleinfoLike对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DomainServiceException;

    /**
  * 根据条件删除TArticleinfoLike对象
  * 
  * @param tarticleinfoLike TArticleinfoLike删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;	

	/**
  * 查询TArticleinfoLike对象
  * 
  * @param tarticleinfoLike TArticleinfoLike对象
  * @return TArticleinfoLike对象
  * @throws DomainServiceException ds异常 
  */
	 public TArticleinfoLike getTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DomainServiceException; 

    /**
  * 根据主键查询TArticleinfoLike对象
  * 
  * @param likeindex TArticleinfoLike对象主键
  * @return TArticleinfoLike对象
  * @throws DomainServiceException ds异常 
  */
	 public TArticleinfoLike getTArticleinfoLikeByIndex(Long likeindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TArticleinfoLike对象 
   * 
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象集
   * @throws DomainServiceException ds异常
   */
     public List<TArticleinfoLike> getTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;
	 /**
   * 根据条件精确查询TArticleinfoLike对象 
   * 
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TArticleinfoLike> getTArticleinfoLikeByCondExact( TArticleinfoLike tarticleinfoLike )throws DomainServiceException;
	 /**
   * 根据条件分页查询TArticleinfoLike对象 
   *
   * @param tarticleinfoLike TArticleinfoLike对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TArticleinfoLike对象 
   *
   * @param tarticleinfoLike TArticleinfoLike对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}