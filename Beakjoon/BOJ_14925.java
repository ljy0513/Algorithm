package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14925 {
	static int N,M,res;
	static int[][] map,check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		check = new int[N+1][M+1];
		res = 0;
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pasture();
		System.out.println(res);
		
		
	}//main
	
	static void pasture(){
		for (int i = 1; i < N+1 ; i++) {
			for(int j =1 ; j<M+1; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) continue;
				
				check[i][j] = Math.min(Math.min(check[i-1][j],check[i-1][j-1]), check[i][j-1]) + 1;
				res = Math.max(res, check[i][j]);
			}
		}
	}

}












