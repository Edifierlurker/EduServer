

package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITMajorinfoDS
{
    /**
  * 新增TMajorinfo对象
  *
  * @param tmajorinfo TMajorinfo对象
  * @throws DomainServiceException ds异常
  */
	public void insertTMajorinfo( TMajorinfo tmajorinfo )throws DomainServiceException;
   /**
  * 批量新增TMajorinfo对象
  *
  * @param tmajorinfoList  TMajorinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DomainServiceException;	
	
    /**
  * 更新TMajorinfo对象
  *
  * @param tmajorinfo TMajorinfo对象
  * @throws DomainServiceException ds异常
  */
	public void updateTMajorinfo( TMajorinfo tmajorinfo )throws DomainServiceException;

    /**
  * 批量更新TMajorinfo对象
  *
  * @param tmajorinfoList  TMajorinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DomainServiceException;


	/**
  * 删除TMajorinfo对象
  *
  * @param tmajorinfo TMajorinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTMajorinfo( TMajorinfo tmajorinfo )throws DomainServiceException;

	/**
  * 批量删除TMajorinfo对象
  *
  * @param tmajorinfoList  TMajorinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTMajorinfoList( List<TMajorinfo> tmajorinfoList )throws DomainServiceException;


	/**
  * 查询TMajorinfo对象
  * 
  * @param tmajorinfo TMajorinfo对象
  * @return TMajorinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TMajorinfo getTMajorinfo( TMajorinfo tmajorinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TMajorinfo对象
  * 
  * @param majorindex TMajorinfo对象主键
  * @return TMajorinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TMajorinfo getTMajorinfoByIndex(Long majorindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TMajorinfo对象 
   * 
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TMajorinfo> getTMajorinfoByCond( TMajorinfo tmajorinfo )throws DomainServiceException;
	 /**
   * 根据条件精确查询TMajorinfo对象 
   * 
   * @param tmajorinfo TMajorinfo对象
   * @return 满足条件的TMajorinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TMajorinfo> getTMajorinfoByCondExact( TMajorinfo tmajorinfo )throws DomainServiceException;
	 /**
   * 根据条件分页查询TMajorinfo对象 
   *
   * @param tmajorinfo TMajorinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TMajorinfo对象 
   *
   * @param tmajorinfo TMajorinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TMajorinfo tmajorinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}