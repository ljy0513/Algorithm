package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static int N;
	static int M;
	static int[][] map;
	static List<pos> Chicken;
	static List<pos> House;
	static List<pos> temp;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Chicken = new LinkedList<>();
		House = new LinkedList<>();
		temp = new LinkedList<>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					House.add(new pos(i, j));
				else if (map[i][j] == 2)
					Chicken.add(new pos(i, j));
			}
		} // data 저장

		Comb(0, 0);
		System.out.println(MIN);

	}// main

	private static void Comb(int cnt, int start) {
		if (cnt == M) {
			int min = Integer.MAX_VALUE;
			int tmp;
			int sum = 0;
			for (int i = 0; i < House.size(); i++) {
				for (int j = 0; j < temp.size(); j++) {// i번째 집에서 m개의 각 치킨집과의 거리중 최소를 고르기
					tmp = Math.abs(House.get(i).x - temp.get(j).x) + Math.abs(House.get(i).y - temp.get(j).y);
					min = Math.min(tmp, min);
				}
				sum += min;
				min = Integer.MAX_VALUE;
				tmp = 0;
			}
			MIN = Math.min(MIN, sum);
		}

		for (int i = start; i < Chicken.size(); i++) {
			temp.add(Chicken.get(i));
			Comb(cnt + 1, i + 1);
			temp.remove(temp.size()-1);//!!!!!!!!!!!!!!!
		}

	}// Comb
}

class pos {
	int x;
	int y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "pos [x=" + x + ", y=" + y + "]";
	}

}
