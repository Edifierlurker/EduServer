package com.pinke.uni.mobile.protal.note.service;

import java.util.List;

import com.pinke.uni.mobile.protal.note.dao.IUserNoteDAO;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.zte.misp.common.dynamicobj.DynamicObjectBaseDS;
import com.zte.misp.common.framework.base.Sequence;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DAOException;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserNoteDS extends DynamicObjectBaseDS implements IUserNoteDS
{
    // 日志
    private Log log = SSBBus.getLog(getClass());

    private IUserNoteDAO dao = null;

    public void setDao(IUserNoteDAO dao)
    {
        this.dao = dao;
    }

    public void insertUserNote(UserNote userNote) throws DomainServiceException
    {
        log.debug("insert userNote starting...");
        try
        {
//            if (null == userNote.getNoteindex())
//            {
//                userNote.setNoteindex((Long) this.getPrimaryKeyGenerator().getPrimarykey("user_note"));
//            }
            dao.insertUserNote(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userNote end");
    }

    public void insertUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        log.debug("insert userNoteList by pk starting...");
        if (null == userNoteList || userNoteList.size() == 0)
        {
            log.debug("there is no datas in userNoteList");
            return;
        }
        try
        {
            int listSize = userNoteList.size();
            Long index = (Long) Sequence.getSequence("user_note", listSize);
            for (int i = 0; i < userNoteList.size(); i++)
            {
                if (userNoteList.get(i) != null)
                {
                    if (null == userNoteList.get(i).getNoteindex())
                    {
                        Long primaryindex = Long.valueOf(index + i);
                        userNoteList.get(i).setNoteindex(primaryindex);
                    }
                }
            }
            dao.insertUserNoteList(userNoteList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("insert userNoteList by pk end");
    }

    public void updateUserNote(UserNote userNote) throws DomainServiceException
    {
        log.debug("update userNote by pk starting...");
        try
        {
            dao.updateUserNote(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userNote by pk end");
    }

    public void updateUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        log.debug("update userNoteList by pk starting...");
        if (null == userNoteList || userNoteList.size() == 0)
        {
            log.debug("there is no datas in userNoteList");
            return;
        }
        try
        {
            dao.updateUserNoteList(userNoteList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("update userNoteList by pk end");
    }

    public void removeUserNote(UserNote userNote) throws DomainServiceException
    {
        log.debug("remove userNote by pk starting...");
        try
        {
            dao.deleteUserNote(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userNote by pk end");
    }

    public void removeUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        log.debug("remove userNoteList by pk starting...");
        if (null == userNoteList || userNoteList.size() == 0)
        {
            log.debug("there is no datas in userNoteList");
            return;
        }
        try
        {
            dao.deleteUserNoteList(userNoteList);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("remove userNoteList by pk end");
    }

    public UserNote getUserNote(UserNote userNote) throws DomainServiceException
    {
        log.debug("get userNote by pk starting...");
        UserNote rsObj = null;
        try
        {
            rsObj = dao.getUserNote(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userNoteList by pk end");
        return rsObj;
    }

    public UserNote getUserNoteByIndex(Long noteindex) throws DomainServiceException
    {
        log.debug("get userNote by noteindex starting...");
        UserNote rsObj = new UserNote();
        rsObj.setNoteindex(noteindex);
        try
        {
            rsObj = dao.getUserNote(rsObj);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        log.debug("get userNote by noteindex end");
        return rsObj;
    }

    public List<UserNote> getUserNoteByCond(UserNote userNote) throws DomainServiceException
    {
        log.debug("get userNote by condition starting...");
        List<UserNote> rsList = null;
        try
        {
            rsList = dao.getUserNoteByCond(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get userNote by condition end");
        return rsList;
    }

    public List<UserNote> getUserNoteByCondExact(UserNote userNote) throws DomainServiceException
    {
        log.debug("get userNote by exact condition starting...");
        List<UserNote> rsList = null;
        try
        {
            rsList = dao.getUserNoteByCondExact(userNote);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        log.debug("get userNote by exact condition end");
        return rsList;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserNote userNote, int start, int pageSize) throws DomainServiceException
    {
        log.debug("get userNote page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userNote, start, pageSize);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<UserNote>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userNote page info by condition end");
        return tableInfo;
    }

    @SuppressWarnings("unchecked")
    public TableDataInfo pageInfoQuery(UserNote userNote, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        log.debug("get userNote page info by condition starting...");
        PageInfo pageInfo = null;
        try
        {
            pageInfo = dao.pageInfoQuery(userNote, start, pageSize, puEntity);
        }
        catch (DAOException daoEx)
        {
            log.error("dao exception:", daoEx);
            // TODO 根据实际应用，可以在此处添加异常国际化处理
            throw new DomainServiceException(daoEx);
        }
        catch (Exception e)
        {
            log.error("exception:", e);
            throw new DomainServiceException(e);
        }
        TableDataInfo tableInfo = new TableDataInfo();
        tableInfo.setData((List<UserNote>) pageInfo.getResult());
        tableInfo.setTotalCount((int) pageInfo.getTotalCount());
        log.debug("get userNote page info by condition end");
        return tableInfo;
    }

}
