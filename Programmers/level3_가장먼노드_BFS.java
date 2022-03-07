package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level3_가장먼노드_BFS {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		int answer = 0;
		boolean[] visited = new boolean[n+1];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{1,1});
		visited[1] = true;
		int max = 1;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			if(node[1] == max) {
				answer++;
			}else if(node[1] > max){
				max = node[1];
				answer = q.size()+1;
			}
			
			
			for(int i=0; i<edge.length; i++) {
				if(node[0] == edge[i][0] && !visited[edge[i][1]]) {
					q.add(new int[] {edge[i][1],node[1]+1});
					visited[edge[i][1]] = true;
				}else if(node[0] == edge[i][1] && !visited[edge[i][0]]) {
					q.add(new int[] {edge[i][0],node[1]+1});
					visited[edge[i][0]] = true;
				}
			}
		}
		
		System.out.println(answer);
		
		
	}
}
