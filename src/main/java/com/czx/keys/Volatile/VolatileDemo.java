package com.czx.keys.Volatile;

import org.junit.Test;

/**
 * volatile
 * �ñ���ÿ����ʹ�õ�ʱ�򣬶���������ȡ�������ǴӸ����̵߳ġ������ڴ桱��
 * volatile���ѱ�����������������ı�����ʱ���п��ܸı䣬��˱����ĳ���ÿ����Ҫ�洢���ȡ���������ʱ�򣬶���ֱ�Ӵӱ�����ַ�ж�ȡ���ݡ�
 * ���û��volatile�ؼ��֣�������������Ż���ȡ�ʹ洢��������ʱʹ�üĴ����е�ֵ�������������ɱ�ĳ�������˵Ļ��������ֲ�һ�µ�����
 * @author admin
 *
 */
public class VolatileDemo {

	@Test
	public void countTest(){
		Counter counter = new Counter();
		for (int i = 0; i < 1000; i++) { 
            new Thread(counter).start(); 
		} 

        //����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000 
        System.out.println("���н��:Counter.count=" + Counter.count);
	}
}


class Counter implements Runnable{

	public volatile static int count = 0;
	
	public void inc(){
		  //�����ӳ�1���룬ʹ�ý������ 
        try { 
            Thread.sleep(1); 
        } catch (InterruptedException e) { 
        } 

        count++; 
	}
	public void run() {
		// TODO Auto-generated method stub
		inc();
	}
	
}