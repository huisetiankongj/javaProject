package com.czx.lock.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

	public static void main(String[] args) throws InterruptedException {
		int threadCount = 5000;
		Thread[] threads = new Thread[threadCount];  
		Account c1 = new Account();
		for(int i=0,len=threadCount;i<len;i++){
			threads[i] = new Thread(c1,i+"");
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {  
            threads[i].join();  
        }  
		System.out.println(c1.getBalance());
	}
	
}

class Account implements Runnable{
	public static double balance = 0d;
	private static Lock lock = new ReentrantLock();
	public static double getBalance(){
		return balance;
	}
	
	public static void deposit(double d){
		lock.lock();
		 try {
			 balance += d;
			 System.out.println("deposit current thread is "+Thread.currentThread().getName()+"==="+balance);
		 }finally{
			 lock.unlock();
		 }
	}
	public static void take(double d){
		lock.lock();
		try {
			 balance -= d;
		 }finally{
			 lock.unlock();
		 }
	}

	public void run() {
		deposit(10);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		take(10);
	}
}