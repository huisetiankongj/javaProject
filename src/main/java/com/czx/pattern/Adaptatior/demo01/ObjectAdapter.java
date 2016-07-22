package com.czx.pattern.Adaptatior.demo01;

public class ObjectAdapter implements Job{
	
	Person p;

	public ObjectAdapter(Person p ) {
		this.p = p;
	}

	public void speakChinese() {
		p.speakChinese();
	}

	public void speakEnglish() {
		System.out.println("speak English");
	}

}
