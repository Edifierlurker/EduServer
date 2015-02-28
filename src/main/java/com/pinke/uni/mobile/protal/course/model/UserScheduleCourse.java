package com.pinke.uni.mobile.protal.course.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserScheduleCourse extends DynamicBaseObject implements Serializable
{

    private java.lang.Long courseindex;
    private java.lang.Long importcourseindex;
    private java.lang.Long studentindex;
    private java.lang.String coursename;
    private java.lang.Long teacherindex;
    private java.lang.String teachername;
    private java.lang.Long roomindex;
    private java.lang.String roomname;
    private java.lang.String description;
    private java.lang.Long schoolindex;
    private java.lang.String note;
    private java.lang.Integer coursetype;
    private java.lang.Integer weekdays;
    private java.lang.String weeks;
    private java.lang.String sections;
    private java.lang.Integer status;
    private java.lang.String courseStartTime;
    private java.lang.String courseEndTime;
    private java.lang.Long attendindex;
    private java.lang.Long userindex;

    public java.lang.Long getCourseindex()
    {
        return courseindex;
    }

    public void setCourseindex(java.lang.Long courseindex)
    {
        this.courseindex = courseindex;
    }

    public java.lang.Long getImportcourseindex()
    {
        return importcourseindex;
    }

    public void setImportcourseindex(java.lang.Long importcourseindex)
    {
        this.importcourseindex = importcourseindex;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(java.lang.String coursename)
    {
        this.coursename = coursename;
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

    public java.lang.Long getRoomindex()
    {
        return roomindex;
    }

    public void setRoomindex(java.lang.Long roomindex)
    {
        this.roomindex = roomindex;
    }

    public java.lang.String getRoomname()
    {
        return roomname;
    }

    public void setRoomname(java.lang.String roomname)
    {
        this.roomname = roomname;
    }

    public java.lang.String getDescription()
    {
        return description;
    }

    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.String getNote()
    {
        return note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    public java.lang.Integer getCoursetype()
    {
        return coursetype;
    }

    public void setCoursetype(java.lang.Integer coursetype)
    {
        this.coursetype = coursetype;
    }

    public java.lang.Integer getWeekdays()
    {
        return weekdays;
    }

    public void setWeekdays(java.lang.Integer weekdays)
    {
        this.weekdays = weekdays;
    }

    public java.lang.String getWeeks()
    {
        return weeks;
    }

    public void setWeeks(java.lang.String weeks)
    {
        this.weeks = weeks;
    }

    public java.lang.String getSections()
    {
        return sections;
    }

    public void setSections(java.lang.String sections)
    {
        this.sections = sections;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getCourseStartTime()
    {
        return courseStartTime;
    }

    public void setCourseStartTime(java.lang.String courseStartTime)
    {
        this.courseStartTime = courseStartTime;
    }

    public java.lang.String getCourseEndTime()
    {
        return courseEndTime;
    }

    public void setCourseEndTime(java.lang.String courseEndTime)
    {
        this.courseEndTime = courseEndTime;
    }

    public java.lang.Long getAttendindex()
    {
        return attendindex;
    }

    public void setAttendindex(java.lang.Long attendindex)
    {
        this.attendindex = attendindex;
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
        this.addRelation("courseindex", "courseindex");
        this.addRelation("importcourseindex", "importcourseindex");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("coursename", "coursename");
        this.addRelation("teacherindex", "teacherindex");
        this.addRelation("teachername", "teachername");
        this.addRelation("roomindex", "roomindex");
        this.addRelation("roomname", "roomname");
        this.addRelation("description", "description");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("note", "note");
        this.addRelation("coursetype", "coursetype");
        this.addRelation("weekdays", "weekdays");
        this.addRelation("weeks", "weeks");
        this.addRelation("sections", "sections");
        this.addRelation("status", "status");
        this.addRelation("courseStartTime", "courseStartTime");
        this.addRelation("courseEndTime", "courseEndTime");
        this.addRelation("attendindex", "attendindex");
        this.addRelation("userindex", "userindex");
    }
}
