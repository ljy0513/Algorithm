package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level2_게임맵최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int answer = bfs(maps);
		System.out.println(answer);
	}
	
	public static int bfs(int[][] maps) {
		int res = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int r = maps.length;
		int c = maps[0].length;
		boolean[][] visited = new boolean[r][c];
		
		Queue<POS> q = new LinkedList<>();
		q.add(new POS(0,0,1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			
			POS pos = q.poll();
			
			if(pos.x == r-1 && pos.y == c-1) {
				res = pos.m;
				break;
			}else {
				res = -1;
			}
			
			for(int i=0; i<4; i++) {
				int x = pos.x + dx[i];
				int y = pos.y + dy[i]; 
				int m = pos.m;
				if(x < 0 || x >= r || y < 0 || y >= c || visited[x][y] || maps[x][y] == 0) continue;
				
				q.add(new POS(x,y,m+1));
				visited[x][y] = true;
			}
		}
		
		return res;
	}
	
	static class POS {
		int x,y,m;
		
		POS(int x, int y, int m){
			this.x = x;
			this.y = y;
			this.m = m;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + ", m=" + m + "]";
		}
	}
}
