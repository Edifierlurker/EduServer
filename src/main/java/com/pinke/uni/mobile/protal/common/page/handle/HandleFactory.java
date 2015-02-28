package com.pinke.uni.mobile.protal.common.page.handle;

import com.pinke.uni.mobile.protal.common.model.PageService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 14-12-12.
 */
public class HandleFactory {

    private static HandleFactory instance = null;
    private static Map<String, PageService> pageServiceMap = new HashMap<String, PageService>();
    private static Map<String, IPageServiceHandle> handleMap = new ConcurrentHashMap<String, IPageServiceHandle>();

    private HandleFactory() {

    }

    public void setPageServiceMap(Map<String, PageService> pageServices) {
        pageServiceMap = pageServices;
    }


    private void init() {

    }

    public static HandleFactory getInstance() {
        if (instance == null) {
            instance = new HandleFactory();
            instance.init();
        }
        return instance;
    }

    public IPageServiceHandle getHandleInstance(String name) {
        PageService pageService = pageServiceMap.get(name);
        String className = pageService.getClasspath();
        IPageServiceHandle pageBusHandle = null;
        if (className != null)
            try {
                if (handleMap.containsKey(className))
                    return handleMap.get(className);
                else {
                    pageBusHandle = (IPageServiceHandle) Class.forName(className).newInstance();
                    pageBusHandle.setPageService(pageService);
                    handleMap.put(className, pageBusHandle);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return pageBusHandle;
    }

}
