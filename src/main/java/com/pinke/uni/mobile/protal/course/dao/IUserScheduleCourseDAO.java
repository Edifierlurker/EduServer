package com.pinke.uni.mobile.protal.course.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserScheduleCourseDAO
{
     /**
   * 新增UserScheduleCourse对象 
   * 
   * @param userScheduleCourse UserScheduleCourse对象
   * @throws DAOException dao异常
   */ 
     public void insertUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DAOException;
     /**
   * 批量新增UserScheduleCourse对象 
   * 
   * @param userScheduleCourseList UserScheduleCourse对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DAOException;
     /**
   * 根据主键更新UserScheduleCourse对象
   * 
   * @param userScheduleCourse UserScheduleCourse对象
   * @throws DAOException dao异常
   */
     public void updateUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DAOException;
     /**
   * 根据主键批量更新UserScheduleCourse对象
   * 
   * @param userScheduleCourseList UserScheduleCourse对象列表
   * @throws DAOException dao异常
   */
     public void updateUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DAOException;

     /**
   * 根据条件更新UserScheduleCourse对象  
   *
   * @param userScheduleCourse UserScheduleCourse更新条件
   * @throws DAOException dao异常
   */
     public void updateUserScheduleCourseByCond( UserScheduleCourse userScheduleCourse )throws DAOException;

     /**
   * 根据主键删除UserScheduleCourse对象
   *
   * @param userScheduleCourse UserScheduleCourse对象
   * @throws DAOException dao异常
   */
     public void deleteUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DAOException;	
     /**
   * 根据主键批量删除UserScheduleCourse对象
   *
   * @param userScheduleCourseList UserScheduleCourse对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DAOException;
     
     /**
   * 根据条件删除UserScheduleCourse对象
   *
   * @param userScheduleCourse UserScheduleCourse删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserScheduleCourseByCond( UserScheduleCourse userScheduleCourse )throws DAOException;
     
     /**
   * 根据主键查询UserScheduleCourse对象
   *
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象
   * @throws DAOException dao异常
   */
     public UserScheduleCourse getUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DAOException;
     
     /**
   * 根据条件查询UserScheduleCourse对象 
   *
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象集
   * @throws DAOException dao异常
   */
     public List<UserScheduleCourse> getUserScheduleCourseByCond( UserScheduleCourse userScheduleCourse )throws DAOException;
     
	 /**
   * 根据条件精确查询UserScheduleCourse对象 
   *
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象集
   * @throws DAOException dao异常
   */
	 public List<UserScheduleCourse> getUserScheduleCourseByCondExact( UserScheduleCourse userScheduleCourse )throws DAOException;

	 /**
   * 根据条件查询UserScheduleCourse对象 
   *
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserScheduleCourse> getUserScheduleCourseByCond( UserScheduleCourse userScheduleCourse, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserScheduleCourse对象，作为查询条件的参数
   *
   * @param userScheduleCourse UserScheduleCourse对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserScheduleCourse对象，作为查询条件的参数
   *
   * @param userScheduleCourse UserScheduleCourse对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}