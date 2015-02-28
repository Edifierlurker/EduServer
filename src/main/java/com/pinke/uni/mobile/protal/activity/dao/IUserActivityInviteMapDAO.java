package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserActivityInviteMapDAO
{
     /**
   * 新增UserActivityInviteMap对象 
   * 
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @throws DAOException dao异常
   */ 
     public void insertUserActivityInviteMap( UserActivityInviteMap userActivityInviteMap )throws DAOException;
     /**
   * 批量新增UserActivityInviteMap对象 
   * 
   * @param userActivityInviteMapList UserActivityInviteMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserActivityInviteMapList( List<UserActivityInviteMap> userActivityInviteMapList )throws DAOException;
     /**
   * 根据主键更新UserActivityInviteMap对象
   * 
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @throws DAOException dao异常
   */
     public void updateUserActivityInviteMap( UserActivityInviteMap userActivityInviteMap )throws DAOException;
     /**
   * 根据主键批量更新UserActivityInviteMap对象
   * 
   * @param userActivityInviteMapList UserActivityInviteMap对象列表
   * @throws DAOException dao异常
   */
     public void updateUserActivityInviteMapList( List<UserActivityInviteMap> userActivityInviteMapList )throws DAOException;

     /**
   * 根据条件更新UserActivityInviteMap对象  
   *
   * @param userActivityInviteMap UserActivityInviteMap更新条件
   * @throws DAOException dao异常
   */
     public void updateUserActivityInviteMapByCond( UserActivityInviteMap userActivityInviteMap )throws DAOException;

     /**
   * 根据主键删除UserActivityInviteMap对象
   *
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @throws DAOException dao异常
   */
     public void deleteUserActivityInviteMap( UserActivityInviteMap userActivityInviteMap )throws DAOException;	
     /**
   * 根据主键批量删除UserActivityInviteMap对象
   *
   * @param userActivityInviteMapList UserActivityInviteMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserActivityInviteMapList( List<UserActivityInviteMap> userActivityInviteMapList )throws DAOException;
     
     /**
   * 根据条件删除UserActivityInviteMap对象
   *
   * @param userActivityInviteMap UserActivityInviteMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserActivityInviteMapByCond( UserActivityInviteMap userActivityInviteMap )throws DAOException;
     
     /**
   * 根据主键查询UserActivityInviteMap对象
   *
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @return 满足条件的UserActivityInviteMap对象
   * @throws DAOException dao异常
   */
     public UserActivityInviteMap getUserActivityInviteMap( UserActivityInviteMap userActivityInviteMap )throws DAOException;
     
     /**
   * 根据条件查询UserActivityInviteMap对象 
   *
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @return 满足条件的UserActivityInviteMap对象集
   * @throws DAOException dao异常
   */
     public List<UserActivityInviteMap> getUserActivityInviteMapByCond( UserActivityInviteMap userActivityInviteMap )throws DAOException;
     
	 /**
   * 根据条件精确查询UserActivityInviteMap对象 
   *
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @return 满足条件的UserActivityInviteMap对象集
   * @throws DAOException dao异常
   */
	 public List<UserActivityInviteMap> getUserActivityInviteMapByCondExact( UserActivityInviteMap userActivityInviteMap )throws DAOException;

	 /**
   * 根据条件查询UserActivityInviteMap对象 
   *
   * @param userActivityInviteMap UserActivityInviteMap对象
   * @return 满足条件的UserActivityInviteMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserActivityInviteMap> getUserActivityInviteMapByCond( UserActivityInviteMap userActivityInviteMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserActivityInviteMap对象，作为查询条件的参数
   *
   * @param userActivityInviteMap UserActivityInviteMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserActivityInviteMap对象，作为查询条件的参数
   *
   * @param userActivityInviteMap UserActivityInviteMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}