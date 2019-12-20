package com.bdqn.controller;

/*
 * 面试题 ？？ 
 *  什么是单例模式  ：一个类只有一个对象
 *  请写出单例模式的源码  ？    如下
 *   单例模式的懒汉模式有什么问题？
 *    懒汉有线程安全问题
 *     
 *     如果解决？？
 *     加锁
 *   单例模式有6种模式，  有懒汉   饿汉
 */
public class SingleTest implements Runnable{

	public  static  SingleTest single  ;

	@Override
	public void run() {
		/*if (single == null) {
			single = new SingleTest();
		}
		System.out.println(single); */
		getInstance();
	}
	
	
	public synchronized static SingleTest getInstance() {

		if (single == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			single = new SingleTest();
		}
		System.out.println(single);
		return single;

	}
	
	public static void main(String[] args) {
		
		SingleTest test = new SingleTest();
		Thread t1 = new Thread(test, "A窗口");
		Thread t2 = new Thread(test, "B窗口");
		Thread t3 = new Thread(test, "C窗口");
	 
		t1.start();
		t2.start();
		t3.start();
	}



}
