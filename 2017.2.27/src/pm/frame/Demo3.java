package pm.frame;

import java.awt.FileDialog;

import javax.swing.JFrame;

import pm.util.FrameUtil;

/*
文件对话框（FileDialog）：


*/
public class Demo3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("窗体");
		//创建一个文件对话框
		//打开
		/*FileDialog dialog = new FileDialog(frame,"请选择打开的文件",FileDialog.LOAD);*/
		//保存
		FileDialog dialog = new FileDialog(frame,"请选择保存的路径",FileDialog.SAVE);
		FrameUtil.initframe(frame, 300, 400);
		dialog.setVisible(true);
		System.out.println("文件的目录"+dialog.getDirectory());
		System.out.println("文件名"+dialog.getFile());
	}
}
