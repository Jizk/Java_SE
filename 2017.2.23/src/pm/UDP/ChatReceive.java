package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceive extends Thread {
	public void run() {
		try {
			//����UDP����
			DatagramSocket socket = new DatagramSocket(9090);
			//׼����������
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			boolean flag = true;
			while(flag){
				socket.receive(packet);
				System.out.println(packet.getAddress().getHostAddress()+"˵��"+new String(buf,0,packet.getLength()));
			}
			//�ر���Դ
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
