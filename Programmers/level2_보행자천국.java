package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class level2_보행자천국 {

	public static void main(String[] args) {
		int m = 3;
		int n = 6;
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		int answer = 0;

		// 하, 우 방향만 이동가능
		// 0 -> 통과, 1 -> 금지, 2 ->직진만 가능
		// 20170805로 나눈 나머지
		// (0,0)출발 -> (m-1,n-1)도착
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,0));
		
		int[][] dir = { { 1, 0 }, { 0, 1 } };
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			
			if(pos.x == m-1 && pos.y == n-1) answer++;
			
			for (int i = 0; i < dir.length; i++) {
				if((i == 0 && pos.d == 1) || (i == 1 && pos.d == -1)) continue;
				
				int mx = pos.x + dir[i][0];
				int my = pos.y + dir[i][1];
				
				if(mx < 0 || mx >= m || my < 0 || my >= n || cityMap[mx][my] == 1) continue;
				
				q.add(new Pos(mx,my,cityMap[mx][my] == 0 ? 0 : i == 0 ? -1 : 1)); //직진만 가능하지 체크
			}
		}
		
		System.out.println(answer % 20170805);
		
	}

	static class Pos {
		int x, y, d; // d : -1 - 하, 1 - 우, 0 - 둘다 가능

		public Pos(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", d=" + d + "]";
		}

	}
}
