package com.bdqn.controller;

/*
 * ������ ���� 
 *  ʲô�ǵ���ģʽ  ��һ����ֻ��һ������
 *  ��д������ģʽ��Դ��  ��    ����
 *   ����ģʽ������ģʽ��ʲô���⣿
 *    �������̰߳�ȫ����
 *     
 *     ����������
 *     ����
 *   ����ģʽ��6��ģʽ��  ������   ����
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
		Thread t1 = new Thread(test, "A����");
		Thread t2 = new Thread(test, "B����");
		Thread t3 = new Thread(test, "C����");
	 
		t1.start();
		t2.start();
		t3.start();
	}



}
