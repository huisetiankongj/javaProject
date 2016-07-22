package com.czx.pattern.decorator.demo01;

public abstract class OtherDecorator extends Cake {

	Cake cake;
	public OtherDecorator(Cake cake) {
		this.cake = cake;
	}

	public abstract String getRemark();  
}
