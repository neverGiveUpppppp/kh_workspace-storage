package MVC.controller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import MVC.model.vo.pModelVo03;

public class pController03 {
	
	// Map
	// {key=value} 형식으로 출력됨 // map도 중괄호{} 찍혀서 나온다
	public void pMap() {
		
		// 1.HashMap
		// 2.TreeMap
		
		// 1.HashMap
		// put(K key, V value):V
		// 반환타입 : value
		HashMap<String,pModelVo03> hm = new HashMap<>();
		hm.put("힘", new pModelVo03("아자아자",1));			
		hm.put("내", new pModelVo03("으샤으샤",2)); 
		hm.put("라", new pModelVo03("으랴차차",3));
		System.out.println(hm.put("힘", new pModelVo03("아자아자",1))); // 아자아자[1원]
		System.out.println(hm); // 순서x
		System.out.println(hm); // {내=으샤으샤[2원], 힘=아자아자[1원], 라=으랴차차[3원]}
		
		
		// 2.containsKey(Object key)
		// 키나 값이 들어가 있는지를 확인하는 메소드
		// containsKey(Object key):boolean	
		// containsValue(Object value):boolean	
		
		boolean a = hm.containsKey("힘"); // 키값 확인
		System.out.println(a);
		System.out.println(hm.containsKey("내"));
		
		System.out.println(hm.containsValue(new pModelVo03("아자아자",2))); // 밸류값 확인
		System.out.println(hm.containsValue(new pModelVo03("아자아자",1))); // 새객채 주소값다름
		// 모델 클래스에서 오버라이딩 후 결과창 true
		
		// 3.get()
		// get(Object key) : v
		// key값에 맞는 'value값 반환'
		System.out.println(hm.get("힘"));
		System.out.println(hm.get("내"));
		System.out.println(hm.get("라"));
		
		
		// keySet() & entrySet()
		
		// keySet()
		// keySet():Set<K>
		// 맵에 있는 key들을 set에 담아 반환
		System.out.println(hm.keySet()); // [내, 힘, 라]
		
		
		
		// 다른방법
		Set<String> ks = hm.keySet(); // ketSet이 메소드라 제네릭 안붙임
		System.out.println(ks.iterator()); // java.util.HashMap$KeyIterator@6d06d69c
		Iterator<String> it = ks.iterator();
		System.out.println(it); // java.util.HashMap$KeyIterator@7852e922
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("keySet : "+key);
		}
		
		
		
		// entrySet()
		// entrySet():Set<Map.Entry<K,V>>
		// map에 있는 entry들을 set 담에 반환(키와 값의 쌍을 set에 담아 반환)
		// entry 의미 : 키와 값을 묶은 것(키와 값의 쌍)
		System.out.println("=====entrySet=====");
		System.out.println(hm.entrySet()); // [내=으샤으샤[2원], 힘=아자아자[1원], 라=으랴차차[3원]]
		
		// 다른방법
		Set<Entry<String,pModelVo03>> es = hm.entrySet();
		es.iterator();
		Iterator<Entry<String,pModelVo03>> it2 = es.iterator();
		while(it2.hasNext()) {
			Entry<String,pModelVo03> en = it2.next();
			System.out.print(en+" "); // 내=으샤으샤[2원] 힘=아자아자[1원] 라=으랴차차[3원] 
		}
		System.out.println();
		
		// TreeMap
		//
		
		System.out.println("=====TreeMap=====");
//		TreeMap<String,pModelVo03> tm = new TreeMap<>();
		TreeMap<String,pModelVo03> tm = new TreeMap<>(hm);
		System.out.println(tm); // {내=으샤으샤[2원], 라=으랴차차[3원], 힘=아자아자[1원]}
		
		// size():int
		System.out.println(tm.size()); // 3
		
		// remove(Object key):V
//		System.out.println(tm.remove(new TreeMap("힘"), new TreeMap("아자아자",1)));
		System.out.println(tm.remove(new String("힘"))); // value리턴 : 아자아자[1원]
		System.out.println(tm); // {내=으샤으샤[2원], 라=으랴차차[3원]}
		
		System.out.println(tm.keySet());
		Set<String> set = tm.keySet(); 
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
		System.out.println(tm.remove(new String("내")));
		System.out.println(tm); // {라=으랴차차[3원]}
		
		
		System.out.println("===replace===");
		// replace(K key, V oldValue, V newValue):boolean
		System.out.println(tm.replace(new String("라"), new pModelVo03("으랴차차",3), new pModelVo03("화이팅",4)));//true
		
		// remove(Object key, Object value):boolean
		tm.remove(new String("라"), new pModelVo03("화이팅",4));
		System.out.println(tm); // {}
		
		
		
		System.out.println("===TreeMap2===");
		TreeMap<String,pModelVo03> tm2 = new TreeMap<>();
		
		// put(K key, V value):V
		tm2.put(new String("a"), new pModelVo03("a",1));
		tm2.put(new String("b"),new pModelVo03("b",2));
		tm2.put(new String("c"),new pModelVo03("c",3));
		System.out.println(tm2); //  {a=a[1원], b=b[2원], c=c[3원]}
		
		// size():int
		System.out.println(tm2.size()); // 2
		// remove(Object key):V
		System.out.println(tm2.remove(new String("b"))); // 지운 밸류값 출력 : b[2원]
		System.out.println(tm2);						 // {a=a[1원], c=c[3원]}
		// remove(Object key, Object value):boolean
		System.out.println(tm2.remove(new String("a"),new pModelVo03("a",1)));// true
		System.out.println(tm2);						 // {c=c[3원]}
		// replace(K key, V value):default V
		System.out.println(tm2.replace(new String("c"), new pModelVo03("c",3))); // c[3원]
		System.out.println(tm2);						 // {c=c[3원]}
		// replace(K key, V oldValue, V newValue):boolean
		tm2.replace(new String("c"), new pModelVo03("c",3), new pModelVo03("d",4));
		System.out.println(tm2.replace(new String("c"), new pModelVo03("c",3), new pModelVo03("d",4)));//false
		System.out.println(tm2); // {c=d[4원]} : 키값c 밸류값d,4
		

		
	}	
		
}
