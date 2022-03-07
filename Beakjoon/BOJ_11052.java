package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	static int N,max;
	static int[] price;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		price = new int[N + 1];
		max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N + 1; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		Comb(0,0);
		System.out.println(max);
	}
	
	static void Comb (int cnt, int sum) {
		if(cnt > N) return;
		
		if(cnt == N) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			if(cnt > N) break;
			Comb(cnt+i, sum+price[i]);
		}
	}

}
