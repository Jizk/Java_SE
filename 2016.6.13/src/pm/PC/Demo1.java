/*线程通讯 一个线程完成了自己的任务时,要通知另外一个线程去完成另外一个任务
 wait()方法       等待
 notify()方法  唤醒
 都属于 Object对象的,必须在同步代码快或者同步函数中使用,必须要有锁对象
 生产者,消费者问题
 实现生产一个,消费一个
 */
package pm.PC;
//产品类
class Product{
	String name;
	double  price;
	boolean flag = false;  //产品生产标识,默认没生产
}
//生产者
class Producer extends Thread{
	Product p; 
	public Producer(Product p){
		this.p = p;
	}
	public Producer(String name){
		super(name);
	}
	public void run(){
		int i=0;
		while(true){
			synchronized(p){
				if(p.flag==false){
					if(i%2==0){
						p.name="苹果";
						p.price=6.5;
					}else{
						p.name="香蕉";
						p.price=2.0;
					}
					i++;
					p.flag=true; //生产完毕
					System.out.println("生产者生产了"+p.name+",价格是:"+p.price);
					p.notify();  //唤醒消费者
				}else{
					try {
						p.wait();  //生产者等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
//消费者
class Customer extends Thread{
	Product p;
	public Customer(Product p){
		this.p = p;
	}
	public Customer(String name){
		super(name);
	}
	public void run(){
		while(true){
			synchronized(p){
				if(p.flag==true){
					System.out.println("消费者消费了"+p.name+",价格是:"+p.price);
					p.flag=false;
					p.notify(); //唤醒生产者
				}
				else{
					try {
						p.wait();  //消费者等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
public class Demo1 {
	public static void main(String[] args) {
		Product p= new Product();
		Producer producer = new Producer(p);
		Customer customer = new Customer(p);
		producer.start();
		customer.start();
		
	}

}