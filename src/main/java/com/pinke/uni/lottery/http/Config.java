package com.pinke.uni.lottery.http;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-6
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    private String snsType;

    private String snsName;

    private String openbaseurl;

    private String linkuri;

    private String shareuri;

    public String getShareuri() {
        return shareuri;
    }

    public void setShareuri(String shareuri) {
        this.shareuri = shareuri;
    }

    public String getOpenbaseurl() {
        return openbaseurl;
    }

    public void setOpenbaseurl(String openbaseurl) {
        this.openbaseurl = openbaseurl;
    }

    public String getLinkuri() {
        return linkuri;
    }

    public void setLinkuri(String linkuri) {
        this.linkuri = linkuri;
    }

    public String getSnsName() {
        return snsName;
    }

    public void setSnsName(String snsName) {
        this.snsName = snsName;
    }

    public String getSnsType() {
        return snsType;
    }

    public void setSnsType(String snsType) {
        this.snsType = snsType;
    }

    @Override
    public String toString() {
        return "sns: " + snsName + "\n\r"
                + "type: " + snsType + "\n\r"
                + "openbaseurl: " + openbaseurl + "\n\r"
                + "linkuri: " + linkuri;
    }
}
