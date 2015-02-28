

package com.pinke.uni.mobile.protal.schedule.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.schedule.model.UserSchedule;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserScheduleLS
{
    /**
  * 新增UserSchedule对象
  *
  * @param userSchedule UserSchedule对象
  * @throws DomainServiceException ds异常
  */
	public String insertUserSchedule( UserSchedule userSchedule )throws DomainServiceException;
  
  /**
  * 批量新增UserSchedule对象
  *
  * @param userScheduleList  UserSchedule对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertUserScheduleList( List<UserSchedule> userScheduleList )throws DomainServiceException;	
	
    /**
  * 更新UserSchedule对象
  *
  * @param userSchedule UserSchedule对象
  * @throws DomainServiceException ds异常
  */
	public String updateUserSchedule( UserSchedule userSchedule )throws DomainServiceException;

    /**
  * 批量更新UserSchedule对象
  *
  * @param userScheduleList  UserSchedule对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateUserScheduleList( List<UserSchedule> userScheduleList )throws DomainServiceException;


	/**
  * 删除UserSchedule对象
  *
  * @param userSchedule UserSchedule对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserSchedule( UserSchedule userSchedule )throws DomainServiceException;

	/**
  * 批量删除UserSchedule对象
  *
  * @param userScheduleList  UserSchedule对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserScheduleList( List<UserSchedule> userScheduleList )throws DomainServiceException;

	/**
  * 查询UserSchedule对象
  * 
  * @param userSchedule UserSchedule对象
  * @return UserSchedule对象
  * @throws DomainServiceException ds异常 
  */
	 public UserSchedule getUserSchedule( UserSchedule userSchedule )throws DomainServiceException; 

    /**
  * 根据主键查询UserSchedule对象
  * 
  * @param scheduleindex UserSchedule对象主键
  * @return UserSchedule对象
  * @throws DomainServiceException ds异常 
  */
	 public UserSchedule getUserScheduleByIndex(Long scheduleindex) throws DomainServiceException; 

	 /**
   * 根据条件查询UserSchedule对象 
   * 
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象集
   * @throws DomainServiceException ds异常
   */
     public List<UserSchedule> getUserScheduleByCond( UserSchedule userSchedule )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询UserSchedule对象 
   * 
   * @param userSchedule UserSchedule对象
   * @return 满足条件的UserSchedule对象集
   * @throws DomainServiceException ds异常
   */
	 public List<UserSchedule> getUserScheduleByCondExact( UserSchedule userSchedule )throws DomainServiceException;

	 /**
   * 根据条件分页查询UserSchedule对象 
   *
   * @param userSchedule UserSchedule对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserSchedule userSchedule, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}