package com.pinke.uni.mobile.protal.common.openfire;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;

public class OpenfireConnection
{
    private Log log = SSBBus.getLog(this.getClass());
    private static Connection connection;

    private ConnectionConfiguration config;

    /** openfire服务器address */

    private final static String server = ApplicationGlobalResource.getInstance().getValueByKey("openfire.url");

    public OpenfireConnection()
    {
        try
        {
            config = new ConnectionConfiguration(server, 5222);

            /** 是否启用压缩 */

            config.setCompressionEnabled(true);

            /** 是否启用安全验证 */

            config.setSASLAuthenticationEnabled(true);

            /** 是否启用调试 */

            config.setDebuggerEnabled(false);
            config.setReconnectionAllowed(true);
            config.setSendPresence(true);

            // config.setRosterLoadedAtLogin(true);

            /** 创建connection链接 */
            connection = new XMPPConnection(config);
            /** 建立连接 */
            connection.connect();
        }
        catch (Exception e)
        {
            log.error("初始化与openfire的链接");
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

}
