package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TArticleinfo extends DynamicBaseObject implements Serializable
{

    private java.lang.Long articleindex;
    private java.lang.Long bbsindex;
    private java.lang.String articlepic;
    private java.lang.String articletitle;
    private java.lang.String articlebref;
    private java.lang.String articledesc;
    private java.lang.String createtime;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.Long createrindex;
    private java.lang.Integer articlestars;
    private java.lang.Integer ifissue;
    private java.lang.Integer articletype;
    private java.lang.Integer istop;
    private java.lang.String lastposttime;
    private java.lang.String creator;
    private java.lang.Long noticeuserindex;
    private java.lang.Long commenttimes;
    private java.lang.String bbstitle;

    private String headpic;

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public java.lang.String getCreator()
    {
        return creator;
    }

    public void setCreator(java.lang.String creator)
    {
        this.creator = creator;
    }

    public java.lang.Long getArticleindex()
    {
        return articleindex;
    }

    public void setArticleindex(java.lang.Long articleindex)
    {
        this.articleindex = articleindex;
    }

    public java.lang.Long getBbsindex()
    {
        return bbsindex;
    }

    public void setBbsindex(java.lang.Long bbsindex)
    {
        this.bbsindex = bbsindex;
    }

    public java.lang.String getArticlepic()
    {
        return articlepic;
    }

    public void setArticlepic(java.lang.String articlepic)
    {
        this.articlepic = articlepic;
    }

    public java.lang.String getArticletitle()
    {
        return articletitle;
    }

    public void setArticletitle(java.lang.String articletitle)
    {
        this.articletitle = articletitle;
    }

    public java.lang.String getArticlebref()
    {
        return articlebref;
    }

    public void setArticlebref(java.lang.String articlebref)
    {
        this.articlebref = articlebref;
    }

    public java.lang.String getArticledesc()
    {
        return articledesc;
    }

    public void setArticledesc(java.lang.String articledesc)
    {
        this.articledesc = articledesc;
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

    public java.lang.Long getCreaterindex()
    {
        return createrindex;
    }

    public void setCreaterindex(java.lang.Long createrindex)
    {
        this.createrindex = createrindex;
    }

    public java.lang.Integer getArticlestars()
    {
        return articlestars;
    }

    public void setArticlestars(java.lang.Integer articlestars)
    {
        this.articlestars = articlestars;
    }

    public java.lang.Integer getIfissue()
    {
        return ifissue;
    }

    public void setIfissue(java.lang.Integer ifissue)
    {
        this.ifissue = ifissue;
    }

    public java.lang.Integer getArticletype()
    {
        return articletype;
    }

    public void setArticletype(java.lang.Integer articletype)
    {
        this.articletype = articletype;
    }

    public java.lang.Integer getIstop()
    {
        return istop;
    }

    public void setIstop(java.lang.Integer istop)
    {
        this.istop = istop;
    }

    public java.lang.String getLastposttime()
    {
        return lastposttime;
    }

    public void setLastposttime(java.lang.String lastposttime)
    {
        this.lastposttime = lastposttime;
    }

    public java.lang.Long getNoticeuserindex()
    {
        return noticeuserindex;
    }

    public void setNoticeuserindex(java.lang.Long noticeuserindex)
    {
        this.noticeuserindex = noticeuserindex;
    }

    public java.lang.Long getCommenttimes()
    {
        return commenttimes;
    }

    public void setCommenttimes(java.lang.Long commenttimes)
    {
        this.commenttimes = commenttimes;
    }

    public java.lang.String getBbstitle()
    {
        return bbstitle;
    }

    public void setBbstitle(java.lang.String bbstitle)
    {
        this.bbstitle = bbstitle;
    }

    public void initRelation()
    {
        this.addRelation("articleindex", "articleindex");
        this.addRelation("bbsindex", "bbsindex");
        this.addRelation("articlepic", "articlepic");
        this.addRelation("articletitle", "articletitle");
        this.addRelation("articlebref", "articlebref");
        this.addRelation("articledesc", "articledesc");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("createrindex", "createrindex");
        this.addRelation("articlestars", "articlestars");
        this.addRelation("ifissue", "ifissue");
        this.addRelation("articletype", "articletype");
        this.addRelation("istop", "istop");
        this.addRelation("lastposttime", "lastposttime");
        this.addRelation("creator", "creator");
        this.addRelation("noticeuserindex", "noticeuserindex");
        this.addRelation("commenttimes", "commenttimes");
        this.addRelation("headpic", "headpic");
        this.addRelation("bbstitle", "bbstitle");
        
    }
}
