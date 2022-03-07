package Solution;

import java.util.Arrays;

public class level3_가정먼노드_다익스트라실패 {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		int answer = 0;
		
		int[][] matrix = new int[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];
		int[] distance = new int[n + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		for (int i = 0; i < edge.length; i++) {
			matrix[edge[i][0]][edge[i][1]] = matrix[edge[i][1]][edge[i][0]] = 1;
		}

		int min = 0, current = 1, max = 0;
		for (int i = 1; i <= n; ++i) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j <= n; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;

			for (int c = 1; c <= n; c++) {
				if (!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) {
					distance[c] = min + matrix[current][c];
					max = max < distance[c] ? distance[c] : max;
				}
			}
		}
		
		for (int i = 1; i < distance.length; i++) {
			if(max == distance[i]) answer++;
		}
		
		System.out.println(answer);
	}

}
