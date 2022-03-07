package Solution;

import java.util.Arrays;
import java.util.Collections;

public class level2_N개의최소공배수 {

	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		Integer[] arr2 = new Integer[arr.length];
		
		for (int i = 0; i < arr.length; i++) arr2[i] = arr[i];
		Arrays.sort(arr2,Collections.reverseOrder());
		
		int max_num = arr2[0];
		int cnt = 0;
		
		while(true) {	
			for (int i = 1; i < arr2.length; i++) {
				if(max_num % arr2[i] != 0) {
					break;
				}
				cnt++;
			}
			if(cnt == arr2.length-1) break;
			max_num += arr2[0];
			cnt = 0;
		}
		
		System.out.println(max_num);

	}

}
