package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N, M,V;
	static int[][] graph;
	static StringBuilder bfs,dfs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to] = graph[from][to] = 1; //양방향
		}
		boolean[] visited = new boolean[N+1];
		dfs = new StringBuilder();
		dfs(V,visited);
		System.out.println(dfs);
		bfs();
		System.out.println(bfs);
	}
	
	private static void bfs() {
		bfs = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			bfs.append(n).append(" ");
			
			for(int i=1; i<N+1; i++) {
				if(graph[n][i] != 1 || visited[i]) continue;
				queue.offer(i);
				visited[i] = true;
			}
		}	
		
	}
	
	private static void dfs(int current,boolean[] visited) {
		visited[current] = true;
		dfs.append(current).append(" ");
		
		for(int i=1; i<N+1; i++) {
			if(graph[current][i] != 1 || visited[i]) continue;
			dfs(i,visited);
		}
	}
}


