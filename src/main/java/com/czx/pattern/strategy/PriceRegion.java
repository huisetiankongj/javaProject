package com.czx.pattern.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//��ʾֻ�ܸ�����Ӹ�ע��
@Retention(RetentionPolicy.RUNTIME)//�������Ҫ��ע�Ᵽ��������ʱ
public @interface PriceRegion {
	 int max() default Integer.MAX_VALUE;
	 int min() default Integer.MIN_VALUE;
}
