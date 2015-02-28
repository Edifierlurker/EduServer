package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TFriendinfoApply extends DynamicBaseObject implements Serializable
{

    private java.lang.Long applyindex;
    private java.lang.Long userindex;
    private java.lang.Long friendindex;
    private java.lang.Integer status;
    private java.lang.String applynote;
    private java.lang.String friendname;
    private java.lang.String friendphone;
    private java.lang.String friendid;
    private java.lang.String friendheadpic;

    public java.lang.Long getApplyindex()
    {
        return applyindex;
    }

    public void setApplyindex(java.lang.Long applyindex)
    {
        this.applyindex = applyindex;
    }

    public java.lang.Long getUserindex()
    {
        return userindex;
    }

    public void setUserindex(java.lang.Long userindex)
    {
        this.userindex = userindex;
    }

    public java.lang.Long getFriendindex()
    {
        return friendindex;
    }

    public void setFriendindex(java.lang.Long friendindex)
    {
        this.friendindex = friendindex;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.String getApplynote()
    {
        return applynote;
    }

    public void setApplynote(java.lang.String applynote)
    {
        this.applynote = applynote;
    }

    public java.lang.String getFriendname()
    {
        return friendname;
    }

    public void setFriendname(java.lang.String friendname)
    {
        this.friendname = friendname;
    }

    public java.lang.String getFriendphone()
    {
        return friendphone;
    }

    public void setFriendphone(java.lang.String friendphone)
    {
        this.friendphone = friendphone;
    }

    public java.lang.String getFriendid()
    {
        return friendid;
    }

    public void setFriendid(java.lang.String friendid)
    {
        this.friendid = friendid;
    }

    public java.lang.String getFriendheadpic()
    {
        return friendheadpic;
    }

    public void setFriendheadpic(java.lang.String friendheadpic)
    {
        this.friendheadpic = friendheadpic;
    }

    public void initRelation()
    {
        this.addRelation("applyindex", "applyindex");
        this.addRelation("userindex", "userindex");
        this.addRelation("friendindex", "friendindex");
        this.addRelation("status", "status");
        this.addRelation("applynote", "applynote");

        this.addRelation("friendname", "friendname");
        this.addRelation("friendphone", "friendphone");
        this.addRelation("friendid", "friendid");
        this.addRelation("friendheadpic", "friendheadpic");
    }
}
