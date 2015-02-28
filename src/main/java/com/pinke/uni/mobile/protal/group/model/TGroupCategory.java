package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupCategory extends DynamicBaseObject implements Serializable
{

    private java.lang.Long categoryindex;
    private java.lang.String categoryname;
    private java.lang.String categorypic;
    private java.lang.Integer categorylevel;
    private java.lang.Long categoryupindex;
    private java.lang.Integer weight;
    private java.lang.String createtime;
    private java.lang.Integer status;

    public java.lang.Long getCategoryindex()
    {
        return categoryindex;
    }

    public void setCategoryindex(java.lang.Long categoryindex)
    {
        this.categoryindex = categoryindex;
    }

    public java.lang.String getCategoryname()
    {
        return categoryname;
    }

    public void setCategoryname(java.lang.String categoryname)
    {
        this.categoryname = categoryname;
    }

    public java.lang.String getCategorypic()
    {
        return categorypic;
    }

    public void setCategorypic(java.lang.String categorypic)
    {
        this.categorypic = categorypic;
    }

    public java.lang.Integer getCategorylevel()
    {
        return categorylevel;
    }

    public void setCategorylevel(java.lang.Integer categorylevel)
    {
        this.categorylevel = categorylevel;
    }

    public java.lang.Long getCategoryupindex()
    {
        return categoryupindex;
    }

    public void setCategoryupindex(java.lang.Long categoryupindex)
    {
        this.categoryupindex = categoryupindex;
    }

    public java.lang.Integer getWeight()
    {
        return weight;
    }

    public void setWeight(java.lang.Integer weight)
    {
        this.weight = weight;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
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
        this.addRelation("categoryindex", "categoryindex");
        this.addRelation("categoryname", "categoryname");
        this.addRelation("categorypic", "categorypic");
        this.addRelation("categorylevel", "categorylevel");
        this.addRelation("categoryupindex", "categoryupindex");
        this.addRelation("weight", "weight");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
    }
}
