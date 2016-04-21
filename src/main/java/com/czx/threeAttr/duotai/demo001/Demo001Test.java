package com.czx.threeAttr.duotai.demo001;

import org.junit.Test;

public class Demo001Test {
	/**
	 * 测试
	 * 大家都去工作的多态实现
	 * 抽象出Person这个类(is a)
	 * 提取IWork这个接口(can do)
	 * 构造出Position这个类
	 */
	public static void main(String[] args) {
		IWork itwork = new ITWork();
		Position itPosition = new Position("it",itwork);
		Person itPerson = new ITPerson("小明",itPosition);
		itPerson.goWork();
	}
}
