package com.pinke.uni.mobile.protal.exam.dao;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DAOException;

public interface IUserScheduleExaminfoDAO
{
    /**
     * 新增UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 批量新增UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void insertUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException;

    /**
     * 根据主键更新UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 根据主键批量更新UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException;

    /**
     * 根据条件更新UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo更新条件
     * @throws DAOException
     *             dao异常
     */
    public void updateUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 根据主键删除UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 根据主键批量删除UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList) throws DAOException;

    /**
     * 根据条件删除UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo删除条件
     * @throws DAOException
     *             dao异常
     */
    public void deleteUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 根据主键查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象
     * @throws DAOException
     *             dao异常
     */
    public UserScheduleExaminfo getUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DAOException;

    /**
     * 根据条件查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DAOException;

    /**
     * 根据条件精确查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象集
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCondExact(UserScheduleExaminfo userScheduleExaminfo)
            throws DAOException;

    /**
     * 根据条件查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象集
     * @param puEntity
     *            排序控制参数@see PageUtilEntity
     * @throws DAOException
     *             dao异常
     */
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo,
            PageUtilEntity puEntity) throws DAOException;

    /**
     * 根据条件分页查询UserScheduleExaminfo对象，作为查询条件的参数
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @param start
     *            起始行
     * @param pageSize
     *            页面大小
     * @return 查询结果
     * @throws DAOException
     *             dao异常
     */
    public PageInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize)
            throws DAOException;

    /**
     * 根据条件分页查询UserScheduleExaminfo对象，作为查询条件的参数
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
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
    public PageInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtends(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DAOException;

    /**
     * 查询用户已经参加的考试列表
     * 
     * @param userScheduleExaminfo
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtendsMore(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DAOException;

    public UserScheduleExaminfoExtends getUserScheduleExaminfoExtends(UserScheduleExaminfoExtends userScheduleExaminfo)
            throws DAOException;

    @SuppressWarnings("unchecked")
    public PageInfo pageInfoQueryExtends(UserScheduleExaminfoExtends userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

    public PageInfo pageInfoQueryExtendsMore(UserScheduleExaminfoExtends userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DAOException;

}