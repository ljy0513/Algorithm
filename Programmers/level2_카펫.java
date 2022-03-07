package Solution;

import java.util.Arrays;

public class level2_카펫 {
	static int[] answer = new int[2];
	
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		
		carpet(brown,yellow);
		
		System.out.println(Arrays.toString(answer));
	}
	
	static void carpet(int bro,int yel) {
		int total = bro + yel; //갈색과 노란색의 합이 전체 카펫의 크기
		int row=0, col =0;
		
		for(int i = 1; i<=total; i++) {
			// 1. 카페의 크기가 될 수 있는 가로 세로 구하기 (전체 개수의 약수 이용)
			if(total % i == 0) {
				col = i;
				row = total / i;
				if(col > row) break;
			}
			
			// 2. 테두리의 개수가 brown의 개수와 같으면 끝
			int border = 2 * row + 2 * col - 4;
			if(border == bro) {
				answer[0] = row;
				answer[1] = col;
				break;
			}
		}
	}
	
}
