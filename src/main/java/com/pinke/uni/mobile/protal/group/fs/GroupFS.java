package com.pinke.uni.mobile.protal.group.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.common.model.PageParam;
import com.pinke.uni.mobile.protal.group.ls.ITGroupCategoryLS;
import com.pinke.uni.mobile.protal.group.ls.ITGroupCategoryMapLS;
import com.pinke.uni.mobile.protal.group.ls.ITGroupinfoAttendMapLS;
import com.pinke.uni.mobile.protal.group.ls.ITGroupinfoBulletinLS;
import com.pinke.uni.mobile.protal.group.ls.ITGroupinfoBulletinPicLS;
import com.pinke.uni.mobile.protal.group.ls.ITGroupinfoLS;
import com.pinke.uni.mobile.protal.group.ls.ITNearStudentLS;
import com.pinke.uni.mobile.protal.group.model.TGroupCategory;
import com.pinke.uni.mobile.protal.group.model.TGroupCategoryMap;
import com.pinke.uni.mobile.protal.group.model.TGroupinfo;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoAttendMap;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletin;
import com.pinke.uni.mobile.protal.group.model.TGroupinfoBulletinPic;
import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.pinke.uni.mobile.protal.util.AppstoreOnlineErrorCode;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.framework.base.PrimaryKeyGenerator;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class GroupFS implements IGroupFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private ITGroupinfoLS tgroupinfoLS;
    private ITGroupinfoAttendMapLS tgroupinfoAttendMapLS;
    private ITGroupCategoryLS tgroupCategoryLS;
    private ITGroupCategoryMapLS tgroupCategoryMapLS;
    private ITNearStudentLS tnearStudentLS;
    private ITGroupinfoBulletinLS tgroupinfoBulletinLS;
    private ITGroupinfoBulletinPicLS tgroupinfoBulletinPicLS;

    /**
     * 分页查询群组列表(按距离)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByDistance(String longitude, String latitude, int page, int count)
    {

        TableDataInfo list = null;
        // SeriObjDCache dcValue = null;
        // String strKey = "getGroupList";
        // if ("false".equals(OPENFLAG))
        // {
        // mcc = null;
        // }
        // if (mcc != null)
        // {
        // dcValue = (Object) mcc.get(new String(strKey + "_" + page + "_" + count));
        //
        // }
        //
        // if (dcValue == null || mcc == null)
        // {

        try
        {
            TGroupinfo tgroupinfo = new TGroupinfo();
            tgroupinfo.setLongitude(longitude);
            tgroupinfo.setLatitude(latitude);
            tgroupinfo.setStatus(1);
            tgroupinfo.setGrouptype(0);
            tgroupinfo.setOrderCond("DISTANCE DESC");
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = tgroupinfoLS.pageInfoQueryExtends(tgroupinfo, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // if (mcc != null)
        // {
        // boolean success = mcc.set(new String(strKey + "_" + page + "_" + count), dcValue, new Date(
        // DCACHETIME_LEVERL1 * 1000));
        // }
        // }
        // else
        // {
        // if (dcValue != null && Tools.isNotNull(dcValue.toString()))
        // {
        // list = (TableDataInfo) dcValue;
        // }
        // }
        return list;

    }

    /**
     * 新增群组
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfo insertGroupInfo(TGroupinfo tgroupinfo)
    {
        try
        {
            tgroupinfo.setStatus(1);

            PrimaryKeyGenerator test = new PrimaryKeyGenerator();
            Long groupid = (Long) test.getPrimarykey("t_groupinfo_groupid");
            System.out.println(groupid);
            tgroupinfo.setGroupid(groupid);
            String errorcode = tgroupinfoLS.insertTGroupinfo(tgroupinfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                List<TGroupinfo> list = tgroupinfoLS.getTGroupinfoByCond(tgroupinfo);
                if (list != null && list.size() > 0)
                {
                    tgroupinfo = list.get(0);
                }
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tgroupinfo;
    }

    /**
     * 修改群组信息
     * 
     * @param tgroupinfo
     * @return
     */
    public TGroupinfo updateGroupInfo(TGroupinfo tgroupinfo)
    {
        try
        {
            tgroupinfo.setStatus(1);
            String errorcode = tgroupinfoLS.updateTGroupinfo(tgroupinfo);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                List<TGroupinfo> list = tgroupinfoLS.getTGroupinfoByCond(tgroupinfo);
                if (list != null && list.size() > 0)
                {
                    tgroupinfo = list.get(0);
                }
            }
        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tgroupinfo;
    }

    /**
     * 分页查询群组列表(按搜索条件)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByKeyword(String keyword, String longitude, String latitude, int page, int count)
    {

        TableDataInfo list = new TableDataInfo();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupListByKeyword";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + keyword + "_" + page + "_" + count + "_"
                    + longitude + "_" + latitude));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfo tgroupinfo = new TGroupinfo();

                if (StringUtils.isNumeric(keyword))
                {
                    tgroupinfo.setSearchcond(keyword);
                }
                else
                {
                    tgroupinfo.setGrouptitle(keyword);
                }
                tgroupinfo.setLatitude(latitude);
                tgroupinfo.setLongitude(longitude);
                tgroupinfo.setStatus(1);
                tgroupinfo.setGrouptype(0);
                tgroupinfo.setOrderCond("DISTANCE DESC");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tgroupinfoLS.pageInfoQueryExtends(tgroupinfo, pageparam.getFirstIndex(),
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
                boolean success = mcc.set(new String(strKey + "_" + keyword + "_" + page + "_" + count + "_"
                        + longitude + "_" + latitude), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
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
     * 查询群组详情(note字段利用为等级名称)
     * 
     * @param bbsindex
     * @return
     */
    public TGroupinfo getGroupInfoByIndex(Long groupindex)
    {

        TGroupinfo tgroupinfo = new TGroupinfo();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupInfoByIndex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + groupindex));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                tgroupinfo = tgroupinfoLS.getTGroupinfoByIndex(groupindex);
            }
            catch (DomainServiceException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mcc != null)
            {
                dcValue = new SeriObjDCache();
                if (tgroupinfo != null)
                {
                    dcValue.setMemObj(tgroupinfo);
                }
                else
                {
                    dcValue.setMemObj(new TGroupinfo());
                }
                boolean success = mcc.set(new String(strKey + "_" + groupindex), dcValue, new Date(
                        DCACHETIME_LEVERL1 * 1000));
            }
        }
        else
        {
            if (dcValue != null)
            {
                tgroupinfo = (TGroupinfo) dcValue.getMemObj();
            }
        }
        return tgroupinfo;

    }

    /**
     * 查询群组成员列表
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupAttendList(Long groupindex)
    {

        List<TGroupinfoAttendMap> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupAttendList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + groupindex));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                tgroupinfoAttendMap.setGroupindex(groupindex);
                tgroupinfoAttendMap.setStatus(1);
                tgroupinfoAttendMap.setOrderCond("attendtime desc");
                list = tgroupinfoAttendMapLS.getTGroupinfoAttendMapByCond(tgroupinfoAttendMap);

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

                boolean success = mcc.set(new String(strKey + "_" + groupindex), dcValue, new Date(
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
     * 查询群组申请列表
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupApplyList(Long groupindex)
    {

        List<TGroupinfoAttendMap> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupApplyList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + groupindex));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                tgroupinfoAttendMap.setGroupindex(groupindex);
                tgroupinfoAttendMap.setStatus(2);
                tgroupinfoAttendMap.setOrderCond("attendtime desc");
                list = tgroupinfoAttendMapLS.getTGroupinfoAttendMapByCond(tgroupinfoAttendMap);

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
                boolean success = mcc.set(new String(strKey + "_" + groupindex), dcValue, new Date(
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
     * 新增群组申请者
     * 
     * @param tbbsinfo
     * @return
     */
    public String insertGroupApplyInfo(TGroupinfoAttendMap tgroupinfoAttendMap)
    {
        String result = "0";
        String errorcode = "";
        try
        {

            TGroupinfoAttendMap temp = new TGroupinfoAttendMap();
            temp.setGroupindex(tgroupinfoAttendMap.getGroupindex());
            temp.setAttendindex(tgroupinfoAttendMap.getAttendindex());
            temp = tgroupinfoAttendMapLS.getTGroupinfoAttendMap(temp);

            if (temp != null && temp.getMapindex() != null)
            {
                // if ("2".equals(temp.getStatus() + ""))
                // {
                // temp.setStatus(1);
                // String time = Tools.formatDate7(new Date());
                // temp.setAttendtime(time);
                // errorcode = tgroupinfoAttendMapLS.updateTGroupinfoAttendMap(temp);
                // }
                /**
                 * 已经申请加入群组
                 */
                if ("2".equals(temp.getStatus() + ""))
                {
                    result = "2";
                }
                /**
                 * 已经加入群组
                 */

                else if ("1".equals(temp.getStatus() + ""))
                {
                    result = "3";
                }

            }
            else
            {
                errorcode = tgroupinfoAttendMapLS.insertTGroupinfoAttendMap(tgroupinfoAttendMap);

            }

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
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
     * 新增群组参与者
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupAttendInfo(TGroupinfoAttendMap tgroupinfoAttendMap)
    {
        boolean result = false;
        String errorcode = "";
        try
        {
            if (tgroupinfoAttendMap == null)
                return false;
            /**
             * 申请加入
             */
            if (tgroupinfoAttendMap.getMapindex() != null)
            {
                tgroupinfoAttendMap.setStatus(1);
                String createtime = Tools.formatDate7(new Date());
                tgroupinfoAttendMap.setApplytime(createtime);
                errorcode = tgroupinfoAttendMapLS.updateTGroupinfoAttendMap(tgroupinfoAttendMap);
            }
            /**
             * 直接加入（群主）
             */
            else
            {
                TGroupinfoAttendMap temp = new TGroupinfoAttendMap();
                temp.setGroupindex(tgroupinfoAttendMap.getGroupindex());
                temp.setAttendindex(tgroupinfoAttendMap.getAttendindex());
                temp = tgroupinfoAttendMapLS.getTGroupinfoAttendMap(temp);

                if (temp != null && temp.getMapindex() != null)
                {
                    /**
                     * 已经申请加入群组,更新状态
                     */
                    if (!"1".equals(temp.getStatus() + ""))
                    {
                        temp.setStatus(1);
                        String createtime = Tools.formatDate7(new Date());
                        temp.setApplytime(createtime);
                        errorcode = tgroupinfoAttendMapLS.updateTGroupinfoAttendMap(temp);
                    }

                }
                /**
                 * 从未申请或加入过，新增
                 */
                else
                {
                    tgroupinfoAttendMap.setStatus(1);
                    String createtime = Tools.formatDate7(new Date());
                    tgroupinfoAttendMap.setApplytime(createtime);
                    errorcode = tgroupinfoAttendMapLS.insertTGroupinfoAttendMap(tgroupinfoAttendMap);

                }

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
     * 新增群组参与者列表
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupAttendList(List<TGroupinfoAttendMap> tgroupinfoAttendMapList)
    {
        boolean result = false;
        String errorcode = "";
        try
        {

            if (tgroupinfoAttendMapList == null || tgroupinfoAttendMapList.size() == 0)
                return false;

            errorcode = tgroupinfoAttendMapLS.insertTGroupinfoAttendMapList(tgroupinfoAttendMapList);

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
     * 拒绝群组申请
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupAttendInfo(TGroupinfoAttendMap tgroupinfoAttendMap)
    {
        boolean result = false;
        String errorcode = "";
        try
        {
            if (tgroupinfoAttendMap == null || tgroupinfoAttendMap.getMapindex() == null)
                return false;

            tgroupinfoAttendMap.setStatus(0);
            String createtime = Tools.formatDate7(new Date());
            tgroupinfoAttendMap.setApplytime(createtime);
            errorcode = tgroupinfoAttendMapLS.updateTGroupinfoAttendMap(tgroupinfoAttendMap);

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
     * 查询群组分类(一级分类)
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupCategoryList()
    {

        List<TGroupCategory> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupCategoryList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {

                TGroupCategory tgroupCategory = new TGroupCategory();
                tgroupCategory.setStatus(1);
                tgroupCategory.setCategorylevel(1);
                tgroupCategory.setOrderCond("weight asc,categoryindex desc");
                list = tgroupCategoryLS.getTGroupCategoryByCond(tgroupCategory);

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
                boolean success = mcc.set(new String(strKey), dcValue, new Date(DCACHETIME_LEVERL1 * 1000));
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
     * 查询群组分类(二级分类)
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupCategoryListByUpindex(Long upindex)
    {

        List<TGroupCategory> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getGroupCategoryListByUpindex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + upindex));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {

                TGroupCategory tgroupCategory = new TGroupCategory();
                tgroupCategory.setStatus(1);
                tgroupCategory.setCategorylevel(2);
                tgroupCategory.setCategoryupindex(upindex);
                tgroupCategory.setOrderCond("weight asc,categoryindex desc");
                list = tgroupCategoryLS.getTGroupCategoryByCond(tgroupCategory);

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
                boolean success = mcc.set(new String(strKey + "_" + upindex), dcValue, new Date(
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
     * 查询分类下的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupListByCategory(Long categoryindex, int page, int count)
    {

        TableDataInfo list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getGroupCategoryListByUpindex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + categoryindex + "_" + page + "_" + count));

        }
        if (dcValue == null || mcc == null)
        {

            try
            {

                TGroupCategoryMap tgroupCategoryMap = new TGroupCategoryMap();
                tgroupCategoryMap.setStatus(1);
                tgroupCategoryMap.setCategoryindex(categoryindex);
                tgroupCategoryMap.setOrderCond("weight asc,mapindex desc");
                PageParam pageparam = new PageParam();
                pageparam.setPageNo(page);
                pageparam.setPageSize(count);
                list = tgroupCategoryMapLS.pageInfoQuery(tgroupCategoryMap, pageparam.getFirstIndex(), pageparam
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
                boolean success = mcc.set(new String(strKey + "_" + categoryindex + "_" + page + "_" + count), dcValue,
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
     * 新增用户位置信息
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertUserSiteInfo(TNearStudent tnearStudent)
    {
        boolean result = false;
        String errorcode = "";
        if (tnearStudent == null || tnearStudent.getStudentindex() == null)
            return false;
        try
        {
            TNearStudent temp = tnearStudentLS.getTNearStudentByIndex(tnearStudent.getStudentindex());
            if (temp != null)
            {

                errorcode = tnearStudentLS.updateTNearStudent(tnearStudent);
            }
            else
            {
                errorcode = tnearStudentLS.insertTNearStudent(tnearStudent);

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
     * 删除用户位置信息
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeUserSiteInfo(Long studentindex)
    {
        boolean result = false;
        String errorcode = "";
        if (studentindex == null)
            return false;
        try
        {
            TNearStudent tnearStudent = new TNearStudent();
            tnearStudent.setStudentindex(studentindex);
            errorcode = tnearStudentLS.removeTNearStudent(tnearStudent);
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
     * 分页查询附近的人(按距离)
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getNearStudentListByDistance(TNearStudent tnearStudent, int page, int count)
    {

        TableDataInfo list = null;
        // SeriObjDCache dcValue = null;
        // String strKey = "getGroupList";
        // if ("false".equals(OPENFLAG))
        // {
        // mcc = null;
        // }
        // if (mcc != null)
        // {
        // dcValue = (Object) mcc.get(new String(strKey + "_" + page + "_" + count));
        //
        // }
        //
        // if (dcValue == null || mcc == null)
        // {

        try
        {

            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = tnearStudentLS.pageInfoQuery(tnearStudent, pageparam.getFirstIndex(), pageparam.getPageSize(),
                    new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // if (mcc != null)
        // {
        // boolean success = mcc.set(new String(strKey + "_" + page + "_" + count), dcValue, new Date(
        // DCACHETIME_LEVERL1 * 1000));
        // }
        // }
        // else
        // {
        // if (dcValue != null && Tools.isNotNull(dcValue.toString()))
        // {
        // list = (TableDataInfo) dcValue;
        // }
        // }
        return list;

    }

    /**
     * 分页查询群组公告列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getGroupBulletinList(Long groupIndex, int page, int count)
    {

        TableDataInfo list = null;
        // SeriObjDCache dcValue = null;
        // String strKey = "getGroupList";
        // if ("false".equals(OPENFLAG))
        // {
        // mcc = null;
        // }
        // if (mcc != null)
        // {
        // dcValue = (Object) mcc.get(new String(strKey + "_" + page + "_" + count));
        //
        // }
        //
        // if (dcValue == null || mcc == null)
        // {

        try
        {
            TGroupinfoBulletin tgroupinfoBulletin = new TGroupinfoBulletin();
            tgroupinfoBulletin.setGroupindex(groupIndex);
            tgroupinfoBulletin.setStatus(1);
            tgroupinfoBulletin.setOrderCond("createtime desc");
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = tgroupinfoBulletinLS.pageInfoQuery(tgroupinfoBulletin, pageparam.getFirstIndex(), pageparam
                    .getPageSize(), new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // if (mcc != null)
        // {
        // boolean success = mcc.set(new String(strKey + "_" + page + "_" + count), dcValue, new Date(
        // DCACHETIME_LEVERL1 * 1000));
        // }
        // }
        // else
        // {
        // if (dcValue != null && Tools.isNotNull(dcValue.toString()))
        // {
        // list = (TableDataInfo) dcValue;
        // }
        // }
        return list;

    }

    /**
     * 全条件查询群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfoBulletin getGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin)
    {

        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getStudentindex() == null
                || tgroupinfoBulletin.getGroupindex() == null)
            return null;
        try
        {

            List<TGroupinfoBulletin> list = tgroupinfoBulletinLS.getTGroupinfoBulletinByCond(tgroupinfoBulletin);
            if (list != null && list.size() > 0)
            {
                tgroupinfoBulletin = list.get(0);
            }
            else
            {
                tgroupinfoBulletin = null;
            }

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tgroupinfoBulletin;
    }

    /**
     * 按索引查询群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public TGroupinfoBulletin getGroupBulletin(Long bulletinidnex)
    {
        TGroupinfoBulletin tgroupinfoBulletin = null;

        try
        {

            tgroupinfoBulletin = tgroupinfoBulletinLS.getTGroupinfoBulletinByIndex(bulletinidnex);

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tgroupinfoBulletin;
    }

    /**
     * 新增群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin)
    {
        boolean result = false;
        String errorcode = "";
        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getStudentindex() == null
                || tgroupinfoBulletin.getGroupindex() == null)
            return false;
        try
        {

            errorcode = tgroupinfoBulletinLS.insertTGroupinfoBulletin(tgroupinfoBulletin);

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
     * 修改群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupBulletin(TGroupinfoBulletin tgroupinfoBulletin)
    {
        boolean result = false;
        String errorcode = "";
        if (tgroupinfoBulletin == null || tgroupinfoBulletin.getBulletinidnex() == null)
            return false;
        try
        {

            errorcode = tgroupinfoBulletinLS.updateTGroupinfoBulletin(tgroupinfoBulletin);

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
     * 删除群组公告
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeGroupBulletin(Long bulletinIndex)
    {
        boolean result = false;
        String errorcode = "";
        if (bulletinIndex == null)
            return false;
        try
        {
            TGroupinfoBulletin tgroupinfoBulletin = new TGroupinfoBulletin();
            tgroupinfoBulletin.setBulletinidnex(bulletinIndex);
            errorcode = tgroupinfoBulletinLS.removeTGroupinfoBulletin(tgroupinfoBulletin);
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
     * 查询群组公告图片
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupBulletinPicList(Long bulletinIndex)
    {

        List list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getGroupBulletinPicList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + bulletinIndex));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfoBulletinPic tgroupinfoBulletinPic = new TGroupinfoBulletinPic();
                tgroupinfoBulletinPic.setBulletinidnex(bulletinIndex);
                tgroupinfoBulletinPic.setStatus(1);
                tgroupinfoBulletinPic.setOrderCond("picindex desc");

                list = tgroupinfoBulletinPicLS.getTGroupinfoBulletinPicByCond(tgroupinfoBulletinPic);

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
                boolean success = mcc.set(new String(strKey + "_" + bulletinIndex), dcValue, new Date(
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
     * 新增群组公告图片列表
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean insertGroupBulletinPic(List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList)
    {
        boolean result = false;
        String errorcode = "";
        if (tgroupinfoBulletinPicList == null)
            return false;
        try
        {

            errorcode = tgroupinfoBulletinPicLS.insertTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);

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
     * 修改群组公告图片
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean updateGroupBulletinPic(TGroupinfoBulletinPic tgroupinfoBulletinPic)
    {
        boolean result = false;
        String errorcode = "";
        if (tgroupinfoBulletinPic == null || tgroupinfoBulletinPic.getPicindex() == null)
            return false;
        try
        {

            errorcode = tgroupinfoBulletinPicLS.updateTGroupinfoBulletinPic(tgroupinfoBulletinPic);

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
     * 删除群组公告图片
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean removeGroupBulletinPic(Long bulletinidnex)
    {
        boolean result = true;
        String errorcode = "";
        if (bulletinidnex == null)
            return false;
        try
        {
            TGroupinfoBulletinPic tgroupinfoBulletinPic = new TGroupinfoBulletinPic();
            tgroupinfoBulletinPic.setBulletinidnex(bulletinidnex);
            List<TGroupinfoBulletinPic> tgroupinfoBulletinPicList = tgroupinfoBulletinPicLS
                    .getTGroupinfoBulletinPicByCondExact(tgroupinfoBulletinPic);
            if (tgroupinfoBulletinPicList != null && tgroupinfoBulletinPicList.size() > 0)
                errorcode = tgroupinfoBulletinPicLS.removeTGroupinfoBulletinPicList(tgroupinfoBulletinPicList);
            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            result = false;
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return result;
    }

    /**
     * 退出群组
     * 
     * @param tbbsinfo
     * @return
     */
    public boolean quitGroup(TGroupinfoAttendMap tgroupinfo)
    {
        boolean result = true;
        String errorcode = "";
        if (tgroupinfo == null || tgroupinfo.getGroupindex() == null || tgroupinfo.getAttendindex() == null)
            return false;
        try
        {

            errorcode = tgroupinfoAttendMapLS.removeTGroupinfoAttendMap(tgroupinfo);

            if (CommonErrorcode.COMMON_SUCCESS.equals(errorcode))
            {
                result = true;
            }
        }
        catch (DomainServiceException e)
        {
            result = false;
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return result;
    }

    /**
     * 条件查询群组成员
     * 
     * @param bbsindex
     * @return
     */
    public List searchGroupUserList(Long groupIndx, String keyword)
    {

        if (groupIndx == null || Tools.isNull(keyword))
        {
            return null;
        }
        List list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getGroupUserList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + groupIndx + "_" + keyword));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                tgroupinfoAttendMap.setGroupindex(groupIndx);
                tgroupinfoAttendMap.setStatus(1);
                if (Tools.isNumeric(keyword))
                {
                    tgroupinfoAttendMap.setStudentid(keyword);
                }
                tgroupinfoAttendMap.setStudentname(keyword);

                list = tgroupinfoAttendMapLS.getTGroupinfoAttendMapByCondExact(tgroupinfoAttendMap);

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
                boolean success = mcc.set(new String(strKey + "_" + groupIndx + "_" + keyword), dcValue, new Date(
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
     * 条件查询群组成员
     * 
     * @param bbsindex
     * @return
     */
    public List getGroupUserList(Long groupIndx)
    {

        if (groupIndx == null)
        {
            return null;
        }
        List list = null;
        SeriObjDCache dcValue = null;
        String strKey = "getGroupUserList";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + groupIndx));

        }

        if (dcValue == null || mcc == null)
        {

            try
            {
                TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();
                tgroupinfoAttendMap.setGroupindex(groupIndx);
                tgroupinfoAttendMap.setStatus(1);
                list = tgroupinfoAttendMapLS.getTGroupinfoAttendMapByCondExact(tgroupinfoAttendMap);

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
                boolean success = mcc.set(new String(strKey + "_" + groupIndx), dcValue, new Date(
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
     * 分页查询我参加的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public TableDataInfo getAttendGroupList(Long userindex, int page, int count)
    {

        TableDataInfo list = null;
        // SeriObjDCache dcValue = null;
        // String strKey = "getGroupList";
        // if ("false".equals(OPENFLAG))
        // {
        // mcc = null;
        // }
        // if (mcc != null)
        // {
        // dcValue = (Object) mcc.get(new String(strKey + "_" + page + "_" + count));
        //
        // }
        //
        // if (dcValue == null || mcc == null)
        // {

        try
        {
            if (Tools.isNull(userindex + ""))
            {
                return null;
            }
            TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();

            tgroupinfoAttendMap.setStatus(1);
            tgroupinfoAttendMap.setAttendindex(userindex);
            tgroupinfoAttendMap.setGrouptype(0l);
            tgroupinfoAttendMap.setOrderCond("attendtime desc");
            PageParam pageparam = new PageParam();
            pageparam.setPageNo(page);
            pageparam.setPageSize(count);
            list = tgroupinfoAttendMapLS.pageInfoQuery(tgroupinfoAttendMap, pageparam.getFirstIndex(), pageparam
                    .getPageSize(), new PageUtilEntity());

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // if (mcc != null)
        // {
        // boolean success = mcc.set(new String(strKey + "_" + page + "_" + count), dcValue, new Date(
        // DCACHETIME_LEVERL1 * 1000));
        // }
        // }
        // else
        // {
        // if (dcValue != null && Tools.isNotNull(dcValue.toString()))
        // {
        // list = (TableDataInfo) dcValue;
        // }
        // }
        return list;

    }

    /**
     * 查询我参加的群组列表
     * 
     * @param bbsindex
     * @return
     */
    public List getMyChatGroupList(Long userindex)
    {

        List<TGroupinfoAttendMap> list = null;
        // SeriObjDCache dcValue = null;
        // String strKey = "getGroupList";
        // if ("false".equals(OPENFLAG))
        // {
        // mcc = null;
        // }
        // if (mcc != null)
        // {
        // dcValue = (Object) mcc.get(new String(strKey + "_" + page + "_" + count));
        //
        // }
        //
        // if (dcValue == null || mcc == null)
        // {

        try
        {
            if (Tools.isNull(userindex + ""))
            {
                return null;
            }
            TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();

            tgroupinfoAttendMap.setStatus(1);
            tgroupinfoAttendMap.setAttendindex(userindex);
            tgroupinfoAttendMap.setOrderCond("grouptype desc,attendtime desc");

            list = tgroupinfoAttendMapLS.getTGroupinfoAttendChat(tgroupinfoAttendMap);

        }
        catch (DomainServiceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // if (mcc != null)
        // {
        // boolean success = mcc.set(new String(strKey + "_" + page + "_" + count), dcValue, new Date(
        // DCACHETIME_LEVERL1 * 1000));
        // }
        // }
        // else
        // {
        // if (dcValue != null && Tools.isNotNull(dcValue.toString()))
        // {
        // list = (TableDataInfo) dcValue;
        // }
        // }
        return list;

    }

    /**
     * 修改用户群昵称
     * 
     * @param bbsindex
     * @return
     */
    public boolean updateUserGroupNickname(Long grpMapIndex, String grpNickName)
    {

        if (Tools.isNull(grpNickName) || Tools.isNull(grpMapIndex + ""))
        {
            return false;
        }

        boolean result = false;

        try
        {
            TGroupinfoAttendMap tgroupinfoAttendMap = new TGroupinfoAttendMap();

            tgroupinfoAttendMap.setMapindex(grpMapIndex);
            tgroupinfoAttendMap.setGrpnickname(grpNickName);
            String errorcode = tgroupinfoAttendMapLS.updateTGroupinfoAttendMap(tgroupinfoAttendMap);
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

    public ITGroupinfoLS getTgroupinfoLS()
    {
        return tgroupinfoLS;
    }

    public void setTgroupinfoLS(ITGroupinfoLS tgroupinfoLS)
    {
        this.tgroupinfoLS = tgroupinfoLS;
    }

    public ITGroupinfoAttendMapLS getTgroupinfoAttendMapLS()
    {
        return tgroupinfoAttendMapLS;
    }

    public void setTgroupinfoAttendMapLS(ITGroupinfoAttendMapLS tgroupinfoAttendMapLS)
    {
        this.tgroupinfoAttendMapLS = tgroupinfoAttendMapLS;
    }

    public ITGroupCategoryLS getTgroupCategoryLS()
    {
        return tgroupCategoryLS;
    }

    public void setTgroupCategoryLS(ITGroupCategoryLS tgroupCategoryLS)
    {
        this.tgroupCategoryLS = tgroupCategoryLS;
    }

    public ITGroupCategoryMapLS getTgroupCategoryMapLS()
    {
        return tgroupCategoryMapLS;
    }

    public void setTgroupCategoryMapLS(ITGroupCategoryMapLS tgroupCategoryMapLS)
    {
        this.tgroupCategoryMapLS = tgroupCategoryMapLS;
    }

    public ITNearStudentLS getTnearStudentLS()
    {
        return tnearStudentLS;
    }

    public void setTnearStudentLS(ITNearStudentLS tnearStudentLS)
    {
        this.tnearStudentLS = tnearStudentLS;
    }

    public ITGroupinfoBulletinLS getTgroupinfoBulletinLS()
    {
        return tgroupinfoBulletinLS;
    }

    public void setTgroupinfoBulletinLS(ITGroupinfoBulletinLS tgroupinfoBulletinLS)
    {
        this.tgroupinfoBulletinLS = tgroupinfoBulletinLS;
    }

    public ITGroupinfoBulletinPicLS getTgroupinfoBulletinPicLS()
    {
        return tgroupinfoBulletinPicLS;
    }

    public void setTgroupinfoBulletinPicLS(ITGroupinfoBulletinPicLS tgroupinfoBulletinPicLS)
    {
        this.tgroupinfoBulletinPicLS = tgroupinfoBulletinPicLS;
    }

}
