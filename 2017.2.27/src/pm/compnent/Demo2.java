package pm.compnent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import pm.util.FrameUtil;

/*
�˵������
	�˵�����MenuBar�� �˵� ��Menu��  �˵��MenuItem��
	�˵���������Ӳ˵�
	�˵�������Ӳ˵���
	
��ѡ�˵�
	���Ȳ˵���Ӳ˵����˵���Ӳ˵���

*/
public class Demo2 {
	JFrame frame = new JFrame();
	
	JMenuBar bar =  new JMenuBar();
	
	JMenu fileMenu = new JMenu("�ļ�");
	JMenu editMenu =  new JMenu("�༭");
	
	JMenuItem openMenu = new JMenuItem("��");
	JMenuItem saveMenu = new JMenuItem("����");
	JMenuItem aboutMenu = new JMenuItem("����");
	JMenuItem closeMenu = new JMenuItem("�ر�");
	
	JMenu menu =  new JMenu("�л�");
	JMenuItem item1 = new JMenuItem("1");
	JMenuItem item2 = new JMenuItem("2");
	JMenuItem item3 = new JMenuItem("3");
	
	JTextArea area =  new JTextArea(20, 30);
	
	public void initNotepad(){
		//��Ӹ�ѡ�˵�
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		fileMenu.add(menu);
		
		//�˵���Ӳ˵���
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		editMenu.add(aboutMenu);
		editMenu.add(closeMenu);
		 //�˵�����Ӳ˵�
		bar.add(fileMenu);
		bar.add(editMenu);
		//��Ӳ˵������ı�
		frame.add(bar,BorderLayout.NORTH);//�˵������ϣ��������׸���
		frame.add(area);
		FrameUtil.initframe(frame, 300, 400);
	}
	public static void main(String[] args) {
		new Demo2().initNotepad();
	}
}
