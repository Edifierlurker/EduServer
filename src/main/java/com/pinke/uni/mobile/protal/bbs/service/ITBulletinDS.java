

package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITBulletinDS
{
    /**
  * 新增TBulletin对象
  *
  * @param tbulletin TBulletin对象
  * @throws DomainServiceException ds异常
  */
	public void insertTBulletin( TBulletin tbulletin )throws DomainServiceException;
   /**
  * 批量新增TBulletin对象
  *
  * @param tbulletinList  TBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTBulletinList( List<TBulletin> tbulletinList )throws DomainServiceException;	
	
    /**
  * 更新TBulletin对象
  *
  * @param tbulletin TBulletin对象
  * @throws DomainServiceException ds异常
  */
	public void updateTBulletin( TBulletin tbulletin )throws DomainServiceException;

    /**
  * 批量更新TBulletin对象
  *
  * @param tbulletinList  TBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTBulletinList( List<TBulletin> tbulletinList )throws DomainServiceException;

	/**
  * 根据条件更新TBulletin对象  
  *
  * @param tbulletin TBulletin更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTBulletinByCond( TBulletin tbulletin )throws DomainServiceException;

	/**
  * 删除TBulletin对象
  *
  * @param tbulletin TBulletin对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTBulletin( TBulletin tbulletin )throws DomainServiceException;

	/**
  * 批量删除TBulletin对象
  *
  * @param tbulletinList  TBulletin对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTBulletinList( List<TBulletin> tbulletinList )throws DomainServiceException;

    /**
  * 根据条件删除TBulletin对象
  * 
  * @param tbulletin TBulletin删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeTBulletinByCond( TBulletin tbulletin )throws DomainServiceException;	

	/**
  * 查询TBulletin对象
  * 
  * @param tbulletin TBulletin对象
  * @return TBulletin对象
  * @throws DomainServiceException ds异常 
  */
	 public TBulletin getTBulletin( TBulletin tbulletin )throws DomainServiceException; 

    /**
  * 根据主键查询TBulletin对象
  * 
  * @param bulindex TBulletin对象主键
  * @return TBulletin对象
  * @throws DomainServiceException ds异常 
  */
	 public TBulletin getTBulletinByIndex(Long bulindex) throws DomainServiceException; 
	 /**
   * 根据条件查询TBulletin对象 
   * 
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象集
   * @throws DomainServiceException ds异常
   */
     public List<TBulletin> getTBulletinByCond( TBulletin tbulletin )throws DomainServiceException;
	 /**
   * 根据条件精确查询TBulletin对象 
   * 
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TBulletin> getTBulletinByCondExact( TBulletin tbulletin )throws DomainServiceException;
	 /**
   * 根据条件分页查询TBulletin对象 
   *
   * @param tbulletin TBulletin对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TBulletin对象 
   *
   * @param tbulletin TBulletin对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}