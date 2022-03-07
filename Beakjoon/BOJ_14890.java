package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
	static int[][] map;
	static int N, X;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		System.out.println(check());
	}
	
	static int check() {
		int cnt = 0;

		// 행 검사
		for (int i = 0; i < N; i++) {
			if(row(i)) cnt++;
			//System.out.println("row : " + i + " " + cnt);
		}

		// 열 검사
		for (int i = 0; i < N; i++) {
			if(col(i)) cnt++;
			//System.out.println("col : " + i + " " + cnt);
		}
		return cnt;
	}
	
	static boolean row(int i) {
		boolean[] used = new boolean[N]; //이미 경사로를 놓은 곳 체크
		
		for (int j = 0; j < N-1; j++) {
			if (map[i][j] == map[i][j+1]) {
				continue;
			}
			
			// 활주로의 높이는 무조건 1이기 때문에 1이상 차이나면 활주로를 만들 수 없다.
			if (Math.abs(map[i][j] - map[i][j+1]) > 1) {
				return false;
			}
			
			if(map[i][j] < map[i][j+1]) {
				if(j < X-1) return false;
				for (int k = j; k > j-X; k--) {
					if (map[i][k] != map[i][j] || used[k]) return false;				
					used[k] = true;
				}
			}else if(map[i][j] > map[i][j+1]){
				if(j >= N-X) return false;
				for (int k = j + 1; k <= j + X; k++) {
					if (map[i][k] != map[i][j+1] || used[k]) return false;				
					used[k] = true;
				}
				j += X - 1;
			}
		}	
		return true;
	}
	
	static boolean col(int i) {
		boolean[] used = new boolean[N]; //이미 경사로를 놓은 곳 체크
		
		for (int j = 0; j < N-1; j++) {
			if (map[j][i] == map[j+1][i] )  {
				continue;
			}
			
			// 활주로의 높이는 무조건 1이기 때문에 1이상 차이나면 활주로를 만들 수 없다.
			if (Math.abs(map[j][i] - map[j+1][i]) > 1) {
				return false;
			}
			
			if(map[j][i] < map[j+1][i]) {
				if(j < X-1) return false;
				for (int k = j; k > j-X; k--) {
					if (map[k][i] != map[j][i] || used[k]) {
						return false;
					}
					used[k] = true;
				}
			}else if(map[j][i] > map[j+1][i]){
				if(j >= N-X) return false;
				for (int k = j + 1; k <= j + X; k++) {
					if (map[k][i] != map[j+1][i] || used[k]) {
						return false;
					}
					used[k] = true;
				}
				j += X - 1;
			}
		}	
		return true;
	}

}
