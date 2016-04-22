package com.czx.thread.demo001;

/**
 * 资源共享
 * 使用实现runnable接口
 * 如果使用extends Thread类的话无法实现资源共享
 * 	1）：适合多个相同的程序代码的线程去处理同一个资源
	2）：可以避免java中的单继承的限制
	3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 * @author admin
 *
 */
public class ResourceShareTest{

	public static void main(String[] args) {
		ResourceShare rs = new ResourceShare();
		new Thread(rs, "C").start();//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常   
	    new Thread(rs, "D").start();
	    new Thread(rs, "E").start();
	}
}
class ResourceShare implements Runnable{

	private int count =99;
	public void run() {
		 for (int i = 0; i < 5; i++) {
			 System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
            	Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
}