package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		boolean[] checked1 = new boolean[1000001];//음수 배열
		boolean[] checked2 = new boolean[1000001];//양수 배열
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(in.readLine());
			if(num[i] >= 0) {
				checked1[num[i]] = true;
			}else {
				checked2[-(num[i])] = true;
			}
		}
		
		for(int i=checked2.length-1; i>0; i--) {
			if(checked2[i]) {
				sb.append(-i).append('\n');
			}
		}
		for(int i=0; i<checked1.length; i++) {
			if(checked1[i]) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

}
