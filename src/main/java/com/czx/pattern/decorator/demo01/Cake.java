package com.czx.pattern.decorator.demo01;

public abstract class Cake {

	String remark = "����";

	public String getRemark() {
		return remark;
	}
	
	//���������Ե���ĸо���������
	public abstract String getImpression();
}
