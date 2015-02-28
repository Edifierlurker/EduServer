package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;
import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TNearStudent extends DynamicBaseObject implements Serializable
{

    private java.lang.Long studentindex;
    private java.lang.String createtime;
    private java.lang.String site;
    private java.lang.String longitude;
    private java.lang.String latitude;
    private java.lang.Integer status;
    private java.lang.Integer gender;
    private java.lang.String headpic;
    private java.lang.String studentname;
    private java.lang.String signature;
    private java.lang.String DISTANCE;
    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.String getSite()
    {
        return site;
    }

    public void setSite(java.lang.String site)
    {
        this.site = site;
    }

    public java.lang.String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(java.lang.String longitude)
    {
        this.longitude = longitude;
    }

    public java.lang.String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(java.lang.String latitude)
    {
        this.latitude = latitude;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.Integer getGender()
    {
        return gender;
    }

    public void setGender(java.lang.Integer gender)
    {
        this.gender = gender;
    }

    public java.lang.String getHeadpic()
    {
        return headpic;
    }

    public void setHeadpic(java.lang.String headpic)
    {
        this.headpic = headpic;
    }

    public java.lang.String getStudentname()
    {
        return studentname;
    }

    public void setStudentname(java.lang.String studentname)
    {
        this.studentname = studentname;
    }

    public java.lang.String getSignature()
    {
        return signature;
    }

    public void setSignature(java.lang.String signature)
    {
        this.signature = signature;
    }

    public java.lang.String getDISTANCE()
    {
        return DISTANCE;
    }

    public void setDISTANCE(java.lang.String dISTANCE)
    {
        DISTANCE = dISTANCE;
    }

    public void initRelation()
    {
        this.addRelation("studentindex", "studentindex");
        this.addRelation("createtime", "createtime");
        this.addRelation("site", "site");
        this.addRelation("longitude", "longitude");
        this.addRelation("latitude", "latitude");
        this.addRelation("status", "status");
        this.addRelation("gender", "gender");
        this.addRelation("headpic", "headpic");
        this.addRelation("studentname", "studentname");
        this.addRelation("signature", "signature");
        this.addRelation("DISTANCE", "DISTANCE");

    }
}
