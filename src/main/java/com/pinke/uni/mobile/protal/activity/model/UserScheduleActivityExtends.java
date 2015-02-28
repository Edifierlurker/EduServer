package com.pinke.uni.mobile.protal.activity.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class UserScheduleActivityExtends extends DynamicBaseObject implements Serializable
{

    private java.lang.Long activityindex;
    private java.lang.String activitytitle;
    private java.lang.Long originatorindex;
    private java.lang.String iconurl;
    private java.lang.String content;
    private java.lang.String site;
    private java.lang.Integer status;
    private java.lang.String starttime;
    private java.lang.String endtime;
    private java.lang.String createtime;
    private java.lang.String updatetime;
    private java.lang.String note;
    private java.lang.Integer opentype;
    private java.lang.String longitude;
    private java.lang.String latitude;
    private java.lang.Long attendcount;
    /**
     * 参与者
     */
    private java.lang.Long attendUserindex;
    private java.lang.String attendUserName;
    private java.lang.String attendUserHeadPic;

    /**
     * 邀请者
     * 
     * @return
     */
    private java.lang.Long inviteUserindex;
    private java.lang.String inviteUserName;
    private java.lang.String inviteUserHeadPic;
    private java.lang.Integer isaccpet;

    private java.lang.String originatorName;

    private String recordurl;

    public String getRecordurl()
    {
        return recordurl;
    }

    public void setRecordurl(String recordurl)
    {
        this.recordurl = recordurl;
    }

    public java.lang.Long getActivityindex()
    {
        return activityindex;
    }

    public void setActivityindex(java.lang.Long activityindex)
    {
        this.activityindex = activityindex;
    }

    public java.lang.String getActivitytitle()
    {
        return activitytitle;
    }

    public void setActivitytitle(java.lang.String activitytitle)
    {
        this.activitytitle = activitytitle;
    }

    public java.lang.Long getOriginatorindex()
    {
        return originatorindex;
    }

    public void setOriginatorindex(java.lang.Long originatorindex)
    {
        this.originatorindex = originatorindex;
    }

    public java.lang.String getIconurl()
    {
        return iconurl;
    }

    public void setIconurl(java.lang.String iconurl)
    {
        this.iconurl = iconurl;
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

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
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

    public java.lang.Integer getOpentype()
    {
        return opentype;
    }

    public void setOpentype(java.lang.Integer opentype)
    {
        this.opentype = opentype;
    }

    public java.lang.Long getAttendUserindex()
    {
        return attendUserindex;
    }

    public void setAttendUserindex(java.lang.Long attendUserindex)
    {
        this.attendUserindex = attendUserindex;
    }

    public java.lang.String getAttendUserName()
    {
        return attendUserName;
    }

    public void setAttendUserName(java.lang.String attendUserName)
    {
        this.attendUserName = attendUserName;
    }

    public java.lang.String getAttendUserHeadPic()
    {
        return attendUserHeadPic;
    }

    public void setAttendUserHeadPic(java.lang.String attendUserHeadPic)
    {
        this.attendUserHeadPic = attendUserHeadPic;
    }

    public java.lang.Long getInviteUserindex()
    {
        return inviteUserindex;
    }

    public void setInviteUserindex(java.lang.Long inviteUserindex)
    {
        this.inviteUserindex = inviteUserindex;
    }

    public java.lang.String getInviteUserName()
    {
        return inviteUserName;
    }

    public void setInviteUserName(java.lang.String inviteUserName)
    {
        this.inviteUserName = inviteUserName;
    }

    public java.lang.String getInviteUserHeadPic()
    {
        return inviteUserHeadPic;
    }

    public void setInviteUserHeadPic(java.lang.String inviteUserHeadPic)
    {
        this.inviteUserHeadPic = inviteUserHeadPic;
    }

    public java.lang.Integer getIsaccpet()
    {
        return isaccpet;
    }

    public void setIsaccpet(java.lang.Integer isaccpet)
    {
        this.isaccpet = isaccpet;
    }

    public java.lang.String getOriginatorName()
    {
        return originatorName;
    }

    public void setOriginatorName(java.lang.String originatorName)
    {
        this.originatorName = originatorName;
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

    public java.lang.Long getAttendcount()
    {
        return attendcount;
    }

    public void setAttendcount(java.lang.Long attendcount)
    {
        this.attendcount = attendcount;
    }

    public void initRelation()
    {
        this.addRelation("activityindex", "activityindex");
        this.addRelation("activitytitle", "activitytitle");
        this.addRelation("originatorindex", "originatorindex");
        this.addRelation("iconurl", "iconurl");
        this.addRelation("content", "content");
        this.addRelation("site", "site");
        this.addRelation("status", "status");
        this.addRelation("starttime", "starttime");
        this.addRelation("endtime", "endtime");
        this.addRelation("createtime", "createtime");
        this.addRelation("updatetime", "updatetime");
        this.addRelation("note", "note");
        this.addRelation("opentype", "opentype");
        this.addRelation("attendUserindex", "attendUserindex");
        this.addRelation("attendUserName", "attendUserName");
        this.addRelation("attendUserHeadPic", "attendUserHeadPic");
        this.addRelation("inviteUserindex", "inviteUserindex");
        this.addRelation("inviteUserName", "inviteUserName");
        this.addRelation("inviteUserHeadPic", "inviteUserHeadPic");
        this.addRelation("isaccpet", "isaccpet");
        this.addRelation("originatorName", "originatorName");
        this.addRelation("recordurl", "recordurl");
        this.addRelation("longitude", "longitude");
        this.addRelation("latitude", "latitude");
        this.addRelation("attendcount", "attendcount");

    }
}
