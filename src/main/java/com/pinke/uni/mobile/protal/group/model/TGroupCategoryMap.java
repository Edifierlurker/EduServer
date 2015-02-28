package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupCategoryMap extends DynamicBaseObject implements Serializable
{

    private java.lang.Long mapindex;
    private java.lang.Long categoryindex;
    private java.lang.Long groupindex;
    private java.lang.Integer weight;
    private java.lang.Integer status;
    private java.lang.String grouptitle;
    private java.lang.String grouppic;
    private java.lang.String grouppbref;
    private java.lang.String  site;

    public java.lang.Long getMapindex()
    {
        return mapindex;
    }

    public void setMapindex(java.lang.Long mapindex)
    {
        this.mapindex = mapindex;
    }

    public java.lang.Long getCategoryindex()
    {
        return categoryindex;
    }

    public void setCategoryindex(java.lang.Long categoryindex)
    {
        this.categoryindex = categoryindex;
    }

    public java.lang.Long getGroupindex()
    {
        return groupindex;
    }

    public void setGroupindex(java.lang.Long groupindex)
    {
        this.groupindex = groupindex;
    }

    public java.lang.Integer getWeight()
    {
        return weight;
    }

    public void setWeight(java.lang.Integer weight)
    {
        this.weight = weight;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getGrouptitle()
    {
        return grouptitle;
    }

    public void setGrouptitle(java.lang.String grouptitle)
    {
        this.grouptitle = grouptitle;
    }

    public java.lang.String getGrouppic()
    {
        return grouppic;
    }

    public void setGrouppic(java.lang.String grouppic)
    {
        this.grouppic = grouppic;
    }

    public java.lang.String getGrouppbref()
    {
        return grouppbref;
    }

    public void setGrouppbref(java.lang.String grouppbref)
    {
        this.grouppbref = grouppbref;
    }

    public java.lang.String getSite()
    {
        return site;
    }

    public void setSite(java.lang.String site)
    {
        this.site = site;
    }

    public void initRelation()
    {
        this.addRelation("mapindex", "mapindex");
        this.addRelation("categoryindex", "categoryindex");
        this.addRelation("groupindex", "groupindex");
        this.addRelation("weight", "weight");
        this.addRelation("status", "status");
        this.addRelation("grouppic", "grouppic");
        this.addRelation("grouppbref", "grouppbref");
        this.addRelation("grouptitle", "grouptitle");
        this.addRelation("site", "site");
    }
}
