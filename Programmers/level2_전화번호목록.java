package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class level2_전화번호목록 {

	public static void main(String[] args) {
		//String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"123","12"};
		boolean answer = true;
		
		int idx = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for(String numbers : phone_book) {
			map.put(numbers, idx++);
		}
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
				if(map.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
				}
			}
		}
		
		
		/*
		List<String> list = new ArrayList<>();
		list = Arrays.asList(phone_book);
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
				if(list.contains(phone_book[i].substring(0, j))) {
					answer = false;
				}
			}
		}
		*/
		
			
		System.out.println(answer);
	}

}
/**
 * 5000000개의 인스턴스 생성 시간 0.548829807초
HashMap Test
	입력 소요 시간  2.415268645초
	탐색 소요 시간 0.002399381초
	삭제 소요 시간 0.002615092초

ArrayList
	입력 소요 시간  0.381054002초
	탐색 소요 시간 1.99475E-4초
	삭제 소요 시간 137.231368119초

LinkedList
	입력 소요 시간  1.503839756초
	탐색 소요 시간 52.905209243초
	삭제 소요 시간 52.587791295초
 */
