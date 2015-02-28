

package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITGroupinfoBulletinLS
{
    /**
  * 新增TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;
  
  /**
  * 批量新增TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;	
	
    /**
  * 更新TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;

    /**
  * 批量更新TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;


	/**
  * 删除TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletin TGroupinfoBulletin对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DomainServiceException;

	/**
  * 批量删除TGroupinfoBulletin对象
  *
  * @param tgroupinfoBulletinList  TGroupinfoBulletin对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DomainServiceException;

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
     public TableDataInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}