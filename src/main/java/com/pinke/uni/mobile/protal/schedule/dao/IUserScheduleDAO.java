package com.pinke.uni.mobile.protal.schedule.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserScheduleDAO
{
     /**
   * 新增UserSchedule对象 
   * 
   * @param userSchedule UserSchedule对象
   * @throws DAOException dao异常
   */ 
     public void insertUserSchedule( UserSchedule userSchedule )throws DAOException;
     /**
   * 批量新增UserSchedule对象 
   * 
   * @param userScheduleList UserSchedule对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserScheduleList( List<UserSchedule> userScheduleList )throws DAOException;
     /**
   * 根据主键更新UserSchedule对象
   * 
   * @param userSchedule UserSchedule对象
   * @throws DAOException dao异常
   */
     public void updateUserSchedule( UserSchedule userSchedule )throws DAOException;
     /**
   * 根据主键批量更新UserSchedule对象
   * 
   * @param userScheduleList UserSchedule对象列表
   * @throws DAOException dao异常
   */
     public void updateUserScheduleList( List<UserSchedule> userScheduleList )throws DAOException;

     /**
   * 根据条件更新UserSchedule对象  
   *
   * @param userSchedule UserSchedule更新条件
   * @throws DAOException dao异常
   */
     public void updateUserScheduleByCond( UserSchedule userSchedule )throws DAOException;

     /**
   * 根据主键删除UserSchedule对象
   *
   * @param userSchedule UserSchedule对象
   * @throws DAOException dao异常
   */
     public void deleteUserSchedule( UserSchedule userSchedule )throws DAOException;	
     /**
   * 根据主键批量删除UserSchedule对象
   *
   * @param userScheduleList UserSchedule对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserScheduleList( List<UserSchedule> userScheduleList )throws DAOException;
     
     /**
   * 根据条件删除UserSchedule对象
   *
   * @param userSchedule UserSchedule删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserScheduleByCond( UserSchedule userSchedule )throws DAOException;
     
     /**
   * 根据主键查询UserSchedule对象
   *
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象
   * @throws DAOException dao异常
   */
     public UserSchedule getUserSchedule( UserSchedule userSchedule )throws DAOException;
     
     /**
   * 根据条件查询UserSchedule对象 
   *
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象集
   * @throws DAOException dao异常
   */
     public List<UserSchedule> getUserScheduleByCond( UserSchedule userSchedule )throws DAOException;
     
	 /**
   * 根据条件精确查询UserSchedule对象 
   *
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象集
   * @throws DAOException dao异常
   */
	 public List<UserSchedule> getUserScheduleByCondExact( UserSchedule userSchedule )throws DAOException;

	 /**
   * 根据条件查询UserSchedule对象 
   *
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserSchedule> getUserScheduleByCond( UserSchedule userSchedule, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserSchedule对象，作为查询条件的参数
   *
   * @param userSchedule UserSchedule对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserSchedule对象，作为查询条件的参数
   *
   * @param userSchedule UserSchedule对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}