package com.pinke.uni.mobile.protal.exam.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserExaminfoAttendMapDAO
{
     /**
   * 新增UserExaminfoAttendMap对象 
   * 
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @throws DAOException dao异常
   */ 
     public void insertUserExaminfoAttendMap( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;
     /**
   * 批量新增UserExaminfoAttendMap对象 
   * 
   * @param userExaminfoAttendMapList UserExaminfoAttendMap对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserExaminfoAttendMapList( List<UserExaminfoAttendMap> userExaminfoAttendMapList )throws DAOException;
     /**
   * 根据主键更新UserExaminfoAttendMap对象
   * 
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @throws DAOException dao异常
   */
     public void updateUserExaminfoAttendMap( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;
     /**
   * 根据主键批量更新UserExaminfoAttendMap对象
   * 
   * @param userExaminfoAttendMapList UserExaminfoAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void updateUserExaminfoAttendMapList( List<UserExaminfoAttendMap> userExaminfoAttendMapList )throws DAOException;

     /**
   * 根据条件更新UserExaminfoAttendMap对象  
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap更新条件
   * @throws DAOException dao异常
   */
     public void updateUserExaminfoAttendMapByCond( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;

     /**
   * 根据主键删除UserExaminfoAttendMap对象
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @throws DAOException dao异常
   */
     public void deleteUserExaminfoAttendMap( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;	
     /**
   * 根据主键批量删除UserExaminfoAttendMap对象
   *
   * @param userExaminfoAttendMapList UserExaminfoAttendMap对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserExaminfoAttendMapList( List<UserExaminfoAttendMap> userExaminfoAttendMapList )throws DAOException;
     
     /**
   * 根据条件删除UserExaminfoAttendMap对象
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserExaminfoAttendMapByCond( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;
     
     /**
   * 根据主键查询UserExaminfoAttendMap对象
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @return 满足条件的UserExaminfoAttendMap对象
   * @throws DAOException dao异常
   */
     public UserExaminfoAttendMap getUserExaminfoAttendMap( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;
     
     /**
   * 根据条件查询UserExaminfoAttendMap对象 
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @return 满足条件的UserExaminfoAttendMap对象集
   * @throws DAOException dao异常
   */
     public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;
     
	 /**
   * 根据条件精确查询UserExaminfoAttendMap对象 
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @return 满足条件的UserExaminfoAttendMap对象集
   * @throws DAOException dao异常
   */
	 public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCondExact( UserExaminfoAttendMap userExaminfoAttendMap )throws DAOException;

	 /**
   * 根据条件查询UserExaminfoAttendMap对象 
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象
   * @return 满足条件的UserExaminfoAttendMap对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond( UserExaminfoAttendMap userExaminfoAttendMap, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserExaminfoAttendMap对象，作为查询条件的参数
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserExaminfoAttendMap对象，作为查询条件的参数
   *
   * @param userExaminfoAttendMap UserExaminfoAttendMap对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}