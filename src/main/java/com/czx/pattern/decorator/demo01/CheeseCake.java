package com.czx.pattern.decorator.demo01;

public class CheeseCake extends Cake {

	
	public CheeseCake() {
		super.remark="ÈéÀÒµ°¸â";//ĞŞ¸ÄÈéÀÒµ°¸âµÄÃèÊö¡£  
	}

	@Override
	public String getImpression() {
		 return "ÏãÌğ¸ĞÊÜ";  
	}

}
