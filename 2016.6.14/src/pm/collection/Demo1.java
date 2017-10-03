/*登录注册功能*/
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
	
	public boolean equals(Object obj){//重写equals方法
		User user= (User)obj;
		return this.id==user.id;
	}
	
	public String toString(){//重写toString方法
		return"{帐号:"+this.id+"密码"+this.password+"}";
	}
}
public class Demo1 {
	static Scanner scanner= new Scanner(System.in);
	static Collection users= new ArrayList();//使用该集合保存所有的用户信息
	public static void main(String[] args){
		while(true){
			System.out.println("请选择功能 A(注册)B(登陆)");
			String option = scanner.next();
			if("a".equalsIgnoreCase(option)){//判断注册还是登录,忽略大小写
				//注册功能
				reg();
				}else if("b".equalsIgnoreCase(option)){
					//登录功能
					login();
				}else{
					System.out.println("你的选择有误,请重新输入");
				}
			
			}
		}
	public static void login() {
		System.out.println("请输入帐号");
		int id= scanner.nextInt();
		System.out.println("请输入密码");
		String password= scanner.next();
		//判断集合中是否存在该用户
		//遍历集合的元素,查看是否存在该用户信息
		boolean isLogin= false;//定义变量记录用于记录是否登录成功,默认没登陆成功
		Iterator it= users.iterator();// 迭代器
		while(it.hasNext()){
			User user= (User)it.next();
			if(user.id==id&&user.password.equals(password)){
				isLogin=true;
			}
		}
		if(isLogin==true){
			System.out.println("登陆成功");
		}else{
			System.out.println("用户名或密码错误,登陆失败");
		}
	}
	public static void reg() {
		User user=null;
		while(true){
			System.out.println("请输入帐号");
			int id=scanner.nextInt();
			user= new User(id,null);
			if(users.contains(user)){//contains底层依赖了equals方法
				System.out.println("该帐号已经 存在,请重新输入帐号");
			}else{
				break;
			}
		}
		System.out.println("请输入密码");
		String password= scanner.next();
		user.setPassword(password);
		//把user对象保存在集合中
		users.add(user);
		System.out.println("注册成功");
		System.out.println("当前注册的人员"+users);
	}
}
