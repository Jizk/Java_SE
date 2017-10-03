package pm.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//����Ŀͻ���
public class ChatClient {
	public static void main(String[] args) throws IOException {
		//����TCP�ͻ��˵ķ���
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//��ȡsocket�����������
		OutputStreamWriter socketOut = new OutputStreamWriter(socket.getOutputStream());
		//��ȡ���̵����������󣬶�ȡ��������
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//��ȡsocket�����������󣬶�ȡ����˷��͵�����
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String line = null;
		while((line=reader.readLine())!=null){//readLine����ֻ�ж���/r/n�Ż�ֹͣ������Ҫ��ÿ���յ����̵�һ�к��/r/n
			System.out.println("�ͻ��˷��ͣ�");
			socketOut.write(line+"/r/n");
			//ˢ��
			socketOut.flush();//ʹ���ַ���һ��Ҫ����ˢ�£����ݲ���д��
			//��ȡ����˵�����
			line = socketReader.readLine();
			System.out.println("�ͻ��˽���" +line);
		}
		//�ر���Դ 
		socket.close();
	}
}
