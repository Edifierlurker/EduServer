

package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface ITNearStudentLS
{
    /**
  * 新增TNearStudent对象
  *
  * @param tnearStudent TNearStudent对象
  * @throws DomainServiceException ds异常
  */
	public String insertTNearStudent( TNearStudent tnearStudent )throws DomainServiceException;
  
  /**
  * 批量新增TNearStudent对象
  *
  * @param tnearStudentList  TNearStudent对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertTNearStudentList( List<TNearStudent> tnearStudentList )throws DomainServiceException;	
	
    /**
  * 更新TNearStudent对象
  *
  * @param tnearStudent TNearStudent对象
  * @throws DomainServiceException ds异常
  */
	public String updateTNearStudent( TNearStudent tnearStudent )throws DomainServiceException;

    /**
  * 批量更新TNearStudent对象
  *
  * @param tnearStudentList  TNearStudent对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateTNearStudentList( List<TNearStudent> tnearStudentList )throws DomainServiceException;


	/**
  * 删除TNearStudent对象
  *
  * @param tnearStudent TNearStudent对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeTNearStudent( TNearStudent tnearStudent )throws DomainServiceException;

	/**
  * 批量删除TNearStudent对象
  *
  * @param tnearStudentList  TNearStudent对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeTNearStudentList( List<TNearStudent> tnearStudentList )throws DomainServiceException;

	/**
  * 查询TNearStudent对象
  * 
  * @param tnearStudent TNearStudent对象
  * @return TNearStudent对象
  * @throws DomainServiceException ds异常 
  */
	 public TNearStudent getTNearStudent( TNearStudent tnearStudent )throws DomainServiceException; 

    /**
  * 根据主键查询TNearStudent对象
  * 
  * @param studentindex TNearStudent对象主键
  * @return TNearStudent对象
  * @throws DomainServiceException ds异常 
  */
	 public TNearStudent getTNearStudentByIndex(Long studentindex) throws DomainServiceException; 

	 /**
   * 根据条件查询TNearStudent对象 
   * 
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象集
   * @throws DomainServiceException ds异常
   */
     public List<TNearStudent> getTNearStudentByCond( TNearStudent tnearStudent )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询TNearStudent对象 
   * 
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象集
   * @throws DomainServiceException ds异常
   */
	 public List<TNearStudent> getTNearStudentByCondExact( TNearStudent tnearStudent )throws DomainServiceException;

	 /**
   * 根据条件分页查询TNearStudent对象 
   *
   * @param tnearStudent TNearStudent对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}