package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int R;
	static int C;
	static char[][] pipe;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		pipe = new char[R][C];
		String str;
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			pipe[i] = str.toCharArray();
		}
		
		cnt=0;
		for(int i=0; i<R; i++) { //모든 행에서 출발 해봐야하기 때문
			move(i,0);
		}
		
		System.out.println(cnt);
		
	}// main

	static int[] dx = { -1, 0, 1 };

	static boolean move(int r, int c) {
		pipe[r][c] = 'X';
		
		if (c == C-1) {
			cnt++;
			return true;
		}

		for (int i = 0; i < dx.length; i++) {
			if(r+dx[i] >= 0 && r+dx[i] < R) {//이동하려는 곳이 경계 밖이 아닐 때
				if (pipe[r+dx[i]][c+1] == '.') {//이동한 자리가 장애물이 없으면
					if(move(r + dx[i], c + 1)) return true; //이미 파이프를 연결했기 때문에 재귀를 나와서 다른 방향으로 가지 말아야한다.
				}
			}
		}
		return false; //세방향으로 모두 가지 못하면 재귀를 탈출하고 다른 방향으로 탐색
	}

}

