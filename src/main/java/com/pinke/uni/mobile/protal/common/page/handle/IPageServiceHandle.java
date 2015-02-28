package com.pinke.uni.mobile.protal.common.page.handle;

import com.pinke.uni.mobile.protal.common.model.PageService;
import com.pinke.uni.mobile.protal.common.model.ResultType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 14-12-10.
 */
public interface IPageServiceHandle {

    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response);

    public String result();

    public void setPageService(PageService pageService);

    public PageService getPageService();
}
