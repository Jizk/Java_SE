package pm.TCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ImageCilent {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
		InputStream inputStream = socket.getInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream("F:\\");
		byte[] buf = new byte[1024];
		int length = 0;
		while((length = inputStream.read())!=-1){
			fileOutputStream.write(buf,0,length);
		}
		//¹Ø±Õ×ÊÔ´
		fileOutputStream.close();
		socket.close();
	}
	
}
