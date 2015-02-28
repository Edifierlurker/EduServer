package com.pinke.uni.lottery.http;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.DefaultProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.*;
import java.net.URLEncoder;

public class HttpClient implements Serializable {

    private static final long serialVersionUID = -176092625883595547L;
    private static final int OK = 200;                        // OK: Success!
    private static final int NOT_MODIFIED = 304;            // Not Modified: There was no new data to return.
    private static final int BAD_REQUEST = 400;                // Bad Request: The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.
    private static final int NOT_AUTHORIZED = 401;            // Not Authorized: Authentication credentials were missing or incorrect.
    private static final int FORBIDDEN = 403;                // Forbidden: The request is understood, but it has been refused.  An accompanying error message will explain why.
    private static final int NOT_FOUND = 404;                // Not Found: The URI requested is invalid or the resource requested, such as a user, does not exists.
    private static final int NOT_ACCEPTABLE = 406;        // Not Acceptable: Returned by the Search API when an invalid format is specified in the request.
    private static final int INTERNAL_SERVER_ERROR = 500;// Internal Server Error: Something is broken.  Please post to the group so the Weibo team can investigate.
    private static final int BAD_GATEWAY = 502;// Bad Gateway: Weibo is down or being upgraded.
    private static final int SERVICE_UNAVAILABLE = 503;// Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.
    private String proxyHost = Configuration.getProxyHost();
    private int proxyPort = Configuration.getProxyPort();
    private String proxyAuthUser = Configuration.getProxyUser();
    private String proxyAuthPassword = Configuration.getProxyPassword();

    org.apache.commons.httpclient.HttpClient client = null;

    private MultiThreadedHttpConnectionManager connectionManager;
    private int maxSize;

    public HttpClient() {
        this(150, 30000, 30000, 1024 * 1024);
    }

    public HttpClient(int maxConPerHost, int conTimeOutMs, int soTimeOutMs,
                      int maxSize) {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setDefaultMaxConnectionsPerHost(maxConPerHost);
        params.setConnectionTimeout(conTimeOutMs);
        params.setSoTimeout(soTimeOutMs);

        HttpClientParams clientParams = new HttpClientParams();
        // 忽略cookie 避免 Cookie rejected 警告
        clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        client = new org.apache.commons.httpclient.HttpClient(clientParams,
                connectionManager);
//        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
//        Protocol.registerProtocol("https", myhttps);
        Protocol.registerProtocol("http", new Protocol("http", new DefaultProtocolSocketFactory(), 80));
        this.maxSize = maxSize;
        // 支持proxy
        if (proxyHost != null && !proxyHost.equals("")) {
            client.getHostConfiguration().setProxy(proxyHost, proxyPort);
            client.getParams().setAuthenticationPreemptive(true);
            if (proxyAuthUser != null && !proxyAuthUser.equals("")) {
                client.getState().setProxyCredentials(
                        AuthScope.ANY,
                        new UsernamePasswordCredentials(proxyAuthUser,
                                proxyAuthPassword)
                );
            }
        }
    }

    /**
     * 处理http getmethod 请求
     */
    public String get(String url, PostParameter[] params)
            throws Exception {
        if (null != params && params.length > 0) {
            String encodedParams = HttpClient.encodeParameters(params);
            if (-1 == url.indexOf("?")) {
                url += "?" + encodedParams;
            } else {
                url += "&" + encodedParams;
            }
        }
        GetMethod getmethod = new GetMethod(url);
        return httpRequest(getmethod);

    }


    /**
     * 处理http post请求
     */
    public String post(String url, PostParameter[] params, String contenttype) throws Exception {
        PostMethod postMethod = new PostMethod(url);
        if (SnsConstants.POST_JSON.equals(contenttype)) {
            JSONObject json = new JSONObject();
            for (int i = 0; i < params.length; i++) {
                json.put(params[i].getName(), params[i].getValue());
            }
            postMethod.setRequestEntity(new StringRequestEntity(json.toString(), "application/json", "UTF-8"));
        } else {
            for (int i = 0; i < params.length; i++) {
                postMethod.addParameter(params[i].getName(), params[i].getValue());
            }
            HttpMethodParams param = postMethod.getParams();
            param.setContentCharset("UTF-8");
        }
        return httpRequest(postMethod);
    }


    public String httpRequest(HttpMethod method) throws SnsTransportException {
        int responseCode = -1;
        try {
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));
            client.executeMethod(method);
            StringBuffer responseBodyString = new StringBuffer();
            InputStream responseBodyStream = method.getResponseBodyAsStream();
            InputStreamReader reader = new InputStreamReader(responseBodyStream, "UTF-8");
            for (int c = -1; (c = reader.read()) != -1; )
                responseBodyString.append((char) c);
            responseCode = method.getStatusCode();

            if (responseCode != OK) {
                throw new SnsTransportException("http response status is " + responseCode + ", request fail!");
            }
            return responseBodyString.toString();
        } catch (IOException ioe) {
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    /*
     * 对parameters进行encode处理
     */
    public static String encodeParameters(PostParameter[] postParameter) {
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < postParameter.length; j++) {
            if (j != 0) {
                buf.append("&");
            }
            try {
                buf.append(URLEncoder.encode(postParameter[j].getName(), "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(postParameter[j].getValue(),
                                "UTF-8"));
            } catch (UnsupportedEncodingException neverHappen) {
            }
        }
        return buf.toString();
    }

    public static void main(String[] arg) throws Exception {
        HttpClient client = new HttpClient();
        String result = client.post("http://www.dongdongma.net/api/time", new PostParameter[0], SnsConstants.POST_JSON);
        System.out.println(result);
    }
}
