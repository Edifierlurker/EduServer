

package com.pinke.uni.mobile.protal.course.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourse;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserScheduleCourseLS
{
    /**
  * 新增UserScheduleCourse对象
  *
  * @param userScheduleCourse UserScheduleCourse对象
  * @throws DomainServiceException ds异常
  */
	public String insertUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DomainServiceException;
  
  /**
  * 批量新增UserScheduleCourse对象
  *
  * @param userScheduleCourseList  UserScheduleCourse对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DomainServiceException;	
	
    /**
  * 更新UserScheduleCourse对象
  *
  * @param userScheduleCourse UserScheduleCourse对象
  * @throws DomainServiceException ds异常
  */
	public String updateUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DomainServiceException;

    /**
  * 批量更新UserScheduleCourse对象
  *
  * @param userScheduleCourseList  UserScheduleCourse对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DomainServiceException;


	/**
  * 删除UserScheduleCourse对象
  *
  * @param userScheduleCourse UserScheduleCourse对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DomainServiceException;

	/**
  * 批量删除UserScheduleCourse对象
  *
  * @param userScheduleCourseList  UserScheduleCourse对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserScheduleCourseList( List<UserScheduleCourse> userScheduleCourseList )throws DomainServiceException;

	/**
  * 查询UserScheduleCourse对象
  * 
  * @param userScheduleCourse UserScheduleCourse对象
  * @return UserScheduleCourse对象
  * @throws DomainServiceException ds异常 
  */
	 public UserScheduleCourse getUserScheduleCourse( UserScheduleCourse userScheduleCourse )throws DomainServiceException; 

    /**
  * 根据主键查询UserScheduleCourse对象
  * 
  * @param courseindex UserScheduleCourse对象主键
  * @return UserScheduleCourse对象
  * @throws DomainServiceException ds异常 
  */
	 public UserScheduleCourse getUserScheduleCourseByIndex(Long courseindex) throws DomainServiceException; 

	 /**
   * 根据条件查询UserScheduleCourse对象 
   * 
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象集
   * @throws DomainServiceException ds异常
   */
     public List<UserScheduleCourse> getUserScheduleCourseByCond( UserScheduleCourse userScheduleCourse )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询UserScheduleCourse对象 
   * 
   * @param userScheduleCourse UserScheduleCourse对象
   * @return 满足条件的UserScheduleCourse对象集
   * @throws DomainServiceException ds异常
   */
	 public List<UserScheduleCourse> getUserScheduleCourseByCondExact( UserScheduleCourse userScheduleCourse )throws DomainServiceException;

	 /**
   * 根据条件分页查询UserScheduleCourse对象 
   *
   * @param userScheduleCourse UserScheduleCourse对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserScheduleCourse userScheduleCourse, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}