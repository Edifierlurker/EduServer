package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITArticleinfoLikeDAO
{
     /**
   * 新增TArticleinfoLike对象 
   * 
   * @param tarticleinfoLike TArticleinfoLike对象
   * @throws DAOException dao异常
   */ 
     public void insertTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DAOException;
     /**
   * 批量新增TArticleinfoLike对象 
   * 
   * @param tarticleinfoLikeList TArticleinfoLike对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DAOException;
     /**
   * 根据主键更新TArticleinfoLike对象
   * 
   * @param tarticleinfoLike TArticleinfoLike对象
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DAOException;
     /**
   * 根据主键批量更新TArticleinfoLike对象
   * 
   * @param tarticleinfoLikeList TArticleinfoLike对象列表
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DAOException;

     /**
   * 根据条件更新TArticleinfoLike对象  
   *
   * @param tarticleinfoLike TArticleinfoLike更新条件
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DAOException;

     /**
   * 根据主键删除TArticleinfoLike对象
   *
   * @param tarticleinfoLike TArticleinfoLike对象
   * @throws DAOException dao异常
   */
     public void deleteTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DAOException;	
     /**
   * 根据主键批量删除TArticleinfoLike对象
   *
   * @param tarticleinfoLikeList TArticleinfoLike对象列表
   * @throws DAOException dao异常
   */
     public void deleteTArticleinfoLikeList( List<TArticleinfoLike> tarticleinfoLikeList )throws DAOException;
     
     /**
   * 根据条件删除TArticleinfoLike对象
   *
   * @param tarticleinfoLike TArticleinfoLike删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DAOException;
     
     /**
   * 根据主键查询TArticleinfoLike对象
   *
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象
   * @throws DAOException dao异常
   */
     public TArticleinfoLike getTArticleinfoLike( TArticleinfoLike tarticleinfoLike )throws DAOException;
     
     /**
   * 根据条件查询TArticleinfoLike对象 
   *
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象集
   * @throws DAOException dao异常
   */
     public List<TArticleinfoLike> getTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike )throws DAOException;
     
	 /**
   * 根据条件精确查询TArticleinfoLike对象 
   *
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象集
   * @throws DAOException dao异常
   */
	 public List<TArticleinfoLike> getTArticleinfoLikeByCondExact( TArticleinfoLike tarticleinfoLike )throws DAOException;

	 /**
   * 根据条件查询TArticleinfoLike对象 
   *
   * @param tarticleinfoLike TArticleinfoLike对象
   * @return 满足条件的TArticleinfoLike对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TArticleinfoLike> getTArticleinfoLikeByCond( TArticleinfoLike tarticleinfoLike, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TArticleinfoLike对象，作为查询条件的参数
   *
   * @param tarticleinfoLike TArticleinfoLike对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TArticleinfoLike对象，作为查询条件的参数
   *
   * @param tarticleinfoLike TArticleinfoLike对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TArticleinfoLike tarticleinfoLike, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}