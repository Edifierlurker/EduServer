

package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupCategoryLS
{
    /**
  * 新增TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;
  
  /**
  * 批量新增TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;	
	
    /**
  * 更新TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;

    /**
  * 批量更新TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;


	/**
  * 删除TGroupCategory对象
  *
  * @param tgroupCategory TGroupCategory对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupCategory( TGroupCategory tgroupCategory )throws DomainServiceException;

	/**
  * 批量删除TGroupCategory对象
  *
  * @param tgroupCategoryList  TGroupCategory对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupCategoryList( List<TGroupCategory> tgroupCategoryList )throws DomainServiceException;

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
     public TableDataInfo pageInfoQuery(TGroupCategory tgroupCategory, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}