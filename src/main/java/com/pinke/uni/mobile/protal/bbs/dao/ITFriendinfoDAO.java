package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITFriendinfoDAO
{
     /**
   * 新增TFriendinfo对象 
   * 
   * @param tfriendinfo TFriendinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTFriendinfo( TFriendinfo tfriendinfo )throws DAOException;
     /**
   * 批量新增TFriendinfo对象 
   * 
   * @param tfriendinfoList TFriendinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTFriendinfoList( List<TFriendinfo> tfriendinfoList )throws DAOException;
     /**
   * 根据主键更新TFriendinfo对象
   * 
   * @param tfriendinfo TFriendinfo对象
   * @throws DAOException dao异常
   */
     public void updateTFriendinfo( TFriendinfo tfriendinfo )throws DAOException;
     /**
   * 根据主键批量更新TFriendinfo对象
   * 
   * @param tfriendinfoList TFriendinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTFriendinfoList( List<TFriendinfo> tfriendinfoList )throws DAOException;

     /**
   * 根据条件更新TFriendinfo对象  
   *
   * @param tfriendinfo TFriendinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTFriendinfoByCond( TFriendinfo tfriendinfo )throws DAOException;

     /**
   * 根据主键删除TFriendinfo对象
   *
   * @param tfriendinfo TFriendinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTFriendinfo( TFriendinfo tfriendinfo )throws DAOException;	
     /**
   * 根据主键批量删除TFriendinfo对象
   *
   * @param tfriendinfoList TFriendinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTFriendinfoList( List<TFriendinfo> tfriendinfoList )throws DAOException;
     
     /**
   * 根据条件删除TFriendinfo对象
   *
   * @param tfriendinfo TFriendinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTFriendinfoByCond( TFriendinfo tfriendinfo )throws DAOException;
     
     /**
   * 根据主键查询TFriendinfo对象
   *
   * @param tfriendinfo TFriendinfo对象
   * @return 满足条件的TFriendinfo对象
   * @throws DAOException dao异常
   */
     public TFriendinfo getTFriendinfo( TFriendinfo tfriendinfo )throws DAOException;
     
     /**
   * 根据条件查询TFriendinfo对象 
   *
   * @param tfriendinfo TFriendinfo对象
   * @return 满足条件的TFriendinfo对象集
   * @throws DAOException dao异常
   */
     public List<TFriendinfo> getTFriendinfoByCond( TFriendinfo tfriendinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TFriendinfo对象 
   *
   * @param tfriendinfo TFriendinfo对象
   * @return 满足条件的TFriendinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TFriendinfo> getTFriendinfoByCondExact( TFriendinfo tfriendinfo )throws DAOException;

	 /**
   * 根据条件查询TFriendinfo对象 
   *
   * @param tfriendinfo TFriendinfo对象
   * @return 满足条件的TFriendinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TFriendinfo> getTFriendinfoByCond( TFriendinfo tfriendinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TFriendinfo对象，作为查询条件的参数
   *
   * @param tfriendinfo TFriendinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TFriendinfo对象，作为查询条件的参数
   *
   * @param tfriendinfo TFriendinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}