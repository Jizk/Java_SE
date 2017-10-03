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
	public static int WIDTH = 40; //��ͼ����
	public static int HEIGHT = 30; //��ͼ����
	//������ӵ�����
	public static final int CELLWIDTH = 20;
	public static final int CELLHEIGHT = 20;
	
	//ʹ�ü��ϱ����߽ڵ��������Ϣ
	LinkedList<Point> snake = new LinkedList<Point>();
	
	private boolean[][] background = new boolean[HEIGHT][WIDTH];
	
	//��ʼ����
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}

	//��ʼ����ͼ
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
		//����ͼ
		for(int rows = 0; rows<background.length ;rows++){
			for(int cols = 0; cols<background[rows].length;cols++){
				if(background[rows][cols]){
					//ʯͷ
					g.setColor(Color.GRAY);
				}else{
					//�յ�
					g.setColor(Color.WHITE);
				}
				//������
				g.fill3DRect(cols*CELLWIDTH, rows*CELLHEIGHT, CELLWIDTH, CELLHEIGHT, true);
			}
				
		}
		//����
		//ȡ����ͷ
		Point head = snake.getFirst();
		g.setColor(Color.RED);
		g.fill3DRect(head.x*CELLWIDTH, head.y*CELLWIDTH, CELLWIDTH, CELLHEIGHT, true);
		//������
		for(int i=1; i<snake.size();i++){
			Point body = snake.get(i);
			g.setColor(Color.GREEN);
			g.fill3DRect(body.x*CELLWIDTH, body.y*CELLWIDTH, CELLWIDTH, CELLHEIGHT, true);
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("̰����");
		Demo1 demo1 =  new Demo1();
		demo1.initbackground();
		demo1.initSnake();
		frame.add(demo1);
		FrameUtil.initframe(frame, WIDTH*CELLWIDTH+20,HEIGHT*CELLHEIGHT+40);
		//����¼�����
		frame.addKeyListener(new KeyAdapter() {
				
		});
	}
}
