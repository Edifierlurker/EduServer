package com.pinke.uni.mobile.protal.exam.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserExaminfoAttendMap extends DynamicBaseObject implements Serializable
{

    private java.lang.Long attendindex;
    private java.lang.Long examindex;
    private java.lang.Long userindex;
    private java.lang.Integer status;
    private java.lang.String note;

    public java.lang.Long getAttendindex()
    {
        return attendindex;
    }

    public void setAttendindex(java.lang.Long attendindex)
    {
        this.attendindex = attendindex;
    }

    public java.lang.Long getExamindex()
    {
        return examindex;
    }

    public void setExamindex(java.lang.Long examindex)
    {
        this.examindex = examindex;
    }

    public java.lang.Long getUserindex()
    {
        return userindex;
    }

    public void setUserindex(java.lang.Long userindex)
    {
        this.userindex = userindex;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
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
        this.addRelation("attendindex", "attendindex");
        this.addRelation("examindex", "examindex");
        this.addRelation("userindex", "userindex");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
    }
}
