package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1754_list {
	static class Edge implements Comparable<Edge> {
		int end;
		int weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(in.readLine()); // 시작 정점 번호

		boolean[] visited = new boolean[V + 1];
		int[] distance = new int[V + 1];
		ArrayList<Edge>[] list = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
//		for (int i = 1; i < V + 1; i++) {
//			distance[i] = Integer.MAX_VALUE;
//		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v, w));
		}

		PriorityQueue<Edge> queue = new PriorityQueue<>();

		queue.offer(new Edge(K, 0));
		distance[K] = 0;

	    while (!queue.isEmpty()) {
            Edge node = queue.poll();
            int cur = node.end;
            int weight = node.weight;
            if (distance[cur]<weight) continue;
            
            for(int i=0; i<list[cur].size(); i++) {
                int v = list[cur].get(i).end;
                int w = list[cur].get(i).weight+weight;
                
                if (distance[v] > w) {
                    distance[v] = w;
                    queue.offer(new Edge(v ,w));
                }
            }
        }
	    /*
		while (!queue.isEmpty()) {
			int cur = queue.poll().end;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for(int i=0; i<list[cur].size(); i++) {
				int v = list[cur].get(i).end;
				int w = list[cur].get(i).weight;
				
				if (distance[v] > distance[cur] + w) {
					distance[v] = distance[cur] + w;
					queue.offer(new Edge(v ,w));
				}
			}
		}
		*/

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] != Integer.MAX_VALUE)
				sb.append(distance[i]).append("\n");
			else
				sb.append("INF\n");
		}
		
		System.out.print(sb);
	}

}
