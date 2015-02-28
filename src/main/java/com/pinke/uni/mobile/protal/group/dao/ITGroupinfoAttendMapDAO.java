package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupinfoAttendMapDAO
{
     /**
   * 新增TGroupinfoAttendMap对象 
   * 
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @throws DAOException dao异常
   */ 
     public void insertTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;
     /**
   * 批量新增TGroupinfoAttendMap对象 
   * 
   * @param tgroupinfoAttendMapList TGroupinfoAttendMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTGroupinfoAttendMapList( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DAOException;
     /**
   * 根据主键更新TGroupinfoAttendMap对象
   * 
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;
     /**
   * 根据主键批量更新TGroupinfoAttendMap对象
   * 
   * @param tgroupinfoAttendMapList TGroupinfoAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoAttendMapList( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DAOException;

     /**
   * 根据条件更新TGroupinfoAttendMap对象  
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap更新条件
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;

     /**
   * 根据主键删除TGroupinfoAttendMap对象
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @throws DAOException dao异常
   */
     public void deleteTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;	
     /**
   * 根据主键批量删除TGroupinfoAttendMap对象
   *
   * @param tgroupinfoAttendMapList TGroupinfoAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteTGroupinfoAttendMapList( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DAOException;
     
     /**
   * 根据条件删除TGroupinfoAttendMap对象
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;
     
     /**
   * 根据主键查询TGroupinfoAttendMap对象
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @return 满足条件的TGroupinfoAttendMap对象
   * @throws DAOException dao异常
   */
     public TGroupinfoAttendMap getTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;
     
     /**
   * 根据条件查询TGroupinfoAttendMap对象 
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @return 满足条件的TGroupinfoAttendMap对象集
   * @throws DAOException dao异常
   */
     public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;
     
	 /**
   * 根据条件精确查询TGroupinfoAttendMap对象 
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @return 满足条件的TGroupinfoAttendMap对象集
   * @throws DAOException dao异常
   */
	 public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCondExact( TGroupinfoAttendMap tgroupinfoAttendMap )throws DAOException;

	 /**
   * 根据条件查询TGroupinfoAttendMap对象 
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象
   * @return 满足条件的TGroupinfoAttendMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TGroupinfoAttendMap对象，作为查询条件的参数
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TGroupinfoAttendMap对象，作为查询条件的参数
   *
   * @param tgroupinfoAttendMap TGroupinfoAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
     @SuppressWarnings("unchecked")
     public List<TGroupinfoAttendMap> getTGroupinfoAttendChat(TGroupinfoAttendMap tgroupinfoAttendMap)
             throws DAOException;
}