package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("C:/SSAFY/workspace/2_java/java05_Practice/src/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int cnt = Integer.parseInt(in.readLine()); //스위치 개수		
		int [] sw = new int[cnt]; //스위치 전원 여부
		StringTokenizer st = new StringTokenizer(in.readLine());
		int idx =0;
		while(st.hasMoreTokens()){
			String str = st.nextToken();
			sw[idx++] = Integer.parseInt(str);
		}
		
		int std = Integer.parseInt(in.readLine()); //학생수		
		for(int i =0; i<std; i++) {
			StringTokenizer str = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(str.nextToken()); //성별
			int sn = Integer.parseInt(str.nextToken()); //전구 위치

			if(sex == 1) Boy(sn,sw,cnt);
			else if(sex == 2) Girl(sn,sw,cnt);
		}

		for(int i=0; i<sw.length; i++) {
			if(i == sw.length-1) {
				System.out.println(sw[i]);
				break;
			}
			System.out.printf("%d ",sw[i]);
			if(i%20 == 19) System.out.println(); //20개 이상일 때 줄바꿈
		}

	}
	
	private static int[] Boy(int sn, int [] sw, int cnt) {
		if(sn <= cnt/2) { //배수가 있다면 
			for(int i=0; i<cnt; i+=sn) {
				if(sn+i-1 >= cnt) break;
				sw[sn+i-1] = sw[sn+i-1] == 0 ? 1 : 0;
			}
		}else { //배수가 없다면
			sw[sn-1] = sw[sn-1] == 0 ? 1 : 0;
		}
		return sw;
	}
	
	private static int[] Girl(int sn, int [] sw, int cnt) {
		sw[sn-1] =	sw[sn-1] == 0? 1 : 0;
		
		for(int i=1; i<cnt/2; i++) {
			if(sn-1-i < 0 || sn-1+i >= cnt) break;
			if(sw[sn-1-i] == sw[sn-1+i]) {
				//sw[sn-1-i] = sw[sn-1-i] ==0 ? 1 : 0;
				//sw[sn-1+i] = sw[sn-1+i] ==0 ? 1 : 0;
				sw[sn-1-i] = sw[sn-1-i] ^ 1; //비트연산자 사용		 
				sw[sn-1+i] = sw[sn-1+i] ^ 1;
			}else break;
		}
		return sw;
	}
}
