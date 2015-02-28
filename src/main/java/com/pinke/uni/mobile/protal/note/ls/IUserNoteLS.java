

package com.pinke.uni.mobile.protal.note.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserNoteLS
{
    /**
  * 新增UserNote对象
  *
  * @param userNote UserNote对象
  * @throws DomainServiceException ds异常
  */
	public String insertUserNote( UserNote userNote )throws DomainServiceException;
  
  /**
  * 批量新增UserNote对象
  *
  * @param userNoteList  UserNote对象列表
  * @throws DomainServiceException ds异常
  */
	public String insertUserNoteList( List<UserNote> userNoteList )throws DomainServiceException;	
	
    /**
  * 更新UserNote对象
  *
  * @param userNote UserNote对象
  * @throws DomainServiceException ds异常
  */
	public String updateUserNote( UserNote userNote )throws DomainServiceException;

    /**
  * 批量更新UserNote对象
  *
  * @param userNoteList  UserNote对象列表
  * @throws DomainServiceException ds异常
  */
	public String updateUserNoteList( List<UserNote> userNoteList )throws DomainServiceException;


	/**
  * 删除UserNote对象
  *
  * @param userNote UserNote对象
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserNote( UserNote userNote )throws DomainServiceException;

	/**
  * 批量删除UserNote对象
  *
  * @param userNoteList  UserNote对象列表
  * @throws DomainServiceException ds异常
  */ 
	public String removeUserNoteList( List<UserNote> userNoteList )throws DomainServiceException;

	/**
  * 查询UserNote对象
  * 
  * @param userNote UserNote对象
  * @return UserNote对象
  * @throws DomainServiceException ds异常 
  */
	 public UserNote getUserNote( UserNote userNote )throws DomainServiceException; 

    /**
  * 根据主键查询UserNote对象
  * 
  * @param noteindex UserNote对象主键
  * @return UserNote对象
  * @throws DomainServiceException ds异常 
  */
	 public UserNote getUserNoteByIndex(Long noteindex) throws DomainServiceException; 

	 /**
   * 根据条件查询UserNote对象 
   * 
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象集
   * @throws DomainServiceException ds异常
   */
     public List<UserNote> getUserNoteByCond( UserNote userNote )throws DomainServiceException;
     
	 /**
   * 根据条件精确查询UserNote对象 
   * 
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象集
   * @throws DomainServiceException ds异常
   */
	 public List<UserNote> getUserNoteByCondExact( UserNote userNote )throws DomainServiceException;

	 /**
   * 根据条件分页查询UserNote对象 
   *
   * @param userNote UserNote对象，作为查询条件的参数 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DomainServiceException ds异常
   */
     public TableDataInfo pageInfoQuery(UserNote userNote, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException;
}