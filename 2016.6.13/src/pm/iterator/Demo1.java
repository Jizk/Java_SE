/*������
 ����ץȡ�����е�Ԫ��
*/
package pm.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo1 {
	public static void main(String[] args) {
		Collection c= new ArrayList();
		c.add("Ԫ��1");
		c.add("Ԫ��2");
		c.add("Ԫ��3");
		c.add("Ԫ��4");
		//Ҫ��ʹ��iterator���������,
		Iterator it=c.iterator(); //����һ��������
		/*System.out.println("��Ԫ�ؿ��Ա�����"+it.hasNext());// �ж��Ƿ���Ԫ�ؿ��Ա���
		System.out.println("��ȡԪ��"+it.next());//��ȡԪ��
		System.out.println("��ȡԪ��"+it.next());
		System.out.println("��ȡԪ��"+it.next());
		System.out.println("��ȡԪ��"+it.next());*/
		while(it.hasNext()){
			System.out.println("��ȡ"+it.next());
		}
		while(it.hasNext()){   //���Ԫ�� 
			it.next();
			it.remove();
		}
	}
}
