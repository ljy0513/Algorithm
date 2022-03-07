package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992 {

	static int N;
	static char[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		tree = new char[N][N];

		for (int i = 0; i < N; i++) {
			tree[i] = in.readLine().toCharArray();
		}
		QuadTree(0, 0, N);
	}

	static void QuadTree(int x, int y, int size) {
		boolean check = Check(x, y, size);
		if (check) {
			System.out.print(tree[x][y]);
			return;
		} else
			System.out.print("(");

		int changeSize = size / 2;

		QuadTree(x, y, changeSize); // 왼쪽 위
		QuadTree(x, y + changeSize, changeSize); // 오른쪽 위
		QuadTree(x + changeSize, y, changeSize); // 왼쪽 아래
		QuadTree(x + changeSize, y + changeSize, changeSize); // 오른쪽 아래
		System.out.print(")");

	}

	static boolean Check(int x, int y, int size) {
		int check = tree[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (check != tree[i][j])
					return false;
			}
		}
		return true;
	}
}
