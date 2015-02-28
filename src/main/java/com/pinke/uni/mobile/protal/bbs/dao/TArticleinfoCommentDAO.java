
  package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TArticleinfoCommentDAO extends DynamicObjectMispDAO implements ITArticleinfoCommentDAO
{	
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
    public void insertTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("insert tarticleinfoComment starting...");
        super.insert( "insertTArticleinfoComment", tarticleinfoComment );
    	log.debug("insert tarticleinfoComment end");
    }
	
	public void insertTArticleinfoCommentList( List<TArticleinfoComment> tarticleinfoCommentList )throws DAOException
	{
		log.debug("insert tarticleinfoCommentList starting...");
		if( null != tarticleinfoCommentList )
		{
		   super.insertBatch( "insertTArticleinfoComment", tarticleinfoCommentList );
		}
		log.debug("insert tarticleinfoCommentList end");
	}
     
    public void updateTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("update tarticleinfoComment by pk starting...");
       	super.update( "updateTArticleinfoComment", tarticleinfoComment );
       	log.debug("update tarticleinfoComment by pk end");
    }
    public void updateTArticleinfoCommentList( List<TArticleinfoComment> tarticleinfoCommentList )throws DAOException
    {
    	log.debug("update tarticleinfoCommentList by pk starting...");
	    super.updateBatch( "updateTArticleinfoComment", tarticleinfoCommentList );
       	log.debug("update tarticleinfoCommentList by pk end");
    }

    public void updateTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("update tarticleinfoComment by conditions starting...");
    	super.update( "updateTArticleinfoCommentByCond", tarticleinfoComment );
    	log.debug("update tarticleinfoComment by conditions end");
    }

    public void deleteTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("delete tarticleinfoComment by pk starting...");
       	super.delete( "deleteTArticleinfoComment", tarticleinfoComment );
       	log.debug("delete tarticleinfoComment by pk end");
    }
    public void deleteTArticleinfoCommentList( List<TArticleinfoComment> tarticleinfoCommentList )throws DAOException
    {
    	log.debug("delete tarticleinfoCommentList by pk starting...");
       	super.deleteBatch( "deleteTArticleinfoComment", tarticleinfoCommentList );
       	log.debug("delete tarticleinfoCommentList by pk end");
    }

    public void deleteTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("delete tarticleinfoComment by conditions starting...");
    	super.delete( "deleteTArticleinfoCommentByCond", tarticleinfoComment );
    	log.debug("delete tarticleinfoComment by conditions end");
    }

    public TArticleinfoComment getTArticleinfoComment( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("query tarticleinfoComment starting...");
        TArticleinfoComment resultObj = (TArticleinfoComment) super.queryForObject("getTArticleinfoComment", tarticleinfoComment);
       	log.debug("query tarticleinfoComment end");
       	return resultObj;
    }

	@SuppressWarnings("unchecked")
    public List<TArticleinfoComment> getTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment )throws DAOException
    {
    	log.debug("query tarticleinfoComment by condition starting...");
    	List<TArticleinfoComment> rList = (List<TArticleinfoComment>)super.queryForList( "queryTArticleinfoCommentListByCond",tarticleinfoComment);
    	log.debug("query tarticleinfoComment by condition end");
    	return rList;
    }
    
	@SuppressWarnings("unchecked")
	public List<TArticleinfoComment> getTArticleinfoCommentByCondExact( TArticleinfoComment tarticleinfoComment )throws DAOException
	{
    	log.debug("query tarticleinfoComment by exact condition starting...");
    	List<TArticleinfoComment> rList = (List<TArticleinfoComment>)super.queryForList( "queryTArticleinfoCommentListByCondExact",tarticleinfoComment);
    	log.debug("query tarticleinfoComment by exact condition end");
    	return rList;
    }
	
	@SuppressWarnings("unchecked")
    public List<TArticleinfoComment> getTArticleinfoCommentByCond( TArticleinfoComment tarticleinfoComment, PageUtilEntity puEntity )throws DAOException
    {
        log.debug("query tarticleinfoComment by condition starting...");
        List<TArticleinfoComment> rList = (List<TArticleinfoComment>)super.queryForList( "queryTArticleinfoCommentListByCond",tarticleinfoComment,puEntity);
        log.debug("query tarticleinfoComment by condition end");
        return rList;
    }
	
	@SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize)throws DAOException
    {
    	log.debug("page query tarticleinfoComment by condition starting...");
     	PageInfo pageInfo = null;
    	int totalCnt = ((Integer) super.queryForObject("queryTArticleinfoCommentListCntByCond",  tarticleinfoComment)).intValue();
    	if( totalCnt > 0 )
    	{
    		int fetchSize = pageSize > (totalCnt - start)? (totalCnt - start) : pageSize;
    		List<TArticleinfoComment> rsList = (List<TArticleinfoComment>)super.pageQuery( "queryTArticleinfoCommentListByCond" ,  tarticleinfoComment , start , fetchSize );
    		pageInfo = new PageInfo( start, totalCnt, fetchSize, rsList );
    	}
    	else
    	{
    		pageInfo = new PageInfo();
    	}
    	log.debug("page query tarticleinfoComment by condition end");
    	return pageInfo;
    }
    
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TArticleinfoComment tarticleinfoComment, int start, int pageSize, PageUtilEntity puEntity)throws DAOException
    {
        return super.indexPageQuery( "queryTArticleinfoCommentListByCond", "queryTArticleinfoCommentListCntByCond", tarticleinfoComment, start, pageSize, puEntity);
    }
    
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(TArticleinfoComment tarticleinfoComment, int start, int pageSize, PageUtilEntity puEntity)throws DAOException
    {
        return super.indexPageQuery( "queryTArticleinfoCommentListByCondExtends", "queryTArticleinfoCommentListCntByCondExtends", tarticleinfoComment, start, pageSize, puEntity);
    }
    
 
} 