package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static Shark[][] map, temp;
	static int R, C, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[1 + R][1 + C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}
		
		System.out.println(fishing());
	}

	static int fishing() {
		int sum = 0;

		for (int i = 1; i <= C; i++) {

			// 낚시하기
			for (int j = 1; j <= R; j++) {
				
				if (map[j][i] != null) {
					Shark shark = map[j][i];
					sum += shark.z;
					map[j][i] = null;
					break; //땅에서 가장 가까운 상어 낚시 완료하면 낚시 그만!
				}
			}

			//상어 이동
			move();
			//이동 완료 후 이동한 자리로 map바꾸기
			change();	
		}
		return sum;
	}

	// 상,하,우,좌 -> 1,2,3,4
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	static void move() {
		//이동 후 같은자리에 상어가 있는지 한번에 체크해야하기 때문에 새로운 배열에 이동 후 map에 저장해준다.
		temp = new Shark[1 + R][1 + C];
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] == null) continue;
				
				Shark s = map[i][j];
				int nr = s.r;
				int nc = s.c;
				int d = s.d; // 상어의 이동 방향

				int cnt = 0; // 몇번 이동했는지 카운팅
				int x=nr,y=nc;//이동하기 직전에 있던 위치를 저장해줌
				
				while (cnt < s.s) {
					nr += dx[d];
					nc += dy[d];
					
					if (nr < 1 || nr >= R+1 || nc < 1 || nc >= C+1) {
						if (d == 1 || d == 2)
							d = d == 1 ? 2 : 1;
						else if (d == 3 || d == 4)
							d = d == 3 ? 4 : 3;
						nr = x;
						nc = y;
						continue;
					}
					x = nr;
					y = nc;
					cnt++;
				}

				s.r = nr;
				s.c = nc;
				s.d = d;

				// 이동한 자리에 이미 상어가 있다면
				if (temp[nr][nc] != null) {
					if (temp[nr][nc].z < s.z) temp[nr][nc] = s;
				} else {
					temp[nr][nc] = s;
				}
			}
		}

	}// move

	static void change() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

}
