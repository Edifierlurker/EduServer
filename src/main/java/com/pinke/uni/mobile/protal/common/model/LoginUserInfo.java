package com.pinke.uni.mobile.protal.common.model;

import java.io.Serializable;

/**
 * Created by Administrator on 15-1-8.
 */
public class LoginUserInfo implements Serializable {

    private Long userindex;

    private String userid;

    private String username;

    private String useraccount;

    private String nickname;

    private Long schoolIndex;

    public Long getSchoolIndex() {
        return schoolIndex;
    }

    public void setSchoolIndex(Long schoolIndex) {
        this.schoolIndex = schoolIndex;
    }

    public Long getUserindex() {
        return userindex;
    }

    public void setUserindex(Long userindex) {
        this.userindex = userindex;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
