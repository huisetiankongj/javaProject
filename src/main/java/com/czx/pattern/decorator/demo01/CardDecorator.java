package com.czx.pattern.decorator.demo01;

public class CardDecorator extends OtherDecorator {

	
	public CardDecorator(Cake cake) {
		super(cake);
		super.remark = "�ؿ�";
	}

	@Override
	public String getRemark() {
		return cake.getRemark()+"+"+super.remark;  
	}

	@Override
	public String getImpression() {
		 return cake.getImpression()+","+"�������ڸв�������";  
	}

}
