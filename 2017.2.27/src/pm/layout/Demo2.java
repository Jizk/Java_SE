package pm.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pm.util.FrameUtil;

/*
 流式布局管理器（FlowLayout）
 	1、默认情况居中对齐
 	2、面板默认的是流式布局管理器
 
 */
public class Demo2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("流式布局管理器");
		JPanel panel = new JPanel();
		frame.add(panel);
		FlowLayout flowLayout =  new FlowLayout(FlowLayout.LEFT);//左对齐
		panel.setLayout(flowLayout);
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		FrameUtil.initframe(frame, 300, 400);
	}
}
