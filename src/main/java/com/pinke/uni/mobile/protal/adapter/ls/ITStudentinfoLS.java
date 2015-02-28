

package com.pinke.uni.mobile.protal.adapter.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITStudentinfoLS
{
    /**
  * 新增TStudentinfo对象
  *
  * @param tstudentinfo TStudentinfo对象
  * @throws DomainServiceException ds异常
  */
	public String insertTStudentinfo( TStudentinfo tstudentinfo )throws DomainServiceException;
  
  /**
  * 批量新增TStudentinfo对象
  *
  * @param tstudentinfoList  TStudentinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DomainServiceException;	
	
    /**
  * 更新TStudentinfo对象
  *
  * @param tstudentinfo TStudentinfo对象
  * @throws DomainServiceException ds异常
  */
	public String updateTStudentinfo( TStudentinfo tstudentinfo )throws DomainServiceException;

    /**
  * 批量更新TStudentinfo对象
  *
  * @param tstudentinfoList  TStudentinfo对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DomainServiceException;


	/**
  * 删除TStudentinfo对象
  *
  * @param tstudentinfo TStudentinfo对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTStudentinfo( TStudentinfo tstudentinfo )throws DomainServiceException;

	/**
  * 批量删除TStudentinfo对象
  *
  * @param tstudentinfoList  TStudentinfo对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DomainServiceException;

	/**
  * 查询TStudentinfo对象
  * 
  * @param tstudentinfo TStudentinfo对象
  * @return TStudentinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TStudentinfo getTStudentinfo( TStudentinfo tstudentinfo )throws DomainServiceException; 

    /**
  * 根据主键查询TStudentinfo对象
  * 
  * @param studentindex TStudentinfo对象主键
  * @return TStudentinfo对象
  * @throws DomainServiceException ds异常 
  */
	 public TStudentinfo getTStudentinfoByIndex(Long studentindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TStudentinfo对象 
   * 
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象集
   * @throws DomainServiceException ds异常
   */
     public List<TStudentinfo> getTStudentinfoByCond( TStudentinfo tstudentinfo )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TStudentinfo对象 
   * 
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TStudentinfo> getTStudentinfoByCondExact( TStudentinfo tstudentinfo )throws DomainServiceException;

	 /**
   * 根据条件分页查询TStudentinfo对象 
   *
   * @param tstudentinfo TStudentinfo对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
     /**
      * 根据用户名查询用户信息
      * @param userCode
      * @return
      * @throws DomainServiceException
      */
     public TStudentinfo getTStudentinfoByUserCode(String userCode) throws DomainServiceException;
}