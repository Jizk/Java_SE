package pm.TCP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/*
 1。编写一个服务器可一个多个客服发送图片



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
			//获取socke的输出流对象
			OutputStream outputStream = socket.getOutputStream();
			//获取到图片的输入流对象
			FileInputStream fileInputStream = new FileInputStream("F:\\");
			//读取图片数据，把数据写出
			byte[] buf =  new byte[1024];
			int length = 0;
			while((length=fileInputStream.read())!=-1){
				outputStream.write(buf,0,length);
			}
			//统计多少人下载了图片，不允许有重复存在，用HashSet
			//获取对方的IP地址对象，地址
			String ip = socket.getInetAddress().getHostAddress();
			if(set.add(ip)){
				System.out.println(ip+"成功下载，当前现在的人数是"+set.size());
			}
			//关闭资源
			fileInputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) throws IOException {
		//建立一个TCP服务，并且要监听一个端口 
		ServerSocket serverSocket = new ServerSocket(9090);
		while(true){
			//接受用户的连接
			Socket socket = serverSocket.accept();
			new ImageServer(socket).start();
		}
	}
}
