package pm.junit;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/*
BeanUtils: �Ѷ�����������ݷ�װ��������

*/
public class Demo2 {
	
	public static void main(String[] args) throws Exception{
		//���ļ��ж�ȡ�������ݶ����ַ�������,
		String id = "110";
		String name = "����";
		String salary = "1000";
		Emp e  = new Emp();
		BeanUtils.setProperty(e, "id", id);
		BeanUtils.setProperty(e, "name", name);
		BeanUtils.setProperty(e, "salary", salary);
		
		System.out.println(e);
	}
}
