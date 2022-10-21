package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ListEx {
	
	public void test1() {
		// C : add 추가
		List<String> li = new ArrayList<>();
		li.add("가");
		li.add("나");
		li.add("나");
		li.add("다");
		for(String s : li) {
			System.out.print(s);
		}
		
		// D : remove 삭제
		System.out.println("\n-----");
		li.remove("나");
		for(String s : li) {
			System.out.print(s);
		}
		
		// R : get 조회, indexOf, contains
		System.out.println("\n-----");
		System.out.println(li.get(0));
		System.out.println(li.indexOf("가"));
		System.out.println(li.contains("가"));
		
		// U : set 수정
		System.out.println("\n-----");
		System.out.println(li.get(2));
		li.set(2, "하하");
		System.out.println(li.get(2));
	}
	
	public void test2() {
		// C : 입력
		List<Data> li = new ArrayList<>();
//		li.add("park"); // Data타입이 아니라서 에러
		Data d = new Data("a001", "kim", 18);
		li.add(d);
		li.add(new Data("b001", "hong", 20));
		li.add(new Data("c001", "park", 15));
		System.out.println(li);
		
		// U : 수정
		System.out.println("\n-----");
		System.out.println(li.indexOf("d001")); // 동등객체 비교하려면 hashCode랑 equals 오버라이드 해서 비교
		System.out.println(li.contains("b001"));
		
		int index = 0;
		for(int i=0; i<li.size(); i++) {        // indexOf 대신 for문으로 index 찾기 가능
			Data temp = li.get(i);
			if(temp.getId().equals("a001")) {
				index = i;
				System.out.println("index : "  + i);
				break;
			}
		}
		li.set(2, new Data("d001", "han", 30));
		li.set(index, new Data("e001", "go", 10000));
		System.out.println(li);
		
		// 수정2. hashCode랑 equals 오버라이드
		System.out.println("\n-----");
		System.out.println(li);
		Data temp = new Data("d001", "", 0);
		int index2 = li.indexOf(temp);
		System.out.println("new index = " + index2);
		boolean b2 = li.contains(temp);
		System.out.println(b2);
		
		// R : 삭제
		
	}
	
	public void test3() {
		List<Integer> li = new Vector<>(10,5); // 10개에서 11개가 추가되면 용량이 15개로 늘어난다. (카파시티) : 메모리를 효율적으로 사용
		
		Integer[] a = {1,2,3,4,5,6,7};
		Integer[] b = {1,5,2,56,26};
		// for문을 이용한 list 교집합 확인
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j]) {
					System.out.printf("%4d\n", a[i]);
					li.add(a[i]);
					break;
				}
			}
		}
		System.out.println(li);
		
		// retain을 이용한 list 교집합 확인
		// Integer[] a = {...};
		// Integer[] b = {...};
		// asList의 매개변수는 Object이다. 그래서 a와 b를 Integer로 선언했다
		// List<Integer> aa = new ArrayList<>(Arrays.asList(a));
		// List<Integer> bb = new ArrayList<>(Arrays.asList(b));
		// aa.retainAll(bb);
		List<Integer> aa = new ArrayList<>(Arrays.asList(a));
		List<Integer> bb = new ArrayList<>(Arrays.asList(b));
		aa.retainAll(bb);
		System.out.println(aa);
		
		// list 부분집합 확인. boolean b = listA.containsAll(listB); -> listB가 listA의 부분집합인가?
	}
	
	public static void main(String[] args) {
		new ListEx().test2();
	}

}









