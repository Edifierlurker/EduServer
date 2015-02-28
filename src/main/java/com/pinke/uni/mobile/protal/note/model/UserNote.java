package com.pinke.uni.mobile.protal.note.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserNote extends DynamicBaseObject implements Serializable
{

    private java.lang.Long noteindex;
    private java.lang.String notetitle;
    private java.lang.Long studentindex;
    private java.lang.Integer status;
    private java.lang.String notedesc;
    private java.lang.String iconurl;
    private java.lang.String recordurl;
    private java.lang.String createtime;
    private java.lang.String updatetime;
    private java.lang.String note;

    public java.lang.Long getNoteindex()
    {
        return noteindex;
    }

    public void setNoteindex(java.lang.Long noteindex)
    {
        this.noteindex = noteindex;
    }

    public java.lang.String getNotetitle()
    {
        return notetitle;
    }

    public void setNotetitle(java.lang.String notetitle)
    {
        this.notetitle = notetitle;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getNotedesc()
    {
        return notedesc;
    }

    public void setNotedesc(java.lang.String notedesc)
    {
        this.notedesc = notedesc;
    }

    public java.lang.String getIconurl()
    {
        return iconurl;
    }

    public void setIconurl(java.lang.String iconurl)
    {
        this.iconurl = iconurl;
    }

    public java.lang.String getRecordurl()
    {
        return recordurl;
    }

    public void setRecordurl(java.lang.String recordurl)
    {
        this.recordurl = recordurl;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(java.lang.String updatetime)
    {
        this.updatetime = updatetime;
    }

    public java.lang.String getNote()
    {
        return note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    public void initRelation()
    {
        this.addRelation("noteindex", "noteindex");
        this.addRelation("notetitle", "notetitle");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("status", "status");
        this.addRelation("notedesc", "notedesc");
        this.addRelation("iconurl", "iconurl");
        this.addRelation("recordurl", "recordurl");
        this.addRelation("createtime", "createtime");
        this.addRelation("updatetime", "updatetime");
        this.addRelation("note", "note");
    }
}
