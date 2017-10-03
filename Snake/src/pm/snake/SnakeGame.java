package pm.snake;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import pm.util.FrameUtil;

public class SnakeGame {
	public static int WIDTH = 35; //��ͼ����
	public static int HEIGHT = 9; //��ͼ����
	//��ͼ
	private char[][] background = new char[HEIGHT][WIDTH];
	//ʹ�ü��ϱ����߽ڵ��������Ϣ
	LinkedList<Point> snake = new LinkedList<Point>();
	//ʳ��
	Point food;
	//��ʼ��Ϸ״̬
	static boolean isGameOver = false;
	//�߳�ʼ���ķ���
	public static final int UP_DIRCTION = 1;
	public static final int DOWN_DIRCTION = -1;
	public static final int LEFT_DIRCTION = 2;
	public static final int RIGHT_DIRCTION = -2;
	int currentDirction = -2;
	//���ƶ��ķ���
	public void move(){
		Point head = snake.getFirst();
		switch (currentDirction) {
			case UP_DIRCTION:
				snake.addFirst(new Point(head.x,head.y-1));
				break;
			case DOWN_DIRCTION:
				snake.addFirst(new Point(head.x,head.y+1));
				break;
			case LEFT_DIRCTION:
				if(head.x==0){
					snake.addFirst(new Point(WIDTH-1,head.y));
				}else{
					snake.addFirst(new Point(head.x-1,head.y));
				}
				break;
			case RIGHT_DIRCTION:
				if(head.x==WIDTH-1){
					snake.addFirst(new Point(0,head.y));
				}else{
					snake.addFirst(new Point(head.x+1,head.y));
				}
				break;
	
			default:
				break;
		}
		if(eatFood()){
			createFood();
		}else{
			snake.removeLast();
		}
	}
	//�ı䷽��
	public void changeDirction(int newDirction){
		if(newDirction+currentDirction!=0){
			this.currentDirction = newDirction;
		}
	}
	//����ʳ��
	public void createFood(){
		//����һ�����������
		Random random = new Random();
		while(true){
			int x =random.nextInt(WIDTH);
			int y =random.nextInt(HEIGHT);
			if(background[y][x]!='*'){
				food = new Point(x,y);
				break;
			}
		}
	}
	//��ʾʳ��
	public void showFood(){
		background[food.y][food.x]= '@';
	}
	//��ʳ��
	public boolean eatFood(){
		Point head = snake.getFirst();
		if(head.equals(food)){
			return true;
		}
		return false;
	}
	
	//��ʼ����
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}
	//��ʾ��
	public void showSnake(){
		//ȡ����ͷ
		Point head = snake.getFirst();
		background[head.y][head.x]= '$';
		//������
		for(int i=1; i<snake.size();i++){
			Point body = snake.get(i);
			background[body.y][body.x]= '#';
		}
	}
	
	//��ʼ����ͼ
	public void initbackground(){
		for(int rows = 0; rows<background.length ;rows++){
			for(int cols = 0; cols<background[rows].length;cols++){
				if(rows==0||rows==(HEIGHT-1)){
					background[rows][cols]= '*';
				}else{
					background[rows][cols]= ' ';
				}
			}		
		}	
	}
	public void showBackground() {
		for(int rows = 0; rows<background.length ;rows++){
			for(int cols = 0; cols<background[rows].length;cols++){
				System.out.print(background[rows][cols]);
			}
				System.out.println();
		}
	} 
	//ˢ����Ϸ״̬
	public void reFrash(){
		//�����Ϸ��״̬��Ϣ
		initbackground();
		//��ʾ��
		showSnake();
		//��ʾʳ��
		showFood();
		//��ʾ��ͼ
		showBackground();
	}
	//������Ϸ
	public void isGameOver(){
		Point head = snake.getFirst();
		//ײǽ
		if(background[head.y][head.x]=='*'){
			isGameOver = true;
		}
		//ҧ���Լ�
		for(int i = 1;i < snake.size();i++){
			Point body = snake.get(i);
			if(head.equals(body)){
				isGameOver=true; 
			}
		}
	}
	public static void main(String[] args) {
		final SnakeGame snake = new SnakeGame();
		snake.initbackground();
		snake.initSnake();
		snake.createFood();
		snake.showFood();
		snake.showSnake();
		snake.showBackground();
		
		JFrame frame = new JFrame("�������");
		JButton button = new JButton("���Ʒ���");
		frame.add(button);
		frame.add(new JButton("��"),BorderLayout.NORTH);
		frame.add(new JButton("��"),BorderLayout.SOUTH);
		frame.add(new JButton("��"),BorderLayout.WEST);
		frame.add(new JButton("��"),BorderLayout.EAST);
		FrameUtil.initframe(frame, 200, 200);
		button.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_UP:
					snake.changeDirction(UP_DIRCTION);
					break;
				case KeyEvent.VK_DOWN:
					snake.changeDirction(DOWN_DIRCTION);
					break;
				case KeyEvent.VK_LEFT:
					snake.changeDirction(LEFT_DIRCTION);
					break;
				case KeyEvent.VK_RIGHT:
					snake.changeDirction(RIGHT_DIRCTION);
					break;

				default:
					break;
				}
				snake.move();
				snake.isGameOver();
				snake.reFrash();
				if(isGameOver) {
					System.out.println("��Ϸ����");
					System.exit(0);
				}
				
			}
		});
	}
}
