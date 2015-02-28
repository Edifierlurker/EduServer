package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;
import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TFriendinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long mapindex;
    private java.lang.Long userindex;
    private java.lang.Long friendindex;
    private java.lang.Integer status;
    private java.lang.String userphone;
    private java.lang.String studentname;
    private java.lang.String studentid;
    private java.lang.String headpic;
    private java.lang.String remark;

    public java.lang.Long getMapindex()
    {
        return mapindex;
    }

    public void setMapindex(java.lang.Long mapindex)
    {
        this.mapindex = mapindex;
    }

    public java.lang.Long getUserindex()
    {
        return userindex;
    }

    public void setUserindex(java.lang.Long userindex)
    {
        this.userindex = userindex;
    }

    public java.lang.Long getFriendindex()
    {
        return friendindex;
    }

    public void setFriendindex(java.lang.Long friendindex)
    {
        this.friendindex = friendindex;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getUserphone()
    {
        return userphone;
    }

    public void setUserphone(java.lang.String userphone)
    {
        this.userphone = userphone;
    }

    public java.lang.String getStudentname()
    {
        return studentname;
    }

    public void setStudentname(java.lang.String studentname)
    {
        this.studentname = studentname;
    }

    public java.lang.String getStudentid()
    {
        return studentid;
    }

    public void setStudentid(java.lang.String studentid)
    {
        this.studentid = studentid;
    }

    public java.lang.String getHeadpic()
    {
        return headpic;
    }

    public void setHeadpic(java.lang.String headpic)
    {
        this.headpic = headpic;
    }

    public java.lang.String getRemark()
    {
        return remark;
    }

    public void setRemark(java.lang.String remark)
    {
        this.remark = remark;
    }

    public void initRelation()
    {
        this.addRelation("mapindex", "mapindex");
        this.addRelation("userindex", "userindex");
        this.addRelation("friendindex", "friendindex");
        this.addRelation("status", "status");
        this.addRelation("remark", "remark");
        
        this.addRelation("userphone", "userphone");
        this.addRelation("studentname", "studentname");
        this.addRelation("studentid", "studentid");
        this.addRelation("headpic", "headpic");
    }
}
