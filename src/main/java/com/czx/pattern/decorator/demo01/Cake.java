package com.czx.pattern.decorator.demo01;

public abstract class Cake {

	String remark = "µ°¸â";

	public String getRemark() {
		return remark;
	}
	
	//ÓÃÀ´ÃèÊö³Ôµ°¸âµÄ¸Ğ¾õ¡£¡£¡£¡£
	public abstract String getImpression();
}
