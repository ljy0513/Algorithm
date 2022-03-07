package Solution;

import java.util.ArrayList;
import java.util.List;

public class level2_소수찾기 {
	static boolean[] isSelected, p_isSelected;
	static int[] arr;
	static List<Integer> selected;
	static int answer;
	static boolean[] used;
	
	public static void main(String[] args) {
		answer = 0;

		String numbers = "17";
		char[] ch = numbers.toCharArray();

		arr = new int[ch.length];
		isSelected = new boolean[ch.length];
		used = new boolean[10000000];
		for (int i = 0; i < ch.length; i++) {
			arr[i] = ch[i] - '0';
		}
		
		Subset(0);
		System.out.println(answer);
	}
	
	//숫자들의 부분집합 만들기
	static void Subset(int cnt) {
		if (cnt == arr.length) {
			selected = new ArrayList<>();

			// 뽑은 숫자 ArrayList에 넣기
			for (int i = 0; i < isSelected.length; i++) {
				if (isSelected[i])
					selected.add(arr[i]);
			}
			
			if(selected.size() > 0) {
				p_isSelected = new boolean[selected.size()];
				perm(0,selected,0);
			}
			
			return;
		}

		isSelected[cnt] = true;
		Subset(cnt + 1);

		isSelected[cnt] = false;
		Subset(cnt + 1);
	}
	
	//뽑은 숫자를 순열로 숫자 만들기
	static void perm(int cnt,List<Integer> selected, int num) {
		if (cnt == selected.size()) {
			if(num != 0 && prime(num)) {
				if(!used[num]) answer++;
				used[num] = true;
				//System.out.println(num);
			}
		}

		for (int i = 0; i < selected.size(); i++) {
			if (p_isSelected[i])
				continue;

			p_isSelected[i] = true;
			perm(cnt + 1, selected, num * 10 + selected.get(i));
			p_isSelected[i] = false;
		}

	}
	
	//소수인지 아닌지 판별
	static boolean prime(int n) {
		//System.out.println("num : "+n);
		if(n == 1) return false;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) return false;	
		}
		
		return true;
	}

}
