package pm.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pm.util.FrameUtil;

/*
 ��ʽ���ֹ�������FlowLayout��
 	1��Ĭ��������ж���
 	2�����Ĭ�ϵ�����ʽ���ֹ�����
 
 */
public class Demo2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("��ʽ���ֹ�����");
		JPanel panel = new JPanel();
		frame.add(panel);
		FlowLayout flowLayout =  new FlowLayout(FlowLayout.LEFT);//�����
		panel.setLayout(flowLayout);
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		FrameUtil.initframe(frame, 300, 400);
	}
}
