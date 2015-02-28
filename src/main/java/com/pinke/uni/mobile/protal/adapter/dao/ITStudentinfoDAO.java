package com.pinke.uni.mobile.protal.adapter.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITStudentinfoDAO
{
     /**
   * 新增TStudentinfo对象 
   * 
   * @param tstudentinfo TStudentinfo对象
   * @throws DAOException dao异常
   */ 
     public void insertTStudentinfo( TStudentinfo tstudentinfo )throws DAOException;
     /**
   * 批量新增TStudentinfo对象 
   * 
   * @param tstudentinfoList TStudentinfo对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DAOException;
     /**
   * 根据主键更新TStudentinfo对象
   * 
   * @param tstudentinfo TStudentinfo对象
   * @throws DAOException dao异常
   */
     public void updateTStudentinfo( TStudentinfo tstudentinfo )throws DAOException;
     /**
   * 根据主键批量更新TStudentinfo对象
   * 
   * @param tstudentinfoList TStudentinfo对象列表
   * @throws DAOException dao异常
   */
     public void updateTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DAOException;

     /**
   * 根据条件更新TStudentinfo对象  
   *
   * @param tstudentinfo TStudentinfo更新条件
   * @throws DAOException dao异常
   */
     public void updateTStudentinfoByCond( TStudentinfo tstudentinfo )throws DAOException;

     /**
   * 根据主键删除TStudentinfo对象
   *
   * @param tstudentinfo TStudentinfo对象
   * @throws DAOException dao异常
   */
     public void deleteTStudentinfo( TStudentinfo tstudentinfo )throws DAOException;	
     /**
   * 根据主键批量删除TStudentinfo对象
   *
   * @param tstudentinfoList TStudentinfo对象列表
   * @throws DAOException dao异常
   */
     public void deleteTStudentinfoList( List<TStudentinfo> tstudentinfoList )throws DAOException;
     
     /**
   * 根据条件删除TStudentinfo对象
   *
   * @param tstudentinfo TStudentinfo删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTStudentinfoByCond( TStudentinfo tstudentinfo )throws DAOException;
     
     /**
   * 根据主键查询TStudentinfo对象
   *
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象
   * @throws DAOException dao异常
   */
     public TStudentinfo getTStudentinfo( TStudentinfo tstudentinfo )throws DAOException;
     
     /**
   * 根据条件查询TStudentinfo对象 
   *
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象集
   * @throws DAOException dao异常
   */
     public List<TStudentinfo> getTStudentinfoByCond( TStudentinfo tstudentinfo )throws DAOException;
     
	 /**
   * 根据条件精确查询TStudentinfo对象 
   *
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象集
   * @throws DAOException dao异常
   */
	 public List<TStudentinfo> getTStudentinfoByCondExact( TStudentinfo tstudentinfo )throws DAOException;

	 /**
   * 根据条件查询TStudentinfo对象 
   *
   * @param tstudentinfo TStudentinfo对象
   * @return 满足条件的TStudentinfo对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TStudentinfo> getTStudentinfoByCond( TStudentinfo tstudentinfo, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TStudentinfo对象，作为查询条件的参数
   *
   * @param tstudentinfo TStudentinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TStudentinfo对象，作为查询条件的参数
   *
   * @param tstudentinfo TStudentinfo对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TStudentinfo tstudentinfo, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
     /**
      * 根据用户账户查询用户个人信息
      * @param tstudentinfo
      * @return
      * @throws DAOException
      */
     public TStudentinfo getTStudentinfoByUserCode(TStudentinfo tstudentinfo) throws DAOException;
}