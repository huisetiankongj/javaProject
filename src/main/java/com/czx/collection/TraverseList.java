package com.czx.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 第二种遍历方法最好
 * @author admin
 *
 */
public class TraverseList {

	public List<String> itemList = new ArrayList<String>();
	
	public TraverseList(){
		super();
		for(int i=0;i<2000000;i++){
			itemList.add("测试"+i);
		}
	}
	
	public void oneMethod(){
		for(String str: itemList){
		}
	}
	
	public void twoMethod(){
		for(int i=0,len=itemList.size();i<len;i++){
			itemList.get(i);
		}
	}
	
	public void threeMethod(){
		Iterator<String> it = itemList.iterator();
		while(it.hasNext()){
			it.next();
		}
	}
	
	public static void main(String[] args) {
		long t1,t2;
		TraverseList t = new TraverseList();
		t1=System.currentTimeMillis();  
		t.oneMethod();
		t2=System.currentTimeMillis();  
		System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
	    System.out.println("List first visit method:");  
	    
	    t1=System.currentTimeMillis();
		t.twoMethod();
		t2=System.currentTimeMillis();  
		System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
	    System.out.println("List second visit method:");  
	    
	    t1=System.currentTimeMillis();  
		t.threeMethod();
		t2=System.currentTimeMillis();  
		System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
	    System.out.println("List three visit method:");  
	}
}
