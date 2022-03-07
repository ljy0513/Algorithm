package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R, C;
	static char[][] map;
	static boolean[][] check;
	static int MAX = Integer.MIN_VALUE;
	static Stack<Character> stack;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new boolean[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}
		
		stack = new Stack<>();
		Alphabet(0, 0);
		
		System.out.println(MAX);
	}
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	static void Alphabet(int x, int y) {
		stack.push(map[x][y]);
		check[x][y] = true;
		visited[map[x][y]-'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int x1= x + dx[i];
			int y1= y + dy[i];
			if (x1>= 0 && x1 < R && y1 >= 0 && y1 < C && !check[x1][y1] && !visited[map[x1][y1]-'A']) {
				Alphabet(x1,y1);
			}
		}
		
		MAX = Math.max(MAX, stack.size());
		visited[map[x][y]-'A'] = false;
		check[x][y] = false;
		stack.pop();
		return;
	}
	
//	static void Alphabet(int x, int y) {
//		stack.push(map[x][y]);
//		check[x][y] = true;
//				
//		for (int i = 0; i < 4; i++) {
//			int x1= x + dx[i];
//			int y1= y + dy[i];
//			if (x1>= 0 && x1 < R && y1 >= 0 && y1 < C && !check[x1][y1]) {
//				if(!stack.contains(map[x1][y1])) Alphabet(x1,y1);
//			}
//		}
//		
//		MAX = Math.max(MAX, stack.size());
//		check[x][y] = false;
//		stack.pop();
//		return;
//	}

}





