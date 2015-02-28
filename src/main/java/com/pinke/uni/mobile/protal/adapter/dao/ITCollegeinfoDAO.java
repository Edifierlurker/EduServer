package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITCollegeinfoDAO
{
     /**
   * 新增TCollegeinfo对象 
   * 
   * @param tcollegeinfo TCollegeinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTCollegeinfo( TCollegeinfo tcollegeinfo )throws DAOException;
     /**
   * 批量新增TCollegeinfo对象 
   * 
   * @param tcollegeinfoList TCollegeinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DAOException;
     /**
   * 根据主键更新TCollegeinfo对象
   * 
   * @param tcollegeinfo TCollegeinfo对象
   * @throws DAOException dao异常
   */
     public void updateTCollegeinfo( TCollegeinfo tcollegeinfo )throws DAOException;
     /**
   * 根据主键批量更新TCollegeinfo对象
   * 
   * @param tcollegeinfoList TCollegeinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DAOException;

     /**
   * 根据条件更新TCollegeinfo对象  
   *
   * @param tcollegeinfo TCollegeinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTCollegeinfoByCond( TCollegeinfo tcollegeinfo )throws DAOException;

     /**
   * 根据主键删除TCollegeinfo对象
   *
   * @param tcollegeinfo TCollegeinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTCollegeinfo( TCollegeinfo tcollegeinfo )throws DAOException;	
     /**
   * 根据主键批量删除TCollegeinfo对象
   *
   * @param tcollegeinfoList TCollegeinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DAOException;
     
     /**
   * 根据条件删除TCollegeinfo对象
   *
   * @param tcollegeinfo TCollegeinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTCollegeinfoByCond( TCollegeinfo tcollegeinfo )throws DAOException;
     
     /**
   * 根据主键查询TCollegeinfo对象
   *
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象
   * @throws DAOException dao异常
   */
     public TCollegeinfo getTCollegeinfo( TCollegeinfo tcollegeinfo )throws DAOException;
     
     /**
   * 根据条件查询TCollegeinfo对象 
   *
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象集
   * @throws DAOException dao异常
   */
     public List<TCollegeinfo> getTCollegeinfoByCond( TCollegeinfo tcollegeinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TCollegeinfo对象 
   *
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TCollegeinfo> getTCollegeinfoByCondExact( TCollegeinfo tcollegeinfo )throws DAOException;

	 /**
   * 根据条件查询TCollegeinfo对象 
   *
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TCollegeinfo> getTCollegeinfoByCond( TCollegeinfo tcollegeinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TCollegeinfo对象，作为查询条件的参数
   *
   * @param tcollegeinfo TCollegeinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TCollegeinfo对象，作为查询条件的参数
   *
   * @param tcollegeinfo TCollegeinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}