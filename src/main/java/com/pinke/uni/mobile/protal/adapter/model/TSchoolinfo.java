package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TSchoolinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long schoolindex;
    private java.lang.String schoolname;
    private java.lang.Integer schoolstatus;
    private java.lang.String registertime;
    private java.lang.String canceltime;
    private java.lang.Integer schooltype;
    private java.lang.Integer weeks;
    private java.lang.String weekbegin;
    private java.lang.Integer sections;

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.String getSchoolname()
    {
        return schoolname;
    }

    public void setSchoolname(java.lang.String schoolname)
    {
        this.schoolname = schoolname;
    }

    public java.lang.Integer getSchoolstatus()
    {
        return schoolstatus;
    }

    public void setSchoolstatus(java.lang.Integer schoolstatus)
    {
        this.schoolstatus = schoolstatus;
    }

    public java.lang.String getRegistertime()
    {
        return registertime;
    }

    public void setRegistertime(java.lang.String registertime)
    {
        this.registertime = registertime;
    }

    public java.lang.String getCanceltime()
    {
        return canceltime;
    }

    public void setCanceltime(java.lang.String canceltime)
    {
        this.canceltime = canceltime;
    }

    public java.lang.Integer getSchooltype()
    {
        return schooltype;
    }

    public void setSchooltype(java.lang.Integer schooltype)
    {
        this.schooltype = schooltype;
    }

    public java.lang.Integer getWeeks()
    {
        return weeks;
    }

    public void setWeeks(java.lang.Integer weeks)
    {
        this.weeks = weeks;
    }

    public java.lang.String getWeekbegin()
    {
        return weekbegin;
    }

    public void setWeekbegin(java.lang.String weekbegin)
    {
        this.weekbegin = weekbegin;
    }

    public java.lang.Integer getSections()
    {
        return sections;
    }

    public void setSections(java.lang.Integer sections)
    {
        this.sections = sections;
    }

    public void initRelation()
    {
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("schoolname", "schoolname");
        this.addRelation("schoolstatus", "schoolstatus");
        this.addRelation("registertime", "registertime");
        this.addRelation("canceltime", "canceltime");
        this.addRelation("schooltype", "schooltype");
        this.addRelation("weeks", "weeks");
        this.addRelation("weekbegin", "weekbegin");
        this.addRelation("sections", "sections");
    }
}
