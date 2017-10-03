package pm.TCP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/*
 1����дһ����������һ������ͷ�����ͼƬ



 */
public class ImageServer extends Thread{
	
	Socket socket;
	static HashSet<String> set = new HashSet<String>();
	
	public ImageServer(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//��ȡsocke�����������
			OutputStream outputStream = socket.getOutputStream();
			//��ȡ��ͼƬ������������
			FileInputStream fileInputStream = new FileInputStream("F:\\");
			//��ȡͼƬ���ݣ�������д��
			byte[] buf =  new byte[1024];
			int length = 0;
			while((length=fileInputStream.read())!=-1){
				outputStream.write(buf,0,length);
			}
			//ͳ�ƶ�����������ͼƬ�����������ظ����ڣ���HashSet
			//��ȡ�Է���IP��ַ���󣬵�ַ
			String ip = socket.getInetAddress().getHostAddress();
			if(set.add(ip)){
				System.out.println(ip+"�ɹ����أ���ǰ���ڵ�������"+set.size());
			}
			//�ر���Դ
			fileInputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) throws IOException {
		//����һ��TCP���񣬲���Ҫ����һ���˿� 
		ServerSocket serverSocket = new ServerSocket(9090);
		while(true){
			//�����û�������
			Socket socket = serverSocket.accept();
			new ImageServer(socket).start();
		}
	}
}
