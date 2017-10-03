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
 非容器组件：
 
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("窗体");
		JPanel panel =  new JPanel();
		frame.add(panel);
		//用户名 
		//标签
		JLabel nameLabel = new JLabel("用户名：");
		//输入框
		JTextField textField=  new JTextField(15);
		//添加到面板上
		panel.add(nameLabel);
		panel.add(textField);
		//密码
		JLabel passLabel = new JLabel("用户名：");
		//密码框
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passLabel);
		panel.add(passwordField);
		//性别
		//单选框
		JLabel sexLabel = new JLabel("性别：");
		JRadioButton man = new JRadioButton("男",true);//默认选中
		JRadioButton woman = new JRadioButton("女");
		//如果是单选框必须要分组，同一组的单选框只能选择其中的一个
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
	
		panel.add(sexLabel);
		panel.add(man);
		panel.add(woman);
		//故乡
		//下拉框
		JLabel cityLabel = new JLabel("城市：");
		Object[] objects = {"b","a","c","d"};
		JComboBox citys =  new JComboBox(objects);
		panel.add(cityLabel);
		panel.add(citys);
		//兴趣爱好
		//复选框
		JLabel habitLabel = new JLabel("兴趣爱好：");
		JCheckBox checkBox1 =  new JCheckBox("a",true);
		JCheckBox checkBox2 =  new JCheckBox("b",true);
		JCheckBox checkBox3 =  new JCheckBox("c");
		panel.add(habitLabel);
		panel.add(checkBox1);
		panel.add(checkBox2);
		panel.add(checkBox3);
		//个人简介
		//
		JLabel Label = new JLabel("个人简介：");
		JTextArea area =  new JTextArea(20, 15);
		//自动换行
		area.setLineWrap(true);
		panel.add(Label);
		panel.add(area);
		
		
		FrameUtil.initframe(frame, 800, 400);
	}
}
