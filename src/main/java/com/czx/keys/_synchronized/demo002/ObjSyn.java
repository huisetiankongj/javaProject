package com.czx.keys._synchronized.demo002;

/**
 * ������
 * 1�����߳�ͬʱ������������ͬ����������ʱ����һ���߳��õ�����������������߳̾�Ҫ�ȴ�������������ͷŲ��ܷ��ʸö����ͬ������
 * 2����һ���߳��õ��������������߳��ǿ��Է���û�н���ͬ���ķ�������ͨ������������Ӱ�졣
 * 
 * ��������������Ͷ����״̬֮����û�����ڵĹ����ģ���Ȼ������඼������������һ����Ч�ļ������ƣ�
 * ��������򲢲�һ��ͨ��������������������ȡ������������������ʱ����������ֹ�����̷߳��ʸö���
 * ��ĳ���̻߳�ö������֮��ֻ����ֹ�����̻߳��ͬһ������֮����ÿ��������һ������������Ϊ����ȥ��ʽ�ش��������󡣡�
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
