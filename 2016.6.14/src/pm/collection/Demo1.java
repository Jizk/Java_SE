/*��¼ע�Ṧ��*/
package pm.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

class User{
	int id;
	String password;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id,String password){
		this.id=id;
		this.password=password;
	}
	
	public boolean equals(Object obj){//��дequals����
		User user= (User)obj;
		return this.id==user.id;
	}
	
	public String toString(){//��дtoString����
		return"{�ʺ�:"+this.id+"����"+this.password+"}";
	}
}
public class Demo1 {
	static Scanner scanner= new Scanner(System.in);
	static Collection users= new ArrayList();//ʹ�øü��ϱ������е��û���Ϣ
	public static void main(String[] args){
		while(true){
			System.out.println("��ѡ���� A(ע��)B(��½)");
			String option = scanner.next();
			if("a".equalsIgnoreCase(option)){//�ж�ע�ỹ�ǵ�¼,���Դ�Сд
				//ע�Ṧ��
				reg();
				}else if("b".equalsIgnoreCase(option)){
					//��¼����
					login();
				}else{
					System.out.println("���ѡ������,����������");
				}
			
			}
		}
	public static void login() {
		System.out.println("�������ʺ�");
		int id= scanner.nextInt();
		System.out.println("����������");
		String password= scanner.next();
		//�жϼ������Ƿ���ڸ��û�
		//�������ϵ�Ԫ��,�鿴�Ƿ���ڸ��û���Ϣ
		boolean isLogin= false;//���������¼���ڼ�¼�Ƿ��¼�ɹ�,Ĭ��û��½�ɹ�
		Iterator it= users.iterator();// ������
		while(it.hasNext()){
			User user= (User)it.next();
			if(user.id==id&&user.password.equals(password)){
				isLogin=true;
			}
		}
		if(isLogin==true){
			System.out.println("��½�ɹ�");
		}else{
			System.out.println("�û������������,��½ʧ��");
		}
	}
	public static void reg() {
		User user=null;
		while(true){
			System.out.println("�������ʺ�");
			int id=scanner.nextInt();
			user= new User(id,null);
			if(users.contains(user)){//contains�ײ�������equals����
				System.out.println("���ʺ��Ѿ� ����,�����������ʺ�");
			}else{
				break;
			}
		}
		System.out.println("����������");
		String password= scanner.next();
		user.setPassword(password);
		//��user���󱣴��ڼ�����
		users.add(user);
		System.out.println("ע��ɹ�");
		System.out.println("��ǰע�����Ա"+users);
	}
}
