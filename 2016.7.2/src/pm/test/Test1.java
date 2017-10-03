package pm.test;

import java.util.*;

public class Test1{
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1,"tom");
		map.put(2,"lu");
		map.put(3,"an");
		Set keySet = map.keySet();
		Iterator it = keySet.iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(key);
			map.remove(key);
		}
	}
	
}
