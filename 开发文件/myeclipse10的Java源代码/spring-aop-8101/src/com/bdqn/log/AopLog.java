package com.bdqn.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopLog {
 
	
	//�����������Ϊһ����ǿ����   ֯�뵽Ŀ��λ�ã��е㣩
	public void xxx(){
		System.out.println("����ǰ��");
	}
	
	//Ҳ��Ϊһ����ǿ����������������Ŀ�귽��ִ����  ֮����ִ��  �����õ�Ŀ�귽���ķ���ֵ �������Ŀ�귽�����쳣  �Ͳ�ִ����
	public void yyy(Object re){
		System.out.println("���� ����");
		System.out.println(re); 
		
	}
	
	//�쳣��ǿ  ��Ŀ�귽�����쳣  ��ִ�У����û�쳣  �Ͳ�ִ��
	public void zzz(){
		System.out.println("���� �쳣");
		System.out.println( );  
	}
	
	//������ǿ������Ŀ�귽�� �������쳣 �Ҷ�Ҫִ��
	public void uuu(){
		System.out.println("��������");
		System.out.println( );  
	}
	
	
	//������ǿ 
	public Object kkk(ProceedingJoinPoint point) throws Throwable{
		System.out.println("���ǻ���");
		
		Object o = point.proceed();  //�����ȥ
		
		o = 100;
		
		System.out.println("���ǻ��ƣ���Ҫ����");
		return o;
	}
	
	
}
