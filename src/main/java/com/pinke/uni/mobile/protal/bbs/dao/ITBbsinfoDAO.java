package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITBbsinfoDAO
{
     /**
   * 新增TBbsinfo对象 
   * 
   * @param tbbsinfo TBbsinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTBbsinfo( TBbsinfo tbbsinfo )throws DAOException;
     /**
   * 批量新增TBbsinfo对象 
   * 
   * @param tbbsinfoList TBbsinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DAOException;
     /**
   * 根据主键更新TBbsinfo对象
   * 
   * @param tbbsinfo TBbsinfo对象
   * @throws DAOException dao异常
   */
     public void updateTBbsinfo( TBbsinfo tbbsinfo )throws DAOException;
     /**
   * 根据主键批量更新TBbsinfo对象
   * 
   * @param tbbsinfoList TBbsinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DAOException;

     /**
   * 根据条件更新TBbsinfo对象  
   *
   * @param tbbsinfo TBbsinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTBbsinfoByCond( TBbsinfo tbbsinfo )throws DAOException;

     /**
   * 根据主键删除TBbsinfo对象
   *
   * @param tbbsinfo TBbsinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTBbsinfo( TBbsinfo tbbsinfo )throws DAOException;	
     /**
   * 根据主键批量删除TBbsinfo对象
   *
   * @param tbbsinfoList TBbsinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DAOException;
     
     /**
   * 根据条件删除TBbsinfo对象
   *
   * @param tbbsinfo TBbsinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTBbsinfoByCond( TBbsinfo tbbsinfo )throws DAOException;
     
     /**
   * 根据主键查询TBbsinfo对象
   *
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象
   * @throws DAOException dao异常
   */
     public TBbsinfo getTBbsinfo( TBbsinfo tbbsinfo )throws DAOException;
     
     /**
   * 根据条件查询TBbsinfo对象 
   *
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象集
   * @throws DAOException dao异常
   */
     public List<TBbsinfo> getTBbsinfoByCond( TBbsinfo tbbsinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TBbsinfo对象 
   *
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TBbsinfo> getTBbsinfoByCondExact( TBbsinfo tbbsinfo )throws DAOException;

	 /**
   * 根据条件查询TBbsinfo对象 
   *
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TBbsinfo> getTBbsinfoByCond( TBbsinfo tbbsinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TBbsinfo对象，作为查询条件的参数
   *
   * @param tbbsinfo TBbsinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TBbsinfo对象，作为查询条件的参数
   *
   * @param tbbsinfo TBbsinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}