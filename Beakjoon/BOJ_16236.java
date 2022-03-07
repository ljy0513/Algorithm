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

public class BOJ_16236 {
	static int N,order;
	static int[][] map, visited;
	static int time, eat;
	static Fish babyshark;
	static Queue<Fish> queue;
	static boolean eatfish;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N];
		eatfish = true;//물고기를 하나도 못먹고 돌아왔다면 더 이상 먹을 물고기가 없음
		time = 0;
		eat = 0;
		order =0;
		int cnt = 0; //총 물고기 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 아기상어의 위치와 크기 설정
					babyshark = new Fish(i, j, 2);
				} else if (map[i][j] != 0 && map[i][j] != 9) {
					cnt++;
				}
			}
		}

		if (cnt == 0)
			System.out.println(0); // 잡아 먹을 수 있는 물고기가 하나도 없을 때
		else {
			queue = new LinkedList<>();
			while(eatfish) {
				queue.offer(babyshark);
				if(cnt == 0) break;
				bfs();
				queue.clear();
				cnt--;
			}
			System.out.println(time);
		}

	}// main

	static int[] dx = { -1, 0, 0, 1 };// 상,좌,우,하
	static int[] dy = { 0, -1, 1, 0 };

	static void bfs() {
		eatfish = false;
		visited = new int[N][N];
		visited[babyshark.x][babyshark.y] = 1;
		List<Fish> list = new ArrayList<>();
		int min=Integer.MAX_VALUE; //아기상어와 가장 가까운 물고기와의 거리
		
		while (!queue.isEmpty()) {
			
			Fish fish = queue.poll();
		
			//아기상어보다 작은 물고기를 찾음
			if (fish.size < babyshark.size && fish.size != 0) {			
				if(visited[fish.x][fish.y] > min) {			
					break;
				}else if(visited[fish.x][fish.y] <= min) {
					min = visited[fish.x][fish.y];
					eatfish  = true;
					list.add(fish);
				}
			}
			
			for (int i = 0; i < 4; i++) { // 사방 탐색
				int x = fish.x + dx[i];
				int y = fish.y + dy[i];

				if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] != 0)
					continue; // 경계 밖이거나 이미 방문한 곳
				if (map[x][y] <= babyshark.size) {
					queue.offer(new Fish(x, y, map[x][y]));
					visited[x][y] += visited[fish.x][fish.y]+1;
				}
			}
		}//while
		
		if(eatfish) {
			Collections.sort(list);			
			Fish eating = list.get(0);
			for(int i=0; i<list.size(); i++) {
				//System.out.println("list "+ i + " " + list.get(i));
			}
			eat++;
			if (eat == babyshark.size) {
				eat = 0;
				babyshark.size++;
			}
			map[babyshark.x][babyshark.y] = 0;
			map[eating.x][eating.y] = 9;
			babyshark.x = eating.x; //먹은 물고기 위치로 이동
			babyshark.y = eating.y;	
			time += visited[eating.x][eating.y]-1;
			//System.out.println(eating.toString() + " 시간 : " + time + " 상어크기 : " + babyshark.size);
		}
	}//bfs
}

class Fish implements Comparable<Fish>{
	int x;
	int y;
	int size;

	public Fish(int x, int y, int size) {
		;
		this.x = x;
		this.y = y;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Fish o) {
		return this.x == o.x? this.y - o.y : this.x - o.x;
	}
}