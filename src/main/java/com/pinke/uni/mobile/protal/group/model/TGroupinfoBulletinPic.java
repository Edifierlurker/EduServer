package com.pinke.uni.mobile.protal.group.model;

import java.io.Serializable;
import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TGroupinfoBulletinPic extends DynamicBaseObject implements Serializable
{

    private java.lang.Long picindex;
    private java.lang.Long bulletinidnex;
    private java.lang.String iconurl;
    private java.lang.Integer status;
    private java.lang.String note;

   

    public java.lang.Long getPicindex()
    {
        return picindex;
    }



    public void setPicindex(java.lang.Long picindex)
    {
        this.picindex = picindex;
    }



    public java.lang.Long getBulletinidnex()
    {
        return bulletinidnex;
    }



    public void setBulletinidnex(java.lang.Long bulletinidnex)
    {
        this.bulletinidnex = bulletinidnex;
    }



    public java.lang.String getIconurl()
    {
        return iconurl;
    }



    public void setIconurl(java.lang.String iconurl)
    {
        this.iconurl = iconurl;
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
        this.addRelation("picindex", "picindex");
        this.addRelation("bulletinidnex", "bulletinidnex");
        this.addRelation("iconurl", "iconurl");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
    }
}
