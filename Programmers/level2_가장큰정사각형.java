package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level2_가장큰정사각형 {

	public static void main(String[] args) {
		int[][] board = //{{0,0,1,1},{1,1,1,1}};
			{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int answer = 0;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 1) {
					answer = Math.max(square(i,j,board),answer);
				}
			}
		}
		
		System.out.println(answer * answer);
	}
	
	static int square(int x, int y, int[][] board) {
		int[] dx = {0,1,1};
		int[] dy = {1,1,0};
		
		Queue<POS> q = new LinkedList<>();
		boolean[][] checked = new boolean[board.length][board[0].length];
		boolean flag = true;
		int len = 0;
		
		q.add(new POS(x,y,1));
		checked[x][y] = true;
		
		while(!q.isEmpty()) {		
			POS pos = q.poll();
			len = pos.d;
			
			for(int i=0; i<dx.length; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
					flag = false;
					break;
				}
				
				if(board[nx][ny] == 1 && !checked[nx][ny]) {
					q.add(new POS(nx,ny,pos.d+1));
					checked[nx][ny] = true;
				}else {
					flag = false;
					break;
				}
			}			
			if(!flag) break;
		}
		return len;
	}
	
	static class POS{
		int x, y, d;

		public POS(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + ", d=" + d + "]";
		}	
	}

}
