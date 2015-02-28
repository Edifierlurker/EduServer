package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITArticleinfoDAO;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoDS extends DynamicObjectBaseDS implements ITArticleinfoDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITArticleinfoDAO dao = null;
	
	public void setDao(ITArticleinfoDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTArticleinfo( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug("insert tarticleinfo starting...");
		try
		{
            // if (null == tarticleinfo.getArticleindex())
            // {
            // tarticleinfo.setArticleindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("t_articleinfo"));
            // }
			dao.insertTArticleinfo( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tarticleinfo end");
	}
	public void insertTArticleinfoList( List<TArticleinfo> tarticleinfoList )throws DomainServiceException
	{
		log.debug("insert tarticleinfoList by pk starting...");
		if(null == tarticleinfoList || tarticleinfoList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoList");
			return;
		}
	    try
		{
		   	int listSize = tarticleinfoList.size();
			Long index = (Long) Sequence.getSequence("t_articleinfo", listSize);
			for (int i = 0; i < tarticleinfoList.size(); i++) {
				if (tarticleinfoList.get(i) != null) {
					if (null == tarticleinfoList.get(i).getArticleindex()) {
						Long primaryindex = Long.valueOf(index + i);
						tarticleinfoList.get(i).setArticleindex(primaryindex);
					}
				}
			}
			dao.insertTArticleinfoList( tarticleinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tarticleinfoList by pk end");
	}
	public void updateTArticleinfo( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug("update tarticleinfo by pk starting...");
	    try
		{
			dao.updateTArticleinfo( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfo by pk end");
	}

	public void updateTArticleinfoList( List<TArticleinfo> tarticleinfoList )throws DomainServiceException
	{
		log.debug("update tarticleinfoList by pk starting...");
		if(null == tarticleinfoList || tarticleinfoList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoList");
			return;
		}
	    try
		{
			dao.updateTArticleinfoList( tarticleinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfoList by pk end");
	}

	public void updateTArticleinfoByCond( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug("update tarticleinfo by condition starting...");
		try
		{
			dao.updateTArticleinfoByCond( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfo by condition end");
	}


	public void removeTArticleinfo( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug( "remove tarticleinfo by pk starting..." );
		try
		{
			dao.deleteTArticleinfo( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfo by pk end" );
	}

	public void removeTArticleinfoList ( List<TArticleinfo> tarticleinfoList )throws DomainServiceException
	{
		log.debug( "remove tarticleinfoList by pk starting..." );
		if(null == tarticleinfoList || tarticleinfoList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoList");
			return;
		}
		try
		{
			dao.deleteTArticleinfoList( tarticleinfoList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfoList by pk end" );
	}

	public void removeTArticleinfoByCond( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug( "remove tarticleinfo by condition starting..." );
		try
		{
			dao.deleteTArticleinfoByCond( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfo by condition end" );
	}


	public TArticleinfo getTArticleinfo( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug( "get tarticleinfo by pk starting..." );
		TArticleinfo rsObj = null;
		try
		{
			rsObj = dao.getTArticleinfo( tarticleinfo );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tarticleinfoList by pk end" );
		return rsObj;
	}

	 public TArticleinfo getTArticleinfoByIndex(Long articleindex) throws DomainServiceException {
		log.debug( "get tarticleinfo by articleindex starting..." );
		TArticleinfo rsObj = new TArticleinfo();
		rsObj.setArticleindex(articleindex);
		try
		{
			rsObj = dao.getTArticleinfo( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tarticleinfo by articleindex end" );
		return rsObj;
	}
	public List<TArticleinfo> getTArticleinfoByCond( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug( "get tarticleinfo by condition starting..." );
		List<TArticleinfo> rsList = null;
		try
		{
			rsList = dao.getTArticleinfoByCond(tarticleinfo);
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
		log.debug( "get tarticleinfo by condition end" );
		return rsList;
	}
	public List<TArticleinfo> getTArticleinfoByCondExact( TArticleinfo tarticleinfo )throws DomainServiceException
	{
		log.debug( "get tarticleinfo by exact condition starting..." );
		List<TArticleinfo> rsList = null;
		try
		{
			rsList = dao.getTArticleinfoByCondExact( tarticleinfo );
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
		log.debug( "get tarticleinfo by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tarticleinfo page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tarticleinfo, start, pageSize);
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
		tableInfo.setData((List<TArticleinfo>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tarticleinfo page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tarticleinfo page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tarticleinfo, start, pageSize, puEntity);
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
		tableInfo.setData((List<TArticleinfo>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tarticleinfo page info by condition end" );
		return tableInfo;
	}
	
	public TableDataInfo pageInfoQueryExtends(TArticleinfo tarticleinfo, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
    {
        log.debug( "get tarticleinfo page info by condition starting..." );
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtends(tarticleinfo, start, pageSize, puEntity);
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
        tableInfo.setData((List<TArticleinfo>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug( "get tarticleinfo page info by condition end" );
        return tableInfo;
    }
    
	
}
