package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<int[]>stk = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=1; i<=N; i++) {
			int h =  Integer.parseInt(st.nextToken());
			
			while(!stk.isEmpty()) {
				if(stk.peek()[1] >= h) {//앞 탑의 높이가 더 높기 떄문에 레이저를 맞아서 그 위치를 출력함
					System.out.print(stk.peek()[0] + " ");
					break;
				}
				stk.pop(); //뒤에있는 탑이 더 높다면 앞에 있는 탑은 레이저를 맞지 않기 때문에 고려하지 않아도됨
			}
			
			if(stk.isEmpty()) System.out.print("0 ");
			stk.push(new int[]{i,h}); //위치와 높이를 배열에 같이 저장해줌
		}
		
		
		//5
		//6 9 5 7 4
	}
}
