package pm.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 TCP���ص㣺
 	TCP�ǻ���IO���������ݵĴ���ģ��������ӵ�
 	TCP�������ݴ�����û�д�С����
 	TCP���������ӵģ�ͨ���������ֻ��Ʊ�֤���ݵ�������
 	TCP�ٶ���
 	TCP�����ֿͻ��˷���˵�
 	
 TCPЭ���Socket�� 
 	Socket���ͻ��ˣ� һ������������Ҫ�����˽�������
 	ServerSocket������ˣ�
 
 */
public class Demo1 {
	public static void main(String[] args) throws IOException {
		//����TCP����,��ַ
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//��ȡ����Ӧ�������ҵ�һ���������
		OutputStream outputStream = socket.getOutputStream();
		//������������������д��
		outputStream.write("���������".getBytes());
		//��ȡ���������󣬶�ȡ����˻��͵�����
		InputStream inputStream = socket.getInputStream();
		byte[] buf = new byte[1024];
		int length = 0;
		length = inputStream.read(buf);
		System.out.println("�ͻ��˽���"+new String(buf,0,length));
		//�ر���Դ
		socket.close(); 
	}
}
