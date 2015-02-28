package com.pinke.uni.mobile.protal.common.config;


import java.io.InputStream;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.pinke.uni.mobile.protal.util.StoreUtility;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
/**
 * 配置文件解析类
 * @author Administrator
 *
 */
public class ConfigParser {
	private Log log = SSBBus.getLog(this.getClass());
	/**
	 * 配置文件路径
	 */
//	public static final String XML_FILE =ProjectContext.getInstance().getProjectConfigFile();
	public static final String XML_FILE =StoreUtility.getWebPath()+"unistore_agent.xml";

//	public static final String XML_FILE ="F:\\work\\workspace\\appstore_agent\\WebRoot\\WEB-INF\\unistore_agent.xml";
	DocumentBuilderFactory factory = null;

	DocumentBuilder builder = null;

	Document doc = null;

	private static ConfigParser configParser;

	private static synchronized ConfigParser getConfigParser()  {
		if (configParser == null) {
			configParser = new ConfigParser();
		}
		return configParser;
	}

	public ConfigParser()  {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(XML_FILE);
		} catch (Exception e) {
			log.error("配置文件初始化失败",e);
		}
	}
	/**
	 * 构造方法
	 * @param in 输入的XML流
	 * @throws Exception
	 */
	public ConfigParser(InputStream in) throws Exception {
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		doc = builder.parse(in);
	}
	/**
	 * 获得节点值
	 * 
	 * @param elementName
	 *            节点名称
	 * @return 节点值
	 */
	public String getElement(String elementName) {
		try {
			return doc.getElementsByTagName(elementName).item(0)
					.getFirstChild().getNodeValue();
		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
	}
	/**
	 * 得到节点名
	 * @param elementName 节点名称
	 * @return
	 */
	public String[] getNodeName(String elementName) {
		try {
			NodeList nodeList = doc.getElementsByTagName(elementName).item(0)
					.getChildNodes();
			int n = nodeList.getLength();
			Vector v = new Vector();
			int nodeNum = 0;

			for (int i = 0; i < n; i++) {
				if (nodeList.item(i).getNodeType() == 1) {
					v.add(nodeList.item(i).getNodeName());
					nodeNum++;
				}
			}
			String nodeName[] = new String[nodeNum];
			for (int i = 0; i < nodeNum; i++) {
				nodeName[i] = (String) v.get(i);
				// System.out.println(nodeName[i]);
			}
			return nodeName;
		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
	}
	
	public String getSonNodeName(String nodeName, String attrSrc,
			String attrSrcValue) {
		try {
			String sonNodeName[] = this.getNodeName(nodeName);
			int n = sonNodeName.length;
			for (int i = 0; i < n; i++) {
				if (this.getNodeAtrr(sonNodeName[i], attrSrc).trim().equals(
						attrSrcValue)) {
					return sonNodeName[i];
				}
			}

		} catch (Exception ex) {

		}

		return null;
	}
	public String getSonAttr(String nodeName, String attrSrc,
			String attrSrcValue, String attrDes) {
		String nodeNameTmp = this.getSonNodeName(nodeName, attrSrc,
				attrSrcValue);
		// System.out.println(nodeNameTmp);
		if (nodeNameTmp == null) {
			return null;
		}

		return this.getNodeAtrr(nodeNameTmp, attrDes);
	}

	public String getNodeAtrr(String strNode, String strAttr) {
		try {
			Element nodeTmp = (Element) doc.getElementsByTagName(strNode).item(
					0);
			if (nodeTmp == null) {
				throw new Exception("读取节点错误");
			}
			return ((Element) nodeTmp).getAttribute(strAttr);
		} catch (Exception ex) {
			log.error(ex);
			return null;
		}

	}
	public String getFatherNodeAtrr(String strNode, String strAttr) {

		try {
			Element nodeTmp = (Element) doc.getElementsByTagName(strNode).item(
					0).getParentNode();
			if (nodeTmp == null) {
				throw new Exception("读取节点错误");
			}
			return ((Element) nodeTmp).getAttribute(strAttr);
		} catch (Exception ex) {
			log.error(ex);
			return null;
		}
	}

}
