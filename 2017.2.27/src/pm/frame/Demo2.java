package pm.frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pm.util.FrameUtil;

/*
对话框类（Dialog）
	
JOptionPannel(对话框)
	消息对话框
	警告对话框
	错误对话框
	输入对话框
	确认对话框

 */
public class Demo2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("窗体");
		/*//创建对话框
		JDialog dialog = new JDialog(frame,"对话框",true);
		//使用自定义的窗体工具类
		
		dialog.setBounds(500, 300, 100, 200);
		dialog.setVisible(true);*/
		FrameUtil.initframe(frame, 300, 400);
		//消息
		/*JOptionPane.showMessageDialog(frame,"巴拉巴拉", "呵呵",JOptionPane.INFORMATION_MESSAGE);*/
		//警告
		/*JOptionPane.showMessageDialog(frame,"巴拉巴拉", "呵呵",JOptionPane.WARNING_MESSAGE);*/
		//错误
		/*JOptionPane.showMessageDialog(frame,"巴拉巴拉", "呵呵",JOptionPane.ERROR_MESSAGE);*/
		//输入
		/*String s = JOptionPane.showInputDialog("请输入");
		System.out.println(s);*/
		//确认
		int num = JOptionPane.showConfirmDialog(frame, "确认嘛");
		System.out.println(num);
	}

}
