package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());		
		int[] arrN = new int[N];
		int idx =0;
		while(st.hasMoreTokens()) {
			arrN[idx++] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int[] arrM = new int[M];
		idx = 0;
		while(st.hasMoreTokens()) {
			arrM[idx++] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);

		for(int i=0; i<M; i++) {
			int s=0, e=N-1;
			
			while(s != e){
				int tmp = (s + e) /2;
				if(arrN[tmp] < arrM[i]) {
					s = tmp+1;
				}else { //arrN[tmp] >= M
					e = tmp;
				}
			}
			
			if(s == e) {
				if(arrN[s] == arrM[i]) System.out.println(1);
				else System.out.println(0);
			}
		}				
	}//main
}

//왜 전 시간이 길까요...?
//55120	1536