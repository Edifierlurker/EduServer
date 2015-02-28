

package com.pinke.uni.mobile.protal.adapter.service;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITCollegeinfoDS
{
    /**
  * 新增TCollegeinfo对象
  *
  * @param tcollegeinfo TCollegeinfo对象
  * @throws DomainServiceException ds异常
  */
	public void insertTCollegeinfo( TCollegeinfo tcollegeinfo )throws DomainServiceException;
   /**
  * 批量新增TCollegeinfo对象
  *
  * @param tcollegeinfoList  TCollegeinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DomainServiceException;	
	
    /**
  * 更新TCollegeinfo对象
  *
  * @param tcollegeinfo TCollegeinfo对象
  * @throws DomainServiceException ds异常
  */
	public void updateTCollegeinfo( TCollegeinfo tcollegeinfo )throws DomainServiceException;

    /**
  * 批量更新TCollegeinfo对象
  *
  * @param tcollegeinfoList  TCollegeinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DomainServiceException;


	/**
  * 删除TCollegeinfo对象
  *
  * @param tcollegeinfo TCollegeinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTCollegeinfo( TCollegeinfo tcollegeinfo )throws DomainServiceException;

	/**
  * 批量删除TCollegeinfo对象
  *
  * @param tcollegeinfoList  TCollegeinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTCollegeinfoList( List<TCollegeinfo> tcollegeinfoList )throws DomainServiceException;


	/**
  * 查询TCollegeinfo对象
  * 
  * @param tcollegeinfo TCollegeinfo对象
  * @return TCollegeinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TCollegeinfo getTCollegeinfo( TCollegeinfo tcollegeinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TCollegeinfo对象
  * 
  * @param collegeindex TCollegeinfo对象主键
  * @return TCollegeinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TCollegeinfo getTCollegeinfoByIndex(Long collegeindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TCollegeinfo对象 
   * 
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TCollegeinfo> getTCollegeinfoByCond( TCollegeinfo tcollegeinfo )throws DomainServiceException;
	 /**
   * 根据条件精确查询TCollegeinfo对象 
   * 
   * @param tcollegeinfo TCollegeinfo对象
   * @return 满足条件的TCollegeinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TCollegeinfo> getTCollegeinfoByCondExact( TCollegeinfo tcollegeinfo )throws DomainServiceException;
	 /**
   * 根据条件分页查询TCollegeinfo对象 
   *
   * @param tcollegeinfo TCollegeinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TCollegeinfo对象 
   *
   * @param tcollegeinfo TCollegeinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TCollegeinfo tcollegeinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}