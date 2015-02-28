package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITClassinfoDAO
{
     /**
   * 新增TClassinfo对象 
   * 
   * @param tclassinfo TClassinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTClassinfo( TClassinfo tclassinfo )throws DAOException;
     /**
   * 批量新增TClassinfo对象 
   * 
   * @param tclassinfoList TClassinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTClassinfoList( List<TClassinfo> tclassinfoList )throws DAOException;
     /**
   * 根据主键更新TClassinfo对象
   * 
   * @param tclassinfo TClassinfo对象
   * @throws DAOException dao异常
   */
     public void updateTClassinfo( TClassinfo tclassinfo )throws DAOException;
     /**
   * 根据主键批量更新TClassinfo对象
   * 
   * @param tclassinfoList TClassinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTClassinfoList( List<TClassinfo> tclassinfoList )throws DAOException;

     /**
   * 根据条件更新TClassinfo对象  
   *
   * @param tclassinfo TClassinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTClassinfoByCond( TClassinfo tclassinfo )throws DAOException;

     /**
   * 根据主键删除TClassinfo对象
   *
   * @param tclassinfo TClassinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTClassinfo( TClassinfo tclassinfo )throws DAOException;	
     /**
   * 根据主键批量删除TClassinfo对象
   *
   * @param tclassinfoList TClassinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTClassinfoList( List<TClassinfo> tclassinfoList )throws DAOException;
     
     /**
   * 根据条件删除TClassinfo对象
   *
   * @param tclassinfo TClassinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTClassinfoByCond( TClassinfo tclassinfo )throws DAOException;
     
     /**
   * 根据主键查询TClassinfo对象
   *
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象
   * @throws DAOException dao异常
   */
     public TClassinfo getTClassinfo( TClassinfo tclassinfo )throws DAOException;
     
     /**
   * 根据条件查询TClassinfo对象 
   *
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象集
   * @throws DAOException dao异常
   */
     public List<TClassinfo> getTClassinfoByCond( TClassinfo tclassinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TClassinfo对象 
   *
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TClassinfo> getTClassinfoByCondExact( TClassinfo tclassinfo )throws DAOException;

	 /**
   * 根据条件查询TClassinfo对象 
   *
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TClassinfo> getTClassinfoByCond( TClassinfo tclassinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TClassinfo对象，作为查询条件的参数
   *
   * @param tclassinfo TClassinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TClassinfo对象，作为查询条件的参数
   *
   * @param tclassinfo TClassinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}