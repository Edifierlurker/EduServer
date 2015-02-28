package com.pinke.uni.mobile.protal.common.page.handle;

import com.meetup.memcached.MemcachedClient;
import com.pinke.uni.lottery.ParamsUtil;
import com.pinke.uni.lottery.http.HttpClient;
import com.pinke.uni.lottery.http.PostParameter;
import com.pinke.uni.mobile.protal.common.model.PageService;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 14-12-11.
 */
public class BaseServiceHandle implements IPageServiceHandle {
    private PageService pageService;

    protected ThreadLocal<String> result = new ThreadLocal<String>();

    @Override
    public IPageServiceHandle proccess(HttpServletRequest request, HttpServletResponse response) {
        return this;
    }

    protected String proccessHttpSender(String[] paramName, HttpServletRequest request, String mimetype) {
        HttpClient client = new HttpClient(150, 10000, 10000, 1024 * 1024);
        Map<String, String> requireParams = getRequireParamFromRequestMap(paramName, request);
        requireParams.put("t",System.currentTimeMillis() + "");
        Map<String, String> finalParams = ParamsUtil.paramStringToMap(ParamsUtil.generateRequestParamStr(requireParams));
        PostParameter[] postParameters = ParamsUtil.mapToPostParameter(finalParams);
        String rs = null;
        try {
            rs = client.post(this.getPageService().getPage(), postParameters, mimetype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    protected Map<String, String> getRequireParamFromRequestMap(String[] paramName, HttpServletRequest request) {
        Map<String, String> requireParams = new TreeMap<String, String>();
        for (String param : paramName) {
            String value = request.getParameter(param) == null ? (request.getAttribute(param) ==null? "" : request.getAttribute(param) + ""): request.getParameter(param) ;
            requireParams.put(param, value);
        }
        return requireParams;
    }

    protected String proccessHttpGet(String[] param,HttpServletRequest request){
        HttpClient client = new HttpClient(150, 5000, 5000, 1024 * 1024);
        Map<String,String> map = getRequireParamFromRequestMap(param,request);
        PostParameter[] params = ParamsUtil.mapToPostParameter(map);
        String rs = null;
        try {
            String url = this.getPageService().getPage();
            if (null != params && params.length > 0) {
                String encodedParams = HttpClient.encodeParameters(params);
                if (-1 == url.indexOf("?")) {
                    url += "?" + encodedParams;
                } else {
                    url += "&" + encodedParams;
                }
            }
            GetMethod getMethod = new GetMethod(url);
            getMethod.setRequestHeader("handphone",map.get("userCode"));
            getMethod.setRequestHeader("x-up-calling-line-id",map.get("userCode"));
            rs = client.httpRequest(getMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public String result() {
        return result.get();
    }

    public PageService getPageService() {
        return pageService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    protected Object getMemCachedValue(String key){
        MemcachedClient client = new MemcachedClient();
        return client.get(key);
    }

    protected boolean setMemCachedValue(String key,Object value,long time) {
        MemcachedClient client = new MemcachedClient();
        return client.set(key ,value,new Date(time * 1000));
    }
}
