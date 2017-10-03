package pm.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
//初始化窗体的工具类
public class FrameUtil {
	public static void initframe(JFrame frame,int width,int height){
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //获取一个与系统相关的工具类
		Dimension d = toolkit.getScreenSize();
		int x =(int) d.getWidth();
		int y =(int)d.getHeight();
		frame.setBounds((x-width)/2,( y-height)/2, width, height);
		frame.setVisible(true);//设置窗体的可见性
		//设置窗体关闭的事件
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
