package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paper[][] = new int[100][100];
		int sum = 0;
		int N = Integer.parseInt(in.readLine()); // 색종이 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = 90-y; j < 100-y; j++) {
				for (int k = x; k < x+10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				sum += paper[i][j];
			}
		}

		System.out.print(sum);
	}

}
