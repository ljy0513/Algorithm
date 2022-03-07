package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401 {
	static int M = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		

	}
	
	static long fac(int n) {
		long result = 1;
		for(int i = 1;i <= n;i++) {
			result *= i;
			result %= M;
		}
		return result;
	}
}
