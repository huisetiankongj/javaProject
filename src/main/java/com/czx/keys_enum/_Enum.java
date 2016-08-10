package com.czx.keys_enum;

/**
 * 定于枚举
 * 1、枚举是已知一组的【对象】的集合，所有对象的使用方式都可以进行相同的使用
 * 2、枚举像一个类一样，可以定于属性、方法、构造函数等，但他们使用是以枚举的常量来使用
 * 3、枚举类型里面的方法都是对枚举对象使用
 * 		Color.RED.getName()
 * @author admin
 *
 */
public class _Enum {

	//1、常量
	public enum ColorEnum{
		red,green,blue,yellow;
	}
	
	//2、switch
	
	
	public class tt{
		
	}
	public interface Behaviour {  
	    void print();  
	    String getInfo();  
	}  
	
	//3、向枚举中添加新方法
	public enum Color implements Behaviour{
		RED("红色",1),BLUE("蓝色",2),YELLOW("黄色",3);
		
		private String name;  
		private int index;  
		
		//构造方法
		private Color(String name,int index){
			this.name = name;
			this.index = index;
		}
		
		//普通方法
		public static String getName(int index){
			for(Color c :Color.values()){
				if(index == c.index){
					return c.name;
				}
			}
			return null;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
		
		//覆盖方法  
		@Override
		public String toString(){
			 return this.index+"_"+this.name;  
		}

		public void print() {
			System.out.println(this.index+":"+this.name);  
		}

		public String getInfo() {
			 return this.name;  
		}
		
		
	}
	
	/**
    * 订单状态
    * 
    * 实现带有抽象方法的枚举
    * 
    * @author jiqinlin
    *
    */
	public enum OrderState {
		 /** 已取消 */
        CANCEL {public String getName(){return "已取消";}},
        /** 待审核 */
        WAITCONFIRM {public String getName(){return "待审核";}},
        /** 等待付款 */
        WAITPAYMENT {public String getName(){return "等待付款";}},
        /** 正在配货 */
        ADMEASUREPRODUCT {public String getName(){return "正在配货";}},
        /** 等待发货 */
        WAITDELIVER {public String getName(){return "等待发货";}},
        /** 已发货 */
        DELIVERED {public String getName(){return "已发货";}},
        /** 已收货 */
        RECEIVED {public String getName(){return "已收货";}};
        
		public abstract String getName();
	}
	
	public static void main(String[] args) {
		ColorEnum color = ColorEnum.blue;
		System.out.println(color.name());
		//2、switch
		switch (color) {
		case red:
			color = ColorEnum.blue;
			break;
		case green:
			color = ColorEnum.red;
			break;
		case blue:
			color = ColorEnum.yellow;
			break;
		case yellow:
			color = ColorEnum.green;
			break;
		default:
			break;
		}
		
		//枚举的遍历
		for(Color c : Color.values()){
			System.out.println(c.getName());
		}
		System.out.println(color);
		//执行枚举元素的方法
		System.out.println(Color.RED.getName());
		System.out.println(Color.RED.getInfo());
		Color.RED.print();
		System.out.println(Color.RED.toString());
		
		System.out.println(OrderState.CANCEL.getName());
	}
}
