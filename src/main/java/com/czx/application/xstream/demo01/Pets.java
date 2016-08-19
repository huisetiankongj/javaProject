package com.czx.application.xstream.demo01;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Pets {

	@XStreamImplicit(itemFieldName="pet")
	private List<Animal> animalList;
	
	public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
