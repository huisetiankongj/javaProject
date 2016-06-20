package com.czx.keys._transient.demo001;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientTest {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("czx");	
		user.setPasswd("123456");
		
		System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());
        
        try {
			ObjectOutputStream os = new ObjectOutputStream(
			        new FileOutputStream("C:/user.txt"));
            os.writeObject(user); // ��User����д���ļ�
            os.flush();
            os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
			        "C:/user.txt"));
			user = (User) is.readObject(); // �����ж�ȡUser������
            is.close();
            
            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.err.println("password: " + user.getPasswd());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}



class User implements Serializable{
	
	private static final long serialVersionUID = 8294180014912103005L;  
	
	private String username;
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