package pm.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
�¼���
	�¼�Դ		������		�¼�		����ʽ
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		JButton button =  new JButton("�㰡");
		frame.add(button);
		//����ť��Ӷ��������� 
		//�����ڲ���
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button= (JButton)e.getSource();//��ȡ���¼�Դ
				if(button.getText().equals("�㰡")){
					button.setText("���");
				}else{
					button.setText("�㰡");
				}
			}
		});
		FrameUtil.initframe(frame, 300, 400);
	}
}
