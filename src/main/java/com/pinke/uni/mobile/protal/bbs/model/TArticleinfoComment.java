package com.pinke.uni.mobile.protal.bbs.model;

import java.io.Serializable;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

@SuppressWarnings("serial")
public class TArticleinfoComment extends DynamicBaseObject implements Serializable
{

    private java.lang.Long commentindex;
    private java.lang.Long articleindex;
    private java.lang.Long commenterindex;
    private java.lang.String commentdesc;
    private java.lang.Integer commentstarts;
    private java.lang.String createtime;
    private java.lang.Integer status;
    private java.lang.String note;
    private java.lang.Long addcommentindex;
    private java.lang.Integer commenttype;
    private java.lang.String articletitle;
    private java.lang.String articledesc;
    private java.lang.String commenter;
    private java.lang.Long authorindex;
    private java.lang.Long commenttimes;
    private java.lang.String headpic;

    public java.lang.Long getCommentindex()
    {
        return commentindex;
    }

    public void setCommentindex(java.lang.Long commentindex)
    {
        this.commentindex = commentindex;
    }

    public java.lang.Long getArticleindex()
    {
        return articleindex;
    }

    public void setArticleindex(java.lang.Long articleindex)
    {
        this.articleindex = articleindex;
    }

    public java.lang.Long getCommenterindex()
    {
        return commenterindex;
    }

    public void setCommenterindex(java.lang.Long commenterindex)
    {
        this.commenterindex = commenterindex;
    }

    public java.lang.String getCommentdesc()
    {
        return commentdesc;
    }

    public void setCommentdesc(java.lang.String commentdesc)
    {
        this.commentdesc = commentdesc;
    }

    public java.lang.Integer getCommentstarts()
    {
        return commentstarts;
    }

    public void setCommentstarts(java.lang.Integer commentstarts)
    {
        this.commentstarts = commentstarts;
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

    public java.lang.Long getAddcommentindex()
    {
        return addcommentindex;
    }

    public void setAddcommentindex(java.lang.Long addcommentindex)
    {
        this.addcommentindex = addcommentindex;
    }

    public java.lang.Integer getCommenttype()
    {
        return commenttype;
    }

    public void setCommenttype(java.lang.Integer commenttype)
    {
        this.commenttype = commenttype;
    }

    public java.lang.String getArticletitle()
    {
        return articletitle;
    }

    public void setArticletitle(java.lang.String articletitle)
    {
        this.articletitle = articletitle;
    }

    public java.lang.String getArticledesc()
    {
        return articledesc;
    }

    public void setArticledesc(java.lang.String articledesc)
    {
        this.articledesc = articledesc;
    }

    public java.lang.String getCommenter()
    {
        return commenter;
    }

    public void setCommenter(java.lang.String commenter)
    {
        this.commenter = commenter;
    }

    public java.lang.Long getAuthorindex()
    {
        return authorindex;
    }

    public void setAuthorindex(java.lang.Long authorindex)
    {
        this.authorindex = authorindex;
    }

    public java.lang.Long getCommenttimes()
    {
        return commenttimes;
    }

    public void setCommenttimes(java.lang.Long commenttimes)
    {
        this.commenttimes = commenttimes;
    }

    public java.lang.String getHeadpic()
    {
        return headpic;
    }

    public void setHeadpic(java.lang.String headpic)
    {
        this.headpic = headpic;
    }

    public void initRelation()
    {
        this.addRelation("commentindex", "commentindex");
        this.addRelation("articleindex", "articleindex");
        this.addRelation("commenterindex", "commenterindex");
        this.addRelation("commentdesc", "commentdesc");
        this.addRelation("commentstarts", "commentstarts");
        this.addRelation("createtime", "createtime");
        this.addRelation("status", "status");
        this.addRelation("note", "note");
        this.addRelation("addcommentindex", "addcommentindex");
        this.addRelation("commenttype", "commenttype");
        this.addRelation("articletitle", "articletitle");
        this.addRelation("articledesc", "articledesc");
        this.addRelation("commenter", "commenter");
        this.addRelation("authorindex", "authorindex");
        this.addRelation("commenttimes", "commenttimes");
        this.addRelation("headpic", "headpic");
    }
}
