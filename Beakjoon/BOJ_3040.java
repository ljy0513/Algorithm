package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BOJ_3040 {
	
	static int[] dwarfs;
	static int[] realDwarfs;	
	static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		dwarfs = new int[9];
		for(int i=0; i<9; i++) dwarfs[i] = Integer.parseInt(in.readLine());
		
		realDwarfs = new int[7];
		tmp = new int[7];
		Comb(0,0);
		for(int i=0; i<7; i++) {
			System.out.println(realDwarfs[i]);
		}
		
	}//main
	
	private static void Comb(int cnt, int start) {	
		if(cnt == 7) {
			if(IntStream.of(tmp).sum() == 100) realDwarfs = tmp.clone();
			return;
		}
		for(int i=start; i<9; i++) {
			tmp[cnt] = dwarfs[i];
			Comb(cnt+1,i+1);
		}
	}

}
