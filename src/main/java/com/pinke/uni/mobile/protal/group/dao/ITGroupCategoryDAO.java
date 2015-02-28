package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupCategoryDAO
{
     /**
   * 新增TGroupCategory对象 
   * 
   * @param tgroupCategory TGroupCategory对象
   * @throws DAOException dao异常
   */ 
     public void insertTGroupCategory( TGroupCategory tgroupCategory )throws DAOException;
     /**
   * 批量新增TGroupCategory对象 
   * 
   * @param tgroupCategoryList TGroupCategory对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DAOException;
     /**
   * 根据主键更新TGroupCategory对象
   * 
   * @param tgroupCategory TGroupCategory对象
   * @throws DAOException dao异常
   */
     public void updateTGroupCategory( TGroupCategory tgroupCategory )throws DAOException;
     /**
   * 根据主键批量更新TGroupCategory对象
   * 
   * @param tgroupCategoryList TGroupCategory对象列表
   * @throws DAOException dao异常
   */
     public void updateTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DAOException;

     /**
   * 根据条件更新TGroupCategory对象  
   *
   * @param tgroupCategory TGroupCategory更新条件
   * @throws DAOException dao异常
   */
     public void updateTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DAOException;

     /**
   * 根据主键删除TGroupCategory对象
   *
   * @param tgroupCategory TGroupCategory对象
   * @throws DAOException dao异常
   */
     public void deleteTGroupCategory( TGroupCategory tgroupCategory )throws DAOException;	
     /**
   * 根据主键批量删除TGroupCategory对象
   *
   * @param tgroupCategoryList TGroupCategory对象列表
   * @throws DAOException dao异常
   */
     public void deleteTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DAOException;
     
     /**
   * 根据条件删除TGroupCategory对象
   *
   * @param tgroupCategory TGroupCategory删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DAOException;
     
     /**
   * 根据主键查询TGroupCategory对象
   *
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象
   * @throws DAOException dao异常
   */
     public TGroupCategory getTGroupCategory( TGroupCategory tgroupCategory )throws DAOException;
     
     /**
   * 根据条件查询TGroupCategory对象 
   *
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象集
   * @throws DAOException dao异常
   */
     public List<TGroupCategory> getTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DAOException;
     
	 /**
   * 根据条件精确查询TGroupCategory对象 
   *
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象集
   * @throws DAOException dao异常
   */
	 public List<TGroupCategory> getTGroupCategoryByCondExact( TGroupCategory tgroupCategory )throws DAOException;

	 /**
   * 根据条件查询TGroupCategory对象 
   *
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TGroupCategory> getTGroupCategoryByCond( TGroupCategory tgroupCategory, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TGroupCategory对象，作为查询条件的参数
   *
   * @param tgroupCategory TGroupCategory对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TGroupCategory对象，作为查询条件的参数
   *
   * @param tgroupCategory TGroupCategory对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}