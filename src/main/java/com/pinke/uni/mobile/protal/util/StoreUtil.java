package com.pinke.uni.mobile.protal.util;

import java.util.HashMap;

/**
 * 一些初始化和公用信息
 * 
 * @author Administrator
 * 
 */
public class StoreUtil
{
    /**
     * 反射类路径
     */
    private static HashMap<String, String> reflectObj = new HashMap<String, String>();

    public static void init()
    {        

        initReflectObj();
    }

    /**
     * 初始化类信息
     */
    private static void initReflectObj()
    {
        /**
         * 用户登录、注册、个人信息相关
         */
        reflectObj.put("login", "com.pinke.uni.mobile.protal.adapter.action.LoginAction");
        reflectObj.put("register", "com.pinke.uni.mobile.protal.adapter.action.RegistAction");
        reflectObj.put("modifyPassword", "com.pinke.uni.mobile.protal.adapter.action.ModifyPasswordAction");
        reflectObj.put("updateUserInfo", "com.pinke.uni.mobile.protal.adapter.action.UpdateUserInfoAction");
        reflectObj.put("getUserInfo", "com.pinke.uni.mobile.protal.adapter.action.GetUserInfoAction");
        reflectObj.put("getMajInfo", "com.pinke.uni.mobile.protal.adapter.action.GetSchoolInfoAction");
        reflectObj.put("getSchoolInfoExtends", "com.pinke.uni.mobile.protal.adapter.action.GetSchoolInfoExtendsAction");
        reflectObj.put("checkUserReg", "com.pinke.uni.mobile.protal.adapter.action.CheckUserRegisterAction");
        reflectObj.put("update", "com.pinke.uni.mobile.protal.adapter.action.ClientUpAction");
        
        reflectObj.put("getUserInfoByUserid", "com.pinke.uni.mobile.protal.adapter.action.GetUserInfoByUseridAction");

        /**
         * 日程表相关
         */
        reflectObj.put("insertSchedule", "com.pinke.uni.mobile.protal.schedule.action.InsertUserScheduleAction");
        reflectObj.put("getSchedule", "com.pinke.uni.mobile.protal.schedule.action.GetUserScheduleAction");
        reflectObj.put("delSchedule", "com.pinke.uni.mobile.protal.schedule.action.DelUserScheduleAction");
        reflectObj.put("delActivity", "com.pinke.uni.mobile.protal.schedule.action.DelUserRecordAction");

        /**
         * 笔记相关
         */
        reflectObj.put("getNoteList", "com.pinke.uni.mobile.protal.note.action.GetUserNoteListAction");
        reflectObj.put("getNoteDetail", "com.pinke.uni.mobile.protal.note.action.GetUserNoteDetailAction");
        reflectObj.put("insertNote", "com.pinke.uni.mobile.protal.note.action.InsertUserNoteAction");

        /**
         * 活动相关
         */
        reflectObj.put("getActivityDetail", "com.pinke.uni.mobile.protal.activity.action.GetUserActivityDetailAction");
        reflectObj.put("insertActivity", "com.pinke.uni.mobile.protal.activity.action.InsertUserActivityAction");
        reflectObj.put("getActivityList", "com.pinke.uni.mobile.protal.activity.action.GetActivityListAction");
        reflectObj.put("searchActivityList", "com.pinke.uni.mobile.protal.activity.action.SearchActivityListAction");

        /**
         * 个人相关
         */

        reflectObj.put("getPrivateList", "com.pinke.uni.mobile.protal.personal.action.GetPersonalListAction");
        reflectObj.put("getPrivateDetail", "com.pinke.uni.mobile.protal.personal.action.GetPersonalDetailAction");
        reflectObj.put("insertPrivate", "com.pinke.uni.mobile.protal.personal.action.InsertUserPersonalAction");

        /**
         * 考试相关
         */

        reflectObj.put("getExamDetail", "com.pinke.uni.mobile.protal.exam.action.GetExamDetailAction");
        reflectObj.put("getExamList", "com.pinke.uni.mobile.protal.exam.action.GetExamListAction");
        reflectObj.put("insertExam", "com.pinke.uni.mobile.protal.exam.action.InsertExamAction");

        /**
         * 课程相关
         */
        reflectObj.put("getCourseDetail", "com.pinke.uni.mobile.protal.course.action.GetCourseDetailAction");
        reflectObj.put("getCourseList", "com.pinke.uni.mobile.protal.course.action.GetCourseListAction");
        reflectObj.put("insertCourse", "com.pinke.uni.mobile.protal.course.action.InsertCourseAction");

        /**
         * 好友相关
         */
        reflectObj.put("dealFriendApply", "com.pinke.uni.mobile.protal.bbs.action.DealFriendApplyAction");
        reflectObj.put("insertFriendApply", "com.pinke.uni.mobile.protal.bbs.action.InsertFriendApplyAction");
        reflectObj.put("getFriendList", "com.pinke.uni.mobile.protal.bbs.action.GetFriendListAction");
        reflectObj.put("getFriendApplyList", "com.pinke.uni.mobile.protal.bbs.action.GetFriendApplyListAction");
        reflectObj.put("updateFriendRemark", "com.pinke.uni.mobile.protal.bbs.action.UpdateFriendRemarkAction");

        /**
         * 论坛相关
         */
        reflectObj.put("insertBBSNotice", "com.pinke.uni.mobile.protal.bbs.action.InsertBBSNoticeAction");
        reflectObj.put("insertBBSDetail", "com.pinke.uni.mobile.protal.bbs.action.InsertBBSDetailAction");
        reflectObj.put("insertBBSArticleDetail", "com.pinke.uni.mobile.protal.bbs.action.InsertBBSArticleAction");
        reflectObj.put("insertArticleComment", "com.pinke.uni.mobile.protal.bbs.action.InsertArticleCommentAction");
        reflectObj.put("getBBSList", "com.pinke.uni.mobile.protal.bbs.action.GetBBSListAction");
        reflectObj.put("getBBSArticleList", "com.pinke.uni.mobile.protal.bbs.action.GetArticleListAction");
        reflectObj.put("getArticleCommentList", "com.pinke.uni.mobile.protal.bbs.action.GetArticleCommentListAction");
        reflectObj.put("getBulletinList", "com.pinke.uni.mobile.protal.bbs.action.GetBulletinListAction");
        reflectObj.put("searchUserList", "com.pinke.uni.mobile.protal.bbs.action.SearchUserListAction");

        /**
         * 群组相关
         */
        reflectObj.put("getGroupList", "com.pinke.uni.mobile.protal.group.action.GetGroupListAction");
        reflectObj.put("insertGroupDetail", "com.pinke.uni.mobile.protal.group.action.InsertGroupAction");
        reflectObj.put("getGroupDetail", "com.pinke.uni.mobile.protal.group.action.GetGroupDetailAction");
        reflectObj.put("getGroupCategory", "com.pinke.uni.mobile.protal.group.action.GetGroupCategoryAction");
        reflectObj.put("attendgroup", "com.pinke.uni.mobile.protal.group.action.ApplyAttendGroupAction");
        reflectObj.put("getGroupListByCat", "com.pinke.uni.mobile.protal.group.action.GetGroupListByCategoryAction");
        reflectObj.put("getGroupBulletinList", "com.pinke.uni.mobile.protal.group.action.GetGroupBulletinListAction");

        reflectObj.put("searchGroupList", "com.pinke.uni.mobile.protal.group.action.SearchGroupListAction");

        reflectObj.put("insertGroupBulletin", "com.pinke.uni.mobile.protal.group.action.InsertGroupBulletinAction");
        reflectObj.put("quitGroup", "com.pinke.uni.mobile.protal.group.action.QuitGroupAction");
        reflectObj.put("removeGroupBulletin", "com.pinke.uni.mobile.protal.group.action.RemoveGroupBulletinAction");

        reflectObj.put("searchGroupStudentList",
                "com.pinke.uni.mobile.protal.group.action.SearchGroupStudentListAction");

        reflectObj.put("getGroupStudentList", "com.pinke.uni.mobile.protal.group.action.GetGroupStudentListAction");
        reflectObj.put("updateGrpNickname", "com.pinke.uni.mobile.protal.group.action.updateGroupUserNicknameAction");
        reflectObj.put("dealGroupApply", "com.pinke.uni.mobile.protal.group.action.DealGroupApplyAction");

        reflectObj.put("getChatGroupList", "com.pinke.uni.mobile.protal.group.action.GetChatGroupListAction");
        
        reflectObj.put("insertChatGroup", "com.pinke.uni.mobile.protal.group.action.InsertChatGroupAction");

        /**
         * 附近的人
         */
        reflectObj.put("getNearStudentList", "com.pinke.uni.mobile.protal.group.action.GetUserNearPositionListAction");
        reflectObj.put("removeUserPositon", "com.pinke.uni.mobile.protal.group.action.RemoveUserPositionAction");

    }

