/*��Ʊ����*/
//�̰߳�ȫ����
//ԭ��: int numΪ�Ǿ�̬��Ա ,��ÿ�������ж������һ��. ���: ����Ϊ��̬��Ա
/*�̰߳�ȫ��������ʽ
 	��ʽһ: ͬ�������
 		synchronized(������){     ������ֻҪ�Ƕ�����ǿ��Ե�,���̵߳������������Ψһ�����
 		 			........
 		}
 	��ʽ��:ͬ������

 */
package pn.Thread;
class SaleTicket extends Thread{
	static int num=50;
	static Object o = new Object();//������
	public SaleTicket(String name){
		super(name);
	}
	public void run(){
		while(true){
			synchronized("1"){ //ͬ�������
				if(num>0){
					System.out.println(Thread.currentThread().getName()+"�۳��˵�"+num+"��Ʊ");
					num--;
				}else{
					System.out.println("������");
					break;
				}
			}
		}
	}
}
public class Demo2 {

	
	public static void main(String[] args) {
		SaleTicket thread1 = new SaleTicket("����һ");
		SaleTicket thread2 = new SaleTicket("���ڶ�");
		SaleTicket thread3 = new SaleTicket("������ ");
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
