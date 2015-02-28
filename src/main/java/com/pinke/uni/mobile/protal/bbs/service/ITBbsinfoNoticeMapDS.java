

package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITBbsinfoNoticeMapDS
{
    /**
  * 新增TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
  * @throws DomainServiceException ds异常
  */
	public void insertTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;
   /**
  * 批量新增TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMapList  TBbsinfoNoticeMap对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DomainServiceException;	
	
    /**
  * 更新TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
  * @throws DomainServiceException ds异常
  */
	public void updateTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;

    /**
  * 批量更新TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMapList  TBbsinfoNoticeMap对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DomainServiceException;

	/**
  * 根据条件更新TBbsinfoNoticeMap对象  
  *
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;

	/**
  * 删除TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;

	/**
  * 批量删除TBbsinfoNoticeMap对象
  *
  * @param tbbsinfoNoticeMapList  TBbsinfoNoticeMap对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DomainServiceException;

    /**
  * 根据条件删除TBbsinfoNoticeMap对象
  * 
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;	

	/**
  * 查询TBbsinfoNoticeMap对象
  * 
  * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
  * @return TBbsinfoNoticeMap对象
  * @throws DomainServiceException ds异常 
  */
	 public TBbsinfoNoticeMap getTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException; 

    /**
  * 根据主键查询TBbsinfoNoticeMap对象
  * 
  * @param mapindex TBbsinfoNoticeMap对象主键
  * @return TBbsinfoNoticeMap对象
  * @throws DomainServiceException ds异常 
  */
	 public TBbsinfoNoticeMap getTBbsinfoNoticeMapByIndex(Long mapindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TBbsinfoNoticeMap对象 
   * 
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象集
   * @throws DomainServiceException ds异常
   */
     public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;
	 /**
   * 根据条件精确查询TBbsinfoNoticeMap对象 
   * 
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象
   * @return 满足条件的TBbsinfoNoticeMap对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCondExact( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DomainServiceException;
	 /**
   * 根据条件分页查询TBbsinfoNoticeMap对象 
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TBbsinfoNoticeMap对象 
   *
   * @param tbbsinfoNoticeMap TBbsinfoNoticeMap对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}