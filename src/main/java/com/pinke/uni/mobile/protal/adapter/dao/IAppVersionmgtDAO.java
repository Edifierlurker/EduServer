package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IAppVersionmgtDAO
{
     /**
   * 新增AppVersionmgt对象 
   * 
   * @param appVersionmgt AppVersionmgt对象
   * @throws DAOException dao异常
   */ 
     public void insertAppVersionmgt( AppVersionmgt appVersionmgt )throws DAOException;
     /**
   * 批量新增AppVersionmgt对象 
   * 
   * @param appVersionmgtList AppVersionmgt对象列表
   * @throws DAOException dao异常
   */ 
     public void insertAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DAOException;
     /**
   * 根据主键更新AppVersionmgt对象
   * 
   * @param appVersionmgt AppVersionmgt对象
   * @throws DAOException dao异常
   */
     public void updateAppVersionmgt( AppVersionmgt appVersionmgt )throws DAOException;
     /**
   * 根据主键批量更新AppVersionmgt对象
   * 
   * @param appVersionmgtList AppVersionmgt对象列表
   * @throws DAOException dao异常
   */
     public void updateAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DAOException;

     /**
   * 根据条件更新AppVersionmgt对象  
   *
   * @param appVersionmgt AppVersionmgt更新条件
   * @throws DAOException dao异常
   */
     public void updateAppVersionmgtByCond( AppVersionmgt appVersionmgt )throws DAOException;

     /**
   * 根据主键删除AppVersionmgt对象
   *
   * @param appVersionmgt AppVersionmgt对象
   * @throws DAOException dao异常
   */
     public void deleteAppVersionmgt( AppVersionmgt appVersionmgt )throws DAOException;	
     /**
   * 根据主键批量删除AppVersionmgt对象
   *
   * @param appVersionmgtList AppVersionmgt对象列表
   * @throws DAOException dao异常
   */
     public void deleteAppVersionmgtList( List<AppVersionmgt> appVersionmgtList )throws DAOException;
     
     /**
   * 根据条件删除AppVersionmgt对象
   *
   * @param appVersionmgt AppVersionmgt删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteAppVersionmgtByCond( AppVersionmgt appVersionmgt )throws DAOException;
     
     /**
   * 根据主键查询AppVersionmgt对象
   *
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象
   * @throws DAOException dao异常
   */
     public AppVersionmgt getAppVersionmgt( AppVersionmgt appVersionmgt )throws DAOException;
     
     /**
   * 根据条件查询AppVersionmgt对象 
   *
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象集
   * @throws DAOException dao异常
   */
     public List<AppVersionmgt> getAppVersionmgtByCond( AppVersionmgt appVersionmgt )throws DAOException;
     
	 /**
   * 根据条件精确查询AppVersionmgt对象 
   *
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象集
   * @throws DAOException dao异常
   */
	 public List<AppVersionmgt> getAppVersionmgtByCondExact( AppVersionmgt appVersionmgt )throws DAOException;

	 /**
   * 根据条件查询AppVersionmgt对象 
   *
   * @param appVersionmgt AppVersionmgt对象
   * @return 满足条件的AppVersionmgt对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<AppVersionmgt> getAppVersionmgtByCond( AppVersionmgt appVersionmgt, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询AppVersionmgt对象，作为查询条件的参数
   *
   * @param appVersionmgt AppVersionmgt对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询AppVersionmgt对象，作为查询条件的参数
   *
   * @param appVersionmgt AppVersionmgt对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(AppVersionmgt appVersionmgt, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}