package com.pinke.uni.mobile.protal.exam.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserScheduleExaminfoExtends extends DynamicBaseObject implements Serializable
{

    private java.lang.Long examindex;
    private java.lang.Long importexamindex;
    private java.lang.Long studentindex;
    private java.lang.String examname;
    private java.lang.Long courseindex;
    private java.lang.Long teacherindex;
    private java.lang.Long moniteachindex;
    private java.lang.String examdate;
    private java.lang.String examstarttime;
    private java.lang.String examendtime;
    private java.lang.String site;
    private java.lang.Integer status;
    private java.lang.Integer openexam;
    private java.lang.String description;
    private java.lang.String note;
    private java.lang.Integer examtype;
    private java.lang.String teachername;
    private java.lang.String moniteachername;
    private java.lang.String coursename;
    private java.lang.Long userindex;

    public java.lang.Long getExamindex()
    {
        return examindex;
    }

    public void setExamindex(java.lang.Long examindex)
    {
        this.examindex = examindex;
    }

    public java.lang.Long getImportexamindex()
    {
        return importexamindex;
    }

    public void setImportexamindex(java.lang.Long importexamindex)
    {
        this.importexamindex = importexamindex;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.String getExamname()
    {
        return examname;
    }

    public void setExamname(java.lang.String examname)
    {
        this.examname = examname;
    }

    public java.lang.Long getCourseindex()
    {
        return courseindex;
    }

    public void setCourseindex(java.lang.Long courseindex)
    {
        this.courseindex = courseindex;
    }

    public java.lang.Long getTeacherindex()
    {
        return teacherindex;
    }

    public void setTeacherindex(java.lang.Long teacherindex)
    {
        this.teacherindex = teacherindex;
    }

    public java.lang.Long getMoniteachindex()
    {
        return moniteachindex;
    }

    public void setMoniteachindex(java.lang.Long moniteachindex)
    {
        this.moniteachindex = moniteachindex;
    }

    public java.lang.String getExamdate()
    {
        return examdate;
    }

    public void setExamdate(java.lang.String examdate)
    {
        this.examdate = examdate;
    }

    public java.lang.String getExamstarttime()
    {
        return examstarttime;
    }

    public void setExamstarttime(java.lang.String examstarttime)
    {
        this.examstarttime = examstarttime;
    }

    public java.lang.String getExamendtime()
    {
        return examendtime;
    }

    public void setExamendtime(java.lang.String examendtime)
    {
        this.examendtime = examendtime;
    }

    public java.lang.String getSite()
    {
        return site;
    }

    public void setSite(java.lang.String site)
    {
        this.site = site;
    }

    public java.lang.Integer getOpenexam()
    {
        return openexam;
    }

    public void setOpenexam(java.lang.Integer openexam)
    {
        this.openexam = openexam;
    }

    public java.lang.String getDescription()
    {
        return description;
    }

    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }

    public java.lang.String getNote()
    {
        return note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.Integer getExamtype()
    {
        return examtype;
    }

    public void setExamtype(java.lang.Integer examtype)
    {
        this.examtype = examtype;
    }

    public java.lang.String getTeachername()
    {
        return teachername;
    }

    public void setTeachername(java.lang.String teachername)
    {
        this.teachername = teachername;
    }

    public java.lang.String getMoniteachername()
    {
        return moniteachername;
    }

    public void setMoniteachername(java.lang.String moniteachername)
    {
        this.moniteachername = moniteachername;
    }

    public java.lang.String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(java.lang.String coursename)
    {
        this.coursename = coursename;
    }

    public java.lang.Long getUserindex()
    {
        return userindex;
    }

    public void setUserindex(java.lang.Long userindex)
    {
        this.userindex = userindex;
    }

    public void initRelation()
    {
        this.addRelation("examindex", "examindex");
        this.addRelation("importexamindex", "importexamindex");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("examname", "examname");
        this.addRelation("courseindex", "courseindex");
        this.addRelation("teacherindex", "teacherindex");
        this.addRelation("moniteachindex", "moniteachindex");
        this.addRelation("examdate", "examdate");
        this.addRelation("examstarttime", "examstarttime");
        this.addRelation("examendtime", "examendtime");
        this.addRelation("site", "site");
        this.addRelation("status", "status");
        this.addRelation("openexam", "openexam");
        this.addRelation("description", "description");
        this.addRelation("note", "note");
        this.addRelation("examtype", "examtype");
        this.addRelation("teachername", "teachername");
        this.addRelation("moniteachername", "moniteachername");
        this.addRelation("coursename", "coursename");
        this.addRelation("userindex", "userindex");
    }
}
