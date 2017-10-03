/*迭代器
 用于抓取集合中的元素
*/
package pm.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo1 {
	public static void main(String[] args) {
		Collection c= new ArrayList();
		c.add("元素1");
		c.add("元素2");
		c.add("元素3");
		c.add("元素4");
		//要求使用iterator迭代其遍历,
		Iterator it=c.iterator(); //返回一个迭代器
		/*System.out.println("有元素可以遍历嘛"+it.hasNext());// 判断是否有元素可以遍历
		System.out.println("获取元素"+it.next());//获取元素
		System.out.println("获取元素"+it.next());
		System.out.println("获取元素"+it.next());
		System.out.println("获取元素"+it.next());*/
		while(it.hasNext()){
			System.out.println("获取"+it.next());
		}
		while(it.hasNext()){   //清空元素 
			it.next();
			it.remove();
		}
	}
}
