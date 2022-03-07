package Solution;

import java.util.Arrays;
import java.util.Comparator;

public class level2_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		String answer = "";
		
		String[] strNumbers = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strNumbers[i] = Integer.toString(numbers[i]);
		}
		
		//두 개씩 짝지어서 비교했을때 더 큰 순으로 정렬
		Arrays.sort(strNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//return (o2+o1).compareTo(o1+o2);
				Integer n1 = Integer.parseInt(o1+o2);
				Integer n2 = Integer.parseInt(o2+o1);
				return n2.compareTo(n1);
			}
		});
		
		for(String number : strNumbers) {
			answer += number;
		}
		
		if(answer.charAt(0) == '0') answer = "0";
		
		System.out.println(answer);

	}

}
