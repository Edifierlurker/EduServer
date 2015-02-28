package com.pinke.uni.mobile.protal.activity.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserScheduleActivityLS
{
    /**
     * 新增UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException;

    /**
     * 批量新增UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException;

    /**
     * 更新UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException;

    /**
     * 批量更新UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException;

    /**
     * 删除UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DomainServiceException;

    /**
     * 批量删除UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList)
            throws DomainServiceException;

    /**
     * 查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return UserScheduleActivity对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserScheduleActivity getUserScheduleActivity(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException;

    /**
     * 根据主键查询UserScheduleActivity对象
     * 
     * @param activityindex
     *            UserScheduleActivity对象主键
     * @return UserScheduleActivity对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserScheduleActivity getUserScheduleActivityByIndex(Long activityindex) throws DomainServiceException;

    /**
     * 根据条件查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException;

    /**
     * 根据条件精确查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCondExact(UserScheduleActivity userScheduleActivity)
            throws DomainServiceException;

    /**
     * 根据条件分页查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象，作为查询条件的参数
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws DomainServiceException
     *             ds异常
     */
    public TableDataInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public UserScheduleActivityExtends getUserScheduleActivityExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DomainServiceException;

    public List<UserScheduleActivity> getUserScheduleActivityByCondExtends(
            UserScheduleActivityExtends userScheduleActivity) throws DomainServiceException;
    public TableDataInfo pageInfoQueryExtends(UserScheduleActivityExtends userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

}