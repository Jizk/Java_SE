package pm.compnent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import pm.util.FrameUtil;

/*
 �����������
 
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		JPanel panel =  new JPanel();
		frame.add(panel);
		//�û��� 
		//��ǩ
		JLabel nameLabel = new JLabel("�û�����");
		//�����
		JTextField textField=  new JTextField(15);
		//��ӵ������
		panel.add(nameLabel);
		panel.add(textField);
		//����
		JLabel passLabel = new JLabel("�û�����");
		//�����
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passLabel);
		panel.add(passwordField);
		//�Ա�
		//��ѡ��
		JLabel sexLabel = new JLabel("�Ա�");
		JRadioButton man = new JRadioButton("��",true);//Ĭ��ѡ��
		JRadioButton woman = new JRadioButton("Ů");
		//����ǵ�ѡ�����Ҫ���飬ͬһ��ĵ�ѡ��ֻ��ѡ�����е�һ��
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
	
		panel.add(sexLabel);
		panel.add(man);
		panel.add(woman);
		//����
		//������
		JLabel cityLabel = new JLabel("���У�");
		Object[] objects = {"b","a","c","d"};
		JComboBox citys =  new JComboBox(objects);
		panel.add(cityLabel);
		panel.add(citys);
		//��Ȥ����
		//��ѡ��
		JLabel habitLabel = new JLabel("��Ȥ���ã�");
		JCheckBox checkBox1 =  new JCheckBox("a",true);
		JCheckBox checkBox2 =  new JCheckBox("b",true);
		JCheckBox checkBox3 =  new JCheckBox("c");
		panel.add(habitLabel);
		panel.add(checkBox1);
		panel.add(checkBox2);
		panel.add(checkBox3);
		//���˼��
		//
		JLabel Label = new JLabel("���˼�飺");
		JTextArea area =  new JTextArea(20, 15);
		//�Զ�����
		area.setLineWrap(true);
		panel.add(Label);
		panel.add(area);
		
		
		FrameUtil.initframe(frame, 800, 400);
	}
}
