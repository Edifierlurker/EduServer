 package com.pinke.uni.mobile.protal.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectParmMgt {
	
	/** 
	 * 将src的第一个字母转换为大写，src为空时返回null  
     * @param src  
     *            源字符串  
     * @return 字符串，将src的第一个字母转换为大写，src为空时返回null 
     */  
    public static String change(String src) {   
        if (src != null) {   
            StringBuffer sb = new StringBuffer(src);   
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));   
            return sb.toString();   
        } else {   
            return null;   
        }   
    }
    
    /**
     * 将list对象中的null或空对象进行移除
     * @param objList 所要移除空对象的对象列表
     */
    @SuppressWarnings("unchecked")
	public static void removeNullForObjList(List objList) //去空操作
	{
		if(null != objList){
			// 移除list中的空对象
			for (int i = 0; i < objList.size(); i++) {
				if (objList.get(i) == null) {
					objList.remove(i);
					i--;
				}
			}
		}
	}
	 /**
     * 将list对象中的null或空对象或new一个对象但所有字段为null进行移除
     * @param objList 所要移除空对象的对象列表
     */
	@SuppressWarnings("unchecked")
	public static void removeAllNullForObjList(List objList) //去空操作
	{
		if(objList != null)
		{
			List  objNull = new ArrayList();
			Object  obj = null;
			for(int i=0;i<objList.size();i++)
			{
				obj = objList.get(i); 
				if(obj == null || "".equals(obj))
				{
					objNull.add(obj);//记下当前的为空的List，放入对象数组里面
				}
				else
				{
				    Class userClass = obj.getClass();
				    boolean flag = false;
				    //获得对象所有属性值数组
				    Field[] fields = userClass.getDeclaredFields();
			        String fdname=null;   
			        Method metd = null;   
			        // 遍历该数组
			        for (Field field : fields) 
			        { 
			            // 得到字段名
			            fdname = field.getName();
			            Object nameValue = null;
			            try
                        {
			                // 根据字段名找到对应的get方法，null表示无参数
			                metd = userClass.getMethod("get" + change(fdname)); 
			                // 调用该字段的get方法  
                            nameValue = metd.invoke(obj);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            return;
                        }       
			            if(nameValue!=null)
			            {
			                flag = true;
			            }
			        }// 遍历完所有的属性。 
			        if(!flag)
			        {
			            objNull.add(obj);//记下当前的为空的List，放入对象数组里面
			        }
				}
			}
			objList.removeAll(objNull);
		}
	}
	
	/**
	 * 对对象中的字符类型字段去前后空格处理
	 * @param o 待处理的对象
	 */
	@SuppressWarnings("unchecked")
	public static void trimForJavaBeanObject(Object o){//trim()操作
		if (o == null) {
			return;
		}
        //得到类
		Class cl = o.getClass();	
		do{
			Field[] fields = cl.getDeclaredFields();
			// 遍历该数组
			for (Field field : fields) {
				// 得到字段名
				String fdname = field.getName();
				Object nameValue = null;
				try {
					if (field.getType().equals(String.class)) {
						//根据字段名找到对应的get和set方法，null表示无参数
						Method getMetd = cl.getMethod("get" + change(fdname));
						Method setMetd = cl.getMethod("set" + change(fdname),String.class);
						// 调用该字段的get方法  
						nameValue = getMetd.invoke(o);
						if (nameValue != null && !("").equals(nameValue)) {
							nameValue = nameValue.toString().trim();
							//调用该字段的set方法
							setMetd.invoke(o, nameValue);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
			//获得父类
			cl = cl.getSuperclass();
		}while(cl != null);
		
	}
	
	
	
}
