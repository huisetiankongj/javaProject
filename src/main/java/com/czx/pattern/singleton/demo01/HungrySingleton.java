package com.czx.pattern.singleton.demo01;

/**
 * ��ʽ����ʵ��
 * @author admin
 *
 */
public class HungrySingleton {

	private static HungrySingleton singleton= new HungrySingleton();
	
    //�����ṩ��һ�����ⲿ���ʱ�class�ľ�̬����������ֱ�ӷ���
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
