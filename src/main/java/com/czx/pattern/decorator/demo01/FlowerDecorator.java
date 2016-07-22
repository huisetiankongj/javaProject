package com.czx.pattern.decorator.demo01;

public class FlowerDecorator extends OtherDecorator {

	public FlowerDecorator(Cake cake) {
		super(cake);
		super.remark ="һ��õ�廨";
	}

	@Override
	public String getRemark() {
		return cake.getRemark()+"+"+super.remark;  
	}

	@Override
	public String getImpression() {
		return cake.getImpression()+","+"����һ�仨����happy";  
	}

}
