

package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITSchoolinfoDS
{
    /**
  * 新增TSchoolinfo对象
  *
  * @param tschoolinfo TSchoolinfo对象
  * @throws DomainServiceException ds异常
  */
	public void insertTSchoolinfo( TSchoolinfo tschoolinfo )throws DomainServiceException;
   /**
  * 批量新增TSchoolinfo对象
  *
  * @param tschoolinfoList  TSchoolinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DomainServiceException;	
	
    /**
  * 更新TSchoolinfo对象
  *
  * @param tschoolinfo TSchoolinfo对象
  * @throws DomainServiceException ds异常
  */
	public void updateTSchoolinfo( TSchoolinfo tschoolinfo )throws DomainServiceException;

    /**
  * 批量更新TSchoolinfo对象
  *
  * @param tschoolinfoList  TSchoolinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DomainServiceException;

	/**
  * 根据条件更新TSchoolinfo对象  
  *
  * @param tschoolinfo TSchoolinfo更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTSchoolinfoByCond( TSchoolinfo tschoolinfo )throws DomainServiceException;

	/**
  * 删除TSchoolinfo对象
  *
  * @param tschoolinfo TSchoolinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTSchoolinfo( TSchoolinfo tschoolinfo )throws DomainServiceException;

	/**
  * 批量删除TSchoolinfo对象
  *
  * @param tschoolinfoList  TSchoolinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTSchoolinfoList( List<TSchoolinfo> tschoolinfoList )throws DomainServiceException;


	/**
  * 查询TSchoolinfo对象
  * 
  * @param tschoolinfo TSchoolinfo对象
  * @return TSchoolinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TSchoolinfo getTSchoolinfo( TSchoolinfo tschoolinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TSchoolinfo对象
  * 
  * @param schoolindex TSchoolinfo对象主键
  * @return TSchoolinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TSchoolinfo getTSchoolinfoByIndex(Long schoolindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TSchoolinfo对象 
   * 
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TSchoolinfo> getTSchoolinfoByCond( TSchoolinfo tschoolinfo )throws DomainServiceException;
	 /**
   * 根据条件精确查询TSchoolinfo对象 
   * 
   * @param tschoolinfo TSchoolinfo对象
   * @return 满足条件的TSchoolinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TSchoolinfo> getTSchoolinfoByCondExact( TSchoolinfo tschoolinfo )throws DomainServiceException;
	 /**
   * 根据条件分页查询TSchoolinfo对象 
   *
   * @param tschoolinfo TSchoolinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TSchoolinfo对象 
   *
   * @param tschoolinfo TSchoolinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TSchoolinfo tschoolinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}