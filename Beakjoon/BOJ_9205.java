package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9205 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(in.readLine());
			List<POS> list = new ArrayList<>();
				
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new POS(x,y));
			}
			
			int[][] dis = new int[N+2][N+2];
			
			for(int i=0; i<N+2; i++) {
				for (int j = i+1; j < N+2; j++) {
					dis[i][j]=Math.abs(list.get(i).x-list.get(j).x)+Math.abs(list.get(i).y-list.get(j).y);
					if(dis[i][j]>1000) {
						dis[i][j]=-1;
						dis[j][i]=-1;
					}
				}
			}
			
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i <N+2; i++) {
					if(k==i)continue;
					for (int j = 0; j < N+2; j++) {
						if(i==j || j==k)continue;
						if(dis[i][k]==-1 || dis[k][j]==-1) continue;
						
						dis[i][j]=1;

					}
				}
			}
			
			if(dis[0][N+1]==-1) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}

		}//test
	}

	static class POS {
		int x, y;

		POS(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "POS [x=" + x + ", y=" + y + "]";
		}
	}
}

