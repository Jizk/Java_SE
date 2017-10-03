package pm.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
鼠标事件监听器

 */
public class Demo2 {
	public static void main(String[] args) {
		JFrame frame =  new JFrame("鼠标事件监听器");
		JButton button =  new JButton("按钮");
		frame.add(button);
		//给按钮添加鼠标事件监听器
	/*	button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标松开");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("鼠标按下");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("鼠标移出");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标进入");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("鼠标单击");
				
			}
		});*/
		//添加适配器，不必实现MouseListener的所有方法
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	System.out.println("鼠标单击");
				if(e.getClickCount()==2){
					System.out.println("鼠标双击");
				}
			}
		});
		FrameUtil.initframe(frame, 300, 300);
	}
}
