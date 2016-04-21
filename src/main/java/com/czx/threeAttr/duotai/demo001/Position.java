package com.czx.threeAttr.duotai.demo001;

public class Position implements IWork{

	private String name;//ְλ����
	private IWork work;//����
	
	public Position() {
		super();
	}
	public Position(String name, IWork work) {
		super();
		this.name = name;
		this.work = work;
	}
	public void goWork() {
		work.goWork();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWork(IWork work) {
		this.work = work;
	}
}
