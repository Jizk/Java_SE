package pm.frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
软件的交互方式：
   1.控制台的交互方式
   2.图形化界面
   
在java中的图形类被成为组件类。
 
 组件的类别：
 	容器组件
 	非容器组件
 	
 	
*/
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JAVA"); //窗体不可见
		//设置窗体大小
		//frame.setSize(300, 400); //像素 宽 高
		//设置左上角出现的位置
		//frame.setBounds(x, y, 300, 400);//第一个是左上角出现的x轴坐标，第二个是y轴坐标，第三个是窗体宽，第四个是窗体高
		initframe(frame,300,400);
		frame.setVisible(true);//设置窗体的可见性
		//设置窗体关闭的事件
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//获取屏幕分辨率，设置窗体在屏幕居中位置
	public static void initframe(JFrame frame,int width,int height){
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //获取一个与系统相关的工具类
		Dimension d = toolkit.getScreenSize();
		int x =(int) d.getWidth();
		int y =(int)d.getHeight();
		frame.setBounds((x-width)/2,( y-height)/2, width, height);
	}
}
