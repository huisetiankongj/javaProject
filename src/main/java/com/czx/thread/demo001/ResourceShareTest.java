package com.czx.thread.demo001;

/**
 * ��Դ����
 * ʹ��ʵ��runnable�ӿ�
 * ���ʹ��extends Thread��Ļ��޷�ʵ����Դ����
 * 	1�����ʺ϶����ͬ�ĳ��������߳�ȥ����ͬһ����Դ
	2�������Ա���java�еĵ��̳е�����
	3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���
 * @author admin
 *
 */
public class ResourceShareTest{

	public static void main(String[] args) {
		ResourceShare rs = new ResourceShare();
		new Thread(rs, "C").start();//ͬһ��mt��������Thread�оͲ����ԣ������ͬһ��ʵ��������mt���ͻ�����쳣   
	    new Thread(rs, "D").start();
	    new Thread(rs, "E").start();
	}
}
class ResourceShare implements Runnable{

	private int count =99;
	public void run() {
		 for (int i = 0; i < 5; i++) {
			 System.out.println(Thread.currentThread().getName() + "����  count= " + count--);
            try {
            	Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
}