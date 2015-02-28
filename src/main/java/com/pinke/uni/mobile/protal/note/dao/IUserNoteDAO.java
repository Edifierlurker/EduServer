package com.pinke.uni.mobile.protal.note.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserNoteDAO
{
     /**
   * 新增UserNote对象 
   * 
   * @param userNote UserNote对象
   * @throws DAOException dao异常
   */ 
     public void insertUserNote( UserNote userNote )throws DAOException;
     /**
   * 批量新增UserNote对象 
   * 
   * @param userNoteList UserNote对象列表
   * @throws DAOException dao异常
   */ 
     public void insertUserNoteList( List<UserNote> userNoteList )throws DAOException;
     /**
   * 根据主键更新UserNote对象
   * 
   * @param userNote UserNote对象
   * @throws DAOException dao异常
   */
     public void updateUserNote( UserNote userNote )throws DAOException;
     /**
   * 根据主键批量更新UserNote对象
   * 
   * @param userNoteList UserNote对象列表
   * @throws DAOException dao异常
   */
     public void updateUserNoteList( List<UserNote> userNoteList )throws DAOException;

     /**
   * 根据条件更新UserNote对象  
   *
   * @param userNote UserNote更新条件
   * @throws DAOException dao异常
   */
     public void updateUserNoteByCond( UserNote userNote )throws DAOException;

     /**
   * 根据主键删除UserNote对象
   *
   * @param userNote UserNote对象
   * @throws DAOException dao异常
   */
     public void deleteUserNote( UserNote userNote )throws DAOException;	
     /**
   * 根据主键批量删除UserNote对象
   *
   * @param userNoteList UserNote对象列表
   * @throws DAOException dao异常
   */
     public void deleteUserNoteList( List<UserNote> userNoteList )throws DAOException;
     
     /**
   * 根据条件删除UserNote对象
   *
   * @param userNote UserNote删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteUserNoteByCond( UserNote userNote )throws DAOException;
     
     /**
   * 根据主键查询UserNote对象
   *
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象
   * @throws DAOException dao异常
   */
     public UserNote getUserNote( UserNote userNote )throws DAOException;
     
     /**
   * 根据条件查询UserNote对象 
   *
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象集
   * @throws DAOException dao异常
   */
     public List<UserNote> getUserNoteByCond( UserNote userNote )throws DAOException;
     
	 /**
   * 根据条件精确查询UserNote对象 
   *
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象集
   * @throws DAOException dao异常
   */
	 public List<UserNote> getUserNoteByCondExact( UserNote userNote )throws DAOException;

	 /**
   * 根据条件查询UserNote对象 
   *
   * @param userNote UserNote对象
   * @return 满足条件的UserNote对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<UserNote> getUserNoteByCond( UserNote userNote, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询UserNote对象，作为查询条件的参数
   *
   * @param userNote UserNote对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserNote userNote, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询UserNote对象，作为查询条件的参数
   *
   * @param userNote UserNote对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(UserNote userNote, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}