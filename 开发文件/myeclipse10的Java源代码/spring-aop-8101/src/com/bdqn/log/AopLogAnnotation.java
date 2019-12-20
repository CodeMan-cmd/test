package com.bdqn.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class AopLogAnnotation {
 
	
	//�����������Ϊһ����ǿ����   ֯�뵽Ŀ��λ�ã��е㣩
	@Pointcut("execution(* com.bdqn.service..*.*(..))")  
	public void aaa(){}
	 
	
	@Before("aaa()")
	public void xxx(){
		System.out.println("����ǰ��");
	}
	
	//Ҳ��Ϊһ����ǿ����������������Ŀ�귽��ִ����  ֮����ִ��  �����õ�Ŀ�귽���ķ���ֵ �������Ŀ�귽�����쳣  �Ͳ�ִ����
	@AfterReturning(pointcut="aaa()")
	public void yyy(){
		System.out.println("���� ����");
		System.out.println( ); 
		
	}
	
	//�쳣��ǿ  ��Ŀ�귽�����쳣  ��ִ�У����û�쳣  �Ͳ�ִ��
	@AfterThrowing(pointcut="aaa()")
	public void zzz(){
		System.out.println("���� �쳣");
		System.out.println( );  
	} 
	
	//������ǿ������Ŀ�귽�� �������쳣 �Ҷ�Ҫִ��
	@After("aaa()")
	public void uuu(){
		System.out.println("��������");
		System.out.println( );  
	}
	
	
	//������ǿ 
	@Around("aaa()")
	public Object kkk(ProceedingJoinPoint point) throws Throwable{
		System.out.println("���ǻ���");
		
		Object o = point.proceed();  //�����ȥ
		
		o = 100;
		
		System.out.println("���ǻ��ƣ���Ҫ����");
		return o;
	}  
	
	
}
