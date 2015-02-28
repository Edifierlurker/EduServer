package com.pinke.uni.mobile.protal.activity.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMap;
import com.pinke.uni.mobile.protal.activity.model.UserActivityAttendMapExtends;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserActivityAttendMapLS
{
    /**
     * 新增UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;

    /**
     * 批量新增UserActivityAttendMap对象
     * 
     * @param userActivityAttendMapList
     *            UserActivityAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException;

    /**
     * 更新UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;

    /**
     * 批量更新UserActivityAttendMap对象
     * 
     * @param userActivityAttendMapList
     *            UserActivityAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException;

    /**
     * 删除UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;

    /**
     * 批量删除UserActivityAttendMap对象
     * 
     * @param userActivityAttendMapList
     *            UserActivityAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserActivityAttendMapList(List<UserActivityAttendMap> userActivityAttendMapList)
            throws DomainServiceException;

    /**
     * 查询UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @return UserActivityAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserActivityAttendMap getUserActivityAttendMap(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;

    /**
     * 根据主键查询UserActivityAttendMap对象
     * 
     * @param attendindex
     *            UserActivityAttendMap对象主键
     * @return UserActivityAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserActivityAttendMap getUserActivityAttendMapByIndex(Long attendindex) throws DomainServiceException;

    /**
     * 根据条件查询UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @return 满足条件的UserActivityAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserActivityAttendMapExtends> getUserActivityAttendMapByCond(
            UserActivityAttendMapExtends userActivityAttendMap) throws DomainServiceException;

    /**
     * 根据条件精确查询UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象
     * @return 满足条件的UserActivityAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserActivityAttendMap> getUserActivityAttendMapByCondExact(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;

    /**
     * 根据条件分页查询UserActivityAttendMap对象
     * 
     * @param userActivityAttendMap
     *            UserActivityAttendMap对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(UserActivityAttendMap userActivityAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public String updateUserActivityAttendMapByCond(UserActivityAttendMap userActivityAttendMap)
            throws DomainServiceException;
}