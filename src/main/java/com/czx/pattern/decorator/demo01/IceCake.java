package com.czx.pattern.decorator.demo01;

public class IceCake extends Cake {

	public IceCake() {
		 super.remark="±ùä¿ÁÜµ°¸â";  
	}

	@Override
	public String getImpression() {
		 return "±ùË¬ÎŞ±È";  
	}

}
