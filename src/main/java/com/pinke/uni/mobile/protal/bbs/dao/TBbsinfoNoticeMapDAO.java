
  package com.pinke.uni.mobile.protal.bbs.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class TBbsinfoNoticeMapDAO extends DynamicObjectMispDAO implements ITBbsinfoNoticeMapDAO
{	
	// 日志
	private Log log = SSBBus.getLog(getClass());
	
    public void insertTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("insert tbbsinfoNoticeMap starting...");
        super.insert( "insertTBbsinfoNoticeMap", tbbsinfoNoticeMap );
    	log.debug("insert tbbsinfoNoticeMap end");
    }
	
	public void insertTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException
	{
		log.debug("insert tbbsinfoNoticeMapList starting...");
		if( null != tbbsinfoNoticeMapList )
		{
		   super.insertBatch( "insertTBbsinfoNoticeMap", tbbsinfoNoticeMapList );
		}
		log.debug("insert tbbsinfoNoticeMapList end");
	}
     
    public void updateTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("update tbbsinfoNoticeMap by pk starting...");
       	super.update( "updateTBbsinfoNoticeMap", tbbsinfoNoticeMap );
       	log.debug("update tbbsinfoNoticeMap by pk end");
    }
    public void updateTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException
    {
    	log.debug("update tbbsinfoNoticeMapList by pk starting...");
	    super.updateBatch( "updateTBbsinfoNoticeMap", tbbsinfoNoticeMapList );
       	log.debug("update tbbsinfoNoticeMapList by pk end");
    }

    public void updateTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("update tbbsinfoNoticeMap by conditions starting...");
    	super.update( "updateTBbsinfoNoticeMapByCond", tbbsinfoNoticeMap );
    	log.debug("update tbbsinfoNoticeMap by conditions end");
    }

    public void deleteTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("delete tbbsinfoNoticeMap by pk starting...");
       	super.delete( "deleteTBbsinfoNoticeMap", tbbsinfoNoticeMap );
       	log.debug("delete tbbsinfoNoticeMap by pk end");
    }
    public void deleteTBbsinfoNoticeMapList( List<TBbsinfoNoticeMap> tbbsinfoNoticeMapList )throws DAOException
    {
    	log.debug("delete tbbsinfoNoticeMapList by pk starting...");
       	super.deleteBatch( "deleteTBbsinfoNoticeMap", tbbsinfoNoticeMapList );
       	log.debug("delete tbbsinfoNoticeMapList by pk end");
    }

    public void deleteTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("delete tbbsinfoNoticeMap by conditions starting...");
    	super.delete( "deleteTBbsinfoNoticeMapByCond", tbbsinfoNoticeMap );
    	log.debug("delete tbbsinfoNoticeMap by conditions end");
    }

    public TBbsinfoNoticeMap getTBbsinfoNoticeMap( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("query tbbsinfoNoticeMap starting...");
        TBbsinfoNoticeMap resultObj = (TBbsinfoNoticeMap) super.queryForObject("getTBbsinfoNoticeMap", tbbsinfoNoticeMap);
       	log.debug("query tbbsinfoNoticeMap end");
       	return resultObj;
    }

	@SuppressWarnings("unchecked")
    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
    {
    	log.debug("query tbbsinfoNoticeMap by condition starting...");
    	List<TBbsinfoNoticeMap> rList = (List<TBbsinfoNoticeMap>)super.queryForList( "queryTBbsinfoNoticeMapListByCond",tbbsinfoNoticeMap);
    	log.debug("query tbbsinfoNoticeMap by condition end");
    	return rList;
    }
    
	@SuppressWarnings("unchecked")
	public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCondExact( TBbsinfoNoticeMap tbbsinfoNoticeMap )throws DAOException
	{
    	log.debug("query tbbsinfoNoticeMap by exact condition starting...");
    	List<TBbsinfoNoticeMap> rList = (List<TBbsinfoNoticeMap>)super.queryForList( "queryTBbsinfoNoticeMapListByCondExact",tbbsinfoNoticeMap);
    	log.debug("query tbbsinfoNoticeMap by exact condition end");
    	return rList;
    }
	
	@SuppressWarnings("unchecked")
    public List<TBbsinfoNoticeMap> getTBbsinfoNoticeMapByCond( TBbsinfoNoticeMap tbbsinfoNoticeMap, PageUtilEntity puEntity )throws DAOException
    {
        log.debug("query tbbsinfoNoticeMap by condition starting...");
        List<TBbsinfoNoticeMap> rList = (List<TBbsinfoNoticeMap>)super.queryForList( "queryTBbsinfoNoticeMapListByCond",tbbsinfoNoticeMap,puEntity);
        log.debug("query tbbsinfoNoticeMap by condition end");
        return rList;
    }
	
	@SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize)throws DAOException
    {
    	log.debug("page query tbbsinfoNoticeMap by condition starting...");
     	PageInfo pageInfo = null;
    	int totalCnt = ((Integer) super.queryForObject("queryTBbsinfoNoticeMapListCntByCond",  tbbsinfoNoticeMap)).intValue();
    	if( totalCnt > 0 )
    	{
    		int fetchSize = pageSize > (totalCnt - start)? (totalCnt - start) : pageSize;
    		List<TBbsinfoNoticeMap> rsList = (List<TBbsinfoNoticeMap>)super.pageQuery( "queryTBbsinfoNoticeMapListByCond" ,  tbbsinfoNoticeMap , start , fetchSize );
    		pageInfo = new PageInfo( start, totalCnt, fetchSize, rsList );
    	}
    	else
    	{
    		pageInfo = new PageInfo();
    	}
    	log.debug("page query tbbsinfoNoticeMap by condition end");
    	return pageInfo;
    }
    
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(TBbsinfoNoticeMap tbbsinfoNoticeMap, int start, int pageSize, PageUtilEntity puEntity)throws DAOException
    {
        return super.indexPageQuery( "queryTBbsinfoNoticeMapListByCond", "queryTBbsinfoNoticeMapListCntByCond", tbbsinfoNoticeMap, start, pageSize, puEntity);
    }
 
} 