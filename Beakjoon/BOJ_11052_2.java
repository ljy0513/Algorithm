package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11052_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int dp[] = new int[N + 1];
		int p[] = new int[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N + 1; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], p[j] + dp[i - j]);
				System.out.println(dp[i]);
			}
		}
		
		System.out.println(Arrays.toString(dp));
		//System.out.println(dp[N]);
	}

}
