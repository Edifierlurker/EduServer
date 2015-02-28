package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITNearStudentDAO
{
     /**
   * 新增TNearStudent对象 
   * 
   * @param tnearStudent TNearStudent对象
   * @throws DAOException dao异常
   */ 
     public void insertTNearStudent( TNearStudent tnearStudent )throws DAOException;
     /**
   * 批量新增TNearStudent对象 
   * 
   * @param tnearStudentList TNearStudent对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTNearStudentList( List<TNearStudent> tnearStudentList )throws DAOException;
     /**
   * 根据主键更新TNearStudent对象
   * 
   * @param tnearStudent TNearStudent对象
   * @throws DAOException dao异常
   */
     public void updateTNearStudent( TNearStudent tnearStudent )throws DAOException;
     /**
   * 根据主键批量更新TNearStudent对象
   * 
   * @param tnearStudentList TNearStudent对象列表
   * @throws DAOException dao异常
   */
     public void updateTNearStudentList( List<TNearStudent> tnearStudentList )throws DAOException;

     /**
   * 根据条件更新TNearStudent对象  
   *
   * @param tnearStudent TNearStudent更新条件
   * @throws DAOException dao异常
   */
     public void updateTNearStudentByCond( TNearStudent tnearStudent )throws DAOException;

     /**
   * 根据主键删除TNearStudent对象
   *
   * @param tnearStudent TNearStudent对象
   * @throws DAOException dao异常
   */
     public void deleteTNearStudent( TNearStudent tnearStudent )throws DAOException;	
     /**
   * 根据主键批量删除TNearStudent对象
   *
   * @param tnearStudentList TNearStudent对象列表
   * @throws DAOException dao异常
   */
     public void deleteTNearStudentList( List<TNearStudent> tnearStudentList )throws DAOException;
     
     /**
   * 根据条件删除TNearStudent对象
   *
   * @param tnearStudent TNearStudent删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTNearStudentByCond( TNearStudent tnearStudent )throws DAOException;
     
     /**
   * 根据主键查询TNearStudent对象
   *
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象
   * @throws DAOException dao异常
   */
     public TNearStudent getTNearStudent( TNearStudent tnearStudent )throws DAOException;
     
     /**
   * 根据条件查询TNearStudent对象 
   *
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象集
   * @throws DAOException dao异常
   */
     public List<TNearStudent> getTNearStudentByCond( TNearStudent tnearStudent )throws DAOException;
     
	 /**
   * 根据条件精确查询TNearStudent对象 
   *
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象集
   * @throws DAOException dao异常
   */
	 public List<TNearStudent> getTNearStudentByCondExact( TNearStudent tnearStudent )throws DAOException;

	 /**
   * 根据条件查询TNearStudent对象 
   *
   * @param tnearStudent TNearStudent对象
   * @return 满足条件的TNearStudent对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TNearStudent> getTNearStudentByCond( TNearStudent tnearStudent, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TNearStudent对象，作为查询条件的参数
   *
   * @param tnearStudent TNearStudent对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TNearStudent对象，作为查询条件的参数
   *
   * @param tnearStudent TNearStudent对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}