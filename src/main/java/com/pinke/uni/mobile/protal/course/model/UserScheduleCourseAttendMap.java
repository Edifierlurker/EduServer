package com.pinke.uni.mobile.protal.course.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserScheduleCourseAttendMap extends DynamicBaseObject implements Serializable
{

    private java.lang.Long courseattendindex;
    private java.lang.Long courseindex;
    private java.lang.Long attendindex;
    private java.lang.Integer status;
    private java.lang.String comments;
    private java.lang.String coursestarttime;
    private java.lang.String courseendtime;

    public java.lang.Long getCourseattendindex()
    {
        return courseattendindex;
    }

    public void setCourseattendindex(java.lang.Long courseattendindex)
    {
        this.courseattendindex = courseattendindex;
    }

    public java.lang.Long getCourseindex()
    {
        return courseindex;
    }

    public void setCourseindex(java.lang.Long courseindex)
    {
        this.courseindex = courseindex;
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

    public java.lang.String getComments()
    {
        return comments;
    }

    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }

    public java.lang.String getCoursestarttime()
    {
        return coursestarttime;
    }

    public void setCoursestarttime(java.lang.String coursestarttime)
    {
        this.coursestarttime = coursestarttime;
    }

    public java.lang.String getCourseendtime()
    {
        return courseendtime;
    }

    public void setCourseendtime(java.lang.String courseendtime)
    {
        this.courseendtime = courseendtime;
    }

    public void initRelation()
    {
        this.addRelation("courseattendindex", "courseattendindex");
        this.addRelation("courseindex", "courseindex");
        this.addRelation("attendindex", "attendindex");
        this.addRelation("status", "status");
        this.addRelation("comments", "comments");
        this.addRelation("coursestarttime", "coursestarttime");
        this.addRelation("courseendtime", "courseendtime");
    }
}
