package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupCategoryMapDAO
{
     /**
   * 新增TGroupCategoryMap对象 
   * 
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @throws DAOException dao异常
   */ 
     public void insertTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DAOException;
     /**
   * 批量新增TGroupCategoryMap对象 
   * 
   * @param tgroupCategoryMapList TGroupCategoryMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DAOException;
     /**
   * 根据主键更新TGroupCategoryMap对象
   * 
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @throws DAOException dao异常
   */
     public void updateTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DAOException;
     /**
   * 根据主键批量更新TGroupCategoryMap对象
   * 
   * @param tgroupCategoryMapList TGroupCategoryMap对象列表
   * @throws DAOException dao异常
   */
     public void updateTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DAOException;

     /**
   * 根据条件更新TGroupCategoryMap对象  
   *
   * @param tgroupCategoryMap TGroupCategoryMap更新条件
   * @throws DAOException dao异常
   */
     public void updateTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DAOException;

     /**
   * 根据主键删除TGroupCategoryMap对象
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @throws DAOException dao异常
   */
     public void deleteTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DAOException;	
     /**
   * 根据主键批量删除TGroupCategoryMap对象
   *
   * @param tgroupCategoryMapList TGroupCategoryMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DAOException;
     
     /**
   * 根据条件删除TGroupCategoryMap对象
   *
   * @param tgroupCategoryMap TGroupCategoryMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DAOException;
     
     /**
   * 根据主键查询TGroupCategoryMap对象
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象
   * @throws DAOException dao异常
   */
     public TGroupCategoryMap getTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DAOException;
     
     /**
   * 根据条件查询TGroupCategoryMap对象 
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象集
   * @throws DAOException dao异常
   */
     public List<TGroupCategoryMap> getTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DAOException;
     
	 /**
   * 根据条件精确查询TGroupCategoryMap对象 
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象集
   * @throws DAOException dao异常
   */
	 public List<TGroupCategoryMap> getTGroupCategoryMapByCondExact( TGroupCategoryMap tgroupCategoryMap )throws DAOException;

	 /**
   * 根据条件查询TGroupCategoryMap对象 
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TGroupCategoryMap> getTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TGroupCategoryMap对象，作为查询条件的参数
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TGroupCategoryMap对象，作为查询条件的参数
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}