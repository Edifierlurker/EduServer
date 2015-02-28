

package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupCategoryMapLS
{
    /**
  * 新增TGroupCategoryMap对象
  *
  * @param tgroupCategoryMap TGroupCategoryMap对象
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException;
  
  /**
  * 批量新增TGroupCategoryMap对象
  *
  * @param tgroupCategoryMapList  TGroupCategoryMap对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException;	
	
    /**
  * 更新TGroupCategoryMap对象
  *
  * @param tgroupCategoryMap TGroupCategoryMap对象
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException;

    /**
  * 批量更新TGroupCategoryMap对象
  *
  * @param tgroupCategoryMapList  TGroupCategoryMap对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException;


	/**
  * 删除TGroupCategoryMap对象
  *
  * @param tgroupCategoryMap TGroupCategoryMap对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException;

	/**
  * 批量删除TGroupCategoryMap对象
  *
  * @param tgroupCategoryMapList  TGroupCategoryMap对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException;

	/**
  * 查询TGroupCategoryMap对象
  * 
  * @param tgroupCategoryMap TGroupCategoryMap对象
  * @return TGroupCategoryMap对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupCategoryMap getTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException; 

    /**
  * 根据主键查询TGroupCategoryMap对象
  * 
  * @param mapindex TGroupCategoryMap对象主键
  * @return TGroupCategoryMap对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupCategoryMap getTGroupCategoryMapByIndex(Long mapindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TGroupCategoryMap对象 
   * 
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象集
   * @throws DomainServiceException ds异常
   */
     public List<TGroupCategoryMap> getTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TGroupCategoryMap对象 
   * 
   * @param tgroupCategoryMap TGroupCategoryMap对象
   * @return 满足条件的TGroupCategoryMap对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TGroupCategoryMap> getTGroupCategoryMapByCondExact( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException;

	 /**
   * 根据条件分页查询TGroupCategoryMap对象 
   *
   * @param tgroupCategoryMap TGroupCategoryMap对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}