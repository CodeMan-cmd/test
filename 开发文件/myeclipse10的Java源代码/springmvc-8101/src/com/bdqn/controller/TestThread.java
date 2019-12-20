package com.bdqn.controller;

public class TestThread implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {

		while (true) {
			synchronized (this) { 
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "卖了第"
							+ ticket + "张票");
					ticket = ticket - 1;

				} else {
					break;
				}
			}

		}

	}

	public static void main(String[] args) {

		TestThread test = new TestThread();
		Thread t1 = new Thread(test, "A窗口");
		Thread t2 = new Thread(test, "B窗口");
		Thread t3 = new Thread(test, "C窗口");

		t1.start();
		t2.start();
		t3.start();

	}

}
