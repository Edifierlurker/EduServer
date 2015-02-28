package com.pinke.uni.mobile.protal.personal.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserSchedulePrivateDAO
{
     /**
   * 新增UserSchedulePrivate对象 
   * 
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @throws DAOException dao异常
   */ 
     public void insertUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DAOException;
     /**
   * 批量新增UserSchedulePrivate对象 
   * 
   * @param userSchedulePrivateList UserSchedulePrivate对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DAOException;
     /**
   * 根据主键更新UserSchedulePrivate对象
   * 
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @throws DAOException dao异常
   */
     public void updateUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DAOException;
     /**
   * 根据主键批量更新UserSchedulePrivate对象
   * 
   * @param userSchedulePrivateList UserSchedulePrivate对象列表
   * @throws DAOException dao异常
   */
     public void updateUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DAOException;

     /**
   * 根据条件更新UserSchedulePrivate对象  
   *
   * @param userSchedulePrivate UserSchedulePrivate更新条件
   * @throws DAOException dao异常
   */
     public void updateUserSchedulePrivateByCond( UserSchedulePrivate userSchedulePrivate )throws DAOException;

     /**
   * 根据主键删除UserSchedulePrivate对象
   *
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @throws DAOException dao异常
   */
     public void deleteUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DAOException;	
     /**
   * 根据主键批量删除UserSchedulePrivate对象
   *
   * @param userSchedulePrivateList UserSchedulePrivate对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DAOException;
     
     /**
   * 根据条件删除UserSchedulePrivate对象
   *
   * @param userSchedulePrivate UserSchedulePrivate删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserSchedulePrivateByCond( UserSchedulePrivate userSchedulePrivate )throws DAOException;
     
     /**
   * 根据主键查询UserSchedulePrivate对象
   *
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象
   * @throws DAOException dao异常
   */
     public UserSchedulePrivate getUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DAOException;
     
     /**
   * 根据条件查询UserSchedulePrivate对象 
   *
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象集
   * @throws DAOException dao异常
   */
     public List<UserSchedulePrivate> getUserSchedulePrivateByCond( UserSchedulePrivate userSchedulePrivate )throws DAOException;
     
	 /**
   * 根据条件精确查询UserSchedulePrivate对象 
   *
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象集
   * @throws DAOException dao异常
   */
	 public List<UserSchedulePrivate> getUserSchedulePrivateByCondExact( UserSchedulePrivate userSchedulePrivate )throws DAOException;

	 /**
   * 根据条件查询UserSchedulePrivate对象 
   *
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserSchedulePrivate> getUserSchedulePrivateByCond( UserSchedulePrivate userSchedulePrivate, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserSchedulePrivate对象，作为查询条件的参数
   *
   * @param userSchedulePrivate UserSchedulePrivate对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserSchedulePrivate对象，作为查询条件的参数
   *
   * @param userSchedulePrivate UserSchedulePrivate对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}