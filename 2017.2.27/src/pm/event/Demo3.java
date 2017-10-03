package pm.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
 键盘事件监听器:
 */
public class Demo3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("键盘事件监听器");
		JButton button = new JButton("按钮");
		frame.add(button);
		//给按钮添加键盘事件监听器
		/*button.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("键入某个键");
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("释放某个键");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("按下某个键");
				
			}
		});*/
		//添加适配器
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			//	System.out.println("按下的字符"+e.getKeyChar());
			//	System.out.println("获取对应的数值"+e.getKeyCode());
				
			}
		});
		FrameUtil.initframe(frame, 300, 300);
	}
}
