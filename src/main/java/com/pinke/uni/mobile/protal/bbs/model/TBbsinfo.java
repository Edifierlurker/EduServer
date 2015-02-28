package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TBbsinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long bbsindex;
    private java.lang.String bbstitle;
    private java.lang.String bbsbref;
    private java.lang.String createtime;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.Long creatorindex;
    private java.lang.Long weight;
    private java.lang.Long schoolindex;
    private java.lang.Long attendindex;
    private java.lang.String bbsicon;
    private java.lang.Long attendcount;
    private java.lang.Long studentindex;
    private java.lang.Long caclecount;

    public java.lang.Long getBbsindex()
    {
        return bbsindex;
    }

    public void setBbsindex(java.lang.Long bbsindex)
    {
        this.bbsindex = bbsindex;
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

    public java.lang.Long getCreatorindex()
    {
        return creatorindex;
    }

    public void setCreatorindex(java.lang.Long creatorindex)
    {
        this.creatorindex = creatorindex;
    }

    public java.lang.Long getWeight()
    {
        return weight;
    }

    public void setWeight(java.lang.Long weight)
    {
        this.weight = weight;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.Long getAttendindex()
    {
        return attendindex;
    }

    public void setAttendindex(java.lang.Long attendindex)
    {
        this.attendindex = attendindex;
    }

    public java.lang.String getBbsicon()
    {
        return bbsicon;
    }

    public void setBbsicon(java.lang.String bbsicon)
    {
        this.bbsicon = bbsicon;
    }

    public java.lang.Long getAttendcount()
    {
        return attendcount;
    }

    public void setAttendcount(java.lang.Long attendcount)
    {
        this.attendcount = attendcount;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.Long getCaclecount()
    {
        return caclecount;
    }

    public void setCaclecount(java.lang.Long caclecount)
    {
        this.caclecount = caclecount;
    }

    public void initRelation()
    {
        this.addRelation("bbsindex", "bbsindex");
        this.addRelation("bbstitle", "bbstitle");
        this.addRelation("bbsbref", "bbsbref");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("creatorindex", "creatorindex");
        this.addRelation("weight", "weight");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("attendindex", "attendindex");
        this.addRelation("bbsicon", "bbsicon");
        this.addRelation("attendcount", "attendcount");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("caclecount", "caclecount");
    }
}
