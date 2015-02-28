package com.pinke.uni.mobile.protal.activity.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.activity.model.UserActivityInviteMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserActivityInviteMapLS
{
    /**
     * 新增UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 批量新增UserActivityInviteMap对象
     * 
     * @param userActivityInviteMapList
     *            UserActivityInviteMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException;

    /**
     * 更新UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 批量更新UserActivityInviteMap对象
     * 
     * @param userActivityInviteMapList
     *            UserActivityInviteMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException;

    /**
     * 删除UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 批量删除UserActivityInviteMap对象
     * 
     * @param userActivityInviteMapList
     *            UserActivityInviteMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserActivityInviteMapList(List<UserActivityInviteMap> userActivityInviteMapList)
            throws DomainServiceException;

    /**
     * 查询UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @return UserActivityInviteMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserActivityInviteMap getUserActivityInviteMap(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 根据主键查询UserActivityInviteMap对象
     * 
     * @param inviteindex
     *            UserActivityInviteMap对象主键
     * @return UserActivityInviteMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserActivityInviteMap getUserActivityInviteMapByIndex(Long inviteindex) throws DomainServiceException;

    /**
     * 根据条件查询UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @return 满足条件的UserActivityInviteMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserActivityInviteMap> getUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 根据条件精确查询UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象
     * @return 满足条件的UserActivityInviteMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserActivityInviteMap> getUserActivityInviteMapByCondExact(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;

    /**
     * 根据条件分页查询UserActivityInviteMap对象
     * 
     * @param userActivityInviteMap
     *            UserActivityInviteMap对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(UserActivityInviteMap userActivityInviteMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public String updateUserActivityInviteMapByCond(UserActivityInviteMap userActivityInviteMap)
            throws DomainServiceException;
}