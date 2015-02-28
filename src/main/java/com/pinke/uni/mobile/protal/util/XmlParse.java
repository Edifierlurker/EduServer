package com.pinke.uni.mobile.protal.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParse {

	/**
	 * 待解析的字符串
	 */
	private String xmlsrc = null;

	/**
	 * 文档读取类
	 */
	private Document doc = null;

	/**
	 * 构造函数
	 * 
	 * @param xmlsrc
	 *            xml字符串
	 */
	public XmlParse(String xmlsrc) {
		xmlsrc = xmlsrc.trim().replaceAll("encoding=\"UTF-8\"",
				"encoding=\"GB2312\"");
		this.xmlsrc = xmlsrc;
		inint();
	}

	/**
	 * 初始化xml配置文件
	 */
	private void inint() {
		InputStream in = new ByteArrayInputStream(xmlsrc.getBytes());
		// DOM解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// DOM解析器
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			// 文档读取类
			doc = builder.parse(in);
			// 文档规范类
			doc.normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从NODELIST读到字符串
	 * 
	 * @param list
	 *            节点列表
	 * @param tagName
	 * @param i
	 * @return String 获取的字符串 null未获取到值
	 */
	private String getListStr(NodeList list, String tagName, int i) {
		String listStr = "";
		// 获取节点
		Node child = ((Element) list.item(i)).getElementsByTagName(tagName)
				.item(0);
		// 如果节点不为空
		if (child != null) {
			// 节点下的子节点不为空
			if (child.getFirstChild() != null) {
				listStr = child.getFirstChild().getNodeValue().trim();
			}
		}
		return listStr;
	}

	/**
	 * 获取节点列表
	 * 
	 * @param parenode
	 *            父节点
	 * @param nodenamelist
	 *            待查询的节点名称
	 * @return 查询结果，多个结果
	 */
	public ArrayList<HashMap<String, String>> getnodeList(String parenode,
			ArrayList<String> nodenamelist) {
		ArrayList<HashMap<String, String>> nodelist = new ArrayList<HashMap<String, String>>();
		NodeList relist = doc.getElementsByTagName(parenode);
		for (int i = 0; i < relist.getLength(); i++) {
			HashMap<String, String> nodemap = new HashMap<String, String>();
			for (String nodename : nodenamelist) {
				String nodevalue = getListStr(relist, nodename, i);
				nodemap.put(nodename, nodevalue);
			}
			nodelist.add(nodemap);
		}
		return nodelist;
	}

	/**
	 * 通过节点名称获取节点值
	 * 
	 * @param xmlsrc
	 *            xml值
	 * @param parenode
	 *            父节点
	 * @param nodename
	 *            节点名称
	 * @return 返回信息
	 */
	public String nodeparse(String parenode, String nodename) {
		// 解析字符串
		String value = null;
		try {
			if (doc != null) {
				// 获得节点列表
				NodeList headlist = doc.getElementsByTagName(parenode);
				// 获取节点名称
				value = getListStr(headlist, nodename, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		// String xmlsrc =
		// "<?xml version=\"1.0\" encoding=\"GB2312\"?><interface-result><head><flag>00000</flag><detail>操作成功</detail>"
		// +
		// "<recordsn>EPAY100710091000000000050010</recordsn><service_code>MAP01004</service_code>"+
		// "<svcnum>000000</svcnum>"+"</head> <content><record><order_id>200003</order_id><sp_sett_id>000</sp_sett_id> <pay_state>0</pay_state>"+
		// " <order_balance>10</order_balance><order_desc>账户余额不足</order_desc><order_time>2010-07-10 11:25:03</order_time>"+
		// "<resp_time>2010-07-11 18:33:02</resp_time> <refund_state>0</refund_state></record></content></interface-result>";
		// XmlParse xmlparse = new XmlParse(xmlsrc);
		// String value = xmlparse.nodeparse("interface-result","order_desc");
		// // System.out.println(value);
		// xmlsrc =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  <interface-result>    <head>      <flag>00000</flag>      <detail>操作成功</detail>      <recordsn>EPAY100710091000000000040010</recordsn>      <service_code>MAP01003</service_code>      <svcnum>000000</svcnum>    </head>    <content>      <record>        <user_id>8adfe23c29c09e6c0129c0a6d8db0001</user_id>        <passport>paohui__07</passport>        <account_state>00</account_state>        <resp_time>2010-07-11 22:55:55</resp_time>        <account_balance>145840</account_balance>        <detail_accounts>          <detail_account>            <balance>145840</balance>            <detail_account_type>02</detail_account_type>            <desc>现金账户</desc>          </detail_account>          <detail_account>            <balance>0</balance>            <detail_account_type>03</detail_account_type>            <desc>一卡充账户</desc>          </detail_account>          <detail_account>            <balance>0</balance>            <detail_account_type>01</detail_account_type>            <desc>赠款账户</desc>          </detail_account>        </detail_accounts>      </record>    </content>  </interface-result>";
		// xmlparse = new XmlParse(xmlsrc);
		// ArrayList<String> nodenamelist = new ArrayList<String>();
		// nodenamelist.add("balance");
		// nodenamelist.add("detail_account_type");
		// nodenamelist.add("desc");
		// ArrayList<HashMap<String,String>> re =
		// xmlparse.getnodeList("detail_account",nodenamelist);
		// System.out.println(re.get(0).get("balance"));
	}
}
