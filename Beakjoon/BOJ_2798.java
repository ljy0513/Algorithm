package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
	static int N,M,res;
	static int[] cards,input;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		
		cards = new int[N];
		input = new int[3];
		res = 0;
		
		st = new StringTokenizer(in.readLine());
		int idx =0;
		while(st.hasMoreTokens()) {
			cards[idx++] = Integer.parseInt(st.nextToken());
		}
		
		Comb(0,0,0);
		System.out.println(res);
	}
	
	static void Comb(int cnt,int start,int sum) {
		if(sum > M) return;
		
		if(cnt == 3) {
			int tmp=0;
			for(int i=0; i<3; i++) {
				tmp += input[i];
			}
			if(min > Math.abs(M-tmp)) {
				min = Math.abs(M-tmp);
				res = tmp;				
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			input[cnt] = cards[i];
			Comb(cnt + 1, i+1 , sum + cards[i]);
		}
	}

}
