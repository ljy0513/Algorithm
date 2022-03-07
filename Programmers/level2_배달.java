package Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class level2_배달 {

	public static void main(String[] args) {
		int N = 6;
		//int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		int[][] adj  = new int[N+1][N+1];
		
		for(int[] arr : adj) Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0; i<road.length; i++) {
			int v1= road[i][0];
			int v2= road[i][1];
			int e= road[i][2];
			if(adj[v1][v2] < e) continue; //원래 있던 값이 더 작으면 갱신X
			adj[v1][v2] = adj[v2][v1]= e;
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return dist[o1] - dist[o2];
			}
		});
		
		//시작 시점 큐에 추가
		pq.add(1);
		dist[1] = 0; //자신과의 거리
		
		while(!pq.isEmpty()) {		
			int nv = pq.poll();
			if(visited[nv]) continue;
			visited[nv] = true;
			
			for(int i=1; i<=N; i++) {
				if(adj[nv][i] == Integer.MAX_VALUE) continue;
				
				if(dist[i] > dist[nv] + adj[nv][i]) {
					dist[i] = dist[nv] + adj[nv][i];
					pq.add(i);
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		int answer = 0;
		for(int i=1; i<= N; i++) {
			if(dist[i] <= K) answer++;
		}
		
		System.out.println(answer);
	}

}
