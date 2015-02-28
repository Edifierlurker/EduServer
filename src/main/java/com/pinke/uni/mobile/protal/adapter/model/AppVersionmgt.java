package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class AppVersionmgt extends DynamicBaseObject implements Serializable
{

    private java.lang.Long versionindex;
    private java.lang.String packagename;
    private java.lang.Integer status;
    private java.lang.String versioncode;
    private java.lang.String versioname;
    private java.lang.String updatedesc;
    private java.lang.String apppath;
    private java.lang.Integer updateflag;
    private java.lang.Integer grouptype;
    private java.lang.String createtime;

    public java.lang.Long getVersionindex()
    {
        return versionindex;
    }

    public void setVersionindex(java.lang.Long versionindex)
    {
        this.versionindex = versionindex;
    }

    public java.lang.String getPackagename()
    {
        return packagename;
    }

    public void setPackagename(java.lang.String packagename)
    {
        this.packagename = packagename;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getVersioncode()
    {
        return versioncode;
    }

    public void setVersioncode(java.lang.String versioncode)
    {
        this.versioncode = versioncode;
    }

    public java.lang.String getVersioname()
    {
        return versioname;
    }

    public void setVersioname(java.lang.String versioname)
    {
        this.versioname = versioname;
    }

    public java.lang.String getUpdatedesc()
    {
        return updatedesc;
    }

    public void setUpdatedesc(java.lang.String updatedesc)
    {
        this.updatedesc = updatedesc;
    }

    public java.lang.String getApppath()
    {
        return apppath;
    }

    public void setApppath(java.lang.String apppath)
    {
        this.apppath = apppath;
    }

    public java.lang.Integer getUpdateflag()
    {
        return updateflag;
    }

    public void setUpdateflag(java.lang.Integer updateflag)
    {
        this.updateflag = updateflag;
    }

    public java.lang.Integer getGrouptype()
    {
        return grouptype;
    }

    public void setGrouptype(java.lang.Integer grouptype)
    {
        this.grouptype = grouptype;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public void initRelation()
    {
        this.addRelation("versionindex", "versionindex");
        this.addRelation("packagename", "packagename");
        this.addRelation("status", "status");
        this.addRelation("versioncode", "versioncode");
        this.addRelation("versioname", "versioname");
        this.addRelation("updatedesc", "updatedesc");
        this.addRelation("apppath", "apppath");
        this.addRelation("updateflag", "updateflag");
        this.addRelation("grouptype", "grouptype");
        this.addRelation("createtime", "createtime");
    }
}
