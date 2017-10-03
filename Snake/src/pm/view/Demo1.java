package pm.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pm.util.FrameUtil;

public class Demo1 extends JPanel{
	public static int WIDTH = 40; //地图列数
	public static int HEIGHT = 30; //地图行数
	//定义格子的像素
	public static final int CELLWIDTH = 20;
	public static final int CELLHEIGHT = 20;
	
	//使用集合保存蛇节点的所有信息
	LinkedList<Point> snake = new LinkedList<Point>();
	
	private boolean[][] background = new boolean[HEIGHT][WIDTH];
	
	//初始化蛇
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}

	//初始化地图
	public void initbackground(){
		for(int rows = 0; rows<background.length ;rows++){
			for(int cols = 0; cols<background[rows].length;cols++){
				if(rows==0||rows==(HEIGHT-1)){
					background[rows][cols]= true;
				}else{
					background[rows][cols]= false;
				}
			}		
		}	
	}
	public void paint(Graphics g){
		//画地图
		for(int rows = 0; rows<background.length ;rows++){
			for(int cols = 0; cols<background[rows].length;cols++){
				if(background[rows][cols]){
					//石头
					g.setColor(Color.GRAY);
				}else{
					//空地
					g.setColor(Color.WHITE);
				}
				//画矩形
				g.fill3DRect(cols*CELLWIDTH, rows*CELLHEIGHT, CELLWIDTH, CELLHEIGHT, true);
			}
				
		}
		//画蛇
		//取出蛇头
		Point head = snake.getFirst();
		g.setColor(Color.RED);
		g.fill3DRect(head.x*CELLWIDTH, head.y*CELLWIDTH, CELLWIDTH, CELLHEIGHT, true);
		//画蛇身
		for(int i=1; i<snake.size();i++){
			Point body = snake.get(i);
			g.setColor(Color.GREEN);
			g.fill3DRect(body.x*CELLWIDTH, body.y*CELLWIDTH, CELLWIDTH, CELLHEIGHT, true);
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("贪吃蛇");
		Demo1 demo1 =  new Demo1();
		demo1.initbackground();
		demo1.initSnake();
		frame.add(demo1);
		FrameUtil.initframe(frame, WIDTH*CELLWIDTH+20,HEIGHT*CELLHEIGHT+40);
		//添加事件监听
		frame.addKeyListener(new KeyAdapter() {
				
		});
	}
}
