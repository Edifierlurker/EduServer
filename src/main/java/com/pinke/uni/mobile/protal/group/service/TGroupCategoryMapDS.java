package com.pinke.uni.mobile.protal.group.service;

import java.util.List;

import com.pinke.uni.mobile.protal.group.dao.ITGroupCategoryMapDAO;
import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TGroupCategoryMapDS extends DynamicObjectBaseDS implements ITGroupCategoryMapDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITGroupCategoryMapDAO dao = null;
	
	public void setDao(ITGroupCategoryMapDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug("insert tgroupCategoryMap starting...");
		try
		{
            // if (null == tgroupCategoryMap.getMapindex())
            // {
            // tgroupCategoryMap.setMapindex((Long)
            // this.getPrimaryKeyGenerator().getPrimarykey("t_group_category_map"));
            // }
			dao.insertTGroupCategoryMap( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tgroupCategoryMap end");
	}
	public void insertTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException
	{
		log.debug("insert tgroupCategoryMapList by pk starting...");
		if(null == tgroupCategoryMapList || tgroupCategoryMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupCategoryMapList");
			return;
		}
	    try
		{
		   	int listSize = tgroupCategoryMapList.size();
			Long index = (Long) Sequence.getSequence("t_group_category_map", listSize);
			for (int i = 0; i < tgroupCategoryMapList.size(); i++) {
				if (tgroupCategoryMapList.get(i) != null) {
					if (null == tgroupCategoryMapList.get(i).getMapindex()) {
						Long primaryindex = Long.valueOf(index + i);
						tgroupCategoryMapList.get(i).setMapindex(primaryindex);
					}
				}
			}
			dao.insertTGroupCategoryMapList( tgroupCategoryMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tgroupCategoryMapList by pk end");
	}
	public void updateTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug("update tgroupCategoryMap by pk starting...");
	    try
		{
			dao.updateTGroupCategoryMap( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupCategoryMap by pk end");
	}

	public void updateTGroupCategoryMapList( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException
	{
		log.debug("update tgroupCategoryMapList by pk starting...");
		if(null == tgroupCategoryMapList || tgroupCategoryMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupCategoryMapList");
			return;
		}
	    try
		{
			dao.updateTGroupCategoryMapList( tgroupCategoryMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupCategoryMapList by pk end");
	}

	public void updateTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug("update tgroupCategoryMap by condition starting...");
		try
		{
			dao.updateTGroupCategoryMapByCond( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tgroupCategoryMap by condition end");
	}


	public void removeTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug( "remove tgroupCategoryMap by pk starting..." );
		try
		{
			dao.deleteTGroupCategoryMap( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupCategoryMap by pk end" );
	}

	public void removeTGroupCategoryMapList ( List<TGroupCategoryMap> tgroupCategoryMapList )throws DomainServiceException
	{
		log.debug( "remove tgroupCategoryMapList by pk starting..." );
		if(null == tgroupCategoryMapList || tgroupCategoryMapList.size() == 0 )
		{
			log.debug("there is no datas in tgroupCategoryMapList");
			return;
		}
		try
		{
			dao.deleteTGroupCategoryMapList( tgroupCategoryMapList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupCategoryMapList by pk end" );
	}

	public void removeTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug( "remove tgroupCategoryMap by condition starting..." );
		try
		{
			dao.deleteTGroupCategoryMapByCond( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tgroupCategoryMap by condition end" );
	}


	public TGroupCategoryMap getTGroupCategoryMap( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug( "get tgroupCategoryMap by pk starting..." );
		TGroupCategoryMap rsObj = null;
		try
		{
			rsObj = dao.getTGroupCategoryMap( tgroupCategoryMap );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tgroupCategoryMapList by pk end" );
		return rsObj;
	}

	 public TGroupCategoryMap getTGroupCategoryMapByIndex(Long mapindex) throws DomainServiceException {
		log.debug( "get tgroupCategoryMap by mapindex starting..." );
		TGroupCategoryMap rsObj = new TGroupCategoryMap();
		rsObj.setMapindex(mapindex);
		try
		{
			rsObj = dao.getTGroupCategoryMap( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tgroupCategoryMap by mapindex end" );
		return rsObj;
	}
	public List<TGroupCategoryMap> getTGroupCategoryMapByCond( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug( "get tgroupCategoryMap by condition starting..." );
		List<TGroupCategoryMap> rsList = null;
		try
		{
			rsList = dao.getTGroupCategoryMapByCond(tgroupCategoryMap);
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
		log.debug( "get tgroupCategoryMap by condition end" );
		return rsList;
	}
	public List<TGroupCategoryMap> getTGroupCategoryMapByCondExact( TGroupCategoryMap tgroupCategoryMap )throws DomainServiceException
	{
		log.debug( "get tgroupCategoryMap by exact condition starting..." );
		List<TGroupCategoryMap> rsList = null;
		try
		{
			rsList = dao.getTGroupCategoryMapByCondExact( tgroupCategoryMap );
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
		log.debug( "get tgroupCategoryMap by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tgroupCategoryMap page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tgroupCategoryMap, start, pageSize);
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
		tableInfo.setData((List<TGroupCategoryMap>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tgroupCategoryMap page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TGroupCategoryMap tgroupCategoryMap, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tgroupCategoryMap page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tgroupCategoryMap, start, pageSize, puEntity);
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
		tableInfo.setData((List<TGroupCategoryMap>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tgroupCategoryMap page info by condition end" );
		return tableInfo;
	}
	
}
