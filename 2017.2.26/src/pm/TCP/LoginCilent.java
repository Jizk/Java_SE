package pm.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginCilent {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//获取到socket的输出流对象
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//获取到socket的输入流对象
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//获取到键盘的输入流对象
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("请选择功能（A）登录（B）注册");
			String line = reader.readLine();
			if("a".equalsIgnoreCase(line)){
				getInfo(socketOut, reader, line);
				//读取服务器反馈的信息
				String option = socketReader.readLine();
				System.out.println(option);
			}else if("b".equalsIgnoreCase(line)){
				getInfo(socketOut, reader, line);
				//读取服务器反馈的信息
				String option = socketReader.readLine();
				System.out.println(option);
				
			}
		}
	}

	public static void getInfo(OutputStreamWriter socketOut,BufferedReader reader, String line)
			throws IOException {
		System.out.println("请输入用户名");
		String username = reader.readLine();
		System.out.println("请输入密码");
		String password = reader.readLine();
		String info = line+" "+username+" "+password+"\r\n";
		socketOut.write(info);
		socketOut.flush();
	}
}
