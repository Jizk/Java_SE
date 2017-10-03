package pm.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 TCP的特点：
 	TCP是基于IO流进行数据的传输的，面向连接的
 	TCP进行数据传输是没有大小限制
 	TCP是面向连接的，通过三次握手机制保证数据的完整性
 	TCP速度慢
 	TCP是区分客户端服务端的
 	
 TCP协议的Socket： 
 	Socket（客户端） 一旦启动，马上要与服务端建立连接
 	ServerSocket（服务端）
 
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		//建立TCP服务,地址
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//获取到对应的流（找到一个输出流）
		OutputStream outputStream = socket.getOutputStream();
		//利用输出流对象把数据写出
		outputStream.write("服务器你好".getBytes());
		//获取输入流对象，读取服务端回送的数据
		InputStream inputStream = socket.getInputStream();
		byte[] buf = new byte[1024];
		int length = 0;
		length = inputStream.read(buf);
		System.out.println("客户端接收"+new String(buf,0,length));
		//关闭资源
		socket.close(); 
	}
}
