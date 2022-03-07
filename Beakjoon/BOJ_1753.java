package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1753 {
	static int[][] adjMatrix;
	static boolean[] visited;
	static int V, E, K;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(in.readLine()); // 시작 정점 번호

		adjMatrix = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		int[] distance = new int[V + 1];

		for (int i = 1; i < V + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjMatrix[u][v] = w;
		}

		distance[K] = 0;
		int vertex = 0;
		
		for (int i = 1; i < V + 1; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j]; //min : 시작 점 부터 각 정점까지의 경로가 가장 작은 경로 저장
					vertex = j; //지금까지의 최소경로의 마지막 정점 저장
				}
			}
			visited[vertex] = true;
			
			for(int j=1; j<V+1; j++) {
				if(!visited[j] && adjMatrix[vertex][j] != 0
						&& distance[j] > adjMatrix[vertex][j]+min) {
					distance[j] = adjMatrix[vertex][j]+min;
				}
			}							
		}
		
		for(int i=1; i<V+1; i++) {
			if(distance[i] != Integer.MAX_VALUE) System.out.println(distance[i]);
			else System.out.println("INF");
		}
	}

}
