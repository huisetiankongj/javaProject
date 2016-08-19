package com.czx.application.xstream.demo01;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Friends {

	 @XStreamImplicit(itemFieldName="name")
	 private List<String> name;
	 
	 public void setName(List<String> name) {
         this.name = name;
     }
}
