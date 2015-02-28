package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;
import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TBulletin extends DynamicBaseObject implements Serializable
{

    private java.lang.Long bulindex;
    private java.lang.String theme;
    private java.lang.String content;
    private java.lang.String createtime;
    private java.lang.String validtime;
    private java.lang.String invalidtime;
    private java.lang.Integer validdays;
    private java.lang.Long schoolindex;

    public java.lang.Long getBulindex()
    {
        return bulindex;
    }

    public void setBulindex(java.lang.Long bulindex)
    {
        this.bulindex = bulindex;
    }

    public java.lang.String getTheme()
    {
        return theme;
    }

    public void setTheme(java.lang.String theme)
    {
        this.theme = theme;
    }

    public java.lang.String getContent()
    {
        return content;
    }

    public void setContent(java.lang.String content)
    {
        this.content = content;
    }

    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }

    public java.lang.String getValidtime()
    {
        return validtime;
    }

    public void setValidtime(java.lang.String validtime)
    {
        this.validtime = validtime;
    }

    public java.lang.String getInvalidtime()
    {
        return invalidtime;
    }

    public void setInvalidtime(java.lang.String invalidtime)
    {
        this.invalidtime = invalidtime;
    }

    public java.lang.Integer getValiddays()
    {
        return validdays;
    }

    public void setValiddays(java.lang.Integer validdays)
    {
        this.validdays = validdays;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public void initRelation()
    {
        this.addRelation("bulindex", "bulindex");
        this.addRelation("theme", "theme");
        this.addRelation("content", "content");
        this.addRelation("createtime", "createtime");
        this.addRelation("validtime", "validtime");
        this.addRelation("invalidtime", "invalidtime");
        this.addRelation("validdays", "validdays");
        this.addRelation("schoolindex", "schoolindex");
    }
}
