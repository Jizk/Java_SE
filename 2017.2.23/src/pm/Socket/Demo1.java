package pm.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 网络编程：主要是解决计算机与计算机的数据传输问题。
 
 网络编程：不需要基于html页面就可以达到数据之间的传输 
 
 网页编程：要基于html页面的基础上进行数据的交互

 网络通讯的三要素：
 	IP
 	端口号 用于标明该消息就给哪个应用程序处理的，是一个标识符
 	协议
 	 
 InetAddress(IP类)
 常用的方法：
 		  getLocalHost() 获取本机的IP地址
 		  getByName()可以根据一个IP地址的字符串形式或者一个主机名生成一个IP地址对象(获取别人的IP地址对象)
 		  
 		  getHostAddress() 返回一个IP地址的字符串表示形式
 		  getHostName() 返回计算机的主机名
 
 
 端口号是没有类描述的，端口号范围：0~65535
 
 网络通讯协议： 
 UDP协议
 
 
 TCP协议
 		  
 */

public class Demo1 {
	public static void main(String[] args) throws UnknownHostException {
		/*
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP地址:"+address.getHostAddress());
		System.out.println("主机名:"+address.getHostName());
		*/
		//获取别人的IP地址
		//可以根据一个IP地址的字符串形式或者一个主机名生成一个IP地址对象
		InetAddress address = InetAddress.getByName("169.254.78.113");
		
		InetAddress[] arr = InetAddress.getAllByName("www.baidu.com");//域名
		
	}
}
