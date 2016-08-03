package com.czx.keys._synchronized.demo002;

/**
 * ͬ�������
 * һ����Ķ���������һ����Ķ�������û�й����ģ���һ���̻߳��A��Ķ�����ʱ����ͬʱҲ���Ի��B��Ķ�������
 * @author admin
 *
 */
public class BlockSyn {

	private static Person person = new Person();
	public void syn(){
		synchronized (person) {
			person.test01();
		}
	}
	
	
	public static void main(String[] args) {
		final BlockSyn blockSyn = new BlockSyn();
		new Thread(new Runnable() {
			
			public void run() {
				blockSyn.syn();
			}
		}).start();
		new Thread(new Runnable() {
			
			public void run() {
				blockSyn.syn();
			}
		}).start();
	}
}


class Person{
	public void test01(){
		for(int i=0,len=10;i<len;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"==method test02 ==="+i);
		}
	}
}