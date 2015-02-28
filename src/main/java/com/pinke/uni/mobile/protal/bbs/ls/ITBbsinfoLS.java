

package com.pinke.uni.mobile.protal.bbs.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITBbsinfoLS
{
    /**
  * 新增TBbsinfo对象
  *
  * @param tbbsinfo TBbsinfo对象
  * @throws DomainServiceException ds异常
  */
	public String insertTBbsinfo( TBbsinfo tbbsinfo )throws DomainServiceException;
  
  /**
  * 批量新增TBbsinfo对象
  *
  * @param tbbsinfoList  TBbsinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DomainServiceException;	
	
    /**
  * 更新TBbsinfo对象
  *
  * @param tbbsinfo TBbsinfo对象
  * @throws DomainServiceException ds异常
  */
	public String updateTBbsinfo( TBbsinfo tbbsinfo )throws DomainServiceException;

    /**
  * 批量更新TBbsinfo对象
  *
  * @param tbbsinfoList  TBbsinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DomainServiceException;


	/**
  * 删除TBbsinfo对象
  *
  * @param tbbsinfo TBbsinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTBbsinfo( TBbsinfo tbbsinfo )throws DomainServiceException;

	/**
  * 批量删除TBbsinfo对象
  *
  * @param tbbsinfoList  TBbsinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTBbsinfoList( List<TBbsinfo> tbbsinfoList )throws DomainServiceException;

	/**
  * 查询TBbsinfo对象
  * 
  * @param tbbsinfo TBbsinfo对象
  * @return TBbsinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TBbsinfo getTBbsinfo( TBbsinfo tbbsinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TBbsinfo对象
  * 
  * @param bbsindex TBbsinfo对象主键
  * @return TBbsinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TBbsinfo getTBbsinfoByIndex(Long bbsindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TBbsinfo对象 
   * 
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TBbsinfo> getTBbsinfoByCond( TBbsinfo tbbsinfo )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TBbsinfo对象 
   * 
   * @param tbbsinfo TBbsinfo对象
   * @return 满足条件的TBbsinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TBbsinfo> getTBbsinfoByCondExact( TBbsinfo tbbsinfo )throws DomainServiceException;

	 /**
   * 根据条件分页查询TBbsinfo对象 
   *
   * @param tbbsinfo TBbsinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TBbsinfo tbbsinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}