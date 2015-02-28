

package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITArticleinfoShareLS
{
    /**
  * 新增TArticleinfoShare对象
  *
  * @param tarticleinfoShare TArticleinfoShare对象
  * @throws DomainServiceException ds异常
  */
	public String insertTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DomainServiceException;
  
  /**
  * 批量新增TArticleinfoShare对象
  *
  * @param tarticleinfoShareList  TArticleinfoShare对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DomainServiceException;	
	
    /**
  * 更新TArticleinfoShare对象
  *
  * @param tarticleinfoShare TArticleinfoShare对象
  * @throws DomainServiceException ds异常
  */
	public String updateTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DomainServiceException;

    /**
  * 批量更新TArticleinfoShare对象
  *
  * @param tarticleinfoShareList  TArticleinfoShare对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DomainServiceException;


	/**
  * 删除TArticleinfoShare对象
  *
  * @param tarticleinfoShare TArticleinfoShare对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DomainServiceException;

	/**
  * 批量删除TArticleinfoShare对象
  *
  * @param tarticleinfoShareList  TArticleinfoShare对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTArticleinfoShareList( List<TArticleinfoShare> tarticleinfoShareList )throws DomainServiceException;

	/**
  * 查询TArticleinfoShare对象
  * 
  * @param tarticleinfoShare TArticleinfoShare对象
  * @return TArticleinfoShare对象
  * @throws DomainServiceException ds异常 
  */
	 public TArticleinfoShare getTArticleinfoShare( TArticleinfoShare tarticleinfoShare )throws DomainServiceException; 

    /**
  * 根据主键查询TArticleinfoShare对象
  * 
  * @param shareindex TArticleinfoShare对象主键
  * @return TArticleinfoShare对象
  * @throws DomainServiceException ds异常 
  */
	 public TArticleinfoShare getTArticleinfoShareByIndex(Long shareindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TArticleinfoShare对象 
   * 
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象集
   * @throws DomainServiceException ds异常
   */
     public List<TArticleinfoShare> getTArticleinfoShareByCond( TArticleinfoShare tarticleinfoShare )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TArticleinfoShare对象 
   * 
   * @param tarticleinfoShare TArticleinfoShare对象
   * @return 满足条件的TArticleinfoShare对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TArticleinfoShare> getTArticleinfoShareByCondExact( TArticleinfoShare tarticleinfoShare )throws DomainServiceException;

	 /**
   * 根据条件分页查询TArticleinfoShare对象 
   *
   * @param tarticleinfoShare TArticleinfoShare对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TArticleinfoShare tarticleinfoShare, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}