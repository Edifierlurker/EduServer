package com.pinke.uni.mobile.protal.adapter.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TStudentinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long studentindex;
    private java.lang.String studentid;
    private java.lang.String userphone;
    private java.lang.String password;
    private java.lang.String headpic;
    private java.lang.String registertime;
    private java.lang.String canceltime;
    private java.lang.String studentname;
    private java.lang.Integer status;
    private java.lang.Integer gender;
    private java.lang.String birthmonth;
    private java.lang.String origin;
    private java.lang.String contactinfo;
    private java.lang.String idcard;
    private java.lang.Integer usertype;
    private java.lang.String profession;
    private java.lang.String studentno;
    private java.lang.Long classindex;
    private java.lang.Long majorindex;
    private java.lang.Long schoolindex;
    private java.lang.Long collegeindex;
    private java.lang.String entertime;
    private java.lang.String signature;
    private java.lang.String weekbegin;
    private java.lang.Long weeks;
    private java.lang.String starseat;
    private java.lang.String hobby;
    private java.lang.String userrecordurl;

    public java.lang.Long getStudentindex()
    {
        return studentindex;
    }

    public void setStudentindex(java.lang.Long studentindex)
    {
        this.studentindex = studentindex;
    }

    public java.lang.String getStudentid()
    {
        return studentid;
    }

    public void setStudentid(java.lang.String studentid)
    {
        this.studentid = studentid;
    }

    public java.lang.String getUserphone()
    {
        return userphone;
    }

    public void setUserphone(java.lang.String userphone)
    {
        this.userphone = userphone;
    }

    public java.lang.String getPassword()
    {
        return password;
    }

    public void setPassword(java.lang.String password)
    {
        this.password = password;
    }

    public java.lang.String getHeadpic()
    {
        return headpic;
    }

    public void setHeadpic(java.lang.String headpic)
    {
        this.headpic = headpic;
    }

    public java.lang.String getRegistertime()
    {
        return registertime;
    }

    public void setRegistertime(java.lang.String registertime)
    {
        this.registertime = registertime;
    }

    public java.lang.String getCanceltime()
    {
        return canceltime;
    }

    public void setCanceltime(java.lang.String canceltime)
    {
        this.canceltime = canceltime;
    }

    public java.lang.String getStudentname()
    {
        return studentname;
    }

    public void setStudentname(java.lang.String studentname)
    {
        this.studentname = studentname;
    }

    public java.lang.Integer getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    public java.lang.Integer getGender()
    {
        return gender;
    }

    public void setGender(java.lang.Integer gender)
    {
        this.gender = gender;
    }

    public java.lang.String getBirthmonth()
    {
        return birthmonth;
    }

    public void setBirthmonth(java.lang.String birthmonth)
    {
        this.birthmonth = birthmonth;
    }

    public java.lang.String getOrigin()
    {
        return origin;
    }

    public void setOrigin(java.lang.String origin)
    {
        this.origin = origin;
    }

    public java.lang.String getContactinfo()
    {
        return contactinfo;
    }

    public void setContactinfo(java.lang.String contactinfo)
    {
        this.contactinfo = contactinfo;
    }

    public java.lang.String getIdcard()
    {
        return idcard;
    }

    public void setIdcard(java.lang.String idcard)
    {
        this.idcard = idcard;
    }

    public java.lang.Integer getUsertype()
    {
        return usertype;
    }

    public void setUsertype(java.lang.Integer usertype)
    {
        this.usertype = usertype;
    }

    public java.lang.String getProfession()
    {
        return profession;
    }

    public void setProfession(java.lang.String profession)
    {
        this.profession = profession;
    }

    public java.lang.String getStudentno()
    {
        return studentno;
    }

    public void setStudentno(java.lang.String studentno)
    {
        this.studentno = studentno;
    }

    public java.lang.Long getClassindex()
    {
        return classindex;
    }

    public void setClassindex(java.lang.Long classindex)
    {
        this.classindex = classindex;
    }

    public java.lang.Long getMajorindex()
    {
        return majorindex;
    }

    public void setMajorindex(java.lang.Long majorindex)
    {
        this.majorindex = majorindex;
    }

    public java.lang.Long getSchoolindex()
    {
        return schoolindex;
    }

    public void setSchoolindex(java.lang.Long schoolindex)
    {
        this.schoolindex = schoolindex;
    }

    public java.lang.Long getCollegeindex()
    {
        return collegeindex;
    }

    public void setCollegeindex(java.lang.Long collegeindex)
    {
        this.collegeindex = collegeindex;
    }

    public java.lang.String getEntertime()
    {
        return entertime;
    }

    public void setEntertime(java.lang.String entertime)
    {
        this.entertime = entertime;
    }

    public java.lang.String getSignature()
    {
        return signature;
    }

    public void setSignature(java.lang.String signature)
    {
        this.signature = signature;
    }

    public java.lang.String getWeekbegin()
    {
        return weekbegin;
    }

    public void setWeekbegin(java.lang.String weekbegin)
    {
        this.weekbegin = weekbegin;
    }

    public java.lang.Long getWeeks()
    {
        return weeks;
    }

    public void setWeeks(java.lang.Long weeks)
    {
        this.weeks = weeks;
    }

    public java.lang.String getHobby()
    {
        return hobby;
    }

    public void setHobby(java.lang.String hobby)
    {
        this.hobby = hobby;
    }

    public java.lang.String getStarseat()
    {
        return starseat;
    }

    public void setStarseat(java.lang.String starseat)
    {
        this.starseat = starseat;
    }

    public java.lang.String getuserrecordurl()
    {
        return userrecordurl;
    }

    public void setuserrecordurl(java.lang.String userrecordurl)
    {
        this.userrecordurl = userrecordurl;
    }

    public void initRelation()
    {
        this.addRelation("studentindex", "studentindex");
        this.addRelation("studentid", "studentid");
        this.addRelation("userphone", "userphone");
        this.addRelation("password", "password");
        this.addRelation("headpic", "headpic");
        this.addRelation("registertime", "registertime");
        this.addRelation("canceltime", "canceltime");
        this.addRelation("studentname", "studentname");
        this.addRelation("status", "status");
        this.addRelation("gender", "gender");
        this.addRelation("birthmonth", "birthmonth");
        this.addRelation("origin", "origin");
        this.addRelation("contactinfo", "contactinfo");
        this.addRelation("idcard", "idcard");
        this.addRelation("usertype", "usertype");
        this.addRelation("profession", "profession");
        this.addRelation("studentno", "studentno");
        this.addRelation("classindex", "classindex");
        this.addRelation("majorindex", "majorindex");
        this.addRelation("schoolindex", "schoolindex");
        this.addRelation("collegeindex", "collegeindex");
        this.addRelation("entertime", "entertime");
        this.addRelation("signature", "signature");
        this.addRelation("weekbegin", "weekbegin");
        this.addRelation("weeks", "weeks");
        this.addRelation("starseat", "starseat");
        this.addRelation("hobby", "hobby");
        this.addRelation("userrecordurl", "userrecordurl");
    }
}
