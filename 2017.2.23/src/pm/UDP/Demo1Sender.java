package pm.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 UDP的特点：
 1.将数据极其源和目的封装为数据包，不需要建立连接
 2.每个数据包大小限制在64K中
 3.不可靠
 4.速度快
 例如： feiQ，QQ 
 
UDP协议下的Scoket:
	DatagramSocket(UDP插座服务)
	发送与接收
	DatagramPacket(数据包类)
	DatagramPacket(buf, length, address, port)  发送的数据内容 发送内容的大小 发送的目的地址对象 端口号
*/

//发送端

public class Demo1Sender{
	public static void main(String[] args) throws IOException {
		//建立UDP服务
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//准备数据，将数据封装到数据包中
		String data = "第一个UDP列子";
		//创建了一个数据包
		DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 9090);
		//调用udp的服务发送数据
		datagramSocket.send(datagramPacket);
		//关闭资源  释放占用的端口号
		datagramSocket.close();
	}
	
}











