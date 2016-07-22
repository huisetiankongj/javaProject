package com.czx.pattern.decorator.demo01;

public class NutsDecorator extends OtherDecorator {

	public NutsDecorator(Cake cake) {
		super(cake);
		super.remark = "果仁";  
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
