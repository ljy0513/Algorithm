package Solution;

import java.util.Arrays;

public class level2_구명보트 {
	
	public static void main(String[] args) {
		int[] people = {40,50,90,100,110,120,130};
		int limit = 160;
		int answer = 0;
		int cnt=0;
		
		Arrays.sort(people);
		int start = 0;
		
		for(int i=people.length-1; i >= 0; i--) {
			if(cnt < people.length) answer++;		
			if(i==start) break;
			
			if(people[start] + people[i] <= limit) {
				start++;
				cnt += 2;
			}else {
				cnt++;
			}
		}
		
		System.out.println(answer);
	}		
}
