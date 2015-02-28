package com.pinke.uni.mobile.protal.group.ls;

import java.util.List;

import com.pinke.uni.mobile.protal.group.model.TNearStudent;
import com.pinke.uni.mobile.protal.group.service.ITNearStudentDS;
import com.pinke.uni.mobile.protal.util.ObjectParmMgt;
import com.zte.misp.common.CommonErrorcode;
import com.zte.misp.common.log.Logger;
import com.zte.misp.common.log.LoggerFactory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageUtilEntity;
import com.zte.ssb.framework.exception.exceptions.DomainServiceException;

public class TNearStudentLS implements ITNearStudentLS
{

    private Logger log = LoggerFactory.getLogger("TNearStudent", TNearStudentLS.class);

    private ITNearStudentDS tnearStudentDS;

    public void setTnearStudentDS(ITNearStudentDS tnearStudentDS)
    {
        this.tnearStudentDS = tnearStudentDS;
    }

    public String insertTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        // check param
        if (null == tnearStudent)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }

        tnearStudentDS.insertTNearStudent(tnearStudent);

        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tnearStudent success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String insertTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tnearStudentList);
        if (null == tnearStudentList || tnearStudentList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tnearStudentDS.insertTNearStudentList(tnearStudentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":insert tnearStudentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        // check param
        if (tnearStudent == null || tnearStudent.getStudentindex() == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tnearStudentDS.updateTNearStudent(tnearStudent);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tnearStudent success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String updateTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tnearStudentList);
        if (null == tnearStudentList || tnearStudentList.size() == 0)
        {
            log.error("return errorCode " + CommonErrorcode.COMMON_INPUT_OBJECT_NULL + " : input param is null!");
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tnearStudentDS.updateTNearStudentList(tnearStudentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":update tnearStudentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        // check param
        if (tnearStudent == null)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tnearStudentDS.removeTNearStudent(tnearStudent);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tnearStudent success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public String removeTNearStudentList(List<TNearStudent> tnearStudentList) throws DomainServiceException
    {
        // remove null object in list
        ObjectParmMgt.removeNullForObjList(tnearStudentList);
        if (tnearStudentList == null || tnearStudentList.size() == 0)
        {
            return CommonErrorcode.COMMON_INPUT_OBJECT_NULL;
        }
        tnearStudentDS.removeTNearStudentList(tnearStudentList);
        log.debug("return errorCode:" + CommonErrorcode.COMMON_SUCCESS + ":remove tnearStudentList success");
        return CommonErrorcode.COMMON_SUCCESS;
    }

    public TNearStudent getTNearStudent(TNearStudent tnearStudent) throws DomainServiceException
    {
        // check param
        if (tnearStudent == null || tnearStudent.getStudentindex() == null)
        {
            return null;
        }
        return tnearStudentDS.getTNearStudent(tnearStudent);
    }

    public TNearStudent getTNearStudentByIndex(Long studentindex) throws DomainServiceException
    {
        // check param
        if (studentindex == null)
        {
            return null;
        }
        return tnearStudentDS.getTNearStudentByIndex(studentindex);
    }

    public List<TNearStudent> getTNearStudentByCond(TNearStudent tnearStudent) throws DomainServiceException
    {
        return tnearStudentDS.getTNearStudentByCond(tnearStudent);
    }

    public List<TNearStudent> getTNearStudentByCondExact(TNearStudent tnearStudent) throws DomainServiceException
    {
        return tnearStudentDS.getTNearStudentByCondExact(tnearStudent);
    }

    public TableDataInfo pageInfoQuery(TNearStudent tnearStudent, int start, int pageSize, PageUtilEntity puEntity)
            throws DomainServiceException
    {
        return tnearStudentDS.pageInfoQuery(tnearStudent, start, pageSize, puEntity);
    }

}
