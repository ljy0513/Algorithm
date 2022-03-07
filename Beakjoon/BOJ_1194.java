package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<POS> q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64]; // 1<<6 == 64
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			if (q.size() != 0)
				continue;

			for (int j = 0; j < M; j++) {
				// 시작점 부터 탐색 시작
				if (map[i][j] == '0') {
					q.add(new POS(i, j, 0, 0));
					visited[i][j][0] = true;
					break;
				}
			}
		}
		
		System.out.println(bfs());
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int bfs() {

		while (!q.isEmpty()) {
			System.out.println(q.peek());
			POS pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = pos.x + dx[i];
				int y = pos.y + dy[i];

				// 경계 밖 , 벽 , 현재 키의 상태에서 방문을 했던 곳이라면 더 이상 가지 못함
				if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == '#' || visited[x][y][pos.key])
					continue;

				// 1 을 만났을 때 탈출
				if (map[x][y] == '1')
					return pos.dist + 1;

				// key를 획득
				if (map[x][y] >= 'a' && map[x][y] <= 'f') {
					// 1 << map[x][y] - 'a') : 1을 획득한 키의 위치로 비트 옮겨줌
					// | 연산은 같은 키가 있어도 상관없음
					int key = pos.key | (1 << map[x][y] - 'a');
					q.add(new POS(x, y, key, pos.dist + 1));
					visited[x][y][key] = true;
				}
				// 문을 만남
				else if (map[x][y] >= 'A' && map[x][y] <= 'F') {
					// & 연산은 해당 문에 맞는 키가 있다면 키와 문의 비트위치가 1이므로 0이 아님
					if ((pos.key & (1 << map[x][y] - 'A')) != 0) {
						q.add(new POS(x, y, pos.key, pos.dist + 1));
						visited[x][y][pos.key] = true;
					}
				}else{
					q.add(new POS(x, y, pos.key, pos.dist + 1));
					visited[x][y][pos.key] = true;
				}
					
			}

		} // while

		// 출구를 찾지 못했다면 -1 반환
		return -1;
	}

	static class POS {
		// 좌표,갖고있는 키,누적 거리
		int x, y, key, dist;

		public POS(int x, int y, int key, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + ", key=" + key + ", dist=" + dist + "]";
		}
	}
}

//key 000000 : 아무키도 획득하지 못한 상태
