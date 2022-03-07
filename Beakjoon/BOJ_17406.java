package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_17406 {
	static int[][] arr;
	static int [][] copy;
	static int N;
	static int M;
	static int K;
	static int[][] oper; //연산 저장
	static int MIN = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static int[] operOrder; //연산 순열 저장
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		oper = new int[K][3];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0; j<3; j++) {
				oper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		copy = new int [N][M];
		
		isSelected = new boolean[K];
		operOrder = new int [K];
		
		permutation(0);
		System.out.println(MIN);
	}//main
	
	static void permutation (int cnt) {
		if(cnt == K) {//순열 하나가 완성됐을 때
			for(int i=0; i<N; i++) { //copy배열 원상태로 복구
				for(int j=0; j<M; j++) {
					copy[i][j] = arr[i][j];
				}
			}
			
			for(int i=0; i<K; i++) {
				int tmp = operOrder[i];
				position(oper[tmp][0], oper[tmp][1], oper[tmp][2]);
			}
			
			if(MIN > minimum()) MIN = minimum();
			
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(isSelected[i]) continue; //사용중인 수면 다음 수

			operOrder[cnt] = i;
			isSelected[i] = true; //수를 선택해서 뽑았으므로 사용중 표시
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}//연산 순서 순열
	
	static void position (int r, int c, int s) {		
		int rs = r-s-1;
		int re = r+s-1;
		int cs = c-s-1;
		int ce = c+s-1;		
		rightRotate(rs, re, cs, ce);
	}//각 꼭짓점 위치 구하기
	
	static void rightRotate (int rs, int re, int cs, int ce) {
		if(rs >= re || cs >= ce) return;
		
		int tmp = copy[rs][cs];
		for(int i=rs; i<re; i++) copy[i][cs] = copy[i+1][cs];
		for(int i=cs; i<ce; i++) copy[re][i] = copy[re][i+1];
		for(int i=re; i>rs; i--) copy[i][ce] = copy[i-1][ce];
		for(int i=ce; i>cs; i--) copy[rs][i] = copy[rs][i-1];		
		copy[rs][cs+1] = tmp;
		
		rightRotate(rs+1,re-1,cs+1,ce-1);	
	}//회전 함수
	
	static int  minimum () {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {			
			int tmp = IntStream.of(copy[i]).sum();
			if(min > tmp) min = tmp;
		}
		return min;
	}//배열 값 구하기
	
}
