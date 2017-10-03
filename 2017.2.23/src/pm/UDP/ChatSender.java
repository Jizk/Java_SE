package pm.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatSender extends Thread{
	public void run() {
		try {
			//����UDP����
			DatagramSocket socket = new DatagramSocket();
			//׼�����ݣ������ݷ�װ�����ݰ���
			// BufferedReader�ṩһ��һ�ж�����¼��Ĺ���
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			//�������ݰ�
			DatagramPacket packet = null;
			while((line = reader.readLine())!=null){
				//�����ݷ�װ�����ݰ��У�׼������
				packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.15.255"), 9090);
				//�����ݷ��ͳ�ȥ
				socket.send(packet);
				
			}
			//�ر���Դ
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
