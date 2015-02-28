package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TMajorinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long majorindex;
    private java.lang.String majorname;
    private java.lang.Long schoolindex;
    private java.lang.Long collegeindex;

    public java.lang.Long getMajorindex()
    {
        return majorindex;
    }

    public void setMajorindex(java.lang.Long majorindex)
    {
        this.majorindex = majorindex;
    }

    public java.lang.String getMajorname()
    {
        return majorname;
    }

    public void setMajorname(java.lang.String majorname)
    {
        this.majorname = majorname;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.Long getCollegeindex()
    {
        return collegeindex;
    }

    public void setCollegeindex(java.lang.Long collegeindex)
    {
        this.collegeindex = collegeindex;
    }

    public void initRelation()
    {
        this.addRelation("majorindex", "majorindex");
        this.addRelation("majorname", "majorname");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("collegeindex", "collegeindex");
    }
}
