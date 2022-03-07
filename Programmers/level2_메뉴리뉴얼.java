package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class level2_메뉴리뉴얼 {
	static char[] ch;
	static Map<String, Integer> map;
	
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		List<String> answerList = new ArrayList<>();
		
		for(int i=0; i<course.length; i++) {
			//주문별로 course개수 만큼 조합
			map = new HashMap<>();
			for(int j=0; j<orders.length; j++) {
				ch = new char[course[i]];
				char[] food = orders[j].toCharArray();
				Arrays.sort(food);
				Comb(0,0,course[i],food);
			}
			
			//가장 많이 나온 코스 List에 저장
			boolean flag = false;
			for(int j=orders.length; j>0; j--) {
				if(flag) break;
				for(String key : map.keySet()) {
					if(map.get(key) == j && map.get(key) > 1) {
						flag = true;
						answerList.add(key);
					}
				}
			}
		}
		
		Collections.sort(answerList);
		
		int size = 0;
		String[] answer = new String[answerList.size()];
		for(String str : answerList) {
			answer[size++] = str;
		}
		System.out.println(Arrays.toString(answer));
	}

	public static void Comb(int cnt, int start, int course, char[] food) {
		if(cnt == course) {
			String comb = String.valueOf(ch);
			if(map.containsKey(comb)) {
				map.put(comb, map.get(comb)+1);
			}else {
				map.put(comb, 1);
			}
			return;
		}
		
		for(int i=start; i<food.length; i++) {
			ch[cnt] = food[i];
			Comb(cnt+1, i+1, course, food);
		}
	}
}
