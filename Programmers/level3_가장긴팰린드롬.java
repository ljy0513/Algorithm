package Solution;

public class level3_가장긴팰린드롬 {

	public static void main(String[] args) {
		String s = "abcde";
		int answer = 1;
		
		for (int i = 1; i < s.length(); i++) { // 1. 글자 수 줄이기
			int start = 0;
			int end = s.length() - i;
			boolean success = true;
			
			while(end <= s.length() - 1) { // 2. 범위 이동
				int S = start;
				int E = end;
				
				// 3. 뒤집어도 똑같은 문자열인지 확인
				while(E-S >= 1) {
					if(s.charAt(S) != s.charAt(E)) {
						success = false;
						break;
					}else {
						success = true;
					}
					S++;
					E--;
				}
				if(success) {
					answer = end - start + 1;
					break;
				}
				
				start++;
				end++;
			}			
			if(success)	break;
		}
		
		System.out.println(answer);
	}

}
