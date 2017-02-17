package com.czx.classes._reference;

import java.util.Date;

public class MyDate extends Date {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("obj["+this.getTime()+"] is gc");
	}

}
