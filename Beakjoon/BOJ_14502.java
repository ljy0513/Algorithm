package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[][] lab, copy;
	static List<POS> list;

	static class POS {
		int x, y;

		POS(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		copy = new int[N][M];
		list = new ArrayList<>(); // 벽을 세울 수 있는 위치만 저장

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) list.add(new POS(i, j));			
			}
		}

		Comb(0, 0);
		System.out.println(max);
	}

	static void Comb(int cnt, int start) {
		if (cnt == 3) {			
			bfs();		
			return;
		}

		for (int i = start; i < list.size(); i++) {
			POS wall = list.get(i);
			//벽을 세움
			lab[wall.x][wall.y] = 1;
			//다음 벽을 세우러감
			Comb(cnt + 1, i+1);
			//돌아와서 원위치
			lab[wall.x][wall.y] = 0;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs() {
		Queue<POS> q = new LinkedList<>();
		init();
		
		//바이러스 위치를 모두 저장
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copy[i][j] == 2)
					q.add(new POS(i, j));
		
		//바이러스 감염 시작
		while (!q.isEmpty()) {
			POS virus = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = virus.x + dx[i];
				int y = virus.y + dy[i];
				
				if(x < 0 || x >= N || y < 0 || y >= M) continue;
				
				// 감염되지 않은 곳이라면 감염 시킴
				// 방문 체크는 0->2로 변했기 때문에 필요없음
				if (copy[x][y] == 0) {
					copy[x][y] = 2; //감염
					q.add(new POS(x, y));
				}
			}
		}

		// 감염되지 않은곳 count
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copy[i][j] == 0) cnt++;

		max = Math.max(cnt, max);

	}

	static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = lab[i][j];
			}
		}
	}

}
