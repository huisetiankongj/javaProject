package com.czx.keys._transient.demo001;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientTest1 {

	public static void main(String[] args) {
		User1 user = new User1();
		user.setUsername("czx");	
		user.setPasswd("123456");
		
		System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());
        
        try {
			ObjectOutputStream os = new ObjectOutputStream(
			        new FileOutputStream("C:/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
        	User1.username = "jmwang";
        	
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
			        "C:/user.txt"));
			user = (User1) is.readObject(); // 从流中读取User的数据
            is.close();
            
            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.err.println("password: " + user.getPasswd());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}



class User1 implements Serializable{
	
	private static final long serialVersionUID = 8294180014912103005L;  
	
	public static String username;
	private transient String passwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}