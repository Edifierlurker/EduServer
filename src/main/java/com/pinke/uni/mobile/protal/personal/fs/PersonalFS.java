package com.pinke.uni.mobile.protal.personal.fs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.mobile.protal.common.dcache.SeriObjDCache;
import com.pinke.uni.mobile.protal.personal.ls.IUserSchedulePrivateLS;
import com.pinke.uni.mobile.protal.personal.model.UserSchedulePrivate;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.misp.common.CommonErrorcode;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class PersonalFS implements IPersonalFS
{
    private static final String OPENFLAG = ApplicationGlobalResource.getInstance().getValueByKey("memcache.openFlag");
    private static final Long DCACHETIME_LEVERL1 = Tools.getMemcacheTime("memcache.time_level1");
    private static final Long DCACHETIME_LEVERL2 = Tools.getMemcacheTime("memcache.time_level2");
    MemcachedClient mcc = new MemcachedClient();

    private IUserSchedulePrivateLS userSchedulePrivateLS;

    /**
     * 查询用户的个人列表
     * 
     * @param userIndex
     * @return
     */
    public List getUserPersonalList(Long userIndex)
    {
        if (userIndex == null)
        {
            return null;
        }
        List<UserSchedulePrivate> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getUserPersonalList";
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
            UserSchedulePrivate userSchedulePrivate = new UserSchedulePrivate();
            userSchedulePrivate.setStudentindex(userIndex);
            userSchedulePrivate.setStatus(1);
            try
            {
                list = userSchedulePrivateLS.getUserSchedulePrivateByCond(userSchedulePrivate);
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
                boolean success = mcc.set(new String(strKey + "_" + userIndex), dcValue, new Date(
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
     * 根据个人详情index查询个人详情
     * 
     * @param userIndex
     * @return
     */
    public List getUserPersonalDetailByIndex(Long detailIndex, Long userIndex)
    {
        if (detailIndex == null)
        {
            return null;
        }
        List<UserSchedulePrivate> list = new ArrayList();
        SeriObjDCache dcValue = null;
        String strKey = "getUserPersonalDetailByIndex";
        if ("false".equals(OPENFLAG))
        {
            mcc = null;
        }
        if (mcc != null)
        {
            dcValue = (SeriObjDCache) mcc.get(new String(strKey + "_" + detailIndex + "_" + userIndex));

        }
        if (dcValue == null || mcc == null)
        {
            UserSchedulePrivate userSchedulePrivate = new UserSchedulePrivate();
            userSchedulePrivate.setPrivateindex(detailIndex);
            userSchedulePrivate.setStudentindex(userIndex);
            userSchedulePrivate.setStatus(1);
            try
            {
                list = userSchedulePrivateLS.getUserSchedulePrivateByCond(userSchedulePrivate);
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
                boolean success = mcc.set(new String(strKey + "_" + detailIndex + "_" + userIndex), dcValue, new Date(
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
     * 修改个人（包括假删除）
     * 
     * @param userSchedulePrivate
     * @return
     */
    public boolean updatePersonalDetail(UserSchedulePrivate userSchedulePrivate)
    {
        if (userSchedulePrivate == null || userSchedulePrivate.getPrivateindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userSchedulePrivateLS.updateUserSchedulePrivate(userSchedulePrivate);
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
     * 新增个人
     * 
     * @param userSchedulePrivate
     * @return
     */
    public boolean insertPersonalDetail(UserSchedulePrivate userSchedulePrivate)
    {
        if (userSchedulePrivate == null || userSchedulePrivate.getPrivateindex() == null)
        {
            return false;
        }
        boolean result = false;
        try
        {
            String errorcode = userSchedulePrivateLS.insertUserSchedulePrivate(userSchedulePrivate);
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

    public IUserSchedulePrivateLS getUserSchedulePrivateLS()
    {
        return userSchedulePrivateLS;
    }

    public void setUserSchedulePrivateLS(IUserSchedulePrivateLS userSchedulePrivateLS)
    {
        this.userSchedulePrivateLS = userSchedulePrivateLS;
    }

}
