package pm.snake;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
	public static int WIDTH = 35; //��ͼ����
	public static int HEIGHT = 9; //��ͼ����
	//��ͼ
	private char[][] background = new char[HEIGHT][WIDTH];
	//ʹ�ü��ϱ����߽ڵ��������Ϣ
	LinkedList<Point> snake = new LinkedList<Point>();
	//ʳ��
	Point food;
	//�������ƶ�
	public void moveUp(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x,head.y-1));
		snake.removeLast();
		
	}
	//�������ƶ�
	public void moveDown(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x,head.y+1));
		snake.removeLast();
		
	}
	//�������ƶ�
	public void moveLeft(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x-1,head.y));
		snake.removeLast();
		
	}
	//�������ƶ�
	public void moveRight(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x+1,head.y));
		snake.removeLast();
		
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
				if(rows==0||rows==(HEIGHT-1)||cols==0||cols==(WIDTH-1)){
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
	public static void main(String[] args) {
		SnakeGame snake = new SnakeGame();
		snake.initbackground();
		snake.initSnake();
		snake.createFood();
		snake.showFood();
		snake.showSnake();
		snake.showBackground();
		
		for(int i =0;i<3;i++){
			snake.moveUp();
			snake.reFrash();
		}
		for(int i =0;i<3;i++){
			snake.moveDown();
			snake.reFrash();
		}
		for(int i =0;i<3;i++){
			snake.moveLeft();
			snake.reFrash();
		}
		for(int i =0;i<3;i++){
			snake.moveRight();
			snake.reFrash();
		}
	}
}
