package Solution;

import java.util.HashMap;
import java.util.Map;

public class level2_위장 {
	public static void main(String[] args) {
		String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
			//{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};;
		
		Map<String , Integer> map = new HashMap<>();
				
		//종류에 맞게 리스트를 만들어서 저장
		for (int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
			    map.put(clothes[i][1],map.get(clothes[i][1])+1);
			}else {
                map.put(clothes[i][1],1);
			}
		}
        
        int answer = 1;
        for(String cate : map.keySet()){
            answer *= (map.get(cate) + 1); //+1은 착용하지 않은 경우 추가
        }   	
		
		System.out.println(answer-1);
	}

}
