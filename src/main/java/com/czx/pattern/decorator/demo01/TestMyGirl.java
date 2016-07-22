package com.czx.pattern.decorator.demo01;
/**
 * 制作蛋糕，蛋糕种类有是奶酪蛋糕、巧克力蛋糕、插花的巧克力蛋糕、贺卡的冰激凌蛋糕等等，
 * 在这里我们只需要关注蛋糕，而贺卡、插花只不过是起到了装饰的作用。现在我们想要什么就能生成什么。
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
