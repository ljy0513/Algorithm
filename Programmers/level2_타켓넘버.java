package Solution;

public class level2_타켓넘버 {
	static int[] numbers;
	static int target;
	static int res;
	
	public static void main(String[] args) {
		numbers = new int[] {1,1,1,1,1};
		target = 3;
		res = 0;
		dfs(0,0,0);
		System.out.println(res);
	}
	
	static void dfs(int cnt, int start, int tmp) {
		if(cnt == numbers.length) {
			if(tmp == target) res++;
			return;
		}
		
		for(int i=start; i<numbers.length; i++) {
			dfs(cnt+1, i+1, tmp+numbers[i]);
			dfs(cnt+1, i+1, tmp-numbers[i]);
		}
	}
}
