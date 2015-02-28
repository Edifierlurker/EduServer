package com.pinke.uni.mobile.protal.note.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.note.ls.IUserNoteLS;
import com.pinke.uni.mobile.protal.note.model.UserNote;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class UserNoteFS implements IUserNoteFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private Log log = SSBBus.getLog(this.getClass());
    private IUserNoteLS userNoteLS;

    /**
     * 根据用户index查询笔记列表
     * 
     * @param userIndex
     * @return
     */
    public List getUserNoteListByUserIndex(Long userIndex)
    {
        if (userIndex == null)
        {
            return null;
        }
        SeriObjDCache dcValue = null;
        String strKey = "getUserNoteListByUserIndex";
        List<UserNote> list = new ArrayList();
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex));

        }
        if (dcValue == null || mcc == null)
        {
            try
            {
                UserNote userNote = new UserNote();
                userNote.setStudentindex(userIndex);
                userNote.setStatus(1);
                list = userNoteLS.getUserNoteByCond(userNote);
            }
            catch (DomainServiceException e)
            {
                log.error("根据用户index查询笔记列表异常" + e);
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list);

                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                }
                boolean success = mcc.set(new String(strKey + "_" + userIndex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list = dcValue.getMemlist();
            }
        }
        return list;

    }

    /**
     * 根据笔记index查询笔记详情
     * 
     * @param noteIndex
     * @return
     */
    public UserNote getUserNoteDetailByNoteIndex(Long noteIndex)
    {
        if (noteIndex == null)
        {
            return null;
        }
        SeriObjDCache dcValue = null;
        String strKey = "getUserNoteDetailByNoteIndex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + noteIndex));

        }
        UserNote userNote = null;
        if (dcValue == null || mcc == null)
        {
            try
            {
                userNote = userNoteLS.getUserNoteByIndex(noteIndex);
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (userNote != null)
                {
                    dcValue.setMemObj(userNote);

                }
                else
                {
                    dcValue.setMemObj(new UserNote());
                }
                boolean success = mcc.set(new String(strKey + "_" + noteIndex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                userNote = (UserNote) dcValue.getMemObj();
            }
        }
        return userNote;
    }

    /**
     * 添加用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean insertUserNote(UserNote userNote)
    {
        boolean result = false;
        if (userNote == null || userNote.getStudentindex() == null)
        {
            return false;
        }
        try
        {
            String errorCode = userNoteLS.insertUserNote(userNote);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            log.error("添加笔记详情异常" + e);
        }
        return result;
    }

    /**
     * 删除用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean delUserNote(UserNote userNote)
    {
        if (userNote == null || userNote.getNoteindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorCode = userNoteLS.removeUserNote(userNote);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }

        }
        catch (DomainServiceException e)
        {
            log.error("删除用户笔记 异常" + e);
        }
        return result;
    }

    /**
     * 修改用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean updateUserNote(UserNote userNote)
    {
        boolean result = false;
        if (userNote == null || userNote.getNoteindex() == null)
        {
            return false;
        }
        try
        {
            String errorCode = userNoteLS.updateUserNote(userNote);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            log.error("修改用户笔记 异常" + e);
        }
        return result;
    }

    public IUserNoteLS getUserNoteLS()
    {
        return userNoteLS;
    }

    public void setUserNoteLS(IUserNoteLS userNoteLS)
    {
        this.userNoteLS = userNoteLS;
    }

}
