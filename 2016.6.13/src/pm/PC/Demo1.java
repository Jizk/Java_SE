/*�߳�ͨѶ һ���߳�������Լ�������ʱ,Ҫ֪ͨ����һ���߳�ȥ�������һ������
 wait()����       �ȴ�
 notify()����  ����
 ������ Object�����,������ͬ����������ͬ��������ʹ��,����Ҫ��������
 ������,����������
 ʵ������һ��,����һ��
 */
package pm.PC;
//��Ʒ��
class Product{
	String name;
	double  price;
	boolean flag = false;  //��Ʒ������ʶ,Ĭ��û����
}
//������
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
						p.name="ƻ��";
						p.price=6.5;
					}else{
						p.name="�㽶";
						p.price=2.0;
					}
					i++;
					p.flag=true; //�������
					System.out.println("������������"+p.name+",�۸���:"+p.price);
					p.notify();  //����������
				}else{
					try {
						p.wait();  //�����ߵȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
//������
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
					System.out.println("������������"+p.name+",�۸���:"+p.price);
					p.flag=false;
					p.notify(); //����������
				}
				else{
					try {
						p.wait();  //�����ߵȴ�
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