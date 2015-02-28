package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TBbsinfoNoticeMap extends DynamicBaseObject implements Serializable
{

    private java.lang.Long mapindex;
    private java.lang.Long bbsindex;
    private java.lang.Long attendindex;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.String bbstitle;
    private java.lang.String bbsbref;
    private java.lang.String createtime;
    private java.lang.Integer attendcount;

    public java.lang.Long getMapindex()
    {
        return mapindex;
    }

    public void setMapindex(java.lang.Long mapindex)
    {
        this.mapindex = mapindex;
    }

    public java.lang.Long getBbsindex()
    {
        return bbsindex;
    }

    public void setBbsindex(java.lang.Long bbsindex)
    {
        this.bbsindex = bbsindex;
    }

    public java.lang.Long getAttendindex()
    {
        return attendindex;
    }

    public void setAttendindex(java.lang.Long attendindex)
    {
        this.attendindex = attendindex;
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

    public java.lang.String getBbstitle()
    {
        return bbstitle;
    }

    public void setBbstitle(java.lang.String bbstitle)
    {
        this.bbstitle = bbstitle;
    }

    public java.lang.String getBbsbref()
    {
        return bbsbref;
    }

    public void setBbsbref(java.lang.String bbsbref)
    {
        this.bbsbref = bbsbref;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.Integer getAttendcount()
    {
        return attendcount;
    }

    public void setAttendcount(java.lang.Integer attendcount)
    {
        this.attendcount = attendcount;
    }

    public void initRelation()
    {
        this.addRelation("mapindex", "mapindex");
        this.addRelation("bbsindex", "bbsindex");
        this.addRelation("attendindex", "attendindex");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("bbstitle", "bbstitle");
        this.addRelation("bbsbref", "bbsbref");
        this.addRelation("createtime", "createtime");
        this.addRelation("attendcount", "attendcount");
    }
}
