package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceive extends Thread {
	public void run() {
		try {
			//建立UDP服务
			DatagramSocket socket = new DatagramSocket(9090);
			//准备接受数据
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			boolean flag = true;
			while(flag){
				socket.receive(packet);
				System.out.println(packet.getAddress().getHostAddress()+"说："+new String(buf,0,packet.getLength()));
			}
			//关闭资源
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
