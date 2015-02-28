package com.pinke.uni.mobile.protal.common.model;

/**
 * Created by Administrator on 14-12-31.
 */
public class PageService {

    private String servicename;

    private String classpath;

    private String page;

    private ResultType datatype;

    public ResultType getDatatype() {
        return datatype;
    }

    public void setDatatype(ResultType datatype) {
        this.datatype = datatype;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
