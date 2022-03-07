package Solution;

import java.util.*;

public class level3_섬연결하기 {
	static int[] parents;
	static int[][] edgeList;
	static int N;

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int answer = 0;
		N = n;
		edgeList = costs;
		parents = new int[n];

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		make();

		int cnt = 0;

		for (int[] cost : costs) {
			if (union(cost[0], cost[1])) {
				answer += cost[2];
				cnt++;
				if (cnt == n - 1)
					break;
			}
		}

		System.out.println(answer);
	}

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return false;
		parents[broot] = aroot;
		return true;
	}

}
