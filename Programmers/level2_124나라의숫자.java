package Solution;

public class level2_124나라의숫자 {

	public static void main(String[] args) {
		int n = 39;
		String res = "";
		
		int remain = 0;
		
		while(n != 0) {		
			
			remain = n % 3;
			n /= 3;
			
			if(remain == 0) n--;
			
			if(remain == 1) res = '1' + res;
			else if(remain == 2) res = '2' + res;
			else res = '4' + res;		
		}
		
		System.out.println(res);
	}

}
