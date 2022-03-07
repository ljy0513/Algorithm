package Solution;

import java.util.HashSet;
import java.util.Set;

public class level2_방문길이 {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		int answer = 0;

		// 갔던곳 재방문 가능
		// 경계 벗어나면 무시
		// 한점을 배열의 한칸으로 설정!!

		// 현재 시작점
		int nx = 5, ny = 5;

		// 상,하,좌,우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Set<Pair> set = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			int mx = 0, my = 0;
			char dir = dirs.charAt(i);

			if (dir == 'U') { // 상
				mx = nx + dx[0];
				my = ny + dy[0];
			} else if (dir == 'D') { // 하
				mx = nx + dx[1];
				my = ny + dy[1];
			} else if (dir == 'L') { // 좌
				mx = nx + dx[2];
				my = ny + dy[2];
			} else { // 우
				mx = nx + dx[3];
				my = ny + dy[3];
			}
			
			if(mx < 0 || mx > 10 || my < 0 || my > 10) continue;
			
			set.add(new Pair(nx,ny,mx,my));
			set.add(new Pair(mx,my,nx,ny)); // 반대 방향도 같은 길은 간것이기 때문에 포함해야함
			
			nx = mx;
			ny = my;
		}
		
		answer = set.size()/2;
		System.out.println(answer);

	}

	static class Pair {
		int x1, y1, x2, y2;

		public Pair(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x1;
			result = prime * result + x2;
			result = prime * result + y1;
			result = prime * result + y2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x1 != other.x1)
				return false;
			if (x2 != other.x2)
				return false;
			if (y1 != other.y1)
				return false;
			if (y2 != other.y2)
				return false;
			return true;
		}

		

	}

}
