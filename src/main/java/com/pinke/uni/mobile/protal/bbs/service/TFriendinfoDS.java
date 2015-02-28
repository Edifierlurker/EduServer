package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITFriendinfoDAO;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TFriendinfoDS extends DynamicObjectBaseDS implements ITFriendinfoDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITFriendinfoDAO dao = null;
	
	public void setDao(ITFriendinfoDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTFriendinfo( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug("insert tfriendinfo starting...");
		try
		{
            // if (null == tfriendinfo.getMapindex())
            // {
            // tfriendinfo.setMapindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_friendinfo"));
            // }
			dao.insertTFriendinfo( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tfriendinfo end");
	}
	public void insertTFriendinfoList( List<TFriendinfo> tfriendinfoList )throws DomainServiceException
	{
		log.debug("insert tfriendinfoList by pk starting...");
		if(null == tfriendinfoList || tfriendinfoList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoList");
			return;
		}
	    try
		{
//		   	int listSize = tfriendinfoList.size();
//			Long index = (Long) Sequence.getSequence("t_friendinfo", listSize);
//			for (int i = 0; i < tfriendinfoList.size(); i++) {
//				if (tfriendinfoList.get(i) != null) {
//					if (null == tfriendinfoList.get(i).getMapindex()) {
//						Long primaryindex = Long.valueOf(index + i);
//						tfriendinfoList.get(i).setMapindex(primaryindex);
//					}
//				}
//			}
			dao.insertTFriendinfoList( tfriendinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tfriendinfoList by pk end");
	}
	public void updateTFriendinfo( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug("update tfriendinfo by pk starting...");
	    try
		{
			dao.updateTFriendinfo( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfo by pk end");
	}

	public void updateTFriendinfoList( List<TFriendinfo> tfriendinfoList )throws DomainServiceException
	{
		log.debug("update tfriendinfoList by pk starting...");
		if(null == tfriendinfoList || tfriendinfoList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoList");
			return;
		}
	    try
		{
			dao.updateTFriendinfoList( tfriendinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfoList by pk end");
	}

	public void updateTFriendinfoByCond( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug("update tfriendinfo by condition starting...");
		try
		{
			dao.updateTFriendinfoByCond( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfo by condition end");
	}


	public void removeTFriendinfo( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug( "remove tfriendinfo by pk starting..." );
		try
		{
			dao.deleteTFriendinfo( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfo by pk end" );
	}

	public void removeTFriendinfoList ( List<TFriendinfo> tfriendinfoList )throws DomainServiceException
	{
		log.debug( "remove tfriendinfoList by pk starting..." );
		if(null == tfriendinfoList || tfriendinfoList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoList");
			return;
		}
		try
		{
			dao.deleteTFriendinfoList( tfriendinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfoList by pk end" );
	}

	public void removeTFriendinfoByCond( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug( "remove tfriendinfo by condition starting..." );
		try
		{
			dao.deleteTFriendinfoByCond( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfo by condition end" );
	}


	public TFriendinfo getTFriendinfo( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug( "get tfriendinfo by pk starting..." );
		TFriendinfo rsObj = null;
		try
		{
			rsObj = dao.getTFriendinfo( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tfriendinfoList by pk end" );
		return rsObj;
	}

	 public TFriendinfo getTFriendinfoByIndex(Long mapindex) throws DomainServiceException {
		log.debug( "get tfriendinfo by mapindex starting..." );
		TFriendinfo rsObj = new TFriendinfo();
		rsObj.setMapindex(mapindex);
		try
		{
			rsObj = dao.getTFriendinfo( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tfriendinfo by mapindex end" );
		return rsObj;
	}
	public List<TFriendinfo> getTFriendinfoByCond( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug( "get tfriendinfo by condition starting..." );
		List<TFriendinfo> rsList = null;
		try
		{
			rsList = dao.getTFriendinfoByCond(tfriendinfo);
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
		log.debug( "get tfriendinfo by condition end" );
		return rsList;
	}
	public List<TFriendinfo> getTFriendinfoByCondExact( TFriendinfo tfriendinfo )throws DomainServiceException
	{
		log.debug( "get tfriendinfo by exact condition starting..." );
		List<TFriendinfo> rsList = null;
		try
		{
			rsList = dao.getTFriendinfoByCondExact( tfriendinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
		log.debug( "get tfriendinfo by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tfriendinfo page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tfriendinfo, start, pageSize);
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
		TableDataInfo tableInfo = new TableDataInfo();
		tableInfo.setData((List<TFriendinfo>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tfriendinfo page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TFriendinfo tfriendinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tfriendinfo page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tfriendinfo, start, pageSize, puEntity);
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
		TableDataInfo tableInfo = new TableDataInfo();
		tableInfo.setData((List<TFriendinfo>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tfriendinfo page info by condition end" );
		return tableInfo;
	}
	
}
