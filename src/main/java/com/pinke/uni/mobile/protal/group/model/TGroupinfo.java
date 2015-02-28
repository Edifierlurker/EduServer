package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long groupindex;
    private java.lang.Long groupid;
    private java.lang.Long grouplevel;
    private java.lang.String groupmessage;
    private java.lang.String grouppic;
    private java.lang.String grouptitle;
    private java.lang.String groupbref;
    private java.lang.String groupdesc;
    private java.lang.String createtime;
    private java.lang.String site;
    private java.lang.String longitude;
    private java.lang.String latitude;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.Long categorylevel1;
    private java.lang.Long categorylevel2;
    private java.lang.Long groupmanagerindex;
    private java.lang.Long groupcreaterindex;
    private java.lang.Integer grouppoints;
    private java.lang.String groupcomment;
    private java.lang.Integer groupstars;
    private java.lang.Integer grouptype;
    private java.lang.Long DISTANCE;
    private java.lang.String searchcond;

    public java.lang.Long getGroupindex()
    {
        return groupindex;
    }

    public void setGroupindex(java.lang.Long groupindex)
    {
        this.groupindex = groupindex;
    }

    public java.lang.Long getGroupid()
    {
        return groupid;
    }

    public void setGroupid(java.lang.Long groupid)
    {
        this.groupid = groupid;
    }

    public java.lang.Long getGrouplevel()
    {
        return grouplevel;
    }

    public void setGrouplevel(java.lang.Long grouplevel)
    {
        this.grouplevel = grouplevel;
    }

    public java.lang.String getGroupmessage()
    {
        return groupmessage;
    }

    public void setGroupmessage(java.lang.String groupmessage)
    {
        this.groupmessage = groupmessage;
    }

    public java.lang.String getGrouppic()
    {
        return grouppic;
    }

    public void setGrouppic(java.lang.String grouppic)
    {
        this.grouppic = grouppic;
    }

    public java.lang.String getGrouptitle()
    {
        return grouptitle;
    }

    public void setGrouptitle(java.lang.String grouptitle)
    {
        this.grouptitle = grouptitle;
    }

    public java.lang.String getGroupbref()
    {
        return groupbref;
    }

    public void setGroupbref(java.lang.String groupbref)
    {
        this.groupbref = groupbref;
    }

    public java.lang.String getGroupdesc()
    {
        return groupdesc;
    }

    public void setGroupdesc(java.lang.String groupdesc)
    {
        this.groupdesc = groupdesc;
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

    public java.lang.String getNote()
    {
        return note;
    }

    public void setNote(java.lang.String note)
    {
        this.note = note;
    }

    public java.lang.Long getCategorylevel1()
    {
        return categorylevel1;
    }

    public void setCategorylevel1(java.lang.Long categorylevel1)
    {
        this.categorylevel1 = categorylevel1;
    }

    public java.lang.Long getCategorylevel2()
    {
        return categorylevel2;
    }

    public void setCategorylevel2(java.lang.Long categorylevel2)
    {
        this.categorylevel2 = categorylevel2;
    }

    public java.lang.Long getGroupmanagerindex()
    {
        return groupmanagerindex;
    }

    public void setGroupmanagerindex(java.lang.Long groupmanagerindex)
    {
        this.groupmanagerindex = groupmanagerindex;
    }

    public java.lang.Long getGroupcreaterindex()
    {
        return groupcreaterindex;
    }

    public void setGroupcreaterindex(java.lang.Long groupcreaterindex)
    {
        this.groupcreaterindex = groupcreaterindex;
    }

    public java.lang.Integer getGrouppoints()
    {
        return grouppoints;
    }

    public void setGrouppoints(java.lang.Integer grouppoints)
    {
        this.grouppoints = grouppoints;
    }

    public java.lang.String getGroupcomment()
    {
        return groupcomment;
    }

    public void setGroupcomment(java.lang.String groupcomment)
    {
        this.groupcomment = groupcomment;
    }

    public java.lang.Integer getGroupstars()
    {
        return groupstars;
    }

    public void setGroupstars(java.lang.Integer groupstars)
    {
        this.groupstars = groupstars;
    }

    public java.lang.Integer getGrouptype()
    {
        return grouptype;
    }

    public void setGrouptype(java.lang.Integer grouptype)
    {
        this.grouptype = grouptype;
    }

    public java.lang.Long getDISTANCE()
    {
        return DISTANCE;
    }

    public void setDISTANCE(java.lang.Long dISTANCE)
    {
        DISTANCE = dISTANCE;
    }

    public java.lang.String getSearchcond()
    {
        return searchcond;
    }

    public void setSearchcond(java.lang.String searchcond)
    {
        this.searchcond = searchcond;
    }

    public void initRelation()
    {
        this.addRelation("groupindex", "groupindex");
        this.addRelation("groupid", "groupid");
        this.addRelation("grouplevel", "grouplevel");
        this.addRelation("groupmessage", "groupmessage");
        this.addRelation("grouppic", "grouppic");
        this.addRelation("grouptitle", "grouptitle");
        this.addRelation("groupbref", "groupbref");
        this.addRelation("groupdesc", "groupdesc");
        this.addRelation("createtime", "createtime");
        this.addRelation("site", "site");
        this.addRelation("longitude", "longitude");
        this.addRelation("latitude", "latitude");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("categorylevel1", "categorylevel1");
        this.addRelation("categorylevel2", "categorylevel2");
        this.addRelation("groupmanagerindex", "groupmanagerindex");
        this.addRelation("groupcreaterindex", "groupcreaterindex");
        this.addRelation("grouppoints", "grouppoints");
        this.addRelation("groupcomment", "groupcomment");
        this.addRelation("groupstars", "groupstars");
        this.addRelation("grouptype", "grouptype");
        this.addRelation("DISTANCE", "DISTANCE");
        this.addRelation("searchcond", "searchcond");
    }
}
