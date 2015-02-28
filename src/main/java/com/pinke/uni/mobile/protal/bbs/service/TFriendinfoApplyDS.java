package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITFriendinfoApplyDAO;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TFriendinfoApplyDS extends DynamicObjectBaseDS implements ITFriendinfoApplyDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITFriendinfoApplyDAO dao = null;
	
	public void setDao(ITFriendinfoApplyDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug("insert tfriendinfoApply starting...");
		try
		{
            // if (null == tfriendinfoApply.getApplyindex())
            // {
            // tfriendinfoApply.setApplyindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_friendinfo_apply"));
            // }
			dao.insertTFriendinfoApply( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tfriendinfoApply end");
	}
	public void insertTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException
	{
		log.debug("insert tfriendinfoApplyList by pk starting...");
		if(null == tfriendinfoApplyList || tfriendinfoApplyList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoApplyList");
			return;
		}
	    try
		{
		   	int listSize = tfriendinfoApplyList.size();
			Long index = (Long) Sequence.getSequence("t_friendinfo_apply", listSize);
			for (int i = 0; i < tfriendinfoApplyList.size(); i++) {
				if (tfriendinfoApplyList.get(i) != null) {
					if (null == tfriendinfoApplyList.get(i).getApplyindex()) {
						Long primaryindex = Long.valueOf(index + i);
						tfriendinfoApplyList.get(i).setApplyindex(primaryindex);
					}
				}
			}
			dao.insertTFriendinfoApplyList( tfriendinfoApplyList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tfriendinfoApplyList by pk end");
	}
	public void updateTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug("update tfriendinfoApply by pk starting...");
	    try
		{
			dao.updateTFriendinfoApply( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfoApply by pk end");
	}

	public void updateTFriendinfoApplyList( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException
	{
		log.debug("update tfriendinfoApplyList by pk starting...");
		if(null == tfriendinfoApplyList || tfriendinfoApplyList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoApplyList");
			return;
		}
	    try
		{
			dao.updateTFriendinfoApplyList( tfriendinfoApplyList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfoApplyList by pk end");
	}

	public void updateTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug("update tfriendinfoApply by condition starting...");
		try
		{
			dao.updateTFriendinfoApplyByCond( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tfriendinfoApply by condition end");
	}


	public void removeTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug( "remove tfriendinfoApply by pk starting..." );
		try
		{
			dao.deleteTFriendinfoApply( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfoApply by pk end" );
	}

	public void removeTFriendinfoApplyList ( List<TFriendinfoApply> tfriendinfoApplyList )throws DomainServiceException
	{
		log.debug( "remove tfriendinfoApplyList by pk starting..." );
		if(null == tfriendinfoApplyList || tfriendinfoApplyList.size() == 0 )
		{
			log.debug("there is no datas in tfriendinfoApplyList");
			return;
		}
		try
		{
			dao.deleteTFriendinfoApplyList( tfriendinfoApplyList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfoApplyList by pk end" );
	}

	public void removeTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug( "remove tfriendinfoApply by condition starting..." );
		try
		{
			dao.deleteTFriendinfoApplyByCond( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tfriendinfoApply by condition end" );
	}


	public TFriendinfoApply getTFriendinfoApply( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug( "get tfriendinfoApply by pk starting..." );
		TFriendinfoApply rsObj = null;
		try
		{
			rsObj = dao.getTFriendinfoApply( tfriendinfoApply );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tfriendinfoApplyList by pk end" );
		return rsObj;
	}

	 public TFriendinfoApply getTFriendinfoApplyByIndex(Long applyindex) throws DomainServiceException {
		log.debug( "get tfriendinfoApply by applyindex starting..." );
		TFriendinfoApply rsObj = new TFriendinfoApply();
		rsObj.setApplyindex(applyindex);
		try
		{
			rsObj = dao.getTFriendinfoApply( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tfriendinfoApply by applyindex end" );
		return rsObj;
	}
	public List<TFriendinfoApply> getTFriendinfoApplyByCond( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug( "get tfriendinfoApply by condition starting..." );
		List<TFriendinfoApply> rsList = null;
		try
		{
			rsList = dao.getTFriendinfoApplyByCond(tfriendinfoApply);
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
		log.debug( "get tfriendinfoApply by condition end" );
		return rsList;
	}
	public List<TFriendinfoApply> getTFriendinfoApplyByCondExact( TFriendinfoApply tfriendinfoApply )throws DomainServiceException
	{
		log.debug( "get tfriendinfoApply by exact condition starting..." );
		List<TFriendinfoApply> rsList = null;
		try
		{
			rsList = dao.getTFriendinfoApplyByCondExact( tfriendinfoApply );
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
		log.debug( "get tfriendinfoApply by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tfriendinfoApply page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tfriendinfoApply, start, pageSize);
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
		tableInfo.setData((List<TFriendinfoApply>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tfriendinfoApply page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TFriendinfoApply tfriendinfoApply, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tfriendinfoApply page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tfriendinfoApply, start, pageSize, puEntity);
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
		tableInfo.setData((List<TFriendinfoApply>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tfriendinfoApply page info by condition end" );
		return tableInfo;
	}
	
}
