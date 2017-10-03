package pm.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
布局管理器：布局管理器用于指定组件的摆放位置 

BorderLayout （边框布局管理器）
	摆放风格：上北下南左西右东中
	1、如果没有指定组件的方位，默认添加到中间位置上
	2、如果东南西北没有对应的组件，那么中间位置的组件就会占据其空缺的位置
	3、窗体默认的是边框布局管理器
 */
public class Demo1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("边框布局管理器");
		BorderLayout borderLayout  = new  BorderLayout();
		//让窗体使用边框布局管理器
		frame.setLayout(borderLayout);
		frame.add(new JButton("北"),borderLayout.NORTH);
		frame.add(new JButton("南"),borderLayout.SOUTH);
		frame.add(new JButton("西"),borderLayout.WEST);
		frame.add(new JButton("东"),borderLayout.EAST);
		frame.add(new JButton("中"),borderLayout.CENTER);
		FrameUtil.initframe(frame, 300, 300);
	}
}
