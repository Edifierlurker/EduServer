package com.pinke.uni.mobile.protal.bbs.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface IBBSFS
{
    /**
     * 新增论坛
     * 
     * @param tbbsinfo
     * @return
     */
    public TBbsinfo insertBBSInfo(TBbsinfo tbbsinfo);

    /**
     * 根据index查询论坛详情
     * 
     * @param bbsindex
     * @return
     */
    public TBbsinfo getBBSInfo(Long bbsindex);

    /**
     * 分页查询论坛列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBBSList(Long schoolIndex, Long userIndex, int page, int count);

    /**
     * 分页查询某一论坛下的文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleList(Long bbsindex, int page, int count);

    /**
     * 新增文章
     * 
     * @param tbbsinfo
     * @return
     */
    public TArticleinfo insertArticleInfo(TArticleinfo tarticleinfo);

    /**
     * 新增论坛关注
     * 
     * @param tbbsinfo
     * @return
     */
    public String insertBBSNoticeInfo(TBbsinfoNoticeMap tbbsinfoNoticeMap);

    /**
     * 分页查询我关注的论坛列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBBSNoticeList(Long userindex, int page, int count);

    /**
     * 分页查询评论列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleCommentList(Long articleindex, int page, int count);

    /**
     * 文章只看楼主
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleCommentListByindex(Long userindex, Long articleindex, int page, int count);

    /**
     * 评论我的
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getCommentToMeList(Long userindex, int page, int count);

    /**
     * 新增文章分享
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleShareInfo(TArticleinfoShare tarticleinfoShare);

    /**
     * 新增/更新文章喜欢
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleLikeInfo(TArticleinfoLike tarticleinfoLike);

    /**
     * 新增好友
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertFriend(Long userindex, Long friendindex, Long applyindex);

    /**
     * 好友列表
     * 
     * @param bbsindex
     * @return
     */
    public List getFriendList(Long userindex);

    /**
     * 新增好友申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertFriendApply(Long userindex, Long friendindex);

    /**
     * 更新好友申请状态
     * 
     * @param userindex
     * @param friendindex
     * @return
     */
    public boolean updateFriendApply(Long applyindex, int status);

    /**
     * 好友申请列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getFriendApplyList(Long userindex, int page, int count);

    /**
     * 新增文章评论
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleCommentInfo(TArticleinfoComment tarticleinfoComment);

    /**
     * 分页查询校园公告列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBulletinList(Long schoolindex, int page, int count);

    /**
     * 查询论坛关注者列表
     * 
     * @param bbsIndex
     * @return
     */
    public List getBBSAttendList(Long bbsIndex);

    /**
     * 分页查询我关注的论坛下的最新文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getUserNoticeArticleList(Long userindex, int page, int count);

    /**
     * 查询我是否关注某论坛
     * 
     * @param bbsindex
     * @return
     */
    public boolean isBBSNotice(Long userindex, Long bbsindex);

    /**
     * 取消论坛关注
     * 
     * @param tbbsinfo
     * @return
     */
    public String removeBBSNoticeInfo(TBbsinfoNoticeMap tbbsinfoNoticeMap);

    /**
     * 分页查询我的文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getMyArticleList(Long userIndex, int page, int count);

    /**
     * 查询好友是否已经申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean checkFriendApply(Long userindex, Long friendindex);

    /**
     * 更新好友备注名
     * 
     * @param userindex
     * @param friendindex
     * @return
     */
    public boolean updateFriendRemark(Long userIndex, Long friendIndex, String remark);

}
