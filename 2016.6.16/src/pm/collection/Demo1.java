/*
 生成扑克牌,并实现洗牌功能
 */

package pm.collection;

import java.util.LinkedList;
import java.util.Random;

class Poker{
	 String color;
	 String num;
	 public Poker(String color,String num){
		 this.color= color;
		 this.num= num;
	 }
	 public String toString(){   //重写toString方法
		 return "{"+color+num+"}";
	 } 
}
public class Demo1 {
	public static void main(String[] args) {
		LinkedList pokers =  creatPoker();
		shufflePoker(pokers);
		showPoker(pokers);
		
		
	}
	//生成扑克牌的方法
	public static LinkedList creatPoker(){
		LinkedList list = new LinkedList();  //该集合用于存储扑克牌对象
		String[] colors ={"黑桃","红桃","方块","梅花"};
		String[] nums={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<colors.length;i++){
			for(int j=0;j<nums.length;j++){
				list.add(new Poker(colors[i],nums[j]));
			}
		}
		return list;
	}
	//显示扑克牌的方法
	public static void showPoker(LinkedList pokers){
		for(int i=0;i<pokers.size();i++){
			System.out.print(pokers.get(i));
			if(i%10==9){
				System.out.println();
			}
		}
	}
	//洗牌的方法
	public static void shufflePoker(LinkedList pokers){
		Random random= new Random();
		for(int i=0;i<100;i++){
			//随机产生两个索引值
			int index1=random.nextInt(pokers.size());
			int index2=random.nextInt(pokers.size());
			//根据索引值取出两张牌
			Poker pokers1=(Poker)pokers.get(index1);
			Poker pokers2=(Poker)pokers.get(index2);
			//两张牌交换顺序
			pokers.set(index1,pokers2);
			pokers.set(index2, pokers1);
		}
	}

}
