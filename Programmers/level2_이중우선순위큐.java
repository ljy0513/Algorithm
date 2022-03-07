package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class level2_이중우선순위큐 {

	public static void main(String[] args) {
		
		String[] operations = {"I 16", "I 5","D 1","I 32","I 8"};
			//{"I 7","I 5","I -5","D -1"};
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < operations.length; i++) {	
			// 삽입
			if(operations[i].charAt(0) == 'I') {
				int num = Integer.parseInt(operations[i].substring(2,operations[i].length()));
				arr.add(num);
			}else {
				//비어있다면 연산 무시
				if(arr.size() == 0) continue;
				
				Collections.sort(arr);
				
				if(operations[i].charAt(2) == '1') arr.remove(arr.size()-1);
				else arr.remove(0);
			}
		}
		
		Collections.sort(arr);
		
		int[] answer;
		if(arr.size() == 0) {
			answer = new int[] {0,0};
		}else {
			answer = new int[] {arr.get(arr.size()-1),arr.get(0)};
		}

		System.out.println(Arrays.toString(answer));
		
	}

}
