package com.czx.pattern.decorator.demo01;

public class IceCake extends Cake {

	public IceCake() {
		 super.remark="����ܵ���";  
	}

	@Override
	public String getImpression() {
		 return "��ˬ�ޱ�";  
	}

}
