package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485 {
	static int N;
	static int[][] map,distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		StringBuilder sb = new StringBuilder();
		int t = 1;
		
		while(true) {	
			//입력
			N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs();
			sb.append("Problem ").append(t++).append(": ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.println(sb);

	}//main
	
	//상,우,하,좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void bfs() {	
		Queue<POS> q= new LinkedList<>();
		q.add(new POS(0,0));
		distance[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			POS pos = q.poll();

			for(int i=0; i<4; i++) {
				int x = pos.x + dx[i];
				int y = pos.y + dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= N ) continue;			
				
				if(distance[x][y] > distance[pos.x][pos.y] + map[x][y]) {
					q.add(new POS(x,y));
					distance[x][y] = distance[pos.x][pos.y] + map[x][y];
				}			
				
			}//for
		}//while
	}//bfs
	
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

//우선순위큐 사용?