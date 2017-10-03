package pm.compnent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import pm.util.FrameUtil;

/*
菜单组件：
	菜单条（MenuBar） 菜单 （Menu）  菜单项（MenuItem）
	菜单条可以添加菜单
	菜单可以添加菜单项
	
复选菜单
	首先菜单添加菜单，菜单添加菜单项

*/
public class Demo2 {
	JFrame frame = new JFrame();
	
	JMenuBar bar =  new JMenuBar();
	
	JMenu fileMenu = new JMenu("文件");
	JMenu editMenu =  new JMenu("编辑");
	
	JMenuItem openMenu = new JMenuItem("打开");
	JMenuItem saveMenu = new JMenuItem("保存");
	JMenuItem aboutMenu = new JMenuItem("关于");
	JMenuItem closeMenu = new JMenuItem("关闭");
	
	JMenu menu =  new JMenu("切换");
	JMenuItem item1 = new JMenuItem("1");
	JMenuItem item2 = new JMenuItem("2");
	JMenuItem item3 = new JMenuItem("3");
	
	JTextArea area =  new JTextArea(20, 30);
	
	public void initNotepad(){
		//添加复选菜单
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		fileMenu.add(menu);
		
		//菜单添加菜单项
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		editMenu.add(aboutMenu);
		editMenu.add(closeMenu);
		 //菜单条添加菜单
		bar.add(fileMenu);
		bar.add(editMenu);
		//添加菜单条，文本
		frame.add(bar,BorderLayout.NORTH);//菜单条在上，否则容易覆盖
		frame.add(area);
		FrameUtil.initframe(frame, 300, 400);
	}
	public static void main(String[] args) {
		new Demo2().initNotepad();
	}
}
