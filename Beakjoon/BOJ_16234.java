package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int day;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		day = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(day);
	}// main

	// 상,좌,하,우
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void bfs() {
		Queue<POS> queue1 = new LinkedList<>();
		int sum = 0;
		boolean check = true;

		while (check) { //인구 이동이 됐기 때문에 또 할 수 있는지 체크하기 위함
			check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					sum = 0;

					queue1.add(new POS(i, j));
					visited[i][j] = true;
					
                    //연결되 나라들 저장
					List<POS> list = new ArrayList<>();
					
					while (!queue1.isEmpty()) {
						POS pos = queue1.poll();
						list.add(pos);
						sum += map[pos.x][pos.y];

						for (int k = 0; k < 4; k++) {
							int x = pos.x + dx[k];
							int y = pos.y + dy[k];

							if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y])
								continue;
							if (Math.abs(map[x][y] - map[pos.x][pos.y]) >= L
									&& Math.abs(map[x][y] - map[pos.x][pos.y]) <= R) {
								queue1.add(new POS(x, y));
								visited[x][y] = true;
							}
						}
					}
					
					if (list.size() >= 2) { //연결된 나라들끼리 인구이동
						sum /= list.size();
						for(int k=0; k<list.size(); k++) {
							int x = list.get(k).x;
							int y = list.get(k).y;
							
							map[x][y] = sum;
						}
						check = true;//인구이동이 됨
					}
				}
			}
			init(); //다음날 인구 이동을 위해 방문 여부 초기화
			if(check) day++; //인구가 이동 됐다면 하루 증가시킴
		}

	}// bfs

	static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
	
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

