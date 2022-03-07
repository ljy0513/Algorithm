package Solution;

import java.util.Arrays;

public class level2_행렬테두리 {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[][] adj = new int[rows][columns];
		int num = 1;
		
		for(int i=0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				adj[i][j] = num;
				num++;
			}
		}
		

	}
	
	static void lotate(int[][] queries, int[][] adj) {
		for(int i=0; i<queries.length; i++) {
			int r1 = queries[i][0];
			int c1 = queries[i][1];
			int r2 = queries[i][2];
			int c2 = queries[i][3];
			
			int tmp = adj[r1][c1];
			int min = 10001;

		}
	}

}
