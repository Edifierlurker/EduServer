package com.pinke.uni.mobile.protal.common.servlet;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;

import com.meetup.memcached.SockIOPool;
import com.pinke.uni.mobile.protal.common.config.ConfigContent;
import com.pinke.uni.mobile.protal.common.config.ParseConfig;
import com.pinke.uni.mobile.protal.common.openfire.OpenfireConnection;
import com.pinke.uni.mobile.protal.util.ProjectContext;
import com.pinke.uni.mobile.protal.util.StoreUtil;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class InitServlet extends HttpServlet
{
    private Log log = SSBBus.getLog(this.getClass());
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 967468593411436923L;

    /**
     * @throws ServletException
     */
    public void init() throws ServletException
    {
        super.init();
        ProjectContext context = ProjectContext.getInstance();
        // =================================================
        context.setRootPath(getServletContext().getRealPath(File.separator));
        StringBuffer path = new StringBuffer(100);
        path.append(context.getRootPath()).append("WEB-INF").append(File.separator);
        context.setConfigPath(path.toString());
        // =================================================
        context.setProjectConfigFile(context.getConfigPath() + "unistore_agent.xml");
        // LoadConfig.getConfig(path.toString());

        context.setIproxyPath(context.getConfigPath());
        context.setLoggerPath(context.getConfigPath() + "");
        context.setCategory_images(context.getConfigPath() + "images" + File.separator);
        StoreUtil.init();
        // StoreCfgInfo.init();
        ConfigContent.init();
        // 配置文件
        // LoadConfig.getConfig(context.getConfigPath()+"");
        // 解析提示语配置文件
        ParseConfig.getParseConfig().parse(
                context.getConfigPath() + "source" + File.separator + ConfigContent.getXmlconfig().getSource());
        log.info("**********初始化数据成功**********");
        // 定时任务
        // TaskShedule.init();

        BasicConfigurator.configure();

        try
        {
            String server = ApplicationGlobalResource.getInstance().getValueByKey("memcache.server");
            String initConn = ApplicationGlobalResource.getInstance().getValueByKey("memcache.initCon");
            String minCon = ApplicationGlobalResource.getInstance().getValueByKey("memcache.minCon");
            String maxCon = ApplicationGlobalResource.getInstance().getValueByKey("memcache.maxCon");
            String maintSleep = ApplicationGlobalResource.getInstance().getValueByKey("memcache.maintSleep");
            String socketTO = ApplicationGlobalResource.getInstance().getValueByKey("memcache.socketTO");
            String[] servers = server.split(",");
            SockIOPool pool = SockIOPool.getInstance();
            pool.setServers(servers);
            pool.setFailover(true);
            pool.setInitConn(Tools.isNotNull(initConn) ? Integer.parseInt(initConn) : 10);
            pool.setMinConn(Tools.isNotNull(minCon) ? Integer.parseInt(minCon) : 5);
            pool.setMaxConn(Tools.isNotNull(maxCon) ? Integer.parseInt(maxCon) : 250);
            pool.setMaintSleep(Tools.isNotNull(maintSleep) ? Integer.parseInt(maintSleep) : 30);
            pool.setNagle(false);
            pool.setSocketTO(Tools.isNotNull(socketTO) ? Integer.parseInt(socketTO) : 3000);
            pool.setAliveCheck(true);
            pool.initialize();
        }
        catch (Exception e)
        {
            log.error("初始化与memcache链接失败");
        }
        new OpenfireConnection();

    }

}
