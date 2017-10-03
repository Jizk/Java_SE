package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端
public class Demo1Receive {
	public static void main(String[] args) throws IOException {
		//建立UDP服务，监听一个端口号
		DatagramSocket socket = new DatagramSocket(9090);
		//准备空的数据包接收数据
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		//调用UDP服务接收数据
		socket.receive(packet);//数据实际上存储到buf数组中,是一个阻塞的方法，没有接收到之前会一直等待
		//
		System.out.println("接收到的数据是："+ new String(buf,0,packet.getLength()));//获取了数据包存储了几个字节
		//关闭资源
		socket.close();
	
	}
}
