package Solution;

public class level2_땅따먹기 {

	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		int[][] dp = new int[land.length][4];
		dp[0] = land[0];
		int answer = 0;
		
		for(int i=1; i<land.length; i++) {
			land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2], land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2], land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1], land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1], land[i-1][2]));
		}
		//전의 행에서 현재 행에서 선택된 열을 제외하고 나머지중에 가장큰 수와 자기 자신을 더함
		//ex) 현재 열이 1번이라면 그 전에 선택된 열은 2,3,4중 하나면 됨으로 2,3,4중 가장 큰 수를 택해서 현재열과 더함
		
		for(int i=0; i<4; i++) {
			answer = Math.max(land[land.length-1][i], answer);
		}
		System.out.println(answer);

	}

}
