package com.czx.keys_enum;

/**
 * ����ö��
 * 1��ö������֪һ��ġ����󡿵ļ��ϣ����ж����ʹ�÷�ʽ�����Խ�����ͬ��ʹ��
 * 2��ö����һ����һ�������Զ������ԡ����������캯���ȣ�������ʹ������ö�ٵĳ�����ʹ��
 * 3��ö����������ķ������Ƕ�ö�ٶ���ʹ��
 * 		Color.RED.getName()
 * @author admin
 *
 */
public class _Enum {

	//1������
	public enum ColorEnum{
		red,green,blue,yellow;
	}
	
	//2��switch
	
	
	public class tt{
		
	}
	public interface Behaviour {  
	    void print();  
	    String getInfo();  
	}  
	
	//3����ö��������·���
	public enum Color implements Behaviour{
		RED("��ɫ",1),BLUE("��ɫ",2),YELLOW("��ɫ",3);
		
		private String name;  
		private int index;  
		
		//���췽��
		private Color(String name,int index){
			this.name = name;
			this.index = index;
		}
		
		//��ͨ����
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
		
		//���Ƿ���  
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
    * ����״̬
    * 
    * ʵ�ִ��г��󷽷���ö��
    * 
    * @author jiqinlin
    *
    */
	public enum OrderState {
		 /** ��ȡ�� */
        CANCEL {public String getName(){return "��ȡ��";}},
        /** ����� */
        WAITCONFIRM {public String getName(){return "�����";}},
        /** �ȴ����� */
        WAITPAYMENT {public String getName(){return "�ȴ�����";}},
        /** ������� */
        ADMEASUREPRODUCT {public String getName(){return "�������";}},
        /** �ȴ����� */
        WAITDELIVER {public String getName(){return "�ȴ�����";}},
        /** �ѷ��� */
        DELIVERED {public String getName(){return "�ѷ���";}},
        /** ���ջ� */
        RECEIVED {public String getName(){return "���ջ�";}};
        
		public abstract String getName();
	}
	
	public static void main(String[] args) {
		ColorEnum color = ColorEnum.blue;
		System.out.println(color.name());
		//2��switch
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
		
		//ö�ٵı���
		for(Color c : Color.values()){
			System.out.println(c.getName());
		}
		System.out.println(color);
		//ִ��ö��Ԫ�صķ���
		System.out.println(Color.RED.getName());
		System.out.println(Color.RED.getInfo());
		Color.RED.print();
		System.out.println(Color.RED.toString());
		
		System.out.println(OrderState.CANCEL.getName());
	}
}
