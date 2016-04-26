package com.czx.keys.Volatile;

import org.junit.Test;

/**
 * volatile
 * 让变量每次在使用的时候，都从主存中取。而不是从各个线程的“工作内存”。
 * volatile提醒编译器它后面所定义的变量随时都有可能改变，因此编译后的程序每次需要存储或读取这个变量的时候，都会直接从变量地址中读取数据。
 * 如果没有volatile关键字，则编译器可能优化读取和存储，可能暂时使用寄存器中的值，如果这个变量由别的程序更新了的话，将出现不一致的现象
 * @author admin
 *
 */
public class VolatileDemo {

	@Test
	public void countTest(){
		Counter counter = new Counter();
		for (int i = 0; i < 1000; i++) { 
            new Thread(counter).start(); 
		} 

        //这里每次运行的值都有可能不同,可能为1000 
        System.out.println("运行结果:Counter.count=" + Counter.count);
	}
}


class Counter implements Runnable{

	public volatile static int count = 0;
	
	public void inc(){
		  //这里延迟1毫秒，使得结果明显 
        try { 
            Thread.sleep(1); 
        } catch (InterruptedException e) { 
        } 

        count++; 
	}
	public void run() {
		// TODO Auto-generated method stub
		inc();
	}
	
}