package com.czx.threeAttr.duotai.demo001;

public class ITPerson extends Person {

	public ITPerson(){
		super();
	}
	public ITPerson(String name,Position position){
		super();
		this.name = name;
		this.position = position;
	}
	protected void goWork() {
		this.position.goWork();
	}
	
}
