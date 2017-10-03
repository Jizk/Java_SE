package pm.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
事件：
	事件源		监听器		事件		处理方式
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("窗体");
		JButton button =  new JButton("点啊");
		frame.add(button);
		//给按钮添加动作监听器 
		//匿名内部类
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button= (JButton)e.getSource();//获取到事件源
				if(button.getText().equals("点啊")){
					button.setText("点吧");
				}else{
					button.setText("点啊");
				}
			}
		});
		FrameUtil.initframe(frame, 300, 400);
	}
}
