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
		//��ȡ��socket�����������
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//��ȡ��socket������������
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//��ȡ�����̵�����������
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("��ѡ���ܣ�A����¼��B��ע��");
			String line = reader.readLine();
			if("a".equalsIgnoreCase(line)){
				getInfo(socketOut, reader, line);
				//��ȡ��������������Ϣ
				String option = socketReader.readLine();
				System.out.println(option);
			}else if("b".equalsIgnoreCase(line)){
				getInfo(socketOut, reader, line);
				//��ȡ��������������Ϣ
				String option = socketReader.readLine();
				System.out.println(option);
				
			}
		}
	}

	public static void getInfo(OutputStreamWriter socketOut,BufferedReader reader, String line)
			throws IOException {
		System.out.println("�������û���");
		String username = reader.readLine();
		System.out.println("����������");
		String password = reader.readLine();
		String info = line+" "+username+" "+password+"\r\n";
		socketOut.write(info);
		socketOut.flush();
	}
}
