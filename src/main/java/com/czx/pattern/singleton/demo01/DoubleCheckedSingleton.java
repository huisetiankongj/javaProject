package com.czx.pattern.singleton.demo01;

/**
 * ˫����/˫��У������DCL���� double-checked locking��
 * ʵ��ԭ�����ǲ����߳�ÿ�ζ���������ֻ����ʵ��δ��������ʱ���ټ�����
 * ͬʱҲ�ܱ�֤���̵߳İ�ȫ������instance���ڵ������ֱ�ӷ��أ�
 * ��instance�����ڣ�����ͬʱ�������̵߳���getInstance()����ʱ��
 * ���Ƕ�����ͨ����һ��instance == null�жϣ�
 * Ȼ������synchronizd�����ƣ������߳�ֻ��һ���ܽ��룬��һ�������ŶӵȺ�
 * ����Ҫ���е�һ�����벢����֮����һ�����ܽ��롣
 * ���û���˵ڶ��ص�instance == null���жϣ����һ���̴߳�����ʵ����
 * �ڶ����̻߳��ǿ����ؼ�������ʵ����
 * ���ַ�ʽ����˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ�����;
 * @author admin
 *
 */
public class DoubleCheckedSingleton {

	private static volatile  DoubleCheckedSingleton dcSingleton= null; 
	
	public static DoubleCheckedSingleton getInstance(){
		if(dcSingleton==null){
			synchronized (DoubleCheckedSingleton.class) {
				if(dcSingleton==null)
					dcSingleton = new DoubleCheckedSingleton();	
			}
		}
		return dcSingleton;
	}
}
