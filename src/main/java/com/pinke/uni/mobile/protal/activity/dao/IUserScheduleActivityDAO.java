package com.pinke.uni.mobile.protal.activity.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivity;
import com.pinke.uni.mobile.protal.activity.model.UserScheduleActivityExtends;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserScheduleActivityDAO
{
    /**
     * 新增UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 批量新增UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException;

    /**
     * 根据主键更新UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 根据主键批量更新UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException;

    /**
     * 根据条件更新UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 根据主键删除UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 根据主键批量删除UserScheduleActivity对象
     * 
     * @param userScheduleActivityList
     *            UserScheduleActivity对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleActivityList(List<UserScheduleActivity> userScheduleActivityList) throws DAOException;

    /**
     * 根据条件删除UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 根据主键查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象
     * @throws DAOException
     *             dao异常
     */
    public UserScheduleActivity getUserScheduleActivity(UserScheduleActivity userScheduleActivity) throws DAOException;

    /**
     * 根据条件查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity)
            throws DAOException;

    /**
     * 根据条件精确查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCondExact(UserScheduleActivity userScheduleActivity)
            throws DAOException;

    /**
     * 根据条件查询UserScheduleActivity对象
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @return 满足条件的UserScheduleActivity对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCond(UserScheduleActivity userScheduleActivity,
            PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询UserScheduleActivity对象，作为查询条件的参数
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize)
            throws DAOException;

    /**
     * 根据条件分页查询UserScheduleActivity对象，作为查询条件的参数
     * 
     * @param userScheduleActivity
     *            UserScheduleActivity对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(UserScheduleActivity userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

    /**
     * 查询活动详情
     */
    public UserScheduleActivityExtends getUserScheduleActivityExtends(UserScheduleActivityExtends userScheduleActivity)
            throws DAOException;

    /**
     * 查询用户参与的活动列表
     * 
     * @param userScheduleActivity
     * @return
     * @throws DAOException
     */
    public List<UserScheduleActivity> getUserScheduleActivityByCondExtends(
            UserScheduleActivityExtends userScheduleActivity) throws DAOException;

    /**
     * 查询用户参与的活动列表(分页)
     * 
     * @param userScheduleActivity
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(UserScheduleActivityExtends userScheduleActivity, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;
}