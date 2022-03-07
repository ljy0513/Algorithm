package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. 두 선거구로 나눈다
// 2. 두 선거구가 이어져있는지 확인
// 3. 두 선거구의 인구 차이를 계산 -> 원래 최소값보다 작으면 업데이트

public class BOJ_17471 {
	static int N;
	static int[][] matrix;
	static int[] population;
	static boolean[] visited;
	static int[] area1, area2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 구역의 수
		N = Integer.parseInt(in.readLine());

		// 구역마다 인구 수 저장
		st = new StringTokenizer(in.readLine());
		population = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			population[i] = Integer.parseInt(st.nextToken());

		// 연결된 구역 인접 행렬
		int n, v;
		matrix = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				v = Integer.parseInt(st.nextToken());
				matrix[i][v] = matrix[v][i] = 1;
			}
		}

		
		for (int i = 1; i < N; i++) {
			area1 = new int[i];
			area2 = new int[N-i];
			Comb(0, 1, i);
		}
		System.out.println(min);
	}

	static void Comb(int cnt, int start, int select) {
		if (cnt == select) {
			// area1에 포함되지 않은 구역을 area2에 저장해서 두 선거구로 나누기
			int idx = 0;
			for (int i = 1; i < 1 + N; i++) {
				if (!contains(i,area1)) continue;
				area2[idx++] = i;
			}
			
			System.out.println(Arrays.toString(area1));
			System.out.println(Arrays.toString(area2));
			
			// 2. 두 선거구가 이어져있는지 확인
			visited = new boolean[1 + N];
			if (Connected(area1) && Connected(area2)) {
				// 3. 두 선거구의 인구 차이를 계산 -> 원래 최소값보다 작으면 업데이트
				min = Math.min(min, minimum());
			}
			return;
		}

		for (int i = start; i < N + 1; i++) {
			area1[cnt] = i;
			Comb(cnt + 1, i + 1, select);
			
		}
	}

	// 선거구끼리 연결되었는지 확인
	static boolean Connected(int[] area) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		
		for (int i = 1; i < 1 + N; i++) {
			if (visited[i])
				continue;

			q.add(i);
			visited[i] = true;
			
			while (!q.isEmpty()) {
				int v = q.poll();

				for (int j = 1; j < 1 + N; j++) {
					// 같은 구역에 있고, 입접된 구역이라면
					if (contains(j, area) && matrix[v][j] == 1 && !visited[j]) {
						q.add(j);
						cnt++;
						visited[j] = true;
					}
				}
			}

		}

		if (cnt != area.length)
			return false;
		return true;
	}

	// 두 선거구의 인구차이 계산
	static int minimum() {
		int sum1 = 0, sum2 = 0;

		for (int i = 0; i < area1.length; i++) 
			sum1 += population[area1[i]];

		for (int i = 0; i < area1.length; i++) 
			sum2 += population[area2[i]];		

		return Math.abs(sum1 - sum2);
	}
	
	static boolean contains(int n , int[] area) {
		for(int i=0; i<area.length; i++) {
			if(area[i] == n) return true; //같은게 있으면 
		}
		return false;
	}

}
