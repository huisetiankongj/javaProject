package com.czx.pattern.decorator.demo01;

public class FlowerDecorator extends OtherDecorator {

	public FlowerDecorator(Cake cake) {
		super(cake);
		super.remark ="一朵玫瑰花";
	}

	@Override
	public String getRemark() {
		return cake.getRemark()+"+"+super.remark;  
	}

	@Override
	public String getImpression() {
		return cake.getImpression()+","+"看到一朵花真是happy";  
	}

}
