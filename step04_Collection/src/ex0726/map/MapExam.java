package ex0726.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam extends HashMap<Integer, String>{
	public MapExam() {
		super.put(10, "웅기");
		super.put(50, "나영");
		super.put(30, "효리");
		super.put(20, "미나");
		super.put(10, "수영");
		super.put(40, "미선");
		super.put(30, "미미");
		
		// 출력
		System.out.println(this.size());
		System.out.println(this);
		
		System.out.println("---------요소 하나씩 꺼내기---------");
		Set<Integer> set = super.keySet(); // map의 모든 key 정보를 set으로 만들어 전달
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int key = it.next(); // 모든 요소 꺼낸다
			String value = super.get(key);
			System.out.println(key + " | " + value);
		}
		
		System.out.println("개선된 for 문");
		for (Integer key : super.keySet()) {
			String value = super.get(key);
			System.out.println(key + " | " + value);
		}
		
		System.out.println("-----Map.Entry<K, V> 사용하기----");
		Set<Map.Entry<Integer, String>> s = super.entrySet();
		Iterator<Map.Entry<Integer, String>> itm = s.iterator();
		while (itm.hasNext()) {
			Map.Entry<Integer, String> entry = itm.next(); 
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " | " + value);
		}
		for (Map.Entry<Integer, String> e : s) {
			int key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " | " + value);
		}
	}
	
	
	
	public static void main(String[] args) {
		new MapExam();
	}
}
