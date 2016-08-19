package com.czx.application.xstream.demo01;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Animal {

	@XStreamAlias("name")
	private String name;
	@XStreamAlias("age")
	private int age;
	public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
}
