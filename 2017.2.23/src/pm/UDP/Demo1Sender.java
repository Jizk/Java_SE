package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 UDP���ص㣺
 1.�����ݼ���Դ��Ŀ�ķ�װΪ���ݰ�������Ҫ��������
 2.ÿ�����ݰ���С������64K��
 3.���ɿ�
 4.�ٶȿ�
 ���磺 feiQ��QQ 
 
UDPЭ���µ�Scoket:
	DatagramSocket(UDP��������)
	���������
	DatagramPacket(���ݰ���)
	DatagramPacket(buf, length, address, port)  ���͵��������� �������ݵĴ�С ���͵�Ŀ�ĵ�ַ���� �˿ں�
*/

//���Ͷ�

public class Demo1Sender{
	public static void main(String[] args) throws IOException {
		//����UDP����
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//׼�����ݣ������ݷ�װ�����ݰ���
		String data = "��һ��UDP����";
		//������һ�����ݰ�
		DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 9090);
		//����udp�ķ���������
		datagramSocket.send(datagramPacket);
		//�ر���Դ  �ͷ�ռ�õĶ˿ں�
		datagramSocket.close();
	}
	
}











