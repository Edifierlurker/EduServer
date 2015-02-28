package com.pinke.uni.mobile.protal.note.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.note.model.UserNote;

public interface IUserNoteFS
{
    /**
     * 根据用户index查询笔记列表
     * 
     * @param userIndex
     * @return
     */
    public List getUserNoteListByUserIndex(Long userIndex);

    /**
     * 根据笔记index查询笔记详情
     * 
     * @param noteIndex
     * @return
     */
    public UserNote getUserNoteDetailByNoteIndex(Long noteIndex);

    /**
     * 添加用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean insertUserNote(UserNote userNote);

    /**
     * 删除用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean delUserNote(UserNote userNote);

    /**
     * 修改用户笔记
     * 
     * @param userNote
     * @return
     */
    public boolean updateUserNote(UserNote userNote);

}
