package pm.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
 ��񲼾ֹ�������GridLayout��
 	1.�������������ʱ��Ĭ�ϻ���һ��
 
 
 */
public class Demo3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("��񲼾ֹ�����");
		GridLayout gridLayout =  new GridLayout(4,4);
		frame.setLayout(gridLayout);
		for(int i = 0;i < 10;i++){
			frame.add(new JButton(i+""));
		}
		frame.add(new JButton("+"));
		frame.add(new JButton("-"));
		frame.add(new JButton("*"));
		frame.add(new JButton("/"));
		frame.add(new JButton("="));
		frame.add(new JButton("."));
		FrameUtil.initframe(frame, 300, 300);
	}
}
