package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
	
	public void test1() {
		
		// List Stream
		List<String> li = new ArrayList<>();
		String[] arr = {"강아지","고양이","고슴도치","말","소"};
		li.addAll(Arrays.asList(arr));
		Stream<String> st = li.stream();
		st.forEach(x -> System.out.println(x));
		
		// List는 Stream을 만들지 않아도 forEach 사용 가능하다
		System.out.println("-".repeat(25));
		li.forEach(x -> System.out.println(x));
		
		// Array Stream
		System.out.println("-".repeat(25));
		String[] arr2 = {"사과","배","포도","딸기","바나나"};
		Stream<String> st2 = Arrays.stream(arr2);
		st2.forEach(x -> System.out.println(x));
		
		// Map<K,V>
		Map<String, String> hs = new HashMap<>();
		hs.put("aaa", "kim");
		hs.put("bbb", "lee");
		hs.put("ccc", "park");
		hs.forEach((key, value) -> {
			System.out.printf("%s : %s\n", key, value);
		});
		
	}
	
	public void test2() {
		
		// map() : 매핑하거나 변경할 때 사용
		List<String> li = Arrays.asList("abc","Abc","aBC","abC");
		Stream<String> st = li.stream().map(x -> x.toUpperCase());
		st.forEach(x -> System.out.println(x + " "));
		
		// distinct() : 중복 값 제거
		List<Integer> li2 = Arrays.asList(1,2,3,4,3,4,5,6);
		Stream<Integer> st2 = li2.stream();
		st2.distinct().forEach(x -> System.out.println(x));
		
		// filter() : 조건에 맞는 데이터만 골라낸다. boolean값을 반환하는 람다식이 필요하다
		List<Integer> li3 = Arrays.asList(1,2,3,4,3,4,5,6);
		Stream<Integer> st3 = li3.stream().filter(x -> x>4);
		st3.forEach(x -> System.out.println(x + " "));
		
		// sorted() : 정렬
		System.out.println("-".repeat(25));
		List<Integer> li4 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		Stream<Integer> st4 = li4.stream().sorted();
		st4.forEach(x -> System.out.println(x + " "));
		
		/*
		 *  match()
		 *  allMatch() : 모든 조건이 만족하면 true
		 *  anyMatch() : 조건 하나만 만족해도 true
		 *  noneMatch() : 모든 조건이 만족하지 않으면 true
		 */
		List<Integer> li5 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		boolean b1 = li5.stream().allMatch(x -> x%2==0);
		System.out.println("모두 짝수 인가? " + b1);
		
		Stream st5 = li5.stream();
		boolean b2 = li5.stream().allMatch(x -> x<10);
		System.out.println("모두 10 보다 작은가? " + b2);
		
		// sum(), count(), average(), max(), min() : 기본 집계
		int[] su1 = {1,2,3,4,5};
		long hap = Arrays.stream(su1).sum();
		System.out.println("hap : " + hap);
		hap = Arrays.stream(su1).filter(x -> x<4).sum();
		System.out.println("hap2 : " + hap);
		
		int[] su2 = {1,2,3,4,5};
		long cnt = Arrays.stream(su2).count();
		System.out.println("cnt : " + cnt);
		cnt = Arrays.stream(su2).filter(x -> x<4).count();
		System.out.println("cnt2 : " + cnt);
		
		int[] su3 = {1,2,3,4,5};
		OptionalDouble avg = Arrays.stream(su3).average();
		System.out.println("avg : " + avg);
		
		int[] su4 = {1,2,3,4,5};
		OptionalInt max = Arrays.stream(su4).max();
		System.out.println("max : " + max);
		
		int[] su5 = {1,2,3,4,5};
		OptionalInt min = Arrays.stream(su5).min();
		System.out.println("min : " + min);
		
		// reduce() : stream 내부의 값을 변경하지 않고 다양한 형태로 집계
		System.out.println("-".repeat(25));
		Stream<Integer> st7 = Stream.of(1,2,3,4,5);
		Optional<Integer> opt = st7.reduce((x, y) -> x+y);
		opt.ifPresent(s -> System.out.println(s));
		
		// collect() : 콜렉션이 저장된 데이터를 특정 기준으로 분류해서 새로운 콜렉션 반환
		Integer[] su8 = {1,2,3,4,5,6,7,8,9};
		List<Integer> li8 = Arrays.stream(su8).filter(x -> x>5)
											  .collect(Collectors.toList());
		li8.stream().forEach(x -> System.out.println(x));
	}

	public static void main(String[] args) {
		new StreamEx().test2();
	}

}