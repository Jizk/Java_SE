/*线程*/
package pn.Thread;

class Thread1 extends Thread{

	@Override
	public void run() {
		while(true){
			System.out.println("线程1......");
		}
	}
	
}
class Thread2 extends Thread{

	@Override
	public void run() {
		while(true){
			System.out.println("线程2......");
		}
	}
	
}
public class Demo1 {
	
	public static void main(String[] args) {
		Thread1 t1= new Thread1();
		t1.start();
		Thread2 t2= new Thread2();
		t2.start();
	}

}
