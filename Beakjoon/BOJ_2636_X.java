package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_X {
	static int r, c;
	static int[][] cheeze;
	static boolean[][] visited;
	static int time, cnt; // 다 녹을때까지 시간, 치즈개수
	static Queue<POS> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		cheeze = new int[c][r];
		visited = new boolean[c][r];
		time = 0;
		cnt = 0;
		queue = new LinkedList<>();
		int remain = 0; //다 직전 녹기전 치즈의 개수
		
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < r; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
				if (cheeze[i][j] == 1) cnt++;
			}
		}

		while (cnt != 0) {
			System.out.println(remain);
			remain = cnt;
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < r; j++) {

					if (visited[i][j] || cheeze[i][j] == 1) continue;

					queue.add(new POS(i, j));
					visited[i][j] = true;
					bfs();
				}
			}
			
			for (int i = 0; i < c; i++) {
				System.out.println(Arrays.toString(cheeze[i]));				
			}
			init();
			time++;
		}
		
		sb.append(time).append("\n").append(remain);
		System.out.println(sb);

	}// main

	// 상,우,하,좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs() {

		int x, y;

		while (!queue.isEmpty()) {

			POS pos = queue.poll();

			for (int i = 0; i < 4; i++) {
				x = pos.x + dx[i];
				y = pos.y + dy[i];

				if (x < 0 || x >= c || y < 0 || y >= r || visited[x][y]) continue;
				
				if(cheeze[x][y] == 1) {
					cheeze[x][y] = 0;
					cnt--;
				}else {
					queue.add(new POS(x, y));	
				}				
				visited[x][y] = true;
			}
		}
		
		
	}// bfs

	static void init() {
		for (int i = 0; i < c; i++) {
			Arrays.fill(visited[i], false);
		}
	}// init

	static class POS {
		int x, y;

		POS(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + "]";
		}
	}
}
