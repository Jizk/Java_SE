package pm.frame;

import java.awt.FileDialog;

import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
�ļ��Ի���FileDialog����


*/
public class Demo3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		//����һ���ļ��Ի���
		//��
		/*FileDialog dialog = new FileDialog(frame,"��ѡ��򿪵��ļ�",FileDialog.LOAD);*/
		//����
		FileDialog dialog = new FileDialog(frame,"��ѡ�񱣴��·��",FileDialog.SAVE);
		FrameUtil.initframe(frame, 300, 400);
		dialog.setVisible(true);
		System.out.println("�ļ���Ŀ¼"+dialog.getDirectory());
		System.out.println("�ļ���"+dialog.getFile());
	}
}
