

package com.pinke.uni.mobile.protal.group.service;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupCategoryDS
{
    /**
  * 新增TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */
	public void insertTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;
   /**
  * 批量新增TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;	
	
    /**
  * 更新TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */
	public void updateTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;

    /**
  * 批量更新TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;

	/**
  * 根据条件更新TGroupCategory对象  
  *
  * @param tgroupCategory TGroupCategory更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DomainServiceException;

	/**
  * 删除TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;

	/**
  * 批量删除TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;

    /**
  * 根据条件删除TGroupCategory对象
  * 
  * @param tgroupCategory TGroupCategory删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DomainServiceException;	

	/**
  * 查询TGroupCategory对象
  * 
  * @param tgroupCategory TGroupCategory对象
  * @return TGroupCategory对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupCategory getTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException; 

    /**
  * 根据主键查询TGroupCategory对象
  * 
  * @param categoryindex TGroupCategory对象主键
  * @return TGroupCategory对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupCategory getTGroupCategoryByIndex(Long categoryindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TGroupCategory对象 
   * 
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象集
   * @throws DomainServiceException ds异常
   */
     public List<TGroupCategory> getTGroupCategoryByCond( TGroupCategory tgroupCategory )throws DomainServiceException;
	 /**
   * 根据条件精确查询TGroupCategory对象 
   * 
   * @param tgroupCategory TGroupCategory对象
   * @return 满足条件的TGroupCategory对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TGroupCategory> getTGroupCategoryByCondExact( TGroupCategory tgroupCategory )throws DomainServiceException;
	 /**
   * 根据条件分页查询TGroupCategory对象 
   *
   * @param tgroupCategory TGroupCategory对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TGroupCategory对象 
   *
   * @param tgroupCategory TGroupCategory对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}