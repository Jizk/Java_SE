package pm.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//聊天的客户端
public class ChatClient {
	public static void main(String[] args) throws IOException {
		//建立TCP客户端的服务
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//获取socket的输出流对象
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//获取键盘的输入流对象，读取键盘数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//获取socket的输入流对象，读取服务端发送的数据
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String line = null;
		while((line=reader.readLine())!=null){//readLine方法只有读到/r/n才会停止，所以要在每接收到键盘的一行后加/r/n
			System.out.println("客户端发送：");
			socketOut.write(line+"/r/n");
			//刷新
			socketOut.flush();//使用字符流一定要调用刷新，数据才能写出
			//读取服务端的数据
			line = socketReader.readLine();
			System.out.println("客户端接收" +line);
		}
		//关闭资源 
		socket.close();
	}
}
