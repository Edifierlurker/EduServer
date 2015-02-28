package com.pinke.uni.mobile.protal.bbs.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.bbs.ls.ITArticleinfoCommentLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITArticleinfoLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITArticleinfoLikeLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITArticleinfoShareLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITBbsinfoLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITBbsinfoNoticeMapLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITBulletinLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITFriendinfoApplyLS;
import com.pinke.uni.mobile.protal.bbs.ls.ITFriendinfoLS;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfo;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoComment;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoLike;
import com.pinke.uni.mobile.protal.bbs.model.TArticleinfoShare;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfo;
import com.pinke.uni.mobile.protal.bbs.model.TBbsinfoNoticeMap;
import com.pinke.uni.mobile.protal.bbs.model.TBulletin;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfo;
import com.pinke.uni.mobile.protal.bbs.model.TFriendinfoApply;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class BBSFS implements IBBSFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private ITBbsinfoLS tbbsinfoLS;
    private ITArticleinfoLS tarticleinfoLS;
    private ITBbsinfoNoticeMapLS tbbsinfoNoticeMapLS;
    private ITArticleinfoCommentLS tarticleinfoCommentLS;
    private ITArticleinfoShareLS tarticleinfoShareLS;
    private ITArticleinfoLikeLS tarticleinfoLikeLS;
    private ITFriendinfoLS tfriendinfoLS;
    private ITFriendinfoApplyLS tfriendinfoApplyLS;
    private ITBulletinLS tbulletinLS;

    /**
     * 新增论坛,成功返回新增的对象
     * 
     * @param tbbsinfo
     * @return
     */
    public TBbsinfo insertBBSInfo(TBbsinfo tbbsinfo)
    {

        try
        {
            tbbsinfo.setStatus(1);
            String errorcode = tbbsinfoLS.insertTBbsinfo(tbbsinfo);

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                List<TBbsinfo> list = tbbsinfoLS.getTBbsinfoByCond(tbbsinfo);
                if (list != null && list.size() > 0)
                {
                    tbbsinfo = list.get(0);
                }

            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tbbsinfo;
    }

    /**
     * 根据index查询论坛详情
     * 
     * @param bbsindex
     * @return
     */
    public TBbsinfo getBBSInfo(Long bbsindex)
    {
        TBbsinfo tbbsinfo = new TBbsinfo();
        if (tbbsinfo == null)
            return null;
        SeriObjDCache dcValue = null;
        String strKey = "getBBSInfo";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + bbsindex));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                tbbsinfo = tbbsinfoLS.getTBbsinfoByIndex(bbsindex);

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();

                if (tbbsinfo != null)
                {
                    dcValue.setMemObj(tbbsinfo);
                }
                else
                {
                    dcValue.setMemObj(new TBbsinfo());
                }

                boolean success = mcc.set(new String(strKey + "_" + bbsindex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                tbbsinfo = (TBbsinfo) dcValue.getMemObj();
            }
        }
        return tbbsinfo;

    }

    /**
     * 分页查询论坛列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBBSList(Long schoolIndex, Long userIndex, int page, int count)
    {
        if (Tools.isNull(schoolIndex + ""))
        {
            return null;
        }

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getBBSList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + schoolIndex + "_" + userIndex + "_" + page
                    + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TBbsinfo tbbsinfo = new TBbsinfo();
                tbbsinfo.setStatus(1);
                tbbsinfo.setSchoolindex(schoolIndex);
                tbbsinfo.setStudentindex(userIndex);
                tbbsinfo.setOrderCond("weight asc,createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tbbsinfoLS.pageInfoQuery(tbbsinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (list != null)
                    {
                        dcValue.setMemlist(list.getData());
                        dcValue.setTotalCount(list.getTotalCount());
                    }
                    else
                    {
                        dcValue.setMemlist(new ArrayList());
                        dcValue.setTotalCount(0);
                    }
                    boolean success = mcc.set(new String(strKey + "_" + schoolIndex + "_" + userIndex + "_" + page
                            + "_" + count), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
                }

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 分页查询某一论坛下的文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleList(Long bbsindex, int page, int count)
    {
        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getArticleList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + bbsindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfo tarticleinfo = new TArticleinfo();
                tarticleinfo.setStatus(1);
                tarticleinfo.setBbsindex(bbsindex);
                tarticleinfo.setOrderCond("createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoLS.pageInfoQuery(tarticleinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();

                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }

                boolean success = mcc.set(new String(strKey + "_" + bbsindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 新增论坛关注
     * 
     * @param tbbsinfo
     * @return
     */
    public String insertBBSNoticeInfo(TBbsinfoNoticeMap tbbsinfoNoticeMap)
    {
        String result = "0";
        try
        {

            List<TBbsinfoNoticeMap> list = tbbsinfoNoticeMapLS.getTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
            if (list != null && list.size() > 0)
            {
                TBbsinfoNoticeMap temp = list.get(0);
                if (temp.getStatus() == 1)
                {
                    return "1";
                }
                else
                {
                    temp.setStatus(1);
                    String errorcode = tbbsinfoNoticeMapLS.updateTBbsinfoNoticeMap(temp);
                    if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
                    {
                        result = "2";
                    }
                }
            }
            else
            {

                tbbsinfoNoticeMap.setStatus(1);
                String errorcode = tbbsinfoNoticeMapLS.insertTBbsinfoNoticeMap(tbbsinfoNoticeMap);
                if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
                {
                    result = "2";
                }
            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 取消论坛关注
     * 
     * @param tbbsinfo
     * @return
     */
    public String removeBBSNoticeInfo(TBbsinfoNoticeMap tbbsinfoNoticeMap)
    {
        String result = "0";
        try
        {

            List<TBbsinfoNoticeMap> list = tbbsinfoNoticeMapLS.getTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);
            if (list != null && list.size() > 0)
            {
                String errorcode = tbbsinfoNoticeMapLS.removeTBbsinfoNoticeMapList(list);
                if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
                {
                    result = "2";
                }

            }
            else
            {

                result = "1";

            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增文章
     * 
     * @param tbbsinfo
     * @return
     */
    public TArticleinfo insertArticleInfo(TArticleinfo tarticleinfo)
    {

        try
        {
            tarticleinfo.setStatus(1);
            String errorcode = tarticleinfoLS.insertTArticleinfo(tarticleinfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                List<TArticleinfo> list = tarticleinfoLS.getTArticleinfoByCond(tarticleinfo);
                if (list != null && list.size() > 0)
                    tarticleinfo = list.get(0);

            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tarticleinfo;
    }

    /**
     * 分页查询我关注的论坛列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBBSNoticeList(Long userindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getBBSNoticeList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TBbsinfoNoticeMap tbbsnoticeinfo = new TBbsinfoNoticeMap();
                tbbsnoticeinfo.setAttendindex(userindex);
                tbbsnoticeinfo.setStatus(1);
                tbbsnoticeinfo.setOrderCond("m.weight asc,m.createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tbbsinfoNoticeMapLS.pageInfoQuery(tbbsnoticeinfo, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 新增文章评论
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleCommentInfo(TArticleinfoComment tarticleinfoComment)
    {
        boolean result = false;
        try
        {
            tarticleinfoComment.setStatus(1);
            String errorcode = tarticleinfoCommentLS.insertTArticleinfoComment(tarticleinfoComment);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分页查询评论列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleCommentList(Long articleindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getArticleCommentList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + articleindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfoComment tarticleinfoComment = new TArticleinfoComment();
                tarticleinfoComment.setArticleindex(articleindex);
                tarticleinfoComment.setStatus(1);
                tarticleinfoComment.setOrderCond("s.createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoCommentLS.pageInfoQuery(tarticleinfoComment, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }

                boolean success = mcc.set(new String(strKey + "_" + articleindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 文章只看楼主
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getArticleCommentListByindex(Long userindex, Long articleindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getArticleCommentList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + articleindex + "_" + page
                    + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfoComment tarticleinfoComment = new TArticleinfoComment();
                tarticleinfoComment.setArticleindex(articleindex);
                tarticleinfoComment.setCommenterindex(userindex);
                tarticleinfoComment.setStatus(1);
                tarticleinfoComment.setOrderCond("s.createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoCommentLS.pageInfoQuery(tarticleinfoComment, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + articleindex + "_" + page + "_"
                        + count), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null && Tools.isNotNull(dcValue.toString()))
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 评论我的
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getCommentToMeList(Long userindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getCommentToMeList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfoComment tarticleinfoComment = new TArticleinfoComment();
                tarticleinfoComment.setAuthorindex(userindex);
                tarticleinfoComment.setStatus(1);
                tarticleinfoComment.setOrderCond("s.createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoCommentLS.pageInfoQueryExtends(tarticleinfoComment, pageparam.getFirstIndex(),
                        pageparam.getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null && Tools.isNotNull(dcValue.toString()))
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 新增文章分享
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleShareInfo(TArticleinfoShare tarticleinfoShare)
    {
        boolean result = false;
        if (tarticleinfoShare == null)
            return false;
        try
        {
            tarticleinfoShare.setStatus(1);
            String errorcode = tarticleinfoShareLS.insertTArticleinfoShare(tarticleinfoShare);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增/更新文章喜欢
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertArticleLikeInfo(TArticleinfoLike tarticleinfoLike)
    {
        boolean result = false;
        String errorcode = "";
        try
        {
            if (tarticleinfoLike == null || tarticleinfoLike.getArticleindex() == null
                    || tarticleinfoLike.getUserindex() == null)
                return false;
            TArticleinfoLike temp = new TArticleinfoLike();
            temp.setArticleindex(tarticleinfoLike.getArticleindex());
            temp.setUserindex(tarticleinfoLike.getUserindex());

            temp = tarticleinfoLikeLS.getTArticleinfoLike(temp);
            if (temp != null)
            {
                errorcode = tarticleinfoLikeLS.updateTArticleinfoLike(tarticleinfoLike);
            }
            else
            {
                errorcode = tarticleinfoLikeLS.insertTArticleinfoLike(tarticleinfoLike);
            }
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增好友
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertFriend(Long userindex, Long friendindex, Long applyindex)
    {
        if (userindex == null || friendindex == null || applyindex == null)
            return false;
        boolean result = false;
        String errorcode = "";
        List<TFriendinfo> list = new ArrayList();
        try
        {
            // TFriendinfoApply tfriendinfoApply = new TFriendinfoApply();
            // tfriendinfoApply.setApplyindex(applyindex);
            // tfriendinfoApply.setStatus(2);
            // tfriendinfoApplyLS.updateTFriendinfoApply(tfriendinfoApply);
            TFriendinfo tfriendinfo1 = new TFriendinfo();
            tfriendinfo1.setFriendindex(friendindex);
            tfriendinfo1.setUserindex(userindex);
            TFriendinfo temp1 = tfriendinfoLS.getTFriendinfo(tfriendinfo1);
            TFriendinfo tfriendinfo2 = new TFriendinfo();
            tfriendinfo2.setFriendindex(userindex);
            tfriendinfo2.setUserindex(friendindex);
            TFriendinfo temp2 = tfriendinfoLS.getTFriendinfo(tfriendinfo2);
            /**
             * 互为好友
             */
            if (temp1 == null)
            {
                tfriendinfo1.setStatus(1);
                list.add(tfriendinfo1);
            }
            if (temp2 == null)
            {
                tfriendinfo2.setStatus(1);
                list.add(tfriendinfo2);
            }
            if (list != null && list.size() > 0)
            {

                errorcode = tfriendinfoLS.insertTFriendinfoList(list);

                if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
                {
                    updateFriendApply(applyindex, 2);
                    result = true;
                }
            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 好友列表
     * 
     * @param bbsindex
     * @return
     */
    public List getFriendList(Long userindex)
    {

        List list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getFriendList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TFriendinfo tfriendinfo = new TFriendinfo();
                tfriendinfo.setUserindex(userindex);
                tfriendinfo.setStatus(1);
                tfriendinfo.setOrderCond("mapindex desc");
                list = tfriendinfoLS.getTFriendinfoByCond(tfriendinfo);

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list);

                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list = dcValue.getMemlist();

            }
        }
        return list;

    }

    /**
     * 新增好友申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertFriendApply(Long userindex, Long friendindex)
    {
        if (userindex == null || friendindex == null)
            return false;
        boolean result = false;
        String errorcode = "";

        try
        {
            TFriendinfoApply tfriendinfoApply = new TFriendinfoApply();
            tfriendinfoApply.setFriendindex(friendindex);
            tfriendinfoApply.setUserindex(userindex);

            tfriendinfoApply.setStatus(1);
            errorcode = tfriendinfoApplyLS.insertTFriendinfoApply(tfriendinfoApply);

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询好友是否已经申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean checkFriendApply(Long userindex, Long friendindex)
    {
        if (userindex == null || friendindex == null)
            return true;
        boolean result = true;
        String errorcode = "";

        try
        {
            TFriendinfoApply tfriendinfoApply = new TFriendinfoApply();
            tfriendinfoApply.setFriendindex(friendindex);
            tfriendinfoApply.setUserindex(userindex);
            List<TFriendinfoApply> tempList = tfriendinfoApplyLS.getTFriendinfoApplyByCond(tfriendinfoApply);
            if (tempList != null && tempList.size() > 0)
            {
                result = false;

            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新好友申请状态
     * 
     * @param userindex
     * @param friendindex
     * @return
     */
    public boolean updateFriendApply(Long applyindex, int status)
    {
        boolean result = false;
        String errorcode = "";

        if (Tools.isNull(applyindex + "") || Tools.isNull(status + ""))
        {
            return false;
        }
        try
        {
            TFriendinfoApply tfriendinfoApply = new TFriendinfoApply();
            tfriendinfoApply.setApplyindex(applyindex);
            tfriendinfoApply.setStatus(status);
            errorcode = tfriendinfoApplyLS.updateTFriendinfoApply(tfriendinfoApply);

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分页查询校园公告列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getBulletinList(Long schoolindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getBulletinList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + schoolindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TBulletin tbulletin = new TBulletin();
                tbulletin.setSchoolindex(schoolindex);
                String time = Tools.formatDate7(new Date());
                tbulletin.setInvalidtime(time);
                tbulletin.setValidtime(time);
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tbulletinLS.pageInfoQuery(tbulletin, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + schoolindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 好友申请列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getFriendApplyList(Long userindex, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getFriendApplyList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TFriendinfoApply tfriendinfoApply = new TFriendinfoApply();
                tfriendinfoApply.setUserindex(userindex);
                tfriendinfoApply.setStatus(1);
                tfriendinfoApply.setOrderCond("applyindex desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tfriendinfoApplyLS.pageInfoQuery(tfriendinfoApply, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 查询论坛关注者列表
     * 
     * @param bbsIndex
     * @return
     */
    public List getBBSAttendList(Long bbsIndex)
    {
        if (Tools.isNull(bbsIndex + ""))
            return null;
        List<TBbsinfoNoticeMap> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getBBSAttendList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + bbsIndex));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TBbsinfoNoticeMap tbbsinfoNoticeMap = new TBbsinfoNoticeMap();
                tbbsinfoNoticeMap.setStatus(1);
                tbbsinfoNoticeMap.setBbsindex(bbsIndex);
                list = tbbsinfoNoticeMapLS.getTBbsinfoNoticeMapByCond(tbbsinfoNoticeMap);

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list);

                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                }
                boolean success = mcc.set(new String(strKey + "_" + bbsIndex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list = dcValue.getMemlist();
            }
        }
        return list;
    }

    /**
     * 分页查询我关注的论坛下的最新文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getUserNoticeArticleList(Long userindex, int page, int count)
    {
        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserNoticeArticleList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfo tarticleinfo = new TArticleinfo();
                tarticleinfo.setStatus(1);
                tarticleinfo.setNoticeuserindex(userindex);
                tarticleinfo.setOrderCond("lastposttime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoLS.pageInfoQueryExtends(tarticleinfo, pageparam.getFirstIndex(), pageparam
                        .getPageSize(), new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }
                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }

        }
        return list;

    }

    /**
     * 查询我是否关注某论坛
     * 
     * @param bbsindex
     * @return
     */
    public boolean isBBSNotice(Long userindex, Long bbsindex)
    {

        boolean result = false;
        List<TBbsinfoNoticeMap> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "isBBSNotice";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userindex + "_" + bbsindex));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TBbsinfoNoticeMap tbbsnoticeinfo = new TBbsinfoNoticeMap();
                tbbsnoticeinfo.setAttendindex(userindex);
                tbbsnoticeinfo.setBbsindex(bbsindex);
                // tbbsnoticeinfo.setStatus(1);
                list = tbbsinfoNoticeMapLS.getTBbsinfoNoticeMapByCond(tbbsnoticeinfo);
                if (list != null && list.size() > 0)
                {
                    result = true;
                }

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (list != null)
                {
                    dcValue.setMemlist(list);

                }
                else
                {
                    dcValue.setMemlist(new ArrayList());

                }

                boolean success = mcc.set(new String(strKey + "_" + userindex + "_" + bbsindex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list = dcValue.getMemlist();
            }
        }
        return result;

    }

    /**
     * 分页查询我的文章列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getMyArticleList(Long userIndex, int page, int count)
    {
        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getMyArticleList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TArticleinfo tarticleinfo = new TArticleinfo();
                tarticleinfo.setStatus(1);
                tarticleinfo.setCreaterindex(userIndex);
                tarticleinfo.setOrderCond("createtime desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tarticleinfoLS.pageInfoQuery(tarticleinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                        new PageUtilEntity());

            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();

                if (list != null)
                {
                    dcValue.setMemlist(list.getData());
                    dcValue.setTotalCount(list.getTotalCount());
                }
                else
                {
                    dcValue.setMemlist(new ArrayList());
                    dcValue.setTotalCount(0);
                }

                boolean success = mcc.set(new String(strKey + "_" + userIndex + "_" + page + "_" + count), dcValue,
                        new Date(DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                list.setData(dcValue.getMemlist());
                list.setTotalCount(dcValue.getTotalCount());
            }
        }
        return list;

    }

    /**
     * 更新好友备注名
     * 
     * @param userindex
     * @param friendindex
     * @return
     */
    public boolean updateFriendRemark(Long userIndex, Long friendIndex, String remark)
    {
        boolean result = false;
        String errorcode = "";

        if (Tools.isNull(userIndex + "") || Tools.isNull(friendIndex + ""))
        {
            return false;
        }
        if (Tools.isNull(remark))
            remark = "";
        try
        {
            TFriendinfo tfriendinfo = new TFriendinfo();
            tfriendinfo.setFriendindex(friendIndex);
            tfriendinfo.setUserindex(userIndex);
            tfriendinfo.setRemark(remark);
            errorcode = tfriendinfoLS.updateTFriendinfoExtends(tfriendinfo);

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public ITBbsinfoLS getTbbsinfoLS()
    {
        return tbbsinfoLS;
    }

    public void setTbbsinfoLS(ITBbsinfoLS tbbsinfoLS)
    {
        this.tbbsinfoLS = tbbsinfoLS;
    }

    public ITArticleinfoLS getTarticleinfoLS()
    {
        return tarticleinfoLS;
    }

    public void setTarticleinfoLS(ITArticleinfoLS tarticleinfoLS)
    {
        this.tarticleinfoLS = tarticleinfoLS;
    }

    public ITBbsinfoNoticeMapLS getTbbsinfoNoticeMapLS()
    {
        return tbbsinfoNoticeMapLS;
    }

    public void setTbbsinfoNoticeMapLS(ITBbsinfoNoticeMapLS tbbsinfoNoticeMapLS)
    {
        this.tbbsinfoNoticeMapLS = tbbsinfoNoticeMapLS;
    }

    public ITArticleinfoCommentLS getTarticleinfoCommentLS()
    {
        return tarticleinfoCommentLS;
    }

    public void setTarticleinfoCommentLS(ITArticleinfoCommentLS tarticleinfoCommentLS)
    {
        this.tarticleinfoCommentLS = tarticleinfoCommentLS;
    }

    public ITArticleinfoShareLS getTarticleinfoShareLS()
    {
        return tarticleinfoShareLS;
    }

    public void setTarticleinfoShareLS(ITArticleinfoShareLS tarticleinfoShareLS)
    {
        this.tarticleinfoShareLS = tarticleinfoShareLS;
    }

    public ITArticleinfoLikeLS getTarticleinfoLikeLS()
    {
        return tarticleinfoLikeLS;
    }

    public void setTarticleinfoLikeLS(ITArticleinfoLikeLS tarticleinfoLikeLS)
    {
        this.tarticleinfoLikeLS = tarticleinfoLikeLS;
    }

    public ITFriendinfoLS getTfriendinfoLS()
    {
        return tfriendinfoLS;
    }

    public void setTfriendinfoLS(ITFriendinfoLS tfriendinfoLS)
    {
        this.tfriendinfoLS = tfriendinfoLS;
    }

    public ITFriendinfoApplyLS getTfriendinfoApplyLS()
    {
        return tfriendinfoApplyLS;
    }

    public void setTfriendinfoApplyLS(ITFriendinfoApplyLS tfriendinfoApplyLS)
    {
        this.tfriendinfoApplyLS = tfriendinfoApplyLS;
    }

    public ITBulletinLS getTbulletinLS()
    {
        return tbulletinLS;
    }

    public void setTbulletinLS(ITBulletinLS tbulletinLS)
    {
        this.tbulletinLS = tbulletinLS;
    }

}
