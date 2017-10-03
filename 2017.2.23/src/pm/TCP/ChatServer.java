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
		//����TCP����
		ServerSocket serverSocket = new ServerSocket(9090);
		//���ܿͻ��˵�����
		Socket socket =serverSocket.accept();
		//��ȡsocket�����������󣬶�ȡ�ͷ��˷��͵�����
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//��ȡsocket�����������
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//��ȡ���̵�����������
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		//��ȡ�ͻ��˵�����
		String line = null;
		while((line= socketReader.readLine())!=null){
			System.out.println("����˽ӽ���"+line);
			System.out.print("����˷���:");
			//���͸��ͻ��˵�����
			line = reader.readLine();
			socketOut.write(line+"/r/n");
			socketOut.flush();
			
		}
		//�ر���Դ
		serverSocket.close();
	}
}
