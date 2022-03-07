package Solution;

import java.util.Arrays;

public class level3_순위 {

	public static void main(String[] args) {
		int answer = 0;
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		boolean[][] checked = new boolean[n][n];
		
		for(int i = 0; i < n ; i++) {
			for (int j = 0; j < 2; j++) {
				int s = results[i][0]-1;
				int d = results[i][1]-1;
				checked[s][d] = true;
			}
		}
		
		for(int k=0; k<n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(checked[i][k] && checked[k][j]) {
						checked[i][j] = true;
					}
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(checked[i]));
//		}
		
		for(int i =0; i<n; i++) {
			int res = 0;
			for(int j=0; j<n; j++) {
				if(checked[i][j] || checked[j][i]) res++;
			}
			if(res == n-1) answer++;
		}
		
		System.out.println(answer);
	}

}
