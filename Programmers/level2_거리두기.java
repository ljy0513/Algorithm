package Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level2_거리두기 {
	
	public static void main(String[] args) {
		String[][] places = { {"OOOOO", "OOOOO", "OPXOO", "OXPOO", "OPOOO"}, 
							  {"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}, 
		                      {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
		                      {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
		                      {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"} };
		
		int[] answer = new int[5];
		char[][] place = new char[5][5];
			
		for(int i=0; i<5; i++) {
			for (int j = 0; j < answer.length; j++) {
				place[j] = places[i][j].toCharArray();
				//System.out.println(Arrays.toString(place[j]));
			}
			//System.out.println("----------------------------------");
			answer[i] = bfs(place);
		}
		
		System.out.println(Arrays.toString(answer));
	}//main
	
	static int bfs(char[][] place) {
		Queue<POS> q = new LinkedList<>();
		boolean[][] visited;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		
		for(int i=0; i<5; i++) {
			for (int j = 0; j < 5; j++) {			
				if(place[i][j] != 'P') continue;
				visited = new boolean[5][5];
				
				q.add(new POS(i,j));
				visited[i][j] = true;
								
				while(!q.isEmpty()) {					
					POS pos = q.poll();
					if(Math.abs(i-pos.x) + Math.abs(j-pos.y) >= 2) break;
					
					for(int d=0; d<4; d++) {
						int x = pos.x+dx[d];
						int y = pos.y+dy[d];
						
						if(x < 0 || x >= 5 || y < 0 || y >= 5 || visited[x][y] || place[x][y] == 'X') continue;
						if(place[x][y] == 'P') return 0;
						
						q.add(new POS(x,y));
						visited[x][y] = true;
					}
				}
				q.clear();
			}
		}	
		return 1;
	}
	
	static class POS{
		int x,y;

		public POS(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + "]";
		}
	}
}
