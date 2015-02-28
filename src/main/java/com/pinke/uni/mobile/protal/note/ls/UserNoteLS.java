package com.pinke.uni.mobile.protal.note.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.pinke.uni.mobile.protal.note.service.IUserNoteDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class UserNoteLS implements IUserNoteLS
{

    private Logger log = LoggerFactory.getLogger("UserNote", UserNoteLS.class);

    private IUserNoteDS userNoteDS;

    public void setUserNoteDS(IUserNoteDS userNoteDS)
    {
        this.userNoteDS = userNoteDS;
    }

    public String insertUserNote(UserNote userNote) throws DomainServiceException
    {
        // check param
        if (null == userNote)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        userNoteDS.insertUserNote(userNote);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userNote success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userNoteList);
        if (null == userNoteList || userNoteList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userNoteDS.insertUserNoteList(userNoteList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert userNoteList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserNote(UserNote userNote) throws DomainServiceException
    {
        // check param
        if (userNote == null || userNote.getNoteindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userNoteDS.updateUserNote(userNote);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userNote success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userNoteList);
        if (null == userNoteList || userNoteList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userNoteDS.updateUserNoteList(userNoteList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update userNoteList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserNote(UserNote userNote) throws DomainServiceException
    {
        // check param
        if (userNote == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userNoteDS.removeUserNote(userNote);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userNote success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeUserNoteList(List<UserNote> userNoteList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(userNoteList);
        if (userNoteList == null || userNoteList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        userNoteDS.removeUserNoteList(userNoteList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove userNoteList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public UserNote getUserNote(UserNote userNote) throws DomainServiceException
    {
        // check param
        if (userNote == null || userNote.getNoteindex() == null)
        {
            return null;
        }
        return userNoteDS.getUserNote(userNote);
    }

    public UserNote getUserNoteByIndex(Long noteindex) throws DomainServiceException
    {
        // check param
        if (noteindex == null)
        {
            return null;
        }
        return userNoteDS.getUserNoteByIndex(noteindex);
    }

    public List<UserNote> getUserNoteByCond(UserNote userNote) throws DomainServiceException
    {
        return userNoteDS.getUserNoteByCond(userNote);
    }

    public List<UserNote> getUserNoteByCondExact(UserNote userNote) throws DomainServiceException
    {
        return userNoteDS.getUserNoteByCondExact(userNote);
    }

    public TableDataInfo pageInfoQuery(UserNote userNote, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return userNoteDS.pageInfoQuery(userNote, start, pageSize, puEntity);
    }

}
