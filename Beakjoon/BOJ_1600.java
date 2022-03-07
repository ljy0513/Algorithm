package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[K + 1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
	}// main

	// 상,우,하,좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	// 좌상 아래부터 우상 방향으로
	static int[] kx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] ky = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static void bfs() {
		Queue<POS> queue = new LinkedList<>();
		queue.add(new POS(0,0,0,0));
		
		while (!queue.isEmpty()) {
			POS pos = queue.poll();

			// 도착시 종료
			if (pos.x == H - 1 && pos.y == W - 1) {
				System.out.println(pos.cnt);
				return;
			}

			for (int i = 0; i < dx.length; i++) {

				int x = pos.x + dx[i];		
				int y = pos.y + dy[i];
				
				if(x < 0 || x >= H || y < 0 || y >= W || visited[pos.k][x][y] || map[x][y] == 1) continue;
				
				queue.add(new POS(x,y,pos.k,pos.cnt+1));
				visited[pos.k][x][y] = true;		
			}
			
			if(pos.k+1 > K) continue;
			
			for(int i=0; i<kx.length; i++) {				
				int x = pos.x + kx[i];		
				int y = pos.y + ky[i];
				if(x < 0 || x >= H || y < 0 || y >= W || visited[pos.k+1][x][y] || map[x][y] == 1) continue;
				
				queue.add(new POS(x,y,pos.k+1,pos.cnt+1));
				visited[pos.k+1][x][y] = true;	
			}
		}
		
		System.out.println(-1);

	}

	static class POS {
		//x좌표,y좌표,점프,이동횟수
		int x, y, k, cnt;

		public POS(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + "]";
		}

	}
}
