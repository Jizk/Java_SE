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
			//��ȡsocket��������
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��ȡsocket�����������
			OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
			//��ȡ�ͷ����������Ϣ
			String info = reader.readLine();
			String datas[] = info.split(" ");
			//��ȡ�û���ѡ����
			String option = datas[0];
			String username = datas[1];
			String password = datas[2];
			if("a".equalsIgnoreCase(option)){
				//��¼
				Properties properties = new Properties();
				//���������ļ�
				properties.load(new FileReader(file));
				if(properties.containsKey(username)){
					String tempPass = properties.getProperty(username);
					if(password.equals(tempPass)){
						socketOut.write("��ӭ��¼\r\n");
					}else{
						socketOut.write("�������]\r\n");
					}
					
				}else{
					socketOut.write("�û��������ڣ�����������\r\n");
				}
				socketOut.flush();
			}else if("b".equalsIgnoreCase(option)){
				//ע��
				
				//����һ�������ļ���
				Properties properties = new Properties();
				//����ԭ���������ļ�
				properties.load(new FileReader(file));
				if(!properties.containsKey(username)){
					//�������û���
					properties.setProperty(username, password);
					//����һ�������ļ�
					properties.store(new FileWriter(file), "users");
					socketOut.write("ע��ɹ�\r\n");
				}else{
					//�����û���
					socketOut.write("�Ѵ����û���������������\r\n");
					
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
