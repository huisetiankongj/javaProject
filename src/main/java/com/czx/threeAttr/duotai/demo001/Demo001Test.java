package com.czx.threeAttr.duotai.demo001;

import org.junit.Test;

public class Demo001Test {
	/**
	 * ����
	 * ��Ҷ�ȥ�����Ķ�̬ʵ��
	 * �����Person�����(is a)
	 * ��ȡIWork����ӿ�(can do)
	 * �����Position�����
	 */
	public static void main(String[] args) {
		IWork itwork = new ITWork();
		Position itPosition = new Position("it",itwork);
		Person itPerson = new ITPerson("С��",itPosition);
		itPerson.goWork();
	}
}
