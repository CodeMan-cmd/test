package com.bdqn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


//定义一个日期类型转换的类  继承Converter 
//S   指的源类型, T 要转的目标类型   这是泛型参数  
public class StringToDateConvert implements Converter<String, Date>{

	private String pattern;  // yyyy-MM-dd  yyyy-MM-dd HH:mm:ss
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public Date convert(String str) {

		Date date = null;
		SimpleDateFormat  sf = new SimpleDateFormat(pattern);
		try {
			date =  sf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
