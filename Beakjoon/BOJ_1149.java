package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());

		int[][] price = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][n];

		dp[0][0] = price[0][0];
		dp[0][1] = price[0][1];
		dp[0][2] = price[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = 	price[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
				} else if (j == 1) {
					dp[i][j] = 	price[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
				} else { //j == 2
					dp[i][j] = 	price[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
				}
			}
		}
		
		int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(min);

	}

}
