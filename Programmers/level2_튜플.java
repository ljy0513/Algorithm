package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class level2_튜플 {

	//원소의 개수가 1개인 집합 부터 시작
	//숫자의 개수가 많은 순서대로 원소가 시작
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		
		//1. {,} 괄호 제거
		s = s.replace("{", "");
		s = s.replace("}", "");		
		//System.out.println(s);
		
		//2. 숫자만 잘라서 배열에 넣기
		String[] number = s.split(",");	
		//System.out.println(Arrays.toString(number));
		
		//3. map을 이용해서 숫자의 해당 숫자의 개수만큼 카운트 
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0; i<number.length; i++) {
			//만약 이미 숫자가 있다면 해당 숫자의 value값 증가
			if(map.containsKey(number[i])) {
				map.replace(number[i], map.get(number[i])+1);
			}
			//숫자가 없다면 key:value 생성
			else {
				map.put(number[i], 1);
			}
		}
		
		//4. map은 정렬이 불가능 하니 entry 사용해서 List에 옮겨준 후 정렬하기
		List<Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());
		
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue()); //value 기준 내림차순 정렬
			}
		});
		
		//5. map iterator 사용하면서 정렬된 순서대로 answer 배열에 삽입
		int[] answer = new int[map.size()];
		int idx = 0;
		for(Entry<String, Integer> entry : entries) {
			//System.out.println(entry.getKey() + " : " + entry.getValue());
			answer[idx++] = Integer.parseInt(entry.getKey());
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
