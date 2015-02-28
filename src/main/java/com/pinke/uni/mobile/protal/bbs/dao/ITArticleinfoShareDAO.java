package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITArticleinfoShareDAO
{
     /**
   * 新增TArticleinfoShare对象 
   * 
   * @param tarticleinfoShare TArticleinfoShare对象
   * @throws DAOException dao异常
   */ 
     public void insertTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DAOException;
     /**
   * 批量新增TArticleinfoShare对象 
   * 
   * @param tarticleinfoShareList TArticleinfoShare对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DAOException;
     /**
   * 根据主键更新TArticleinfoShare对象
   * 
   * @param tarticleinfoShare TArticleinfoShare对象
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DAOException;
     /**
   * 根据主键批量更新TArticleinfoShare对象
   * 
   * @param tarticleinfoShareList TArticleinfoShare对象列表
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DAOException;

     /**
   * 根据条件更新TArticleinfoShare对象  
   *
   * @param tarticleinfoShare TArticleinfoShare更新条件
   * @throws DAOException dao异常
   */
     public void updateTArticleinfoShareByCond( TArticleinfoShare tarticleinfoShare )throws DAOException;

     /**
   * 根据主键删除TArticleinfoShare对象
   *
   * @param tarticleinfoShare TArticleinfoShare对象
   * @throws DAOException dao异常
   */
     public void deleteTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DAOException;	
     /**
   * 根据主键批量删除TArticleinfoShare对象
   *
   * @param tarticleinfoShareList TArticleinfoShare对象列表
   * @throws DAOException dao异常
   */
     public void deleteTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DAOException;
     
     /**
   * 根据条件删除TArticleinfoShare对象
   *
   * @param tarticleinfoShare TArticleinfoShare删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTArticleinfoShareByCond( TArticleinfoShare tarticleinfoShare )throws DAOException;
     
     /**
   * 根据主键查询TArticleinfoShare对象
   *
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象
   * @throws DAOException dao异常
   */
     public TArticleinfoShare getTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DAOException;
     
     /**
   * 根据条件查询TArticleinfoShare对象 
   *
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象集
   * @throws DAOException dao异常
   */
     public List<TArticleinfoShare> getTArticleinfoShareByCond( TArticleinfoShare tarticleinfoShare )throws DAOException;
     
	 /**
   * 根据条件精确查询TArticleinfoShare对象 
   *
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象集
   * @throws DAOException dao异常
   */
	 public List<TArticleinfoShare> getTArticleinfoShareByCondExact( TArticleinfoShare tarticleinfoShare )throws DAOException;

	 /**
   * 根据条件查询TArticleinfoShare对象 
   *
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TArticleinfoShare> getTArticleinfoShareByCond( TArticleinfoShare tarticleinfoShare, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TArticleinfoShare对象，作为查询条件的参数
   *
   * @param tarticleinfoShare TArticleinfoShare对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TArticleinfoShare对象，作为查询条件的参数
   *
   * @param tarticleinfoShare TArticleinfoShare对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}