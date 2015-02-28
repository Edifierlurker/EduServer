package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupinfoBulletin extends DynamicBaseObject implements Serializable
{

    private java.lang.Long bulletinidnex;
    private java.lang.Long groupindex;
    private java.lang.String bulletintitle;
    private java.lang.String bulletindesc;
    private java.lang.Long studentindex;
    private java.lang.String createtime;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.String studentname;

    public java.lang.Long getBulletinidnex()
    {
        return bulletinidnex;
    }

    public void setBulletinidnex(java.lang.Long bulletinidnex)
    {
        this.bulletinidnex = bulletinidnex;
    }

    public java.lang.Long getGroupindex()
    {
        return groupindex;
    }

    public void setGroupindex(java.lang.Long groupindex)
    {
        this.groupindex = groupindex;
    }

    public java.lang.String getBulletintitle()
    {
        return bulletintitle;
    }

    public void setBulletintitle(java.lang.String bulletintitle)
    {
        this.bulletintitle = bulletintitle;
    }

    public java.lang.String getBulletindesc()
    {
        return bulletindesc;
    }

    public void setBulletindesc(java.lang.String bulletindesc)
    {
        this.bulletindesc = bulletindesc;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
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

    public java.lang.String getStudentname()
    {
        return studentname;
    }

    public void setStudentname(java.lang.String studentname)
    {
        this.studentname = studentname;
    }

    public void initRelation()
    {
        this.addRelation("bulletinidnex", "bulletinidnex");
        this.addRelation("groupindex", "groupindex");
        this.addRelation("bulletintitle", "bulletintitle");
        this.addRelation("bulletindesc", "bulletindesc");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("studentname", "studentname");
    }
}
