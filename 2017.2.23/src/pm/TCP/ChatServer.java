package pm.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		//建立TCP服务
		ServerSocket serverSocket = new ServerSocket(9090);
		//接受客户端的连接
		Socket socket =serverSocket.accept();
		//获取socket的输入流对象，读取客服端发送的数据
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//获取socket的输出流对象
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//获取键盘的输入流对象
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		//读取客户端的数据
		String line = null;
		while((line= socketReader.readLine())!=null){
			System.out.println("服务端接接收"+line);
			System.out.print("服务端发送:");
			//发送给客户端的数据
			line = reader.readLine();
			socketOut.write(line+"/r/n");
			socketOut.flush();
			
		}
		//关闭资源
		serverSocket.close();
	}
}
