

package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IAppVersionmgtLS
{
    /**
  * 新增AppVersionmgt对象
  *
  * @param appVersionmgt AppVersionmgt对象
  * @throws DomainServiceException ds异常
  */
	public String insertAppVersionmgt( AppVersionmgt appVersionmgt )throws DomainServiceException;
  
  /**
  * 批量新增AppVersionmgt对象
  *
  * @param appVersionmgtList  AppVersionmgt对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DomainServiceException;	
	
    /**
  * 更新AppVersionmgt对象
  *
  * @param appVersionmgt AppVersionmgt对象
  * @throws DomainServiceException ds异常
  */
	public String updateAppVersionmgt( AppVersionmgt appVersionmgt )throws DomainServiceException;

    /**
  * 批量更新AppVersionmgt对象
  *
  * @param appVersionmgtList  AppVersionmgt对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DomainServiceException;


	/**
  * 删除AppVersionmgt对象
  *
  * @param appVersionmgt AppVersionmgt对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeAppVersionmgt( AppVersionmgt appVersionmgt )throws DomainServiceException;

	/**
  * 批量删除AppVersionmgt对象
  *
  * @param appVersionmgtList  AppVersionmgt对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DomainServiceException;

	/**
  * 查询AppVersionmgt对象
  * 
  * @param appVersionmgt AppVersionmgt对象
  * @return AppVersionmgt对象
  * @throws DomainServiceException ds异常 
  */
	 public AppVersionmgt getAppVersionmgt( AppVersionmgt appVersionmgt )throws DomainServiceException; 

    /**
  * 根据主键查询AppVersionmgt对象
  * 
  * @param versionindex AppVersionmgt对象主键
  * @return AppVersionmgt对象
  * @throws DomainServiceException ds异常 
  */
	 public AppVersionmgt getAppVersionmgtByIndex(Long versionindex) throws DomainServiceException; 

	 /**
   * 根据条件查询AppVersionmgt对象 
   * 
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象集
   * @throws DomainServiceException ds异常
   */
     public List<AppVersionmgt> getAppVersionmgtByCond( AppVersionmgt appVersionmgt )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询AppVersionmgt对象 
   * 
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象集
   * @throws DomainServiceException ds异常
   */
	 public List<AppVersionmgt> getAppVersionmgtByCondExact( AppVersionmgt appVersionmgt )throws DomainServiceException;

	 /**
   * 根据条件分页查询AppVersionmgt对象 
   *
   * @param appVersionmgt AppVersionmgt对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}