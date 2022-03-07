package Solution;

import java.util.Arrays;

public class level2_삼각달팽이 {

	public static void main(String[] args) {
		int n = 5;
		int size = 0;
		
		for(int i=1; i<=n; i++) size += i;
				
		int[] answer = new int[size];
		int index = 0;
		int dir = 0;
		int num = 1;
		int cnt = 0;
		int step = n;
		
		while(n > 0) {		
			if(dir == 0) {
				index += cnt;
				answer[index] = num++;
				cnt++;
				step--;
				if(step == 0) {
					dir = 1;
					step = --n;
				}
			}else if(dir == 1) {
				index++;
				answer[index] = num++;
				step--;
				if(step == 0) {
					dir = 2;
					step = --n;
				}
			}else {
				index -= cnt;
				answer[index] = num++;
				cnt--;
				step--;
				if(step == 0) {
					dir = 0;
					step = --n;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));

	}

}
