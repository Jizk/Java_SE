package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//���ն�
public class Demo1Receive {
	public static void main(String[] args) throws IOException {
		//����UDP���񣬼���һ���˿ں�
		DatagramSocket socket = new DatagramSocket(9090);
		//׼���յ����ݰ���������
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		//����UDP�����������
		socket.receive(packet);//����ʵ���ϴ洢��buf������,��һ�������ķ�����û�н��յ�֮ǰ��һֱ�ȴ�
		//
		System.out.println("���յ��������ǣ�"+ new String(buf,0,packet.getLength()));//��ȡ�����ݰ��洢�˼����ֽ�
		//�ر���Դ
		socket.close();
	
	}
}
