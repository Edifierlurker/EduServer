package com.pinke.uni.mobile.protal.adapter.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.adapter.ls.IAppVersionmgtLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITClassinfoLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITCollegeinfoLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITMajorinfoLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITSchoolinfoHisLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITSchoolinfoLS;
import com.pinke.uni.mobile.protal.adapter.ls.ITStudentinfoLS;
import com.pinke.uni.mobile.protal.adapter.model.AppVersionmgt;
import com.pinke.uni.mobile.protal.adapter.model.TClassinfo;
import com.pinke.uni.mobile.protal.adapter.model.TCollegeinfo;
import com.pinke.uni.mobile.protal.adapter.model.TMajorinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfo;
import com.pinke.uni.mobile.protal.adapter.model.TSchoolinfoHis;
import com.pinke.uni.mobile.protal.adapter.model.TStudentinfo;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.util.AppstoreOnlineErrorCode;
import com.pinke.uni.mobile.protal.util.Blowfish;
import com.pinke.uni.mobile.protal.util.ChannelDataSourceOpenFireUtil;
import com.pinke.uni.mobile.protal.util.StoreTools;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.framework.base.PrimaryKeyGenerator;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class LoginFS implements ILoginFS
{
    private Log log = SSBBus.getLog(this.getClass());
    private ITStudentinfoLS tstudentinfoLS;
    private ITSchoolinfoLS tschoolinfoLS;
    private ITCollegeinfoLS tcollegeinfoLS;
    private ITMajorinfoLS tmajorinfoLS;
    private ITClassinfoLS tclassinfoLS;
    private ITSchoolinfoHisLS tschoolinfoHisLS;
    private IAppVersionmgtLS appVersionmgtLS;

    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    /**
     * 根据用户名查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserCode(String userCode)
    {
        TStudentinfo userinfo = new TStudentinfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserInfoByUserCode";
        if (Tools.isNull(userCode))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userCode));

        }
        if (dcValue == null || mcc == null)
        {
            log.info("*********userCode:" + userCode + "********** 查询用户个人信息memcache中无数据");
            try
            {
                userinfo = tstudentinfoLS.getTStudentinfoByUserCode(userCode);
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (userinfo != null)
                    {
                        dcValue.setMemObj(userinfo);
                        boolean success = mcc.set(new String(strKey + "_" + userCode), dcValue, new Date(
                                DCACHETIME_LEVERL1 * 1000));
                        log.info("*********userCode:" + userCode + "********** 查询用户个人信息存放memcache" + success);
                    }

                }
            }
            catch (DomainServiceException e)
            {
                log.error("根据用户手机号码查询用户个人信息异常" + e);
            }
        }
        else
        {
            userinfo = (TStudentinfo) dcValue.getMemObj();
        }
        return userinfo;

    }

    /**
     * 根据用户index查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserIndex(String userIndex)
    {
        TStudentinfo userinfo = new TStudentinfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserInfoByUserIndex";
        if (Tools.isNull(userIndex))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userIndex));

        }
        if (dcValue == null || mcc == null)
        {
            log.info("*********userIndex:" + userIndex + "********** 查询用户个人信息memcache中无数据");
            try
            {
                userinfo = tstudentinfoLS.getTStudentinfoByIndex(Long.parseLong(userIndex));
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (userinfo != null)
                    {
                        dcValue.setMemObj(userinfo);
                    }
                    else
                    {
                        dcValue.setMemObj(new TStudentinfo());
                    }
                    boolean success = mcc.set(new String(strKey + "_" + userIndex), dcValue, new Date(
                            DCACHETIME_LEVERL1 * 1000));
                    log.info("*********userCode:" + userIndex + "********** 查询用户个人信息存放memcache" + success);
                }
            }
            catch (DomainServiceException e)
            {
                log.error("根据用户index查询用户个人信息异常" + e);
            }
        }
        else
        {
            userinfo = (TStudentinfo) dcValue.getMemObj();
        }
        return userinfo;

    }

    /**
     * 根据userCode删除用户信息缓存
     * 
     * @param userCode
     */
    public void delUserInfoByUserCodeCache(String userCode)
    {
        boolean success = false;
        if (Tools.isNull(userCode))
        {
            return;
        }
        String strKey = "getUserInfoByUserCode";

        if ("true".equals(OPENFLAG) && mcc != null)
        {
            success = mcc.delete(new String(strKey + "_" + userCode));
            log.info("根据userCode删除用户信息缓存是否成功：" + success);
        }
    }

    /**
     * 根据userindex删除用户信息缓存
     * 
     * @param userCode
     */
    public void delUserInfoByUserIndexCache(String userIndex)
    {
        boolean success = false;
        if (Tools.isNull(userIndex))
        {
            return;
        }
        String strKey = "getUserInfoByUserIndex";

        if ("true".equals(OPENFLAG) && mcc != null)
        {
            success = mcc.delete(new String(strKey + "_" + userIndex));
            log.info("根据userIndex删除用户信息缓存是否成功：" + success);
        }
    }

    /**
     * 用户注册接口
     * 
     * @param userinfo
     * @return
     */
    public String signUp(String userCode, String password)
    {
        boolean openfireflag = false;
        if (Tools.isNull(userCode) || Tools.isNull(password))
        {
            return AppstoreOnlineErrorCode.CHECK_PHONENUM_FAIL;
        }
        String errorcode = AppstoreOnlineErrorCode.CHECK_SERVER_ERROR;
        TStudentinfo userinfo = new TStudentinfo();
        PrimaryKeyGenerator test = new PrimaryKeyGenerator();
        Long userid = (Long) test.getPrimarykey("t_studentinfo_userid");

        String registertime = StoreTools.getCurrentTime();
        userinfo.setUserphone(userCode);
        userinfo.setPassword(password);
        userinfo.setStudentid(userid + "");
        userinfo.setRegistertime(registertime);
        try
        {
            TStudentinfo temp = tstudentinfoLS.getTStudentinfoByUserCode(userCode);
            if (temp == null)
            {
                errorcode = tstudentinfoLS.insertTStudentinfo(userinfo);
                if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
                {
                    errorcode = AppstoreOnlineErrorCode.SUCCESS;
                    delUserInfoByUserCodeCache(userCode);
                    TStudentinfo studentinfo = this.getUserInfoByUserCode(userCode);

                    if (studentinfo != null)
                    {
                        errorcode = AppstoreOnlineErrorCode.CHECK_ERROR;

                        ChannelDataSourceOpenFireUtil dsu = new ChannelDataSourceOpenFireUtil();
                        StringBuffer sqlStr = new StringBuffer();
                        sqlStr.append("SELECT propValue FROM ofProperty t WHERE t.name= 'passwordKey' ");
                        List listMap = dsu.getList(sqlStr.toString(), new Object[] {});
                        if (listMap != null && listMap.size() > 0)
                        {
                            String[] tempResult = (String[]) listMap.get(0);
                            String keyString = tempResult[0];

                            try
                            {

                                Blowfish cipher = new Blowfish(keyString);
                                if (cipher != null)
                                {

                                    String encryptedPassword = cipher.encryptString(password);
                                    String createtime = Tools.formatDate7(new Date());
                                    StringBuffer sqlStr1 = new StringBuffer();
                                    sqlStr1.append("INSERT  INTO ofUser (username,encryptedpassword,creationDate,modificationDate) values ( '"
                                            + studentinfo.getStudentid()
                                            + "',"
                                            + "'"
                                            + encryptedPassword
                                            + "','"
                                            + createtime + "','" + createtime + "');");
                                    openfireflag = dsu.insertMess(sqlStr1.toString(), null);
                                    if (openfireflag == false)
                                    {

                                        tstudentinfoLS.removeTStudentinfo(studentinfo);
                                    }
                                    else
                                    {
                                        errorcode = AppstoreOnlineErrorCode.SUCCESS;
                                    }
                                }

                            }
                            catch (Exception e)
                            {

                                log.error(e);
                            }

                        }

                    }

                }
            }
            else
            {
                errorcode = AppstoreOnlineErrorCode.CHECK_ADD_USER;
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.error("用户注册异常", e);
        }
        delUserInfoByUserCodeCache(userCode);
        return errorcode;
    }

    /**
     * 用户登录
     * 
     * @param userCode
     * @param password
     * @return
     */
    public String login(String userCode, String password)
    {

        String errorCode = "";
        if (Tools.isNull(userCode) || Tools.isNull(password))
        {
            return AppstoreOnlineErrorCode.LOG_FAIL;
        }
        try
        {
            TStudentinfo temp = this.getUserInfoByUserCode(userCode);
            if (temp != null)
            {
                if (!password.equals(temp.getPassword()))
                {
                    errorCode = AppstoreOnlineErrorCode.PASS_ERROR;
                }
                else
                {
                    if (!"1".equals(temp.getStatus() + ""))
                    {
                        errorCode = AppstoreOnlineErrorCode.LOG_FAIL;
                    }
                    else
                    {
                        errorCode = AppstoreOnlineErrorCode.SUCCESS;
                    }
                }
            }
            else
            {
                errorCode = AppstoreOnlineErrorCode.USERNOTEXIT;
            }
        }
        catch (Exception e)
        {
            log.error("用户登录异常", e);
            errorCode = AppstoreOnlineErrorCode.CHECK_SERVER_ERROR;
        }

        return errorCode;
    }

    /**
     * 根据用户index,修改用户个人信息
     * 
     * @param userInfo
     * @return
     */
    public boolean updateUserInfo(TStudentinfo userInfo)
    {
        boolean result = false;
        if (userInfo == null || Tools.isNull(userInfo.getStudentindex() + ""))
        {
            return false;
        }
        try
        {

            String errorCode = tstudentinfoLS.updateTStudentinfo(userInfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorCode))
            {
                result = true;
                mcc.delete(new String("getUserInfoByUserCode_null_" + userInfo.getStudentindex()));
                mcc.delete(new String("getUserInfoByUserID_" + userInfo.getStudentid()));
                delUserInfoByUserCodeCache(userInfo.getUserphone());
                delUserInfoByUserIndexCache(userInfo.getStudentindex() + "");
            }

        }
        catch (DomainServiceException e)
        {
            log.error("修改用户个人信息异常" + e);
        }
        return result;
    }

    /**
     * 查询学校信息列表
     * 
     * @param tschoolinfo
     * @return
     */
    public TableDataInfo getSchoolInfoList(TSchoolinfo tschoolinfo, int page, int count)
    {
        if (tschoolinfo == null)
        {
            return null;
        }
        String strKey = "getSchoolInfoList_" + tschoolinfo.toString() + "_" + page + "_" + count;
        TableDataInfo tsList = new TableDataInfo();
        try
        {

            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            tsList = tschoolinfoLS.pageInfoQuery(tschoolinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询学校列表信息异常" + e);
        }
        return tsList;
    }

    /**
     * 查询院系列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getCollegeInfoList(TCollegeinfo tcollegeinfo, int page, int count)
    {
        if (tcollegeinfo == null)
        {
            return null;
        }
        TableDataInfo tcList = new TableDataInfo();
        try
        {

            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            tcList = tcollegeinfoLS.pageInfoQuery(tcollegeinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询院系列表信息异常" + e);
        }
        return tcList;
    }

    /**
     * 查询专业列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getMajorInfoList(TMajorinfo tmajorinfo, int page, int count)
    {
        if (tmajorinfo == null)
        {
            return null;
        }
        TableDataInfo tmList = new TableDataInfo();
        try
        {
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            tmList = tmajorinfoLS.pageInfoQuery(tmajorinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询专业列表信息异常" + e);
        }
        return tmList;
    }

    /**
     * 查询班级列表信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo getClassInfoList(TClassinfo tclassinfo, int page, int count)
    {
        if (tclassinfo == null)
        {
            return null;
        }
        TableDataInfo tcList = new TableDataInfo();
        try
        {
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            tcList = tclassinfoLS.pageInfoQuery(tclassinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询班级列表信息异常" + e);
        }
        return tcList;
    }

    /**
     * 查询学校基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TSchoolinfo getSchoolInfo(Long schoolIndex)
    {
        TSchoolinfo tschoolinfo = new TSchoolinfo();
        if (schoolIndex == null)
        {
            return null;
        }
        String strKey = "getSchoolInfo" + schoolIndex;
        List<TSchoolinfo> tsList = new ArrayList();
        try
        {
            tschoolinfo = tschoolinfoLS.getTSchoolinfoByIndex(schoolIndex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询学校信息异常" + e);
        }
        return tschoolinfo;
    }

    /**
     * 查询学校上课时间信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public List getSchoolfoExtendsList(TSchoolinfoHis tschoolinfoHis)
    {
        if (tschoolinfoHis == null || tschoolinfoHis.getSchoolindex() == null)
        {
            return null;
        }
        List<TSchoolinfoHis> tcList = new ArrayList();
        try
        {
            tcList = tschoolinfoHisLS.getTSchoolinfoHisByCond(tschoolinfoHis);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询查询学校上课时间列表信息异常" + e);
        }
        return tcList;
    }

    /**
     * 查询院系基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TCollegeinfo getCollegeInfo(Long collegeIndex)
    {
        TCollegeinfo tschoolinfo = new TCollegeinfo();
        if (collegeIndex == null)
        {
            return null;
        }
        String strKey = "getCollegeInfo_" + collegeIndex;

        try
        {
            tschoolinfo = tcollegeinfoLS.getTCollegeinfoByIndex(collegeIndex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询学校信息异常" + e);
        }
        return tschoolinfo;
    }

    /**
     * 查询专业基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TMajorinfo getMajorInfo(Long majorIndex)
    {
        TMajorinfo tschoolinfo = new TMajorinfo();
        if (majorIndex == null)
        {
            return null;
        }
        String strKey = "getMajorInfo_" + majorIndex;

        try
        {
            tschoolinfo = tmajorinfoLS.getTMajorinfoByIndex(majorIndex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询学校信息异常" + e);
        }
        return tschoolinfo;
    }

    /**
     * 查询班级基本信息
     * 
     * @param tschoolinfo
     * @return
     */
    public TClassinfo getClassInfo(Long classIndex)
    {
        TClassinfo tschoolinfo = new TClassinfo();
        if (classIndex == null)
        {
            return null;
        }
        String strKey = "getClassInfo_" + classIndex;

        try
        {
            tschoolinfo = tclassinfoLS.getTClassinfoByIndex(classIndex);
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            log.info("查询学校信息异常" + e);
        }
        return tschoolinfo;
    }

    /**
     * 搜索好友信息
     * 
     * @param tcollegeinfo
     * @return
     */
    public TableDataInfo searchUserList(String keyword, int page, int count)
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
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + keyword + "_" + page + "_" + count));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TStudentinfo tstudentinfo = new TStudentinfo();
                tstudentinfo.setUserphone(keyword);
                tstudentinfo.setStudentid(keyword);
                tstudentinfo.setStatus(1);
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tstudentinfoLS.pageInfoQuery(tstudentinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
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

                boolean success = mcc.set(new String(strKey + "_" + keyword + "_" + page + "_" + count), dcValue,
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
     * 根据用户名查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByExtends(TStudentinfo tstudentinfo)
    {
        TStudentinfo userinfo = new TStudentinfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserInfoByUserCode";
        if (Tools.isNull(tstudentinfo.getUserphone()) && Tools.isNull(tstudentinfo.getStudentindex() + ""))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + tstudentinfo.getUserphone() + "_"
                    + tstudentinfo.getStudentindex()));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                List<TStudentinfo> list = tstudentinfoLS.getTStudentinfoByCond(tstudentinfo);
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (list != null && list.size() > 0)
                    {
                        userinfo = list.get(0);
                        dcValue.setMemObj(userinfo);
                    }
                    else
                    {
                        dcValue.setMemObj(new TStudentinfo());
                    }
                    boolean success = mcc.set(new String(strKey + "_" + tstudentinfo.getUserphone() + "_"
                            + tstudentinfo.getStudentindex()), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
                }
            }
            catch (DomainServiceException e)
            {
                log.error("根据用户手机号码查询用户个人信息异常" + e);
            }
        }
        else
        {
            userinfo = (TStudentinfo) dcValue.getMemObj();
        }
        return userinfo;

    }

    /**
     * 根据用户UserID查询用户个人信息
     * 
     * @param userCode
     * @return
     */
    public TStudentinfo getUserInfoByUserID(String userID)
    {
        TStudentinfo userinfo = new TStudentinfo();
        SeriObjDCache dcValue = null;
        String strKey = "getUserInfoByUserID";
        if (Tools.isNull(userID))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + userID));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                TStudentinfo tstudentinfo = new TStudentinfo();
                tstudentinfo.setStatus(1);
                tstudentinfo.setStudentid(userID);
                List<TStudentinfo> list = tstudentinfoLS.getTStudentinfoByCondExact(tstudentinfo);
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (list != null && list.size() > 0)
                    {
                        userinfo = list.get(0);
                        dcValue.setMemObj(userinfo);
                    }
                    else
                    {
                        dcValue.setMemObj(new TStudentinfo());
                    }
                    boolean success = mcc.set(new String(strKey + "_" + userID), dcValue, new Date(
                            DCACHETIME_LEVERL1 * 1000));
                }
            }
            catch (DomainServiceException e)
            {
                log.error("根据用户userid查询用户个人信息异常" + e);
            }
        }
        else
        {
            userinfo = (TStudentinfo) dcValue.getMemObj();
        }
        return userinfo;

    }

    /**
     * 根据包名查询客户端最新的版本
     * 
     * @param userCode
     * @return
     */
    public AppVersionmgt getAppVersion(String packagename)
    {
        AppVersionmgt versionInfo = new AppVersionmgt();
        SeriObjDCache dcValue = null;
        String strKey = "getAppVersion";
        if (Tools.isNull(packagename))
        {
            return null;
        }
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + packagename));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                AppVersionmgt appVersionmgt = new AppVersionmgt();
                appVersionmgt.setStatus(1);
                appVersionmgt.setPackagename(packagename);
                appVersionmgt.setOrderCond("versioncode desc,createtime asc");
                List<AppVersionmgt> list = appVersionmgtLS.getAppVersionmgtByCond(appVersionmgt);
                ;
                if (mcc != null)
                {
                    dcValue = new SeriObjDCache();
                    if (list != null && list.size() > 0)
                    {
                        versionInfo = list.get(0);
                        dcValue.setMemObj(versionInfo);
                    }
                    else
                    {
                        dcValue.setMemObj(new TStudentinfo());
                    }
                    boolean success = mcc.set(new String(strKey + "_" + packagename), dcValue, new Date(
                            DCACHETIME_LEVERL1 * 1000));
                }
            }
            catch (DomainServiceException e)
            {
                log.error("根据包名查询客户端最新的版本异常" + e);
            }
        }
        else
        {
            versionInfo = (AppVersionmgt) dcValue.getMemObj();
        }
        return versionInfo;

    }

    public ITStudentinfoLS getTstudentinfoLS()
    {
        return tstudentinfoLS;
    }

    public void setTstudentinfoLS(ITStudentinfoLS tstudentinfoLS)
    {
        this.tstudentinfoLS = tstudentinfoLS;
    }

    public ITSchoolinfoLS getTschoolinfoLS()
    {
        return tschoolinfoLS;
    }

    public void setTschoolinfoLS(ITSchoolinfoLS tschoolinfoLS)
    {
        this.tschoolinfoLS = tschoolinfoLS;
    }

    public ITCollegeinfoLS getTcollegeinfoLS()
    {
        return tcollegeinfoLS;
    }

    public void setTcollegeinfoLS(ITCollegeinfoLS tcollegeinfoLS)
    {
        this.tcollegeinfoLS = tcollegeinfoLS;
    }

    public ITMajorinfoLS getTmajorinfoLS()
    {
        return tmajorinfoLS;
    }

    public void setTmajorinfoLS(ITMajorinfoLS tmajorinfoLS)
    {
        this.tmajorinfoLS = tmajorinfoLS;
    }

    public ITClassinfoLS getTclassinfoLS()
    {
        return tclassinfoLS;
    }

    public void setTclassinfoLS(ITClassinfoLS tclassinfoLS)
    {
        this.tclassinfoLS = tclassinfoLS;
    }

    public ITSchoolinfoHisLS getTschoolinfoHisLS()
    {
        return tschoolinfoHisLS;
    }

    public void setTschoolinfoHisLS(ITSchoolinfoHisLS tschoolinfoHisLS)
    {
        this.tschoolinfoHisLS = tschoolinfoHisLS;
    }

    public IAppVersionmgtLS getAppVersionmgtLS()
    {
        return appVersionmgtLS;
    }

    public void setAppVersionmgtLS(IAppVersionmgtLS appVersionmgtLS)
    {
        this.appVersionmgtLS = appVersionmgtLS;
    }

}