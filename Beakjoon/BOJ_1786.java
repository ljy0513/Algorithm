package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray(); //찾을 문자열
		
		int tLength = text.length;
		int pLength = pattern.length;
		

		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){
	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j-1];
	        }
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) {
					cnt++;
					list.add((i+2)-pLength); //1부터 시작
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		
		sb.append(cnt).append("\n");
		if(cnt != 0) {
			for(int i=0; i<list.size(); i++)
				sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);

	}
}
