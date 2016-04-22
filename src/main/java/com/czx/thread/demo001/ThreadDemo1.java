package com.czx.thread.demo001;

/**
 *  实现线程两种方法
 *  继承Thread
 *  实现runnable接口
 * @author admin
 *
 */
public class ThreadDemo1 {

	public static void main(String[] args) {
		Demo d = new Demo();
        d.start();
        
        Demo2 d2 = new Demo2();
        Thread t = new Thread(d2);
        t.start();
	}
}


class Demo extends Thread{
	@Override
	public void run() {
		 System.out.println("demo===="+Thread.currentThread().getName());
	}
	
}


class Demo2 implements Runnable{
	public void run() {
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println("demo2===="+Thread.currentThread().getName());
	}
}
