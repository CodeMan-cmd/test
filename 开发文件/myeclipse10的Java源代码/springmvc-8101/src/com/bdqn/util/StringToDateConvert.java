package com.bdqn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


//����һ����������ת������  �̳�Converter 
//S   ָ��Դ����, T Ҫת��Ŀ������   ���Ƿ��Ͳ���  
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
