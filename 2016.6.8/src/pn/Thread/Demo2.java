/*售票问题*/
//线程安全问题
//原因: int num为非静态成员 ,在每个对象中都会存在一份. 解决: 定义为静态成员
/*线程安全问题解决方式
 	方式一: 同步代码块
 		synchronized(锁对象){     锁对象只要是对象就是可以的,多线程的锁对象必须是唯一共享的
 		 			........
 		}
 	方式二:同步函数

 */
package pn.Thread;
class SaleTicket extends Thread{
	static int num=50;
	static Object o = new Object();//锁对象
	public SaleTicket(String name){
		super(name);
	}
	public void run(){
		while(true){
			synchronized("1"){ //同步代码块
				if(num>0){
					System.out.println(Thread.currentThread().getName()+"售出了第"+num+"号票");
					num--;
				}else{
					System.out.println("售完了");
					break;
				}
			}
		}
	}
}
public class Demo2 {

	
	public static void main(String[] args) {
		SaleTicket thread1 = new SaleTicket("窗口一");
		SaleTicket thread2 = new SaleTicket("窗口二");
		SaleTicket thread3 = new SaleTicket("窗口三 ");
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
