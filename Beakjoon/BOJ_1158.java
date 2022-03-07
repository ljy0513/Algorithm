package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) queue.offer(i);
		
		sb.append("<");
	
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) queue.offer(queue.poll());
			sb.append(queue.poll());
			if(queue.isEmpty()) break;
			sb.append(", ");
		}
		
		sb.append(">");
			
		System.out.println(sb);
	}
}
