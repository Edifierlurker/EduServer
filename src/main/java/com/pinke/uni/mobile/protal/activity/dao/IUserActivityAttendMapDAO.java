package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserActivityAttendMapDAO
{
     /**
   * 新增UserActivityAttendMap对象 
   * 
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @throws DAOException dao异常
   */ 
     public void insertUserActivityAttendMap( UserActivityAttendMap userActivityAttendMap )throws DAOException;
     /**
   * 批量新增UserActivityAttendMap对象 
   * 
   * @param userActivityAttendMapList UserActivityAttendMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserActivityAttendMapList( List<UserActivityAttendMap> userActivityAttendMapList )throws DAOException;
     /**
   * 根据主键更新UserActivityAttendMap对象
   * 
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @throws DAOException dao异常
   */
     public void updateUserActivityAttendMap( UserActivityAttendMap userActivityAttendMap )throws DAOException;
     /**
   * 根据主键批量更新UserActivityAttendMap对象
   * 
   * @param userActivityAttendMapList UserActivityAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void updateUserActivityAttendMapList( List<UserActivityAttendMap> userActivityAttendMapList )throws DAOException;

     /**
   * 根据条件更新UserActivityAttendMap对象  
   *
   * @param userActivityAttendMap UserActivityAttendMap更新条件
   * @throws DAOException dao异常
   */
     public void updateUserActivityAttendMapByCond( UserActivityAttendMap userActivityAttendMap )throws DAOException;

     /**
   * 根据主键删除UserActivityAttendMap对象
   *
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @throws DAOException dao异常
   */
     public void deleteUserActivityAttendMap( UserActivityAttendMap userActivityAttendMap )throws DAOException;	
     /**
   * 根据主键批量删除UserActivityAttendMap对象
   *
   * @param userActivityAttendMapList UserActivityAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserActivityAttendMapList( List<UserActivityAttendMap> userActivityAttendMapList )throws DAOException;
     
     /**
   * 根据条件删除UserActivityAttendMap对象
   *
   * @param userActivityAttendMap UserActivityAttendMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserActivityAttendMapByCond( UserActivityAttendMap userActivityAttendMap )throws DAOException;
     
     /**
   * 根据主键查询UserActivityAttendMap对象
   *
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @return 满足条件的UserActivityAttendMap对象
   * @throws DAOException dao异常
   */
     public UserActivityAttendMap getUserActivityAttendMap( UserActivityAttendMap userActivityAttendMap )throws DAOException;
     
     /**
   * 根据条件查询UserActivityAttendMap对象 
   *
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @return 满足条件的UserActivityAttendMap对象集
   * @throws DAOException dao异常
   */
     public List<UserActivityAttendMapExtends> getUserActivityAttendMapByCond( UserActivityAttendMapExtends userActivityAttendMap )throws DAOException;
     
	 /**
   * 根据条件精确查询UserActivityAttendMap对象 
   *
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @return 满足条件的UserActivityAttendMap对象集
   * @throws DAOException dao异常
   */
	 public List<UserActivityAttendMap> getUserActivityAttendMapByCondExact( UserActivityAttendMap userActivityAttendMap )throws DAOException;

	 /**
   * 根据条件查询UserActivityAttendMap对象 
   *
   * @param userActivityAttendMap UserActivityAttendMap对象
   * @return 满足条件的UserActivityAttendMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserActivityAttendMap> getUserActivityAttendMapByCond( UserActivityAttendMap userActivityAttendMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserActivityAttendMap对象，作为查询条件的参数
   *
   * @param userActivityAttendMap UserActivityAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserActivityAttendMap对象，作为查询条件的参数
   *
   * @param userActivityAttendMap UserActivityAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}