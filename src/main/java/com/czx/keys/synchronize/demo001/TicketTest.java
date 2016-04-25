package com.czx.keys.synchronize.demo001;

import org.junit.Test;

public class TicketTest {

	@Test
	public void saleTickeTest() throws InterruptedException{
		Ticket t = new Ticket();
		for(int i=0;i<6666;i++){ 
			Thread t1 = new Thread(t,"t"+i);
			t1.start();
		}
	}
}
