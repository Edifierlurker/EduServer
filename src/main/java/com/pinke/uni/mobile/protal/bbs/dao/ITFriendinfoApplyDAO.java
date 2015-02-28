package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITFriendinfoApplyDAO
{
     /**
   * 新增TFriendinfoApply对象 
   * 
   * @param tfriendinfoApply TFriendinfoApply对象
   * @throws DAOException dao异常
   */ 
     public void insertTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DAOException;
     /**
   * 批量新增TFriendinfoApply对象 
   * 
   * @param tfriendinfoApplyList TFriendinfoApply对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DAOException;
     /**
   * 根据主键更新TFriendinfoApply对象
   * 
   * @param tfriendinfoApply TFriendinfoApply对象
   * @throws DAOException dao异常
   */
     public void updateTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DAOException;
     /**
   * 根据主键批量更新TFriendinfoApply对象
   * 
   * @param tfriendinfoApplyList TFriendinfoApply对象列表
   * @throws DAOException dao异常
   */
     public void updateTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DAOException;

     /**
   * 根据条件更新TFriendinfoApply对象  
   *
   * @param tfriendinfoApply TFriendinfoApply更新条件
   * @throws DAOException dao异常
   */
     public void updateTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DAOException;

     /**
   * 根据主键删除TFriendinfoApply对象
   *
   * @param tfriendinfoApply TFriendinfoApply对象
   * @throws DAOException dao异常
   */
     public void deleteTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DAOException;	
     /**
   * 根据主键批量删除TFriendinfoApply对象
   *
   * @param tfriendinfoApplyList TFriendinfoApply对象列表
   * @throws DAOException dao异常
   */
     public void deleteTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DAOException;
     
     /**
   * 根据条件删除TFriendinfoApply对象
   *
   * @param tfriendinfoApply TFriendinfoApply删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DAOException;
     
     /**
   * 根据主键查询TFriendinfoApply对象
   *
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象
   * @throws DAOException dao异常
   */
     public TFriendinfoApply getTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DAOException;
     
     /**
   * 根据条件查询TFriendinfoApply对象 
   *
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象集
   * @throws DAOException dao异常
   */
     public List<TFriendinfoApply> getTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DAOException;
     
	 /**
   * 根据条件精确查询TFriendinfoApply对象 
   *
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象集
   * @throws DAOException dao异常
   */
	 public List<TFriendinfoApply> getTFriendinfoApplyByCondExact( TFriendinfoApply tfriendinfoApply )throws DAOException;

	 /**
   * 根据条件查询TFriendinfoApply对象 
   *
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TFriendinfoApply> getTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TFriendinfoApply对象，作为查询条件的参数
   *
   * @param tfriendinfoApply TFriendinfoApply对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TFriendinfoApply对象，作为查询条件的参数
   *
   * @param tfriendinfoApply TFriendinfoApply对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}