package Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level3_네트워크 {

	public static void main(String[] args) {
		int n = 4;
		int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
			//{{1,1,1,0,0},{1,1,0,0,0},{1,0,1,0,0},{0,0,0,1,1},{0,0,0,1,1}};
			//{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		//연결된 컴퓨터끼리 하나의 정점 번호로 표시
		int[] visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visited[i] != 0) continue; //이미 다른 정점과 연결됨
			
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			visited[i] = i;
			
			while(!q.isEmpty()) {
				int v = q.poll();
				
				for(int j=1; j<=n; j++) {
					//자기 자신, 연결되어있지 않음, 이미 방문함
					if(v == j || computers[v-1][j-1] == 0 || visited[j] != 0) continue;
					
					q.add(j);
					visited[j] = i;
				}
			}
			
		}
		
		System.out.println(count(visited));
	}
	
	static int count (int[] visited) {
		int cnt = 1;
		int v = visited[1];
		
		//System.out.println(Arrays.toString(visited));
		for(int i=1; i<visited.length; i++) {
			if(v != visited[i]) {
				cnt++;
				v = visited[i];
			}
		}	
		return cnt;
	}

}
