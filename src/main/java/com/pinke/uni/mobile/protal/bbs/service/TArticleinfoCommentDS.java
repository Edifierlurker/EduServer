package com.pinke.uni.mobile.protal.bbs.service;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.dao.ITArticleinfoCommentDAO;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TArticleinfoCommentDS extends DynamicObjectBaseDS implements ITArticleinfoCommentDS
{
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
  	private ITArticleinfoCommentDAO dao = null;
	
	public void setDao(ITArticleinfoCommentDAO dao)
	{
	    this.dao = dao;
	}
	public void insertTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug("insert tarticleinfoComment starting...");
		try
		{
            // if (null == tarticleinfoComment.getCommentindex())
            // {
            // tarticleinfoComment.setCommentindex((Long)
            // this.getPrimaryKeyGenerator().getPrimarykey("t_articleinfo_comment"));
            // }
			dao.insertTArticleinfoComment( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tarticleinfoComment end");
	}
	public void insertTArticleinfoCommentList( List<TArticleinfoComment> tarticleinfoCommentList )throws DomainServiceException
	{
		log.debug("insert tarticleinfoCommentList by pk starting...");
		if(null == tarticleinfoCommentList || tarticleinfoCommentList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoCommentList");
			return;
		}
	    try
		{
		   	int listSize = tarticleinfoCommentList.size();
			Long index = (Long) Sequence.getSequence("t_articleinfo_comment", listSize);
			for (int i = 0; i < tarticleinfoCommentList.size(); i++) {
				if (tarticleinfoCommentList.get(i) != null) {
					if (null == tarticleinfoCommentList.get(i).getCommentindex()) {
						Long primaryindex = Long.valueOf(index + i);
						tarticleinfoCommentList.get(i).setCommentindex(primaryindex);
					}
				}
			}
			dao.insertTArticleinfoCommentList( tarticleinfoCommentList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("insert tarticleinfoCommentList by pk end");
	}
	public void updateTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug("update tarticleinfoComment by pk starting...");
	    try
		{
			dao.updateTArticleinfoComment( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfoComment by pk end");
	}

	public void updateTArticleinfoCommentList( List<TArticleinfoComment> tarticleinfoCommentList )throws DomainServiceException
	{
		log.debug("update tarticleinfoCommentList by pk starting...");
		if(null == tarticleinfoCommentList || tarticleinfoCommentList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoCommentList");
			return;
		}
	    try
		{
			dao.updateTArticleinfoCommentList( tarticleinfoCommentList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfoCommentList by pk end");
	}

	public void updateTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug("update tarticleinfoComment by condition starting...");
		try
		{
			dao.updateTArticleinfoCommentByCond( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug("update tarticleinfoComment by condition end");
	}


	public void removeTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug( "remove tarticleinfoComment by pk starting..." );
		try
		{
			dao.deleteTArticleinfoComment( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfoComment by pk end" );
	}

	public void removeTArticleinfoCommentList ( List<TArticleinfoComment> tarticleinfoCommentList )throws DomainServiceException
	{
		log.debug( "remove tarticleinfoCommentList by pk starting..." );
		if(null == tarticleinfoCommentList || tarticleinfoCommentList.size() == 0 )
		{
			log.debug("there is no datas in tarticleinfoCommentList");
			return;
		}
		try
		{
			dao.deleteTArticleinfoCommentList( tarticleinfoCommentList );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfoCommentList by pk end" );
	}

	public void removeTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug( "remove tarticleinfoComment by condition starting..." );
		try
		{
			dao.deleteTArticleinfoCommentByCond( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "remove tarticleinfoComment by condition end" );
	}


	public TArticleinfoComment getTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug( "get tarticleinfoComment by pk starting..." );
		TArticleinfoComment rsObj = null;
		try
		{
			rsObj = dao.getTArticleinfoComment( tarticleinfoComment );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tarticleinfoCommentList by pk end" );
		return rsObj;
	}

	 public TArticleinfoComment getTArticleinfoCommentByIndex(Long commentindex) throws DomainServiceException {
		log.debug( "get tarticleinfoComment by commentindex starting..." );
		TArticleinfoComment rsObj = new TArticleinfoComment();
		rsObj.setCommentindex(commentindex);
		try
		{
			rsObj = dao.getTArticleinfoComment( rsObj );
		}
		catch( DAOException daoEx )
		{
			log.error( "dao exception:", daoEx );
			// TODO 根据实际应用，可以在此处添加异常国际化处理
			throw new DomainServiceException( daoEx );
		}
		log.debug( "get tarticleinfoComment by commentindex end" );
		return rsObj;
	}
	public List<TArticleinfoComment> getTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug( "get tarticleinfoComment by condition starting..." );
		List<TArticleinfoComment> rsList = null;
		try
		{
			rsList = dao.getTArticleinfoCommentByCond(tarticleinfoComment);
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
		log.debug( "get tarticleinfoComment by condition end" );
		return rsList;
	}
	public List<TArticleinfoComment> getTArticleinfoCommentByCondExact( TArticleinfoComment tarticleinfoComment )throws DomainServiceException
	{
		log.debug( "get tarticleinfoComment by exact condition starting..." );
		List<TArticleinfoComment> rsList = null;
		try
		{
			rsList = dao.getTArticleinfoCommentByCondExact( tarticleinfoComment );
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
		log.debug( "get tarticleinfoComment by exact condition end" );
		return rsList;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize)throws DomainServiceException
	{
		log.debug( "get tarticleinfoComment page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tarticleinfoComment, start, pageSize);
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
		tableInfo.setData((List<TArticleinfoComment>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tarticleinfoComment page info by condition end" );
		return tableInfo;
	}
	@SuppressWarnings("unchecked")
	public TableDataInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
	{
		log.debug( "get tarticleinfoComment page info by condition starting..." );
		PageInfo pageInfo = null;
		try
		{
			pageInfo = dao.pageInfoQuery(tarticleinfoComment, start, pageSize, puEntity);
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
		tableInfo.setData((List<TArticleinfoComment>) pageInfo.getResult());
		tableInfo.setTotalCount((int) pageInfo.getTotalCount());
		log.debug( "get tarticleinfoComment page info by condition end" );
		return tableInfo;
	}
	
	@SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQueryExtends(TArticleinfoComment tarticleinfoComment, int start, int pageSize, PageUtilEntity puEntity)throws DomainServiceException
    {
        log.debug( "get tarticleinfoComment page info by condition starting..." );
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQueryExtends(tarticleinfoComment, start, pageSize, puEntity);
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
        tableInfo.setData((List<TArticleinfoComment>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug( "get tarticleinfoComment page info by condition end" );
        return tableInfo;
    }
	
}
