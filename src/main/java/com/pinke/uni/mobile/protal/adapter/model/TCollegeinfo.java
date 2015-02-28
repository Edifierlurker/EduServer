package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TCollegeinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long collegeindex;
    private java.lang.String collegename;
    private java.lang.Integer status;
    private java.lang.String createtime;
    private java.lang.String canceltime;
    private java.lang.Integer level;
    private java.lang.Long uperindex;

    public java.lang.Long getCollegeindex()
    {
        return collegeindex;
    }

    public void setCollegeindex(java.lang.Long collegeindex)
    {
        this.collegeindex = collegeindex;
    }

    public java.lang.String getCollegename()
    {
        return collegename;
    }

    public void setCollegename(java.lang.String collegename)
    {
        this.collegename = collegename;
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

    public java.lang.String getCanceltime()
    {
        return canceltime;
    }

    public void setCanceltime(java.lang.String canceltime)
    {
        this.canceltime = canceltime;
    }

    public java.lang.Integer getLevel()
    {
        return level;
    }

    public void setLevel(java.lang.Integer level)
    {
        this.level = level;
    }

    public java.lang.Long getUperindex()
    {
        return uperindex;
    }

    public void setUperindex(java.lang.Long uperindex)
    {
        this.uperindex = uperindex;
    }

    public void initRelation()
    {
        this.addRelation("collegeindex", "collegeindex");
        this.addRelation("collegename", "collegename");
        this.addRelation("status", "status");
        this.addRelation("createtime", "createtime");
        this.addRelation("canceltime", "canceltime");
        this.addRelation("level", "level");
        this.addRelation("uperindex", "uperindex");
    }
}
