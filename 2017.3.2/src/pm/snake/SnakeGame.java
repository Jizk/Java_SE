package pm.snake;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame {
	public static int WIDTH = 35; //地图列数
	public static int HEIGHT = 9; //地图行数
	//地图
	private char[][] background = new char[HEIGHT][WIDTH];
	//使用集合保存蛇节点的所有信息
	LinkedList<Point> snake = new LinkedList<Point>();
	//食物
	Point food;
	//蛇向上移动
	public void moveUp(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x,head.y-1));
		snake.removeLast();
		
	}
	//蛇向下移动
	public void moveDown(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x,head.y+1));
		snake.removeLast();
		
	}
	//蛇向左移动
	public void moveLeft(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x-1,head.y));
		snake.removeLast();
		
	}
	//蛇向右移动
	public void moveRight(){
		Point head = snake.getFirst();
		snake.addFirst(new Point(head.x+1,head.y));
		snake.removeLast();
		
	}
	//生成食物
	public void createFood(){
		//创建一个随机数对象
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
	//显示食物
	public void showFood(){
		background[food.y][food.x]= '@';
	}
	
	//初始化蛇
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}
	//显示蛇
	public void showSnake(){
		//取出蛇头
		Point head = snake.getFirst();
		background[head.y][head.x]= '$';
		//画蛇身
		for(int i=1; i<snake.size();i++){
			Point body = snake.get(i);
			background[body.y][body.x]= '#';
		}
	}
	
	//初始化地图
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
	//刷新游戏状态
	public void reFrash(){
		//清空游戏的状态信息
		initbackground();
		//显示蛇
		showSnake();
		//显示食物
		showFood();
		//显示地图
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
