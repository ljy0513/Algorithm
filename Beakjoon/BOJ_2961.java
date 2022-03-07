package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	
	static int N;
	static int[][] flavor;
	static boolean[] isSelected;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		flavor = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		Subset(0);
		System.out.println(MIN);
		
	}//main
	
	//S: 신맛 곱하기, B: 쓴맛 더하기
	private static void Subset(int cnt) {
		int S=1;
		int B=0;
		int tmp;
		
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					S *= flavor[i][0];
					B += flavor[i][1];
					tmp = S-B > 0? S-B : B-S;
					if(MIN > tmp) MIN = tmp;
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		Subset(cnt+1);
		
		isSelected[cnt] = false;
		Subset(cnt+1);
	}
}

