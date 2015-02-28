  
package com.pinke.uni.mobile.protal.personal.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserSchedulePrivate extends DynamicBaseObject implements Serializable
{

    private java.lang.Long privateindex;
    private java.lang.String title;
    private java.lang.Long studentindex;
    private java.lang.String longitude;
    private java.lang.String latitude;
    private java.lang.String content;
    private java.lang.String site;
    private java.lang.String inventer;
    private java.lang.Integer status;
    private java.lang.String starttime;
    private java.lang.String endtime;
    private java.lang.String createtime;
    private java.lang.String updatetime;
    private java.lang.String note;

    public java.lang.String getTitle()
    {
        return title;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    public java.lang.Long getPrivateindex()
    {
        return privateindex;
    }

    public void setPrivateindex(java.lang.Long privateindex)
    {
        this.privateindex = privateindex;
    }

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
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

    public java.lang.String getContent()
    {
        return content;
    }

    public void setContent(java.lang.String content)
    {
        this.content = content;
    }

    public java.lang.String getSite()
    {
        return site;
    }

    public void setSite(java.lang.String site)
    {
        this.site = site;
    }

    public java.lang.String getInventer()
    {
        return inventer;
    }

    public void setInventer(java.lang.String inventer)
    {
        this.inventer = inventer;
    }



    public java.lang.Integer getStatus()
    {
        return status;
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

    public void initRelation()
    {
        this.addRelation("privateindex", "privateindex");
        this.addRelation("title", "title");
        this.addRelation("studentindex", "studentindex");
        this.addRelation("longitude", "longitude");
        this.addRelation("latitude", "latitude");
        this.addRelation("content", "content");
        this.addRelation("site", "site");
        this.addRelation("inventer", "inventer");
        this.addRelation("status", "status");
        this.addRelation("starttime", "starttime");
        this.addRelation("endtime", "endtime");
        this.addRelation("createtime", "createtime");
        this.addRelation("updatetime", "updatetime");
        this.addRelation("note", "note");
    }
}
