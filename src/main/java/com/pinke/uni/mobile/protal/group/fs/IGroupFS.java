package com.pinke.uni.mobile.protal.group.fs;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public interface IGroupFS
{
    /**
     * 分页查询群组列表(按距离)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByDistance(String longitude, String latitude, int page, int count);

    /**
     * 分页查询群组列表(按搜索条件)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByKeyword(String keyword, String longitude, String latitude, int page, int count);

    /**
     * 新增群组
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfo insertGroupInfo(TGroupinfo tgroupinfo);

    /**
     * 查询群组详情
     * 
     * @param bbsindex
     * @return
     */
    public TGroupinfo getGroupInfoByIndex(Long groupindex);

    /**
     * 查询群组成员列表
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupAttendList(Long groupindex);

    /**
     * 查询群组申请列表
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupApplyList(Long groupindex);

    /**
     * 查询群组分类(一级分类)
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupCategoryList();

    /**
     * 查询群组分类(二级分类)
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupCategoryListByUpindex(Long upindex);

    /**
     * 查询分类下的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByCategory(Long categoryindex, int page, int count);

    /**
     * 新增群组申请者
     * 
     * @param tbbsinfo
     * @return
     */
    public String insertGroupApplyInfo(TGroupinfoAttendMap tgroupinfoAttendMap);

    /**
     * 新增用户位置信息
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertUserSiteInfo(TNearStudent tnearStudent);

    /**
     * 删除用户位置信息
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeUserSiteInfo(Long studentindex);

    /**
     * 分页查询附近的人(按距离)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getNearStudentListByDistance(TNearStudent tnearStudent, int page, int count);

    /**
     * 分页查询群组公告列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupBulletinList(Long groupIndex, int page, int count);

    /**
     * 新增群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin);

    /**
     * 修改群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin);

    /**
     * 删除群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeGroupBulletin(Long bulletinIndex);

    /**
     * 查询群组公告图片
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupBulletinPicList(Long bulletinIndex);

    /**
     * 新增群组公告图片列表
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupBulletinPic(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList);

    /**
     * 修改群组公告图片
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic);

    /**
     * 删除群组公告图片
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeGroupBulletinPic(Long picIndex);

    /**
     * 全条件查询群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfoBulletin getGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin);

    /**
     * 按索引查询群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfoBulletin getGroupBulletin(Long bulletinidnex);

    /**
     * 退出群组
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean quitGroup(TGroupinfoAttendMap tgroupinfo);

    /**
     * 修改群组信息
     * 
     * @param tgroupinfo
     * @return
     */
    public TGroupinfo updateGroupInfo(TGroupinfo tgroupinfo);

    /**
     * 条件查询群组成员
     * 
     * @param bbsindex
     * @return
     */
    public List searchGroupUserList(Long groupIndx, String keyword);

    /**
     * 查询群组成员列表
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupUserList(Long groupIndx);

    /**
     * 分页查询我参加的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getAttendGroupList(Long userindex, int page, int count);

    /**
     * 修改用户群昵称
     * 
     * @param bbsindex
     * @return
     */
    public boolean updateUserGroupNickname(Long grpMapIndex, String grpNickName);

    /**
     * 新增群组参与者
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupAttendInfo(TGroupinfoAttendMap tgroupinfoAttendMap);

    /**
     * 拒绝群组申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupAttendInfo(TGroupinfoAttendMap tgroupinfoAttendMap);

    /**
     * 查询我参加的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public List getMyChatGroupList(Long userindex);

    /**
     * 新增群组参与者列表
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupAttendList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList);

}
