package com.czx.classes._reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

public class ReferenceTest {

	/**
	 * �������
	 */
	@Test
	public void noGarbageRetrieve1(){
		MyDate myDate = new MyDate();
		myDate = null;
	}
	
	/**
	 * ��ʽ������������
	 */
	@Test
	public void explicitGarbageRetrieve(){
		MyDate myDate = new MyDate();
		myDate = null;
		System.gc();
	}
	
	/**
	 * ��ʽ������������
	 */
	@Test
	public void implicitGarbageRetrieve(){
		MyDate myDate = new MyDate();
		myDate = null;
		LargeCostMemory.drainMemory();
	}
	
	/**
	 * ǿ����
	 */
	@Test
	public void strongReferenceTest(){
		MyDate date = new MyDate();
        System.gc();
	}
	
	/**
	 * ������
	 */
	@Test
	public void softReferenceTest(){
		MyDate date = new MyDate();
		SoftReference<MyDate> ref = new SoftReference<MyDate>(date);
		LargeCostMemory.drainMemory();
	}
	
	/**
	 * ������
	 */
	@Test
	public void weakReferenceTest(){
		MyDate date = new MyDate();
		WeakReference<MyDate> ref = new WeakReference<MyDate>(date);
		System.gc();
	}
	
	/**
	 * ������
	 */
	@Test
	public void phantomReferenceTest(){
		ReferenceQueue queue = new ReferenceQueue();
		PhantomReference<MyDate> ref = new PhantomReference<MyDate>(new MyDate(),queue);
		System.gc();
	}
}
