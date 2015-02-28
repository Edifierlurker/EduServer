package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupinfoAttendMapDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupinfoAttendMapDS extends DynamicObjectBaseDS implements ITGroupinfoAttendMapDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITGroupinfoAttendMapDAO dao = null;
	
	public void setDao(ITGroupinfoAttendMapDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug("insert tgroupinfoAttendMap starting...");
		try
		{
            // if (null == tgroupinfoAttendMap.getMapindex())
            // {
            // tgroupinfoAttendMap.setMapindex((Long)
            // this.getPrimaryKeyGenerator().getPrimarykey("t_groupinfo_attend_map"));
            // }
			dao.insertTGroupinfoAttendMap( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tgroupinfoAttendMap end");
	}
	public void insertTGroupinfoAttendMapList( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DomainServiceException
	{
		log.debug("insert tgroupinfoAttendMapList by pk starting...");
		if(null == tgroupinfoAttendMapList || tgroupinfoAttendMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupinfoAttendMapList");
			return;
		}
	    try
		{
//		   	int listSize = tgroupinfoAttendMapList.size();
//			Long index = (Long) Sequence.getSequence("t_groupinfo_attend_map", listSize);
//			for (int i = 0; i < tgroupinfoAttendMapList.size(); i++) {
//				if (tgroupinfoAttendMapList.get(i) != null) {
//					if (null == tgroupinfoAttendMapList.get(i).getMapindex()) {
//						Long primaryindex = Long.valueOf(index + i);
//						tgroupinfoAttendMapList.get(i).setMapindex(primaryindex);
//					}
//				}
//			}
			dao.insertTGroupinfoAttendMapList( tgroupinfoAttendMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tgroupinfoAttendMapList by pk end");
	}
	public void updateTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug("update tgroupinfoAttendMap by pk starting...");
	    try
		{
			dao.updateTGroupinfoAttendMap( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupinfoAttendMap by pk end");
	}

	public void updateTGroupinfoAttendMapList( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DomainServiceException
	{
		log.debug("update tgroupinfoAttendMapList by pk starting...");
		if(null == tgroupinfoAttendMapList || tgroupinfoAttendMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupinfoAttendMapList");
			return;
		}
	    try
		{
			dao.updateTGroupinfoAttendMapList( tgroupinfoAttendMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupinfoAttendMapList by pk end");
	}

	public void updateTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug("update tgroupinfoAttendMap by condition starting...");
		try
		{
			dao.updateTGroupinfoAttendMapByCond( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupinfoAttendMap by condition end");
	}


	public void removeTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug( "remove tgroupinfoAttendMap by pk starting..." );
		try
		{
			dao.deleteTGroupinfoAttendMapByCond( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupinfoAttendMap by pk end" );
	}

	public void removeTGroupinfoAttendMapList ( List<TGroupinfoAttendMap> tgroupinfoAttendMapList )throws DomainServiceException
	{
		log.debug( "remove tgroupinfoAttendMapList by pk starting..." );
		if(null == tgroupinfoAttendMapList || tgroupinfoAttendMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupinfoAttendMapList");
			return;
		}
		try
		{
			dao.deleteTGroupinfoAttendMapList( tgroupinfoAttendMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupinfoAttendMapList by pk end" );
	}

	public void removeTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug( "remove tgroupinfoAttendMap by condition starting..." );
		try
		{
			dao.deleteTGroupinfoAttendMapByCond( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupinfoAttendMap by condition end" );
	}


	public TGroupinfoAttendMap getTGroupinfoAttendMap( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug( "get tgroupinfoAttendMap by pk starting..." );
		TGroupinfoAttendMap rsObj = null;
		try
		{
			rsObj = dao.getTGroupinfoAttendMap( tgroupinfoAttendMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tgroupinfoAttendMapList by pk end" );
		return rsObj;
	}

	 public TGroupinfoAttendMap getTGroupinfoAttendMapByIndex(Long mapindex) throws DomainServiceException {
		log.debug( "get tgroupinfoAttendMap by mapindex starting..." );
		TGroupinfoAttendMap rsObj = new TGroupinfoAttendMap();
		rsObj.setMapindex(mapindex);
		try
		{
			rsObj = dao.getTGroupinfoAttendMap( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tgroupinfoAttendMap by mapindex end" );
		return rsObj;
	}
	public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCond( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug( "get tgroupinfoAttendMap by condition starting..." );
		List<TGroupinfoAttendMap> rsList = null;
		try
		{
			rsList = dao.getTGroupinfoAttendMapByCond(tgroupinfoAttendMap);
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
		log.debug( "get tgroupinfoAttendMap by condition end" );
		return rsList;
	}
	public List<TGroupinfoAttendMap> getTGroupinfoAttendMapByCondExact( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
	{
		log.debug( "get tgroupinfoAttendMap by exact condition starting..." );
		List<TGroupinfoAttendMap> rsList = null;
		try
		{
			rsList = dao.getTGroupinfoAttendMapByCondExact( tgroupinfoAttendMap );
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
		log.debug( "get tgroupinfoAttendMap by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tgroupinfoAttendMap page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tgroupinfoAttendMap, start, pageSize);
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
		tableInfo.setData((List<TGroupinfoAttendMap>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tgroupinfoAttendMap page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TGroupinfoAttendMap tgroupinfoAttendMap, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tgroupinfoAttendMap page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tgroupinfoAttendMap, start, pageSize, puEntity);
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
		tableInfo.setData((List<TGroupinfoAttendMap>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tgroupinfoAttendMap page info by condition end" );
		return tableInfo;
	}
	
	public List<TGroupinfoAttendMap> getTGroupinfoAttendChat( TGroupinfoAttendMap tgroupinfoAttendMap )throws DomainServiceException
    {
        log.debug( "get tgroupinfoAttendMap by condition starting..." );
        List<TGroupinfoAttendMap> rsList = null;
        try
        {
            rsList = dao.getTGroupinfoAttendChat(tgroupinfoAttendMap);
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
        log.debug( "get tgroupinfoAttendMap by condition end" );
        return rsList;
    }
	
	
}
