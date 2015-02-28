package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITSchoolinfoHisDAO
{
     /**
   * 新增TSchoolinfoHis对象 
   * 
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @throws DAOException dao异常
   */ 
     public void insertTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DAOException;
     /**
   * 批量新增TSchoolinfoHis对象 
   * 
   * @param tschoolinfoHisList TSchoolinfoHis对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DAOException;
     /**
   * 根据主键更新TSchoolinfoHis对象
   * 
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DAOException;
     /**
   * 根据主键批量更新TSchoolinfoHis对象
   * 
   * @param tschoolinfoHisList TSchoolinfoHis对象列表
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DAOException;

     /**
   * 根据条件更新TSchoolinfoHis对象  
   *
   * @param tschoolinfoHis TSchoolinfoHis更新条件
   * @throws DAOException dao异常
   */
     public void updateTSchoolinfoHisByCond( TSchoolinfoHis tschoolinfoHis )throws DAOException;

     /**
   * 根据主键删除TSchoolinfoHis对象
   *
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @throws DAOException dao异常
   */
     public void deleteTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DAOException;	
     /**
   * 根据主键批量删除TSchoolinfoHis对象
   *
   * @param tschoolinfoHisList TSchoolinfoHis对象列表
   * @throws DAOException dao异常
   */
     public void deleteTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DAOException;
     
     /**
   * 根据条件删除TSchoolinfoHis对象
   *
   * @param tschoolinfoHis TSchoolinfoHis删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTSchoolinfoHisByCond( TSchoolinfoHis tschoolinfoHis )throws DAOException;
     
     /**
   * 根据主键查询TSchoolinfoHis对象
   *
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象
   * @throws DAOException dao异常
   */
     public TSchoolinfoHis getTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DAOException;
     
     /**
   * 根据条件查询TSchoolinfoHis对象 
   *
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象集
   * @throws DAOException dao异常
   */
     public List<TSchoolinfoHis> getTSchoolinfoHisByCond( TSchoolinfoHis tschoolinfoHis )throws DAOException;
     
	 /**
   * 根据条件精确查询TSchoolinfoHis对象 
   *
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象集
   * @throws DAOException dao异常
   */
	 public List<TSchoolinfoHis> getTSchoolinfoHisByCondExact( TSchoolinfoHis tschoolinfoHis )throws DAOException;

	 /**
   * 根据条件查询TSchoolinfoHis对象 
   *
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TSchoolinfoHis> getTSchoolinfoHisByCond( TSchoolinfoHis tschoolinfoHis, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TSchoolinfoHis对象，作为查询条件的参数
   *
   * @param tschoolinfoHis TSchoolinfoHis对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TSchoolinfoHis对象，作为查询条件的参数
   *
   * @param tschoolinfoHis TSchoolinfoHis对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}