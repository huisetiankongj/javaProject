package com.czx.pattern.decorator.demo01;

public class CardDecorator extends OtherDecorator {

	
	public CardDecorator(Cake cake) {
		super(cake);
		super.remark = "贺卡";
	}

	@Override
	public String getRemark() {
		return cake.getRemark()+"+"+super.remark;  
	}

	@Override
	public String getImpression() {
		 return cake.getImpression()+","+"吃起来口感不错啊！！";  
	}

}
