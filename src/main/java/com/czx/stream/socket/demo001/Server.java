package com.czx.stream.socket.demo001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server= null;
		try {
			server = new ServerSocket(Constant.PORT);
			while( true ){
				Socket socket = server.accept();
				//��Socket����õ�����������������Ӧ��BufferedReader����
				PrintWriter os=new PrintWriter(socket.getOutputStream());
				BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = is.readLine();
				while(!"null".equals(line)&&line!=null&&!line.isEmpty()){
					System.out.println(line);
//					os.println(line);
					line = is.readLine();
				}
				os.write("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36");
				System.out.println("�ر���");
				os.flush();
				os.close();
				is.close(); //�ر�Socket������
				socket.close(); //�ر�Socket
				System.out.println("�ر�");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //�ر�ServerSocket
		}
	}
}
