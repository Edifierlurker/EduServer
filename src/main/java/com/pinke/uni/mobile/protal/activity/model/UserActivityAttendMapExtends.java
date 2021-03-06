package com.pinke.uni.mobile.protal.activity.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserActivityAttendMapExtends extends DynamicBaseObject implements Serializable
{

    private java.lang.Long attendindex;
    private java.lang.Long activityindex;
    private java.lang.Long studentindex;
    private java.lang.Integer status;
    private java.lang.Integer comments;
    /**
     * 参与者
     */
    private java.lang.String attendUserName;
    private java.lang.String attendUserHeadPic;

    public java.lang.Long getAttendindex()
    {
        return attendindex;
    }

    public void setAttendindex(java.lang.Long attendindex)
    {
        this.attendindex = attendindex;
    }

    public java.lang.Long getActivityindex()
    {
        return activityindex;
    }

    public void setActivityindex(java.lang.Long activityindex)
    {
        this.activityindex = activityindex;
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

    public java.lang.String getAttendUserName()
    {
        return attendUserName;
    }

    public void setAttendUserName(java.lang.String attendUserName)
    {
        this.attendUserName = attendUserName;
    }

    public java.lang.String getAttendUserHeadPic()
    {
        return attendUserHeadPic;
    }

    public void setAttendUserHeadPic(java.lang.String attendUserHeadPic)
    {
        this.attendUserHeadPic = attendUserHeadPic;
    }

    public java.lang.Integer getComments()
    {
        return comments;
    }

    public void setComments(java.lang.Integer comments)
    {
        this.comments = comments;
    }

    public void initRelation()
    {
        this.addRelation("attendindex", "attendindex");
        this.addRelation("activityindex", "activityindex");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("status", "status");
        this.addRelation("comments", "comments");
        this.addRelation("attendUserName", "attendUserName");
        this.addRelation("attendUserHeadPic", "attendUserHeadPic");
    }
}
