package pm.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1Server {
	public static void main(String[] args) throws IOException {
		//����TCP�����,����һ���˿�
		ServerSocket serverSocket = new ServerSocket(9090);
		//���ܿͻ��˵�����
		Socket socket = serverSocket.accept(); //�÷�����һ�������ķ�����û�пͻ��˵����ӣ���һֱ�ȴ���ȥ
		//��ȡ�����������󣬶�ȡ�ͻ��˷��͵���Ϣ
		InputStream inputStream  = socket.getInputStream();
		byte[] buf =  new byte[1024];
		int length = 0;
		length =  inputStream.read(buf);
		System.out.println("����������"+ new String(buf,0,length));
		//��ͻ��˷�������
		//��ȡ��socket�����������
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("�ͻ������".getBytes());
		//�ر���Դ
		serverSocket.close();
	}
}
