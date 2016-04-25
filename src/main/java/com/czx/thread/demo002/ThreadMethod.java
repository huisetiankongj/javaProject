package com.czx.thread.demo002;

import org.junit.Test;

/**
 * 线程方法
 * 测试的时候如果主线程关闭后，子线程也会终止
 * @author admin
 *
 */
public class ThreadMethod {

	
	/**
	 * join()的作用是："等待该线程终止"，
	 * 这里需要理解的就是该线程是指的主线程等待子线程的终止。
	 * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
	 */
	@Test
	public void joinMethod(){
		System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
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
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
	}
	
	
	/**
	 * Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
       yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
       	因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
       	但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中
	 */
	@Test
	public void yieldMethod(){
		ThreadYield tYield1 = new ThreadYield();
		
		Thread t1 = new Thread(tYield1,"张三1");
		Thread t2 = new Thread(tYield1,"李四2");
		Thread t3 = new Thread(tYield1,"张三3");
		Thread t4 = new Thread(tYield1,"李四4");
		Thread t5 = new Thread(tYield1,"张三5");
		Thread t6 = new Thread(tYield1,"李四6");
		Thread t7 = new Thread(tYield1,"张三7");
		Thread t8 = new Thread(tYield1,"李四8");
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
		System.out.println("main线程退出");
		
	}
	/**
	 * wait
	 * 与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，
	 * 从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内
	 * 功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行
	 * @throws InterruptedException
	 * 
	 * ThreadA->ThreadB->ThreadC->ThreadA循环执行三个线程。
	 * 为了控制线程执行的顺序，那么就必须要确定唤醒、等待的顺序，所以每一个线程必须同时持有两个对象锁，才能继续执行。
	 * 一个对象锁是prev，就是前一个线程所持有的对象锁。还有一个就是自身对象锁。
	 * 主要的思想就是，为了控制执行的顺序，必须要先持有prev锁，也就前一个线程要释放自身对象锁，
	 * 再去申请自身对象锁，两者兼备时打印，之后首先调用self.notify()释放自身对象锁，唤醒下一个等待线程，
	 * 再调用prev.wait()释放prev对象锁，终止当前线程，等待循环结束后再次被唤醒。
	 * 运行上述代码，可以发现三个线程循环打印ABC，共10次。
	 * 程序运行的主要过程就是A线程最先运行，持有C,A对象锁，后释放A,C锁，唤醒B。
	 * 线程B等待A锁，再申请B锁，后打印B，再释放B，A锁，唤醒C，线程C等待B锁，再申请C锁，后打印C，再释放C,B锁，唤醒A。
	 * 看起来似乎没什么问题，但如果你仔细想一下，就会发现有问题，就是初始条件，三个线程按照A,B,C的顺序来启动，
	 * 按照前面的思考，A唤醒B，B唤醒C，C再唤醒A。但是这种假设依赖于JVM中线程调度、执行的顺序
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
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);  
        new Thread(pc).start();   
        Thread.sleep(100);  
	}
	
}


class ThreadSleep implements Runnable{

	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
	        System.out.println("子线程"+Thread.currentThread().getName() + "运行 : " + i);
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
	        System.out.println(Thread.currentThread().getName() + "运行 : " + i);
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