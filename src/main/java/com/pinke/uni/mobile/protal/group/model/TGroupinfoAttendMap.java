package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupinfoAttendMap extends DynamicBaseObject implements Serializable
{

    private java.lang.Long mapindex;
    private java.lang.Long groupindex;
    private java.lang.Long attendindex;
    private java.lang.Integer status;
    private java.lang.String attendtime;
    private java.lang.String applytime;
    private java.lang.String note;
    private java.lang.String studentname;
    private java.lang.String headpic;
    private java.lang.String userphone;
    private java.lang.String studentid;
    private java.lang.String grpnickname;

    private java.lang.String grouptitle;
    private java.lang.String site;
    private java.lang.String groupbref;
    private java.lang.String grouppic;
    private java.lang.Long groupid;
    private java.lang.Long grouptype;
    private java.lang.Long groupmanagerindex;

    public java.lang.Long getMapindex()
    {
        return mapindex;
    }

    public void setMapindex(java.lang.Long mapindex)
    {
        this.mapindex = mapindex;
    }

    public java.lang.Long getGroupindex()
    {
        return groupindex;
    }

    public void setGroupindex(java.lang.Long groupindex)
    {
        this.groupindex = groupindex;
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

    public java.lang.String getAttendtime()
    {
        return attendtime;
    }

    public void setAttendtime(java.lang.String attendtime)
    {
        this.attendtime = attendtime;
    }

    public java.lang.String getApplytime()
    {
        return applytime;
    }

    public void setApplytime(java.lang.String applytime)
    {
        this.applytime = applytime;
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

    public java.lang.String getHeadpic()
    {
        return headpic;
    }

    public void setHeadpic(java.lang.String headpic)
    {
        this.headpic = headpic;
    }

    public java.lang.String getUserphone()
    {
        return userphone;
    }

    public void setUserphone(java.lang.String userphone)
    {
        this.userphone = userphone;
    }

    public java.lang.String getStudentid()
    {
        return studentid;
    }

    public void setStudentid(java.lang.String studentid)
    {
        this.studentid = studentid;
    }

    public java.lang.String getGrouptitle()
    {
        return grouptitle;
    }

    public void setGrouptitle(java.lang.String grouptitle)
    {
        this.grouptitle = grouptitle;
    }

    public java.lang.String getSite()
    {
        return site;
    }

    public void setSite(java.lang.String site)
    {
        this.site = site;
    }

    public java.lang.String getGroupbref()
    {
        return groupbref;
    }

    public void setGroupbref(java.lang.String groupbref)
    {
        this.groupbref = groupbref;
    }

    public java.lang.String getGrouppic()
    {
        return grouppic;
    }

    public void setGrouppic(java.lang.String grouppic)
    {
        this.grouppic = grouppic;
    }

    public java.lang.Long getGroupid()
    {
        return groupid;
    }

    public void setGroupid(java.lang.Long groupid)
    {
        this.groupid = groupid;
    }

    public java.lang.String getGrpnickname()
    {
        return grpnickname;
    }

    public void setGrpnickname(java.lang.String grpnickname)
    {
        this.grpnickname = grpnickname;
    }

    public java.lang.Long getGrouptype()
    {
        return grouptype;
    }

    public void setGrouptype(java.lang.Long grouptype)
    {
        this.grouptype = grouptype;
    }

    public java.lang.Long getGroupmanagerindex()
    {
        return groupmanagerindex;
    }

    public void setGroupmanagerindex(java.lang.Long groupmanagerindex)
    {
        this.groupmanagerindex = groupmanagerindex;
    }

    public void initRelation()
    {
        this.addRelation("mapindex", "mapindex");
        this.addRelation("groupindex", "groupindex");
        this.addRelation("attendindex", "attendindex");
        this.addRelation("status", "status");
        this.addRelation("attendtime", "attendtime");
        this.addRelation("applytime", "applytime");
        this.addRelation("note", "note");
        this.addRelation("studentname", "studentname");
        this.addRelation("headpic", "headpic");
        this.addRelation("userphone", "userphone");
        this.addRelation("studentid", "studentid");
        this.addRelation("grpnickname", "grpnickname");
        this.addRelation("groupbref", "groupbref");
        this.addRelation("site", "site");
        this.addRelation("grouptitle", "grouptitle");
        this.addRelation("grouppic", "grouppic");
        this.addRelation("groupid", "groupid");
        this.addRelation("grouptype", "grouptype");
        this.addRelation("groupmanagerindex", "groupmanagerindex");
    }
}
