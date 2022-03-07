package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int tmp;
		int cnt = 0;

		for (int i = 0; i <= N/5; i++) {
			tmp = N % 5 + i * 5;

			if (tmp % 3 == 0) {
				cnt += (tmp / 3) + ((N - tmp) / 5);
				break;
			}
		}
		
		if(cnt == 0) System.out.println(-1);
		else System.out.println(cnt);

	}

}
