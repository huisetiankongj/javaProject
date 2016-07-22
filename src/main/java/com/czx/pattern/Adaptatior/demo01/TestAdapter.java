package com.czx.pattern.Adaptatior.demo01;

import org.junit.Test;

public class TestAdapter {
	/**
	 * ��������
	 */
	@Test
	public void classAdapter(){
		Job job = new ClassAdapter();
		job.speakChinese();
		job.speakEnglish();
	}
	
	/**
	 * ����������
	 */
	@Test
	public void objectAdapter(){
		Person p = new Person();  
        Job j = new ObjectAdapter(p);  
        j.speakChinese();  
        j.speakEnglish(); 
	}
}
