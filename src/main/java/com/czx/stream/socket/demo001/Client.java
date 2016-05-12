package com.czx.stream.socket.demo001;

import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		try{
			Socket[] sockets = new Socket[500];
			for(int i=0;i<sockets.length;i++){
				sockets[i] = new Socket("127.0.0.1",8088);
				PrintWriter os=new PrintWriter(sockets[i].getOutputStream());
				os.write("�������ӵ�"+i);
				os.flush();
				os.close(); //�ر�Socket�����
			}
			Thread.sleep(5000);
			for(int i=0;i<sockets.length;i++){
				sockets[i].close(); //�ر�Socket
			}
		}catch(Exception e) {
			System.out.println("Error1"+e);
		}
	}	
}
