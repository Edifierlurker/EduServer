

package com.pinke.uni.mobile.protal.personal.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserSchedulePrivateLS
{
    /**
  * 新增UserSchedulePrivate对象
  *
  * @param userSchedulePrivate UserSchedulePrivate对象
  * @throws DomainServiceException ds异常
  */
	public String insertUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException;
  
  /**
  * 批量新增UserSchedulePrivate对象
  *
  * @param userSchedulePrivateList  UserSchedulePrivate对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DomainServiceException;	
	
    /**
  * 更新UserSchedulePrivate对象
  *
  * @param userSchedulePrivate UserSchedulePrivate对象
  * @throws DomainServiceException ds异常
  */
	public String updateUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException;

    /**
  * 批量更新UserSchedulePrivate对象
  *
  * @param userSchedulePrivateList  UserSchedulePrivate对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DomainServiceException;


	/**
  * 删除UserSchedulePrivate对象
  *
  * @param userSchedulePrivate UserSchedulePrivate对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException;

	/**
  * 批量删除UserSchedulePrivate对象
  *
  * @param userSchedulePrivateList  UserSchedulePrivate对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserSchedulePrivateList( List<UserSchedulePrivate> userSchedulePrivateList )throws DomainServiceException;

	/**
  * 查询UserSchedulePrivate对象
  * 
  * @param userSchedulePrivate UserSchedulePrivate对象
  * @return UserSchedulePrivate对象
  * @throws DomainServiceException ds异常 
  */
	 public UserSchedulePrivate getUserSchedulePrivate( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException; 

    /**
  * 根据主键查询UserSchedulePrivate对象
  * 
  * @param privateindex UserSchedulePrivate对象主键
  * @return UserSchedulePrivate对象
  * @throws DomainServiceException ds异常 
  */
	 public UserSchedulePrivate getUserSchedulePrivateByIndex(Long privateindex) throws DomainServiceException; 

	 /**
   * 根据条件查询UserSchedulePrivate对象 
   * 
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象集
   * @throws DomainServiceException ds异常
   */
     public List<UserSchedulePrivate> getUserSchedulePrivateByCond( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询UserSchedulePrivate对象 
   * 
   * @param userSchedulePrivate UserSchedulePrivate对象
   * @return 满足条件的UserSchedulePrivate对象集
   * @throws DomainServiceException ds异常
   */
	 public List<UserSchedulePrivate> getUserSchedulePrivateByCondExact( UserSchedulePrivate userSchedulePrivate )throws DomainServiceException;

	 /**
   * 根据条件分页查询UserSchedulePrivate对象 
   *
   * @param userSchedulePrivate UserSchedulePrivate对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserSchedulePrivate userSchedulePrivate, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}