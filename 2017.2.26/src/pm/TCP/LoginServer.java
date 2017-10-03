package pm.TCP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class LoginServer extends Thread{
	
	Socket socket;
	
	static File file = new File("F:\\user.properties");
	
	public LoginServer(Socket socket) {
		this.socket = socket;
	}
	static{
		try {
			if(!file.exists()){
				file.createNewFile();
			} 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true){
		try{
			//获取socket的输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取socket的输出流对象
			OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
			//读取客服端输入的信息
			String info = reader.readLine();
			String datas[] = info.split(" ");
			//获取用户的选择功能
			String option = datas[0];
			String username = datas[1];
			String password = datas[2];
			if("a".equalsIgnoreCase(option)){
				//登录
				Properties properties = new Properties();
				//加载配置文件
				properties.load(new FileReader(file));
				if(properties.containsKey(username)){
					String tempPass = properties.getProperty(username);
					if(password.equals(tempPass)){
						socketOut.write("欢迎登录\r\n");
					}else{
						socketOut.write("密码错误]\r\n");
					}
					
				}else{
					socketOut.write("用户名不存在，请重新输入\r\n");
				}
				socketOut.flush();
			}else if("b".equalsIgnoreCase(option)){
				//注册
				
				//创建一个配置文件夹
				Properties properties = new Properties();
				//加载原来的配置文件
				properties.load(new FileReader(file));
				if(!properties.containsKey(username)){
					//不存在用户名
					properties.setProperty(username, password);
					//生成一个配置文件
					properties.store(new FileWriter(file), "users");
					socketOut.write("注册成功\r\n");
				}else{
					//存在用户名
					socketOut.write("已存在用户名，请重新输入\r\n");
					
				}
				socketOut.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9090);
		while(true){
			Socket socket = serverSocket.accept();
			new LoginServer(socket).start();
		}
	}
	
}
