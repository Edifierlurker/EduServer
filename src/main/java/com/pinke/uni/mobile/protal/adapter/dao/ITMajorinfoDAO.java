package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITMajorinfoDAO
{
     /**
   * 新增TMajorinfo对象 
   * 
   * @param tmajorinfo TMajorinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTMajorinfo( TMajorinfo tmajorinfo )throws DAOException;
     /**
   * 批量新增TMajorinfo对象 
   * 
   * @param tmajorinfoList TMajorinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DAOException;
     /**
   * 根据主键更新TMajorinfo对象
   * 
   * @param tmajorinfo TMajorinfo对象
   * @throws DAOException dao异常
   */
     public void updateTMajorinfo( TMajorinfo tmajorinfo )throws DAOException;
     /**
   * 根据主键批量更新TMajorinfo对象
   * 
   * @param tmajorinfoList TMajorinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DAOException;

     /**
   * 根据条件更新TMajorinfo对象  
   *
   * @param tmajorinfo TMajorinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTMajorinfoByCond( TMajorinfo tmajorinfo )throws DAOException;

     /**
   * 根据主键删除TMajorinfo对象
   *
   * @param tmajorinfo TMajorinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTMajorinfo( TMajorinfo tmajorinfo )throws DAOException;	
     /**
   * 根据主键批量删除TMajorinfo对象
   *
   * @param tmajorinfoList TMajorinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DAOException;
     
     /**
   * 根据条件删除TMajorinfo对象
   *
   * @param tmajorinfo TMajorinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTMajorinfoByCond( TMajorinfo tmajorinfo )throws DAOException;
     
     /**
   * 根据主键查询TMajorinfo对象
   *
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象
   * @throws DAOException dao异常
   */
     public TMajorinfo getTMajorinfo( TMajorinfo tmajorinfo )throws DAOException;
     
     /**
   * 根据条件查询TMajorinfo对象 
   *
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象集
   * @throws DAOException dao异常
   */
     public List<TMajorinfo> getTMajorinfoByCond( TMajorinfo tmajorinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TMajorinfo对象 
   *
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TMajorinfo> getTMajorinfoByCondExact( TMajorinfo tmajorinfo )throws DAOException;

	 /**
   * 根据条件查询TMajorinfo对象 
   *
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TMajorinfo> getTMajorinfoByCond( TMajorinfo tmajorinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TMajorinfo对象，作为查询条件的参数
   *
   * @param tmajorinfo TMajorinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TMajorinfo对象，作为查询条件的参数
   *
   * @param tmajorinfo TMajorinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}