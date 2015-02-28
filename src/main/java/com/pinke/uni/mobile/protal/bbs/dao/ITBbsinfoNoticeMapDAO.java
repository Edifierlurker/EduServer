package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITBbsinfoNoticeMapDAO
{
     /**
   * 新增TBbsinfoNoticeMap对象 
   * 
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @throws DAOException dao异常
   */ 
     public void insertTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;
     /**
   * 批量新增TBbsinfoNoticeMap对象 
   * 
   * @param tbbsinfoNoticeMapList TBbsinfoNoticeMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException;
     /**
   * 根据主键更新TBbsinfoNoticeMap对象
   * 
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @throws DAOException dao异常
   */
     public void updateTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;
     /**
   * 根据主键批量更新TBbsinfoNoticeMap对象
   * 
   * @param tbbsinfoNoticeMapList TBbsinfoNoticeMap对象列表
   * @throws DAOException dao异常
   */
     public void updateTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException;

     /**
   * 根据条件更新TBbsinfoNoticeMap对象  
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap更新条件
   * @throws DAOException dao异常
   */
     public void updateTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;

     /**
   * 根据主键删除TBbsinfoNoticeMap对象
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @throws DAOException dao异常
   */
     public void deleteTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;	
     /**
   * 根据主键批量删除TBbsinfoNoticeMap对象
   *
   * @param tbbsinfoNoticeMapList TBbsinfoNoticeMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException;
     
     /**
   * 根据条件删除TBbsinfoNoticeMap对象
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;
     
     /**
   * 根据主键查询TBbsinfoNoticeMap对象
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象
   * @throws DAOException dao异常
   */
     public TBbsinfoNoticeMap getTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;
     
     /**
   * 根据条件查询TBbsinfoNoticeMap对象 
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象集
   * @throws DAOException dao异常
   */
     public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;
     
	 /**
   * 根据条件精确查询TBbsinfoNoticeMap对象 
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象集
   * @throws DAOException dao异常
   */
	 public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCondExact( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException;

	 /**
   * 根据条件查询TBbsinfoNoticeMap对象 
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TBbsinfoNoticeMap对象，作为查询条件的参数
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TBbsinfoNoticeMap对象，作为查询条件的参数
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}