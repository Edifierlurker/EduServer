

package com.pinke.uni.mobile.protal.course.service;

import java.util.List;
import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserScheduleCourseAttendMapDS
{
    /**
  * 新增UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
  * @throws DomainServiceException ds异常
  */
	public void insertUserScheduleCourseAttendMap( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;
   /**
  * 批量新增UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMapList  UserScheduleCourseAttendMap对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertUserScheduleCourseAttendMapList( List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList )throws DomainServiceException;	
	
    /**
  * 更新UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
  * @throws DomainServiceException ds异常
  */
	public void updateUserScheduleCourseAttendMap( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;

    /**
  * 批量更新UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMapList  UserScheduleCourseAttendMap对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateUserScheduleCourseAttendMapList( List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList )throws DomainServiceException;

	/**
  * 根据条件更新UserScheduleCourseAttendMap对象  
  *
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateUserScheduleCourseAttendMapByCond( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;

	/**
  * 删除UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeUserScheduleCourseAttendMap( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;

	/**
  * 批量删除UserScheduleCourseAttendMap对象
  *
  * @param userScheduleCourseAttendMapList  UserScheduleCourseAttendMap对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeUserScheduleCourseAttendMapList( List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList )throws DomainServiceException;

    /**
  * 根据条件删除UserScheduleCourseAttendMap对象
  * 
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeUserScheduleCourseAttendMapByCond( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;	

	/**
  * 查询UserScheduleCourseAttendMap对象
  * 
  * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
  * @return UserScheduleCourseAttendMap对象
  * @throws DomainServiceException ds异常 
  */
	 public UserScheduleCourseAttendMap getUserScheduleCourseAttendMap( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException; 

    /**
  * 根据主键查询UserScheduleCourseAttendMap对象
  * 
  * @param courseattendindex UserScheduleCourseAttendMap对象主键
  * @return UserScheduleCourseAttendMap对象
  * @throws DomainServiceException ds异常 
  */
	 public UserScheduleCourseAttendMap getUserScheduleCourseAttendMapByIndex(Long courseattendindex) throws DomainServiceException; 
	 /**
   * 根据条件查询UserScheduleCourseAttendMap对象 
   * 
   * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
   * @return 满足条件的UserScheduleCourseAttendMap对象集
   * @throws DomainServiceException ds异常
   */
     public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;
	 /**
   * 根据条件精确查询UserScheduleCourseAttendMap对象 
   * 
   * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象
   * @return 满足条件的UserScheduleCourseAttendMap对象集
   * @throws DomainServiceException ds异常
   */
	 public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCondExact( UserScheduleCourseAttendMap userScheduleCourseAttendMap )throws DomainServiceException;
	 /**
   * 根据条件分页查询UserScheduleCourseAttendMap对象 
   *
   * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询UserScheduleCourseAttendMap对象 
   *
   * @param userScheduleCourseAttendMap UserScheduleCourseAttendMap对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}