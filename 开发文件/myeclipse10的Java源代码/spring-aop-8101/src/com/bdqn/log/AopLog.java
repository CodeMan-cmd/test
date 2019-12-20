package com.bdqn.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopLog {
 
	
	//把这个方法作为一个增强方法   织入到目标位置（切点）
	public void xxx(){
		System.out.println("我是前置");
	}
	
	//也作为一个增强方法，但是它是在目标方法执行完  之后再执行  可以拿到目标方法的返回值 但是如果目标方法有异常  就不执行了
	public void yyy(Object re){
		System.out.println("我是 后置");
		System.out.println(re); 
		
	}
	
	//异常增强  当目标方法有异常  就执行，如果没异常  就不执行
	public void zzz(){
		System.out.println("我是 异常");
		System.out.println( );  
	}
	
	//最终增强，不管目标方法 有咩有异常 我都要执行
	public void uuu(){
		System.out.println("我是最终");
		System.out.println( );  
	}
	
	
	//环绕增强 
	public Object kkk(ProceedingJoinPoint point) throws Throwable{
		System.out.println("我是环绕");
		
		Object o = point.proceed();  //放你过去
		
		o = 100;
		
		System.out.println("我是环绕，我要完了");
		return o;
	}
	
	
}
