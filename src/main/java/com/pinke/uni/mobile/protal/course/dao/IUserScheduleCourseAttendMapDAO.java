package com.pinke.uni.mobile.protal.course.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.course.model.UserScheduleCourseAttendMap;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserScheduleCourseAttendMapDAO
{
    /**
     * 新增UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException;

    /**
     * 批量新增UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMapList
     *            UserScheduleCourseAttendMap对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException;

    /**
     * 根据主键更新UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException;

    /**
     * 根据主键批量更新UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMapList
     *            UserScheduleCourseAttendMap对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException;

    /**
     * 根据条件更新UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException;

    /**
     * 根据主键删除UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleCourseAttendMap(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException;

    /**
     * 根据主键批量删除UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMapList
     *            UserScheduleCourseAttendMap对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleCourseAttendMapList(List<UserScheduleCourseAttendMap> userScheduleCourseAttendMapList)
            throws DAOException;

    /**
     * 根据条件删除UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleCourseAttendMapByCond(UserScheduleCourseAttendMap userScheduleCourseAttendMap)
            throws DAOException;

    /**
     * 根据主键查询UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @return 满足条件的UserScheduleCourseAttendMap对象
     * @throws DAOException
     *             dao异常
     */
    public UserScheduleCourseAttendMap getUserScheduleCourseAttendMap(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException;

    /**
     * 根据条件查询UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @return 满足条件的UserScheduleCourseAttendMap对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException;

    /**
     * 根据条件精确查询UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @return 满足条件的UserScheduleCourseAttendMap对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCondExact(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException;

    /**
     * 根据条件查询UserScheduleCourseAttendMap对象
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @return 满足条件的UserScheduleCourseAttendMap对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleCourseAttendMap> getUserScheduleCourseAttendMapByCond(
            UserScheduleCourseAttendMap userScheduleCourseAttendMap, PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询UserScheduleCourseAttendMap对象，作为查询条件的参数
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize)
            throws DAOException;

    /**
     * 根据条件分页查询UserScheduleCourseAttendMap对象，作为查询条件的参数
     * 
     * @param userScheduleCourseAttendMap
     *            UserScheduleCourseAttendMap对象
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
    public PageInfo pageInfoQuery(UserScheduleCourseAttendMap userScheduleCourseAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

    public int pageInfoQueryCount(UserScheduleCourseAttendMap userScheduleCourseAttendMap) throws DAOException;

}