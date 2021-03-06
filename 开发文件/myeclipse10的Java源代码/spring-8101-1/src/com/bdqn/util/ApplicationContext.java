package com.bdqn.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {

	
	public static Map<String,Object> maps;
	static{
		//1、加载xxx.properties
		maps = new HashMap<String,Object>();
		InputStream is = ApplicationContext.class.getClassLoader().getResourceAsStream("xxx.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(is);
			
			Enumeration<Object> keys = properties.keys();
			while(keys.hasMoreElements()){
				
				String key = (String) keys.nextElement();
				String value = (String) properties.get(key);
				
				//获取value 这个字符串  反射成一个对应的类的 元数据
				//2、把配置文件里面的对象都造出来
				Class clz = Class.forName(value);
				Object o = clz.newInstance();
				//3、放到一个容器里面去   容器  map
				maps.put(key, o );
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	 public Object getBean(String key){
		 return maps.get(key);
	 }
	
	

	
	
	
	
	
	
}
