package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	static int arr [][];
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(R-- > 0) leftRotate(0,N-1,0,M-1);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void leftRotate (int rs, int re, int cs, int ce) {
		if(rs >= re || cs >= ce) return;
		
		int tmp = arr[rs][cs];
		for(int i=cs; i<ce; i++) arr[rs][i] = arr[rs][i+1];
		for(int i=rs; i<re; i++) arr[i][ce] = arr[i+1][ce];
		for(int i=ce; i>cs; i--) arr[re][i] = arr[re][i-1];
		for(int i=re; i>rs; i--) arr[i][cs] = arr[i-1][cs];		
		arr[rs+1][cs] = tmp;
	
		leftRotate(rs+1,re-1,cs+1,ce-1);
	}
}

















