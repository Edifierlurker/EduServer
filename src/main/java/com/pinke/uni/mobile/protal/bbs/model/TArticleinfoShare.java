package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TArticleinfoShare extends DynamicBaseObject implements Serializable
{

    private java.lang.Long shareindex;
    private java.lang.Long articleindex;
    private java.lang.Long userindex;
    private java.lang.String sharesite;
    private java.lang.String sharelinkurl;
    private java.lang.String createtime;
    private java.lang.Integer status;
    private java.lang.String note;

    public java.lang.Long getShareindex()
    {
        return shareindex;
    }

    public void setShareindex(java.lang.Long shareindex)
    {
        this.shareindex = shareindex;
    }

    public java.lang.Long getArticleindex()
    {
        return articleindex;
    }

    public void setArticleindex(java.lang.Long articleindex)
    {
        this.articleindex = articleindex;
    }

    public java.lang.Long getUserindex()
    {
        return userindex;
    }

    public void setUserindex(java.lang.Long userindex)
    {
        this.userindex = userindex;
    }

    public java.lang.String getSharesite()
    {
        return sharesite;
    }

    public void setSharesite(java.lang.String sharesite)
    {
        this.sharesite = sharesite;
    }

    public java.lang.String getSharelinkurl()
    {
        return sharelinkurl;
    }

    public void setSharelinkurl(java.lang.String sharelinkurl)
    {
        this.sharelinkurl = sharelinkurl;
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
        this.addRelation("shareindex", "shareindex");
        this.addRelation("articleindex", "articleindex");
        this.addRelation("userindex", "userindex");
        this.addRelation("sharesite", "sharesite");
        this.addRelation("sharelinkurl", "sharelinkurl");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
    }
}
