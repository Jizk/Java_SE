package pm.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pm.util.FrameUtil;

/*
��� JPanel
 
 */
public class Demo4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		//����һ�����
		JPanel panel = new JPanel();
		//�������ı�����ɫ
		panel.setBackground(Color.red);
		//�������ӵ�����
		frame.add(panel);
		FrameUtil.initframe(frame, 300,400);
	}
}
