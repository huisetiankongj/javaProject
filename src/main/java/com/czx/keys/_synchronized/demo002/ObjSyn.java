package com.czx.keys._synchronized.demo002;

/**
 * 对象锁
 * 1、多线程同时调用这个对象的同步锁定方法时，当一个线程拿到这个对象锁后，其他线程就要等待这个对象锁的释放才能访问该对象的同步方法
 * 2、当一个线程拿到对象锁后，其他线程是可以访问没有进行同步的方法（普通方法），互不影响。
 * 
 * 【对象的内置锁和对象的状态之间是没有内在的关联的，虽然大多数类都将内置锁用做一种有效的加锁机制，
 * 但对象的域并不一定通过内置锁来保护。当获取到与对象关联的内置锁时，并不能阻止其他线程访问该对象，
 * 当某个线程获得对象的锁之后，只能阻止其他线程获得同一个锁。之所以每个对象都有一个内置锁，是为了免去显式地创建锁对象。】
 * @author admin
 *
 */
public class ObjSyn {

	public void test01(){
		synchronized (this) {
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
	
	public synchronized void test02(){
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
		for(int i=0,len=10;i<len;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"==method test03 ==="+i);
		}
	}
	
	public static void main(String[] args) {
		final ObjSyn objSyn = new ObjSyn();
		new Thread(new Runnable() {
			
			public void run() {
				objSyn.test01();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				objSyn.test02();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				objSyn.test03();
			}
		}).start();
	}
}
