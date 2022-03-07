package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static int N,M;
	static boolean[][] matrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new boolean[1+N][1+N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			matrix[s][e] = matrix[e][s] = true;			
		}		
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[1+N];
		int cnt = 0;
		
		for(int i = 1; i<1+N; i++) {
			if(visited[i]) continue;
			cnt++;
			q.add(i);
			visited[i] = true;
			
			while(!q.isEmpty()) {
				int n = q.poll();
				
				for(int j=1; j<1+N; j++) {
					if(visited[j] || !matrix[n][j]) continue;
					
					q.add(j);
					visited[j] = true;
				}
			}	
			
		}
		
		return cnt;
		
	}//bfs

}
