package pm.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 �����̣���Ҫ�ǽ������������������ݴ������⡣
 
 �����̣�����Ҫ����htmlҳ��Ϳ��Դﵽ����֮��Ĵ��� 
 
 ��ҳ��̣�Ҫ����htmlҳ��Ļ����Ͻ������ݵĽ���

 ����ͨѶ����Ҫ�أ�
 	IP
 	�˿ں� ���ڱ�������Ϣ�͸��ĸ�Ӧ�ó�����ģ���һ����ʶ��
 	Э��
 	 
 InetAddress(IP��)
 ���õķ�����
 		  getLocalHost() ��ȡ������IP��ַ
 		  getByName()���Ը���һ��IP��ַ���ַ�����ʽ����һ������������һ��IP��ַ����(��ȡ���˵�IP��ַ����)
 		  
 		  getHostAddress() ����һ��IP��ַ���ַ�����ʾ��ʽ
 		  getHostName() ���ؼ������������
 
 
 �˿ں���û���������ģ��˿ںŷ�Χ��0~65535
 
 ����ͨѶЭ�飺 
 UDPЭ��
 
 
 TCPЭ��
 		  
 */

public class Demo1 {
	public static void main(String[] args) throws UnknownHostException {
		/*
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP��ַ:"+address.getHostAddress());
		System.out.println("������:"+address.getHostName());
		*/
		//��ȡ���˵�IP��ַ
		//���Ը���һ��IP��ַ���ַ�����ʽ����һ������������һ��IP��ַ����
		InetAddress address = InetAddress.getByName("169.254.78.113");
		
		InetAddress[] arr = InetAddress.getAllByName("www.baidu.com");//����
		
	}
}
