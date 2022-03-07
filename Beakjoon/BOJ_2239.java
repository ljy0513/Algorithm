package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
	static int[][] sudoku;
	static List<POS> list;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		list = new ArrayList<>();
		flag = false;
		
		for(int i=0; i<9; i++) {
			char[] ch = in.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = ch[j] - '0';
				if(sudoku[i][j] == 0) list.add(new POS(i,j));
			}
		}

		dfs(0);

	}
	
	static void dfs(int cnt) {
		if(cnt == list.size() && !flag) {
			print();
			flag = true;
			return;
			//System.exit(0);
		}
		
		POS pos = list.get(cnt);
		for(int i=1; i<10; i++) {
			if(flag) break;
			if(getNum(i, list.get(cnt))) {
				sudoku[pos.x][pos.y] = i;
				dfs(cnt+1);			
				sudoku[pos.x][pos.y] = 0;
			}
		}
	}
	
	static boolean getNum(int n, POS pos) {
		//행열
		for(int i=0; i<9; i++) {
			if(n == sudoku[pos.x][i]) return false;
			if(n == sudoku[i][pos.y]) return false;
		}
			
		//pos가 속해있는 구역
		int x = pos.x/3*3;
		int y = pos.y/3*3;
		
		for(int i = x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				if(n == sudoku[i][j]) return false;
			}
		}
			
		return true;
	}
	
	static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class POS {
		int x,y;
		
		public POS (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
