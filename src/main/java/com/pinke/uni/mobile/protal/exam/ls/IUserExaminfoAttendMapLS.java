package com.pinke.uni.mobile.protal.exam.ls;

import java.util.List;
import com.pinke.uni.mobile.protal.exam.model.UserExaminfoAttendMap;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public interface IUserExaminfoAttendMapLS
{
    /**
     * 新增UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 批量新增UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMapList
     *            UserExaminfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String insertUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException;

    /**
     * 更新UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 批量更新UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMapList
     *            UserExaminfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String updateUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException;

    /**
     * 删除UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 批量删除UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMapList
     *            UserExaminfoAttendMap对象列表
     * @throws DomainServiceException
     *             ds异常
     */
    public String removeUserExaminfoAttendMapList(List<UserExaminfoAttendMap> userExaminfoAttendMapList)
            throws DomainServiceException;

    /**
     * 查询UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @return UserExaminfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserExaminfoAttendMap getUserExaminfoAttendMap(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据主键查询UserExaminfoAttendMap对象
     * 
     * @param attendindex
     *            UserExaminfoAttendMap对象主键
     * @return UserExaminfoAttendMap对象
     * @throws DomainServiceException
     *             ds异常
     */
    public UserExaminfoAttendMap getUserExaminfoAttendMapByIndex(Long attendindex) throws DomainServiceException;

    /**
     * 根据条件查询UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @return 满足条件的UserExaminfoAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据条件精确查询UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象
     * @return 满足条件的UserExaminfoAttendMap对象集
     * @throws DomainServiceException
     *             ds异常
     */
    public List<UserExaminfoAttendMap> getUserExaminfoAttendMapByCondExact(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;

    /**
     * 根据条件分页查询UserExaminfoAttendMap对象
     * 
     * @param userExaminfoAttendMap
     *            UserExaminfoAttendMap对象，作为查询条件的参数
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
    public TableDataInfo pageInfoQuery(UserExaminfoAttendMap userExaminfoAttendMap, int start, int pageSize,
            PageUtilEntity puEntity) throws DomainServiceException;

    public String updateUserExaminfoAttendMapByCond(UserExaminfoAttendMap userExaminfoAttendMap)
            throws DomainServiceException;
}