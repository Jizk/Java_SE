package pm.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
���ֹ����������ֹ���������ָ������İڷ�λ�� 

BorderLayout ���߿򲼾ֹ�������
	�ڷŷ���ϱ����������Ҷ���
	1�����û��ָ������ķ�λ��Ĭ����ӵ��м�λ����
	2�������������û�ж�Ӧ���������ô�м�λ�õ�����ͻ�ռ�����ȱ��λ��
	3������Ĭ�ϵ��Ǳ߿򲼾ֹ�����
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�߿򲼾ֹ�����");
		BorderLayout borderLayout  = new  BorderLayout();
		//�ô���ʹ�ñ߿򲼾ֹ�����
		frame.setLayout(borderLayout);
		frame.add(new JButton("��"),borderLayout.NORTH);
		frame.add(new JButton("��"),borderLayout.SOUTH);
		frame.add(new JButton("��"),borderLayout.WEST);
		frame.add(new JButton("��"),borderLayout.EAST);
		frame.add(new JButton("��"),borderLayout.CENTER);
		FrameUtil.initframe(frame, 300, 300);
	}
}
