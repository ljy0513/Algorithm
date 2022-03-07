package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10026 {
	static int N;
	static char[][] color;
	static char[][] RGcolor;
	static boolean[][] visited;
	static int none, blind;
	static int check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		color = new char[N][N];
		RGcolor = new char[N][N];
		visited = new boolean[N][N];
		none = 0;
		blind = 0;
		check =0;
		
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			color[i] = str.toCharArray();
			
			for(int j=0; j<N; j++) {
				if(color[i][j] == 'G') RGcolor[i][j] = 'R';
				else RGcolor[i][j] = color[i][j];
			}
		}
		
		int i=0;
		while(check < N*N) {
			for (int j = 0; j < N; j++) {
				if(check == N*N) break;			
				if (visited[i][j]) continue;
				dfs(i, j,color);
				none++;
			}
			i++;
		}

		i=0;
		check=0;
		for(int j=0; j<N; j++) {
			Arrays.fill(visited[j], false);
		}
		
		while(check < N*N) {
			if(i == N) break;
			for (int j = 0; j < N; j++) {
				if(check == N*N) break;			
				if (visited[i][j]) continue;
				dfs(i, j,RGcolor);
				blind++;
			}			
			i++;
		}
		
		System.out.println(none + " " + blind);
		
	}// main

	static int[] dx = { -1, 0, 0, 1 }; // 상,좌,우,하
	static int[] dy = { 0, -1, 1, 0 };

	static void dfs(int i, int j,char[][] c) {
		visited[i][j] = true;
		check++;
		
		for (int d = 0; d < 4; d++) {
			int x = i + dx[d];
			int y = j + dy[d];

			if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y])
				continue; // 경계 밖이거나 이미 방문 했다면
			if (c[i][j] != c[x][y])
				continue; // 색이 다르다면

			dfs(x, y,c);
		}
	}

}
