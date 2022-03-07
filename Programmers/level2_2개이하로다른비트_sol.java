package Solution;

import java.util.Arrays;

public class level2_2개이하로다른비트_sol {

	public static void main(String[] args) {
		long[] numbers = { 1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100 };
		long[] answer = new long[numbers.length];
		
		
		for (int i = 0; i < numbers.length; i++) {
			//짝수일 때
			if(numbers[i] % 2 == 0) {
				answer[i] = numbers[i]+1;
			}
			//홀수일 때
			else {
				long num = numbers[i] & 7l;
				
				if(num == 1) {
					answer[i] = numbers[i]+1;
				}else if(num == 3) {
					answer[i] = numbers[i]+2;
				}else if(num == 5) {
					answer[i] = numbers[i]+1;
				}else {
					answer[i] = numbers[i]+4;
				}														
			}			
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
