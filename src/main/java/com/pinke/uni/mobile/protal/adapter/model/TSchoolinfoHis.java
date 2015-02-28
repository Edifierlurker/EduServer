package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TSchoolinfoHis extends DynamicBaseObject implements Serializable
{

    private java.lang.Long mapindex;
    private java.lang.Long schoolindex;
    private java.lang.Integer sections;
    private java.lang.String sectionstarttime;
    private java.lang.String sectionendtime;
    private java.lang.Integer status;

    public java.lang.Long getMapindex()
    {
        return mapindex;
    }

    public void setMapindex(java.lang.Long mapindex)
    {
        this.mapindex = mapindex;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }


    public java.lang.String getSectionstarttime()
    {
        return sectionstarttime;
    }

    public void setSectionstarttime(java.lang.String sectionstarttime)
    {
        this.sectionstarttime = sectionstarttime;
    }

    public java.lang.String getSectionendtime()
    {
        return sectionendtime;
    }

    public void setSectionendtime(java.lang.String sectionendtime)
    {
        this.sectionendtime = sectionendtime;
    }



    public java.lang.Integer getSections()
    {
        return sections;
    }

    public void setSections(java.lang.Integer sections)
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

    public void initRelation()
    {
        this.addRelation("mapindex", "mapindex");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("sections", "sections");
        this.addRelation("sectionstarttime", "sectionstarttime");
        this.addRelation("sectionendtime", "sectionendtime");
        this.addRelation("status", "status");
    }
}
