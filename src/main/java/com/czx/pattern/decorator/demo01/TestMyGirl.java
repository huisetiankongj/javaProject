package com.czx.pattern.decorator.demo01;
/**
 * �������⣬���������������ҵ��⡢�ɿ������⡢�廨���ɿ������⡢�ؿ��ı����走��ȵȣ�
 * ����������ֻ��Ҫ��ע���⣬���ؿ����廨ֻ����������װ�ε����á�����������Ҫʲô��������ʲô��
 * @author admin
 *
 */
public class TestMyGirl {

	public static void main(String[] args) {
		Cake cake = new NutsDecorator(new FlowerDecorator(new ChocolateCake()));
		System.out.println(cake.getImpression());
		System.out.println(cake.getRemark());
	}
}
