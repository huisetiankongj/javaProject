package com.czx.pattern.decorator.demo01;

public class CheeseCake extends Cake {

	
	public CheeseCake() {
		super.remark="���ҵ���";//�޸����ҵ����������  
	}

	@Override
	public String getImpression() {
		 return "�������";  
	}

}
