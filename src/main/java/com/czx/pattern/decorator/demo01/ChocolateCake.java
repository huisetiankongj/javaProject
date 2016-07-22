package com.czx.pattern.decorator.demo01;

public class ChocolateCake extends Cake {

	
	public ChocolateCake() {
		super.remark="巧克力蛋糕";  
	}

	@Override
	public String getImpression() {
		return "丝一般的润滑";  
	}

}
