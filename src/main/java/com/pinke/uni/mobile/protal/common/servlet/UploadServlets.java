package com.pinke.uni.mobile.protal.common.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 手机客户端上传图片
 * 
 * @author Administrator
 */
public class UploadServlets extends HttpServlet
{
    private Log log = LogFactory.getLog(UploadServlets.class);
    private static final long serialVersionUID = 1L;
    private String userPath; // 用户头像目录
    private String activityPath;// 活动目录
    private String groupPath;// 群组目录
    private String bbsPath;// 校园圈目录
    private String otherPath;// 其他目录
    private String uploadPath;
    private String tempPath; // 临时文件目录
    private String userRecordPath; // 用户语音目录

    String recordUpload;
    File tempPathFile;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        // uploadPath = config.getServletContext().getInitParameter("imageStorePath");
        // photoUpload = config.getServletContext().getInitParameter("photoUpload");
        // images_600 = config.getServletContext().getInitParameter("images_600");
        // images_258 = config.getServletContext().getInitParameter("images_258");
        // images_242 = config.getServletContext().getInitParameter("images_242");
        // images_226 = config.getServletContext().getInitParameter("images_226");
        // images_84 = config.getServletContext().getInitParameter("images_84");
        // images_60 = config.getServletContext().getInitParameter("images_60");
        // tempPath = config.getServletContext().getInitParameter("images_120");

        uploadPath = config.getServletContext().getRealPath("/") + "/upload/";
        userPath = config.getServletContext().getRealPath("/") + "/upload/" + "userUpload";
        activityPath = config.getServletContext().getRealPath("/") + "/upload/" + "activityUpload";
        groupPath = config.getServletContext().getRealPath("/") + "/upload/" + "groupUpload";
        bbsPath = config.getServletContext().getRealPath("/") + "/upload/" + "bbsUpload";
        otherPath = config.getServletContext().getRealPath("/") + "/upload/" + "otherUpload";
        tempPath = config.getServletContext().getRealPath("/") + "/upload/" + "tempPath";
        userRecordPath = config.getServletContext().getRealPath("/") + "/upload/" + "userRecord";
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists())
        {
            uploadFile.mkdirs();
        }
        File userFile = new File(userPath);
        if (!userFile.exists())
        {
            userFile.mkdirs();
        }
        File userRecordFile = new File(userRecordPath);
        if (!userRecordFile.exists())
        {
            userRecordFile.mkdirs();
        }
        File activityFile = new File(activityPath);
        if (!activityFile.exists())
        {
            activityFile.mkdirs();
        }
        File groupFile = new File(groupPath);
        if (!groupFile.exists())
        {
            groupFile.mkdirs();
        }
        File bbsFile = new File(bbsPath);
        if (!bbsFile.exists())
        {
            bbsFile.mkdirs();
        }
        File otherFile = new File(otherPath);
        if (!otherFile.exists())
        {
            otherFile.mkdirs();
        }
        File tempPathFile = new File(tempPath);
        if (!tempPathFile.exists())
        {
            tempPathFile.mkdirs();
        }
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        JSONObject resultJobj = new JSONObject();
        try
        {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(10240); // 设置缓冲区大小，这里是10kb
            factory.setRepository(tempPathFile);// 设置缓冲区目录

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(10485760); // 设置最大文件尺寸，这里是10MB
            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
            Iterator<FileItem> i = items.iterator();
            /**
             * 头像：1; 活动封面：2 ;群组：3; bbs：4;其他：6; 用户语音介绍:5;
             */
            String uploadType = "1";
            while (i.hasNext())
            {
                FileItem fi = (FileItem) i.next();
                if (fi.isFormField())
                {
                    uploadType = fi.getString();
                }
                String fileName = fi.getName();
                if (fileName != null && "1".equals(uploadType))
                {
                    // 保存头像
                    File savedFile = new File(userPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端修改头像上传成功!");
                }
                else if (fileName != null && "2".equals(uploadType))
                {

                    File savedFile = new File(activityPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端上传活动封面成功!");
                }
                else if (fileName != null && "3".equals(uploadType))
                {
                    File savedFile = new File(groupPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端上传群组图片成功!");
                }
                else if (fileName != null && "4".equals(uploadType))
                {
                    File savedFile = new File(bbsPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端上传bbs图片成功!");
                }
                else if (fileName != null && "5".equals(uploadType))
                {
                    File savedFile = new File(userRecordPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端上传用户语音介绍成功!");
                }
                else if (fileName != null && "6".equals(uploadType))
                {
                    File savedFile = new File(otherPath, fi.getFieldName());
                    fi.write(savedFile);
                    log.info("手机客户端上传其他图片成功!");
                }

            }
            resultJobj.put("result", "0");
            resultJobj.put("desc", "");
        }
        catch (Exception e)
        {
            resultJobj.put("result", "1");
            resultJobj.put("desc", "服务器内部错误");
            log.error("手机客户端上传图片出现错误，UploadServlets doPost", e);

        }
        finally
        {
            try
            {
                // 数据加密操作
                // String jobjStr = SendUtil.encrypt(json);
                byte[] send = resultJobj.toString().getBytes("UTF-8");
                response.setContentLength(send.length);
                ServletOutputStream out = response.getOutputStream();
                out.write(send);
                out.flush();
                out.close();
                log.info("发送数据成功，长度：" + send.length);
            }
            catch (IOException e)
            {
                log.error("发送数据错误，客户端已关闭连接" + e.getMessage());
            }
        }

    }

}
