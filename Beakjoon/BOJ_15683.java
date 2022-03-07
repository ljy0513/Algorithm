package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int N, M;
	static int[][] map,copy;
	static List<cctv> list;
	static int MIN = Integer.MAX_VALUE;
	static int[] direction;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new int[N][M];
		copy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=6 && map[i][j] !=0) {
					list.add(new cctv(map[i][j], i, j));
				}
			}
		}
		
		direction = new int[list.size()];
		Comb(0);
		System.out.println(MIN);
	}//main
	
	static void Comb(int cnt) {
		if(cnt == list.size()) {
			init();
			watch();
			MIN = Math.min(MIN, count());
			return;
		}
		
		cctv cc = list.get(cnt);
		int len = cc.dir.length; //해당 cctv 방향의 종류 개수
		
		for(int i=0; i<len; i++) {
			direction[cnt] = i;
			Comb(cnt+1);
		}
		
	}//Comb
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void watch() {
		for(int c=0; c<list.size(); c++) {
			cctv cc = list.get(c);
			int d = direction[c];
			int x = cc.x;
			int y = cc.y;
			
			for(int i=0; i<cc.dir[d].length; i++) { //방향 종류의 가지만큼 움직여야함
				int tmp = cc.dir[d][i];

				while(true) {
					x += dx[tmp];
					y += dy[tmp];
					if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
						copy[x][y] = 7;
					}else{
						x = cc.x; //방향으로 끝까지 갔다면 다시 제자리로 돌아와야지 다른 방향으로 감시 할 수 있음
						y = cc.y;
						break;
					}
				}
			}
		}
		
	}//watch
	
	static int count() {
		int cnt=0;		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == 0) cnt++;
			}
		}
		return cnt;			
	}//count
	
	static void init() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}//init

}

class cctv {
	int num;
	int x;
	int y;
	int[][] dir;
	
	public cctv(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
		
		if(num == 1) {
			dir = new int[][] {{0},{1},{2},{3}};
		}else if(num == 2){
			dir = new int[][] {{0,1},{2,3}};
		}else if(num == 3){
			dir = new int[][] {{0,3},{1,3},{1,2},{0,2}};
		}else if(num == 4){
			dir = new int[][] {{0,2,3},{0,1,3},{1,2,3},{0,1,2}};		
		}else {
			dir = new int[][] {{0,1,2,3}};
		}
	}
}


