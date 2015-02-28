package com.pinke.uni.mobile.protal.exam.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfo;
import com.pinke.uni.mobile.protal.exam.model.UserScheduleExaminfoExtends;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserScheduleExaminfoLS
{
    /**
     * 新增UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException;

    /**
     * 批量新增UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException;

    /**
     * 更新UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException;

    /**
     * 批量更新UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException;

    /**
     * 删除UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo) throws DomainServiceException;

    /**
     * 批量删除UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfoList
     *            UserScheduleExaminfo对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserScheduleExaminfoList(List<UserScheduleExaminfo> userScheduleExaminfoList)
            throws DomainServiceException;

    /**
     * 查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return UserScheduleExaminfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserScheduleExaminfo getUserScheduleExaminfo(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException;

    /**
     * 根据主键查询UserScheduleExaminfo对象
     * 
     * @param examindex
     *            UserScheduleExaminfo对象主键
     * @return UserScheduleExaminfo对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserScheduleExaminfo getUserScheduleExaminfoByIndex(Long examindex) throws DomainServiceException;

    /**
     * 根据条件查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCond(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException;

    /**
     * 根据条件精确查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象
     * @return 满足条件的UserScheduleExaminfo对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserScheduleExaminfo> getUserScheduleExaminfoByCondExact(UserScheduleExaminfo userScheduleExaminfo)
            throws DomainServiceException;

    /**
     * 根据条件分页查询UserScheduleExaminfo对象
     * 
     * @param userScheduleExaminfo
     *            UserScheduleExaminfo对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(UserScheduleExaminfo userScheduleExaminfo, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtends(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException;

    public List<UserScheduleExaminfoExtends> getUserScheduleExaminfoByCondExtendsMore(
            UserScheduleExaminfoExtends userScheduleExaminfo) throws DomainServiceException;

    public UserScheduleExaminfoExtends getUserScheduleExaminfoByIndexExtends(Long examindex)
            throws DomainServiceException;

    public TableDataInfo pageInfoQueryExtends(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException;

    public TableDataInfo pageInfoQueryExtendsMore(UserScheduleExaminfoExtends userScheduleExaminfo, int start,
            int pageSize, PageUtilEntity puEntity) throws DomainServiceException;

}