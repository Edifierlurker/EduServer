package com.pinke.uni.lottery.http;

import com.pinke.uni.lottery.http.SnsInitException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Configuration {
    private static HashMap<String, Config> snsMap;
    private static final String configFile = "/com/zte/snsconfig.xml";
    private static GeneralConfig generalConfig = new GeneralConfig();

    static {
        init();
    }

    private Configuration() {
    }

    private static void init() {
        URL path = Configuration.class.getResource(configFile);
        SAXReader saxRea = new SAXReader();
        Document doc = null;
        try {
            try {
                doc = saxRea.read(path.toString());
            } catch (Exception e) {
                throw new SnsInitException("load snsconfig.xml fail", e);
            }
            Element element = doc.getRootElement();
            Element general = element.element("general");
            if (general != null) {
                generalConfig = new GeneralConfig();
                generalConfig.setSourceType(getTextValueByElementNString(general, "source"));
                generalConfig.setProxyHost(getTextValueByElementNString(general, "proxyhost"));
                String port = getTextValueByElementNString(general, "proxyport");
                generalConfig.setProxyPort(port == null ? 0 : Integer.parseInt(port));
                generalConfig.setProxyUser(getTextValueByElementNString(general, "proxyuser"));
                generalConfig.setProxyPassword(getTextValueByElementNString(general, "proxypassword"));
                generalConfig.setQuerybindurl(getTextValueByElementNString(general, "querybindurl"));
                generalConfig.setBindrequesturl(getTextValueByElementNString(general, "bindrequesturl"));
                generalConfig.setRestdeclaredparams(getTextValueByElementNString(general, "restdeclaredparams"));
            }
            List<Element> snsList = element.elements("sns");
            snsMap = new HashMap<String, Config>();
            if (CollectionUtils.isNotEmpty(snsList)) {
                for (Element sns : snsList) {
                    Config config = new Config();
                    String name = getTextValueByElementNString(sns, "name");
                    config.setSnsName(name);
                    String type = getTextValueByElementNString(sns, "type");
                    config.setSnsType(type);
                    config.setOpenbaseurl(getTextValueByElementNString(sns, "openbaseurl"));
                    config.setLinkuri(getTextValueByElementNString(sns, "linkuri"));
                    config.setShareuri(getTextValueByElementNString(sns, "shareuri"));
                    snsMap.put(type, config);
                }
            }
        } catch (SnsInitException e) {
            e.printStackTrace();
        }
    }

    private static String getTextValueByElementNString(Element parent, String elementName) {
        if (parent == null || elementName == null) return null;
        Element element = parent.element(elementName);
        if (element == null) return null;
        return StringUtils.isBlank(element.getTextTrim()) ? null : element.getTextTrim();
    }

    public static String getPropertyBySNSTypeAndElementNString(String snstype, String elementName) {
        if (snstype == null || elementName == null) return null;
        Config config = snsMap.get(snstype);
        if (config == null) return null;
        String val = null;
        if (elementName.equals("name"))
            val = config.getSnsName();
        if (elementName.equals("openbaseurl"))
            val = config.getOpenbaseurl();
        if (elementName.equals("linkuri"))
            val = config.getLinkuri();
        if (elementName.equals("shareuri"))
            val = config.getShareuri();
        return val;
    }

    public static String getSource() {
        return generalConfig.getSourceType();
    }

    public static String getProxyHost() {
        return generalConfig.getProxyHost();
    }

    public static int getProxyPort() {
        return generalConfig.getProxyPort();
    }

    public static String getProxyUser() {
        return generalConfig.getProxyUser();
    }

    public static String getProxyPassword() {
        return generalConfig.getProxyPassword();
    }

    public static String getQuerybindurl() {
        return generalConfig.getQuerybindurl();
    }

    public static String getBindrequesturl() {
        return generalConfig.getBindrequesturl();
    }

    public static String getRestdeclaredparams() {
        return generalConfig.getRestdeclaredparams();
    }
}
