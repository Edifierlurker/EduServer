package com.pinke.uni.mobile.protal.schedule.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserSchedule extends DynamicBaseObject implements Serializable
{

    private java.lang.Long scheduleindex;
    private java.lang.String schedulename;
    private java.lang.Long studentindex;
    private java.lang.Integer status;
    private java.lang.Integer scheduletype;
    private java.lang.String scheduletitle;
    private java.lang.Long detailindex;
    private java.lang.String scheduledate;
    private java.lang.String starttime;
    private java.lang.String endtime;
    private java.lang.String createtime;
    private java.lang.String updatetime;
    private java.lang.String note;
    private java.lang.Integer isdelete;
    private java.lang.String scheduleweekStart;
    private java.lang.String scheduleweekEnd;

    public java.lang.Long getScheduleindex()
    {
        return scheduleindex;
    }

    public void setScheduleindex(java.lang.Long scheduleindex)
    {
        this.scheduleindex = scheduleindex;
    }

    public java.lang.String getSchedulename()
    {
        return schedulename;
    }

    public void setSchedulename(java.lang.String schedulename)
    {
        this.schedulename = schedulename;
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

    public java.lang.Integer getScheduletype()
    {
        return scheduletype;
    }

    public void setScheduletype(java.lang.Integer scheduletype)
    {
        this.scheduletype = scheduletype;
    }

    public java.lang.String getScheduletitle()
    {
        return scheduletitle;
    }

    public void setScheduletitle(java.lang.String scheduletitle)
    {
        this.scheduletitle = scheduletitle;
    }

    public java.lang.Long getDetailindex()
    {
        return detailindex;
    }

    public void setDetailindex(java.lang.Long detailindex)
    {
        this.detailindex = detailindex;
    }

    public java.lang.String getScheduledate()
    {
        return scheduledate;
    }

    public void setScheduledate(java.lang.String scheduledate)
    {
        this.scheduledate = scheduledate;
    }

    public java.lang.String getStarttime()
    {
        return starttime;
    }

    public void setStarttime(java.lang.String starttime)
    {
        this.starttime = starttime;
    }

    public java.lang.String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(java.lang.String endtime)
    {
        this.endtime = endtime;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(java.lang.String updatetime)
    {
        this.updatetime = updatetime;
    }

    public java.lang.String getNote()
    {
        return note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    public java.lang.Integer getIsdelete()
    {
        return isdelete;
    }

    public void setIsdelete(java.lang.Integer isdelete)
    {
        this.isdelete = isdelete;
    }

    public java.lang.String getScheduleweekStart()
    {
        return scheduleweekStart;
    }

    public void setScheduleweekStart(java.lang.String scheduleweekStart)
    {
        this.scheduleweekStart = scheduleweekStart;
    }

    public java.lang.String getScheduleweekEnd()
    {
        return scheduleweekEnd;
    }

    public void setScheduleweekEnd(java.lang.String scheduleweekEnd)
    {
        this.scheduleweekEnd = scheduleweekEnd;
    }

    public void initRelation()
    {
        this.addRelation("scheduleindex", "scheduleindex");
        this.addRelation("schedulename", "schedulename");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("status", "status");
        this.addRelation("scheduletype", "scheduletype");
        this.addRelation("scheduletitle", "scheduletitle");
        this.addRelation("detailindex", "detailindex");
        this.addRelation("scheduledate", "scheduledate");
        this.addRelation("starttime", "starttime");
        this.addRelation("endtime", "endtime");
        this.addRelation("createtime", "createtime");
        this.addRelation("updatetime", "updatetime");
        this.addRelation("note", "note");
        this.addRelation("scheduleweekStart", "scheduleweekStart");
        this.addRelation("scheduleweekEnd", "scheduleweekEnd");
    }
}
