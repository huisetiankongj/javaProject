package com.czx.thread.demo002;

import org.junit.Test;

/**
 * �̷߳���
 * ���Ե�ʱ��������̹߳رպ����߳�Ҳ����ֹ
 * @author admin
 *
 */
public class ThreadMethod {

	
	/**
	 * join()�������ǣ�"�ȴ����߳���ֹ"��
	 * ������Ҫ���ľ��Ǹ��߳���ָ�����̵߳ȴ����̵߳���ֹ��
	 * Ҳ���������̵߳�����join()��������Ĵ��룬ֻ�еȵ����߳̽����˲���ִ�С�
	 */
	@Test
	public void joinMethod(){
		System.out.println(Thread.currentThread().getName()+"���߳����п�ʼ!");
		ThreadSleep tCount = new ThreadSleep();
		Thread t1 = new Thread(tCount,"A");
		Thread t2 = new Thread(tCount,"B");
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "���߳����н���!");
	}
	
	
	/**
	 * Thread.yield()���������ǣ���ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�
       yield()Ӧ���������õ�ǰ�����̻߳ص�������״̬�������������ͬ���ȼ��������̻߳�����л��ᡣ
       	��ˣ�ʹ��yield()��Ŀ��������ͬ���ȼ����߳�֮�����ʵ�����תִ�С�
       	���ǣ�ʵ�����޷���֤yield()�ﵽ�ò�Ŀ�ģ���Ϊ�ò����̻߳��п��ܱ��̵߳��ȳ����ٴ�ѡ��
	 */
	@Test
	public void yieldMethod(){
		ThreadYield tYield1 = new ThreadYield();
		
		Thread t1 = new Thread(tYield1,"����1");
		Thread t2 = new Thread(tYield1,"����2");
		Thread t3 = new Thread(tYield1,"����3");
		Thread t4 = new Thread(tYield1,"����4");
		Thread t5 = new Thread(tYield1,"����5");
		Thread t6 = new Thread(tYield1,"����6");
		Thread t7 = new Thread(tYield1,"����7");
		Thread t8 = new Thread(tYield1,"����8");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		
		try {
			t1.join();
			t2.join();
//			t3.join();
//			t4.join();
//			t5.join();
//			t6.join();
//			t7.join();
//			t8.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main�߳��˳�");
		
	}
	/**
	 * wait
	 * ��Obj.notify()����Ҫ��synchronized(Obj)һ��ʹ�ã�Ҳ����wait,��notify������Ѿ���ȡ��Obj�����в�����
	 * ���﷨�Ƕ���˵����Obj.wait(),Obj.notify������synchronized(Obj){...}������
	 * ��������˵wait����˵�߳��ڻ�ȡ�������������ͷŶ�������ͬʱ���߳����ߡ�ֱ���������̵߳��ö����notify()���Ѹ��̣߳����ܼ�����ȡ��������������ִ��
	 * @throws InterruptedException
	 * 
	 * ThreadA->ThreadB->ThreadC->ThreadAѭ��ִ�������̡߳�
	 * Ϊ�˿����߳�ִ�е�˳����ô�ͱ���Ҫȷ�����ѡ��ȴ���˳������ÿһ���̱߳���ͬʱ�������������������ܼ���ִ�С�
	 * һ����������prev������ǰһ���߳������еĶ�����������һ�����������������
	 * ��Ҫ��˼����ǣ�Ϊ�˿���ִ�е�˳�򣬱���Ҫ�ȳ���prev����Ҳ��ǰһ���߳�Ҫ�ͷ������������
	 * ��ȥ������������������߼汸ʱ��ӡ��֮�����ȵ���self.notify()�ͷ������������������һ���ȴ��̣߳�
	 * �ٵ���prev.wait()�ͷ�prev����������ֹ��ǰ�̣߳��ȴ�ѭ���������ٴα����ѡ�
	 * �����������룬���Է��������߳�ѭ����ӡABC����10�Ρ�
	 * �������е���Ҫ���̾���A�߳��������У�����C,A�����������ͷ�A,C��������B��
	 * �߳�B�ȴ�A����������B�������ӡB�����ͷ�B��A��������C���߳�C�ȴ�B����������C�������ӡC�����ͷ�C,B��������A��
	 * �������ƺ�ûʲô���⣬���������ϸ��һ�£��ͻᷢ�������⣬���ǳ�ʼ�����������̰߳���A,B,C��˳����������
	 * ����ǰ���˼����A����B��B����C��C�ٻ���A���������ּ���������JVM���̵߳��ȡ�ִ�е�˳��
	 */
	@Test
	public void waitMethod() throws InterruptedException{
		Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        PrintThread pa = new PrintThread("A", c, a);   
        PrintThread pb = new PrintThread("B", a, b);   
        PrintThread pc = new PrintThread("C", b, c);  
        new Thread(pa).start();
        Thread.sleep(100);  //ȷ����˳��A��B��Cִ��
        new Thread(pb).start();
        Thread.sleep(100);  
        new Thread(pc).start();   
        Thread.sleep(100);  
	}
	
}


class ThreadSleep implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName() + " �߳����п�ʼ!");
        for (int i = 0; i < 5; i++) {
	        System.out.println("���߳�"+Thread.currentThread().getName() + "���� : " + i);
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}     
}

class ThreadYield implements Runnable{

	public void run() {
		 for (int i = 0; i < 300; i++) {
	        System.out.println(Thread.currentThread().getName() + "���� : " + i);
	        if (i%5==0) {
                Thread.yield();
            }
		 }
	}     
}

class PrintThread implements Runnable{

	private String name;   
    private Object prev;   
    private Object self;   
  
    public PrintThread(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
    
	public void run() {
		// TODO Auto-generated method stub
		int count = 10;   
        while (count > 0) {   
            synchronized (prev) {   
                synchronized (self) {   
                    System.out.print(name);   
                    count--;  
                    
                    self.notify();   
                }   
                try {   
                    prev.wait();   
                } catch (InterruptedException e) {   
                    e.printStackTrace();   
                }   
            }   
  
        }   
	}
	
}