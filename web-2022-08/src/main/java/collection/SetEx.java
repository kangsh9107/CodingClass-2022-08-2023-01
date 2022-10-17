package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetEx {
	
	// Set CRUD
	public void test1() {
		Set<String> hs = new HashSet<>();
		
		// C : 추가
		hs.add("kim");
		hs.add("hong");
		hs.add("park");
		hs.add("nam");
		System.out.println(hs);
		
		// U : 수정. remove -> add
		hs.remove("park");
		hs.add("kang");
		System.out.println(hs); // Set 구조는 입력순서와 출력순서가 상관없다
		
		// R : 조회. 순차접근을 하려면 iterator를 사용해서 hasNext, next 메서드를 사용해야 한다
		System.out.println("-".repeat(25));
		Iterator<String> iter = hs.iterator(); // iterator를 만드는 게 핵심이다
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println(hs.contains("kim"));
		
		// D : 삭제
		hs.remove("nam");
		System.out.println(hs);
	}
	
	// 중복값 제거 후 출력
	public void test2() {
		Integer[] a = {1,23,12,43,352,25,52,624,62,6};
		Integer[] b = {1,352,52,6,14,325,235,26,26};
		
		List<Integer> aa = new ArrayList<>(Arrays.asList(a));
		List<Integer> bb = new ArrayList<>();
		bb.addAll(Arrays.asList(b)); // Arrays.asList : 배열을 ArrayList로 변경
		
		// 1) 합집합
		System.out.println(aa);
		System.out.println(bb);
		aa.addAll(bb);
		System.out.println(aa);
		
		// 2) 중복제거. Set에 존재하지 않는 값은 저장되며 true 반환. 존재하는 값은 저장되지 않으며 false 반환.
		//            쉽게 말하면 중복된 값은 저장되지 않는다
		System.out.println("-".repeat(25));
		Set<Integer> set = new HashSet<>();
		set.addAll(aa);
		System.out.println(set);
	}
	
	// List에 포함된 요소의 개수 구하기. Collections.frequency(List명, i); i는 기대하는 객체
	// 자바스크립트에서는 array_reduce.html에서 실습했던 내용
	public void test3() {
		Integer[] su = {1,1,1,2,3,4,5,6,7,8,3,7,357,5,457};
		List<Integer> li = new ArrayList<>();
		li.addAll(Arrays.asList(su));
		
		Set<Integer> set = new HashSet<>(li);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(li, i);
			System.out.printf("%4d : %d\n", i, cnt);
		}
	}
	
	/*
	 * 응용
	 * score의 값을 사용하여 각 학점대의 명수를 출력
	 * ex. 90~ : 1명
	 *     80~ : 1명
	 */
	public void test4() {
		Integer[] score = {90,90,70,70,50,50,80,40,30};
		List<Integer> li = new ArrayList<>(Arrays.asList(score));
		
		Set<Integer> set = new HashSet<>(li);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(li, i);
			System.out.printf("%d~ : %d명\n", i, cnt);
		}
		
		// 강사님 코드
		Integer[] score2 = {91,99,70,70,50,50,80,40,30};
		List<Integer> list = new ArrayList<>();
		// 90~99는 모두 90으로 나오게 각각 점수대를 for문과 floorDiv로 가공한다
		for(Integer i : score) {
			list.add(Math.floorDiv(i, 10)); // i/10을 하고 소수점을 절삭. ex) 99 -> 9.9 -> 9
		}
		
		System.out.println("-".repeat(25));
		Set<Integer> set2 = new HashSet<>(list);
		Iterator<Integer> iter2 = set2.iterator();
		while(iter2.hasNext()) {
			Integer i = iter2.next();
			int cnt = Collections.frequency(list, i);
			System.out.printf("%d~ : %d명\n", (i*10), cnt);
		}
	}

	public static void main(String[] args) {
		new SetEx().test4();
	}
	
}









