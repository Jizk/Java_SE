/*
 �����˿���,��ʵ��ϴ�ƹ���
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
	 public String toString(){   //��дtoString����
		 return "{"+color+num+"}";
	 } 
}
public class Demo1 {
	public static void main(String[] args) {
		LinkedList pokers =  creatPoker();
		shufflePoker(pokers);
		showPoker(pokers);
		
		
	}
	//�����˿��Ƶķ���
	public static LinkedList creatPoker(){
		LinkedList list = new LinkedList();  //�ü������ڴ洢�˿��ƶ���
		String[] colors ={"����","����","����","÷��"};
		String[] nums={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<colors.length;i++){
			for(int j=0;j<nums.length;j++){
				list.add(new Poker(colors[i],nums[j]));
			}
		}
		return list;
	}
	//��ʾ�˿��Ƶķ���
	public static void showPoker(LinkedList pokers){
		for(int i=0;i<pokers.size();i++){
			System.out.print(pokers.get(i));
			if(i%10==9){
				System.out.println();
			}
		}
	}
	//ϴ�Ƶķ���
	public static void shufflePoker(LinkedList pokers){
		Random random= new Random();
		for(int i=0;i<100;i++){
			//���������������ֵ
			int index1=random.nextInt(pokers.size());
			int index2=random.nextInt(pokers.size());
			//��������ֵȡ��������
			Poker pokers1=(Poker)pokers.get(index1);
			Poker pokers2=(Poker)pokers.get(index2);
			//�����ƽ���˳��
			pokers.set(index1,pokers2);
			pokers.set(index2, pokers1);
		}
	}

}
