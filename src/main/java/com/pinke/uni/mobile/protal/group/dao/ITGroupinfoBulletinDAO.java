package com.pinke.uni.mobile.protal.group.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface ITGroupinfoBulletinDAO
{
     /**
   * 新增TGroupinfoBulletin对象 
   * 
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @throws DAOException dao异常
   */ 
     public void insertTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;
     /**
   * 批量新增TGroupinfoBulletin对象 
   * 
   * @param tgroupinfoBulletinList TGroupinfoBulletin对象列表
   * @throws DAOException dao异常
   */ 
     public void insertTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DAOException;
     /**
   * 根据主键更新TGroupinfoBulletin对象
   * 
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;
     /**
   * 根据主键批量更新TGroupinfoBulletin对象
   * 
   * @param tgroupinfoBulletinList TGroupinfoBulletin对象列表
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DAOException;

     /**
   * 根据条件更新TGroupinfoBulletin对象  
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin更新条件
   * @throws DAOException dao异常
   */
     public void updateTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;

     /**
   * 根据主键删除TGroupinfoBulletin对象
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @throws DAOException dao异常
   */
     public void deleteTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;	
     /**
   * 根据主键批量删除TGroupinfoBulletin对象
   *
   * @param tgroupinfoBulletinList TGroupinfoBulletin对象列表
   * @throws DAOException dao异常
   */
     public void deleteTGroupinfoBulletinList( List<TGroupinfoBulletin> tgroupinfoBulletinList )throws DAOException;
     
     /**
   * 根据条件删除TGroupinfoBulletin对象
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin删除条件
   * @throws DAOException dao异常
   */ 
     public void deleteTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;
     
     /**
   * 根据主键查询TGroupinfoBulletin对象
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象
   * @throws DAOException dao异常
   */
     public TGroupinfoBulletin getTGroupinfoBulletin( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;
     
     /**
   * 根据条件查询TGroupinfoBulletin对象 
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象集
   * @throws DAOException dao异常
   */
     public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;
     
	 /**
   * 根据条件精确查询TGroupinfoBulletin对象 
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象集
   * @throws DAOException dao异常
   */
	 public List<TGroupinfoBulletin> getTGroupinfoBulletinByCondExact( TGroupinfoBulletin tgroupinfoBulletin )throws DAOException;

	 /**
   * 根据条件查询TGroupinfoBulletin对象 
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象
   * @return 满足条件的TGroupinfoBulletin对象集
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @throws DAOException dao异常
   */
     public List<TGroupinfoBulletin> getTGroupinfoBulletinByCond( TGroupinfoBulletin tgroupinfoBulletin, PageUtilEntity puEntity )throws DAOException;

     /**
   * 根据条件分页查询TGroupinfoBulletin对象，作为查询条件的参数
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize)throws DAOException;
     
     /**
   * 根据条件分页查询TGroupinfoBulletin对象，作为查询条件的参数
   *
   * @param tgroupinfoBulletin TGroupinfoBulletin对象 
   * @param start 起始行
   * @param pageSize 页面大小
   * @param puEntity 排序控制参数@see PageUtilEntity
   * @return  查询结果
   * @throws DAOException dao异常
   */
     public PageInfo pageInfoQuery(TGroupinfoBulletin tgroupinfoBulletin, int start, int pageSize,PageUtilEntity puEntity)throws DAOException;
        
}