package pm.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1Server {
	public static void main(String[] args) throws IOException {
		//建立TCP服务端,监听一个端口
		ServerSocket serverSocket = new ServerSocket(9090);
		//接受客户端的连接
		Socket socket = serverSocket.accept(); //该方法是一个阻塞的方法，没有客户端的连接，会一直等待下去
		//获取到输入流对象，读取客户端发送的消息
		InputStream inputStream  = socket.getInputStream();
		byte[] buf =  new byte[1024];
		int length = 0;
		length =  inputStream.read(buf);
		System.out.println("服务器接收"+ new String(buf,0,length));
		//向客户端发送数据
		//获取到socket的输出流对象
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("客户端你好".getBytes());
		//关闭资源
		serverSocket.close();
	}
}
