package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TClassinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long classindex;
    private java.lang.String classname;
    private java.lang.Integer status;
    private java.lang.String createtime;
    private java.lang.String graduatetime;
    private java.lang.Long collegeindex;
    private java.lang.Long schoolindex;
    private java.lang.Long teacherindex;
    private java.lang.String teachername;

    public java.lang.Long getClassindex()
    {
        return classindex;
    }

    public void setClassindex(java.lang.Long classindex)
    {
        this.classindex = classindex;
    }

    public java.lang.String getClassname()
    {
        return classname;
    }

    public void setClassname(java.lang.String classname)
    {
        this.classname = classname;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.String getGraduatetime()
    {
        return graduatetime;
    }

    public void setGraduatetime(java.lang.String graduatetime)
    {
        this.graduatetime = graduatetime;
    }

    public java.lang.Long getCollegeindex()
    {
        return collegeindex;
    }

    public void setCollegeindex(java.lang.Long collegeindex)
    {
        this.collegeindex = collegeindex;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.Long getTeacherindex()
    {
        return teacherindex;
    }

    public void setTeacherindex(java.lang.Long teacherindex)
    {
        this.teacherindex = teacherindex;
    }

    public java.lang.String getTeachername()
    {
        return teachername;
    }

    public void setTeachername(java.lang.String teachername)
    {
        this.teachername = teachername;
    }

    public void initRelation()
    {
        this.addRelation("classindex", "classindex");
        this.addRelation("classname", "classname");
        this.addRelation("status", "status");
        this.addRelation("createtime", "createtime");
        this.addRelation("graduatetime", "graduatetime");
        this.addRelation("collegeindex", "collegeindex");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("teacherindex", "teacherindex");
        this.addRelation("teachername", "teachername");
    }
}
