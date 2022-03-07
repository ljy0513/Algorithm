package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(in.readLine());
		
		int tmp;		
		for(int i =0; i<N; i++) {
			for (int j = 0; j < N-1; j++) {
				if(num[j] > num[j+1]) {
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
			}
		}
		
		for(int n : num) System.out.println(n);

	}
}
