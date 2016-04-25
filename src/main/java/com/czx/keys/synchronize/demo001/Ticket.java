package com.czx.keys.synchronize.demo001;

public class Ticket implements Runnable{

	public int count=6666;
	public void saleTicket() throws Exception{
		synchronized(this){ 
			System.out.println(Thread.currentThread().getName()+"��ʣ"+count--+"Ʊ");
		}
		
	}

	public void run() {
		try {
			if(count>0)
			saleTicket();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
