package com.czx.keys._synchronized.demo002;

/**
 * 类锁
 * 1、【类锁和对象锁是两个不一样的锁，控制着不同的区域，它们是互不干扰的。
 * 		同样，线程获得对象锁的同时，也可以获得该类锁，即同时获得两个锁，这是允许的。】
 * @author admin
 *
 */
public class ClassSyn {

	public void test01(){
		synchronized (ClassSyn.class) {
			for(int i=0,len=10;i<len;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"==method test01 ==="+i);
			}
			
		}
	}
	
	public static synchronized void test02(){
		for(int i=0,len=10;i<len;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"==method test02 ==="+i);
		}
	}
	
	public void test03(){
		synchronized(this){
			for(int i=0,len=10;i<len;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"==method test03 ==="+i);
			}
		}
	}
	
	public void test04(){
		for(int i=0,len=10;i<len;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"==method test04 ==="+i);
		}
	}
	
	public static void main(String[] args) {
		final ClassSyn classSyn1 = new ClassSyn();
		final ClassSyn classSyn2 = new ClassSyn();
		new Thread(new Runnable() {
			
			public void run() {
				classSyn1.test01();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				classSyn2.test02();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				classSyn2.test03();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				classSyn2.test04();
			}
		}).start();
	}
}
