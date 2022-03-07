package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	static int N,n;
	static int r;
	static int c;
	static int cnt;
	static int[] dx = {0,0,1,1};
	static int[] dy = {0,1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = (int)Math.pow(2,N);
		
		Z(n,0,0);
	}//main
	
	static void Z (int len,int r1, int c1) {
		if(len == 2) {
			for (int i = 0; i < 4; i++) {
				int x=r1+dx[i];
				int y=c1+dy[i];
				if(r==x && c==y) {
					System.out.println(cnt);
					return;
				}
				cnt++;
			}
			return;
		}
		
		if(r <r1 + len/2 && c >= c1+len/2) {//2
			cnt += Math.pow(len/2, 2);
			c1 += len/2;
		}else if(r >= r1 + len/2 && c < c1 + len/2) {//3
			cnt += Math.pow(len/2, 2) *2;
			r1 += len/2;
		}else if(r >= r1 + len/2&& c >= c1+ len/2){//4
			cnt += Math.pow(len/2, 2) *3;
			c1 += len/2;
			r1 += len/2;		
		}
		Z(len/2,r1,c1);
	}	
}