    public static String getReflectObj(String key)
    {
        return reflectObj.get(key);
    }

    /**
     * 获取用户默认密码
     * 
     * @return
     */
    public static String getUserPass()
    {
        String s = SystemTools.getUUID_32();
        s = s.substring(0, 6);
        return s;
    }

    /**
     * 获取index位验证码
     * 
     * @return
     */
    public static String getVerifycode(int index)
    {
        String s = SystemTools.getUUID_32();
        s = s.substring(0, index).toUpperCase();
        return s;
    }

    /**
     * 获取用户sessionid
     * 
     * @return
     */
    public static String getSessionid()
    {
        String s = SystemTools.getUUID_32();
        return s;
    }

    /**
     * 解析图片url
     * 
     * @param cache
     *            缓存类，用于获取跟客户端手机机型分辨率匹配的图片名
     * @param iconurl
     *            图片原始url
     * @param iconName
     *            客户端手机图片名
     * @param icontype
     *            图片类型 1、列表 2 详情 3 截图
     * @return [图片名，目录]
     * @throws Exception
     */
    public static String[] parseIconurl(String iconurl, String iconName) throws Exception
    {
        String[] urlparams = SystemTools.getURLParams(iconurl);
        if (iconName != null)
        {
            // ----判断图片名字是否带日期---开始
            if (null != urlparams[0])
            {
                String tpurldate = "";
                for (int j = 0; j < urlparams[0].length(); j++)
                {
                    if (!Character.isDigit(urlparams[0].charAt(j)))
                    {

                    }
                    else
                    {
                        tpurldate += urlparams[0].charAt(j);
                    }
                }
                iconName = tpurldate.length() == 14 ? tpurldate + iconName : iconName;
            }
            // ----判断图片名字是否带日期---结束

            String[] iconparam = urlparams[0].split("\\.");
            if (iconparam.length == 2 && !urlparams[0].toLowerCase().contains("figure"))
            {// 非截图时，采用图片名加数据库中所存图片后缀拼接组成
                urlparams[0] = iconName + "." + iconparam[1];
            }
            else if (iconparam.length != 2 && !urlparams[0].toLowerCase().contains("figure"))
            {// 广告只有路径，没有图片名
                urlparams[0] = iconName + ".jpg";
            }// 截图取原图片大小，不做处理
        }
        return urlparams;
    }

    public static String getStrKey(String[] keyStr)
    {
        StringBuffer key = new StringBuffer();
        key.append("");
        for (int i = 0; i < keyStr.length; i++)
        {
            if (Tools.isNotNull(keyStr[i]))
            {
                if (i == 0)
                {
                    key.append("mobileServer");
                    key.append("_");
                    key.append(keyStr[i]);
                }
                else
                {
                    key.append("_");
                    key.append(keyStr[i]);
                }
            }
        }
        return key.toString();
    }

    public static void main(String[] args)
    {
        init();
    }
}
