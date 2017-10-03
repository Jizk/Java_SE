package pm.junit;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
BeanUtils: 把对象的属性数据封装到对象中

*/
public class Demo2 {
	
	public static void main(String[] args) throws Exception{
		//从文件中读取到的数据都是字符串数据,
		String id = "110";
		String name = "哈哈";
		String salary = "1000";
		Emp e  = new Emp();
		BeanUtils.setProperty(e, "id", id);
		BeanUtils.setProperty(e, "name", name);
		BeanUtils.setProperty(e, "salary", salary);
		
		System.out.println(e);
	}
}
