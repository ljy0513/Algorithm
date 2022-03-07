package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2606 {
	static int N,M;
	static boolean[][] matrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		matrix = new boolean[1+N][1+N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			matrix[s][e] = matrix[e][s] = true;			
		}		
		
		System.out.println(dfs());
	}

	static int dfs() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[1+N];
		int cnt = 0;
		stack.push(1);
		visited[1] = true;
		
		while(!stack.isEmpty()) {
			int n = stack.peek();
			boolean flag = false;
			
			for(int i=1; i<1+N; i++) {
				if(matrix[n][i] && !visited[i]) {
					stack.push(i);
					cnt++;
					visited[i] = true;
					flag = true;
					break;
				}
			}
			
			if(!flag) stack.pop();
		}
		
		return cnt;
	}
}
