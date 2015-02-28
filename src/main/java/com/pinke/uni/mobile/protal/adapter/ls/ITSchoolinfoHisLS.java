

package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITSchoolinfoHisLS
{
    /**
  * 新增TSchoolinfoHis对象
  *
  * @param tschoolinfoHis TSchoolinfoHis对象
  * @throws DomainServiceException ds异常
  */
	public String insertTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException;
  
  /**
  * 批量新增TSchoolinfoHis对象
  *
  * @param tschoolinfoHisList  TSchoolinfoHis对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DomainServiceException;	
	
    /**
  * 更新TSchoolinfoHis对象
  *
  * @param tschoolinfoHis TSchoolinfoHis对象
  * @throws DomainServiceException ds异常
  */
	public String updateTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException;

    /**
  * 批量更新TSchoolinfoHis对象
  *
  * @param tschoolinfoHisList  TSchoolinfoHis对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DomainServiceException;


	/**
  * 删除TSchoolinfoHis对象
  *
  * @param tschoolinfoHis TSchoolinfoHis对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException;

	/**
  * 批量删除TSchoolinfoHis对象
  *
  * @param tschoolinfoHisList  TSchoolinfoHis对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTSchoolinfoHisList( List<TSchoolinfoHis> tschoolinfoHisList )throws DomainServiceException;

	/**
  * 查询TSchoolinfoHis对象
  * 
  * @param tschoolinfoHis TSchoolinfoHis对象
  * @return TSchoolinfoHis对象
  * @throws DomainServiceException ds异常 
  */
	 public TSchoolinfoHis getTSchoolinfoHis( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException; 

    /**
  * 根据主键查询TSchoolinfoHis对象
  * 
  * @param mapindex TSchoolinfoHis对象主键
  * @return TSchoolinfoHis对象
  * @throws DomainServiceException ds异常 
  */
	 public TSchoolinfoHis getTSchoolinfoHisByIndex(Long mapindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TSchoolinfoHis对象 
   * 
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象集
   * @throws DomainServiceException ds异常
   */
     public List<TSchoolinfoHis> getTSchoolinfoHisByCond( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TSchoolinfoHis对象 
   * 
   * @param tschoolinfoHis TSchoolinfoHis对象
   * @return 满足条件的TSchoolinfoHis对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TSchoolinfoHis> getTSchoolinfoHisByCondExact( TSchoolinfoHis tschoolinfoHis )throws DomainServiceException;

	 /**
   * 根据条件分页查询TSchoolinfoHis对象 
   *
   * @param tschoolinfoHis TSchoolinfoHis对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TSchoolinfoHis tschoolinfoHis, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}