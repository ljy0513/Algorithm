package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static List<Edge> edgelist;
	static int[] parents; // 부모원소를 관리(트리처럼 사용)
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		edgelist = new ArrayList<>();
		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		//섬 번호 생성
		bfs();
		
		//for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
		
		//다리 만들기
		makeEdge();
			
		//최소 신장 트리
		
		Collections.sort(edgelist); // 간선 리스트를 가중치 기준으로 오름 차순 정렬
		//for(int i=0; i<edgelist.size(); i++) System.out.println(edgelist.get(i));
		
		parents = new int[cnt+1];
		make(); //모든 정점을 각각의 집합으로 만들고 출발
		
		//간선을 하나씩 시도 하면서 트리를 만들어감
		int edges =0; //쓴 간선의 개수
		int result =0; //사용한 간선들의 가중치의 합
		for (Edge edge : edgelist) {
			if(union(edge.s, edge.e)) {
				result += edge.l;
				edges++;
				if(edges == cnt-1) break; //신장트리 완성
			}
		}
		
		if(edges != cnt-1) System.out.println(-1);
		else System.out.println(result);
	

	}//main

	// 섬의 개수 세기
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 0) continue; // 바다거나, 이미 방문 했던 곳이면
				
				Queue<POS> q = new LinkedList<>();
				q.add(new POS(i, j));
				visited[i][j] = true;
				cnt++;
				map[i][j] = cnt;
				
				while (!q.isEmpty()) {
					POS pos = q.poll();

					for (int d = 0; d < 4; d++) {
						int x = pos.x + dx[d];
						int y = pos.y + dy[d];

						if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] == 0) continue;

						q.add(new POS(x, y));
						visited[x][y] = true;
						map[x][y] = cnt;
					}
				}
				
			}
		}
		
	}

	static void makeEdge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;

				// 상,우,하,좌
				for (int d = 0; d < 4; d++) {
					int x = i;
					int y = j;
					int len = 0;
					
					while (true) {
						x += dx[d];
						y += dy[d];

						// 경계 밖이거나 나랑 같은 섬이라면 탈출
						if (x < 0 || x >= N || y < 0 || y >= M || map[i][j] == map[x][y]) break;
						// 바다라면 다리 만들기
						else if (map[x][y] == 0) len++;
						// 다른 섬을 만난다면 다리 생성(edge생성)
						else if (map[i][j] != map[x][y]) {
							if(len >= 2) {
								edgelist.add(new Edge(map[i][j], map[x][y], len));
							}
							break;
						}
					}
				}

			}
		}
	}
	
	
	private static void make() {
		parents = new int[cnt+1];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <cnt+1 ; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자라면
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합치기)
	private static boolean union(int a, int b) {
		int aRoot = find(a); //a가 속해있는 집합의 대표자를 찾음
		int bRoot = find(b); //b가 속해있는 집합의 대표자를 찾음
		if (aRoot == bRoot)
			return false; // 이미 부모가 같으므로 같은 집합은 합치지 않음

		parents[bRoot] = aRoot;
		return true;
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

	static class Edge implements Comparable<Edge> {
		int s, e, l;

		public Edge(int s, int e, int l) {
			super();
			this.s = s;
			this.e = e;
			this.l = l;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", l=" + l + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.l - o.l;
		}

	}

}
