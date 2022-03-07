package Solution;

public class level2_땅따먹기_fail {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		int answer = 0;
		
		for(int i=0; i<4; i++) {
			int step = i;
			int sum = land[0][i];
			//System.out.println(step);
			
			for(int j=1; j<land.length; j++) {
				int max = Integer.MIN_VALUE;
				int tmp = step;
				for(int k = 0; k<4; k++) {
					if(k == tmp) continue;
					if(max < land[j][k]) {
						max = land[j][k];
						step = k;
					}
				}
				//System.out.println(step);
				sum += max;
			}
			answer = Math.max(answer, sum);
			//System.out.println(answer);
			//System.out.println("-----");
		}

		System.out.println(answer);
	}
	//같은 숫자가 있는것을 고려하지 않음
}
