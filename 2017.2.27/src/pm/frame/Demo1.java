package pm.frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
����Ľ�����ʽ��
   1.����̨�Ľ�����ʽ
   2.ͼ�λ�����
   
��java�е�ͼ���౻��Ϊ����ࡣ
 
 ��������
 	�������
 	���������
 	
 	
*/
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JAVA"); //���岻�ɼ�
		//���ô����С
		//frame.setSize(300, 400); //���� �� ��
		//�������Ͻǳ��ֵ�λ��
		//frame.setBounds(x, y, 300, 400);//��һ�������Ͻǳ��ֵ�x�����꣬�ڶ�����y�����꣬�������Ǵ�������ĸ��Ǵ����
		initframe(frame,300,400);
		frame.setVisible(true);//���ô���Ŀɼ���
		//���ô���رյ��¼�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//��ȡ��Ļ�ֱ��ʣ����ô�������Ļ����λ��
	public static void initframe(JFrame frame,int width,int height){
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //��ȡһ����ϵͳ��صĹ�����
		Dimension d = toolkit.getScreenSize();
		int x =(int) d.getWidth();
		int y =(int)d.getHeight();
		frame.setBounds((x-width)/2,( y-height)/2, width, height);
	}
}
