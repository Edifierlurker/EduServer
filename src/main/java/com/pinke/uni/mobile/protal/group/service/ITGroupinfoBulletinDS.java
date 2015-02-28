

package com.pinke.uni.mobile.protal.group.service;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoBulletinDS
{
    /**
  * 新增TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */
	public void insertTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;
   /**
  * 批量新增TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public void insertTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;	
	
    /**
  * 更新TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */
	public void updateTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;

    /**
  * 批量更新TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public void updateTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;

	/**
  * 根据条件更新TGroupinfoBulletin对象  
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin更新条件
  * @throws DomainServiceException ds异常
  */ 
	public void updateTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;

	/**
  * 删除TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */ 
	public void removeTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;

	/**
  * 批量删除TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */ 
	public void removeTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;

    /**
  * 根据条件删除TGroupinfoBulletin对象
  * 
  * @param tgroupinfoBulletin TGroupinfoBulletin删除条件
  * @throws DomainServiceException ds异常
  */  
    public void removeTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;	

	/**
  * 查询TGroupinfoBulletin对象
  * 
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @return TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupinfoBulletin getTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException; 

    /**
  * 根据主键查询TGroupinfoBulletin对象
  * 
  * @param bulletinidnex TGroupinfoBulletin对象主键
  * @return TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常 
  */
	 public TGroupinfoBulletin getTGroupinfoBulletinByIndex(Long bulletinidnex) throws DomainServiceException; 
	 /**
   * 根据条件查询TGroupinfoBulletin对象 
   * 
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象集
   * @throws DomainServiceException ds异常
   */
     public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;
	 /**
   * 根据条件精确查询TGroupinfoBulletin对象 
   * 
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TGroupinfoBulletin> getTGroupinfoBulletinByCondExact( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;
	 /**
   * 根据条件分页查询TGroupinfoBulletin对象 
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize)throws DomainServiceException;
	 /**
   * 根据条件分页查询TGroupinfoBulletin对象 
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}