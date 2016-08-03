package com.czx.keys._synchronized.demo002;

/**
 * ����
 * 1���������Ͷ�������������һ�������������Ų�ͬ�����������ǻ������ŵġ�
 * 		ͬ�����̻߳�ö�������ͬʱ��Ҳ���Ի�ø���������ͬʱ�������������������ġ���
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
