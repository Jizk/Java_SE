package pm.frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pm.util.FrameUtil;

/*
�Ի����ࣨDialog��
	
JOptionPannel(�Ի���)
	��Ϣ�Ի���
	����Ի���
	����Ի���
	����Ի���
	ȷ�϶Ի���

 */
public class Demo2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		/*//�����Ի���
		JDialog dialog = new JDialog(frame,"�Ի���",true);
		//ʹ���Զ���Ĵ��幤����
		
		dialog.setBounds(500, 300, 100, 200);
		dialog.setVisible(true);*/
		FrameUtil.initframe(frame, 300, 400);
		//��Ϣ
		/*JOptionPane.showMessageDialog(frame,"��������", "�Ǻ�",JOptionPane.INFORMATION_MESSAGE);*/
		//����
		/*JOptionPane.showMessageDialog(frame,"��������", "�Ǻ�",JOptionPane.WARNING_MESSAGE);*/
		//����
		/*JOptionPane.showMessageDialog(frame,"��������", "�Ǻ�",JOptionPane.ERROR_MESSAGE);*/
		//����
		/*String s = JOptionPane.showInputDialog("������");
		System.out.println(s);*/
		//ȷ��
		int num = JOptionPane.showConfirmDialog(frame, "ȷ����");
		System.out.println(num);
	}

}
