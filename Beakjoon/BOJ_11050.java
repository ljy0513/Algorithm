package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int res = fac(N) / (fac(K) * fac(N-K));
		System.out.println(res);
		
	}
		
	static int fac(int n) {
		if(n == 1) return 1;
		else if(n == 0) return 1; //N == K가 같을 때
		return n * fac(n - 1);
	}
	
}
