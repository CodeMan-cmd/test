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
 
	
	//把这个方法作为一个增强方法   织入到目标位置（切点）
	@Pointcut("execution(* com.bdqn.service..*.*(..))")  
	public void aaa(){}
	 
	
	@Before("aaa()")
	public void xxx(){
		System.out.println("我是前置");
	}
	
	//也作为一个增强方法，但是它是在目标方法执行完  之后再执行  可以拿到目标方法的返回值 但是如果目标方法有异常  就不执行了
	@AfterReturning(pointcut="aaa()")
	public void yyy(){
		System.out.println("我是 后置");
		System.out.println( ); 
		
	}
	
	//异常增强  当目标方法有异常  就执行，如果没异常  就不执行
	@AfterThrowing(pointcut="aaa()")
	public void zzz(){
		System.out.println("我是 异常");
		System.out.println( );  
	} 
	
	//最终增强，不管目标方法 有咩有异常 我都要执行
	@After("aaa()")
	public void uuu(){
		System.out.println("我是最终");
		System.out.println( );  
	}
	
	
	//环绕增强 
	@Around("aaa()")
	public Object kkk(ProceedingJoinPoint point) throws Throwable{
		System.out.println("我是环绕");
		
		Object o = point.proceed();  //放你过去
		
		o = 100;
		
		System.out.println("我是环绕，我要完了");
		return o;
	}  
	
	
}
