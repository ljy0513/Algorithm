package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L, C;
	static String[] key, res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		res = new String[L];
		key = new String[C];
		String str = in.readLine();
		key = str.split(" ");

		Arrays.sort(key);
		Comb(0,0);
	}

	static void Comb(int cnt, int start) {
		if (cnt == L) {
			if(check()) {
				for (int i = 0; i < L; i++) {
					System.out.print(res[i]);
				}
				System.out.println();
				return;
			}else return;
			
		}

		for (int i = start; i < C; i++) {
			res[cnt] = key[i];
			Comb(cnt + 1, i + 1);
		}
	}

	static boolean check() {
		int vow=0,con=0;	
		for (int i = 0; i < L; i++) {
			if (res[i].equals("a") || res[i].equals("e") || res[i].equals("i") || res[i].equals("o")
					|| res[i].equals("u")) {
				vow++;
			}else con++;
		}
		if(vow >= 1 && con >=2 )return true;
		return false;
	}
}
