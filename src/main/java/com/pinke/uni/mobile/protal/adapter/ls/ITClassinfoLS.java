

package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITClassinfoLS
{
    /**
  * 新增TClassinfo对象
  *
  * @param tclassinfo TClassinfo对象
  * @throws DomainServiceException ds异常
  */
	public String insertTClassinfo( TClassinfo tclassinfo )throws DomainServiceException;
  
  /**
  * 批量新增TClassinfo对象
  *
  * @param tclassinfoList  TClassinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTClassinfoList( List<TClassinfo> tclassinfoList )throws DomainServiceException;	
	
    /**
  * 更新TClassinfo对象
  *
  * @param tclassinfo TClassinfo对象
  * @throws DomainServiceException ds异常
  */
	public String updateTClassinfo( TClassinfo tclassinfo )throws DomainServiceException;

    /**
  * 批量更新TClassinfo对象
  *
  * @param tclassinfoList  TClassinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTClassinfoList( List<TClassinfo> tclassinfoList )throws DomainServiceException;


	/**
  * 删除TClassinfo对象
  *
  * @param tclassinfo TClassinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTClassinfo( TClassinfo tclassinfo )throws DomainServiceException;

	/**
  * 批量删除TClassinfo对象
  *
  * @param tclassinfoList  TClassinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTClassinfoList( List<TClassinfo> tclassinfoList )throws DomainServiceException;

	/**
  * 查询TClassinfo对象
  * 
  * @param tclassinfo TClassinfo对象
  * @return TClassinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TClassinfo getTClassinfo( TClassinfo tclassinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TClassinfo对象
  * 
  * @param classindex TClassinfo对象主键
  * @return TClassinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TClassinfo getTClassinfoByIndex(Long classindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TClassinfo对象 
   * 
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TClassinfo> getTClassinfoByCond( TClassinfo tclassinfo )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TClassinfo对象 
   * 
   * @param tclassinfo TClassinfo对象
   * @return 满足条件的TClassinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TClassinfo> getTClassinfoByCondExact( TClassinfo tclassinfo )throws DomainServiceException;

	 /**
   * 根据条件分页查询TClassinfo对象 
   *
   * @param tclassinfo TClassinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TClassinfo tclassinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}