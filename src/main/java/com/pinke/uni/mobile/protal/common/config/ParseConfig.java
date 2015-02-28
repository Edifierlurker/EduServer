package com.pinke.uni.mobile.protal.common.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;


public class ParseConfig {

	private static ParseConfig config=new ParseConfig();
	
	private String className;

	public static Map<String , String> messageMaps=new HashMap<String, String>();
	
	private ParseConfig(){}
	
	public static ParseConfig getParseConfig(){
		return config;
	}
	
	public void parse(String filePath){
		Digester digester=new Digester();
		digester.push(this);
		digester.addCallMethod("messages/class/name", "addClassName",1);
		digester.addCallParam("messages/class/name", 0);
		
		digester.addCallMethod("messages/class/message/alert", "addMessage",2);
		digester.addCallParam("messages/class/message/alert", 0, "name");
		digester.addCallParam("messages/class/message/alert", 1);					
		
		try {
			digester.parse(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public void addClassName(String className){
		this.className=className;
		//System.out.println(this.className);
	}
	
	public void addMessage(String name,String message){
		String key=this.className+"."+name;
		//System.out.println(key+":"+message);
		messageMaps.put(key, message);
	}
	
//	public static void main(String[] args) {
//		String filePath=ParseConfig.class.getResource("/message_ZH.xml").getPath();
//		ParseConfig.getParseConfig().parse(filePath);
//		Map mesMap=ParseConfig.messageMaps;
//		for (int i = 1; i <= 11; i++) {
//			System.out.println(mesMap.get("AddC.acb_"+i));
//		}
//
//	}
}
