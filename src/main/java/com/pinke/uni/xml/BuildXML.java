package com.pinke.uni.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.zte.appsotre.xml.PageMoudle;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;

public class BuildXML {
	
	public Document doc = null;
	private Log log = SSBBus.getLog(this.getClass());
	
	public BuildXML(){
		//为创建XML作准备
		//创建DocumentBuilderFactory实例,指定DocumentBuilder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce);
			System.exit(1);
		}
		doc = db.newDocument();
		//先建立根
		Element root = doc.createElement("returnMessage");
		//根元素添加上文档
		doc.appendChild(root);
		//创建数据体
		Element data = doc.createElement("data");
		root.appendChild(data);
	}
	
	public void addRow(Element row){
		NodeList dataRows=this.doc.getElementsByTagName("data");
		Element rows=(Element)dataRows.item(0);
		rows.appendChild(row);
	}
	
	public void addPageModule(Element pageModule){
		Element eltRoot=doc.getDocumentElement();
	    eltRoot.appendChild(pageModule);
	}
	
	public void addPageModule(PageMoudle pageModule){
		if(pageModule!=null){
			Element root=doc.getDocumentElement();
			Element pageMassage = doc.createElement("pageMessage");
			root.appendChild(pageMassage);
			
			Element pageNum = doc.createElement("pageNum");
			pageMassage.appendChild(pageNum);
			Text tPageNum = doc.createTextNode(pageModule.getPageNum()+"");
			pageNum.appendChild(tPageNum);
			
			Element resultTotal = doc.createElement("resultTotal");
			pageMassage.appendChild(resultTotal);
			Text tResultTotal = doc.createTextNode(pageModule.getResultTotal()+"");
			resultTotal.appendChild(tResultTotal);
			
			Element totalCount = doc.createElement("totalCount");
			pageMassage.appendChild(totalCount);
			Text tTotalCount = doc.createTextNode(pageModule.getTotalCount()+"");
			totalCount.appendChild(tTotalCount);
			
			root.appendChild(pageMassage);
		}
	}
	
	public byte[] getXMLDatas(){
		//开始把Document映射到文件
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transFormer = null;
		try {
			transFormer = transFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			log.error("映射xml文件错误",e);
		}
        //设置输出结果
        DOMSource domSource = new DOMSource(doc);
       //设置输出源
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult xmlResult = new StreamResult(bos);
       //输出xml文件
        try {
			transFormer.transform(domSource, xmlResult);
		} catch (TransformerException e) {
			log.error("映射xml文件错误",e);
		}
		byte[] datas = bos.toByteArray();
       try {
			if(bos!=null){
				bos.reset();
				bos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public void printXMl(){
		//开始把Document映射到文件
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transFormer = null;
		try {
			transFormer = transFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			log.error("映射xml文件错误",e);
		}
        //设置输出结果
        DOMSource domSource = new DOMSource(doc);
       //设置输出源
        StreamResult xmlResult = new StreamResult(System.out);
       //输出xml文件
        try {
			transFormer.transform(domSource, xmlResult);
		} catch (TransformerException e) {
			log.error("映射xml文件错误",e);
		}
	}
}


