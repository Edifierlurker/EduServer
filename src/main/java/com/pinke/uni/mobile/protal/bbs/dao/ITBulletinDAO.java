package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITBulletinDAO
{
     /**
   * 新增TBulletin对象 
   * 
   * @param tbulletin TBulletin对象
   * @throws DAOException dao异常
   */ 
     public void insertTBulletin( TBulletin tbulletin )throws DAOException;
     /**
   * 批量新增TBulletin对象 
   * 
   * @param tbulletinList TBulletin对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTBulletinList( List<TBulletin> tbulletinList )throws DAOException;
     /**
   * 根据主键更新TBulletin对象
   * 
   * @param tbulletin TBulletin对象
   * @throws DAOException dao异常
   */
     public void updateTBulletin( TBulletin tbulletin )throws DAOException;
     /**
   * 根据主键批量更新TBulletin对象
   * 
   * @param tbulletinList TBulletin对象列表
   * @throws DAOException dao异常
   */
     public void updateTBulletinList( List<TBulletin> tbulletinList )throws DAOException;

     /**
   * 根据条件更新TBulletin对象  
   *
   * @param tbulletin TBulletin更新条件
   * @throws DAOException dao异常
   */
     public void updateTBulletinByCond( TBulletin tbulletin )throws DAOException;

     /**
   * 根据主键删除TBulletin对象
   *
   * @param tbulletin TBulletin对象
   * @throws DAOException dao异常
   */
     public void deleteTBulletin( TBulletin tbulletin )throws DAOException;	
     /**
   * 根据主键批量删除TBulletin对象
   *
   * @param tbulletinList TBulletin对象列表
   * @throws DAOException dao异常
   */
     public void deleteTBulletinList( List<TBulletin> tbulletinList )throws DAOException;
     
     /**
   * 根据条件删除TBulletin对象
   *
   * @param tbulletin TBulletin删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTBulletinByCond( TBulletin tbulletin )throws DAOException;
     
     /**
   * 根据主键查询TBulletin对象
   *
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象
   * @throws DAOException dao异常
   */
     public TBulletin getTBulletin( TBulletin tbulletin )throws DAOException;
     
     /**
   * 根据条件查询TBulletin对象 
   *
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象集
   * @throws DAOException dao异常
   */
     public List<TBulletin> getTBulletinByCond( TBulletin tbulletin )throws DAOException;
     
	 /**
   * 根据条件精确查询TBulletin对象 
   *
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象集
   * @throws DAOException dao异常
   */
	 public List<TBulletin> getTBulletinByCondExact( TBulletin tbulletin )throws DAOException;

	 /**
   * 根据条件查询TBulletin对象 
   *
   * @param tbulletin TBulletin对象
   * @return 满足条件的TBulletin对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TBulletin> getTBulletinByCond( TBulletin tbulletin, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TBulletin对象，作为查询条件的参数
   *
   * @param tbulletin TBulletin对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TBulletin对象，作为查询条件的参数
   *
   * @param tbulletin TBulletin对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TBulletin tbulletin, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}