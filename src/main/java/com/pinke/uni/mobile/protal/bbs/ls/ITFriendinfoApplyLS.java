

package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITFriendinfoApplyLS
{
    /**
  * 新增TFriendinfoApply对象
  *
  * @param tfriendinfoApply TFriendinfoApply对象
  * @throws DomainServiceException ds异常
  */
	public String insertTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException;
  
  /**
  * 批量新增TFriendinfoApply对象
  *
  * @param tfriendinfoApplyList  TFriendinfoApply对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException;	
	
    /**
  * 更新TFriendinfoApply对象
  *
  * @param tfriendinfoApply TFriendinfoApply对象
  * @throws DomainServiceException ds异常
  */
	public String updateTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException;

    /**
  * 批量更新TFriendinfoApply对象
  *
  * @param tfriendinfoApplyList  TFriendinfoApply对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException;


	/**
  * 删除TFriendinfoApply对象
  *
  * @param tfriendinfoApply TFriendinfoApply对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException;

	/**
  * 批量删除TFriendinfoApply对象
  *
  * @param tfriendinfoApplyList  TFriendinfoApply对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException;

	/**
  * 查询TFriendinfoApply对象
  * 
  * @param tfriendinfoApply TFriendinfoApply对象
  * @return TFriendinfoApply对象
  * @throws DomainServiceException ds异常 
  */
	 public TFriendinfoApply getTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException; 

    /**
  * 根据主键查询TFriendinfoApply对象
  * 
  * @param applyindex TFriendinfoApply对象主键
  * @return TFriendinfoApply对象
  * @throws DomainServiceException ds异常 
  */
	 public TFriendinfoApply getTFriendinfoApplyByIndex(Long applyindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TFriendinfoApply对象 
   * 
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象集
   * @throws DomainServiceException ds异常
   */
     public List<TFriendinfoApply> getTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TFriendinfoApply对象 
   * 
   * @param tfriendinfoApply TFriendinfoApply对象
   * @return 满足条件的TFriendinfoApply对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TFriendinfoApply> getTFriendinfoApplyByCondExact( TFriendinfoApply tfriendinfoApply )throws DomainServiceException;

	 /**
   * 根据条件分页查询TFriendinfoApply对象 
   *
   * @param tfriendinfoApply TFriendinfoApply对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}