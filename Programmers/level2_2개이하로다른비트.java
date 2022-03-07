package Solution;

import java.util.Arrays;

public class level2_2개이하로다른비트 {

	public static void main(String[] args) {
		long[] numbers = { 2, 7 };
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			long number = numbers[i]+1;
			
			while(true) {
				long res = numbers[i]^number; //같은 자리의 비트가 다를 때 체크
				if(counting(res) <= 2) {
					answer[i] = number;
					break;
				}
				number++;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
	
	//비트를 오른쪽으로 밀면서 1 카운팅
	static int counting(long n) {
	    int count = 0;
	    while (n > 0) {
	        count += n & 1;
	        n >>= 1;
	    }
	    return count;
	}

}
