package pm.UDP;

public class ChatMain {
	public static void main(String[] args) {
		
		ChatReceive receive = new ChatReceive();
		receive.start();
		
		ChatSender sender = new ChatSender();
		sender.start();
	}
}