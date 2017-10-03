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
			//建立UDP服务
			DatagramSocket socket = new DatagramSocket();
			//准备数据，将数据封装到数据包中
			// BufferedReader提供一行一行读键盘录入的功能
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			//建立数据包
			DatagramPacket packet = null;
			while((line = reader.readLine())!=null){
				//把数据封装到数据包中，准备发送
				packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.15.255"), 9090);
				//将数据发送出去
				socket.send(packet);
				
			}
			//关闭资源
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
