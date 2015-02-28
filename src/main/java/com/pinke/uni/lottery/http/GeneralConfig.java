package com.pinke.uni.lottery.http;

public class GeneralConfig {
    private String sourceType;
    private String proxyHost;
    private int proxyPort;
    private String proxyUser;
    private String proxyPassword;
    private String querybindurl;
    private String bindrequesturl;
    private String restdeclaredparams;

    public String getRestdeclaredparams() {
        return restdeclaredparams;
    }

    public void setRestdeclaredparams(String restdeclaredparams) {
        this.restdeclaredparams = restdeclaredparams;
    }

    public String getBindrequesturl() {
        return bindrequesturl;
    }

    public void setBindrequesturl(String bindrequesturl) {
        this.bindrequesturl = bindrequesturl;
    }

    public String getQuerybindurl() {
        return querybindurl;
    }

    public void setQuerybindurl(String querybindurl) {
        this.querybindurl = querybindurl;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return "source: " + sourceType + "\n\r"
                + "bindreuqesturl: " + bindrequesturl + "\n\r"
                + "querybindurl: " + querybindurl + "\n\r"
                + "host: " + proxyHost + "\n\r"
                + "port: " + proxyPort + "\n\r"
                + "user: " + proxyUser + "\n\r"
                + "password: " + proxyPassword;
    }
}