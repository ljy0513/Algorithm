package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class level2_위장_시간초과 {
	static int answer;
	static String[] selected;
	static Map<String , ArrayList<String>> map;
	
	public static void main(String[] args) {
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
			//{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};;
		
		map = new HashMap<>();
		answer = 0;
		ArrayList<String> cate = new ArrayList<>();
		
		//종류에 맞게 리스트를 만들어서 저장
		for (int i = 0; i < clothes.length; i++) {
			ArrayList<String> list = new ArrayList<>();
			
			if(map.containsKey(clothes[i][1])) {
				list = map.get(clothes[i][1]); //원래 저장되어있던 리스트를 가져옴
				list.add(clothes[i][0]);
			}else {
				cate.add(clothes[i][1]);
				list.add(clothes[i][0]);
			}
			map.put(clothes[i][1], list); //새로 만들어진 리스트를 같은 종류로 저장
		}
		
//		for(String str : map.keySet()) {
//			ArrayList<String> list = map.get(str);
//			System.out.print(str + " : ");
//			for(String s : list) {
//				System.out.print(s + ", ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i <= clothes.length; i++) {
			selected = new String[i];
			comb(0,0,i,cate);
		}
		
		System.out.println(answer);
	}
	
	static void comb (int start, int cnt, int n, ArrayList<String> cate) {
		if(cnt == n) {
			int tmp = 1;
			for (int i = 0; i < selected.length; i++) {
				ArrayList<String> list = map.get(selected[i]);
				tmp *= list.size();
			}
			answer += tmp;
			return;
		}
		for(int i = start; i<cate.size(); i++) {
			selected[cnt] = cate.get(i);
			comb(i+1, cnt+1, n, cate);
		}
	}

}
