package com.pinke.uni.mobile.protal.common.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

import com.pinke.uni.mobile.protal.common.openfire.OpenfireConnection;
import com.pinke.uni.mobile.protal.util.Tools;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class TestServlet extends HttpServlet
{
    private Log log = SSBBus.getLog(this.getClass());
    private static final long serialVersionUID = 3382908901985009755L;

    private Connection connection;

    private ConnectionConfiguration config;

    /** openfire服务器address */

    private final static String server = "10.46.178.11";

    private final void fail(Object o)
    {

        if (o != null)
        {

            System.out.println(o);

        }

    }

    private final void fail(Object o, Object... args)
    {

        if (o != null && args != null && args.length > 0)
        {
            String s = o.toString();

            for (int i = 0; i < args.length; i++)
            {
                String item = args[i] == null ? "" : args[i].toString();

                if (s.contains("{" + i + "}"))
                {

                    s = s.replace("{" + i + "}", item);

                }
                else
                {

                    s += " " + item;

                }
            }
        }

    }

    /**
     * Constructor of the object.
     */
    public TestServlet()
    {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

         broadcast();
//        createRoom();
        // ChatManager chatManager = connection.getChatManager();

        // AccountManager accountManager = connection.getAccountManager();
        // for (String attr : accountManager.getAccountAttributes()) {
        // fail("AccountAttribute: {0}", attr);
        // }
        // fail("AccountInstructions: {0}", accountManager.getAccountInstructions());
        //
        // fail("supportsAccountCreation: {0}", accountManager.supportsAccountCreation());
        // try {
        // /** 创建一个用户boy，密码为boy；你可以在管理员控制台页面http://192.168.8.32:9090/user-summary.jsp查看用户/组的相关信息，来查看是否成功创建用户 */
        // accountManager.createAccount("cui007", "111111");
        // // /** 修改密码 */
        // // accountManager.changePassword("abc");
        // } catch (XMPPException e) {
        // e.printStackTrace();
        // }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        doGet(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     * 
     * @throws ServletException
     *             if an error occurs
     */
    public void init() throws ServletException
    {
        // broadcast();
    }

    // try
    // {
    //
    // // connection = new XMPPConnection(server);
    //
    // // connection.connect();
    //
    // /** 5222是openfire服务器默认的通信端口，你可以登录http://192.168.8.32:9090/到管理员控制台查看客户端到服务器端口 */
    //
    // config = new ConnectionConfiguration(server, 5222);
    //
    // /** 是否启用压缩 */
    //
    // config.setCompressionEnabled(true);
    //
    // /** 是否启用安全验证 */
    //
    // config.setSASLAuthenticationEnabled(true);
    //
    // /** 是否启用调试 */
    //
    // config.setDebuggerEnabled(false);
    // config.setReconnectionAllowed(true);
    // config.setSendPresence(true);
    //
    // // config.setReconnectionAllowed(true);
    //
    // // config.setRosterLoadedAtLogin(true);
    //
    // /** 创建connection链接 */
    //
    // connection = new XMPPConnection(config);
    //
    // /** 建立连接 */
    //
    // connection.connect();
    // connection.login("boy", "boy");
    // // fail(connection);
    // //
    // // fail(connection.getConnectionID());
    //
    // }
    // catch (XMPPException e)
    // {
    //
    // e.printStackTrace();
    //
    // }
    //
    // }

    public void broadcast()
    {
        Connection connection = OpenfireConnection.getConnection();
        if (connection != null)
        {
            String loginUser = connection.getUser();
            if (Tools.isNull(loginUser))
            {
                try
                {
                    connection.login("10000008", "c4ca4238a0b923820dcc509a6f75849b");
                    Presence presence = new Presence(Presence.Type.available); 
                    connection.sendPacket(presence);  


//                    connection.login("uniadmin", "111111");
                }
                catch (XMPPException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            Message newmsg = new Message();
            // newmsg.setTo("reg7@"+ connection.getServiceName());
            newmsg.setTo("all@broadcast." + connection.getServiceName());
            newmsg.setSubject("重要通知");
            newmsg.setBody("吃饭啦！");
            newmsg.setFrom("admin");
            newmsg.setType(Message.Type.normal);// normal支持离线
            connection.sendPacket(newmsg);
        }
        else
        {

            new OpenfireConnection();

        }
    }

    public void createRoom()
    {
        Connection connection = OpenfireConnection.getConnection();
        if (connection != null)
        {
            String loginUser = connection.getUser();
            if (Tools.isNull(loginUser))
            {
                try
                {
                    connection.login("uniadmin", "111111");
                }
                catch (XMPPException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            RoomInfo rooms = null;
            try
            {

                try
                {
                    rooms = MultiUserChat.getRoomInfo(connection, "test" + "@conference."
                            + connection.getServiceName());
                }
                catch (XMPPException e)
                {
                    if ("item-not-found(404)".equals(e.getMessage()))
                    {
                        rooms = null;
                    }
                }

                if (rooms == null)
                {
                    MultiUserChat muc = new MultiUserChat(connection, "test@conference."
                            + connection.getServiceName());
                    muc.create("group");
                    Form form = muc.getConfigurationForm();

                    // 根据原始表单创建一个要提交的新表单。
                    Form submitForm = form.createAnswerForm();
                    // 向要提交的表单添加默认答复
                    for (Iterator fields = form.getFields(); fields.hasNext();)
                    {
                        FormField field = (FormField) fields.next();
                        if (!FormField.TYPE_HIDDEN.equals(field.getType()) && field.getVariable() != null)
                        {
                            // 设置默认值作为答复
                            submitForm.setDefaultAnswer(field.getVariable());
                        }
                    }
                    // 设置聊天室是持久聊天室，即将要被保存下来
                    submitForm.setAnswer("muc#roomconfig_persistentroom", true);
                    muc.sendConfigurationForm(submitForm);
                }
            }
            catch (XMPPException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void creatMultiRoom()
    {
        try
        {
            // connection.login("boy", "boy");
            // AccountManager accountManager = connection.getAccountManager();
            // String test = accountManager.getAccountAttribute("username");
            // boolean test1 = MultiUserChat.isServiceEnabled(this.connection, "myroom9@conference." +
            // connection.getServiceName());
            // boolean test2 = MultiUserChat.isServiceEnabled(this.connection, "myroom12@conference." +
            // connection.getServiceName());
            // MultiUserChat.getHostedRooms(this.connection, "");
            //
            // RoomInfo rooms = MultiUserChat.getRoomInfo(this.connection, "myroom9@conference." +
            // connection.getServiceName());
            //
            // System.out.println("test");

            // connection.login("boy", "boy");

            // // 使用XMPPConnection创建一个MultiUserChat
            // MultiUserChat muc = new MultiUserChat(this.connection, "myroom9@conference." +
            // connection.getServiceName());
            //
            //
            //
            // //
            // // // 创建聊天室
            // // muc.create("testbot1");
            // // // 获得聊天室的配置表单
            // Form form = muc.getConfigurationForm();
            // // 根据原始表单创建一个要提交的新表单。
            // Form submitForm = form.createAnswerForm();
            // // 向要提交的表单添加默认答复
            // for (Iterator fields = form.getFields(); fields.hasNext();)
            // {
            // FormField field = (FormField) fields.next();
            // if (!FormField.TYPE_HIDDEN.equals(field.getType()) && field.getVariable() != null)
            // {
            // // 设置默认值作为答复
            // submitForm.setDefaultAnswer(field.getVariable());
            // }
            // }
            // // 设置聊天室的新拥有者
            // // List owners = new ArrayList();
            // // owners.add("liaonaibo2\\40slook.cc");
            // // owners.add("liaonaibo1\\40slook.cc");
            // // submitForm.setAnswer("muc#roomconfig_roomowners", owners);
            // // 设置聊天室是持久聊天室，即将要被保存下来
            // submitForm.setAnswer("muc#roomconfig_persistentroom", true);
            // // // 房间仅对成员开放
            // // submitForm.setAnswer("muc#roomconfig_membersonly", false);
            // // // 允许占有者邀请其他人
            // // submitForm.setAnswer("muc#roomconfig_allowinvites", true);
            // // // 能够发现占有者真实 JID 的角色
            // // // submitForm.setAnswer("muc#roomconfig_whois", "anyone");
            // // // 登录房间对话
            // // submitForm.setAnswer("muc#roomconfig_enablelogging", true);
            // // // 仅允许注册的昵称登录
            // // submitForm.setAnswer("x-muc#roomconfig_reservednick", true);
            // // // 允许使用者修改昵称
            // // submitForm.setAnswer("x-muc#roomconfig_canchangenick", false);
            // // // 允许用户注册房间
            // // submitForm.setAnswer("x-muc#roomconfig_registration", false);
            // // 发送已完成的表单（有默认值）到服务器来配置聊天室
            //
            // muc.sendConfigurationForm(submitForm);
            // muc.invite("reg7@"+ connection.getServiceName(), "tttttttttt");
            // muc.join("reg7@"+ connection.getServiceName());
            // muc.join("reg8@"+ connection.getServiceName());
            // muc.sendMessage("push");
            //
            // ChatManager chatManager = connection.getChatManager();
            // chatManager.createChat("reg7@"+ connection.getServiceName(),null).sendMessage("ssssssssssss");
            //
            // connection.loginAnonymously();
            Message newmsg = new Message();
            // newmsg.setTo("reg7@"+ connection.getServiceName());
            newmsg.setTo("all@broadcast." + connection.getServiceName());
            newmsg.setSubject("重要通知");
            newmsg.setBody("吃饭啦！");
            newmsg.setFrom("admin");
            newmsg.setType(Message.Type.normal);// normal支持离线
            connection.sendPacket(newmsg);

            // connection.disconnect();

            //
            //
            // // muc.invite("reg7@"+ connection.getServiceName(), "tttttttttt");
            // muc.join("reg7@"+ connection.getServiceName());
            // muc.sendMessage("push");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
