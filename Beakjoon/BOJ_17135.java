package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int map[][];
	static int copy[][];
	static boolean check[][];
	static int N;
	static int M;
	static int D;
	static int[] bowman;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bowman = new int[3];
		comb(0,0);
		System.out.println(MAX);

	}

	static void comb(int cnt, int start) {
		if (cnt == 3) {
			init(); //다음 궁수의 조합의 적수를 계산하기 위해서 원래 map으로 초기화
			play();
			count();
			return;
		}
		for (int i = start; i < M; i++) {
			bowman[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}// comb

	static void play() {
		boolean flag = false;
		for (int n = N; n > 0; n--) { //궁수의 위치를 앞으로 당김 (next turn)
			for (int i = 0; i < bowman.length; i++) {//각 궁수들이 공격
				for (int j = 1; j <= D; j++) {
					flag = shoot(n, bowman[i], j);
					if(flag) break;
				}
			}
			flag = false;
			kill(); //다음 턴으로 넘어가기전 죽은 적들을 0으로 처리해줌
		}

	}//play

	static boolean shoot(int x, int y, int d) { //(x,y) : 궁수의 위치 , d : 사정거리
		int distance = 0;
		int min_x=0,min_y=M+1;
		for (int i = x-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				distance = Math.abs(x - i) + Math.abs(y - j);
				if (distance == d) {
					if(copy[i][j] == 1) {
						if(min_y > j) {
							min_x = i;
							min_y = j;
						}
					}
				}
			}
		}
		
		if(min_y < M) {
			check[min_x][min_y]= true;
			return true;
		}
		return false;		
	}// shoot
	
	static void count() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j]) {
					check[i][j] = false; // 다음 궁수의 조합으로 적의 개수를 체크하기 위해서 초기화
					cnt++; // 처리한 적의 수 세주기
				}
			}
		}
		MAX = Math.max(cnt,MAX);
	}
	
	static void kill() { //한턴이 끝나고 죽은 적을 0으로 바꿔줌 (다음턴에 체크되지 않아야하기 때문)
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j]) copy[i][j] = 0;
			}
		}
	}
	
	static void init() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}
