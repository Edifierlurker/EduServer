package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITSchoolinfoDAO
{
     /**
   * 新增TSchoolinfo对象 
   * 
   * @param tschoolinfo TSchoolinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTSchoolinfo( TSchoolinfo tschoolinfo )throws DAOException;
     /**
   * 批量新增TSchoolinfo对象 
   * 
   * @param tschoolinfoList TSchoolinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DAOException;
     /**
   * 根据主键更新TSchoolinfo对象
   * 
   * @param tschoolinfo TSchoolinfo对象
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfo( TSchoolinfo tschoolinfo )throws DAOException;
     /**
   * 根据主键批量更新TSchoolinfo对象
   * 
   * @param tschoolinfoList TSchoolinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DAOException;

     /**
   * 根据条件更新TSchoolinfo对象  
   *
   * @param tschoolinfo TSchoolinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfoByCond( TSchoolinfo tschoolinfo )throws DAOException;

     /**
   * 根据主键删除TSchoolinfo对象
   *
   * @param tschoolinfo TSchoolinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTSchoolinfo( TSchoolinfo tschoolinfo )throws DAOException;	
     /**
   * 根据主键批量删除TSchoolinfo对象
   *
   * @param tschoolinfoList TSchoolinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DAOException;
     
     /**
   * 根据条件删除TSchoolinfo对象
   *
   * @param tschoolinfo TSchoolinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTSchoolinfoByCond( TSchoolinfo tschoolinfo )throws DAOException;
     
     /**
   * 根据主键查询TSchoolinfo对象
   *
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象
   * @throws DAOException dao异常
   */
     public TSchoolinfo getTSchoolinfo( TSchoolinfo tschoolinfo )throws DAOException;
     
     /**
   * 根据条件查询TSchoolinfo对象 
   *
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象集
   * @throws DAOException dao异常
   */
     public List<TSchoolinfo> getTSchoolinfoByCond( TSchoolinfo tschoolinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TSchoolinfo对象 
   *
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TSchoolinfo> getTSchoolinfoByCondExact( TSchoolinfo tschoolinfo )throws DAOException;

	 /**
   * 根据条件查询TSchoolinfo对象 
   *
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TSchoolinfo> getTSchoolinfoByCond( TSchoolinfo tschoolinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TSchoolinfo对象，作为查询条件的参数
   *
   * @param tschoolinfo TSchoolinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TSchoolinfo对象，作为查询条件的参数
   *
   * @param tschoolinfo TSchoolinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}