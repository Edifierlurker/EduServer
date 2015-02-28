package com.pinke.uni.mobile.protal.note.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.zte.misp.common.dynamicobj.DynamicObjectMispDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public class UserNoteDAO extends DynamicObjectMispDAO implements IUserNoteDAO
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    public void insertUserNote(UserNote userNote) throws DAOException
    {
        log.debug("insert userNote starting...");
        super.insert("insertUserNote", userNote);
        log.debug("insert userNote end");
    }

    public void insertUserNoteList(List<UserNote> userNoteList) throws DAOException
    {
        log.debug("insert userNoteList starting...");
        if (null != userNoteList)
        {
            super.insertBatch("insertUserNote", userNoteList);
        }
        log.debug("insert userNoteList end");
    }

    public void updateUserNote(UserNote userNote) throws DAOException
    {
        log.debug("update userNote by pk starting...");
        super.update("updateUserNote", userNote);
        log.debug("update userNote by pk end");
    }

    public void updateUserNoteList(List<UserNote> userNoteList) throws DAOException
    {
        log.debug("update userNoteList by pk starting...");
        super.updateBatch("updateUserNote", userNoteList);
        log.debug("update userNoteList by pk end");
    }

    public void updateUserNoteByCond(UserNote userNote) throws DAOException
    {
        log.debug("update userNote by conditions starting...");
        super.update("updateUserNoteByCond", userNote);
        log.debug("update userNote by conditions end");
    }

    public void deleteUserNote(UserNote userNote) throws DAOException
    {
        log.debug("delete userNote by pk starting...");
        super.delete("deleteUserNote", userNote);
        log.debug("delete userNote by pk end");
    }

    public void deleteUserNoteList(List<UserNote> userNoteList) throws DAOException
    {
        log.debug("delete userNoteList by pk starting...");
        super.deleteBatch("deleteUserNote", userNoteList);
        log.debug("delete userNoteList by pk end");
    }

    public void deleteUserNoteByCond(UserNote userNote) throws DAOException
    {
        log.debug("delete userNote by conditions starting...");
        super.delete("deleteUserNoteByCond", userNote);
        log.debug("delete userNote by conditions end");
    }

    public UserNote getUserNote(UserNote userNote) throws DAOException
    {
        log.debug("query userNote starting...");
        UserNote resultObj = (UserNote) super.queryForObject("getUserNote", userNote);
        log.debug("query userNote end");
        return resultObj;
    }

    @SuppressWarnings("unchecked")
    public List<UserNote> getUserNoteByCond(UserNote userNote) throws DAOException
    {
        log.debug("query userNote by condition starting...");
        List<UserNote> rList = (List<UserNote>) super.queryForList("queryUserNoteListByCond", userNote);
        log.debug("query userNote by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserNote> getUserNoteByCondExact(UserNote userNote) throws DAOException
    {
        log.debug("query userNote by exact condition starting...");
        List<UserNote> rList = (List<UserNote>) super.queryForList("queryUserNoteListByCondExact", userNote);
        log.debug("query userNote by exact condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public List<UserNote> getUserNoteByCond(UserNote userNote, PageUtilEntity puEntity) throws DAOException
    {
        log.debug("query userNote by condition starting...");
        List<UserNote> rList = (List<UserNote>) super.queryForList("queryUserNoteListByCond", userNote, puEntity);
        log.debug("query userNote by condition end");
        return rList;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserNote userNote, int start, int pageSize) throws DAOException
    {
        log.debug("page query userNote by condition starting...");
        PageInfo pageInfo = null;
        int totalCnt = ((Integer) super.queryForObject("queryUserNoteListCntByCond", userNote)).intValue();
        if (totalCnt > 0)
        {
            int fetchSize = pageSize > (totalCnt - start) ? (totalCnt - start) : pageSize;
            List<UserNote> rsList = (List<UserNote>) super.pageQuery("queryUserNoteListByCond", userNote, start,
                    fetchSize);
            pageInfo = new PageInfo(start, totalCnt, fetchSize, rsList);
        }
        else
        {
            pageInfo = new PageInfo();
        }
        log.debug("page query userNote by condition end");
        return pageInfo;
    }

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQuery(UserNote userNote, int start, int pageSize, PageUtilEntity puEntity)
            throws DAOException
    {
        return super.indexPageQuery("queryUserNoteListByCond", "queryUserNoteListCntByCond", userNote, start, pageSize,
                puEntity);
    }

}